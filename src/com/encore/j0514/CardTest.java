package com.encore.j0514;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardTest extends Frame implements ActionListener{
	
	//���� �г�
	Panel redp, bluep, greenp;
	//'����' ��ư
	Button b1,b2,b3;//<=== �̺�Ʈ �ҽ�!! : Button  : add~Listener() : addActionListener()
	
	//ī��ǥ�� �г�
	Panel p1,p2,p3;
	
	CardLayout card;
	
	public CardTest() {
	   setTitle("ī�巹�̾ƿ�");
		
       redp = new Panel();   
         redp.setBackground(Color.red);
       bluep = new Panel();   
         bluep.setBackground(Color.blue);
       greenp = new Panel();
         greenp.setBackground(Color.green);
       
       b1 = new Button("����");
       b2 = new Button("����");
       b3 = new Button("����");
       
       p1 = new Panel();//�г� �⺻���̾ƿ� : FlowLayout
        p1.setLayout(new BorderLayout());
        p1.add("Center",redp);
        p1.add("South",b1);
        
       p2 = new Panel();//�г� �⺻���̾ƿ� : FlowLayout
        p2.setLayout(new BorderLayout());
        p2.add("Center",bluep);
        p2.add("South",b2);
        
       p3 = new Panel();//�г� �⺻���̾ƿ� : FlowLayout
        p3.setLayout(new BorderLayout());
        p3.add("Center",greenp);
        p3.add("South",b3);
        
        
      card = new CardLayout();  
      setLayout(card); //���� ��ġ�� ������Ʈ(p1,p2,p3) ��ġ!!
      //ī�巹�̾ƿ��� ��� '����(alias)'�� �Բ� ����
      
       add("a1",p1); //���� ���� add�� ī�尡 ���α׷� ���۽� ����!!
       add("a2",p2); 
       add("a3",p3);
       //"a1","a2","a3" ----> ����
       
      //���α׷� ���۽� ��� ī�尡 ���̰� �ʹ�!! ---> CardLayout�� show()�޼ҵ� ���..
       
      //card.show (Container parent,String name);
      // ��     ������                    ���              ������
      card.show(this, "a3");
       
       
      setSize(350,450);
      setVisible(true);
      
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {//���(�̺�Ʈ)�߻��� ȣ��� �޼ҵ� : �̺�Ʈ �ڵ鷯 (����߰�)
	   Object ob = e.getSource();//�̺�Ʈ�ҽ��� �ּ�����	
		
	   if(ob==b1) {// p1 ����ī��� ������ư b1 Ŭ����
		   card.show(this, "a2");
	   }else if(ob==b2) {//p2 �Ķ�ī��� ������ư b2 Ŭ����
		   card.show(this, "a3");
	   }else {//p3 �ʷ�ī��� ������ư b3 Ŭ����
		   card.show(this, "a1");
	   }
		
	}//actionPerformed
	
	public static void main(String[] args) {
		new CardTest();
	}


}



