package com.encore.j0821.di;

public interface FileOutput {
	//인터페이스의 존재이유  ===> 서로 다른 객체의 공통적인 연결 모듈 (자식클래스들을 자유롭게 변경하는 것이 가능)
	//부모 p = new A();   부모 p = new B();  부모 p = new C();
	
	public void output(String str);
}