package com.encore.j0501;

abstract class GrandParent{
	public GrandParent() {
	   System.out.println("���θ������");
	}
	public void print() {System.out.println("����Ʈ");}//���ǵ� �޼ҵ�
	public abstract void abc();
}

abstract class Parent extends GrandParent{
	public Parent(String name) {
		 //super();
	   System.out.println("�θ������");
	}
	public void hello() {System.out.println("�ȳ�");}
	public abstract void def();
}

class Child extends Parent{
	public Child() {
		//super();
		super("�̸�");
	   System.out.println("�ڽĻ�����");
	}
	public void good() {System.out.println("����~!!");}
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




