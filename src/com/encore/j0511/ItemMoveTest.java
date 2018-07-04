package com.encore.j0511;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ItemMoveTest extends Frame implements ActionListener{
   List l_list,r_list;
   TextField l_tf, r_tf;
   Button bt_r, bt_r_all, bt_l, bt_l_all;
	
   Panel leftp,centerp,rightp;
   
   public ItemMoveTest() {
	   setTitle("Item�����̱�");
	   
	   l_list = new List();
	   r_list = new List();
	   
	   l_tf = new TextField();
	   r_tf = new TextField();
	   
	   bt_r = new Button("��");
	   bt_r_all = new Button("��");
	   bt_l = new Button("��");
	   bt_l_all = new Button("��");
	   
	   leftp = new Panel();
	     leftp.setLayout(new BorderLayout());
	     leftp.add("Center",l_list);
	     leftp.add("South",l_tf);
	   
	   centerp = new Panel();
	     //centerp.setLayout(new GridLayout(6, 3, 0, 10));
	   centerp.setLayout(null);
	     centerp.setBackground(Color.ORANGE);
//	     centerp.add(new Label());centerp.add(new Label());centerp.add(new Label());
//	     centerp.add(new Label());centerp.add(bt_r);       centerp.add(new Label());
//	     centerp.add(new Label());centerp.add(bt_r_all);   centerp.add(new Label());
//	     centerp.add(new Label());centerp.add(bt_l);       centerp.add(new Label());
//	     centerp.add(new Label());centerp.add(bt_l_all);   centerp.add(new Label());
	     //bt_r.setBounds(x, y, width, height);
	     bt_r.setBounds(35, 40, 30, 30);
	     bt_r_all.setBounds(35, 90, 30, 30);
	     bt_l.setBounds(35, 140, 30, 30);
	     bt_l_all.setBounds(35, 190, 30, 30);
	     
	     centerp.add(bt_r);    
	     centerp.add(bt_r_all);    
	     centerp.add(bt_l);    
	     centerp.add(bt_l_all);    
	     
	     
	   rightp = new Panel();
	     rightp.setLayout(new BorderLayout());
	     rightp.add("Center",r_list);
	     rightp.add("South",r_tf);
	     
	   setLayout(new GridLayout(1, 3));  
	     add(leftp);
	     add(centerp);
	     add(rightp);
	     
	   setSize(300,300);
	   setVisible(true);
	   
	   addWindowListener(new WindowAdapter() {//�͸��� ����Ŭ���� anonymous innerŬ����		   
		   public void windowClosing(WindowEvent e) {
				  System.exit(0);
	       }});
	   
	   //������
	   l_tf.addActionListener(this);
	   r_tf.addActionListener(this);
	   
	   bt_l.addActionListener(this);
	   bt_l_all.addActionListener(this);
	   bt_r.addActionListener(this);
	   bt_r_all.addActionListener(this);
   }//������

   @Override
   public void actionPerformed(ActionEvent e) {//EventHandler
	   Object ob = e.getSource();
	   if(ob == l_tf) {//�����ϴ� �ؽ�Ʈ�ʵ� ����Ű �Է�
		   //1. ������ ���
		   String str = l_tf.getText().trim();//trim(): �¿� ���ӵ� ���� �����ϱ� ���.
		         
		   System.out.println("����TextField�Է°� STR=>>"+ str+"<<");
		   
		   //if(str.equals(""))//str�� ���ڿ�("")�� ����Ǿ��ٸ�, �������Է¾��� ���͸� �ƴٸ�
		   //if(str.length()==0)//str�� ���ڿ�("")�� ����Ǿ��ٸ�, �������Է¾��� ���͸� �ƴٸ�
			// return;  
		   
		  if(str.length()>0) { 
		   //2. ������ ����
		   l_list.add(str);
		  }
		   
		   //3. (����)������ ����
		   l_tf.setText("");
		   
	   }else if(ob == r_tf) {
		   String str = r_tf.getText().trim();
		  if(str.length()>0) {
		     r_list.add(str);
		  }
		   r_tf.setText("");
		   
	   }else if(ob == bt_r) {//���� ����Ʈ���� ���õ� item�� ���� ����Ʈ�� �̵���Ű��
		  //String str = l_list.getSelectedItem();//1.
		  int idx = l_list.getSelectedIndex();//1. add�� ������ �ε��� 0~
		  
		  //idx�˻�!!
		  //if(idx!=-1) {������ ����}
		  
		  if(idx==-1) return;
		  
		  r_list.add( l_list.getItem(idx)  );//2.
		  //l_list.remove(str); //3. �ߺ��Ǵ� item�� ���� ��� ������ ���� �ε��� ���� ������ ����!!
		  l_list.remove(idx);//position==index
		  
		  
	   }else if(ob == bt_r_all) {//���� ����Ʈ�� ��ü���(item)�� ��������Ʈ�� �ű��
		  for(int i=0; i< l_list.getItemCount();  i++) {//����Ʈ�� �ε����� ǥ��
			 String str = l_list.getItem(i);//1.
			 r_list.add(str);//2.
			 //l_list.remove(i);//3.
		  }
		  l_list.removeAll();//���� ����Ʈ ��ü�����
		   
	   }else if(ob == bt_l) {
		   int idx = r_list.getSelectedIndex();			  
		   if(idx==-1) return;			  
		   l_list.add( r_list.getItem(idx)  );
		   r_list.remove(idx);
	   }else if(ob == bt_l_all) {
		   for(int i=0; i< r_list.getItemCount();  i++) {//����Ʈ�� �ε����� ǥ��
				 String str = r_list.getItem(i);
				 l_list.add(str);
		   }
		   r_list.removeAll();
	   }
   }//actionPerformed
/*
    1. ��ư�� Ư������ ��Ÿ����
       ---> Ű���� �ѱ� '��' ������
       ---> ����Ű ������ 
       ---> Ư������ '��'ã�Ƽ� �����ϱ�
       
    2. ������ X��ư �������� ���α׷� �����ϱ�
       ---> ���� �ۼ��� �͸��� ����Ŭ���� �����ϰ� �ٿ��ֱ�
       ---> extends Frame��  : addWindowListener()
           Frame f ������ :  f.addWinodwListener()
      
    3. centerp�г�(Grid(6,3))�� Button���� �� ����  
      --->  centerp.add(new Label()); �� ä���ֱ�
    
    4. ����߰��� ���� EventSource�м�
       l_tf, r_tf ==> TextField 
       bt_r, bt_r_all, bt_l, bt_l_all ==> Button 
       
       ButtonŬ������ TextFieldŬ�������� �޼ҵ� ��
       add�� ����~ Listener�� ������ �޼ҵ� ã��
       
       Button ---> addActionListener()!!
       TextField ---> addActionListener()!!
       
       ===> Button�� �������� 
            TextField�� '����'Ű�� �ԷµǾ�������
            Action����� �߻��� ������ ������!!
       
    5. ����߰�
             ù��°, ������ ���!!
             �ι�°, ������ ����(����)!!
             ����°, ���� ������ ����!!
             
             
    6. ���α׷� ���� �� ����ġ ���� ��Ȳ�� ���� ó��!!
       - TextField�Էµ� ������   -----> List �ű涧
               �����Ͱ� �Էµ��� �ʰ� ���͸� ġ�� ������ List�� �߰�!!
               
       - '��' ��ư Ŭ����  ���� ��������Ʈ�� ���õ� �������� ���ٸ� 
          IllegalArgumentException�߻�!!   <== getSelectedItem()���
          ArrayIndexOutOfBoundsException�߻�!! <== getSelectedIndex()���                     
 */
   
   public static void main(String[] args) {
	  new ItemMoveTest();
   }

}





