package com.encore.j0518;

public class TVContribution {//��۱�
	
   public static void main(String[] args) {
	  //������(Thread) 5���� ����
	 /* 
	  Customer c1 = new Customer();
	  Customer c2 = new Customer();
	  Customer c3 = new Customer();
	  Customer c4 = new Customer();
	  Customer c5 = new Customer();
	  //c1~c5: Thread��ü!!
	  c1.start();
	  c2.start();
	  c3.start();
	  c4.start();
	  c5.start();
	  */

	  //1���� �迭 ��ü����: �ڷ���[] �迭�� = new �ڷ���[������];
	   Customer[] customers = new Customer[5];
	   //customers[]={null,null,null,null,null};
	   
	  Account account = new Account(); 
	  for (int i = 0; i < customers.length; i++) {
		 customers[i] = new Customer(account);//������ ��ü 5�� ����
	  }
	  
	  for (int i = 0; i < customers.length; i++) {
		  customers[i].start(); //��ݽ���(������ ����)
	  }
	  
	  try {
		for (int i = 0; i < customers.length; i++) {
			  customers[i].join();//���� �����尡 �ٸ� ������ ������� ��ٷ���!!
		  }
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	  
	  System.out.println("�� ��ݾ�: "+ account.getTotal());
	  //customers[0].account.getTotal());
	   
   }//main
}



