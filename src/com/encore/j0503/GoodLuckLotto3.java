package com.encore.j0503;

import java.util.Random;

public class GoodLuckLotto3 {
   public static void main(String[] args) {
	//�ڷ��� [] �迭�� = new �ڷ���[�迭ũ��];
	   
	  //����� ��ȯ!!
	   int []lotto = new int[45];//���� 45���� �Է��� �� �ִ� �� ����.
	   
	   for (int i = 0; i < lotto.length; i++) {
		  lotto[i] = i+1;
	   }//for
	   
	   //��ȣ �����ֱ�!! (���� [0]������   ������ ����)
	   Random r = new Random();
	   int tmp;
	   
	   for(int i=0; i<1000; i++) {//�ڼ����ִ� Ƚ�� ǥ��
		   int idx = r.nextInt(44)+1;  //----> 1~44: �ε����� ���
		   //������ ��ȯ
		   tmp = lotto[0];
		   lotto[0] = lotto[idx];
		   lotto[idx] = tmp;
	   }
	   
	   for (int i = 0; i < 6; i++) {
		   System.out.println("lotto["+i+"]="+ lotto[i]);
	   }
   }//main
}



