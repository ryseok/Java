package com.encore.j0525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {//소켓서비스 요청
	
	public static void main(String[] args) throws IOException{
	   //Socket s = new Socket(접속할 서버의 정보);
	   //Socket s = new Socket(String host,int port); host:서버ip, port:서비스 구분 번호
	   Socket s = new Socket("192.168.0.22", 3000);//★3. 서버접속 요청
	   //자기자신의 PC가 호스트인 경우 ===> "localhost" 또는 "127.0.0.1"
	   System.out.println("서버접속 성공!!");
	   
 	   //★4. 입출력 객체생성(in,out)
		 OutputStream out = s.getOutputStream();//상대방에게 메시지를 보내겠다.
		 InputStream is = s.getInputStream();//상대방이 보낸 메시지를 읽겠다.
		 BufferedReader in = new BufferedReader(new InputStreamReader(is));
	   
	   //★6. 메시지 읽기
       String msg = in.readLine();
       System.out.println("from Server ==> "+ msg);
	          
       //★7. 메시지보내기(write)
       String toMsg="평양낸면\n";
       out.write(toMsg.getBytes());//클라이언트---->서버
       
	}//main

}//class end



