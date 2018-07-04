package com.encore.j0514;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MouseEventTest extends JFrame implements MouseListener{
   //컨테이너 또는 컴포넌트 위에서 마우스의 움직임에 따라 정의하는 이벤트.	
   JButton bt;	
	
   public MouseEventTest() {
	  setTitle("마우스이벤트");
	  bt = new JButton("나버튼");
	  
	  setLayout(new FlowLayout());
	  add(bt);
	  
	  setSize(350, 300);
	  setVisible(true);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  
	  //bt.addMouseListener(this);//버튼 위에서의 마우스 움직임!!
	  bt.addMouseListener(new MouseAdapter() {
		  @Override
		public void mouseClicked(MouseEvent e) {
		   System.out.println("마우스클릭!!");    
		}
	  });
   }//생성자
    
   public void mouseClicked(MouseEvent e) {System.out.println("mouseClicked");}
      
   public void mousePressed(MouseEvent e) {System.out.println("mousePressed");}
      
   public void mouseReleased(MouseEvent e) {System.out.println("mouseReleased");}
   
   public void mouseEntered(MouseEvent e) {System.out.println("mouseEntered");}
   
   public void mouseExited(MouseEvent e) {System.out.println("mouseExited");}
   
   
   public static void main(String[] args) {
	  new MouseEventTest();
   }

}




