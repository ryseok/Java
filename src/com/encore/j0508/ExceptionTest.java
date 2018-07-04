package com.encore.j0508;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest {
    public static void main(String[] args) {
	  //텍스트 파일(a.txt)을 읽어서 그 내용을 콘솔에 출력 
    	
      //FileInputStream : 파일에 내용을 byte단위로 읽는 클래스
      //FileReader      :파일에 내용을 문자(char)단위로 읽는 클래스
      //FileReader(String fileName)  ---> fileName:  경로와 파일명
       try{ 	
          //FileReader fr = new FileReader("c:\\jaelee\\workspace\\JavaApp\\abc.txt");
          //FileReader fr = new FileReader("c:/jaelee/workspace/JavaApp/abc.txt");
    	 FileReader fr = new FileReader("a.txt");
 	 //이클립스에서 프로젝트 종류가 JavaProject인 경우  '프로젝트명'까지 경로를 생략하는 것이 가능!!
    	 
    	  /*System.out.println(fr.read());
    	  System.out.println(fr.read());
    	  System.out.println((char)fr.read());// (char)99 ----> 'c'
    	  
    	  System.out.println(fr.read());
    	  System.out.println(fr.read());
    	  System.out.println(fr.read());//-1리턴 : 읽은 문자가 없을경우
*/    	 
    	  int i;
    	  while( (i=fr.read()) !=  -1   ) {//읽은 문자가 있다면
    		  System.out.print((char)i);
    	  }
    	  System.out.println("\n=========================");
          System.out.println("파일읽기 성공~!!");
    	}catch(FileNotFoundException e) {
    	   System.out.println("예외발생!!");
    	   System.out.println("===> 파일이 존재하지 않습니다. 확인바랍니다^^*");
    	   System.out.println("-------------------------------------");
    	   System.out.println(e);
    	   System.out.println(e.toString());//에러메시지
    	   System.out.println(e.getMessage());//간단 에러메시지
    	   e.printStackTrace();
    	}catch(IOException e) {
    		System.out.println("예외발생: "+ e.getMessage());
    	}
	}//main
}






