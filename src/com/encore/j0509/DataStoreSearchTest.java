package com.encore.j0509;

import java.util.Vector;

public class DataStoreSearchTest {
   public static void main(String[] args) {
	  //데이터저장(주기): set,  데이터조회(얻기): get
	   
	  //변수에 데이터 저장
	   String name="나길동";
	   System.out.println(name);//name은 "나길동"
	   System.out.println("나길동 길이==>"+ name.length());
	   
      //배열에 데이터 저장 
	   //String [] names= {"너길동"};
	   String [] names = new String[3];//names[0]번지~names[2]번지 생성
	      names[0] = "너길동";
	   System.out.println(names[0]);    
	   System.out.println("너길동 길이==>"+ names[0].length());
	   
      //벡터에 데이터 저장 
	  Vector<String> v = new Vector<>();
	     v.add("우리길동");
	   System.out.println(v.get(0));//벡터에 저장된 첫번째 데이터 얻어오기
	   System.out.println("우리길동 길이==>"+ v.get(0).length());
	  //★ name == names[인덱스]  == 벡터명.get(인덱스)  == String데이터!!
	  //       == 빈즈명.getName()
	   
	   
	  //빈즈에 데이터 저장 
        Person p = new Person();//new Person("동에번쩍");
        //p.name="동에번쩍";
        //System.out.println(p.name);
          p.setName("서에번쩍");
       System.out.println(p.getName());
       System.out.println("서에번쩍 길이==>"+ p.getName().length());
   }//main
}











