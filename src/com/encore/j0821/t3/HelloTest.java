package com.encore.j0821.t3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloTest {
	public static void main(String[] args) {
		//클래스(Bean)를 관리하는 XML 읽기
		ApplicationContext ctx = new GenericXmlApplicationContext("com/encore/j0821/t3/applicationContext.xml");
		
		 //XML문서에 정의된 Bean 가져오기 ===>ctx.getBean("정의된 id명");
		 //방법1
		 MessageBean msg = (MessageBean) ctx.getBean("msgBean");
			
		 //방법2
		 //MessageBean msg = ctx.getBean("msgBean", MessageBean.class);
		 msg.sayHello("김주원");
	}
}
