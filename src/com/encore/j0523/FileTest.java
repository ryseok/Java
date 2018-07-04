package com.encore.j0523;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;





public class FileTest {
  public static void main(String[] args) throws IOException {
     //File f = new File(String pathname);//pathname: ���(����)�� ���ϸ�
	 /*
       <���ǥ�� ���>
       - ��ü���(����̺��� �߰� ������� ��ü), ������ ���, ������� ���
       - �ڹ��� ��δ� '��ü���'��  �⺻
           ----> ImageIcon("���");	     
           ----> ImageIcon("image/left.gif");
                            ---> ��Ŭ������ ������Ʈ ���� �� JavaProject������ ����!!	 
       - �ڹ��� ��ξ��� ���ڴ� ��ҹ��� ������ ���� ����.                                
	 */
	  
	 //FileŬ���� : ������ ���� �Ӽ��� �˱����� �غ�� Ŭ����, �߰����: ���丮 ����,����� ���
	  
	 File f = new File("c:\\jaelee\\workspace\\JavaApp\\a.txt");//��ü���
	 //'\\' ---> '\'�� Ȯ��(���)���ڰ� �ƴ϶� ���ϰ� ���丮�� �����ϴ� ������ ���ڷ� ���!!
	 System.out.println("f����(���丮)���� ����: "+ f.exists());
	  
	 File f2 = new File("c:/jaelee/workspace/JavaApp/a.txt");
	      f2 = new File("a.txt");//������ ���(��Ŭ���������� ����)
	      f2 = new File(".");//  . ��� : current directory  (������)
	      f2 = new File("../..");//  .. ��� : parent directory  (�θ���)
	 
	 System.out.println("f2����(���丮)���� ����: "+ f2.exists());
	 
	 //��� ���� ������
	 System.out.println("f2.getPath(): "+ f2.getPath());
	  //new File(String path) �Ķ���Ϳ� ���ǵ� ���ڿ� �� �״�� ==> ..\..
	 System.out.println("f2.getAbsolutePath(): "+ f2.getAbsolutePath());
	  //��õ� ������ ��ġ + ������ ���  ==> C:\jaelee\workspace\JavaApp\..\..
	 System.out.println("f2.getCanonicalPath(): "+ f2.getCanonicalPath());
	  //������ ��θ� ������ ���  ==> C:\jaelee
	 
	 //b.txt���� �Ӽ� ���� ==> File f3���� ǥ��?
	 File f3 = new File("src/com/encore/j0523/b.txt");//f3 == b.txt
	 System.out.println("f3����(���丮)���� ����: "+ f3.exists());
	 
	 if(f3.isFile()) {//�����̸�  true
		System.out.println("f3�� ����!!"); 
	 }
	 
	 if(f3.isDirectory()) {//���丮�� true
		System.out.println("f3�� ���丮(����)!!"); 
	 }
	 
	 //����) song������ c.txt������ �����Ͻÿ�.
	 //������: FileWriter, FileOutputStream�� ������ �����ϴ� ����� ���´�!!
	 //new FileReader("c.txt"); ----> ���� ������ ��� �����߻�!!
	 //new FileWriter("c.txt"); ----> ���� ������ ��� ���ϻ���!!
		 
	 String path="song/a/b/";
	 String fileName="c.txt";
	 
	 File f4 = new File(path);
	 
	 if(f4.exists()) {//���� �Ǵ� ������ �����Ѵٸ� true
		System.out.println("#���丮�� �̹� ������!!"); 
	 }else {
		//System.out.println("#���丮�� �������� ����!!");
		f4.mkdirs();//���丮 ������� 
		System.out.println("#���丮�� ���� ������!!");
	 }
	 
	 FileWriter fw = new FileWriter(path+fileName);// song/a/b/c.txt
	 //���� ������ ��� ������ ���Ӱ� ������������  �������� �ʴ� ������ ���� �����߻�!!
	 
	 
	 fw.close();//�ڿ� ��ȯ!!
	 
	 //���� �Ǵ� ���丮 ���� ===> delete()
	 File f5 = new File("song/a/b/c.txt");
	    System.out.println("c.txt ���ϻ���: "+ f5.delete());//���������� true!!
	    
	 File f6 = new File("song/a/b");
	    System.out.println("b��������: "+ f6.delete());//���������� true!!
	                                 //---> �� ���� ��������!!
  }//main

}





