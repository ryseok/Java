package com.encore.j0510;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A implements ActionListener{
	Frame f;
	
	public A(Frame f) {
      this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {//�̺�Ʈ ó����
	   System.out.println("AŬ���� ����~!!");	
	   
	   f.setTitle("Ÿ��Ʋ����~!!");
	}

}
