package com.encore.j0502;

public class StarTest {
  /*  
        hint) �ٱ�for: ��¶��� �� ǥ��,  ��for��: ��µ� "*"�� ���� ǥ��

*
**
***
****
  
   */
	public static void main(String[] args) {
		
	   //int cnt=0;	
       for(int i=1; i<5; i++) {//����,   ���μ� 4�� ǥ��
    	   //0 1 2 3
    	   //1 2 3 4
    	   
    	   //cnt++;//1,2,3,4    	   
           for(int j=0; j<i/*cnt*/; j++) {//���ֺ���, �����ο� ��µ� '*'�� ���� ǥ��
        	   //i=1    	j=0           cnt:1
        	   //i=2    	j=0,1         cnt:2
        	   //i=3    	j=0,1,2       cnt:3
        	   //i=4    	j=0,1,2,3     cnt:4
    		   System.out.print("*");
           }
           System.out.println();
       }
       System.out.println("===================");
       for(int i=4; i>0; i--) {//4��     4~1
    	   for(int j=0; j<i; j++) {//4,3,2,1
    		   System.out.print("*");
    	   }
    	   System.out.println();
       }
	}//main
}






