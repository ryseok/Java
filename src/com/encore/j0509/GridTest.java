package com.encore.j0509;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridTest extends Frame{
	//Grid: ����,�࿭  ===> 2�� 3���� ��ư ���̱�
   Button b1,b2,b3,b4,b5,b6;	
	
   public GridTest() {
	   setTitle("Grid�׽�Ʈ");
	   
	   b1 = new Button("1");
	   b2 = new Button("2");
	   b3 = new Button("3");
	   b4 = new Button("4");
	   b5 = new Button("5");
	   b6 = new Button("6");
	   
	   //setLayout(new GridLayout());
	   //setLayout(new GridLayout(2,3));  //2�� 3�� ��ġ
	   //setLayout(new GridLayout(int rows,int cols, int hgap, int vgap));  //2�� 3�� ��ġ
	   //rows:���� ��,  cols:���� ��, hgap:�������� ������ ������Ʈ ���� ����, vgap:���� ������Ʈ ���� ����
	   setLayout(new GridLayout(2,3, 10, 0));  //2�� 3�� ��ġ
	   add(b1);
	   add(b2);
	   add(b3);
	   add(b4);
	   add(b5);
	   add(b6);

	   setSize(300, 300);
	   setVisible(true);
   }//������
   
   public static void main(String[] args) {
	   new GridTest();
   }
}
