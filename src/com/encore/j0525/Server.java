package com.encore.j0525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server implements Runnable{
	//�ܺ�Ŭ����: ������ ���� ���Ӽ���(���Ӵ��), ������ Ŭ���̾�Ʈ�� ����(Vector)
	
	public static final String NICKNAME= "100"; 
	
	
	ServerSocket ss;
	Vector<Service> v;//������ Ŭ���̾�Ʈ ����
	
	
		
    public Server() {
       System.out.println("Server Start.....");
       v = new Vector<>();
       
	 try {
		   ss = new ServerSocket(3000);//��1.�������ϰ�ü����      
		   new Thread(this).start();
	    } catch (IOException e) {
		    e.printStackTrace();
	      }
	   
	}//������	    
    
    public void run(){//���� Ŭ���̾�Ʈ ������ ���� waitClientConnect
    	try {
			while(true) { 
				Socket s = ss.accept();//��2. Ŭ���̾�Ʈ ���Ӵ��
				//Service serv = new Service(s);     v.add(serv);
				v.add(new Service(s));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }//�ܺ� run
    
   //-------------------------------------------------------------
    class Service extends Thread{//����Ŭ����: ������ ���� ����� ����
    //�� Service��ü �Ѱ� == Ŭ���̾�Ʈ �Ѱ�!!	
    	
      BufferedReader in;//���� �б�
      OutputStream out;//���� ����
      
      String nickName;//��ȭ������
      
      public Service(Socket s) {
    	try {
			//�� 4.���� ����� ��ü ����
			  in = new BufferedReader(new InputStreamReader(s.getInputStream())); 
			  out = s.getOutputStream();		  
			  start();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	  }//������
      
      public void run() {//Ŭ���̾�Ʈ�� ������ �����޽����� �б� ���ؼ�
    	try {
    		//nickName = in.readLine();//Ŭ���̾�Ʈ�� ������ ��ȭ��!!
    		
			while(true) {
			   String msg = in.readLine();//��6. Ŭ���̾�Ʈ�� TF�� ���� ������ �޽��� �б�
			   System.out.println("from Ŭ���̾�Ʈ ==> "+ msg);
			   
			   //msg="100|�浿��" �Ǵ� "200|�ȳ��ϼ���?"  �Ǵ� "300|������½"
			   String arr[]= msg.split("\\|");//arr[]={"100","�浿��"}
			   switch(arr[0]) {
			      case NICKNAME://��ȭ��
			    	         nickName = arr[1]; 
			    	         break;
			      case "200"://��ȭ����
			    	     messageAll("["+nickName+"]��"+ arr[1]);//msg);
			    	         break; 
			      case "300"://�����ȭ��
			    	         nickName = arr[1];
			   }//
			   
			}
		} catch (IOException e) {
			//e.printStackTrace();
			System.err.println("Ŭ���̾�Ʈ�� ���� ����!!");
		}
      }//���� run
      
      public void messageTo(String msg) throws IOException{//Ư�� Ŭ���̾�Ʈ���� �޽��� ������
    	  
			out.write( ( msg+"\n").getBytes()); //��7. ���� Ŭ���̾�Ʈ���� �޽��� ����
		
      }
      
      public void messageAll(String msg) {//������ ��� Ŭ���̾�Ʈ���� �޽��� ������
    	  for(int i=0; i<v.size(); i++) { //��ü Ŭ���̾�Ʈ(Service)
    		  //i=0�浿   1����   2�ֿ�
    		 System.out.println("��");
    		 Service  ser = v.get(i);
    		 try {
				ser.messageTo(msg);
			} catch (IOException e) {				
				//e.printStackTrace();
				//�����߻� -----> Ŭ���̾�Ʈ ���� ����!!
				v.remove(i--);  //���� ���� Ŭ���̾�Ʈ�� ���Ϳ��� ����!!
				System.out.println("Ŭ���̾�Ʈ ���� ���� ==> ���ͻ���!!");
			}
    	  }//for
      }//messageAll
      
      
      
    }//ServiceŬ����
   
	public static void main(String[] args) {
	    new Server();	
	}
}
