package com.encore.j0501;

class My{
   int su;//멤버변수!! --> 기본값존재 ---> 0
   String str;//멤버 ----> 기본값존재 ---> null
   
   int  suArry[] = new int[5];//suArry[0]~ suArry[4]생성
   
}




public class ArrayTest {
   public static void main(String[] args) {
	   My m = new My();
	   System.out.println("su = "+ m.su);
	   System.out.println("str = "+ m.str);
	   System.out.println("suArry배열크기: "+ m.suArry.length); //5
       for(int i=0; i< m.suArry.length; i++) {//suArry배열의 인덱스 표현: 0~4
    	   System.out.println("suArry["+i+"]번지="+ m.suArry[i]);
       }
       //////////////////////////////////////////
       System.out.println("===========================");
       int  suArry2[] = new int[5];//suArry2[0]~ suArry2[4]생성
       for(int i=0; i< suArry2.length; i++) {//suArry2배열의 인덱스 표현: 0~4
    	   System.out.println("suArry2["+i+"]번지="+ suArry2[i]);
       }
   }//main
}








