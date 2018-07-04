package com.encore.j0525;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener, Runnable{
   //������Center ---> JTextArea(������ ���� �޽����� ���)
   //������South  ---> JTextField(�������� ���� �޽���), JButton(��ȭ�� ����)	
   JTextField tf;	
   JTextArea ta;
   JScrollPane scrol_ta;
   JButton bt;
   
   JPanel southp;
	
   BufferedReader in;//�����б�
   OutputStream out;//���Ͼ���
   
   public ChatClient() {
	 setTitle("��ȭ��");
	 tf = new JTextField(15);
	 ta = new JTextArea();
	 scrol_ta = new JScrollPane(ta);
	 
	 bt = new JButton("��ȭ����");
	 southp = new JPanel();
	    southp.add(tf);
	    southp.add(bt);
	 
	 add("South", southp );//tf);
	 add("Center",scrol_ta);
	 setBounds(300,200,  300,600);
	 setVisible(true);
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 
	 connectProcess();
	 new Thread(this).start();
	 
	 String nickName = JOptionPane.showInputDialog(this,"��ȭ��:");
	 //���� ��ȭ���� �������� �˸���!! ===> ������ ������(����)  ===> out.write()
	 toServer("100|"+nickName);
	 
	 tf.addActionListener(this);
	 bt.addActionListener(this);
	 
   }//������
   
   public void connectProcess() {//������ �����۾�
	  try {
		Socket s = new Socket("192.168.0.22", 3000);//��3. ���ϼ��� ����
		  
		  //��4. ���� ����� ��ü ����
		  out = s.getOutputStream();//���濡�� �޽����� �����ڴ�.
		  InputStream is = s.getInputStream();//������ ���� �޽����� �аڴ�.
		  in = new BufferedReader(new InputStreamReader(is));
	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
   }//connectProcess
   
   public void run() {//������ �������? GUI�� ������� ������ ���� �޽����� ����ϱ� ���ؼ�
	  try {
		while(true) { 
		    String msg = in.readLine(); //��8.������ ���� (������ ���� ���޵�)�޽��� �б�!!
		    ta.append(msg+"\n");
		    //ta.setCaretPosition(int position);
		    ta.setCaretPosition(ta.getText().length());
		  }
	  } catch (IOException e) {
		e.printStackTrace();
	  }
   }//run
   
   
   public void sendMsg() {//�������� �޽��� ����	   
		String msg = tf.getText().trim();
		if(msg.length() < 1)return;//�� üũ
		   toServer("200|"+msg);//��5. �޽��� ������
		   tf.setText("");
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
	   Object ob = e.getSource();
	   if(ob==tf) {//�������� �޽��� ����
		   sendMsg();
	   }else if(ob==bt) {//'��ȭ����' ��ư Ŭ��
		  String nickName = JOptionPane.showInputDialog(this, "�����ȭ��:");
		  toServer("300|"+nickName);
	   }
   }
   
   
   public void toServer(String msg) {//�������� �޽��� ������
	   try {
		out.write( (msg+"\n").getBytes() );
	  } catch (IOException e) {
		e.printStackTrace();
	  }
   }
   
   public static void main(String[] args) {
	  new ChatClient();
   }

}





