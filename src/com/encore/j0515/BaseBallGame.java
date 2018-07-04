package com.encore.j0515;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 <�̺�Ʈ ó��>
 1. �̺�Ʈ �ҽ�: bt_new, bt_clear, bt_dap, bt_exit, tf
    ---> ��ư�� ��������, �ؽ�Ʈ�ʵ忡 ���Ͱ� �ԷµǾ����� ---> Action�̺�Ʈ!!
    
 2. implements ActionListener
    actionPerformed����
    
 3. ������ ���
    ��ư.addActionListener(this);        
    �ؽ�Ʈ�ʵ�.addActionListener(this);        
  
 */
public class BaseBallGame extends JFrame implements ActionListener{
   JTextArea ta;
   JButton bt_new, bt_clear, bt_dap, bt_exit;
   JLabel la;
   JTextField tf;
   //JScrollPane: ������ ����� �����͸� ǥ��(JTextArea, JList, JTable)
   JScrollPane scroll_ta;
   
   JPanel panel;
   
   //������ ������ ���� --> int �迭
   int[] com, user; 
   Random r;
   
   int count;
   
   public BaseBallGame() {
	 setTitle("���ھ߱�����");
	 
	 com = new int[3];//int[]com = {0,0,0}
	 user = new int[3];//int[]user = {0,0,0}  ==> �ؽ�Ʈ�ʵ带 ���� �Էµ� �����͸� ������ ����
	 
	 r = new Random();		
	 
	 ta = new JTextArea();
	 //scroll_ta = new JScrollPane(��ũ�ѹٸ� �ʿ�� �ϴ� ������Ʈ);
	 scroll_ta = new JScrollPane(ta);
	 
	 bt_new = new JButton("������");
	 bt_clear = new JButton("�����");
	 bt_dap = new JButton("����");
	 bt_exit = new JButton("����");
	 
	 la = new JLabel("�Է�:");
	 tf = new JTextField();
	 
	 //ta.setBounds(10, 10, 350, 300);
	 scroll_ta.setBounds(10, 10, 350, 300);
	 bt_new.setBounds(380,60,90,40);
	 bt_clear.setBounds(380,120,90,40);
	 bt_dap.setBounds(380,180,90,40);
	 bt_exit.setBounds(380,240,90,40);
	 
	 la.setBounds(10, 320, 30,30);
	 tf.setBounds(50, 320, 310,30);
	 
	 panel = new JPanel();
	  panel.setLayout(null);
	  panel.setBackground(Color.ORANGE);
	  panel.add(scroll_ta);//(ta);
	  panel.add(bt_new);
	  panel.add(bt_clear);
	  panel.add(bt_dap);
	  panel.add(bt_exit);
	  panel.add(la);
	  panel.add(tf);
	 
	 add(panel);
	 setBounds(300,300, 500,410);
	 setVisible(true);
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 createNum();
	 
	 
	 eventUp();//������ ��� �޼ҵ� ȣ��!!
   }//������

   private void eventUp() {
	  tf.addActionListener(this);
	  
	  bt_new.addActionListener(this); 
	  bt_clear.addActionListener(this); 
	  bt_dap.addActionListener(this); 
	  bt_exit.addActionListener(this); 
   }
   
   public void createNum() {
	  for(int i=0; i<com.length; i++) {//����
		  com[i]=r.nextInt(10);//0~9
		  for(int j=i-1; j>-1; j--) {//�ߺ��˻�   i=[1]�� j=[0]    i=[2]�� j=[1] j=[0]
			 if(com[i] == com[j]) {//�ߺ��� ���� �߰�
			     i--;
			     break;
			 }
		  }//for
	  }//for
	   
	   /*com[0]=r.nextInt(10);
		do { 
		 com[1]=r.nextInt(10);
		}while(com[1] == com[0]);
		
		do {
		 com[2]=r.nextInt(10);
		}while(com[2] == com[1] || com[2] == com[0]);*/
   }//createNum
   
   @Override
   public void actionPerformed(ActionEvent e) {//�̺�Ʈó���� <== ��� �߻��� ���� ����!!
      //ta.append("1: 123 �� 1Strike 1Ball\n");
	 Object ob = e.getSource();//�̺�Ʈ�ҽ��� ���۷��� ����
	 
	 //�켱���� : bt_exit, bt_clear, bt_dap, bt_new, tf
	 
	 if(ob==tf) {
		 //����ڰ� �Է��� TextField���� com�迭�� ���� ���Ͽ� ȭ��(TextArea)�� ��� ���!!
		 
	   String str = tf.getText();//"369"
	   //���� com[]�迭�� String���� ��ȯ�Ѵٸ�   ""+com[0]+com[1]+com[2] ---> "327"
	   
	  /*
	   int su = Integer.parseInt(str);//"369" ----> 369
	   user[0]= su/100; //  369/100 ---> 3
	   user[1]= (su%100)/10;  // 369%100  ---> 69/10  ---> 6
	   user[2]= (su%100)%10;  // 369%100  ---> 69%10  ---> 9
      */	   
		 
	  /*
	  user[0]= str.charAt(0)-48; //user[0] = '3'-48  = 51-48 ? 
	  user[1]= str.charAt(1)-48; 
	  user[2]= str.charAt(2)-48;
	  */
	   for(int i=0; i<user.length; i++) {
		   user[i]=str.charAt(i)-48;
	   }
	   //==> com�迭�� ���Ҽ� �ִ� ����� int[]my�迭 ���� ����
	   
	   int strike=0, ball=0;
	   
	   for(int i=0; i<com.length; i++) {//com�迭
		   for(int j=0; j<user.length; j++) {//user�迭
			   //���ڰ� ��!!
			   if(com[i] == user[j]) {//������ ---> ��Ʈ����ũ �Ǵ� ���� �ĺ�!!
				   if(i==j) {//���� �ڸ��� �� ---> ��Ʈ����ũ!!
					   strike++;
				   }else {//�ٸ� �ڸ���  ---> ��!!
					   ball++;
				   }
			   }
		   }
	   }//for
	   
	   count++;
	   if(strike==3) {
		 ta.append("�������մϴ٢� ����["+str+"]�� ���߼̽��ϴ�^^*\n");  
	   }else {
	     ta.append( count+": "+str+" �� "+strike+"Strike "+ball+"Ball\n");
	   }
	   tf.setText("");
	   
	   
	   
	 }else if(ob==bt_new) {
	    //com�迭�� �ߺ������ʴ� 0~9�� ���� �Է�
		 count=0;
		 createNum();
		
	 }else if(ob==bt_clear) {
		//TextComponent���� ���� ----> JTextArea, JTextField ���� �����
		ta.setText("");
		tf.setText("");
	 }else if(ob==bt_dap) {
		//com������ ���� ���!! 
		ta.append("�� ������ ["+com[0]+com[1]+com[2]+"]�Դϴ�.\n");
		         //   "abc" + 0    + 7+     9
		         //   "abc0" + 7 + 9
		         //   "abc07"+9
		         //   "abc079"
		
	 }else if(ob==bt_exit) {
		//�������α׷� ����
		 System.exit(0);
	 }
	   
   }//actionPerformed
   
   public static void main(String[] args) {
	 new BaseBallGame();
   }
}
