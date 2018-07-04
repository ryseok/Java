package com.encore.j0509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersonMenuTest {
   public static void main(String[] args) throws IOException {
	  //반복적인 메뉴 출력, 데이터 입력, 메뉴내의 메소드 호출
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));   
	PersonMenu menu = new PersonMenu();	
	boolean flag=true;//boolean: 상태를 표현하는 자료형
	int no=0;//입력될 Person에 부여할 번호 표현
	
	do {   
     System.out.println("<이름메뉴>");
     System.out.println("1.추가 2.검색 3.수정 4.삭제 5.종료");
     System.out.print("번호입력==>");
     String num = in.readLine();//num="1" "2" "3" "4"  "5"
     
     System.out.println();
     switch(num) {
        case "1": //벡터에 추가할 이름,나이,직업을 입력받기
                 {
        	      System.out.print("이름: ");
        	      String name = in.readLine();//실제 입력시점
        	      
        	      System.out.print("나이: ");
        	      int age = Integer.parseInt(in.readLine());
        	      
        	      System.out.print("직업: ");
        	      String job = in.readLine();
        	      
        	      //menu.insert(name,age,job);
        	      //Person p = new Person(int no,String name,int age,String job)
        	       no++;
        	      Person p = new Person(no, name, age, job);
        	      //no,name,age,job 4개의 변수데이터를  p변수로 표현!!
        	      menu.insert(p);
                 }
                  break;     
                  
        case "2": menu.select();
        	      break;
        	      
        case "3": {
        	//수정에 필요한 3개의 데이터 입력
        	    System.out.print("수정할 번호: ");
		         int upNo =	Integer.parseInt(in.readLine());
		         
		         System.out.print("나이: "); 
		         int age = Integer.parseInt(in.readLine());
		         
		         System.out.print("직업: ");
		         String job =in.readLine();
        	      //menu.update(upNo, age, job);
		         
		         //upNo,age,job을 한개의 변수명(upPerson)으로 저장
		   Person upPerson = new Person(upNo, null, age, job);
		          menu.update(upPerson);
                 }
        	      break; 
        	      
        case "4": 
        	 //삭제할 정보 입력 ----> 중복되지 않는 데이터: 번호
        	     System.out.print("삭제할 번호: ");
        	     int delNo = Integer.parseInt(in.readLine());
        	      menu.delete(delNo);
                  break;
                  
        case "5": flag=false;   
     }//switch
       System.out.println();
	}while(flag);
	
	System.out.println("-- END --");
   }//main
}







