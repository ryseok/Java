package com.encore.j0508;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
   public static void main(String[] args) {
	  //Vector(int initialCapacity, int capacityIncrement)
	  //initialCapacity:����ũ��,  capacityIncrement: ��ũ���� ����ġ
	   
	   Vector v = new Vector(5,3);//���� : �����͸� ��� �ٱ���!!
	   //������ ----> element(���)
	   
	   System.out.println("������ �뷮(��ũ��): "+ v.capacity());//5
	   System.out.println("������ ���(�Էµ� ������)����: "+ v.size());//��0
	   
	   
       //���ʹ� ��ü�� ����(a, new A())�� ��� �迭
	   Integer su = new Integer(1);
	   int su2=2;
	   
	   v.addElement(su);
	   v.addElement(su2);
	   
	   for(int i=3; i<10; i++) {//3~9
		   v.addElement(i);
	   }
	   
	   System.out.println("������ �뷮(��ũ��): "+ v.capacity());//11
	   System.out.println("������ ���(�Էµ� ������)����: "+ v.size());//9
	   
	   v.addElement(true);
	   v.addElement(3.14);
	   v.addElement("�ڹ�");
	   
	   System.out.println("������ �뷮(��ũ��): "+ v.capacity());//14
	   System.out.println("������ ���(�Էµ� ������)����: "+ v.size());//12
	   
	   //���;��� ������ ���� ����
	   if(v.contains(3.14)) {//��� ���Խ� true����
		   System.out.println("3.14�� ����");
	   }
	   
	   //������ ��� ��� ���
	   Enumeration enu = v.elements();
	   //Enumeration(������ �������̽�) enu=[1,2,3,4,.....,"�ڹ�"];
	   System.out.println("------------------------");
	   while(enu.hasMoreElements()) {//��Ұ� ������ true����
		  System.out.println(enu.nextElement()); 
	   }
	   
   }//main
}






