package com.encore.j0514;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class JCheckBoxTest extends JFrame{
    
	JCheckBox cb1,cb2,cb3;
	
	JPanel panel;
	
	public JCheckBoxTest() {
	   ImageIcon icon1 = new ImageIcon("image/left.gif");	
	   ImageIcon icon2 = new ImageIcon("image/leftrollover.gif");	
	   ImageIcon icon3 = new ImageIcon("image/leftdown.gif");
	   
	   ImageIcon icon4 = new ImageIcon("image/right.gif");	
	   ImageIcon icon5 = new ImageIcon("image/rightrollover.gif");	
	   ImageIcon icon6 = new ImageIcon("image/rightdown.gif");
	   
	   ImageIcon cb = new ImageIcon("image/cb.gif");	
	   ImageIcon cbr = new ImageIcon("image/cbr.gif");	
	   ImageIcon cbrs = new ImageIcon("image/cbrs.gif");	
		
	   //cb1 = new JCheckBox("ù��°üũ�ڽ�");
	   //JCheckBox(String text,Icon icon)
	   cb1 = new JCheckBox("ù��°üũ�ڽ�", icon1);
	     cb1.setRolloverIcon(icon2);
	     cb1.setSelectedIcon(icon3);
	   
	   cb2 = new JCheckBox("�ι�°üũ�ڽ�", icon4);
	     cb2.setRolloverIcon(icon5);
	     cb2.setSelectedIcon(icon6);
	   
	     cb2.setToolTipText("�ι�°üũ�ڽ� ������ ����");//ToolTip: ǳ������
	     
	   cb3 = new JCheckBox("����°üũ�ڽ�",cb);
	     cb3.setRolloverIcon(cbr);
	     cb3.setSelectedIcon(cbrs);

	   panel = new JPanel();
	   //panel.setBorder(new TitledBorder("�г�Ÿ��Ʋ"));
	   //panel.setBorder(new BevelBorder(BevelBorder.RAISED));//�簢
	   //BevelBorder: ���簢 ǥ��
	   //TitledBorder(Border border, String title) 
	   
	   panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED)
			                                            ,"�г�Ÿ��Ʋ"));
	   
	   panel.setLayout(new GridLayout(3,1));
	     panel.add(cb1);
	     panel.add(cb2);
	     panel.add(cb3);
	     
	   setTitle("üũ�ڽ��׽�Ʈ");  
	   add(panel);  
	   
	   setSize(350,300);
	   setVisible(true);
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   
	}//������
	
	public static void main(String[] args) {
		new JCheckBoxTest();
	}
}


