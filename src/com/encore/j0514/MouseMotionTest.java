package com.encore.j0514;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseMotionTest extends JFrame implements MouseMotionListener{
   //���콺���(�����̱�,�巡���ϱ�) �̺�Ʈ �����ϱ�
	
   JLabel green,red;	
	
   public MouseMotionTest() {
	  setTitle("���콺Motion�׽�Ʈ");
	  
	  green = new JLabel("MOVE");
	    green.setBackground(Color.green);
	    green.setOpaque(true);
	  red   = new JLabel("DRAG");
	    red.setBackground(Color.red);
        red.setOpaque(true);
	    
	  //�����̳ʿ� �ٴ� ������Ʈ�� ��ġ�� ����� �����ϱ� ���ؼ��� 
	  //�����̳ʰ� NullLayout�� ������ ��!! ----> �����̳ʸ�.setLayout(null);
	  
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
	  
	  addMouseMotionListener(this);//�������������� ���콺 ������!!
   }//������
   
   @Override
   public void mouseDragged(MouseEvent e) {//���콺 Ŭ���� ���¿����� �̵�
	  //System.out.println("mouseDragged");
	   int x = e.getX();
	   int y = e.getY();
	   
	   red.setLocation(x-10, y-30);
   }
   
   @Override
   public void mouseMoved(MouseEvent e) {//�ܼ� �̵�
	   //System.out.println("mouseMoved");
	   int x = e.getX();
	   int y = e.getY();
	   
	   green.setLocation(x-10, y-30);
   }
   
   public static void main(String[] args) {
	  new MouseMotionTest();
   }

	
}


















