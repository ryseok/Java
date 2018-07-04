package com.encore.j0509;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FlowTest {//가운데 정렬 테스트
   //필요한 객체(컴포넌트, 컨테이너) 선언
   Button bt1, bt2, bt3;	
//   Button bt2;	
//   Button bt3;
   Frame f;
	
   public FlowTest() {//생성자 : 초기화 관련
	  //객체 생성
	   //new Button(String label)
	  bt1 = new Button("행복버튼1"); 
	  bt2 = new Button("행복버튼2"); 
	  bt3 = new Button("행복버튼3");
	  
	  //new Frame(String title)
	  f = new Frame("Flow테스트");
	   
	  //속성지정(설정)
	  //컨테이너의 레이아웃 설정(Flow,Grid,Border,Card)
	  //FlowLayout fl = new FlowLayout();
	  f.setLayout(new FlowLayout());//fl);	  
	    f.add(bt1);  //컨테이너.add(붙일 컴포넌트);
	    f.add(bt2);  //컨테이너.add(붙일 컴포넌트);
	    f.add(bt3);  //컨테이너.add(붙일 컴포넌트);
	   
	  //마무리 메소드 2개(프레임창의 크기, 프레임창의 보이기 설정) 
	  //f.setSize(int width,int height); 
	  f.setSize(300,300);
	  f.setVisible(true);
   }//생성자
   
   public static void main(String[] args) {
	  //생성자 호출
	  //FlowTest ft = new FlowTest();
	   
	   new FlowTest();
	   
   }//main
	
}



