package com.encore.j0430.pack2;

import com.encore.j0430.pack1.Parent;

public class Other {
	
	void callTest() {
	//ParentŬ������ ���ǵǾ� �ִ� �޼ҵ� ȣ��
		Parent p = new Parent();
		 p.m1();  
		 //p.m2(); protected(���� ��Ű�� ����)
		 //p.m3(); ����(���� ��Ű�� ����)
		 //p.m4();  private
		 
	}//callTest
}
