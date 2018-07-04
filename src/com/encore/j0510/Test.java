package com.encore.j0510;

public class Test {
    void hello(int no) {
    	if(no==1)System.out.println("¾È³ç~!!");
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
		  //t.ko(); //È­¸é¿¡ "¾È³ç~!!"
		  t.en(); //È­¸é¿¡ "Hello~!!"
	}
}
