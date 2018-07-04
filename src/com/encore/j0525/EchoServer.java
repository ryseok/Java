package com.encore.j0525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
  //서버소켓을 구성	
  public static void main(String[] args) throws IOException{
	//ServerSocket ss = new ServerSocket(int port);
	//ServerSocket: 소켓 서비스를 하는 서버객체
	ServerSocket ss = new ServerSocket(3000);//★1.서버소켓 객체생성
	//서버소켓을 실행하는 JVM이 갖는 ip주소와 명시된 port번호로 소켓서비스를 시작할 준비
	System.out.println("서버 시작(접속대기중).....");
	
	while(true) {
	 Socket s = ss.accept();//★2. 클라이언트 접속 대기 메소드
	 InetAddress ia = s.getInetAddress();
	 System.out.println("클라이언트 접속!! ["+ ia.getHostAddress()+"]");//"서버소켓안녕~!!");
	 
	 //★4. 입출력 객체생성(in,out)
	 OutputStream out = s.getOutputStream();//상대방에게 메시지를 보내겠다.
	 InputStream is = s.getInputStream();//상대방이 보낸 메시지를 읽겠다.
	 BufferedReader in = new BufferedReader(new InputStreamReader(is));
	 
	 //★5. 메시지 보내기
	 String msg="점심 뭐 먹니?\n";
	 //out.write(byte[]b);
	 out.write(msg.getBytes());
	 
	 //★8. 메시지읽기(read)
	 String fromMsg = in.readLine();
	 System.out.println("from Client ==> "+ fromMsg);
	 
	}//while
	
  }//main
}//class end









