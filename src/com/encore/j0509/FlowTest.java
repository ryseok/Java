package com.encore.j0509;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FlowTest {//��� ���� �׽�Ʈ
   //�ʿ��� ��ü(������Ʈ, �����̳�) ����
   Button bt1, bt2, bt3;	
//   Button bt2;	
//   Button bt3;
   Frame f;
	
   public FlowTest() {//������ : �ʱ�ȭ ����
	  //��ü ����
	   //new Button(String label)
	  bt1 = new Button("�ູ��ư1"); 
	  bt2 = new Button("�ູ��ư2"); 
	  bt3 = new Button("�ູ��ư3");
	  
	  //new Frame(String title)
	  f = new Frame("Flow�׽�Ʈ");
	   
	  //�Ӽ�����(����)
	  //�����̳��� ���̾ƿ� ����(Flow,Grid,Border,Card)
	  //FlowLayout fl = new FlowLayout();
	  f.setLayout(new FlowLayout());//fl);	  
	    f.add(bt1);  //�����̳�.add(���� ������Ʈ);
	    f.add(bt2);  //�����̳�.add(���� ������Ʈ);
	    f.add(bt3);  //�����̳�.add(���� ������Ʈ);
	   
	  //������ �޼ҵ� 2��(������â�� ũ��, ������â�� ���̱� ����) 
	  //f.setSize(int width,int height); 
	  f.setSize(300,300);
	  f.setVisible(true);
   }//������
   
   public static void main(String[] args) {
	  //������ ȣ��
	  //FlowTest ft = new FlowTest();
	   
	   new FlowTest();
	   
   }//main
	
}



