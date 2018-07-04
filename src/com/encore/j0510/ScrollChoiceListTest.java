package com.encore.j0510;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.Scrollbar;

public class ScrollChoiceListTest extends Frame{
   Label la;
   Scrollbar sb;
   Choice cho;
   List list;
   
   Panel topp, smallp, bottomp;
   
   public ScrollChoiceListTest() {
      la = new Label("초록");
      //Scrollbar(int orientation, int value, int visible, int minimum, int maximum) 
      //orientation: 수평 또는 수직, value: 조절바의 위치
      //visible: 조절바의 너비, minimum: 최소위치   maximum: 최대위치
      sb = new Scrollbar(Scrollbar.HORIZONTAL, 100, 10, 0, 200);
      cho = new Choice();
        cho.add("서울");
        cho.add("대구");
        cho.add("부산");
        cho.add("광주");
        cho.add("제주");
        
        list = new List();
      //list = new List(int rows); 
      //list = new List(3); 
      //list = new List(int rows,boolean multipleMode)
        //rows: 보여질  행의 수, multipleMode: 다중선택
      list = new List(8,true);
        //list.setMultipleMode(true);
        
        list.add("야구");
        list.add("축구");
        list.add("농구");
        list.add("배구");
        list.add("야구2");
        list.add("축구2");
        list.add("농구2");
        list.add("배구2");
      
      smallp = new Panel();
       smallp.setLayout(new BorderLayout());//West,Center
       smallp.setBackground(Color.MAGENTA);
       smallp.add("West",la);
       smallp.add("Center",sb);
      
      topp = new Panel();//패널 기본레이아웃: FlowLayout
      //new GridLayout(int rows,int cols,int hgap,int vgap)
      topp.setLayout(new GridLayout(3,1,0,20));
      topp.setBackground(Color.GREEN);
       //topp.add(la);
       //topp.add(sb);
       topp.add(new Label());//빈 공간을 표현
       topp.add(smallp);
      
      bottomp = new Panel();
       bottomp.add(list);
       bottomp.setBackground(Color.ORANGE);
       
       
      //this==프레임 : 기본레이아웃: BorderLayout
      setLayout(new GridLayout(3, 1));
      add(topp);
      add(cho);
      //add(list);
      add(bottomp);
	  
      setTitle("비주얼컴포넌트테스트");
      setSize(400, 550);
      setVisible(true);
   }//생성자
	
   public static void main(String[] args) {
	  new ScrollChoiceListTest();
   }	
	
}
