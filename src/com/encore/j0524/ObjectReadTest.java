package com.encore.j0524;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class ObjectReadTest {//��ü(Object) �б�
   public static void main(String[] args) throws Exception{
	 FileInputStream fis = new FileInputStream("person.ser");
	 //ObjectInputStream ois = new ObjectInputStream(InputStream in);
	 ObjectInputStream ois = new ObjectInputStream(fis);
	 
	 Person p = (Person) ois.readObject();
	    System.out.println("�̸�: "+p.name);
	    System.out.println("����: "+p.age);
	    System.out.println("����: "+p.job);
     System.out.println("=====================");
	  Person p2 = (Person) ois.readObject();
	    System.out.println("�̸�: "+p2.name);
	    System.out.println("����: "+p2.age);
	    System.out.println("����: "+p2.job);
	  
	  System.out.println("=====================");
	  System.out.println("�޽���: "+ois.readObject());
	  System.out.println("����: "+ois.readInt());
	  System.out.println("��: "+ois.readBoolean());
	    
   }   
}






