package com.encore.j0510;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class GUITest extends Frame{
	           //�ڽ��� �θ��!!
	
	Label bt;
	Button bt2;//Button bt=null;
    Frame f;  //Frame f=null;
    
    //������ �ΰ� ����!! ---> f������, this������
    
	
	//������ : �ʱ�ȭ(=���Ҵ�)�޼ҵ�
	public GUITest() {
	  System.out.println("������~!!");
	  bt = new Label("����ư");
	  bt2 = new Button("�ʹ�ư");
	  f  = new Frame("��Ÿ��Ʋ");
	  
	  //�Ӽ� ����	   	
	  //��ġ(Layout)��� ����
	  //f.setLayout(new BorderLayout());//���� Border---> ���϶� ��ġ ���� 
	  f.setLayout(new FlowLayout());
	  
	  //�����̳ʸ�.add(���� ������Ʈ��);
	  f.add(bt);//---> Border�ε� ��ġ�� ������ ������  ("Center",bt);
      this.add(bt2);
	  
	  //������ 2 (�����̳� ������, ���̱� ����)
	  f.setSize(300, 300);
	  f.setVisible(true);
	  
	  this.setSize(300, 300);
	  this.setVisible(true);
	}//������	
	
	public static void main(String[] args) {
		new GUITest(); //������ ȣ��		
	}
	
	
}
