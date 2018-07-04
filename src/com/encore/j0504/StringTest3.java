package com.encore.j0504;

public class StringTest3 {
    public static void main(String[] args) {
	    String str="JavaProgramming";
	    
	    //특정문자열로 시작하는지 체크    boolean str.startsWith(String prefix)
	    System.out.println("str은 'Jav'로 시작하는가? "+ str.startsWith("Jav"));
	    System.out.println("str은 'av'로 시작하는가? "+ str.startsWith("av"));
	    
	    //특정문자열로 끝나는지 체크     boolean str.endsWith(String suffix)
	    System.out.println("ing로 끝나는가? "+ str.endsWith("ing"));
	    
	    //특정문자열이 포함되었는지 체크	boolean str.contains(CharSequence s)
	    System.out.println("Pro를 포함하는가? "+ str.contains("Pro"));
	    
	    String tel="010-1234-4567";
	              //01234567890
	    
	   //문제) String tel1,tel2,tel3변수에 각각  "02","123","4567"을 저장하고 화면에 출력하시오.
	   //      힌트: indexOf()메소드와 substring()을 사용.
	    
	    //첫번째 '-'에 대한 인덱스
	    int idx=tel.indexOf('-');
	    System.out.println("idx="+ idx);//3
	    //두번째 '-'에 대한 인덱스 indexOf(int ch, int fromIndex)
	    int idx2= tel.indexOf('-', idx+1);
	        idx2 = tel.lastIndexOf('-'); //<----- 뒤에서 부터 '-' 조회
	    System.out.println("idx2="+ idx2);//8
	    
	    //String tel="010-1234-4567";
             	    //01234567890
	    
	    String tel1= tel.substring(0,2);//0~1  
	           tel1 = tel.substring(0,idx); 
	    String tel2= tel.substring(3,6);//3~5  
	           tel2 = tel.substring(idx+1, idx2);
	    String tel3= tel.substring(7);//7~끝까지
	           tel3 = tel.substring(idx2+1);
	    
	    System.out.println("tel1="+tel1);
	    System.out.println("tel2="+tel2);
	    System.out.println("tel3="+tel3);
	    
	}
}





