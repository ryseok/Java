package com.encore.j0821.t2;

public class HelloTest {
	public static void main(String[] args) {
		//부모클래스는 자식클래스
		MessageBean msg;
		//msg = new MessageBeanKo();
		//msg = new MessageBeanEn();
		msg = new MessageBeanVi();
		msg.sayHello("길라임");
	}
}
