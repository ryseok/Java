package com.encore.j0509;

/* public|abstract|final  */ class NestingClass{//�ܺ�Ŭ����
   int i=11;
   
   void hello() {
	  System.out.println("�ȳ�~!!"); 
	  NestedClass nested = new NestedClass();
	    nested.print();
   }	
   
   /*static*/ class NestedClass{//����Ŭ����(innerŬ����)
	  int j=22;
	  void callTest() {
		  System.out.println("i="+i);
		  hello();
	  }
	  void print() {
		 System.out.println("����Ʈ~!!"); 
	  }
   }
   
}//NestingClass

public class NestedTest {
    public static void main(String[] args) {
		NestingClass nesting = new NestingClass();
		  nesting.hello();
		  
		//���� Ŭ������ print()�޼ҵ带 main()���� ���� ȣ���ϰ� �ʹ�
        NestingClass.NestedClass nested = new NestingClass().new NestedClass();
          nested.print();
	}
}








