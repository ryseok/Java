package com.encore.j0510;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EventTest2 extends Frame{//2.
   Button b;//이벤트소스	
   int cnt;//=0;
   Frame f;
	
   public EventTest2() { 
	  setTitle("이벤트테스트2"); 
	   
	  //객체생성
	  b = new Button("나버튼2");
	  
	  //레이아웃설정
	  setLayout(new FlowLayout());
	  //붙이기
	  add(b);
	  
	  //마무리2
	  setSize(400, 300);
	  setVisible(true);
	  
	  //4. 연결자(메소드) 등록  : 이벤트소스.add인터페이스명(이벤트처리부위치);
	  A a = new A(this);
	  b.addActionListener(a);
	  
   }//생성자
 
   
   public static void main(String[] args) {
	   new EventTest2();
   }

}





