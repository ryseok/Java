package com.encore.j0508;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest {
    public static void main(String[] args) {
	  //�ؽ�Ʈ ����(a.txt)�� �о �� ������ �ֿܼ� ��� 
    	
      //FileInputStream : ���Ͽ� ������ byte������ �д� Ŭ����
      //FileReader      :���Ͽ� ������ ����(char)������ �д� Ŭ����
      //FileReader(String fileName)  ---> fileName:  ��ο� ���ϸ�
       try{ 	
          //FileReader fr = new FileReader("c:\\jaelee\\workspace\\JavaApp\\abc.txt");
          //FileReader fr = new FileReader("c:/jaelee/workspace/JavaApp/abc.txt");
    	 FileReader fr = new FileReader("a.txt");
 	 //��Ŭ�������� ������Ʈ ������ JavaProject�� ���  '������Ʈ��'���� ��θ� �����ϴ� ���� ����!!
    	 
    	  /*System.out.println(fr.read());
    	  System.out.println(fr.read());
    	  System.out.println((char)fr.read());// (char)99 ----> 'c'
    	  
    	  System.out.println(fr.read());
    	  System.out.println(fr.read());
    	  System.out.println(fr.read());//-1���� : ���� ���ڰ� �������
*/    	 
    	  int i;
    	  while( (i=fr.read()) !=  -1   ) {//���� ���ڰ� �ִٸ�
    		  System.out.print((char)i);
    	  }
    	  System.out.println("\n=========================");
          System.out.println("�����б� ����~!!");
    	}catch(FileNotFoundException e) {
    	   System.out.println("���ܹ߻�!!");
    	   System.out.println("===> ������ �������� �ʽ��ϴ�. Ȯ�ιٶ��ϴ�^^*");
    	   System.out.println("-------------------------------------");
    	   System.out.println(e);
    	   System.out.println(e.toString());//�����޽���
    	   System.out.println(e.getMessage());//���� �����޽���
    	   e.printStackTrace();
    	}catch(IOException e) {
    		System.out.println("���ܹ߻�: "+ e.getMessage());
    	}
	}//main
}






