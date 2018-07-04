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
	  System.out.println("매개변수로 받은 두개의 수!!");
	  int su1 = Integer.parseInt(args[0]);//Integer.parseInt("숫자로 구성된 문자열")
	  int su2 = Integer.parseInt(args[1]);
	  
	  System.out.println("su1="+su1+", su2="+su2);
	  System.out.println("su1을 su2로 나눈 몫= "+ (su1/su2));
	  System.out.println("나눗셈을 잘 실행하였습니다~!!");
	 }catch(NumberFormatException e1) {
		 System.out.println("## 숫자만 입력하세요~!!");
	 }catch(Exception e) {//Exception e = new NumberFormatException();
		                  //Exception e = new ArithmeticException();
		 System.out.println("모든 예외 처리: "+ e);
		 return;
	 }finally {
		 System.out.println("예외와 상관없이 반드시 실행해야 할 문장!!===> finally블럭!!");
		 //----> (파일,DB관련 객체)자원 반환 코드
	 }
  
     System.out.println("마지막 문장~!!");
  
  
  
     /*catch(NumberFormatException e1) {
		 System.out.println("## 숫자만 입력하세요~!!");
	 }catch(ArrayIndexOutOfBoundsException e2) {
		 System.out.println("## 두개의 숫자를 입력하세요~!!");
	 }catch(ArithmeticException e3) {
		 System.out.println("## 0으로 나눌 수 없습니다~!!");
	 }*/
   }//main
}




