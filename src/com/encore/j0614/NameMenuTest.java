package com.encore.j0614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
	 
	 if(!no.matches("[0-9]+")) {
		 System.out.println("#번호만 입력하세요!!");
	 }	 
	    switch(no) {
	       case "1"://추가 선택
	       {
	    	       System.out.print("이름입력: ");
	    	       String name=in.readLine();
	    	       
	    	        if(menu.existNameCheck(name)) {
	    	        	System.out.println("#이미 입력된 이름입니다!!");
	    	        	break;
	    	        }
	    	        
	    	        menu.insert(name);
	       }
	    	        break;
	       case "2"://검색 선택 
	    	        ArrayList<String> list = menu.select();
	    	        System.out.println("#이름목록");
	    	        for(int i=0; i<list.size(); i++) {//ArrayList의 인덱스
	    	           System.out.println(" "+ list.get(i));	
	    	        }
	                break;
	       case "3"://수정 선택
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
	       case "4": //삭제 선택
	    	   System.out.print("삭제이름입력: ");
    	       String delName = in.readLine();
    	       
	    	   if(!menu.delete(delName)) {
	    	      System.out.println("#존재하지 않는 이름입니다!!");
	    	   }
	    	         break;
	       case "5": //종료 선택 
	    	      flag=false;
	    }//switch
	 
	    System.out.println();
	 }while(flag);//while(do영역을 반복할 조건식);
	
	 System.out.print("-- END --");
   }//main
}





