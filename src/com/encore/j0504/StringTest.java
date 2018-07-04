package com.encore.j0504;

public class StringTest {
  public static void main(String[] args) {
	
	 //String 문자열 : 문자들의 나열!!
	 String str="JavaProgramming";
	 //인덱스           012345678901234
	 
	 //str.~  String클래스에 있는~
	 
	 //문자열 길이(문자 갯수)
	 System.out.println("str문자열길이(문자갯수): "+ str.length());
	 
	 //부분문자열 ---> "Pro"문자열 얻기
	 System.out.println("str.substring(4,7)="+str.substring(4,7));//beginIndex포함, endIndex불포함
	 
	 //부분문자열 ---> "Programming"문자열 얻기
	 System.out.println("str.substring(4)="+str.substring(4));
	 
	 
	 //특정인덱스의 문자 얻어오기 :char   str.charAt(int index)   
	 System.out.println("str.charAt(4)="+str.charAt(4));
	 
	 //특정문자의 인덱스 얻어오기:int    str.indexOf(int ch)
	 System.out.println("str.indexOf('P')="+str.indexOf('P'));//str.indexOf(97)); //97 == 'a'
	 
	 
	 System.out.println("str.indexOf(\"am\")="+str.indexOf("am"));
	 //문자열에 조건문자가 없다면 -1 리턴!!
	 
	 //String str="JavaProgramming";
	   //인덱스           012345678901234
	 
	 //문자열 치환(대체)
	 //replace(char oldChar, char newChar)
	 System.out.println("str.replace('a', 'o')="+ str.replace('a', 'o'));
	 //str = str.replace('a', 'o');
     System.out.println("STR="+ str);
     
     //"JavaProgramming"  ---> "자바Programming"으로 변경하시오.
     //replace(CharSequence target,CharSequence replacement)
     System.out.println("str.replace(\"Java\", \"자바\")="+ str.replace("Java", "자바"));
	 
     //문자열에 공백 추가!!
     str = "  "+str+"  ";//앞에 공백2개, 뒤에 공백2개
     System.out.println("공백추가후 STR="+ str);
     System.out.println("STR문자열 길이="+ str.length());
     
     //문자열제거!!
     str = str.trim();//좌우 연속된 공백(white space ---> 한개이상의 space,tab,enter의 조합)을 제거      
	 System.out.println("공백제거후 STR문자열 길이= "+ str.length());
  }//main
}







