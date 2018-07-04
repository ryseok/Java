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
	
  //���������� ����	
  public static void main(String[] args) throws IOException{
	//ServerSocket ss = new ServerSocket(int port);
	//ServerSocket: ���� ���񽺸� �ϴ� ������ü
	ServerSocket ss = new ServerSocket(3000);//��1.�������� ��ü����
	//���������� �����ϴ� JVM�� ���� ip�ּҿ� ��õ� port��ȣ�� ���ϼ��񽺸� ������ �غ�
	System.out.println("���� ����(���Ӵ����).....");
	
	while(true) {
	 Socket s = ss.accept();//��2. Ŭ���̾�Ʈ ���� ��� �޼ҵ�
	 InetAddress ia = s.getInetAddress();
	 System.out.println("Ŭ���̾�Ʈ ����!! ["+ ia.getHostAddress()+"]");//"�������Ͼȳ�~!!");
	 
	 //��4. ����� ��ü����(in,out)
	 OutputStream out = s.getOutputStream();//���濡�� �޽����� �����ڴ�.
	 InputStream is = s.getInputStream();//������ ���� �޽����� �аڴ�.
	 BufferedReader in = new BufferedReader(new InputStreamReader(is));
	 
	 //��5. �޽��� ������
	 String msg="���� �� �Դ�?\n";
	 //out.write(byte[]b);
	 out.write(msg.getBytes());
	 
	 //��8. �޽����б�(read)
	 String fromMsg = in.readLine();
	 System.out.println("from Client ==> "+ fromMsg);
	 
	}//while
	
  }//main
}//class end









