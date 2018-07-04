package com.encore.j0523;

public class ASCIIOutputTest {
	//아스키코드: 각 문자에 할당된 고유의 숫자값
	public static void main(String[] args) {
		for(int i=32; i<127; i++) {
		   System.out.write(i);//아스키숫자에 해당하는 문자출력
		   if(i%8==7)System.out.write('\n');//8개의 문자를 출력하고 라인변경
		   else System.out.write('\t');//각 문자를 일정간격 띄어서 출력
		}
		System.out.flush();
	}//main

}
