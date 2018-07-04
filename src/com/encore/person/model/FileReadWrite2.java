package com.encore.person.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class FileReadWrite2 {
   	
	//Vector<Person> ----> File (person.ser)
	public void toFile(Vector<Person> v) {//saveFile (ObjectOutputStream)
		try {
			ObjectOutputStream oos = new ObjectOutputStream
					            (new FileOutputStream("person2.ser"));
			oos.writeObject(v);
			oos.close();
			System.out.println("Person벡터 저장 성공~!!");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}//toFile
	
	//File(person.ser) -----> Vector<Person>
	public Vector<Person> fromFile() {//openFile (ObjectInputStream)
     Vector<Person> v= new Vector<>(); //=null;
     try {
	        ObjectInputStream ois = new ObjectInputStream(
	        		         new FileInputStream("person2.ser"));
			v = (Vector<Person>) ois.readObject();
     } catch (Exception e) {
	     //e.printStackTrace();
    	 System.out.println("EOFException발생했네요!!\n==>새로운 Vector를 저장했어요^O^"); 
    	 Vector<Person> emptyv= new Vector<>();
    	 toFile(emptyv);
    	 
      } 
	 	
		return v;
	}//fromFile
	
}


