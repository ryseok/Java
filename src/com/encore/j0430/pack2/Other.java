package com.encore.j0430.pack2;

import com.encore.j0430.pack1.Parent;

public class Other {
	
	void callTest() {
	//Parent클래스에 정의되어 있는 메소드 호출
		Parent p = new Parent();
		 p.m1();  
		 //p.m2(); protected(같은 패키지 접근)
		 //p.m3(); 생략(같은 패키지 접근)
		 //p.m4();  private
		 
	}//callTest
}
