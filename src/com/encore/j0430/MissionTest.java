package com.encore.j0430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissionTest {
   public static void main(String[] args) throws IOException {
	   //System.in.read(); ----> 엔터키 처리
	   //br.readLine();  ----> 객체생성을 먼저
	  
	boolean flag=true;   
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int su=0;
	
    do{   
		 System.out.println("<<메뉴>>");
		 System.out.println("1.검색 2.증가 3.감소 4.종료"); 
		 System.out.print("번호==> ");
		 String no = br.readLine();
		 
		 switch(no) { //(수식) {//수식데이터: 정수,문자, 문자열
		   //만약 char no; ----> case '1':   , case '2':
		   //만약 int no;  ----> case 1:     , case 2:
		   //만약 String no;  ----> case "1":     , case "2":        
		 
		    case "1": //증가 또는 감소된 숫자의 현재 값 
		    	System.out.println("#검색결과:"+ su);
		    	      break;
		    case "2": //숫자 1증가
		    	      su++;
		    	      System.out.println("#1증가하였습니다.");
		    	      break;
		    case "3": //숫자 1감소
		    	      su--;
		    	      System.out.println("#1감소하였습니다.");
		    	      break;
		    case "4": flag=false;
		 }//switch
		 
		 System.out.println();
	 }while(flag);//(조건식);
    
    System.out.println("-- END --");
	 
   }//main
}


