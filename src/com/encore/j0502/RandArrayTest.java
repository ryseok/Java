package com.encore.j0502;

import java.util.Random;

public class RandArrayTest {
   int []su;
   Random r;
	
   public RandArrayTest() {
	//생성자: (멤버필드에 대한)초기화메소드, 선행작업
	   //배열객체생성:  자료형 변수명[]=new 자료형[배열의크기];
	   su = new int[5];
	   r = new Random();
   }//생성자	
   
   
   public void inputArray() {
	   /*su[0] = 10; 
	   su[1] = 20; 
	   su[2] = 30; 
	   su[3] = 40; 
	   su[4] = 50; */
	   
	   //임의의 수(난수) 발생 ==>  java.lang.Math: random(),   java.util.Random: next() 
	   for(int i=0; i<su.length; i++) {
		  //su[i]= (int) Math.random();   //캐스팅:   (자료형)데이터;
		   //      (int)(0.0~  0.99999   *1000)
		  //su[i]= (int) (Math.random()*1000);   //캐스팅:   (자료형)데이터;
              		// 0  ~ 999
		  //Math.random()  ==   r.nextDouble()
		   su[i] = r.nextInt(1000); //0~999
	   }        
	   
   }
   
   public void printArray() {//배열의 전체 데이터값을 출력. 
      for(int i=0; i<su.length; i++) {
    	 System.out.println("su["+i+"]번지="+ su[i]); 
      }
   }
   
   public void sortArray() {//배열내의 데이터를 오름차순(1,2,3,4) 또는 내림차순(10,9,8,7) 정렬
	  //데이터 교환식
	  //su.length ---> 5
	   
	  int temp; 
	  for(int i=0; i<su.length-1; i++) {//기준!!  왼쪽데이터 (인덱스 0~3)
		  for(int j=i+1; j<su.length; j++) {//비교할 오른쪽데이터 (인덱스 1~4)
			  /*
			     i=0 ,   j=1,2,3,4
			     i=1 ,   j=2,3,4
			     i=2 ,   j=3,4
			     i=3 ,   j=4
			   */
			  
			  //su[i] 데이터  <----> su[j] 데이터
			 if(su[i] > su[j]) {//왼쪽데이터가 오른쪽데이터보다 크다면 
			  temp  = su[i];
			  su[i] = su[j];
			  su[j] = temp;
			 }
		  }//안 for
	  }//바깥 for
   }
	
	
   public static void main(String[] args) {
	    RandArrayTest  rat = new RandArrayTest();   
	      rat.inputArray();
	      rat.printArray();
	      
	      System.out.println("----- 오름차순정렬 -----");
	      rat.sortArray();
	      rat.printArray();
   }//main

}









