package com.encore.j0524;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
   public static void main(String[] args) {
	   String host = "naver.com";//"playdata.io";//
	   //ȣ��Ʈ: ���񽺸� �����ϴ� �ܸ�(PC)
	   //naver.com : ������ (ip�ּҿ� �����ϴ� ����)
	   
	try {
		 InetAddress ia = InetAddress.getByName(host);
		 
		 String name = ia.getHostName();//�����θ�
		 String addr = ia.getHostAddress();//ip�ּ�
		 
		 System.out.println("ȣ��Ʈ��: "+ name);
		 System.out.println("ȣ��Ʈ�ּ�: "+ addr);
		 
		 System.out.println("===========================");
		 //�� �����ο� ���ε� ��� ����ip ������
		 InetAddress ias[] = InetAddress.getAllByName(host);
		 System.out.println("# ["+host+"]�� ����ip");
		 for (int i = 0; i < ias.length; i++) {
			System.out.println(" "+ ias[i].getHostAddress());
		 }
		 
		 
	} catch (UnknownHostException e) {
		e.printStackTrace();
	}
   }//main
}
