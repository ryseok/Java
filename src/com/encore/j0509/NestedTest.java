package com.encore.j0509;

/* public|abstract|final  */ class NestingClass{//외부클래스
   int i=11;
   
   void hello() {
	  System.out.println("안녕~!!"); 
	  NestedClass nested = new NestedClass();
	    nested.print();
   }	
   
   /*static*/ class NestedClass{//내부클래스(inner클래스)
	  int j=22;
	  void callTest() {
		  System.out.println("i="+i);
		  hello();
	  }
	  void print() {
		 System.out.println("프린트~!!"); 
	  }
   }
   
}//NestingClass

public class NestedTest {
    public static void main(String[] args) {
		NestingClass nesting = new NestingClass();
		  nesting.hello();
		  
		//내부 클래스의 print()메소드를 main()에서 직접 호출하고 싶다
        NestingClass.NestedClass nested = new NestingClass().new NestedClass();
          nested.print();
	}
}








