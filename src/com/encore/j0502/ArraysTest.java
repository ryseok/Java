package com.encore.j0502;

import java.util.Arrays;

public class ArraysTest {
  
  public static void main(String[] args) {
	 int su[]= {303, 208, 100, 578, 150};
	 //오름차순 정렬
	 Arrays.sort(su);
	 
	 for (int i = 0; i < su.length; i++) {
		System.out.println("su["+i+"]="+su[i]);
	 }
	 System.out.println("---------------------");
	 
	 char ch[]= {'v','a','C','z','A','x','d'};
	 Arrays.sort(ch);
	 for (int i = 0; i < ch.length; i++) {
		 System.out.println("ch["+i+"]="+ch[i]);
	 }
	 System.out.println("---------------------");
	 Object names[]={"홍길동","길라임",new Boolean(true),"a김주원",new Integer(11),"정철","이순신","이성계"};
	 
	 
	 /*
	     int su;//속성변수!!
	         su=100;
	         
	         su.~  (X)
	         
	     Integer su2;//참조변수!!
	             su2 = new Integer(100);    
	  
	         su2.~  (O)
	  
	   -------------JDK5버전 이후-----------------
	   ===> 오토박싱,언박싱 지원!!
	   
	   int su3 = new Integer(200);
	   
	   Integer su4 = 200;
	  
	  
	  
	     ※ Wrapper클래스
	     
	        기본자료형               래퍼클래스 
	      byte      ---> Byte
	      short     ---> Short
	      int       ---> Integer   (정수와 관련된 속성,메소드를 감싸는 클래스!!)
	      long      ---> Long
	      float     ---> Float
	      double    ---> Double
	      char      ---> Character
	      boolean   ---> Boolean
	  
	  
	  */
	 
	 Arrays.sort(names);
     for (int i = 0; i < names.length; i++) {
    	 System.out.println("names["+i+"]="+names[i]);
	 }
     
	 
  }//main
  
  
}




