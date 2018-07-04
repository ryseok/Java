package com.encore.j0502;

public class StarTest {
  /*  
        hint) 바깥for: 출력라인 수 표현,  안for문: 출력될 "*"의 갯수 표현

*
**
***
****
  
   */
	public static void main(String[] args) {
		
	   //int cnt=0;	
       for(int i=1; i<5; i++) {//기준,   라인수 4를 표현
    	   //0 1 2 3
    	   //1 2 3 4
    	   
    	   //cnt++;//1,2,3,4    	   
           for(int j=0; j<i/*cnt*/; j++) {//자주변경, 각라인에 출력될 '*'의 수를 표현
        	   //i=1    	j=0           cnt:1
        	   //i=2    	j=0,1         cnt:2
        	   //i=3    	j=0,1,2       cnt:3
        	   //i=4    	j=0,1,2,3     cnt:4
    		   System.out.print("*");
           }
           System.out.println();
       }
       System.out.println("===================");
       for(int i=4; i>0; i--) {//4줄     4~1
    	   for(int j=0; j<i; j++) {//4,3,2,1
    		   System.out.print("*");
    	   }
    	   System.out.println();
       }
	}//main
}






