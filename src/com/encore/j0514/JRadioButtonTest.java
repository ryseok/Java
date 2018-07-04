package com.encore.j0514;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class JRadioButtonTest extends JFrame {
   //1. 3개의 JRadioButton객체 생성
   //2. 라디오 버튼을 JPanel에 3행1열로 붙이기
   //3. JPanel에 '패널타이틀' 보더 설정하기.	
   //4. 3개의 라디오 버튼 중 한개 선택하게 하기.(단일 선택)
   //5. JPanel에 tooltip설정. ('라디오버튼 안녕^O^')
   //6. 첫번째 라디오 버튼에 대해 기본아이콘: left.gif  마우스올려졌을때 아이콘: leftrollover.gif
   //   마우스 눌려졌을때 아이콘: leftdown.gif 설정

   JRadioButton rb1,rb2,rb3;
   JPanel panel;
	
   public JRadioButtonTest() {
	  setTitle("라디오버튼테스트"); 
	  ImageIcon icon1 = new ImageIcon("image/left.gif"); 
	  ImageIcon icon2 = new ImageIcon("image/leftrollover.gif"); 
	  ImageIcon icon3 = new ImageIcon("image/leftdown.gif"); 
	  
	  rb1 = new JRadioButton("라디오1", icon1);
	     rb1.setRolloverIcon(icon2);
	     rb1.setPressedIcon(icon3);
	  rb2 = new JRadioButton("라디오2");
	  rb3 = new JRadioButton("라디오3");
	  
	  //그룹묶어주기!!
	  ButtonGroup bg = new ButtonGroup();
	    bg.add(rb1);
	    bg.add(rb2);
	    bg.add(rb3);
	    
	  panel = new JPanel();
	    panel.setLayout(new GridLayout(3, 1));
	    panel.setBorder(new TitledBorder("패널타이틀"));
	    panel.setToolTipText("라디오버튼 안녕^O^");
	    panel.add(rb1);
	    panel.add(rb2);
	    panel.add(rb3);
	    
	  add(panel);//생략 setLayout(new BorderLayout()); add("Center",panel);  
	  
	  setSize(350, 300);
	  setVisible(true);
	  
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
   }//생성자
   
   public static void main(String[] args) {
	  JFrame.setDefaultLookAndFeelDecorated(true); 
	  new JRadioButtonTest();//프레임 객체 생성!!
   }
   	
}
