package com.encore.j0509;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridTest extends Frame{
	//Grid: 격자,행열  ===> 2행 3열에 버튼 붙이기
   Button b1,b2,b3,b4,b5,b6;	
	
   public GridTest() {
	   setTitle("Grid테스트");
	   
	   b1 = new Button("1");
	   b2 = new Button("2");
	   b3 = new Button("3");
	   b4 = new Button("4");
	   b5 = new Button("5");
	   b6 = new Button("6");
	   
	   //setLayout(new GridLayout());
	   //setLayout(new GridLayout(2,3));  //2행 3열 배치
	   //setLayout(new GridLayout(int rows,int cols, int hgap, int vgap));  //2행 3열 배치
	   //rows:행의 수,  cols:열의 수, hgap:수평으로 놓여진 컴포넌트 사이 간격, vgap:수직 컴포넌트 사이 간격
	   setLayout(new GridLayout(2,3, 10, 0));  //2행 3열 배치
	   add(b1);
	   add(b2);
	   add(b3);
	   add(b4);
	   add(b5);
	   add(b6);

	   setSize(300, 300);
	   setVisible(true);
   }//생성자
   
   public static void main(String[] args) {
	   new GridTest();
   }
}
