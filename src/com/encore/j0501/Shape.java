package com.encore.j0501;

public abstract class Shape {
	
   abstract void draw();//����� �޼ҵ�
	
   void hello() {//���ǵ� �޼ҵ�
	   System.out.println("�߻� �ȳ�~!!");
   }
}

class Circle extends Shape{
	void draw() { System.out.println("���׸���"); }
}
class Rectangle extends Shape{
	@Override
	void draw() {
	   System.out.println("�簢���׸���");	
	}	
}
class Triangle extends Shape{
	@Override
	void draw() {
	   System.out.println("�ﰢ���׸���");	
	}	
}




