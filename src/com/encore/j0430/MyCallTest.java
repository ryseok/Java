package com.encore.j0430;

import com.encore.j0427.Parent;

public class MyCallTest {
    public static void main(String[] args) {
    	Parent p;
		//m1()�޼ҵ� ȣ��
    	
       /*
            Ŭ������ ���(=Ŭ�������� �ʵ�,�޼ҵ� ���)�Ϸ���?
       ===> Ŭ���� ��ü����(�޸��Ҵ�)?
       1. static (�����޸� �Ҵ�)
          ---> ���� ���Ǵ� ���(�ʵ�,�޼ҵ�)�� ���� �̸� �޸� �Ҵ�
          ---> ��� ���ٽ�(����) Ŭ������.~ ���� ����
       2. new    (�����޸� �Ҵ�)
          ---> ���������� ����   obj.~  a.~
            
        */
       My.m1();
       int i = My.su;
       //i : �Ӽ����� (�����͸� ��� ����)
       
       System.out.println("i="+i);
       System.out.println("su="+ My.su);
       
       My m = new My();
       //m: ��������, reference���� (�޸𸮸� �����ϴ� ����)
       //m.~ : MyŬ������ �ִ�~
       
       m.m2();
       m.m3(20);//�޼ҵ� ȣ��� ��ȣ�ȿ� �����͸� ������ �� ����
             
       m.m4("ȫ�浿");
       
       m.m5("�����", 15);
       
       A aa = new A();
       m.m6(aa);
       
       m.m6(new A());
       
       
       m.m7("�浿", "����", "�ֿ�");
       
       String []names= {"ȫ�浿",  "�����","���ֿ�", "�̼���"};
         //������ ������!! names[0]  names[1] names[2]
//�迭(Array): ������ �ڷ����� ���� �����͵��� �Ѱ��� ���������� ������ �ڷ���� ����     
       m.m7_2(names);
       
       int sum= m.m11();
       System.out.println("sum="+ sum);
       
       String result = m.m12();
       System.out.println("result="+ result);
       
       A obj = m.m13();
        obj.hello();
        
       int [] array = m.m14();
       
       //�迭�� for���� ģ�ϴ�!! ---> indexǥ�� ����
       for (int j = 0; j < array.length; j++) {
		 System.out.println("array["+j+"]����="+ array[j]);
	   }
       
       
	}//main
}//MyCallTest









