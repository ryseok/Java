package com.encore.j0821.di;

public class MessageBeanImpl implements MessageBean {

	private String greeting;
	private String name;

	public MessageBeanImpl() {
		System.out.println("MessageBeanImpl 기본 생성자");
	}
	
	//BeanCreationException ==> 정상
	public MessageBeanImpl(String name) {
		System.out.println("MessageBeanImpl 오버로딩 생성자");
		this.name=name;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public void sayHello() {
		String str = greeting + "," + name;
		System.out.println(str);

	}

}
