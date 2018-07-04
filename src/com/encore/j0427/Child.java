package com.encore.j0427;

public class Child extends Parent{
	              //is a
	       //자식은 부모다!!
	       //자식은 부모로 형변환하는것이 가능
   int j=22;
   
   void goodBye() {
	  System.out.println("안녕히가세요~!!"); 
   }
   void print() {//--->? 오버라이딩메소드!!
	 System.out.println("자식프린트~!!");  
   }
   
}
