package com.encore.j0509;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class TextFieldAreaTest extends Frame{
   //객체선언
   TextField tf1,tf2;//=null;
   TextArea ta;//=null;
   Label la;
   Panel p,northp;//왜? 한영역에 두개 이상의 컴포넌트를 붙일때
                  //    컴포넌트 속성을 지정하기 위해서
	
   public TextFieldAreaTest() {
	setTitle("TextFiedArea테스트");   
	   
    //객체생성
	//new TextField(int columns) ----> columns : 열길이
	//new TextField(String 기본text, int columns)
	tf1 = new TextField("기본값",10);  
	 tf1.setFont(new Font("굴림체",Font.BOLD,30));
	tf2 = new TextField(10);
	
	ta = new TextArea();
	la = new Label("파일이름:");

	p = new Panel();//작은 도화지
	 p.setLayout(new FlowLayout());//가운데 정렬
	 p.add(la);
	 p.add(tf2);
	 
	p.setBackground(Color.PINK);//Color.YELLOW);//new Color(255,255,0)); 
	p.setForeground(Color.red); 
	
	northp = new Panel();
	//바탕색 설정 ---> background,   글자색 설정 ---> foreground
	//Color(int r, int g, int b)
	Color c = new Color(0,255,0); 
	//northp.setBackground(Color c);
	northp.setBackground(c);
	 northp.add(tf1);
	
	setLayout(new BorderLayout());//컨테이너 레이아웃 설정
	//보더레이아웃경우  붙일때 위치 지정
	//add("North",tf1);
	add("North",northp);
	add("Center", ta);
//	add("South", la);
//	add("South", tf2);
	add("South", p);
	
	//마무리(사이즈,보이기 설정)
	setSize(400, 300);
	setVisible(true);
   }//생성자
   
   public static void main(String[] args) {
	  new TextFieldAreaTest();
   }
}




