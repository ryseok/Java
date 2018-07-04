package com.encore.j0524;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
   public static void main(String[] args) {
	   try {
		URL url = new URL("https://www.naver.com/index.html");
		   
		   System.out.println("프로토콜: "+ url.getProtocol());
		   System.out.println("호스트: "+ url.getHost());
		   System.out.println("서비스파일명: "+ url.getFile());
		   
		   InputStream is =url.openStream();
	   //BufferedReader br = new BufferedReader(new InputStreamReader(InputStream));
	   //InputStreamReader클래스 ----> 바이트스트림을 문자스트림으로 변환하는 기능  
	   //InputStreamReader(InputStream is)  
	   //InputStreamReader(InputStream is,String charsetName)  
	    BufferedReader in = new BufferedReader
	    		              (new InputStreamReader(is,"UTF-8"));//웹소스 얻어오기   
	    
	    //화면 콘솔에 출력
	    String str;
	    while(  (str=in.readLine()) != null ) {//읽을 라인이 있다면
	    	System.out.println(str);
	    }
	    
	    //미션) 읽어들인 웹소스를 파일(test.html)로 저장하고
	    //     탐색기에서 'test.html'을 더블클릭해서 해당 사이트를 접속하시오!!
	    InputStream is2 =url.openStream();
	    BufferedReader br = new BufferedReader
	              (new InputStreamReader(is2,"UTF-8"));//웹소스 얻어오기   

	    //FileWriter fw = new FileWriter("test.html"); ---> 문자집합 설정X
	 //OutputStreamWriter osw = new OutputStreamWriter(OutputStream out,String cs)
	 FileOutputStream fos = new FileOutputStream("test.html");   
	 OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
	    
		//파일(test.html)에 출력
		String str2;
		while(  (str2=br.readLine()) != null ) {//읽을 라인이 있다면
		   //fw.write(str2);
			osw.write(str2);
		}
		   
		//fw.close();
		osw.close();
		System.out.println("파일출력성공~!!");
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
   }//main   
}
