package com.encore.j0504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameMenuTest {
   public static void main(String[] args) throws IOException {
	 //프로그램 제어, (반복적인 메뉴)화면출력
	boolean flag=true;
	BufferedReader in = new BufferedReader
			    (new InputStreamReader(System.in));
	NameMenu menu = new NameMenu();
	
	do{   
	 System.out.println("<이름메뉴>");  
	 System.out.println("1.추가 2.검색 3.수정 4.삭제 5.종료");  
	 System.out.print("번호입력==> ");
	 String no = in.readLine(); //입력시점     
	 
	 //no 데이터 검사 ====> #번호만 입력하세요!!
	 //no="123"
	 
	 if(!no.matches("[0-9]+")) {
		 System.out.println("#번호만 입력하세요!!");
	 }
	 /*for(int i=0; i<no.length(); i++) {//no문자열의 인덱스 표현
		 char ch = no.charAt(i);
		 //문자에 대한 숫자범위 검사  '0'~'9'
		  //숫자: ch>='0' && ch<='9'  숫자아닌값: ch<'0' || ch>'9'
		 if(ch<'0' || ch>'9') {//0~9 아닌 값을 발견시	
			 System.out.println("#번호만 입력하세요!!");
	         break;
		 }
	 }*/
	 
	 
	 
	 
	 //no="1" "2" "3" "4" "5"
	 //int no = Integer.parseInt(in.readLine());  
	 //if(no.equals("1")){insert();}else if(no.equals("2")){select();}   
	    switch(no) {
	       case "1":
	       {
	    	       System.out.print("이름입력: ");
	    	       String name=in.readLine();
	    	       
	    	        if(menu.existNameCheck(name)) {
	    	        	System.out.println("#이미 입력된 이름입니다!!");
	    	        	break;
	    	        }else if(menu.cnt == 5) {
	    	        	System.out.println("#더 이상 입력할 수 없습니다\r\n" + 
	    	        			"  한 개 이상의 이름을 먼저 삭제한 후 입력하세요!!");
	    	        	break;
	    	        }
	    	       
	    	        
	    	        menu.insert(name);
	       }
	    	        break;
	       case "2": menu.select();
	                break;
	       case "3":
	    	   System.out.print("기존이름입력: ");
	    	   String oldName = in.readLine();//입력시점
	    	   System.out.print("변경이름입력: ");
	    	   String newName = in.readLine();
	    	   
	    	   if(menu.existNameCheck(oldName)) {//oldName이 존재한다면
	    		   menu.update(oldName,newName);
	    	   }else {
	    		   System.out.println("#존재하지 않는 이름입니다!!");
	    	   }    
	                break;
	       case "4": 
	    	   System.out.print("삭제이름입력: ");
    	       String delName = in.readLine();
    	       if(!menu.existNameCheck(delName)) {//delName이 존재하지 않는다면
    	    	   System.out.println("#존재하지 않는 이름입니다!!");
    	    	   break;
    	       }
	    	         menu.delete(delName);	       
	    	         break;
	       case "5": flag=false;
	    }//switch
	 
	    System.out.println();
	 }while(flag);//while(do영역을 반복할 조건식);
	
	 System.out.print("-- END --");
   }//main
}





