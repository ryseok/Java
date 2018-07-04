package com.encore.person.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class FileReadWrite {
    
	/*
             <��������> person.txt
              1|ȫ�浿|13|�л�
              2|�����|15|�л�
              3|���ֿ�|17|�л� 	   	
	 */
	
	//Vector<Person> ----> File
	public void toFile(Vector<Person> v) {//saveFile (FileWriter)
	  try {
		FileWriter fw = new FileWriter("person.txt");	
			
		  //v ----> Person ----> String  ------> File('person.txt')
		  for(int i=0; i<v.size(); i++) {//���ͳ��� Person�� ����ŭ �ݺ�
			 Person p = v.get(i);
			 String str = p.getNo() +"|"+ p.getName()+"|"+p.getAge()+"|"+ p.getJob();
			   //   1    +"|"+    "ȫ�浿"   +"|"+     13   +"|" +   "�л�"
			   // ----> str = "1|ȫ�浿|13|�л�"
			 fw.write(str+"\r\n");
		  }
		  
		  fw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}//toFile
	
	
	//�Է� (�б�)        -----> ��� (����, �������߰�)
	//File(person.txt) -----> Vector<Person>
	public Vector<Person> fromFile() {//openFile (FileReader  "person.txt")
		Vector<Person> v = new Vector<>();
		
	  try {	
		BufferedReader in = new BufferedReader(new FileReader("person.txt"));
		/*String str = in.readLine();//===> String str= "1|ȫ�浿|13|�л�"
		String str = in.readLine();//===> String str= "2|�����|15|�л�"
       */	
		
		String str;
		while(   (str=in.readLine()) != null   ) {//���� ������ �ִٸ�
			//str ----> Person ----> Vector
//str="1|ȫ�浿|13|�л�"; str.split("|") ---> strArr[]= {"1","ȫ�浿","13","�л�"};
			String []arr = str.split("\\|");
			
			Person p = new Person();//new�� ����? 'person.txt'�� �� �� ��ŭ
			//-----> no,name,age,job : [0,null,0,null]
			  p.setNo(Integer.parseInt(arr[0]));// no,name,age,job : [1,null,0,null]
			  p.setName(arr[1]);// no,name,age,job : [1,"ȫ�浿",0,null]
			  p.setAge(Integer.parseInt(arr[2]));// no,name,age,job : [1,"ȫ�浿",13,null]
			  p.setJob(arr[3]);// no,name,age,job : [1,"ȫ�浿",13,"�л�"]
			
			v.add(p);
		}
		
		in.close();
		//str�� Person��ü�� ��ȯ ==> ��? Vector�� �߰�(add)�ϱ� ���ؼ�
	  }catch(Exception e) {}
		return v;
	}//fromFile
	
	
	
	/*
	public static void main(String[] args) {
		String str="aa|bb|cc";
		String []arr = str.split("\\|");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr["+i+"]="+arr[i]);
		}
		
		Vector<String> vv = new Vector<>();
		   vv.add("�浿");
		   vv.add("����");
		   vv.add("�ֿ�");
		 System.out.println("vv="+ vv);  
		
		
		FileReadWrite frw = new FileReadWrite();
		  //Vector<Person> v =  frw.fromFile();
		  //System.out.println(v);
		  
		Vector<Person> vvv = new Vector<>();
		   vvv.add(new Person(1, "���浿", 13, "�л�"));
		   vvv.add(new Person(2, "������", 12, "�л�"));
		   vvv.add(new Person(3, "���ֿ�", 11, "�л�"));
		   
		frw.toFile(vvv);  
		System.out.println("������¼���!!");
	}//main
	*/
}


