package com.encore.j0509;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderTest extends Frame{//��������
   //��ü(������Ʈ,�����̳�)����
   Button bt1,bt2,bt3,bt4,bt5;	
   //Frame f;//null	
   
   public BorderTest(String title) {
	   //super(); ����
	   super(title);
	   //��ü����
	   bt1 = new Button("1");	   
	   bt2 = new Button("2");	   
	   bt3 = new Button("3");	   
	   bt4 = new Button("4");	   
	   bt5 = new Button("5");	
	   
	   setTitle("Ÿ��Ʋ����~!!");	   
	   
	   //��ü�� �Ӽ�����(�����̳ʿ� ���� ���̾ƿ�, ������Ʈ ���̱�)
	   //this.setLayout(new BorderLayout());
	   setLayout(new BorderLayout());
	     //BorderLayout(��������)�� ��� ������Ʈ�� ���� ��ġ�� ����!!
	     add("North",bt1);//f.add(String ������ġ, ���� ������Ʈ) 
	     add("East",bt2);
	     add("South",bt3);
	     add("West",bt4);
	     add("Center",bt5);
	     
	   //������(�����̳� ũ�⼳��, ���̱� ����)
       setSize(300, 300);
       setVisible(true);
   }//������
	
   public static void main(String[] args) {
       new BorderTest("Border�׽�Ʈ!!"); //�ڽ��� �θ�� ==> BorderTest�� Frame	  new Frame("Ÿ��Ʋ!!");
   }
}





