package com.encore.j0821.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloTest {
	public static void main(String[] args) {
		//applicationContext.xml에 등록된 클래스를 사용할 준비작업 끝
		ApplicationContext ctx = new GenericXmlApplicationContext("com/encore/j0821/di/applicationContext.xml");
		
		MessageBean msg =  (MessageBean) ctx.getBean("msgBean");
		msg.sayHello();
	}
}
