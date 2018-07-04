package com.encore.j0514;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;







public class GUITest implements ActionListener{
	Button bt1,bt2,bt3;//기능을 부여하고 싶다!!  <===  이벤트 소스
	
	Frame f;
	
    public GUITest() {
        bt1 = new Button("나버튼1");
        bt2 = new Button("나버튼2");
        bt3 = new Button("나버튼3");
        f = new Frame("나프레임");
        
        //f.setLayout(new FlowLayout());
        //f.setLayout(new GridLayout(2,2));
        f.setLayout(new BorderLayout());//프레임의 기본레이아웃, 주의: 붙여질 위치 표시!!
        f.add("Center",bt1);
        f.add("North",bt2);
        f.add("South",bt3);
        
        f.setSize(350, 300);
        f.setVisible(true);
        
        //이벤트소스(~할때)와  이벤트핸들러를 연결!!  ===> 이벤트소스.add인터페이스명(이벤트핸들러위치);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        
	}//생성자
    
    @Override
    public void actionPerformed(ActionEvent e) {//이벤트 처리부 <=== 기능정의
        Object ob = e.getSource();//actionPerformed()메소드를 호출한 이벤트 소스의 레퍼런스 정보 얻기!!
    	
        //조건문 ----> 서로다른 이벤트소스가 동일 메소드를 호출하고 서로 다른 기능을 할때 추가!!
    	if(ob == bt1)//bt1클릭시
    	   System.out.println("1");
    	else if(ob == bt2)//bt2클릭시
           System.out.println("2");
    	else if(ob == bt3)//bt3클릭시
           System.out.println("3");
    	
    }
    
    
    public static void main(String[] args) {
		new GUITest();
	}

}








