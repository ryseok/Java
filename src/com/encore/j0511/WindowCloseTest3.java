package com.encore.j0511;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowCloseTest3 extends Frame {
	// ������ ���� ��� X��ư �������� ���α׷� ����!! ----> �̺�Ʈ: WindowEvent, �޼ҵ�: windowClosing()

	public WindowCloseTest3() {
		setTitle("â�ݱ��׽�Ʈ3");

		setSize(350, 300);
		setVisible(true);
		//���� ������ ��� (�ҽ�-ó���� ����)
		//public void addWindowListener(WindowListener l)
		//this.addWindowListener(class A implements WindowListener{ 7���޼ҵ� ����});
		//==> this.addWindowListener(new WindowListener() { 7���޼ҵ� ���� });
		
		//this.addWindowListener(class A extends WindowAdapter{�ʿ��� �޼ҵ� ����});
		//==> this.addWindowListener(new WindowAdapter() {�ʿ��� �޼ҵ� ����});
		this.addWindowListener(new WindowAdapter() {//�͸��� ����Ŭ���� anonymous innerŬ����		   
			   public void windowClosing(WindowEvent e) {
					  System.out.println("�͸��� ����Ŭ������ ���� ��� ����");
					  //������Ÿ��Ʋ ����!! ----> "������ �ұ�!!"
		                 
					  System.exit(0);
		  }});
	}// ������	
	
	public static void main(String[] args) {
		new WindowCloseTest3();
	}
}





















