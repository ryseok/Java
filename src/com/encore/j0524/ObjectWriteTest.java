package com.encore.j0524;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectWriteTest {//��ü(Object) ����
   public static void main(String[] args) throws Exception{
	 //FileOutputStream fos = new FileOutputStream("����� ������ ����(���,���ϸ�)");  
	 FileOutputStream fos = new FileOutputStream("person.ser"); 
	   
	 //ObjectOutputStream oos = new ObjectOutputStream(OutputStream out);
	 ObjectOutputStream oos = new ObjectOutputStream(fos);
	 //oos ==> ��°�ü

	 Person p = new Person();
	 
	 Person p2 = new Person();
	   p2.name="�����";
	   p2.age=15;
	   p2.job="����Ʈ���";
	   
	 oos.writeObject(p);
	 oos.writeObject(p2);
	 oos.writeObject("����ȭ �ȳ�~!!");
	 oos.writeInt(108);
	 oos.writeBoolean(true);
	 
	 oos.close();//�ڿ���ȯ
	 fos.close();//�ڿ���ȯ
	 
	 System.out.println("��ü���� ����!!");
	 
   }//main
}




