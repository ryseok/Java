package com.encore.j0502;

public class ArrayTest {
  public static void main(String[] args) {
	 //�迭����� �ʱ�ȭ
	 //int []su;
	  //      su={1,    2,    3,   4,    5};
	  //�����߻�: �ݵ�� ����� �ʱ�ȭ�� �Բ� ���!! (X)      
	 int []su = {1,    2,    3,    4,    5,    6,7,8,9};
	         //su[0] su[1] su[2] su[3] su[4]
	 
	 System.out.println("su[0]����="+su[0]);//ù��°������ ���
	 System.out.println("su[1]����="+su[1]);//�ι�°������ ���
	 System.out.println("su[2]����="+su[2]);//����°������ ���
	 System.out.println("su[3]����="+su[3]);//�׹�°������ ���
	 System.out.println("su[4]����="+su[4]);//�ټ���°������ ���
     System.out.println("==============================");
     System.out.println("�迭�� ũ��(��Ұ���): "+ su.length);
	 //for(int i=0; i<5; i++) {//0~4���� ǥ��, �迭�� �ε����� ǥ��
     for(int i=0; i< su.length; i++) {//0~4���� ǥ��, �迭�� �ε����� ǥ��
		 System.out.println("su["+i+"]����="+su[i]);	 
	 }
	 
     System.out.println("# 2�����迭 �׽�Ʈ");
     
        //�� �ε���        0       1           2
     int su2[][]= { {11}, {22,33},  {44,55,66} };
        //�� �ε���        0     0   1     0   1  2
	 
     //1�����迭��.length  ---> �迭ũ��, ��Ұ���
     //2�����迭��.length  ---> ���� ũ��!!   su2.legth ---> 3
     System.out.println("su2�� ��ũ��: "+ su2.length); //3
     
     for(int i=0; i< su2.length; i++) {//�� �ε��� ǥ��  0 1 2
    	 for(int j=0; j< su2[i].length; j++) {//�� �ε��� ǥ�� 
    		 System.out.println("su2["+i+"]["+j+"]="+ su2[i][j]);
    	 }
     }
  }//main
}//ArrayTest







