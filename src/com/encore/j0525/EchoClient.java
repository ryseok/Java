package com.encore.j0525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {//���ϼ��� ��û
	
	public static void main(String[] args) throws IOException{
	   //Socket s = new Socket(������ ������ ����);
	   //Socket s = new Socket(String host,int port); host:����ip, port:���� ���� ��ȣ
	   Socket s = new Socket("192.168.0.22", 3000);//��3. �������� ��û
	   //�ڱ��ڽ��� PC�� ȣ��Ʈ�� ��� ===> "localhost" �Ǵ� "127.0.0.1"
	   System.out.println("�������� ����!!");
	   
 	   //��4. ����� ��ü����(in,out)
		 OutputStream out = s.getOutputStream();//���濡�� �޽����� �����ڴ�.
		 InputStream is = s.getInputStream();//������ ���� �޽����� �аڴ�.
		 BufferedReader in = new BufferedReader(new InputStreamReader(is));
	   
	   //��6. �޽��� �б�
       String msg = in.readLine();
       System.out.println("from Server ==> "+ msg);
	          
       //��7. �޽���������(write)
       String toMsg="��糽��\n";
       out.write(toMsg.getBytes());//Ŭ���̾�Ʈ---->����
       
	}//main

}//class end



