package com.encore.j0501;

import java.io.IOException;

public class Gugudan {
   //단입력
	public int inputDan() throws IOException{
		
	  System.out.print("원하는 단? ");	
	  int dan = System.in.read()-48;//입력시점
	  //입력: 3엔터 ==> 바이트값: 51, 13, 10	
	  System.in.read();
	  System.in.read();
		
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
		char ch = (char)System.in.read();// a엔터
		                 //바이트 코드값: 97, 13, 10
		         //  (char)97 ---> 'a'
		System.in.read();
		System.in.read();
	   //'a' > 20  ===> 97 > 20		
	   //return '\u0000';		
	   //return 문자데이터;	
	  return ch;
	}//continueDan
}









