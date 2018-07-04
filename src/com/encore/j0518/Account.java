package com.encore.j0518;

public class Account {//����� (������)
   private int total;
   
   //���� �޼ҵ�
   public void deposit(int account) {
	  /*
	      ����ȭ(synchronized) 
	      ---> �޼ҵ� ����ȭ (�޼ҵ忡 ������ �����尡 ���� ���
	                                   �ٸ� ��������� ���(LOCK)�ϰ� �ϴ� ����)
           synchronized ������ �޼ҵ��(){}	                                   
	                                   
          ---> ������ȭ, Ư������ ����ȭ
               synchronized(����ȭ ��ü){}	                                     
	   */
	   synchronized (this) {
   	     total += account; //total = total+account;
	   }
   }//deposit
   
   public int getTotal() {
	  return total;
   }

}
