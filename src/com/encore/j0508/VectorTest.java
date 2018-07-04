package com.encore.j0508;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
   public static void main(String[] args) {
	  //Vector(int initialCapacity, int capacityIncrement)
	  //initialCapacity:방의크기,  capacityIncrement: 방크기의 증가치
	   
	   Vector v = new Vector(5,3);//벡터 : 데이터를 담는 바구니!!
	   //데이터 ----> element(요소)
	   
	   System.out.println("벡터의 용량(방크기): "+ v.capacity());//5
	   System.out.println("벡터의 요소(입력된 데이터)갯수: "+ v.size());//★0
	   
	   
       //벡터는 객체의 참조(a, new A())를 담는 배열
	   Integer su = new Integer(1);
	   int su2=2;
	   
	   v.addElement(su);
	   v.addElement(su2);
	   
	   for(int i=3; i<10; i++) {//3~9
		   v.addElement(i);
	   }
	   
	   System.out.println("벡터의 용량(방크기): "+ v.capacity());//11
	   System.out.println("벡터의 요소(입력된 데이터)갯수: "+ v.size());//9
	   
	   v.addElement(true);
	   v.addElement(3.14);
	   v.addElement("자바");
	   
	   System.out.println("벡터의 용량(방크기): "+ v.capacity());//14
	   System.out.println("벡터의 요소(입력된 데이터)갯수: "+ v.size());//12
	   
	   //벡터안의 데이터 포함 여부
	   if(v.contains(3.14)) {//요소 포함시 true리턴
		   System.out.println("3.14를 포함");
	   }
	   
	   //벡터의 모든 요소 출력
	   Enumeration enu = v.elements();
	   //Enumeration(열거형 인터페이스) enu=[1,2,3,4,.....,"자바"];
	   System.out.println("------------------------");
	   while(enu.hasMoreElements()) {//요소가 있으면 true리턴
		  System.out.println(enu.nextElement()); 
	   }
	   
   }//main
}






