package com.encore.j0427;

public class Parent extends Object{
   int i=11;
   void hello() {
	 System.out.println("�ȳ�~!!");  
   }//hello
   
   void hello(String name) {//---->? �����ε��޼ҵ�
	   System.out.println("�ȳ�,"+name);  
   }//hello
   
   void hello(int age) {//---->? �����ε��޼ҵ�
	   System.out.println("�ȳ�,"+age);  
   }//hello  
   
   void print() {
	 System.out.println("�θ�����Ʈ~!!");
   }//print
}
