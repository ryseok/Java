package com.encore.j0518;

import javax.swing.JFrame;

class MyThread extends Thread{
	
   //������ Ư���� ���� �޼ҵ�(���ý���)
	@Override
   public void run() {
	 //���ý�����(��ٸ��� �ʴ�)  �����
	 try {
		for(int i=1; i<11; i++) {//1~10
			  //Thread.sleep(long millis);  millis : �и�������
			  Thread.sleep(1000);//1�ʰ� delay
			  System.out.println("�ڹٽ�����1:"+ i);
		   }//for
	   } catch (InterruptedException e) {
		e.printStackTrace();
	  }
   }//run
}//MyThread

class MyThread2 extends JFrame implements Runnable{

	@Override
	public void run() {
		//���ý�����(��ٸ��� �ʴ�)  �����
		 try {
			for(int i=1; i<11; i++) {//1~10
				  //Thread.sleep(long millis);  millis : �и�������
				  Thread.sleep(1000);//1�ʰ� delay
				  System.out.println("�ڹٽ�����2:"+ i);
			   }//for
		   } catch (InterruptedException e) {
			e.printStackTrace();
		  }
		
	}
	
}

public class ThreadTest {
   public static void main(String[] args) {
	  //�������� ��: run()�޼ҵ带 ����ȣ��X ---> �Ϲݸ޼ҵ�ȣ��!!
	  //          �ݵ�� start()�޼ҵ带 ���� run()ȣ��!!
	   
	   MyThread m1  = new MyThread();//m1: ������ ��üO
	   //m1.run();//�Ϲݸ޼ҵ� ȣ��� ����!!
	   m1.start();
	   
	   MyThread2 m2 = new MyThread2();//Thread��üX, Runnable��üO
	   //-----> �߰������� Thread��ü ���� �ʿ�!!
	   //new Thread(Runnable r)
	   Thread t = new Thread(/*run()�޼ҵ���ġ*/ m2);
	   //m2.run();//�Ϲݸ޼ҵ� ȣ��� ����!!
	   t.start();
   }//main
}



