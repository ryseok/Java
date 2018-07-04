package com.encore.j0518;

class YouThread extends Thread{
	
   public YouThread(String name) {
	   super(name);//상위클래스 생성자 호출
   }	
	
	
   //스레드 특징 메소드 ---> run  : start()메소드를 통해 호출해야 동시 실행이 가능!!
   public void run() {
	  try {
		for(int i=1; i<11; i++) {
			  Thread.sleep(500);//0.5초 대기
			  System.out.println(getName()+" : "+ i);
		  }
	  } catch (InterruptedException e) {
		e.printStackTrace();
	  }
   }//run
	
}


public class ThreadTest2 {
   public static void main(String[] args) {
	   //YouThread = Thread클래스!!
	   //스레드에 이름 부여하기 new Thread(String name)
	   YouThread t1 = new YouThread("길동스레드");
	   YouThread t2 = new YouThread("라임스레드");
	   YouThread t3 = new YouThread("주원스레드");
	   
	   //스레드 우선순위 부여(1~10) 10:우선순위 가장 높음, 5 ---> 기본값
	   t1.setPriority(Thread.MAX_PRIORITY);//(10);
	   t2.setPriority(Thread.MIN_PRIORITY);//(1);
	   t3.setPriority(Thread.NORM_PRIORITY);//(5);
	   
	   //스레드 실행
	   t1.start();
	   t2.start();
	   t3.start();
   }
}


