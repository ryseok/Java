package com.encore.j0503;

import java.util.Arrays;
import java.util.Random;

public class GoodLuckLotto {
   public static void main(String[] args) {
	 //���� 6���� �� ���������� ����.
	 //�ڷ��� �迭��[]=new �ڷ���[�迭ũ��];
	   int lotto[]=new int[6];//lotto[0]~lotto[5]���� ����
	   
	   Random r = new Random(); 
	   
	   lotto[0] = r.nextInt(45) +1;//0~44 + 1 ==> 1~45
	  do { 
	   lotto[1] = r.nextInt(45) +1;//0~44 + 1 ==> 1~45
	  }while(lotto[1] == lotto[0]);//�ߺ��� �� �߰�������
	  
	  do {
	   lotto[2] = r.nextInt(45) +1;//0~44 + 1 ==> 1~45
	  }while(lotto[2]==lotto[1] || lotto[2]==lotto[0]);
	 //----------------------------------------------------- 
	  do {
		  lotto[3] = r.nextInt(45) +1;//0~44 + 1 ==> 1~45
	  }while(lotto[3]==lotto[2] || lotto[3]==lotto[1] || lotto[3]==lotto[0]);
	  
	  do {
		  lotto[4] = r.nextInt(45) +1;//0~44 + 1 ==> 1~45
	  }while(lotto[4]==lotto[3] || lotto[4]==lotto[2] || lotto[4]==lotto[1] || lotto[4]==lotto[0]);
	  
	  do {
		  lotto[5] = r.nextInt(45) +1;//0~44 + 1 ==> 1~45
	  }while(lotto[5]==lotto[4] || lotto[5]==lotto[3] || lotto[5]==lotto[2] || lotto[5]==lotto[1] || lotto[5]==lotto[0]);

	   
	   Arrays.sort(lotto);
	   
	   for (int i = 0; i < lotto.length; i++) {
		  System.out.print(lotto[i]+"  ");
	   }
	   
   }//main
}
