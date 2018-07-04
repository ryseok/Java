package com.encore.j0503;

import java.util.Arrays;
import java.util.Random;

public class GoodLuckLotto2 {
   int [] lotto;
   Random r;
   
   public GoodLuckLotto2() {
	 lotto = new int[6];
	 r = new Random();
   }//������
   
   public void generateNum() {//�ζǹ�ȣ�߻�
	  for(int i=0; i<lotto.length; i++) {//�迭�ε��� 0~5
		  lotto[i]=r.nextInt(45)+1;//������ ���� ����
		  boolean flag = duplicateNumCheck(i);
		  if(flag) {//(flag==true) {
			 i--;  
		  }
	  }
   }
   public boolean duplicateNumCheck(int idx) {//�ߺ����ڰ˻�
	   //�Ű����� idx:==>�����ε����� �ǹ�!!
	   //idx:5   ���ε���:4,3,2,1,0
	   //idx:4   ���ε���:3,2,1,0
	   //idx:3   ���ε���:2,1,0
	  for(int i=idx-1; i>-1; i--) {
		 if(lotto[idx] == lotto[i]) {//�ߺ��� ���� �߰ߵǾ��ٸ�!!
			 return true;
		 }
	  }
	   
	  return false; 
   }
   public void printNum() {//�ζǹ�ȣ���(�迭�� �Էµ� ���� ���)
	  Arrays.sort(lotto);
	  for(int i=0; i<lotto.length; i++) {//�迭�ε��� 0~5
		  System.out.print(lotto[i]);
		  if(i<lotto.length-1)System.out.print(", ");		  
	  }
   }
	
	
	
   public static void main(String[] args) {
       GoodLuckLotto2 luck = new GoodLuckLotto2();
       System.out.println("�ڡ� ���� ����� �ζǹ�ȣ �ڡ�");
       
       for(int i=1; i<6; i++) {//Ƚ�� ����(1ȸ~5ȸ)
    	 System.out.print(" "+i+"ȸ: ");
         luck.generateNum();
         luck.printNum();
         System.out.println();
       }
   }//main
}




