package com.encore.j0821.di;

public class MessageBeanImpl implements MessageBean{

	private String greeting;
	private String name;
	private FileOutput fo;
	
	public MessageBeanImpl() {
	   System.out.println("MessageBean기본생성자!!");
	}
	
	public MessageBeanImpl(String name) {
		System.out.println("MessageBean오버로딩생성자!!");
		this.name = name;
	}
	
	public void setFo(FileOutput fo) {
		this.fo = fo;
	}
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	@Override
	public void sayHello() {
	   String str = greeting+", "+ name+"!!!";
	   System.out.println(str);//콘솔?
	}
}