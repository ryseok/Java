package com.encore.j0503;

import java.util.Random;

public class GoodLuckLotto3 {
   public static void main(String[] args) {
	//자료형 [] 배열명 = new 자료형[배열크기];
	   
	  //사고의 전환!!
	   int []lotto = new int[45];//정수 45개를 입력할 수 있는 방 생성.
	   
	   for (int i = 0; i < lotto.length; i++) {
		  lotto[i] = i+1;
	   }//for
	   
	   //번호 섞어주기!! (기준 [0]번지와   랜덤한 번지)
	   Random r = new Random();
	   int tmp;
	   
	   for(int i=0; i<1000; i++) {//뒤섞어주는 횟수 표현
		   int idx = r.nextInt(44)+1;  //----> 1~44: 인덱스로 사용
		   //데이터 교환
		   tmp = lotto[0];
		   lotto[0] = lotto[idx];
		   lotto[idx] = tmp;
	   }
	   
	   for (int i = 0; i < 6; i++) {
		   System.out.println("lotto["+i+"]="+ lotto[i]);
	   }
   }//main
}



