package com.encore.j0501;

import java.io.IOException;

public class Gugudan {
   //���Է�
	public int inputDan() throws IOException{
		
	  System.out.print("���ϴ� ��? ");	
	  int dan = System.in.read()-48;//�Է½���
	  //�Է�: 3���� ==> ����Ʈ��: 51, 13, 10	
	  System.in.read();
	  System.in.read();
		
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
		char ch = (char)System.in.read();// a����
		                 //����Ʈ �ڵ尪: 97, 13, 10
		         //  (char)97 ---> 'a'
		System.in.read();
		System.in.read();
	   //'a' > 20  ===> 97 > 20		
	   //return '\u0000';		
	   //return ���ڵ�����;	
	  return ch;
	}//continueDan
}









