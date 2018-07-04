package com.encore.j0501;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CurrentTimeTest {
	
    public static void main(String[] args) {
    	
		//2018년 5월 1일 3시 16분 30초 (화요일)
    	//날짜관련클래스: java.util패키지 ===> Date, Calendar ----> get(int field);
    	Date d = new Date();
    	  int hours  = d.getHours();
    	  System.out.println("Date클래스 통한 시간정보: "+ hours);
    	  
    	Calendar c = new GregorianCalendar(); //new Calendar();
    	         //c = Calendar.getInstance();
    	       //c ==> 현 시스템 날짜의 모든 정보가 저장!!
    	 
    	System.out.println("현재년도1: "+c.get(1));
    	System.out.println("현재년도2: "+c.get( Calendar.YEAR ));
    	int year = c.get(Calendar.YEAR);
    	int month = c.get(Calendar.MONTH) + 1; //1월~12월 ---> get() : 0~11
    	int date = c.get(Calendar.DATE);
    	//int h = c.get(Calendar.HOUR);  //오후 4시  ---> 4리턴
    	int h = c.get(Calendar.HOUR_OF_DAY); //오후 4시  ---> 16리턴
    	int m = c.get(Calendar.MINUTE);
    	int s = c.get(Calendar.SECOND);
    	
    	//요일구하기 day
    	int day = c.get(Calendar.DAY_OF_WEEK);
    	System.out.println("day="+day);//현재 수요일!!:4 일~토요일  일요일:1 , 토요일:7
    	                                                     //   1  ~  7
    	String dayStr="";
    	switch(day) {
    	   case  4: dayStr="수요일";
    	}
    	
    	String []dayArray= {"일","월","화","수","목","금","토"};
    	                 //  0    1   2    3    4   5   6
    	
    	System.out.println(year+"년 "+month+"월 "+date+"일 "+h+"시 "+m+"분 "+s
    			         +"초 ("+ dayArray[day-1] +"요일)");
	}//main
}









