package com.encore.j0514;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseMotionTest extends JFrame implements MouseMotionListener{
   //마우스모션(움직이기,드래그하기) 이벤트 설정하기
	
   JLabel green,red;	
	
   public MouseMotionTest() {
	  setTitle("마우스Motion테스트");
	  
	  green = new JLabel("MOVE");
	    green.setBackground(Color.green);
	    green.setOpaque(true);
	  red   = new JLabel("DRAG");
	    red.setBackground(Color.red);
        red.setOpaque(true);
	    
	  //컨테이너에 붙는 컴포넌트에 위치와 사이즈를 지정하기 위해서는 
	  //컨테이너가 NullLayout을 가져야 함!! ----> 컨테이너명.setLayout(null);
	  
	  //green.setSize(int width,int height);
	  green.setSize(80, 30);
	  //green.setLocation(int x,int y);
	  green.setLocation(30, 30);
	    
	  //red.setBounds(int x, int y,int width,int height);
	  //setBounds : setLocation + setSize
	  red.setBounds(30, 80, 80, 30);
	  
	  setLayout(null);  
	   add(green);
	   add(red);
	  
	  //setSize(600, 600);
	  setBounds(300, 200, 600, 600);
	  setVisible(true);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  
	  addMouseMotionListener(this);//프레임위에서의 마우스 움직임!!
   }//생성자
   
   @Override
   public void mouseDragged(MouseEvent e) {//마우스 클릭한 상태에서의 이동
	  //System.out.println("mouseDragged");
	   int x = e.getX();
	   int y = e.getY();
	   
	   red.setLocation(x-10, y-30);
   }
   
   @Override
   public void mouseMoved(MouseEvent e) {//단순 이동
	   //System.out.println("mouseMoved");
	   int x = e.getX();
	   int y = e.getY();
	   
	   green.setLocation(x-10, y-30);
   }
   
   public static void main(String[] args) {
	  new MouseMotionTest();
   }

	
}


















