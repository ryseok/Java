package com.encore.j0427;

public class InheritanceTest {

	public static void main(String[] args) {
	   Child c = new Child();
	   //자신의 자원
	   System.out.println("J="+ c.j);
	   c.goodBye();
	   c.print();
	   
	   //부모의 자원
	   c.hello();
	   //c.abc();
	   c.toString();
	   System.out.println("==============");
	   Parent p  = new Parent();
	   //자신의 자원
	   p.hello();
	   p.print();
	   
	   //자식의 자원
	   //p.goodBye();//에러발생
	   //부모 참조변수(p)를 통해 자식 접근 불가능!!
	   
	   Parent p2 = new Child();
	   //부                   자

	   p2.hello();
	   p2.print();//----> '자식프린트' 출력
	   //★★만약 메모리에 오버라이딩메소드가 존재한다면 부모의 메소드는 은폐되고
	   //  자식의 메소드로 대체가 된다!!
	   
	   //자식 선언 = 부모데이터  -----> 에러발생!!
	   //Child c2 = new Parent();
	   
	   //Child c2 = (Child)new Parent();
	   //Child c2  = (Child)p;
	   //====>p는 자식에 대한 메모리할당이 없으므로 runtime시 에러발생
	   
	   Child c2 = (Child)p2;
	   //===>p2는 자식에 대한 메모리할당이 있으므로 메모리 포인트만 자식으로 변경
	   
	   
	}//main

}





