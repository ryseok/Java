package com.encore.j0510;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventTest extends Frame implements ActionListener{
	Button bt1,bt2;
	//이벤트소스: bt1,bt2 ==> Button ==> ActionEvent
	
    public ButtonEventTest() {
      bt1 = new Button("안녕");
      bt2 = new Button("잘가");
      
      setLayout(new FlowLayout());
      add(bt1);
      add(bt2);
      
      setSize(300, 300);
      setVisible(true);
      
      bt1.addActionListener(this);
      bt2.addActionListener(this);
      
      B b = new B();
      C c = new C();
//      bt1.addActionListener(b);
//      bt2.addActionListener(c);
	}//생성자
    
    @Override
    public void actionPerformed(ActionEvent e) {//이벤트 핸들러
    	
       //System.out.println("actionPerformed()");
    	Object ob = e.getSource();//---->  이벤트소스의 정보(주소)를 얻어오는 메소드
    	//만약 bt1을 클릭했다면  Object ob = bt1;
    	//만약 bt2을 클릭했다면  Object ob = bt2;
    	
        if(ob == bt1  ) 
    	  System.out.println("안녕~!!");
    	else //if(ob == bt2)
    	  System.out.println("잘가~!!");
    }
    
    public static void main(String[] args) {
		new ButtonEventTest();
	}

}
