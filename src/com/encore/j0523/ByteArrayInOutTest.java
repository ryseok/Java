package com.encore.j0523;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ByteArrayInOutTest {
   //c.txt�б�  -----> d.txt����	
	
	
   public static void main(String[] args) throws Exception{
      FileInputStream fis = new FileInputStream("c.txt");//����: abcd
      FileOutputStream fos = new FileOutputStream("d.txt");
      
      //fis.read(byte[]b);
      /*
       byte [] b = new byte[10];//byte[]b={0,0,0,0,0};
      
       for (int i = 0; i < b.length; i++) {
		 System.out.println("b["+i+"]����="+ b[i]);
	   }
      
      System.out.println("======================");
      System.out.println(fis.read(b));
      //byte[]b={97,98,99,100,0};
      for (int i = 0; i < b.length; i++) {
 		System.out.println("b["+i+"]����="+ b[i]);
 	  }
      
      System.out.println(fis.read(b));
      System.out.println(fis.read(b));// fis(b.txt)�� �о� b�迭�� ����(����)
    */
      
      byte [] testArr = {97,98,99,100,101};
                       //0   1  2  3   4
      
      //fos.write(testArr); //testArr�迭�� �о fos(c.txt)�� ����.  abcde ����!!
      
      //fos.write(byte[]b,int offset,int length);
      //byte�迭 b�� offset(������ġ)���� �о���̵�  �ִ� length��ŭ  �о fos�� ���!!
      //fos.write(testArr, 0, 3);//abc����!!
      //fos.write(testArr, 2, 3);//cde����!!
      
      
      
      int i; //c.txt ----> abcdefgh
      byte [] b = new byte[5];//�迭size: read(b)�� ���� ���� �ִ� ����Ʈ ��!!
                 //{0,0,0,0,0}
      //fis.read(b); {a,b,c,d,e}  i=5
      //fis.read(b); {f,g,h,d,e}  i=3
      
      while((i=fis.read(b)) != -1) {//i: ���� ����Ʈ ��
    	  //System.out.println("��");
    	  fos.write(b,0,i);
      }
      //d.txt ------> abcdefghde
      System.out.println("���Ϻ��� ����~!!");
      
      
   }//main
}




