package com.encore.j0504;

public class StringTest2 {
   public static void main(String[] args) {
	   String s1 = "java";
	   String s2 = "JaVA";
	   
	   //문자열 s1,s2를 비교(문자열 내용비교)하시오.
	   
	   System.out.println("s1.equals(s2) = "+ s1.equals(s2));//false: 대소문자를 구분하기 때문에 
	   //"java".equals("JAVA")
	   
	   //대소문자 구분없이 s1과 s2 철자를 비교하시오!!
	   System.out.println("대문자 변환: s1.toUpperCase(): "+ s1.toUpperCase());
	   System.out.println("소문자 변환: s2.toLowerCase(): "+ s2.toLowerCase());
	   
	   System.out.println("소문자로 전체 변경후 비교: "+s1.toLowerCase().equals(s2.toLowerCase()));
	   
	   System.out.println("대소문자 구분없이 비교: equalsIgnoreCase():"+ s1.equalsIgnoreCase(s2));
	   
	   String str="Java3Pro7gra9mm0ing";
	   
	   //문제) 문자열 str안의 숫자의 갯수를 출력하시오.
	   //    --->힌트) 문자열안의 각 문자들은 인덱스를 갖는다!!
	   int cnt=0;
       for(int i=0; i<str.length();  i++) {//str문자열 길이만큼 반복
    	   char ch = str.charAt(i); //'3' ---> 51 
    	   if(ch >= '0'  &&   ch<= '9') {
    		   cnt++;
    	   }
       }
       System.out.println("str의 숫자 개수: "+ cnt);
     /*
                   st.getBytes();                  st.toCharArray()
               <-----------------                ---------------->
       byte b[]                  String st="abc";                  char ch[]
         ={97,98,99};                                                  ={'a','b','c'}; 
               ----------------->                 <----------------
                  new String(b);                     new String(ch);          
               
     */
        String st="abc";
        
        //byte배열 변환
        byte []b = str.getBytes();
        cnt=0;
        for (int i = 0; i < b.length; i++) {
			System.out.println("b["+i+"]="+b[i]);
			if(b[i] >= '0' &&  b[i]<= '9') {//b[i] >= 48 &&  b[i]<=57) {//숫자로 구성된 문자라면
		       cnt++;		
			}
		}
        System.out.println("byte[]배열 변환후 숫자 카운트: "+ cnt);
        //char배열 변환
        char []ch = st.toCharArray();
        for (int i = 0; i < ch.length; i++) {
        	System.out.println("ch["+i+"]="+ch[i]);
		}
        
        //byte[]b를  문자열로 변환
        String st2 = new String(b);
        System.out.println("ST2 = "+ st2);
        
        //char[]ch를  문자열로 변환
        String st3 = new String(ch);
	    System.out.println("ST3 = "+ st3);
	   
   }//main
   
}









