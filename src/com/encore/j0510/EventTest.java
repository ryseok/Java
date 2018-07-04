package com.encore.j0510;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
   <이벤트처리> 기능부여
   1. 컴포넌트에 적용할 이벤트 분석
       ---> 어떤 컴포넌트를 이벤트 소스로 사용?
       ---> Button ---> ActionEvent
       
   2. 인터페이스 만들기!!
      ActionEvent - Event : Action + Listener  ==> ActionListener (인터페이스)    
 */
public class EventTest extends Frame  implements ActionListener{//2.
   Button b;//이벤트소스	
   int cnt;//=0;
	
   public EventTest() { 
	  setTitle("이벤트테스트"); 
	   
	  //객체생성
	  b = new Button("나버튼");
	  
	  //레이아웃설정
	  setLayout(new FlowLayout());
	  //붙이기
	  add(b);
	  
	  //마무리2
	  setSize(400, 300);
	  setVisible(true);
	  
	  //4. 연결자(메소드) 등록  : 이벤트소스.add인터페이스명(이벤트처리부위치);
	  b.addActionListener(this); //4.
	  
   }//생성자
   
   @Override
   public void actionPerformed(ActionEvent e) {//이벤트 처리부!!  3.
	  System.out.println("이벤트 안녕~!!");
	  
	  cnt++;
	  //프레임 타이틀을 변경  : 이벤트테스트-1, 이벤트테스트-2
	  //setTitle("타이틀변경");
	  setTitle("이벤트테스트-"+ cnt);
	  
	  add(new Button("추가버튼["+cnt+"]"));
	  setVisible(true);
   }
   
   public static void main(String[] args) {
	   new EventTest();
   }

}
