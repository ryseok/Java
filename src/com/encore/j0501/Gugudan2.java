package com.encore.j0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gugudan2 {
	BufferedReader in;
	
	public Gugudan2() {
	  //초기화 코드, 선행작업
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	
   //단입력
	public int inputDan() throws IOException{
	  System.out.print("원하는 단? ");	
	  int dan = Integer.parseInt(in.readLine()); //Integer.parseInt("3")  ----> 3
		//parseInt("숫자로 구성된 문자열") ----> 더블quot를 제거해서 숫자변환해 주는 기능
	  
	  //return 정수데이터; ==> 생략불가능
	  return dan;	
	}//inputDan
	
	//단출력(외부에서 받은 단에 대한 1~9까지 곱한 값 출력)
	public void outputDan(int dan) {
	   for(int i=1; i<10; i++) {//1~9
		  System.out.println(dan + "*"+ i +"="+ (dan*i)); 
	   }
		
	   //return; ==> 생략가능	
	}//outputDan
	
	//계속여부
	public char continueDan() throws IOException {
		System.out.print("계속(y/n)? ");
		char ch = in.readLine().charAt(0); //char ch = "y"; 에러 -----> char ch = "y".charAt(0);	
		
		/*
		     char ch1='a';
		     char ch2='b';
		     
		     //두 문자를 비교 ==>  (ch1 == ch2)
		      
		     String str1 = "a"; 
		     String str2 = "b";
		     
		     //두 문자열을 비교 ==>  str1.equals(str2)
		 */
		
	  return ch;
	}//continueDan
}









