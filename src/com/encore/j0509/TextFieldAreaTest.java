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
   //��ü����
   TextField tf1,tf2;//=null;
   TextArea ta;//=null;
   Label la;
   Panel p,northp;//��? �ѿ����� �ΰ� �̻��� ������Ʈ�� ���϶�
                  //    ������Ʈ �Ӽ��� �����ϱ� ���ؼ�
	
   public TextFieldAreaTest() {
	setTitle("TextFiedArea�׽�Ʈ");   
	   
    //��ü����
	//new TextField(int columns) ----> columns : ������
	//new TextField(String �⺻text, int columns)
	tf1 = new TextField("�⺻��",10);  
	 tf1.setFont(new Font("����ü",Font.BOLD,30));
	tf2 = new TextField(10);
	
	ta = new TextArea();
	la = new Label("�����̸�:");

	p = new Panel();//���� ��ȭ��
	 p.setLayout(new FlowLayout());//��� ����
	 p.add(la);
	 p.add(tf2);
	 
	p.setBackground(Color.PINK);//Color.YELLOW);//new Color(255,255,0)); 
	p.setForeground(Color.red); 
	
	northp = new Panel();
	//������ ���� ---> background,   ���ڻ� ���� ---> foreground
	//Color(int r, int g, int b)
	Color c = new Color(0,255,0); 
	//northp.setBackground(Color c);
	northp.setBackground(c);
	 northp.add(tf1);
	
	setLayout(new BorderLayout());//�����̳� ���̾ƿ� ����
	//�������̾ƿ����  ���϶� ��ġ ����
	//add("North",tf1);
	add("North",northp);
	add("Center", ta);
//	add("South", la);
//	add("South", tf2);
	add("South", p);
	
	//������(������,���̱� ����)
	setSize(400, 300);
	setVisible(true);
   }//������
   
   public static void main(String[] args) {
	  new TextFieldAreaTest();
   }
}




