package com.encore.person.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class FileReadWrite {
    
	/*
             <저장형태> person.txt
              1|홍길동|13|학생
              2|길라임|15|학생
              3|김주원|17|학생 	   	
	 */
	
	//Vector<Person> ----> File
	public void toFile(Vector<Person> v) {//saveFile (FileWriter)
	  try {
		FileWriter fw = new FileWriter("person.txt");	
			
		  //v ----> Person ----> String  ------> File('person.txt')
		  for(int i=0; i<v.size(); i++) {//벡터내의 Person의 수만큼 반복
			 Person p = v.get(i);
			 String str = p.getNo() +"|"+ p.getName()+"|"+p.getAge()+"|"+ p.getJob();
			   //   1    +"|"+    "홍길동"   +"|"+     13   +"|" +   "학생"
			   // ----> str = "1|홍길동|13|학생"
			 fw.write(str+"\r\n");
		  }
		  
		  fw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}//toFile
	
	
	//입력 (읽기)        -----> 출력 (쓰기, 데이터추가)
	//File(person.txt) -----> Vector<Person>
	public Vector<Person> fromFile() {//openFile (FileReader  "person.txt")
		Vector<Person> v = new Vector<>();
		
	  try {	
		BufferedReader in = new BufferedReader(new FileReader("person.txt"));
		/*String str = in.readLine();//===> String str= "1|홍길동|13|학생"
		String str = in.readLine();//===> String str= "2|길라임|15|학생"
       */	
		
		String str;
		while(   (str=in.readLine()) != null   ) {//읽을 라인이 있다면
			//str ----> Person ----> Vector
//str="1|홍길동|13|학생"; str.split("|") ---> strArr[]= {"1","홍길동","13","학생"};
			String []arr = str.split("\\|");
			
			Person p = new Person();//new의 갯수? 'person.txt'의 줄 수 만큼
			//-----> no,name,age,job : [0,null,0,null]
			  p.setNo(Integer.parseInt(arr[0]));// no,name,age,job : [1,null,0,null]
			  p.setName(arr[1]);// no,name,age,job : [1,"홍길동",0,null]
			  p.setAge(Integer.parseInt(arr[2]));// no,name,age,job : [1,"홍길동",13,null]
			  p.setJob(arr[3]);// no,name,age,job : [1,"홍길동",13,"학생"]
			
			v.add(p);
		}
		
		in.close();
		//str을 Person객체로 변환 ==> 왜? Vector에 추가(add)하기 위해서
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
		   vv.add("길동");
		   vv.add("라임");
		   vv.add("주원");
		 System.out.println("vv="+ vv);  
		
		
		FileReadWrite frw = new FileReadWrite();
		  //Vector<Person> v =  frw.fromFile();
		  //System.out.println(v);
		  
		Vector<Person> vvv = new Vector<>();
		   vvv.add(new Person(1, "나길동", 13, "학생"));
		   vvv.add(new Person(2, "나라임", 12, "학생"));
		   vvv.add(new Person(3, "나주원", 11, "학생"));
		   
		frw.toFile(vvv);  
		System.out.println("파일출력성공!!");
	}//main
	*/
}


