package com.encore.j0518;

import javax.swing.JFrame;

class MyThread extends Thread{
	
   //스레드 특성을 갖는 메소드(동시실행)
	@Override
   public void run() {
	 //동시실행할(기다리지 않는)  문장들
	 try {
		for(int i=1; i<11; i++) {//1~10
			  //Thread.sleep(long millis);  millis : 밀리세컨드
			  Thread.sleep(1000);//1초간 delay
			  System.out.println("자바스레드1:"+ i);
		   }//for
	   } catch (InterruptedException e) {
		e.printStackTrace();
	  }
   }//run
}//MyThread

class MyThread2 extends JFrame implements Runnable{

	@Override
	public void run() {
		//동시실행할(기다리지 않는)  문장들
		 try {
			for(int i=1; i<11; i++) {//1~10
				  //Thread.sleep(long millis);  millis : 밀리세컨드
				  Thread.sleep(1000);//1초간 delay
				  System.out.println("자바스레드2:"+ i);
			   }//for
		   } catch (InterruptedException e) {
			e.printStackTrace();
		  }
		
	}
	
}

public class ThreadTest {
   public static void main(String[] args) {
	  //※주의할 점: run()메소드를 직접호출X ---> 일반메소드호출!!
	  //          반드시 start()메소드를 통해 run()호출!!
	   
	   MyThread m1  = new MyThread();//m1: 스레드 객체O
	   //m1.run();//일반메소드 호출과 같다!!
	   m1.start();
	   
	   MyThread2 m2 = new MyThread2();//Thread객체X, Runnable객체O
	   //-----> 추가적으로 Thread객체 생성 필요!!
	   //new Thread(Runnable r)
	   Thread t = new Thread(/*run()메소드위치*/ m2);
	   //m2.run();//일반메소드 호출과 같다!!
	   t.start();
   }//main
}



