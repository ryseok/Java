package com.encore.j0501;

class My{
   int su;//�������!! --> �⺻������ ---> 0
   String str;//��� ----> �⺻������ ---> null
   
   int  suArry[] = new int[5];//suArry[0]~ suArry[4]����
   
}




public class ArrayTest {
   public static void main(String[] args) {
	   My m = new My();
	   System.out.println("su = "+ m.su);
	   System.out.println("str = "+ m.str);
	   System.out.println("suArry�迭ũ��: "+ m.suArry.length); //5
       for(int i=0; i< m.suArry.length; i++) {//suArry�迭�� �ε��� ǥ��: 0~4
    	   System.out.println("suArry["+i+"]����="+ m.suArry[i]);
       }
       //////////////////////////////////////////
       System.out.println("===========================");
       int  suArry2[] = new int[5];//suArry2[0]~ suArry2[4]����
       for(int i=0; i< suArry2.length; i++) {//suArry2�迭�� �ε��� ǥ��: 0~4
    	   System.out.println("suArry2["+i+"]����="+ suArry2[i]);
       }
   }//main
}








