package com.encore.j0509;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderTest extends Frame{//방위정렬
   //객체(컴포넌트,컨테이너)선언
   Button bt1,bt2,bt3,bt4,bt5;	
   //Frame f;//null	
   
   public BorderTest(String title) {
	   //super(); 생략
	   super(title);
	   //객체생성
	   bt1 = new Button("1");	   
	   bt2 = new Button("2");	   
	   bt3 = new Button("3");	   
	   bt4 = new Button("4");	   
	   bt5 = new Button("5");	
	   
	   setTitle("타이틀변경~!!");	   
	   
	   //객체에 속성설정(컨테이너에 대한 레이아웃, 컴포넌트 붙이기)
	   //this.setLayout(new BorderLayout());
	   setLayout(new BorderLayout());
	     //BorderLayout(방위정렬)의 경우 컴포넌트를 붙일 위치를 지정!!
	     add("North",bt1);//f.add(String 붙일위치, 붙일 컴포넌트) 
	     add("East",bt2);
	     add("South",bt3);
	     add("West",bt4);
	     add("Center",bt5);
	     
	   //마무리(컨테이너 크기설정, 보이기 설정)
       setSize(300, 300);
       setVisible(true);
   }//생성자
	
   public static void main(String[] args) {
       new BorderTest("Border테스트!!"); //자식은 부모다 ==> BorderTest는 Frame	  new Frame("타이틀!!");
   }
}





