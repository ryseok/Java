package com.encore.j0518;

public class TVContribution {//방송국
	
   public static void main(String[] args) {
	  //성금자(Thread) 5명을 모집
	 /* 
	  Customer c1 = new Customer();
	  Customer c2 = new Customer();
	  Customer c3 = new Customer();
	  Customer c4 = new Customer();
	  Customer c5 = new Customer();
	  //c1~c5: Thread객체!!
	  c1.start();
	  c2.start();
	  c3.start();
	  c4.start();
	  c5.start();
	  */

	  //1차원 배열 객체생성: 자료형[] 배열명 = new 자료형[사이즈];
	   Customer[] customers = new Customer[5];
	   //customers[]={null,null,null,null,null};
	   
	  Account account = new Account(); 
	  for (int i = 0; i < customers.length; i++) {
		 customers[i] = new Customer(account);//스레드 객체 5개 생성
	  }
	  
	  for (int i = 0; i < customers.length; i++) {
		  customers[i].start(); //모금시작(스레드 시작)
	  }
	  
	  try {
		for (int i = 0; i < customers.length; i++) {
			  customers[i].join();//메인 스레드가 다른 스레드 종료까지 기다려라!!
		  }
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	  
	  System.out.println("총 모금액: "+ account.getTotal());
	  //customers[0].account.getTotal());
	   
   }//main
}



