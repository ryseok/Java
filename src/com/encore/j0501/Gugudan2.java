package com.encore.j0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gugudan2 {
	BufferedReader in;
	
	public Gugudan2() {
	  //�ʱ�ȭ �ڵ�, �����۾�
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	
   //���Է�
	public int inputDan() throws IOException{
	  System.out.print("���ϴ� ��? ");	
	  int dan = Integer.parseInt(in.readLine()); //Integer.parseInt("3")  ----> 3
		//parseInt("���ڷ� ������ ���ڿ�") ----> ����quot�� �����ؼ� ���ں�ȯ�� �ִ� ���
	  
	  //return ����������; ==> �����Ұ���
	  return dan;	
	}//inputDan
	
	//�����(�ܺο��� ���� �ܿ� ���� 1~9���� ���� �� ���)
	public void outputDan(int dan) {
	   for(int i=1; i<10; i++) {//1~9
		  System.out.println(dan + "*"+ i +"="+ (dan*i)); 
	   }
		
	   //return; ==> ��������	
	}//outputDan
	
	//��ӿ���
	public char continueDan() throws IOException {
		System.out.print("���(y/n)? ");
		char ch = in.readLine().charAt(0); //char ch = "y"; ���� -----> char ch = "y".charAt(0);	
		
		/*
		     char ch1='a';
		     char ch2='b';
		     
		     //�� ���ڸ� �� ==>  (ch1 == ch2)
		      
		     String str1 = "a"; 
		     String str2 = "b";
		     
		     //�� ���ڿ��� �� ==>  str1.equals(str2)
		 */
		
	  return ch;
	}//continueDan
}









