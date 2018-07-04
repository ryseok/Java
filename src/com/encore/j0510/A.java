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
	public void actionPerformed(ActionEvent e) {//이벤트 처리부
	   System.out.println("A클래스 만세~!!");	
	   
	   f.setTitle("타이틀변경~!!");
	}

}
