package com.encore.j0524;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class ObjectReadTest {//객체(Object) 읽기
   public static void main(String[] args) throws Exception{
	 FileInputStream fis = new FileInputStream("person.ser");
	 //ObjectInputStream ois = new ObjectInputStream(InputStream in);
	 ObjectInputStream ois = new ObjectInputStream(fis);
	 
	 Person p = (Person) ois.readObject();
	    System.out.println("이름: "+p.name);
	    System.out.println("나이: "+p.age);
	    System.out.println("직업: "+p.job);
     System.out.println("=====================");
	  Person p2 = (Person) ois.readObject();
	    System.out.println("이름: "+p2.name);
	    System.out.println("나이: "+p2.age);
	    System.out.println("직업: "+p2.job);
	  
	  System.out.println("=====================");
	  System.out.println("메시지: "+ois.readObject());
	  System.out.println("정수: "+ois.readInt());
	  System.out.println("논리: "+ois.readBoolean());
	    
   }   
}






