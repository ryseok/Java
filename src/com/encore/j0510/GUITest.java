package com.encore.j0510;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class GUITest extends Frame{
	           //자식은 부모다!!
	
	Label bt;
	Button bt2;//Button bt=null;
    Frame f;  //Frame f=null;
    
    //프레임 두개 생성!! ---> f프레임, this프레임
    
	
	//생성자 : 초기화(=값할당)메소드
	public GUITest() {
	  System.out.println("생성자~!!");
	  bt = new Label("나버튼");
	  bt2 = new Button("너버튼");
	  f  = new Frame("나타이틀");
	  
	  //속성 설정	   	
	  //배치(Layout)방법 설정
	  //f.setLayout(new BorderLayout());//생략 Border---> 붙일때 위치 지정 
	  f.setLayout(new FlowLayout());
	  
	  //컨테이너명.add(붙일 컴포넌트명);
	  f.add(bt);//---> Border인데 위치를 정하지 않으면  ("Center",bt);
      this.add(bt2);
	  
	  //마무리 2 (컨테이너 사이즈, 보이기 설정)
	  f.setSize(300, 300);
	  f.setVisible(true);
	  
	  this.setSize(300, 300);
	  this.setVisible(true);
	}//생성자	
	
	public static void main(String[] args) {
		new GUITest(); //생성자 호출		
	}
	
	
}
