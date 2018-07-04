package com.encore.j0523;

public class ASCIIGetBytesTest {
   public static void main(String[] args) {
	 //byte[]배열내의 데이터를 문자로 출력!!
	 /*
	   
	             str.toCharArray()             str.getBytes() 
	             <-----------                 --------------->
	  char ch[]               String str="abc"                  byte b[]
	   ={'a','b','c'}                                            ={97,98,99}
	              ----------->                <--------------
	               ch.~  (X)                      b.~  (X)
	           String s1 =                     String s2 =
	               new String(ch);                     new String(b);
	  */
	   
	   String str="hi java stream!!";
	   byte []b = str.getBytes();//byte자료형은 문자의 아스키코드를 저장함!!
       for (int i = 0; i < b.length; i++) {
		  System.out.write(b[i]);//byte배열의 문자를 화면에 출력
		  if(i%3==2)System.out.write('\n'); //한 줄에 세개의 문자씩 출력
	   }
       //System.out.write('\n');
       System.out.flush();//출력객체의 경우 버퍼에 담긴 내용들을 전부 비워주는(출력하는) 기능.
    }//main
}





