package com.encore.j0511;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
   <이벤트처리> ---> 컴포넌트에 기능을 정의하자!!
  1. 이벤트소스(컴포넌트)에 적용할 이벤트 분석  
         Button  bt    ------> ActionEvent 
  2_1. ActionListener(인터페이스)  ------>  implements ActionListener 
  2_2. public void actionPerformed(ActionEvent e){}  ===> 오버라이딩
  3. 연결자메소드 등록         [이벤트소스]  <------- 연결 ------->  [이벤트처리부]
          이벤트소스명.add인터페이스명(이벤트처리부의 위치);
           bt.addActionListener(this);
           
           
  <이벤트처리 방법>   
  1. 기능을 적용할 컴포넌트 찾기 : bt1 
                           ----> 자료형: Button
     ===> 이벤트 소스 찾기!!                           
                           
  2. Button(이벤트소스)클래스의 메소드 중  add~Listener()메소드 찾기!!
                                 ===> addActionListener() !!
  3. 인터페이스 (add제거)==>  ActionListener : implements 하기!!
                                              ===> 메소드 오버라이딩
  4. 연결자 등록!! (2번의 add~Listener()메소드!!)                                             
                                                                               
        
 */



public class EventTest2 extends Frame implements ActionListener{
   Button bt1,bt2;	// addActionListener(ActionListener l)  
	
   public EventTest2() {
	  setTitle("이벤트테스트2"); 
	  bt1 = new Button("안녕");//101호
	   bt1.setActionCommand("first");
	  bt2 = new Button("종료");//201호
	  
	  setLayout(new FlowLayout());
	  add(bt1);
	  add(bt2);
	  
	  setSize(350, 300);
	  setVisible(true);
	  
	  //소스.addActionListener(핸들러);
	  bt1.addActionListener(this);
	  bt2.addActionListener(this);
	  
	  /*
	       public class Button{
	           public void addActionListener(ActionListener l)
	           {
	               while(true){
	                  if(버튼이 눌렸다면){
	                      l.actionPerformed();
	                  }
	               }
	           }
	       }
	   */
	  
   }//생성자
 
   @Override
   public void actionPerformed(ActionEvent e) {//이벤트 핸들러
	   //ActionEvent : 이벤트 발생시킨 소스의 정보를 얻어올 수 있음
	   //String e.getActionCommand();  ---> 컴포넌트에 설정된 ActionCommand을 얻거나
	   //                             Button의 경우 Label을 얻을 수 있음.
	   //또는 Object e.getSource();  ----> 이벤트소스의 참조변수(메모리 할당) 정보
	 /* String str = e.getActionCommand();
	  System.out.println("STR="+ str);
	   
	  System.out.println("bt1="+ bt1); 
	  System.out.println("bt2="+ bt2);
	  
	  System.out.println("이벤트 소스="+ e.getSource());
	  System.out.println("=================");*/
	   
	 Object ob = e.getSource(); 
	 //if(bt1을 눌려서 actionPerformed가 호출되었다면)  
	 if(ob == bt1) //메모리 비교 
      System.out.println("안녕~!!");
	 //else if(bt2을 눌려서 actionPerformed가 호출되었다면)
	 else {//if(ob == bt2)
        System.out.println("종료~!!");
        System.exit(0); //exit(status) ==> status: 0,양수(정상적인 종료)  음수(비정상적인 종료)
	 }
   }
   
   public static void main(String[] args) {
	  new EventTest2();
   }


}





















