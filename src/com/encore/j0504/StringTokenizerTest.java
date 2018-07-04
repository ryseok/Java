package com.encore.j0504;

import java.util.StringTokenizer;

public class StringTokenizerTest {
    public static void main(String[] args) {
	  //StringTokenizer : 문자열 데이터를 특정 구분자(delimiter)로 분리해주는 클래스.
    	
       //StringTokenizer(String str,String delim)
       //str---> 기준문자열(전체문자열),  delim---> 구분자
       //token(토큰) : 분리된 각각의 데이터!!
    	
       String tel="010--5678";
       StringTokenizer st = new StringTokenizer(tel, "-");
       //st = ["010","1234","5678"]
       
       //String nextToken()
      /* 
       System.out.println(st.nextToken());
       System.out.println(st.nextToken());
       System.out.println(st.nextToken());
       System.out.println(st.nextToken());//가져올 토큰데이터가 없을시 에러발생
       */
       
       //st = ["010","1234","5678"]
       while(st.hasMoreTokens()) {//st에 토큰데이터를 가지고 있다면 true리턴
    	   System.out.println(st.nextToken());//토큰 데이터 뽑아오기   
       }
       //-------------------------------------------------------
       //String tel="010-1234-5678";
       //tel.split(String regex) : 특정문자를 통해 데이터를 분리!!
       System.out.println("=========================");
       String [] tels = tel.split("-");//tels[]={"010","1234","5678"}
       for (int i = 0; i < tels.length; i++) {
		  System.out.println("tels["+i+"]="+ tels[i]);
	   }
       
       String sample=null; 
       
       //sample에 대한 숫자조합인지 미리검사
       
       int su=Integer.parseInt(sample);       
       System.out.println("su="+su);
       
	}//main
    
}






