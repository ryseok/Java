package com.encore.j0430.pack1;

public class Parent {
   int su;
	
   public Parent(){
	  System.out.println("Parent기본생성자!!");
	  su=20;
   }
   
   public void m1() {
	   System.out.println("m1() su출력 ==> "+ su);
   }
   protected void m2() {}
             void m3() {}
   private   void m4() {}
}
