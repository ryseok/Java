package com.encore.j0614;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {
   public static void main(String[] args) {
	  Properties  pro = new Properties(); //속성 데이터를 담는 클래스
	  //property(속성)
	  
	  //데이터 저장(입력)
	  //pro.setProperty(String key,String value);
	  //key: 저장 또는 검색을 위한 값(유일한 값)
	  //     key == 변수명!!
	  //value: 저장하고자 하는 문자열(text) 데이터.
	  
	  pro.setProperty("k1", "길동");
	  pro.setProperty("k2", "라임");
	  pro.setProperty("k3", "주원");
	  
	  pro.setProperty("k3", "유신");//----> k3에 "유신"데이터 overwrite
	  
	  //데이터 출력(조회)
	  System.out.println("k1===>"+ pro.getProperty("k1"));
	  System.out.println("k2===>"+ pro.getProperty("k2"));
	  System.out.println("k3===>"+ pro.getProperty("k3"));
	  
	  System.out.println("=========================");
      //만약 키값을 모르는 경우
	  Enumeration enu = pro.propertyNames(); //저장된 키값들 얻어오기
	  //Enumeration: 열거형 인터페이스
	  //enu = [k1,k2,k3]
	  
	  while(enu.hasMoreElements()) {
		  Object key = enu.nextElement();
		  System.out.println(key+" : "+ pro.getProperty(key.toString()));
	  }
	  
	  //test.properties파일로 부터 속성데이터 얻어오기!!	  
	  //pro.load(Reader reader)
	  
	  try {
		pro.load(new FileReader("src/com/encore/j0614/test.properties"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	  
	  System.out.println("이름: "+ pro.getProperty("name"));
	  System.out.println("나임: "+ pro.getProperty("age"));
	  System.out.println("직업: "+ pro.getProperty("job"));
	  System.out.println("기타: "+ pro.getProperty("etc"));
	  
	  
   }//main
}



