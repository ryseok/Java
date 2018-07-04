package com.encore.j0524;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
   public static void main(String[] args) {
	   String host = "naver.com";//"playdata.io";//
	   //호스트: 서비스를 제공하는 단말(PC)
	   //naver.com : 도메인 (ip주소에 적용하는 문자)
	   
	try {
		 InetAddress ia = InetAddress.getByName(host);
		 
		 String name = ia.getHostName();//도메인명
		 String addr = ia.getHostAddress();//ip주소
		 
		 System.out.println("호스트명: "+ name);
		 System.out.println("호스트주소: "+ addr);
		 
		 System.out.println("===========================");
		 //한 도메인에 매핑된 모든 서버ip 얻어오기
		 InetAddress ias[] = InetAddress.getAllByName(host);
		 System.out.println("# ["+host+"]의 서버ip");
		 for (int i = 0; i < ias.length; i++) {
			System.out.println(" "+ ias[i].getHostAddress());
		 }
		 
		 
	} catch (UnknownHostException e) {
		e.printStackTrace();
	}
   }//main
}
