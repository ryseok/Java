package com.encore.j0511;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
   <�̺�Ʈó��> ---> ������Ʈ�� ����� ��������!!
  1. �̺�Ʈ�ҽ�(������Ʈ)�� ������ �̺�Ʈ �м�  
         Button  bt    ------> ActionEvent 
  2_1. ActionListener(�������̽�)  ------>  implements ActionListener 
  2_2. public void actionPerformed(ActionEvent e){}  ===> �������̵�
  3. �����ڸ޼ҵ� ���         [�̺�Ʈ�ҽ�]  <------- ���� ------->  [�̺�Ʈó����]
          �̺�Ʈ�ҽ���.add�������̽���(�̺�Ʈó������ ��ġ);
           bt.addActionListener(this);
           
           
  <�̺�Ʈó�� ���>   
  1. ����� ������ ������Ʈ ã�� : bt1 
                           ----> �ڷ���: Button
     ===> �̺�Ʈ �ҽ� ã��!!                           
                           
  2. Button(�̺�Ʈ�ҽ�)Ŭ������ �޼ҵ� ��  add~Listener()�޼ҵ� ã��!!
                                 ===> addActionListener() !!
  3. �������̽� (add����)==>  ActionListener : implements �ϱ�!!
                                              ===> �޼ҵ� �������̵�
  4. ������ ���!! (2���� add~Listener()�޼ҵ�!!)                                             
                                                                               
        
 */



public class EventTest2 extends Frame implements ActionListener{
   Button bt1,bt2;	// addActionListener(ActionListener l)  
	
   public EventTest2() {
	  setTitle("�̺�Ʈ�׽�Ʈ2"); 
	  bt1 = new Button("�ȳ�");//101ȣ
	   bt1.setActionCommand("first");
	  bt2 = new Button("����");//201ȣ
	  
	  setLayout(new FlowLayout());
	  add(bt1);
	  add(bt2);
	  
	  setSize(350, 300);
	  setVisible(true);
	  
	  //�ҽ�.addActionListener(�ڵ鷯);
	  bt1.addActionListener(this);
	  bt2.addActionListener(this);
	  
	  /*
	       public class Button{
	           public void addActionListener(ActionListener l)
	           {
	               while(true){
	                  if(��ư�� ���ȴٸ�){
	                      l.actionPerformed();
	                  }
	               }
	           }
	       }
	   */
	  
   }//������
 
   @Override
   public void actionPerformed(ActionEvent e) {//�̺�Ʈ �ڵ鷯
	   //ActionEvent : �̺�Ʈ �߻���Ų �ҽ��� ������ ���� �� ����
	   //String e.getActionCommand();  ---> ������Ʈ�� ������ ActionCommand�� ��ų�
	   //                             Button�� ��� Label�� ���� �� ����.
	   //�Ǵ� Object e.getSource();  ----> �̺�Ʈ�ҽ��� ��������(�޸� �Ҵ�) ����
	 /* String str = e.getActionCommand();
	  System.out.println("STR="+ str);
	   
	  System.out.println("bt1="+ bt1); 
	  System.out.println("bt2="+ bt2);
	  
	  System.out.println("�̺�Ʈ �ҽ�="+ e.getSource());
	  System.out.println("=================");*/
	   
	 Object ob = e.getSource(); 
	 //if(bt1�� ������ actionPerformed�� ȣ��Ǿ��ٸ�)  
	 if(ob == bt1) //�޸� �� 
      System.out.println("�ȳ�~!!");
	 //else if(bt2�� ������ actionPerformed�� ȣ��Ǿ��ٸ�)
	 else {//if(ob == bt2)
        System.out.println("����~!!");
        System.exit(0); //exit(status) ==> status: 0,���(�������� ����)  ����(���������� ����)
	 }
   }
   
   public static void main(String[] args) {
	  new EventTest2();
   }


}





















