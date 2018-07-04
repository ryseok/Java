package com.encore.j0501;

public abstract class Shape {
	
   abstract void draw();//선언된 메소드
	
   void hello() {//정의된 메소드
	   System.out.println("추상 안녕~!!");
   }
}

class Circle extends Shape{
	void draw() { System.out.println("원그리기"); }
}
class Rectangle extends Shape{
	@Override
	void draw() {
	   System.out.println("사각형그리기");	
	}	
}
class Triangle extends Shape{
	@Override
	void draw() {
	   System.out.println("삼각형그리기");	
	}	
}




