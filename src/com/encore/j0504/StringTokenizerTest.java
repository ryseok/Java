package com.encore.j0504;

import java.util.StringTokenizer;

public class StringTokenizerTest {
    public static void main(String[] args) {
	  //StringTokenizer : ���ڿ� �����͸� Ư�� ������(delimiter)�� �и����ִ� Ŭ����.
    	
       //StringTokenizer(String str,String delim)
       //str---> ���ع��ڿ�(��ü���ڿ�),  delim---> ������
       //token(��ū) : �и��� ������ ������!!
    	
       String tel="010--5678";
       StringTokenizer st = new StringTokenizer(tel, "-");
       //st = ["010","1234","5678"]
       
       //String nextToken()
      /* 
       System.out.println(st.nextToken());
       System.out.println(st.nextToken());
       System.out.println(st.nextToken());
       System.out.println(st.nextToken());//������ ��ū�����Ͱ� ������ �����߻�
       */
       
       //st = ["010","1234","5678"]
       while(st.hasMoreTokens()) {//st�� ��ū�����͸� ������ �ִٸ� true����
    	   System.out.println(st.nextToken());//��ū ������ �̾ƿ���   
       }
       //-------------------------------------------------------
       //String tel="010-1234-5678";
       //tel.split(String regex) : Ư�����ڸ� ���� �����͸� �и�!!
       System.out.println("=========================");
       String [] tels = tel.split("-");//tels[]={"010","1234","5678"}
       for (int i = 0; i < tels.length; i++) {
		  System.out.println("tels["+i+"]="+ tels[i]);
	   }
       
       String sample=null; 
       
       //sample�� ���� ������������ �̸��˻�
       
       int su=Integer.parseInt(sample);       
       System.out.println("su="+su);
       
	}//main
    
}






