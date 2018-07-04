package com.encore.j0511;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class HelloEventTest extends Frame implements ActionListener, ItemListener {
   TextField tf;
   Checkbox cb1,cb2,cb3;//<==�̺�Ʈ�ҽ�  3��: Checkbox : addItemListener()
   Button bt_hello,bt_clear,bt_exit;//<==�̺�Ʈ �ҽ� 3�� : Button : addActionListener()
   
   Panel northp,centerp,southp;
   
   CheckboxGroup cg;//�������: Ŭ�������� �޼ҵ尣�� ���� ������!!
   
   public HelloEventTest() {
	   setTitle("�ȳ��̺�Ʈ");
	   tf = new TextField(15);
	   
	   cg = new CheckboxGroup();
       cb1 = new Checkbox("�ڹ��ʱ�", cg, true);
       cb2 = new Checkbox("�ڹ��߱�", cg, false);
       cb3 = new Checkbox("�ڹٰ��", cg, false);
	   
       bt_hello = new Button("�ȳ�");
       bt_clear = new Button("�����");
       bt_exit = new Button("����");
       
       //System.out.println("northp="+northp);
       //System.out.println("tf="+tf);
	   northp = new Panel();
	    northp.setBackground(Color.orange);
	    northp.add(tf);
	    
	   centerp = new Panel();
	    centerp.setLayout(new GridLayout(3, 1));
	    centerp.add(cb1);
	    centerp.add(cb2);
	    centerp.add(cb3);
	    
	   southp = new Panel();
	    southp.setBackground(Color.pink);
	    southp.add(bt_hello);
	    southp.add(bt_clear);
	    southp.add(bt_exit);
	   
	   add("North",northp);
	   add("Center",centerp);
	   add("South",southp);
	
	   setSize(350, 300);
	   setVisible(true);
	   
	   //���� ������ ��� 
	   bt_hello.addActionListener(this);
	   bt_clear.addActionListener(this);
	   bt_exit.addActionListener(this);
	   
	   cb1.addItemListener(this);
	   cb2.addItemListener(this);
	   cb3.addItemListener(this);
   }//������
   
   @Override
   public void itemStateChanged(ItemEvent e) {//üũ�ڽ��� ���� �̺�Ʈ �ڵ鷯
	   tf.setText(cg.getSelectedCheckbox().getLabel()+"�ȳ�~??");
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e) {//�̺�Ʈ �ڵ鷯(<=== �������)
	   Object ob = e.getSource();//ob= bt_hello �Ǵ� bt_clear �Ǵ� bt_exit �� ������ ��ư�� �ּҰ�
	   if(ob == bt_hello) {//�ȳ� ��ư Ŭ����
		  
		  /*if(cb1.getState())//if(cb1�� ���õ� ���¶��) if(cb1.getState()==true) 
		    tf.setText("�ڹ��ʱ޾ȳ�~!!");
		  else if(cb2.getState())//else if(cb2�� ���õ� ���¶��)
		    tf.setText("�ڹ��߱޾ȳ�~!!"); 
		  else
			tf.setText("�ڹٰ�޾ȳ�~!!");*/ 
		  
		//CheckboxGroup cg  <----- cb1,cb2,cb3
		  Checkbox cb = cg.getSelectedCheckbox();//���õǾ��� üũ�ڽ� (�ּ�)���� ������ 
		         //cb = cb1 �Ǵ� cb2 �Ǵ� cb3
		  /*if(cb == cb1) tf.setText("�ڹ��ʱ޾ȳ�~~!!");
		  else if(cb == cb2) tf.setText("�ڹ��߱޾ȳ�~~!!");
		  else if(cb == cb3) tf.setText("�ڹٰ�޾ȳ�~~!!");*/
		  tf.setText(cb.getLabel()+"�ȳ�~!!!");
		   
		   
	   }else if(ob == bt_clear) {//����� ��ư Ŭ����
		  //tf.setText("�����");
		  tf.setText(" "); 
		  tf.setText(""); 
	   }else {//if(ob == bt_exit){//���� ��ư Ŭ����
		  System.exit(0);   
	   }
   }
   
   public static void main(String[] args) {
	  new HelloEventTest();
   }


}






