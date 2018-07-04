package com.encore.j0525.ref;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Service extends Thread{
   //Service == ���� Ŭ���̾�Ʈ �Ѹ�!!	
	
   Room myRoom;//Ŭ���̾�Ʈ�� ������ ��ȭ��	
	
   //���ϰ��� ����¼���
   BufferedReader in;
   OutputStream out;
   
   Vector<Service> allV;//��� �����(���ǻ���� + ��ȭ������)
   Vector<Service> waitV;//���� �����	   
   Vector<Room> roomV;//������ ��ȭ�� Room-vs(Vector) : ��ȭ������
   
   Socket s;
   
   String nickName;
   
   public Service(Socket s, Server server) { 
	   allV=server.allV;
	   waitV=server.waitV;
	   roomV=server.roomV;
	   
	   this.s = s;
	   
	   try {		
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		out = s.getOutputStream();
		
		start();
	  } catch (IOException e) {
		e.printStackTrace();
	 }
   }//������
   
   @Override
   public void run() {
	 try {
		
		while(true){
		    String msg = in.readLine();//Ŭ���̾�Ʈ�� ��� �޽����� �ޱ�
		    
		   if(msg == null) return; //���������� ����
		   
		   if(msg.trim().length() > 0){  
		     System.out.println("from Client: "+ msg +":"+
		                  s.getInetAddress().getHostAddress());
		     //�������� ��Ȳ�� �����!!
		     
            String msgs[]=msg.split("\\|");
            String protocol = msgs[0]; 
            
		    switch(protocol){
		      case "100": //���� ����
		            allV.add(this);//��ü����ڿ� ���
		            waitV.add(this);//���ǻ���ڿ� ���  
		            
		          break;
		          
		      case "150": //��ȭ�� �Է�
		    	          nickName=msgs[1]; 
		    	          
		    	    //���� ��ȭ�� �Է������� ������ ������ ���
		    	    messageWait("160|"+ getRoomInfo());
		    	    messageWait("180|"+ getWaitInwon());
		    	          
		                  break;
		      case "160": //�游��� (��ȭ�� ����)
		    	  myRoom = new Room();
		    	    myRoom.title =msgs[1];//������
		    	    myRoom.count = 1;
		    	    myRoom.boss = nickName;
		    	          
		    	          roomV.add(myRoom);
		    	          
		    	          //����----> ��ȭ�� �̵�!!
		    	          waitV.remove(this);
		    	          myRoom.userV.add(this);
		    	          
		    	          messageRoom("200|"+nickName);//���ο����� ���� �˸�
		    	          
		    	          //���� ����ڵ鿡�� �������� ���
		    	          //��) ��ȭ���:JavaLove
		    	          //-----> roomInfo(JList) :  JavaLove--1		    	          
		    	          messageWait("160|"+ getRoomInfo());
		    	          messageWait("180|"+ getWaitInwon());
		    	          break;
		    	
		      case "170": //(���ǿ���) ��ȭ�� �ο�����
		    	          messageTo("170|"+getRoomInwon(msgs[1]));
		    	          break;
		    	          
		      case "175": //(��ȭ�濡��) ��ȭ�� �ο�����
		    	          messageRoom("175|"+getRoomInwon());
		    	          break;
		    	          
		      case "200": //����� (��ȭ�� ����) ----> msgs[] = {"200","�ڹٹ�"}
		    	         for(int i=0; i<roomV.size(); i++){//���̸� ã��!!
		    	        	 Room r = roomV.get(i);
		    	        	 if(r.title.equals(msgs[1])){//��ġ�ϴ� �� ã��!!		    	        	
		    	        		 myRoom = r;
		    	        		 myRoom.count++;//�ο��� 1����
		    	        		 break;
		    	        	 }
		    	         }//for
		    	         
		    	         //����----> ��ȭ�� �̵�!!
		    	          waitV.remove(this);
		    	          myRoom.userV.add(this);	
		    	          
		    	         messageRoom("200|"+nickName);//���ο����� ���� �˸�  
		    	          
		    	         //�� ���� title����
		    	         messageTo("202|"+ myRoom.title);
		    	         
		    	         messageWait("160|"+ getRoomInfo());
		    	         messageWait("180|"+ getWaitInwon());
		    	         break;
		    	  
		      case "300": //�޽���		    	        
		    	          messageRoom("300|["+nickName +"]�� "+msgs[1]);		    	         
		    	          //Ŭ���̾�Ʈ���� �޽��� ������
		    	          break;
		   
		      case "400": //��ȭ�� ����
		    	          myRoom.count--;//�ο��� ����
		    	  
		    	          messageRoom("400|"+nickName);//���ο��鿡�� ���� �˸�!!
		    	          
		    	          //��ȭ��----> ���� �̵�!!
		    	          myRoom.userV.remove(this);	
		    	          waitV.add(this);
		    	          
		    	          //��ȭ�� ������ ���ο� �ٽ����
		    	          messageRoom("175|"+getRoomInwon());
		    	          
		    	          //���ǿ� ������ �ٽ����
		    	          messageWait("160|"+ getRoomInfo());
		    	          
		    	          break;
		    	  
		    }//���� switch
		  }//if
		}//while
	 }catch (IOException e) {
		 System.out.println("��");
		e.printStackTrace();
	}
   }//run
   
   public String getRoomInfo(){
	  String str="";
	  for(int i=0; i<roomV.size(); i++){
		  //"�ڹٹ�--1,����Ŭ��--1,JDBC��--1"
		 Room r= roomV.get(i);
		 str += r.title+"--"+r.count;
		 if(i<roomV.size()-1)str += ",";
	  }
	  return str;
   }//getRoomInfo
   
   public String getRoomInwon(){//�������� �ο�����
	   String str="";	   
	   for(int i=0; i<myRoom.userV.size(); i++){
		   //"�浿,����,�ֿ�"
		    Service ser= myRoom.userV.get(i);
			  str += ser.nickName;
		     if(i<myRoom.userV.size()-1)str += ",";
	   }
	  return str;
   }//getRoomInwon
   
   public String getRoomInwon(String title){//������ Ŭ���� ���� �ο�����
	   String str="";
	   
	   for(int i=0; i<roomV.size(); i++){
		   //"�浿,����,�ֿ�"
		   Room room = roomV.get(i);
		   if(room.title.equals(title)){
			   for(int j=0; j<room.userV.size(); j++){
				   Service ser= room.userV.get(j);
				   str += ser.nickName;
				   if(j<room.userV.size()-1)str += ",";			   
			   }
			   break;
		   }
	   }
	   return str;
   }//getRoomInwon
   
   public String getWaitInwon(){
	   String str="";
	   for(int i=0; i<waitV.size(); i++){
		   //"�浿,����,�ֿ�"
		   Service ser= waitV.get(i);
		   str += ser.nickName;
		   if(i<waitV.size()-1)str += ",";
	   }
	   return str;
   }//getWaitInwon
   
   public void messageAll(String msg){//��ü�����
	   //���ӵ� ��� Ŭ���̾�Ʈ(����+��ȭ��)���� �޽��� ����	   
	   for(int i=0; i<allV.size(); i++){//���� �ε���
		  Service service = allV.get(i); //������ Ŭ���̾�Ʈ ������
		  try {
			service.messageTo(msg);
		} catch (IOException e) {
			//�����߻� ---> Ŭ���̾�Ʈ ���� ����!!
			allV.remove(i--); //���� ���� Ŭ���̾�Ʈ�� ���Ϳ��� ����!!
		    System.out.println("Ŭ���̾�Ʈ ���� ����!!");
		}
	   }
   }//messageAll
   
   public void messageWait(String msg){//���� �����	   
	   for(int i=0; i<waitV.size(); i++){//���� �ε���
		   Service service = waitV.get(i); //������ Ŭ���̾�Ʈ ������
		   try {
			   service.messageTo(msg);
		   } catch (IOException e) {
			   //�����߻� ---> Ŭ���̾�Ʈ ���� ����!!
			   waitV.remove(i--); //���� ���� Ŭ���̾�Ʈ�� ���Ϳ��� ����!!
			   System.out.println("Ŭ���̾�Ʈ ���� ����!!");
		   }
	   }
   }//messageWait
   
   public void messageRoom(String msg){//��ȭ������
//	   System.out.println("msg="+msg);
//	   System.out.println("myRoom="+myRoom);
//	   System.out.println("myRoom ����="+ myRoom.userV.size());
	   for(int i=0; i< myRoom.userV.size(); i++){//���� �ε���
		   Service service = myRoom.userV.get(i); //������ Ŭ���̾�Ʈ ������
		   try {
			   service.messageTo(msg);
		   } catch (IOException e) {
			   //�����߻� ---> Ŭ���̾�Ʈ ���� ����!!
			   myRoom.userV.remove(i--); //���� ���� Ŭ���̾�Ʈ�� ���Ϳ��� ����!!
			   System.out.println("Ŭ���̾�Ʈ ���� ����!!");
		   }
	   }
   }//messageAll
   
   public void messageTo(String msg) throws IOException{
	   //Ư�� Ŭ���̾�Ʈ���� �޽��� ���� (���� ����--->Ŭ���̾�Ʈ �޽��� ����)
	   out.write(  (msg+"\n").getBytes()   );
   }
	
}



