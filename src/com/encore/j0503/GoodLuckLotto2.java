package com.encore.j0503;

import java.util.Arrays;
import java.util.Random;

public class GoodLuckLotto2 {
   int [] lotto;
   Random r;
   
   public GoodLuckLotto2() {
	 lotto = new int[6];
	 r = new Random();
   }//생성자
   
   public void generateNum() {//로또번호발생
	  for(int i=0; i<lotto.length; i++) {//배열인덱스 0~5
		  lotto[i]=r.nextInt(45)+1;//랜덤한 수를 저장
		  boolean flag = duplicateNumCheck(i);
		  if(flag) {//(flag==true) {
			 i--;  
		  }
	  }
   }
   public boolean duplicateNumCheck(int idx) {//중복숫자검사
	   //매개변수 idx:==>기준인덱스를 의미!!
	   //idx:5   비교인덱스:4,3,2,1,0
	   //idx:4   비교인덱스:3,2,1,0
	   //idx:3   비교인덱스:2,1,0
	  for(int i=idx-1; i>-1; i--) {
		 if(lotto[idx] == lotto[i]) {//중복된 수가 발견되었다면!!
			 return true;
		 }
	  }
	   
	  return false; 
   }
   public void printNum() {//로또번호출력(배열에 입력된 값을 출력)
	  Arrays.sort(lotto);
	  for(int i=0; i<lotto.length; i++) {//배열인덱스 0~5
		  System.out.print(lotto[i]);
		  if(i<lotto.length-1)System.out.print(", ");		  
	  }
   }
	
	
	
   public static void main(String[] args) {
       GoodLuckLotto2 luck = new GoodLuckLotto2();
       System.out.println("★★ 금주 행운의 로또번호 ★★");
       
       for(int i=1; i<6; i++) {//횟수 지정(1회~5회)
    	 System.out.print(" "+i+"회: ");
         luck.generateNum();
         luck.printNum();
         System.out.println();
       }
   }//main
}




