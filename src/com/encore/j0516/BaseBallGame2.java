package com.encore.j0516;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGame2 extends JFrame implements ActionListener{
   JTextArea ta;
   JScrollPane scroll_ta;
   
   JButton bt_new, bt_clear, bt_dap, bt_hint, bt_exit ;
   JLabel la;
   JTextField tf;
   
   JPanel panel;
   
   //������ ������ ���� --> int[]com �迭, ����� �Էµ����� ���� ���� --> int[] user
   int[] com, user; 
   Random r;
   
   int count;
   boolean start;//���� ���� ����ǥ��
   
   public BaseBallGame2() {
	 setTitle("���ھ߱�����");
	 
	 com = new int[3];//int[]com = {0,0,0}
	 user = new int[3];//int[]user = {0,0,0}  ==> �ؽ�Ʈ�ʵ带 ���� �Էµ� �����͸� ������ ����
	 
	 r = new Random();		
	 
	 ta = new JTextArea();
	 scroll_ta = new JScrollPane(ta);
	 
	 bt_new = new JButton("������");
	 bt_clear = new JButton("�����");
	 bt_dap = new JButton("����");
	 bt_hint = new JButton("��Ʈ");
	 bt_exit = new JButton("����");
	 
	 la = new JLabel("�Է�:");
	 tf = new JTextField();
	 

	 scroll_ta.setBounds(10, 10, 350, 300);
	 bt_new.setBounds(380,30,90,40);//x,y,����,����
	 bt_clear.setBounds(380,90,90,40);
	 bt_dap.setBounds(380,150,90,40);
	 bt_hint.setBounds(380,210,90,40);
	 bt_exit.setBounds(380,270,90,40);
	 
	 la.setBounds(10, 320, 30,30);
	 tf.setBounds(50, 320, 310,30);
	 
	 panel = new JPanel();
	  panel.setLayout(null);
	  panel.setBackground(Color.ORANGE);
	  panel.add(scroll_ta);//(ta);
	  panel.add(bt_new);
	  panel.add(bt_clear);
	  panel.add(bt_dap);
	  panel.add(bt_hint);
	  panel.add(bt_exit);
	  panel.add(la);
	  panel.add(tf);
	 
	 add(panel);
	 
	 setBounds(300,300, 500,410);//(x,y,width,height)
	 setVisible(true);
	 setResizable(false);//������ ������ �Ұ�!!
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 
	 ta.setLineWrap(true);//TextArea�� �ڵ� �ٹٲ�(���λ���� ����� �ؽ�Ʈ �߻���)
	 
	 //new Font(String name,int style,int size)
	 ta.setFont(new Font("����ü", Font.BOLD , 17));
	 /*
	    clas Font{
	       public static final int BOLD=1; 
	    }
	  */
	 
	 
	 //�������
	 ta.setEditable(false);
	 //ta.setEnabled(false);//��Ȱ��ȭ
	 tf.setEnabled(false);//���� ������ �Է±���
	 
	 //���ӽ����� '����', '��Ʈ' ��Ȱ��ȭ
	 bt_dap.setEnabled(false);	 
	 bt_hint.setEnabled(false);	 
	 
	 ruleDescription();
	 	 
	 eventUp();//������ ��� �޼ҵ� ȣ��!!
   }//������

   private void eventUp() {
	  //tf.addMouseListener(MouseListener ml); 
	   
	  tf.addMouseListener(new MouseAdapter() {
		              // class A extends MouseAdapter{}
		  @Override
		  public void mousePressed(MouseEvent e) {
		     if(!start) //if(start) ===> start == true , if(!start) ==> start ==false
		      JOptionPane.showMessageDialog(tf, "���ӽ����� ���� [������]��ư�� Ŭ��!!");    
		     //JOptionPane.showMessageDialog  (this, "���ӽ����� ���� [������]��ư�� Ŭ��!!");  
		     showMsg("���ӽ����� ���� [������]��ư�� Ŭ��!!");    
		  }
	  }); 
	   
	  tf.addActionListener(this);
	  
	  bt_new.addActionListener(this); 
	  bt_clear.addActionListener(this); 
	  bt_dap.addActionListener(this); 
	  bt_hint.addActionListener(this); 
	  bt_exit.addActionListener(this); 
   }//eventUp
   
   
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
	  System.out.println("�� ������ "+com[0]+com[1]+com[2]);
   }//createNum
   
   public void ruleDescription() {
	   ta.setText("\n\n\t<���ھ߱�����>");
	   ta.append("\n1. ���ӽ����� ���ؼ� �����ӹ�ư�� Ŭ��");
	   ta.append("\n2. �Է¿� �ߺ������ʴ� ���ڸ����� �Է� �� ����");
	   ta.append("\n3. ���ڿ� �ڸ����� ���߸� Strike, ���ڸ� ���߸� Ball�� �߰��˴ϴ�.");
	   ta.append("\n4. ������ ���� ������ �����ư�� Ŭ��");
	   ta.append("\n5. ��Ÿ ���ǻ����� ������ �����ڿ��� �����ٶ�(02-754-7302)");
   }//���Ӽ���
   
   public void initText() {//�ؽ�Ʈ������Ʈ �ʱ�ȭ(���ڿ� ����)
	  ta.setText("");
	  tf.setText("");
	  tf.requestFocus();//�ؽ�Ʈ�ʵ忡 ��Ŀ��
   }
   
   public void startGame() {	  
	   count=0;
	   start=true;
	  //��Ȱ��ȭ ������Ʈ ---> Ȱ��ȭ
	   bt_dap.setEnabled(true);
	   bt_hint.setEnabled(true);
	   tf.setEnabled(true);	
	   
	   initText();
   }//�����ʱ�ȭ(���ӽ���) ---> ������
   public void endGame() {//�� ���� ����(������ ���߰ų� '����'��ư�� Ŭ��������)
	   start=false;
	  
	   //Ȱ��ȭ ������Ʈ ---> ��Ȱ��ȭ
	   bt_dap.setEnabled(false);
	   bt_hint.setEnabled(false);
	   tf.setEnabled(false);
	   
   }
   
   public boolean validCheck(String str) {//����ڰ� �Է��� �����Ϳ� ���� �˻�(3�ڸ� ����)
	   //str ==> tf.getText()
	  if(str.matches("[0-9]{3}")) {//���ڸ� ���� �˻�
		  return true;//��ȿ��(������) ������ �϶� true ����!!
	  }	  
    return false;
   }
   
   
   public boolean duplicateCheck(int user[]) {//����ڰ� �Է��� ���ڿ� ���� �ߺ� �˻�      ��) 3  2  3
	  //user[0] user[1] user[2]
	   
	  /*if( user[0]==user[1] || user[0]==user[2] || user[1]==user[2]) { //�ߺ���
		 return true; 
	  }*/
	  
	  for(int i=0; i<user.length-1; i++) {//0~1
		 for(int j=i+1; j<user.length; j++) {//1~2
			 if(user[i] == user[j]) return true;//�ߺ��� �� �߽߰� true����
		 }
	  }
	  
	return false;
   }
   
   
   public void showMsg(String msg) {
	   JOptionPane.showMessageDialog(this,msg);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {//�̺�Ʈó���� <== ��� �߻��� ���� ����!!

	 Object ob = e.getSource();//�̺�Ʈ�ҽ��� ���۷��� ����
	 
	 if(ob==tf) {
		 //����ڰ� �Է��� TextField���� com�迭�� ���� ���Ͽ� ȭ��(TextArea)�� ��� ���!!
		 
	   String str = tf.getText();//"369"
	   //���� com[]�迭�� String���� ��ȯ�Ѵٸ�   ""+com[0]+com[1]+com[2] ---> "327"
	   
	   if(!validCheck(str)) {//str�� �������� �����Ͱ� �ԷµǾ��ٸ�!!
		   //!validCheck(str) ===> validCheck(str)==false
		  showMsg("���ڸ� ���� �Է�!!"); 
		  tf.setText(""); 
		 return;//���̻� �������� �ʰ���!!
	   }
	   
	   for(int i=0; i<user.length; i++) {
		   user[i]=str.charAt(i)-48;
	   }
	   //==> com�迭�� ���Ҽ� �ִ� ����� int[]my�迭 ���� ����
	   
	   
	   if(duplicateCheck(user)) {   //����ڰ� �Է��� ������ �ߺ�üũ
		 //�ߺ��� ���� �߽߰�
		   showMsg("�ߺ��� ���� �Է��� �� �����ϴ�!!");
		   tf.setText("");
		   return;
	   }
	   
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
		 endGame();
	   }else {
	     ta.append( count+": "+str+" �� "+strike+"Strike "+ball+"Ball\n");
	   }
	   tf.setText("");
	   
	   
	   
	 }else if(ob==bt_new) {
	    //com�迭�� �ߺ������ʴ� 0~9�� ���� �Է�		 
		 createNum();
		 startGame();
	 }else if(ob==bt_clear) {
		//TextComponent���� ���� ----> JTextArea, JTextField ���� �����
		ta.setText("");
		tf.setText("");
	 }else if(ob==bt_dap) {
		//com������ ���� ���!! 
		ta.append("�� ������ ["+com[0]+com[1]+com[2]+"]�Դϴ�.\n");
		endGame();
	 }else if(ob == bt_hint) {//��Ʈ��ư�� Ŭ���ߴٸ�
		showMsg("��Ʈ ��==> "+ com[r.nextInt(3)]);//com[0]);
		bt_hint.setEnabled(false);
	 }else if(ob==bt_exit) {
		//�������α׷� ����
		 System.exit(0);
	 }
	   
   }//actionPerformed
   
   public static void main(String[] args) {
	 new BaseBallGame2();
   }
}
