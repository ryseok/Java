package com.encore.person.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputForm extends JFrame{
   JLabel la_name,la_age,la_job;
   public JTextField tf_name,tf_age,tf_job;
   
   public JButton bt_submit, bt_cancel;
   
   public InputForm() {
	  setTitle("�Է���");
	  la_name = new JLabel("�̸�");
	  la_age = new JLabel("����");
	  la_job = new JLabel("����");
	  
	  tf_name = new JTextField();
	  tf_age = new JTextField();
	  tf_job = new JTextField();
	  
	  bt_submit = new JButton("�Է�");
	  bt_cancel = new JButton("���");
	  
	  la_name.setBounds(50,30, 30,30);
	  la_age.setBounds(50,80, 30,30);
	  la_job.setBounds(50,130, 30,30);
	  
	  tf_name.setBounds(90,30, 130,30);
	  tf_age.setBounds(90,80, 130,30);
	  tf_job.setBounds(90,130, 130,30);
	  
	  bt_submit.setBounds(60,180, 70,30);
	  bt_cancel.setBounds(140,180, 70,30);	  
	  
	  setLayout(null);	  
	  add(la_name);
	  add(la_age);
	  add(la_job);
	  add(tf_name);
	  add(tf_age);
	  add(tf_job);
	  add(bt_submit);
	  add(bt_cancel);
	  
	  setBounds(500,200,280,280);
	  //setVisible(true);
	  //setDefaultCloseOperation(EXIT_ON_CLOSE);
	
   }//������
  
   public void initText() {//�ؽ�Ʈ�ʵ� �ʱ�ȭ
	  tf_name.setText(""); 
	  tf_age.setText(""); 
	  tf_job.setText("");
	  
	  tf_name.requestFocus();
   }
   
   
}//InputForm




