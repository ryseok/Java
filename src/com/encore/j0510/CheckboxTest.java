package com.encore.j0510;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;

public class CheckboxTest extends Frame{
   Checkbox cb1,cb2;
   Checkbox cb3,cb4;
   TextArea ta;
   Label la;

   Panel northp,southp;
   
   CheckboxGroup cg;
   
   public CheckboxTest() {
	  //cg = new CheckboxGroup();  
	   
      cb1 = new Checkbox("사과");
      cb2 = new Checkbox("딸기");
      
      //Checkbox(String label, CheckboxGroup group, boolean state) 
      
      cb3 = new Checkbox("남자", new CheckboxGroup(), true);
      cb4 = new Checkbox("여자", new CheckboxGroup(), false);
      
      ta = new TextArea();
      la = new Label("성별:");
      
      northp = new Panel();//기본배치:FlowLayout
      northp.add(cb1);
      northp.add(cb2);
      northp.setBackground(Color.orange);
      
      southp = new Panel();
      southp.add(la);
      southp.add(cb3);
      southp.add(cb4);
      southp.setBackground(Color.MAGENTA);

      //this프레임 기본배치: BorderLayout
      add("North",northp);
      add("Center",ta);
      add("South",southp);
      
      setTitle("체크박스테스트");
      setSize(400, 300);
      setVisible(true);
   }//생성자
   public static void main(String[] args) {
	  new CheckboxTest();
   }
}