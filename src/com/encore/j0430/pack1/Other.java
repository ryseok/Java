package com.encore.j0430.pack1;

public class Other {
	
	void callTest() {
	//ParentŬ������ ���ǵǾ� �ִ� �޼ҵ� ȣ��
		Parent p = new Parent();
		             //--->�⺻ ������ ȣ��		
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
