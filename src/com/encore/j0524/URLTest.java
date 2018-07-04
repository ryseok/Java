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
		   
		   System.out.println("��������: "+ url.getProtocol());
		   System.out.println("ȣ��Ʈ: "+ url.getHost());
		   System.out.println("�������ϸ�: "+ url.getFile());
		   
		   InputStream is =url.openStream();
	   //BufferedReader br = new BufferedReader(new InputStreamReader(InputStream));
	   //InputStreamReaderŬ���� ----> ����Ʈ��Ʈ���� ���ڽ�Ʈ������ ��ȯ�ϴ� ���  
	   //InputStreamReader(InputStream is)  
	   //InputStreamReader(InputStream is,String charsetName)  
	    BufferedReader in = new BufferedReader
	    		              (new InputStreamReader(is,"UTF-8"));//���ҽ� ������   
	    
	    //ȭ�� �ֿܼ� ���
	    String str;
	    while(  (str=in.readLine()) != null ) {//���� ������ �ִٸ�
	    	System.out.println(str);
	    }
	    
	    //�̼�) �о���� ���ҽ��� ����(test.html)�� �����ϰ�
	    //     Ž���⿡�� 'test.html'�� ����Ŭ���ؼ� �ش� ����Ʈ�� �����Ͻÿ�!!
	    InputStream is2 =url.openStream();
	    BufferedReader br = new BufferedReader
	              (new InputStreamReader(is2,"UTF-8"));//���ҽ� ������   

	    //FileWriter fw = new FileWriter("test.html"); ---> �������� ����X
	 //OutputStreamWriter osw = new OutputStreamWriter(OutputStream out,String cs)
	 FileOutputStream fos = new FileOutputStream("test.html");   
	 OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
	    
		//����(test.html)�� ���
		String str2;
		while(  (str2=br.readLine()) != null ) {//���� ������ �ִٸ�
		   //fw.write(str2);
			osw.write(str2);
		}
		   
		//fw.close();
		osw.close();
		System.out.println("������¼���~!!");
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
   }//main   
}
