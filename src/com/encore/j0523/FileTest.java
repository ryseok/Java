package com.encore.j0523;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;





public class FileTest {
  public static void main(String[] args) throws IOException {
     //File f = new File(String pathname);//pathname: 경로(폴더)와 파일명
	 /*
       <경로표현 방법>
       - 전체경로(드라이브명과 중간 폴더경로 전체), 생략된 경로, 상대적인 경로
       - 자바의 경로는 '전체경로'가  기본
           ----> ImageIcon("경로");	     
           ----> ImageIcon("image/left.gif");
                            ---> 이클립스의 프로젝트 종류 중 JavaProject에서만 가능!!	 
       - 자바의 경로안의 문자는 대소문자 구분을 하지 않음.                                
	 */
	  
	 //File클래스 : 파일이 갖는 속성을 알기위해 준비된 클래스, 추가기능: 디렉토리 생성,지우기 기능
	  
	 File f = new File("c:\\jaelee\\workspace\\JavaApp\\a.txt");//전체경로
	 //'\\' ---> '\'가 확장(기능)문자가 아니라 파일과 디렉토리를 구분하는 역할의 문자로 사용!!
	 System.out.println("f파일(디렉토리)존재 유무: "+ f.exists());
	  
	 File f2 = new File("c:/jaelee/workspace/JavaApp/a.txt");
	      f2 = new File("a.txt");//생략된 경로(이클립스내에서 가능)
	      f2 = new File(".");//  . 경로 : current directory  (현재경로)
	      f2 = new File("../..");//  .. 경로 : parent directory  (부모경로)
	 
	 System.out.println("f2파일(디렉토리)존재 유무: "+ f2.exists());
	 
	 //경로 정보 얻어오기
	 System.out.println("f2.getPath(): "+ f2.getPath());
	  //new File(String path) 파라미터에 정의된 문자열 값 그대로 ==> ..\..
	 System.out.println("f2.getAbsolutePath(): "+ f2.getAbsolutePath());
	  //명시된 파일의 위치 + 설정된 경로  ==> C:\jaelee\workspace\JavaApp\..\..
	 System.out.println("f2.getCanonicalPath(): "+ f2.getCanonicalPath());
	  //설정된 경로를 적용한 경로  ==> C:\jaelee
	 
	 //b.txt파일 속성 참조 ==> File f3으로 표현?
	 File f3 = new File("src/com/encore/j0523/b.txt");//f3 == b.txt
	 System.out.println("f3파일(디렉토리)존재 유무: "+ f3.exists());
	 
	 if(f3.isFile()) {//파일이면  true
		System.out.println("f3은 파일!!"); 
	 }
	 
	 if(f3.isDirectory()) {//디렉토리면 true
		System.out.println("f3은 디렉토리(폴더)!!"); 
	 }
	 
	 //문제) song폴더에 c.txt파일을 생성하시오.
	 //※참고: FileWriter, FileOutputStream은 파일을 생성하는 기능을 갖는다!!
	 //new FileReader("c.txt"); ----> 없는 파일의 경우 에러발생!!
	 //new FileWriter("c.txt"); ----> 없는 파일의 경우 파일생성!!
		 
	 String path="song/a/b/";
	 String fileName="c.txt";
	 
	 File f4 = new File(path);
	 
	 if(f4.exists()) {//폴더 또는 파일이 존재한다면 true
		System.out.println("#디렉토리가 이미 존재함!!"); 
	 }else {
		//System.out.println("#디렉토리가 존재하지 않음!!");
		f4.mkdirs();//디렉토리 생성기능 
		System.out.println("#디렉토리를 새로 생성함!!");
	 }
	 
	 FileWriter fw = new FileWriter(path+fileName);// song/a/b/c.txt
	 //없는 파일의 경우 파일을 새롭게 생성해주지만  존재하지 않는 폴더의 경우는 에러발생!!
	 
	 
	 fw.close();//자원 반환!!
	 
	 //파일 또는 디렉토리 삭제 ===> delete()
	 File f5 = new File("song/a/b/c.txt");
	    System.out.println("c.txt 파일삭제: "+ f5.delete());//삭제성공시 true!!
	    
	 File f6 = new File("song/a/b");
	    System.out.println("b폴더삭제: "+ f6.delete());//삭제성공시 true!!
	                                 //---> 빈 폴더 삭제가능!!
  }//main

}





