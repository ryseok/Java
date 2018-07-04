package com.encore.j0430.pack2;

import com.encore.j0430.pack1.Parent;

public class Child extends Parent{
	
   void callTest() {
   //부모클래스에 정의되어 있는 메소드 호출
	 m1();
	 m2();
	 // protected(같은 패키지 접근)
	 // 자식클래스의 경우 다른 패키지라도 접근 가능
	 
	 //m3(); 생략(같은 패키지 접근)
	 //m4(); private
	   
   }//callTest
}
