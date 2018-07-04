package com.encore.j0525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server implements Runnable{
	//외부클래스: 소켓을 통한 접속서비스(접속대기), 접속한 클라이언트를 관리(Vector)
	
	public static final String NICKNAME= "100"; 
	
	
	ServerSocket ss;
	Vector<Service> v;//접속한 클라이언트 관리
	
	
		
    public Server() {
       System.out.println("Server Start.....");
       v = new Vector<>();
       
	 try {
		   ss = new ServerSocket(3000);//★1.서버소켓객체생성      
		   new Thread(this).start();
	    } catch (IOException e) {
		    e.printStackTrace();
	      }
	   
	}//생성자	    
    
    public void run(){//여러 클라이언트 접속을 위해 waitClientConnect
    	try {
			while(true) { 
				Socket s = ss.accept();//★2. 클라이언트 접속대기
				//Service serv = new Service(s);     v.add(serv);
				v.add(new Service(s));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }//외부 run
    
   //-------------------------------------------------------------
    class Service extends Thread{//내부클래스: 소켓을 통한 입출력 서비스
    //※ Service객체 한개 == 클라이언트 한개!!	
    	
      BufferedReader in;//소켓 읽기
      OutputStream out;//소켓 쓰기
      
      String nickName;//대화명저장
      
      public Service(Socket s) {
    	try {
			//★ 4.소켓 입출력 객체 생성
			  in = new BufferedReader(new InputStreamReader(s.getInputStream())); 
			  out = s.getOutputStream();		  
			  start();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	  }//생성자
      
      public void run() {//클라이언트가 보내는 여러메시지를 읽기 위해서
    	try {
    		//nickName = in.readLine();//클라이언트가 전달한 대화명!!
    		
			while(true) {
			   String msg = in.readLine();//★6. 클라이언트가 TF를 통해 전달한 메시지 읽기
			   System.out.println("from 클라이언트 ==> "+ msg);
			   
			   //msg="100|길동이" 또는 "200|안녕하세요?"  또는 "300|동에번쩍"
			   String arr[]= msg.split("\\|");//arr[]={"100","길동이"}
			   switch(arr[0]) {
			      case NICKNAME://대화명
			    	         nickName = arr[1]; 
			    	         break;
			      case "200"://대화내용
			    	     messageAll("["+nickName+"]▶"+ arr[1]);//msg);
			    	         break; 
			      case "300"://변경대화명
			    	         nickName = arr[1];
			   }//
			   
			}
		} catch (IOException e) {
			//e.printStackTrace();
			System.err.println("클라이언트가 접속 끊음!!");
		}
      }//내부 run
      
      public void messageTo(String msg) throws IOException{//특정 클라이언트에게 메시지 보내기
    	  
			out.write( ( msg+"\n").getBytes()); //★7. 실제 클라이언트에게 메시지 전달
		
      }
      
      public void messageAll(String msg) {//접속한 모든 클라이언트에게 메시지 보내기
    	  for(int i=0; i<v.size(); i++) { //전체 클라이언트(Service)
    		  //i=0길동   1라임   2주원
    		 System.out.println("★");
    		 Service  ser = v.get(i);
    		 try {
				ser.messageTo(msg);
			} catch (IOException e) {				
				//e.printStackTrace();
				//에러발생 -----> 클라이언트 접속 끊음!!
				v.remove(i--);  //접속 끊긴 클라이언트를 벡터에서 삭제!!
				System.out.println("클라이언트 접속 끊음 ==> 벡터삭제!!");
			}
    	  }//for
      }//messageAll
      
      
      
    }//Service클래스
   
	public static void main(String[] args) {
	    new Server();	
	}
}
