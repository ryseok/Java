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
	   
      cb1 = new Checkbox("���");
      cb2 = new Checkbox("����");
      
      //Checkbox(String label, CheckboxGroup group, boolean state) 
      
      cb3 = new Checkbox("����", new CheckboxGroup(), true);
      cb4 = new Checkbox("����", new CheckboxGroup(), false);
      
      ta = new TextArea();
      la = new Label("����:");
      
      northp = new Panel();//�⺻��ġ:FlowLayout
      northp.add(cb1);
      northp.add(cb2);
      northp.setBackground(Color.orange);
      
      southp = new Panel();
      southp.add(la);
      southp.add(cb3);
      southp.add(cb4);
      southp.setBackground(Color.MAGENTA);

      //this������ �⺻��ġ: BorderLayout
      add("North",northp);
      add("Center",ta);
      add("South",southp);
      
      setTitle("üũ�ڽ��׽�Ʈ");
      setSize(400, 300);
      setVisible(true);
   }//������
   public static void main(String[] args) {
	  new CheckboxTest();
   }
}