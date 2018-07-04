package com.encore.j0514;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MouseEventTest extends JFrame implements MouseListener{
   //�����̳� �Ǵ� ������Ʈ ������ ���콺�� �����ӿ� ���� �����ϴ� �̺�Ʈ.	
   JButton bt;	
	
   public MouseEventTest() {
	  setTitle("���콺�̺�Ʈ");
	  bt = new JButton("����ư");
	  
	  setLayout(new FlowLayout());
	  add(bt);
	  
	  setSize(350, 300);
	  setVisible(true);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  
	  //bt.addMouseListener(this);//��ư �������� ���콺 ������!!
	  bt.addMouseListener(new MouseAdapter() {
		  @Override
		public void mouseClicked(MouseEvent e) {
		   System.out.println("���콺Ŭ��!!");    
		}
	  });
   }//������
    
   public void mouseClicked(MouseEvent e) {System.out.println("mouseClicked");}
      
   public void mousePressed(MouseEvent e) {System.out.println("mousePressed");}
      
   public void mouseReleased(MouseEvent e) {System.out.println("mouseReleased");}
   
   public void mouseEntered(MouseEvent e) {System.out.println("mouseEntered");}
   
   public void mouseExited(MouseEvent e) {System.out.println("mouseExited");}
   
   
   public static void main(String[] args) {
	  new MouseEventTest();
   }

}




