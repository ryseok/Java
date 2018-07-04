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
      la = new Label("�ʷ�");
      //Scrollbar(int orientation, int value, int visible, int minimum, int maximum) 
      //orientation: ���� �Ǵ� ����, value: �������� ��ġ
      //visible: �������� �ʺ�, minimum: �ּ���ġ   maximum: �ִ���ġ
      sb = new Scrollbar(Scrollbar.HORIZONTAL, 100, 10, 0, 200);
      cho = new Choice();
        cho.add("����");
        cho.add("�뱸");
        cho.add("�λ�");
        cho.add("����");
        cho.add("����");
        
        list = new List();
      //list = new List(int rows); 
      //list = new List(3); 
      //list = new List(int rows,boolean multipleMode)
        //rows: ������  ���� ��, multipleMode: ���߼���
      list = new List(8,true);
        //list.setMultipleMode(true);
        
        list.add("�߱�");
        list.add("�౸");
        list.add("��");
        list.add("�豸");
        list.add("�߱�2");
        list.add("�౸2");
        list.add("��2");
        list.add("�豸2");
      
      smallp = new Panel();
       smallp.setLayout(new BorderLayout());//West,Center
       smallp.setBackground(Color.MAGENTA);
       smallp.add("West",la);
       smallp.add("Center",sb);
      
      topp = new Panel();//�г� �⺻���̾ƿ�: FlowLayout
      //new GridLayout(int rows,int cols,int hgap,int vgap)
      topp.setLayout(new GridLayout(3,1,0,20));
      topp.setBackground(Color.GREEN);
       //topp.add(la);
       //topp.add(sb);
       topp.add(new Label());//�� ������ ǥ��
       topp.add(smallp);
      
      bottomp = new Panel();
       bottomp.add(list);
       bottomp.setBackground(Color.ORANGE);
       
       
      //this==������ : �⺻���̾ƿ�: BorderLayout
      setLayout(new GridLayout(3, 1));
      add(topp);
      add(cho);
      //add(list);
      add(bottomp);
	  
      setTitle("���־�������Ʈ�׽�Ʈ");
      setSize(400, 550);
      setVisible(true);
   }//������
	
   public static void main(String[] args) {
	  new ScrollChoiceListTest();
   }	
	
}
