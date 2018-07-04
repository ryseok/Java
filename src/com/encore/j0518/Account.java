package com.encore.j0518;

public class Account {//모금함 (저금통)
   private int total;
   
   //지불 메소드
   public void deposit(int account) {
	  /*
	      동기화(synchronized) 
	      ---> 메소드 동기화 (메소드에 진입한 스레드가 있을 경우
	                                   다른 스레드들은 대기(LOCK)하게 하는 역할)
           synchronized 리턴형 메소드명(){}	                                   
	                                   
          ---> 블럭동기화, 특정영역 동기화
               synchronized(동기화 객체){}	                                     
	   */
	   synchronized (this) {
   	     total += account; //total = total+account;
	   }
   }//deposit
   
   public int getTotal() {
	  return total;
   }

}
