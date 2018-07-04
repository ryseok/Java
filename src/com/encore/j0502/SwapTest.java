package com.encore.j0502;

public class SwapTest {
    public static void main(String[] args) {
		int a=20;
		int b=40;
		
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		System.out.println("# a와 b의 데이터 교환");
		int temp;
		
		temp=a;
		a   =b;//b변수가 갖는 값을 a에 할당
		b   =temp;//a;
		
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		int []arr = {33, 55};
		System.out.println("arr[0]번지="+ arr[0]);
		System.out.println("arr[1]번지="+ arr[1]);
		System.out.println("# 배열첫번째와 배열두번째 데이터 교환");
		
		temp   = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
		System.out.println("arr[0]번지="+ arr[0]);
		System.out.println("arr[1]번지="+ arr[1]);
		
	}//main
}





