package com.encore.j0502;

public class ArrayTest {
  public static void main(String[] args) {
	 //배열선언과 초기화
	 //int []su;
	  //      su={1,    2,    3,   4,    5};
	  //에러발생: 반드시 선언과 초기화를 함께 기술!! (X)      
	 int []su = {1,    2,    3,    4,    5,    6,7,8,9};
	         //su[0] su[1] su[2] su[3] su[4]
	 
	 System.out.println("su[0]번지="+su[0]);//첫번째데이터 출력
	 System.out.println("su[1]번지="+su[1]);//두번째데이터 출력
	 System.out.println("su[2]번지="+su[2]);//세번째데이터 출력
	 System.out.println("su[3]번지="+su[3]);//네번째데이터 출력
	 System.out.println("su[4]번지="+su[4]);//다섯번째데이터 출력
     System.out.println("==============================");
     System.out.println("배열의 크기(요소갯수): "+ su.length);
	 //for(int i=0; i<5; i++) {//0~4까지 표현, 배열의 인덱스를 표현
     for(int i=0; i< su.length; i++) {//0~4까지 표현, 배열의 인덱스를 표현
		 System.out.println("su["+i+"]번지="+su[i]);	 
	 }
	 
     System.out.println("# 2차원배열 테스트");
     
        //행 인덱스        0       1           2
     int su2[][]= { {11}, {22,33},  {44,55,66} };
        //열 인덱스        0     0   1     0   1  2
	 
     //1차원배열명.length  ---> 배열크기, 요소갯수
     //2차원배열명.length  ---> 행의 크기!!   su2.legth ---> 3
     System.out.println("su2의 행크기: "+ su2.length); //3
     
     for(int i=0; i< su2.length; i++) {//행 인덱스 표현  0 1 2
    	 for(int j=0; j< su2[i].length; j++) {//열 인덱스 표현 
    		 System.out.println("su2["+i+"]["+j+"]="+ su2[i][j]);
    	 }
     }
  }//main
}//ArrayTest







