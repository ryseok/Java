package com.encore.j0518;

public class Customer extends Thread{//�������� ������ (������)
   //��ǥ��: 50����!!
   Account account;//null
   
   public Customer(Account account) {
	  this.account = account;//new Account();
   }
	
   @Override
   public void run() {
	  try {
		for(int i=1; i<=200; i++) {
			  Thread.sleep(50);//0.05�� ����
			  account.deposit(1000);//���
			  System.out.println(getName()+" : "+ i +"ȸ");//�ڸ�ȿ��
			  if(account.getTotal() >= 500000) {//��ǥ��(���ʸ���) �޼�
				  break; 
			  }
		  }
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
   }//run

}
