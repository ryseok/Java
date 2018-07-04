package com.encore.j0510;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
   <�̺�Ʈó��> ��ɺο�
   1. ������Ʈ�� ������ �̺�Ʈ �м�
       ---> � ������Ʈ�� �̺�Ʈ �ҽ��� ���?
       ---> Button ---> ActionEvent
       
   2. �������̽� �����!!
      ActionEvent - Event : Action + Listener  ==> ActionListener (�������̽�)    
 */
public class EventTest extends Frame  implements ActionListener{//2.
   Button b;//�̺�Ʈ�ҽ�	
   int cnt;//=0;
	
   public EventTest() { 
	  setTitle("�̺�Ʈ�׽�Ʈ"); 
	   
	  //��ü����
	  b = new Button("����ư");
	  
	  //���̾ƿ�����
	  setLayout(new FlowLayout());
	  //���̱�
	  add(b);
	  
	  //������2
	  setSize(400, 300);
	  setVisible(true);
	  
	  //4. ������(�޼ҵ�) ���  : �̺�Ʈ�ҽ�.add�������̽���(�̺�Ʈó������ġ);
	  b.addActionListener(this); //4.
	  
   }//������
   
   @Override
   public void actionPerformed(ActionEvent e) {//�̺�Ʈ ó����!!  3.
	  System.out.println("�̺�Ʈ �ȳ�~!!");
	  
	  cnt++;
	  //������ Ÿ��Ʋ�� ����  : �̺�Ʈ�׽�Ʈ-1, �̺�Ʈ�׽�Ʈ-2
	  //setTitle("Ÿ��Ʋ����");
	  setTitle("�̺�Ʈ�׽�Ʈ-"+ cnt);
	  
	  add(new Button("�߰���ư["+cnt+"]"));
	  setVisible(true);
   }
   
   public static void main(String[] args) {
	   new EventTest();
   }

}
