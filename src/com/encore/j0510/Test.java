package com.encore.j0510;

public class Test {
    void hello(int no) {
    	if(no==1)System.out.println("�ȳ�~!!");
    	else System.out.println("Hello~!!");
    }
    void ko() {
    	hello(1);
    }
    void en() {
    	hello(2);
    }
    public static void main(String[] args) {
		Test t = new Test();
		  //t.ko(); //ȭ�鿡 "�ȳ�~!!"
		  t.en(); //ȭ�鿡 "Hello~!!"
	}
}
