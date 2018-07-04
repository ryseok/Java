package com.encore.j0511;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowCloseTest extends Frame implements WindowListener {
	// 프레임 우측 상단 X버튼 눌렀을때 프로그램 종료!! ----> 이벤트: WindowEvent, 메소드: windowClosing()

	public WindowCloseTest() {
		setTitle("창닫기테스트");

		setSize(350, 300);
		setVisible(true);
		
		//감시 연결자 등록 (소스-처리부 연결)
		addWindowListener(this);
	}// 생성자

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
