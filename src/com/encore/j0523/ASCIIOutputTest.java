package com.encore.j0523;

public class ASCIIOutputTest {
	//�ƽ�Ű�ڵ�: �� ���ڿ� �Ҵ�� ������ ���ڰ�
	public static void main(String[] args) {
		for(int i=32; i<127; i++) {
		   System.out.write(i);//�ƽ�Ű���ڿ� �ش��ϴ� �������
		   if(i%8==7)System.out.write('\n');//8���� ���ڸ� ����ϰ� ���κ���
		   else System.out.write('\t');//�� ���ڸ� �������� �� ���
		}
		System.out.flush();
	}//main

}
