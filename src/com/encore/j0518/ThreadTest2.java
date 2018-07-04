package com.encore.j0518;

class YouThread extends Thread{
	
   public YouThread(String name) {
	   super(name);//����Ŭ���� ������ ȣ��
   }	
	
	
   //������ Ư¡ �޼ҵ� ---> run  : start()�޼ҵ带 ���� ȣ���ؾ� ���� ������ ����!!
   public void run() {
	  try {
		for(int i=1; i<11; i++) {
			  Thread.sleep(500);//0.5�� ���
			  System.out.println(getName()+" : "+ i);
		  }
	  } catch (InterruptedException e) {
		e.printStackTrace();
	  }
   }//run
	
}


public class ThreadTest2 {
   public static void main(String[] args) {
	   //YouThread = ThreadŬ����!!
	   //�����忡 �̸� �ο��ϱ� new Thread(String name)
	   YouThread t1 = new YouThread("�浿������");
	   YouThread t2 = new YouThread("���ӽ�����");
	   YouThread t3 = new YouThread("�ֿ�������");
	   
	   //������ �켱���� �ο�(1~10) 10:�켱���� ���� ����, 5 ---> �⺻��
	   t1.setPriority(Thread.MAX_PRIORITY);//(10);
	   t2.setPriority(Thread.MIN_PRIORITY);//(1);
	   t3.setPriority(Thread.NORM_PRIORITY);//(5);
	   
	   //������ ����
	   t1.start();
	   t2.start();
	   t3.start();
   }
}


