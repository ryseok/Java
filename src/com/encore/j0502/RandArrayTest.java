package com.encore.j0502;

import java.util.Random;

public class RandArrayTest {
   int []su;
   Random r;
	
   public RandArrayTest() {
	//������: (����ʵ忡 ����)�ʱ�ȭ�޼ҵ�, �����۾�
	   //�迭��ü����:  �ڷ��� ������[]=new �ڷ���[�迭��ũ��];
	   su = new int[5];
	   r = new Random();
   }//������	
   
   
   public void inputArray() {
	   /*su[0] = 10; 
	   su[1] = 20; 
	   su[2] = 30; 
	   su[3] = 40; 
	   su[4] = 50; */
	   
	   //������ ��(����) �߻� ==>  java.lang.Math: random(),   java.util.Random: next() 
	   for(int i=0; i<su.length; i++) {
		  //su[i]= (int) Math.random();   //ĳ����:   (�ڷ���)������;
		   //      (int)(0.0~  0.99999   *1000)
		  //su[i]= (int) (Math.random()*1000);   //ĳ����:   (�ڷ���)������;
              		// 0  ~ 999
		  //Math.random()  ==   r.nextDouble()
		   su[i] = r.nextInt(1000); //0~999
	   }        
	   
   }
   
   public void printArray() {//�迭�� ��ü �����Ͱ��� ���. 
      for(int i=0; i<su.length; i++) {
    	 System.out.println("su["+i+"]����="+ su[i]); 
      }
   }
   
   public void sortArray() {//�迭���� �����͸� ��������(1,2,3,4) �Ǵ� ��������(10,9,8,7) ����
	  //������ ��ȯ��
	  //su.length ---> 5
	   
	  int temp; 
	  for(int i=0; i<su.length-1; i++) {//����!!  ���ʵ����� (�ε��� 0~3)
		  for(int j=i+1; j<su.length; j++) {//���� �����ʵ����� (�ε��� 1~4)
			  /*
			     i=0 ,   j=1,2,3,4
			     i=1 ,   j=2,3,4
			     i=2 ,   j=3,4
			     i=3 ,   j=4
			   */
			  
			  //su[i] ������  <----> su[j] ������
			 if(su[i] > su[j]) {//���ʵ����Ͱ� �����ʵ����ͺ��� ũ�ٸ� 
			  temp  = su[i];
			  su[i] = su[j];
			  su[j] = temp;
			 }
		  }//�� for
	  }//�ٱ� for
   }
	
	
   public static void main(String[] args) {
	    RandArrayTest  rat = new RandArrayTest();   
	      rat.inputArray();
	      rat.printArray();
	      
	      System.out.println("----- ������������ -----");
	      rat.sortArray();
	      rat.printArray();
   }//main

}









