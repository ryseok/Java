package com.encore.j0510;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EventTest2 extends Frame{//2.
   Button b;//�̺�Ʈ�ҽ�	
   int cnt;//=0;
   Frame f;
	
   public EventTest2() { 
	  setTitle("�̺�Ʈ�׽�Ʈ2"); 
	   
	  //��ü����
	  b = new Button("����ư2");
	  
	  //���̾ƿ�����
	  setLayout(new FlowLayout());
	  //���̱�
	  add(b);
	  
	  //������2
	  setSize(400, 300);
	  setVisible(true);
	  
	  //4. ������(�޼ҵ�) ���  : �̺�Ʈ�ҽ�.add�������̽���(�̺�Ʈó������ġ);
	  A a = new A(this);
	  b.addActionListener(a);
	  
   }//������
 
   
   public static void main(String[] args) {
	   new EventTest2();
   }

}





