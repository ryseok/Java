package com.encore.j0427;

public class Parent extends Object{
   int i=11;
   void hello() {
	 System.out.println("안녕~!!");  
   }//hello
   
   void hello(String name) {//---->? 오버로딩메소드
	   System.out.println("안녕,"+name);  
   }//hello
   
   void hello(int age) {//---->? 오버로딩메소드
	   System.out.println("안녕,"+age);  
   }//hello  
   
   void print() {
	 System.out.println("부모프린트~!!");
   }//print
}
