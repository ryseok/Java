package com.encore.j0430;

class B{
   //멤버변수(필드)
   String str;//클래스 기본값: null (메모리 할당 X)
	
   //생성자
   B(){
	   this("자바");//다른생성자 호출
	   System.out.println("B클래스 기본 생성자");
   }
   B(String str){//매개변수(지역변수)
	  //str = str;//지역변수str = 지역변수str;
	   this.str = str;//멤버변수 = 지역변수값;
	  System.out.println("오버로딩 생성자");
   }
	
   //메소드정의
   void hello() {
	  System.out.println("STR="+ str);//this.str);
   }
}


public class ThisTest {
    public static void main(String[] args) {
		 B b = new    B();
		          //기본생성자 호출
		 b.hello();
		 System.out.println("==============");
		 
		 B b2 = new B("C언어"); //오버로딩 생성자를 직접호출
		 b2.hello();
		 
	}
}



