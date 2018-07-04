package com.encore.j0514;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest extends JFrame {
 /*
     AWT: 내부적으로 C언어로 구성.
               ----> 운영체제에서 지원하는 컴포넌트를 얻어 옴.
          ----> java.awt.*;
          
     Swing: 순수자바언어로 구성. (운영체제에 상관없이 동일한 컴포넌트 지원)
          ----> javax.swing.*;
          
        특징) awt와 비교하여 첫글자가 'J'로 시작!!
        
     AWT          Swing
    -----------------------
    Button        JButton
    Frame         JFrame
    Checkbox      JCheckbox(X), JCheckBox(O)           
  */
	
   //멤버필드
   JButton bt;
	
   public SwingTest() {
	  setTitle("Swing테스트"); 
	   
	  bt = new JButton("<html><font size=20 color=blue face=궁서체>나버튼</font></html>");
	  
	  setLayout(new FlowLayout());
	  add(bt);
	  
      setSize(350,300);
      setVisible(true);
      
      //연결 감시자 등록 : 이벤트소스.add인터페이스명(이벤트핸들러위치);
      //연결 감시자 등록 : 이벤트소스.add인터페이스명(이벤트핸들러객체);
      //연결 감시자 등록 : 프레임.addWindowListener(new WindowListener()); ---> 생성자호출
      //연결 감시자 등록 : 프레임.addWindowListener(new WindowListener(){ });
      //연결 감시자 등록 : 프레임.addWindowListener(new WindowAdapter(){ });
      //                                         ----------------
      //                                       인터페이스 또는 클래스를 상속받는 내부클래스를 생성하겠다!!
      
      //연결 감시자 등록 : 프레임.addWindowListener(class A implements WindowListener{ 오버라이딩메소드   });
      //연결 감시자 등록 : 프레임.addWindowListener(class A extends WindowAdapter{필요 오버라이딩메소드   });
      
      /*this.addWindowListener(new WindowAdapter() {
    	  @Override
    	public void windowClosing(WindowEvent e) {
    	    System.exit(0);
    	}
      });*/
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // ---> 프레임의 X버튼에 대해 무조건 종료하겠다!!
     
   }//생성자
   
   public static void main(String[] args) {
	  new SwingTest();
   }

}






