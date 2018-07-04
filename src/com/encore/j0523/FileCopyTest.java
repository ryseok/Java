package com.encore.j0523;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyTest {//파일복사와 복사에 걸리는 시간을 체크!!
	
	//a.txt파일을 읽어서 화면(콘솔)에 출력   a.txt ----> 화면
	
	//a.txt파일을 읽어서 b.txt에 출력        a.txt  ----> b.txt   (File Copy!!)
	
	//1)바이트 단위 입출력
	FileInputStream fis;
	FileOutputStream fos;
	
	//2)문자 단위 입출력
	FileReader fr;
	FileWriter fw;
	
	//3)라인 단위 입출력 --> 문자들을 버퍼에 담았다가 한번에 읽고 쓰기. 
	BufferedReader br;
	BufferedWriter bw;
	
	//4)바이트 단위 입출력(byte배열 사용)
	FileInputStream fis2;
	FileOutputStream fos2;
	
	
    public FileCopyTest() throws IOException {
	   fis = new FileInputStream("a.txt");
	   fos = new FileOutputStream("b.txt");
	   //화면 출력
	   /*
	   System.out.println(fis.read());//97   a
	   System.out.println(fis.read());//98   b
	   System.out.println(fis.read());//99   c
	   System.out.println(fis.read());//100  d
	   
	   System.out.println(fis.read());//-1
	   System.out.println(fis.read());//-1 ---> 읽은 byte가 없을때 -1 리턴
	   */
	   int i;
	   
	   long start= System.currentTimeMillis();
	   
	   while(  (i=fis.read()) != -1  ) {//읽은 byte가 있다면   i:읽은 문자의 숫자 코드값
		   //System.out.println(i);//숫자출력
		   //System.out.write(i);//문자출력
		   fos.write(i);//파일에 문자출력
	   }
	   long end = System.currentTimeMillis();
	   
	   //fos.flush();//버퍼내용 전부 출력하기!!
	   fos.close();//출력자원을 반환!! ---> flush()기능이 추가되어있음!!
	   fis.close();
	   
	   //System.out.flush();
	   System.out.println("[byte단위]파일복사 성공~^^*: "+ (end-start));
	   //==========================================================
	   fr = new FileReader("a.txt");//fr은 a.txt파일!!
	   fw = new FileWriter("b.txt");//fw는 b.txt파일!!
	   
	   start = System.currentTimeMillis();
	   while(  (i=fr.read()) != -1 ) {//읽은 문자가 있다면
		   fw.write(i);
	   }
	   end = System.currentTimeMillis();
	   
	   fw.close();
	   fr.close();//입출력 객체에 대한 자원 반환!!
	   
	   System.out.println("[문자단위]파일복사 성공~^^*: "+ (end-start));
	   //==========================================================
	   //br = new BufferedReader(Reader in)
	   //br = new BufferedReader(new FileReader("a.txt"));
	   br = new BufferedReader(new FileReader("a.txt"));
	   //bw = new BufferedWriter(Writer out)
	   bw = new BufferedWriter(new FileWriter("b.txt"));
	   
	   String str;
	   
	   start = System.currentTimeMillis();
	   while( (str=br.readLine()) != null ) {//읽은 라인이 있다면
		   bw.write(str);
	   }
	   end = System.currentTimeMillis();
	   
	   bw.close();
	   br.close();
	   
	   System.out.println("[버퍼단위]파일복사 성공~^^*: "+ (end-start));
	  //==========================================================
	   fis2 = new FileInputStream("a.txt");//fis2는 a.txt파일!!
	   fos2 = new FileOutputStream("b.txt");//fos2는 b.txt파일!!
	   
	   byte []b = new byte[1024];
	   //배열사이즈: 512 또는 1024 ---> 1Kbyte단위로 read()하겠음!!
	  
	   /*
	   fis2.read(b) ----> fis(a.txt)를 읽어서 배열 b에 복사
                                             리턴값은 읽은 바이트수, 읽은 바이트가 없다면 -1리턴 
       fos2.write(b) ----> 배열b를 읽어서 fos(b.txt)에 출력
       fos2.write(b,offset,length) ----> 배열b를 offset에서 시작해서 length만큼 읽어서 
                                         fos2(b.txt)에 출력
       */ 
	   start = System.currentTimeMillis();
	   while( (i=fis2.read(b)) !=  -1) { //i=읽은 바이트 수
		   fos2.write(b,0,i);
	   }
	   end = System.currentTimeMillis();
	   System.out.println("[byte단위, byte배열사용]파일복사 성공~^^*: "+ (end-start));
	   
	}//생성자
    
    public static void main(String[] args) throws IOException{
		new FileCopyTest();
	}
}



