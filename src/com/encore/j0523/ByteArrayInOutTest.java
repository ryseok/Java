package com.encore.j0523;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ByteArrayInOutTest {
   //c.txt읽기  -----> d.txt쓰기	
	
	
   public static void main(String[] args) throws Exception{
      FileInputStream fis = new FileInputStream("c.txt");//내용: abcd
      FileOutputStream fos = new FileOutputStream("d.txt");
      
      //fis.read(byte[]b);
      /*
       byte [] b = new byte[10];//byte[]b={0,0,0,0,0};
      
       for (int i = 0; i < b.length; i++) {
		 System.out.println("b["+i+"]번지="+ b[i]);
	   }
      
      System.out.println("======================");
      System.out.println(fis.read(b));
      //byte[]b={97,98,99,100,0};
      for (int i = 0; i < b.length; i++) {
 		System.out.println("b["+i+"]번지="+ b[i]);
 	  }
      
      System.out.println(fis.read(b));
      System.out.println(fis.read(b));// fis(b.txt)를 읽어 b배열에 복사(쓰기)
    */
      
      byte [] testArr = {97,98,99,100,101};
                       //0   1  2  3   4
      
      //fos.write(testArr); //testArr배열을 읽어서 fos(c.txt)에 쓰기.  abcde 저장!!
      
      //fos.write(byte[]b,int offset,int length);
      //byte배열 b를 offset(시작위치)부터 읽어들이되  최대 length만큼  읽어서 fos에 출력!!
      //fos.write(testArr, 0, 3);//abc저장!!
      //fos.write(testArr, 2, 3);//cde저장!!
      
      
      
      int i; //c.txt ----> abcdefgh
      byte [] b = new byte[5];//배열size: read(b)를 통해 읽을 최대 바이트 수!!
                 //{0,0,0,0,0}
      //fis.read(b); {a,b,c,d,e}  i=5
      //fis.read(b); {f,g,h,d,e}  i=3
      
      while((i=fis.read(b)) != -1) {//i: 읽은 바이트 수
    	  //System.out.println("★");
    	  fos.write(b,0,i);
      }
      //d.txt ------> abcdefghde
      System.out.println("파일복사 성공~!!");
      
      
   }//main
}




