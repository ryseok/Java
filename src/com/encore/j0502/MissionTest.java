package com.encore.j0502;

public class MissionTest {
   public static void main(String[] args) {
	  int [] su = { 1,   2,  3,  4,  5 };
	            //su[0] [1] [2] [3] [4]
	  //1~5숫자를 출력하세요  ----> 0~4
	  for(int i=1; i<6; i++) {//i=1~5
		  System.out.println(i);
	  }
	  System.out.println("배열크기: "+ su.length);
	  System.out.println("=======================\n문제1)\n");
	  //for(int i=0; i<5; i++) {//배열의 인덱스를 표현 0~4
	  for(int i=0; i<su.length; i++) {//배열의 인덱스를 표현 0~4
		  System.out.println(i + "인덱스:" +  su[i]);
	  }
	  System.out.println("=======================\n문제2)\n");
      //for(int i=4; i>-1; i--) {//배열의 인덱스를 표현 4~0
	  for(int i=su.length-1; i>-1; i--) {//배열의 인덱스를 표현 4~0
          System.out.println(i + "인덱스:"+ su[i]);    	  
      }
	  //행                    0     1        2       <=== i
	  int su2[][]={ {1}, {1,2}, {1,2,3}};
	  //열                    0    0 1    0 1 2      <=== j
	  
 	  System.out.println("=======================\n문제3)\n");
      //2차원배열안의 데이터를 출력
 	  //su2.length ===> 행의 갯수 : 3
 	  //su2[행인덱스].length ===> 각 행이 갖는 열의 갯수: 1 또는 2또는 3
 	  //for(int i=0; i<3; i++) {//행의 인덱스          i =  0        1       2
 	  for(int i=0; i<su2.length; i++) {     //행의 인덱스          i =  0        1       2
 		  for(int j=0;  j<su2[i].length; j++) {//열의 인덱스   j =  0        0,1     0,1,2
 			  System.out.println("★su2["+i+"]["+j+"]번지 = "+ su2[i][j]);
 		  }
 	  }
 	  
 	  //su배열의 저장된 정수들을  su3배열에 값을 복사!!
 	  //1차원 배열객체 생성 ===> 자료형 변수명[]=new 자료형[배열크기];
                             //int  su3[] = new int [5]; //su3[0]~ su3[4] 	      
 	  int  su3[] = new int [su.length]; //su3[0]~ su3[4] 
 	        
 	  System.out.println("=======================\n문제4)\n");
 	       //su3 = su;  //su배열이 갖는 주소를 복사 
 	  
 	  for(int i=0; i< su.length; i++) {//배열내의 데이터값을 복사
 		  //su3[0] = su[0];
 		  //su3[1] = su[1];
 		  su3[i] = su[i];
 	  }
 	  
 	       su3[2] = 33;
 	  for (int i = 0; i < su3.length; i++) {
		System.out.println("su3["+i+"]="+su3[i]);
	  }
 	  System.out.println("-----------------------");
 	  for (int i = 0; i < su.length; i++) { //0~4
 		  System.out.println("su["+i+"]="+su[i]);
 	  }
 	  
 	 System.out.println("=======================\n문제5)\n");
 	int [] su4 = { 1,2,3,4,5};
 	 /*
 	[0]번지와 [4]번지 데이터 교환      
    [1]번지와 [3]번지 데이터 교환 후 출력!! 
 	 */
 	 /*int tmp;
 	   tmp   = su4[0];
 	   su4[0] = su4[4];
 	   su4[4] = tmp;
 	   
 	   tmp   = su4[1];
 	   su4[1] = su4[3];
 	   su4[3] = tmp;*/
 	 
 	 /*int tmp;
 	 int j= su4.length-1; //4;
 	 for(int i=0; i< su4.length/2; i++) {//i: 0 1 2 3 4
 		                               //j: 4 3 2 1 0
 		 tmp    = su4[i];
 	   	 su4[i] = su4[j];
 	   	 su4[j] = tmp;
 	   	 
 	   	 j--;
 	 }*/
 	 int tmp; 	 
 	 int half= su4.length/2;
 	 for(int i=0,j=su4.length-1; i<half; i++,j--) {//i: 0 1 2 3 4
 		                               //j: 4 3 2 1 0
 		 tmp    = su4[i];
 	   	 su4[i] = su4[j];
 	   	 su4[j] = tmp; 	   	 
 	 }
 	 
 	 for (int i = 0; i < su4.length; i++) { //0~4
 		 System.out.println("su4["+i+"]="+su4[i]);
 	 }
 	  
 	System.out.println("=======================\n문제6)\n");
 	//su배열의 홀수번지를 출력하시오.
    for(int i=0; i<su.length; i++) {//인덱스0~4
    	if( (i%2)!=0 )System.out.println("su["+i+"]번지="+ su[i]);
    }
    
    System.out.println("=======================\n문제7)\n");
    //su배열의 홀수값을 출력하시오.
    for(int i=0; i<su.length; i++) {//인덱스0~4
    	if( (su[i]%2) !=0  )System.out.println("su["+i+"]번지="+ su[i]);
    }
    int 변수명;
 	
   }//main
}










