package com.encore.j0508;

public class ExceptionTest2 {
   public static void main(String[] args) {
	  /*
	    String[] args={"10","5"};
	    String[] args={"ab","cd"};
	    String[] args={"10"};
                                	    
	      su1  su2
	     ----------
	      10    5
	      ab    cd   ===> NumberFormatException
	      10    X    ===> ArrayIndexOutOfBoundsException
	      10    0    ===> ArithmeticException
	   */
  try{   
	  System.out.println("�Ű������� ���� �ΰ��� ��!!");
	  int su1 = Integer.parseInt(args[0]);//Integer.parseInt("���ڷ� ������ ���ڿ�")
	  int su2 = Integer.parseInt(args[1]);
	  
	  System.out.println("su1="+su1+", su2="+su2);
	  System.out.println("su1�� su2�� ���� ��= "+ (su1/su2));
	  System.out.println("�������� �� �����Ͽ����ϴ�~!!");
	 }catch(NumberFormatException e1) {
		 System.out.println("## ���ڸ� �Է��ϼ���~!!");
	 }catch(Exception e) {//Exception e = new NumberFormatException();
		                  //Exception e = new ArithmeticException();
		 System.out.println("��� ���� ó��: "+ e);
		 return;
	 }finally {
		 System.out.println("���ܿ� ������� �ݵ�� �����ؾ� �� ����!!===> finally��!!");
		 //----> (����,DB���� ��ü)�ڿ� ��ȯ �ڵ�
	 }
  
     System.out.println("������ ����~!!");
  
  
  
     /*catch(NumberFormatException e1) {
		 System.out.println("## ���ڸ� �Է��ϼ���~!!");
	 }catch(ArrayIndexOutOfBoundsException e2) {
		 System.out.println("## �ΰ��� ���ڸ� �Է��ϼ���~!!");
	 }catch(ArithmeticException e3) {
		 System.out.println("## 0���� ���� �� �����ϴ�~!!");
	 }*/
   }//main
}




