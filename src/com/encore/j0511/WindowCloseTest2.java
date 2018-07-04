package com.encore.j0511;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowCloseTest2 extends WindowAdapter{
	// ������ ���� ��� X��ư �������� ���α׷� ����!! ----> �̺�Ʈ: WindowEvent, �޼ҵ�: windowClosing()
    // WindowAdapter : WindowListener�������̽��� ������ ���� Ŭ����
	Frame f;
	
	public WindowCloseTest2() {
		f = new Frame();
		f.setTitle("â�ݱ��׽�Ʈ2");

		f.setSize(350, 300);
		f.setVisible(true);
		
		//���� ������ ��� (�ҽ�-ó���� ����)
		f.addWindowListener(this);
	}// ������
	
	@Override
	public void windowClosing(WindowEvent e) {
	    System.exit(0);
	}
	
	public static void main(String[] args) {
		new WindowCloseTest2();
	}

}
