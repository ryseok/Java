package com.encore.j0427;

public class InheritanceTest {

	public static void main(String[] args) {
	   Child c = new Child();
	   //�ڽ��� �ڿ�
	   System.out.println("J="+ c.j);
	   c.goodBye();
	   c.print();
	   
	   //�θ��� �ڿ�
	   c.hello();
	   //c.abc();
	   c.toString();
	   System.out.println("==============");
	   Parent p  = new Parent();
	   //�ڽ��� �ڿ�
	   p.hello();
	   p.print();
	   
	   //�ڽ��� �ڿ�
	   //p.goodBye();//�����߻�
	   //�θ� ��������(p)�� ���� �ڽ� ���� �Ұ���!!
	   
	   Parent p2 = new Child();
	   //��                   ��

	   p2.hello();
	   p2.print();//----> '�ڽ�����Ʈ' ���
	   //�ڡڸ��� �޸𸮿� �������̵��޼ҵ尡 �����Ѵٸ� �θ��� �޼ҵ�� ����ǰ�
	   //  �ڽ��� �޼ҵ�� ��ü�� �ȴ�!!
	   
	   //�ڽ� ���� = �θ�����  -----> �����߻�!!
	   //Child c2 = new Parent();
	   
	   //Child c2 = (Child)new Parent();
	   //Child c2  = (Child)p;
	   //====>p�� �ڽĿ� ���� �޸��Ҵ��� �����Ƿ� runtime�� �����߻�
	   
	   Child c2 = (Child)p2;
	   //===>p2�� �ڽĿ� ���� �޸��Ҵ��� �����Ƿ� �޸� ����Ʈ�� �ڽ����� ����
	   
	   
	}//main

}





