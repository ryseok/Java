package com.encore.j0430;

class B{
   //�������(�ʵ�)
   String str;//Ŭ���� �⺻��: null (�޸� �Ҵ� X)
	
   //������
   B(){
	   this("�ڹ�");//�ٸ������� ȣ��
	   System.out.println("BŬ���� �⺻ ������");
   }
   B(String str){//�Ű�����(��������)
	  //str = str;//��������str = ��������str;
	   this.str = str;//������� = ����������;
	  System.out.println("�����ε� ������");
   }
	
   //�޼ҵ�����
   void hello() {
	  System.out.println("STR="+ str);//this.str);
   }
}


public class ThisTest {
    public static void main(String[] args) {
		 B b = new    B();
		          //�⺻������ ȣ��
		 b.hello();
		 System.out.println("==============");
		 
		 B b2 = new B("C���"); //�����ε� �����ڸ� ����ȣ��
		 b2.hello();
		 
	}
}



