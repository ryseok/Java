package com.encore.j0524;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectWriteTest {//객체(Object) 쓰기
   public static void main(String[] args) throws Exception{
	 //FileOutputStream fos = new FileOutputStream("출력할 파일의 정보(경로,파일명)");  
	 FileOutputStream fos = new FileOutputStream("person.ser"); 
	   
	 //ObjectOutputStream oos = new ObjectOutputStream(OutputStream out);
	 ObjectOutputStream oos = new ObjectOutputStream(fos);
	 //oos ==> 출력객체

	 Person p = new Person();
	 
	 Person p2 = new Person();
	   p2.name="길라임";
	   p2.age=15;
	   p2.job="스턴트우먼";
	   
	 oos.writeObject(p);
	 oos.writeObject(p2);
	 oos.writeObject("직렬화 안녕~!!");
	 oos.writeInt(108);
	 oos.writeBoolean(true);
	 
	 oos.close();//자원반환
	 fos.close();//자원반환
	 
	 System.out.println("객체쓰기 성공!!");
	 
   }//main
}




