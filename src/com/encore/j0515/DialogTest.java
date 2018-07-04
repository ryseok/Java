package com.encore.j0515;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogTest extends JFrame implements ActionListener{
   //��ȭ����: �޽�����ȭ����, �Է´�ȭ����, Ȯ�δ�ȭ����
   
   JButton bt1,bt2,bt3;	
	
   public DialogTest() {
	  setTitle("��ȭ�����׽�Ʈ");
	  
	  bt1 = new JButton("�޽���â");
	  bt2 = new JButton("�Է�â");
	  bt3 = new JButton("Ȯ��â");
	  
	  setLayout(new FlowLayout());
	  add(bt1);
	  add(bt2);
	  add(bt3);

	  setBounds(300,200, 300,300);//��ġ, ũ��
	  setVisible(true);
	  
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  
	  bt1.addActionListener(this);
	  bt2.addActionListener(this);
	  bt3.addActionListener(this);
   }//������
   
   @Override
   public void actionPerformed(ActionEvent e) {
	  Object ob = e.getSource();
	  if(ob==bt1) {//'�޽���â'��ư Ŭ����
		//JOptionPane.showMessageDialog(Component parentComponent,Object message); 
		//parentComponent: ��� â�� ��ġ , message: �����ϰ��� �ϴ� �޽���);
		//JOptionPane.showMessageDialog(bt1, "���� ���� �����ϴ�~!!");
		JOptionPane.showMessageDialog(this , "���� ���� �����ϴ�~!!");
		
	  }else if(ob==bt2) {//'�Է�â'��ư Ŭ����
		 //JOptionPane.showInputDialog(Component parentComponent,Object message)
		 String str = JOptionPane.showInputDialog(this,"���ῡ �� �Դ�?");
		 System.out.println("STR="+str);
		 //Ȯ��, ���, X ---> �Է°� �Ǵ� ���ڿ�, null, null
		 JOptionPane.showMessageDialog(this , "["+str+"]���ƿ�~^O^!!");
	  }else if(ob==bt3) {//'Ȯ��â'��ư Ŭ����
		//JOptionPane.showConfirmDialog(Component parentComponent,Object message)
		 int t = JOptionPane.showConfirmDialog(this, "���������Ͻðڽ��ϱ�?");//��Ȯ��,�߰�üũ �뵵
		 System.out.println("T="+ t);
		 //��, �ƴϿ�, ���, X  ---> 0,1,2,-1
		 if(t==0) {
			 System.out.println("����ó�� �Ǿ����ϴ�~!!");
		 }
	  }
   }//actionPerformed
   
   public static void main(String[] args) {
	  new DialogTest();
   }

	
}

