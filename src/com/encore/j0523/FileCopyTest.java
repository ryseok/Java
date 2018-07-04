package com.encore.j0523;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyTest {//���Ϻ���� ���翡 �ɸ��� �ð��� üũ!!
	
	//a.txt������ �о ȭ��(�ܼ�)�� ���   a.txt ----> ȭ��
	
	//a.txt������ �о b.txt�� ���        a.txt  ----> b.txt   (File Copy!!)
	
	//1)����Ʈ ���� �����
	FileInputStream fis;
	FileOutputStream fos;
	
	//2)���� ���� �����
	FileReader fr;
	FileWriter fw;
	
	//3)���� ���� ����� --> ���ڵ��� ���ۿ� ��Ҵٰ� �ѹ��� �а� ����. 
	BufferedReader br;
	BufferedWriter bw;
	
	//4)����Ʈ ���� �����(byte�迭 ���)
	FileInputStream fis2;
	FileOutputStream fos2;
	
	
    public FileCopyTest() throws IOException {
	   fis = new FileInputStream("a.txt");
	   fos = new FileOutputStream("b.txt");
	   //ȭ�� ���
	   /*
	   System.out.println(fis.read());//97   a
	   System.out.println(fis.read());//98   b
	   System.out.println(fis.read());//99   c
	   System.out.println(fis.read());//100  d
	   
	   System.out.println(fis.read());//-1
	   System.out.println(fis.read());//-1 ---> ���� byte�� ������ -1 ����
	   */
	   int i;
	   
	   long start= System.currentTimeMillis();
	   
	   while(  (i=fis.read()) != -1  ) {//���� byte�� �ִٸ�   i:���� ������ ���� �ڵ尪
		   //System.out.println(i);//�������
		   //System.out.write(i);//�������
		   fos.write(i);//���Ͽ� �������
	   }
	   long end = System.currentTimeMillis();
	   
	   //fos.flush();//���۳��� ���� ����ϱ�!!
	   fos.close();//����ڿ��� ��ȯ!! ---> flush()����� �߰��Ǿ�����!!
	   fis.close();
	   
	   //System.out.flush();
	   System.out.println("[byte����]���Ϻ��� ����~^^*: "+ (end-start));
	   //==========================================================
	   fr = new FileReader("a.txt");//fr�� a.txt����!!
	   fw = new FileWriter("b.txt");//fw�� b.txt����!!
	   
	   start = System.currentTimeMillis();
	   while(  (i=fr.read()) != -1 ) {//���� ���ڰ� �ִٸ�
		   fw.write(i);
	   }
	   end = System.currentTimeMillis();
	   
	   fw.close();
	   fr.close();//����� ��ü�� ���� �ڿ� ��ȯ!!
	   
	   System.out.println("[���ڴ���]���Ϻ��� ����~^^*: "+ (end-start));
	   //==========================================================
	   //br = new BufferedReader(Reader in)
	   //br = new BufferedReader(new FileReader("a.txt"));
	   br = new BufferedReader(new FileReader("a.txt"));
	   //bw = new BufferedWriter(Writer out)
	   bw = new BufferedWriter(new FileWriter("b.txt"));
	   
	   String str;
	   
	   start = System.currentTimeMillis();
	   while( (str=br.readLine()) != null ) {//���� ������ �ִٸ�
		   bw.write(str);
	   }
	   end = System.currentTimeMillis();
	   
	   bw.close();
	   br.close();
	   
	   System.out.println("[���۴���]���Ϻ��� ����~^^*: "+ (end-start));
	  //==========================================================
	   fis2 = new FileInputStream("a.txt");//fis2�� a.txt����!!
	   fos2 = new FileOutputStream("b.txt");//fos2�� b.txt����!!
	   
	   byte []b = new byte[1024];
	   //�迭������: 512 �Ǵ� 1024 ---> 1Kbyte������ read()�ϰ���!!
	  
	   /*
	   fis2.read(b) ----> fis(a.txt)�� �о �迭 b�� ����
                                             ���ϰ��� ���� ����Ʈ��, ���� ����Ʈ�� ���ٸ� -1���� 
       fos2.write(b) ----> �迭b�� �о fos(b.txt)�� ���
       fos2.write(b,offset,length) ----> �迭b�� offset���� �����ؼ� length��ŭ �о 
                                         fos2(b.txt)�� ���
       */ 
	   start = System.currentTimeMillis();
	   while( (i=fis2.read(b)) !=  -1) { //i=���� ����Ʈ ��
		   fos2.write(b,0,i);
	   }
	   end = System.currentTimeMillis();
	   System.out.println("[byte����, byte�迭���]���Ϻ��� ����~^^*: "+ (end-start));
	   
	}//������
    
    public static void main(String[] args) throws IOException{
		new FileCopyTest();
	}
}



