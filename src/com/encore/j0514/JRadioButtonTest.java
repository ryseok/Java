package com.encore.j0514;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class JRadioButtonTest extends JFrame {
   //1. 3���� JRadioButton��ü ����
   //2. ���� ��ư�� JPanel�� 3��1���� ���̱�
   //3. JPanel�� '�г�Ÿ��Ʋ' ���� �����ϱ�.	
   //4. 3���� ���� ��ư �� �Ѱ� �����ϰ� �ϱ�.(���� ����)
   //5. JPanel�� tooltip����. ('������ư �ȳ�^O^')
   //6. ù��° ���� ��ư�� ���� �⺻������: left.gif  ���콺�÷������� ������: leftrollover.gif
   //   ���콺 ���������� ������: leftdown.gif ����

   JRadioButton rb1,rb2,rb3;
   JPanel panel;
	
   public JRadioButtonTest() {
	  setTitle("������ư�׽�Ʈ"); 
	  ImageIcon icon1 = new ImageIcon("image/left.gif"); 
	  ImageIcon icon2 = new ImageIcon("image/leftrollover.gif"); 
	  ImageIcon icon3 = new ImageIcon("image/leftdown.gif"); 
	  
	  rb1 = new JRadioButton("����1", icon1);
	     rb1.setRolloverIcon(icon2);
	     rb1.setPressedIcon(icon3);
	  rb2 = new JRadioButton("����2");
	  rb3 = new JRadioButton("����3");
	  
	  //�׷칭���ֱ�!!
	  ButtonGroup bg = new ButtonGroup();
	    bg.add(rb1);
	    bg.add(rb2);
	    bg.add(rb3);
	    
	  panel = new JPanel();
	    panel.setLayout(new GridLayout(3, 1));
	    panel.setBorder(new TitledBorder("�г�Ÿ��Ʋ"));
	    panel.setToolTipText("������ư �ȳ�^O^");
	    panel.add(rb1);
	    panel.add(rb2);
	    panel.add(rb3);
	    
	  add(panel);//���� setLayout(new BorderLayout()); add("Center",panel);  
	  
	  setSize(350, 300);
	  setVisible(true);
	  
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
   }//������
   
   public static void main(String[] args) {
	  JFrame.setDefaultLookAndFeelDecorated(true); 
	  new JRadioButtonTest();//������ ��ü ����!!
   }
   	
}
