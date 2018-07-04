package com.encore.j0501;

abstract class GrandParent{
	public GrandParent() {
	   System.out.println("조부모생성자");
	}
	public void print() {System.out.println("프린트");}//정의된 메소드
	public abstract void abc();
}

abstract class Parent extends GrandParent{
	public Parent(String name) {
		 //super();
	   System.out.println("부모생성자");
	}
	public void hello() {System.out.println("안녕");}
	public abstract void def();
}

class Child extends Parent{
	public Child() {
		//super();
		super("이름");
	   System.out.println("자식생성자");
	}
	public void good() {System.out.println("좋아~!!");}
	@Override
	public void def() {	}
	@Override
	public void abc() { }
}

public class MemoryAllocateTest {
   public static void main(String[] args) {
	   Child c = new Child();
	   System.out.println("==================");
	     c.good();
	     c.hello();
	     c.print();
   }
}




