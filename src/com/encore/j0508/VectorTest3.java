package com.encore.j0508;

import java.util.Vector;

public class VectorTest3 {
	
	//★ Vector에 데이터 추가, 삭제, 수정, 검색하기!!
	public static void main(String[] args) {
	    Vector<String> v = new Vector<>();
	    
	    //데이터 추가
	    v.add("자바");//인덱스 0
	    v.add("SQL");//인덱스 1
	    v.add("HTML");//인덱스 2
	    v.add("JavaScript");//인덱스 3
	    v.add("JSP");//인덱스 4
	    v.add("자바");//인덱스 5
	    
	    //데이터 삭제
	    //v.remove(int index);
	    //v.remove(Object o);
	    //v.remove(0);//첫번째 데이터를 삭제해라!!
	    v.remove("자바");
	    
	    
	    //데이터 수정
	    //v.set(int index,String 대체할element);
	    v.set(4, "자바프로그래밍");//5번째 데이터를 변경!!
	    
	    
	    //데이터 조회
//	    System.out.println("다섯번째 데이터: "+ v.get(4));
//	    System.out.println("여섯번째 데이터: "+ v.get(5));
/*	    for(; 배열명.length ;)//배열의 경우
    	for(; 문자열.length() ;)//문자열의 경우
   		for(; 벡터명.size() ;)//벡터의 경우
*/	    
	    //전체데이터 조회
	    for(int i=0; i<v.size(); i++) {//벡터의 인덱스를 표현
	    	String s = v.get(i);
	       System.out.println(i+":"+s);	
	    }
	    
	}

}




