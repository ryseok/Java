package com.encore.j0509;

class MyException extends Exception{
   
	public MyException(String msg) {
		super(msg);//부모 생성자가 갖는 기능을 실행
	}
}


public class ExceptionTest3 {
   public static void main(String[] args) {
      boolean conditions=true;
      
      try {
		if(conditions) {
			  //throw new MyException("사용자 정의 예외 메시지");
			  MyException m = new MyException("사용자 정의 예외 메시지");
			  throw m;
		  }
	} catch (MyException e) {
		e.printStackTrace();
	}
	   
   }
}







