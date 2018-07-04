package com.encore.j0430;

import com.encore.j0427.Parent;

public class MyCallTest {
    public static void main(String[] args) {
    	Parent p;
		//m1()메소드 호출
    	
       /*
            클래스를 사용(=클래스내에 필드,메소드 사용)하려면?
       ===> 클래스 객체생성(메모리할당)?
       1. static (정적메모리 할당)
          ---> 자주 사용되는 요소(필드,메소드)에 대해 미리 메모리 할당
          ---> 요소 접근시(사용시) 클래스명.~ 으로 접근
       2. new    (동적메모리 할당)
          ---> 변수명으로 접근   obj.~  a.~
            
        */
       My.m1();
       int i = My.su;
       //i : 속성변수 (데이터를 담는 변수)
       
       System.out.println("i="+i);
       System.out.println("su="+ My.su);
       
       My m = new My();
       //m: 참조변수, reference변수 (메모리를 참조하는 변수)
       //m.~ : My클래스에 있는~
       
       m.m2();
       m.m3(20);//메소드 호출시 괄호안에 데이터를 전달할 수 있음
             
       m.m4("홍길동");
       
       m.m5("길라임", 15);
       
       A aa = new A();
       m.m6(aa);
       
       m.m6(new A());
       
       
       m.m7("길동", "라임", "주원");
       
       String []names= {"홍길동",  "길라임","김주원", "이순신"};
         //접근은 번지로!! names[0]  names[1] names[2]
//배열(Array): 동일한 자료형을 갖는 데이터들을 한개의 변수명으로 정의한 자료들의 집합     
       m.m7_2(names);
       
       int sum= m.m11();
       System.out.println("sum="+ sum);
       
       String result = m.m12();
       System.out.println("result="+ result);
       
       A obj = m.m13();
        obj.hello();
        
       int [] array = m.m14();
       
       //배열은 for문과 친하다!! ---> index표현 용이
       for (int j = 0; j < array.length; j++) {
		 System.out.println("array["+j+"]번지="+ array[j]);
	   }
       
       
	}//main
}//MyCallTest









