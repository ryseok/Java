package com.encore.j0509;

class MyException extends Exception{
   
	public MyException(String msg) {
		super(msg);//�θ� �����ڰ� ���� ����� ����
	}
}


public class ExceptionTest3 {
   public static void main(String[] args) {
      boolean conditions=true;
      
      try {
		if(conditions) {
			  //throw new MyException("����� ���� ���� �޽���");
			  MyException m = new MyException("����� ���� ���� �޽���");
			  throw m;
		  }
	} catch (MyException e) {
		e.printStackTrace();
	}
	   
   }
}







