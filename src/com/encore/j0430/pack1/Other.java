package com.encore.j0430.pack1;

public class Other {
	
	void callTest() {
	//Parent클래스에 정의되어 있는 메소드 호출
		Parent p = new Parent();
		             //--->기본 생성자 호출		
		 p.m1();  
		 p.m2();
		 p.m3();
		 //p.m4();  private		 
	}//callTest
	
	public static void main(String[] args) {
		Other other = new Other();
		    other.callTest();
	}
}
