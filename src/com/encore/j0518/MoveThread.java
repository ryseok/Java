package com.encore.j0518;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MoveThread extends JFrame implements Runnable, ActionListener{
   JLabel la;
   JButton bt;
   int x,y;	
   
   public MoveThread() {
     setTitle("MoveThread");
     
     ImageIcon icon = new ImageIcon("image/right.gif");
     la = new JLabel(icon);
       la.setBounds(x,y,55,55);//x,y,가로,세로
     bt = new JButton("시작");
       bt.setBounds(20,420, 80,30);
       
     setLayout(null);
     add(la);
     add(bt);
     
     setBounds(200,200, 500,500);
     setVisible(true);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     
     bt.addActionListener(this);
   }//생성자
   @Override
   public void actionPerformed(ActionEvent e) {
	  //버튼이 클릭되었을때 스레드 호출!!
	  //A a = new A();  a.hello(); ===> new A().hello(); 
	   
	  //Thread t = new Thread(this);
	  //t.start();
	   new Thread(this).start();
   }
   
   @Override
   public void run() { 
	 
	try {
			while(true) {
				  Thread.sleep(50);
				  if(x<=425) {
				    x+=5;
				  }else if(y<=400){
					 y+=5; 
				  }
				  //la.setLocation(x, y);
				  la.setLocation(x, y);
			  }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  
   }//run
   
   
   public static void main(String[] args) {
	  new MoveThread();
   }
}



