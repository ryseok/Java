package com.encore.j0502;

public class SwapTest {
    public static void main(String[] args) {
		int a=20;
		int b=40;
		
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		System.out.println("# a�� b�� ������ ��ȯ");
		int temp;
		
		temp=a;
		a   =b;//b������ ���� ���� a�� �Ҵ�
		b   =temp;//a;
		
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		int []arr = {33, 55};
		System.out.println("arr[0]����="+ arr[0]);
		System.out.println("arr[1]����="+ arr[1]);
		System.out.println("# �迭ù��°�� �迭�ι�° ������ ��ȯ");
		
		temp   = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
		System.out.println("arr[0]����="+ arr[0]);
		System.out.println("arr[1]����="+ arr[1]);
		
	}//main
}





