package com.encore.j0511;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowCloseTest extends Frame implements WindowListener {
	// ������ ���� ��� X��ư �������� ���α׷� ����!! ----> �̺�Ʈ: WindowEvent, �޼ҵ�: windowClosing()

	public WindowCloseTest() {
		setTitle("â�ݱ��׽�Ʈ");

		setSize(350, 300);
		setVisible(true);
		
		//���� ������ ��� (�ҽ�-ó���� ����)
		addWindowListener(this);
	}// ������

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
	
	public static void main(String[] args) {
		new WindowCloseTest();
	}

	@Override
	public void windowOpened(WindowEvent e) {}


	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
}
