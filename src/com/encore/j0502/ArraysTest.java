package com.encore.j0502;

import java.util.Arrays;

public class ArraysTest {
  
  public static void main(String[] args) {
	 int su[]= {303, 208, 100, 578, 150};
	 //�������� ����
	 Arrays.sort(su);
	 
	 for (int i = 0; i < su.length; i++) {
		System.out.println("su["+i+"]="+su[i]);
	 }
	 System.out.println("---------------------");
	 
	 char ch[]= {'v','a','C','z','A','x','d'};
	 Arrays.sort(ch);
	 for (int i = 0; i < ch.length; i++) {
		 System.out.println("ch["+i+"]="+ch[i]);
	 }
	 System.out.println("---------------------");
	 Object names[]={"ȫ�浿","�����",new Boolean(true),"a���ֿ�",new Integer(11),"��ö","�̼���","�̼���"};
	 
	 
	 /*
	     int su;//�Ӽ�����!!
	         su=100;
	         
	         su.~  (X)
	         
	     Integer su2;//��������!!
	             su2 = new Integer(100);    
	  
	         su2.~  (O)
	  
	   -------------JDK5���� ����-----------------
	   ===> ����ڽ�,��ڽ� ����!!
	   
	   int su3 = new Integer(200);
	   
	   Integer su4 = 200;
	  
	  
	  
	     �� WrapperŬ����
	     
	        �⺻�ڷ���               ����Ŭ���� 
	      byte      ---> Byte
	      short     ---> Short
	      int       ---> Integer   (������ ���õ� �Ӽ�,�޼ҵ带 ���δ� Ŭ����!!)
	      long      ---> Long
	      float     ---> Float
	      double    ---> Double
	      char      ---> Character
	      boolean   ---> Boolean
	  
	  
	  */
	 
	 Arrays.sort(names);
     for (int i = 0; i < names.length; i++) {
    	 System.out.println("names["+i+"]="+names[i]);
	 }
     
	 
  }//main
  
  
}




