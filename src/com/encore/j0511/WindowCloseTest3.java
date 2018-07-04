package com.encore.j0511;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowCloseTest3 extends Frame {
	// 프레임 우측 상단 X버튼 눌렀을때 프로그램 종료!! ----> 이벤트: WindowEvent, 메소드: windowClosing()

	public WindowCloseTest3() {
		setTitle("창닫기테스트3");

		setSize(350, 300);
		setVisible(true);
		//감시 연결자 등록 (소스-처리부 연결)
		//public void addWindowListener(WindowListener l)
		//this.addWindowListener(class A implements WindowListener{ 7개메소드 구현});
		//==> this.addWindowListener(new WindowListener() { 7개메소드 구현 });
		
		//this.addWindowListener(class A extends WindowAdapter{필요한 메소드 구현});
		//==> this.addWindowListener(new WindowAdapter() {필요한 메소드 구현});
		this.addWindowListener(new WindowAdapter() {//익명의 내부클래스 anonymous inner클래스		   
			   public void windowClosing(WindowEvent e) {
					  System.out.println("익명의 내부클래스를 통한 기능 구현");
					  //프레임타이틀 변경!! ----> "오늘은 불금!!"
		                 
					  System.exit(0);
		  }});
	}// 생성자	
	
	public static void main(String[] args) {
		new WindowCloseTest3();
	}
}





















