package com.encore.j0501;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CurrentTimeTest {
	
    public static void main(String[] args) {
    	
		//2018�� 5�� 1�� 3�� 16�� 30�� (ȭ����)
    	//��¥����Ŭ����: java.util��Ű�� ===> Date, Calendar ----> get(int field);
    	Date d = new Date();
    	  int hours  = d.getHours();
    	  System.out.println("DateŬ���� ���� �ð�����: "+ hours);
    	  
    	Calendar c = new GregorianCalendar(); //new Calendar();
    	         //c = Calendar.getInstance();
    	       //c ==> �� �ý��� ��¥�� ��� ������ ����!!
    	 
    	System.out.println("����⵵1: "+c.get(1));
    	System.out.println("����⵵2: "+c.get( Calendar.YEAR ));
    	int year = c.get(Calendar.YEAR);
    	int month = c.get(Calendar.MONTH) + 1; //1��~12�� ---> get() : 0~11
    	int date = c.get(Calendar.DATE);
    	//int h = c.get(Calendar.HOUR);  //���� 4��  ---> 4����
    	int h = c.get(Calendar.HOUR_OF_DAY); //���� 4��  ---> 16����
    	int m = c.get(Calendar.MINUTE);
    	int s = c.get(Calendar.SECOND);
    	
    	//���ϱ��ϱ� day
    	int day = c.get(Calendar.DAY_OF_WEEK);
    	System.out.println("day="+day);//���� ������!!:4 ��~�����  �Ͽ���:1 , �����:7
    	                                                     //   1  ~  7
    	String dayStr="";
    	switch(day) {
    	   case  4: dayStr="������";
    	}
    	
    	String []dayArray= {"��","��","ȭ","��","��","��","��"};
    	                 //  0    1   2    3    4   5   6
    	
    	System.out.println(year+"�� "+month+"�� "+date+"�� "+h+"�� "+m+"�� "+s
    			         +"�� ("+ dayArray[day-1] +"����)");
	}//main
}









