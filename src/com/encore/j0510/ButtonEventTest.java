package com.encore.j0510;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventTest extends Frame implements ActionListener{
	Button bt1,bt2;
	//�̺�Ʈ�ҽ�: bt1,bt2 ==> Button ==> ActionEvent
	
    public ButtonEventTest() {
      bt1 = new Button("�ȳ�");
      bt2 = new Button("�߰�");
      
      setLayout(new FlowLayout());
      add(bt1);
      add(bt2);
      
      setSize(300, 300);
      setVisible(true);
      
      bt1.addActionListener(this);
      bt2.addActionListener(this);
      
      B b = new B();
      C c = new C();
//      bt1.addActionListener(b);
//      bt2.addActionListener(c);
	}//������
    
    @Override
    public void actionPerformed(ActionEvent e) {//�̺�Ʈ �ڵ鷯
    	
       //System.out.println("actionPerformed()");
    	Object ob = e.getSource();//---->  �̺�Ʈ�ҽ��� ����(�ּ�)�� ������ �޼ҵ�
    	//���� bt1�� Ŭ���ߴٸ�  Object ob = bt1;
    	//���� bt2�� Ŭ���ߴٸ�  Object ob = bt2;
    	
        if(ob == bt1  ) 
    	  System.out.println("�ȳ�~!!");
    	else //if(ob == bt2)
    	  System.out.println("�߰�~!!");
    }
    
    public static void main(String[] args) {
		new ButtonEventTest();
	}

}
