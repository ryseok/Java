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
		
	   //cb1 = new JCheckBox("첫번째체크박스");
	   //JCheckBox(String text,Icon icon)
	   cb1 = new JCheckBox("첫번째체크박스", icon1);
	     cb1.setRolloverIcon(icon2);
	     cb1.setSelectedIcon(icon3);
	   
	   cb2 = new JCheckBox("두번째체크박스", icon4);
	     cb2.setRolloverIcon(icon5);
	     cb2.setSelectedIcon(icon6);
	   
	     cb2.setToolTipText("두번째체크박스 영역에 진입");//ToolTip: 풍선도움말
	     
	   cb3 = new JCheckBox("세번째체크박스",cb);
	     cb3.setRolloverIcon(cbr);
	     cb3.setSelectedIcon(cbrs);

	   panel = new JPanel();
	   //panel.setBorder(new TitledBorder("패널타이틀"));
	   //panel.setBorder(new BevelBorder(BevelBorder.RAISED));//양각
	   //BevelBorder: 음양각 표현
	   //TitledBorder(Border border, String title) 
	   
	   panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED)
			                                            ,"패널타이틀"));
	   
	   panel.setLayout(new GridLayout(3,1));
	     panel.add(cb1);
	     panel.add(cb2);
	     panel.add(cb3);
	     
	   setTitle("체크박스테스트");  
	   add(panel);  
	   
	   setSize(350,300);
	   setVisible(true);
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   
	}//생성자
	
	public static void main(String[] args) {
		new JCheckBoxTest();
	}
}


