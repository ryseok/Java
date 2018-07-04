package com.encore.j0514;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest extends JFrame {
 /*
     AWT: ���������� C���� ����.
               ----> �ü������ �����ϴ� ������Ʈ�� ��� ��.
          ----> java.awt.*;
          
     Swing: �����ڹپ��� ����. (�ü���� ������� ������ ������Ʈ ����)
          ----> javax.swing.*;
          
        Ư¡) awt�� ���Ͽ� ù���ڰ� 'J'�� ����!!
        
     AWT          Swing
    -----------------------
    Button        JButton
    Frame         JFrame
    Checkbox      JCheckbox(X), JCheckBox(O)           
  */
	
   //����ʵ�
   JButton bt;
	
   public SwingTest() {
	  setTitle("Swing�׽�Ʈ"); 
	   
	  bt = new JButton("<html><font size=20 color=blue face=�ü�ü>����ư</font></html>");
	  
	  setLayout(new FlowLayout());
	  add(bt);
	  
      setSize(350,300);
      setVisible(true);
      
      //���� ������ ��� : �̺�Ʈ�ҽ�.add�������̽���(�̺�Ʈ�ڵ鷯��ġ);
      //���� ������ ��� : �̺�Ʈ�ҽ�.add�������̽���(�̺�Ʈ�ڵ鷯��ü);
      //���� ������ ��� : ������.addWindowListener(new WindowListener()); ---> ������ȣ��
      //���� ������ ��� : ������.addWindowListener(new WindowListener(){ });
      //���� ������ ��� : ������.addWindowListener(new WindowAdapter(){ });
      //                                         ----------------
      //                                       �������̽� �Ǵ� Ŭ������ ��ӹ޴� ����Ŭ������ �����ϰڴ�!!
      
      //���� ������ ��� : ������.addWindowListener(class A implements WindowListener{ �������̵��޼ҵ�   });
      //���� ������ ��� : ������.addWindowListener(class A extends WindowAdapter{�ʿ� �������̵��޼ҵ�   });
      
      /*this.addWindowListener(new WindowAdapter() {
    	  @Override
    	public void windowClosing(WindowEvent e) {
    	    System.exit(0);
    	}
      });*/
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // ---> �������� X��ư�� ���� ������ �����ϰڴ�!!
     
   }//������
   
   public static void main(String[] args) {
	  new SwingTest();
   }

}






