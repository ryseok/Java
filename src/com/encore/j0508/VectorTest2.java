package com.encore.j0508;

import java.util.Vector;

class A{
   void hello() {
	  System.out.println("A클래스안녕~!!"); 
   }
}

public class VectorTest2 {
   public static void main(String[] args) {
	  Vector v = new Vector();
	    v.add("안녕");//인덱스 0부여
	    v.add(new A());//인덱스 1부여
	    
	    //v.get(int index)
	    Object ob = v.get(1);//두번째 데이터 얻기
	    //ob.hello(); //------> 에러발생!! --> 왜? 부모 참조변수를 통해 자식 호출 불가!!
	    A a = (A)ob;
	    a.hello();
	    
	  //Vector<A> v2 = new Vector<A>();//---> v2에는 A클래스객체만 담겠습니다!!
	  Vector<A> v2 = new Vector<>();// JDK7버전부터 <> 빈 괄호 지원
	      v2.add(new A());//인덱스0
	      A obj = new A();
	      v2.add(obj);//인덱스1
	      
	      A aa = v2.get(1); 
	        aa.hello();
	        v2.get(1).hello();
	  
	  
	  /*
	      <>: 제네릭 타입 ---> 어떤 자료형을 사용할 지를 명시(명료성을 높임)  JDK5부터 지원
	      
	      <E> : element(요소)가 어떤 자료형을 사용할 지 명시.
	      <K> : key가 어떤 자료형을 사용할 지 명시.
	      <V> : value가 어떤 자료형을 사용할 지 명시.
	      <T> : type에 어떤 자료형을 사용할 지 명시.
	   */
  }
}







 