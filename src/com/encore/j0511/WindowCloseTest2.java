package com.encore.j0511;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowCloseTest2 extends WindowAdapter{
	// 프레임 우측 상단 X버튼 눌렀을때 프로그램 종료!! ----> 이벤트: WindowEvent, 메소드: windowClosing()
    // WindowAdapter : WindowListener인터페이스를 구현해 놓은 클래스
	Frame f;
	
	public WindowCloseTest2() {
		f = new Frame();
		f.setTitle("창닫기테스트2");

		f.setSize(350, 300);
		f.setVisible(true);
		
		//감시 연결자 등록 (소스-처리부 연결)
		f.addWindowListener(this);
	}// 생성자
	
	@Override
	public void windowClosing(WindowEvent e) {
	    System.exit(0);
	}
	
	public static void main(String[] args) {
		new WindowCloseTest2();
	}

}
