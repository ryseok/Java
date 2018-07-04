package com.encore.j0508;

public class ParameterTest {
    public static void main(String[] args) {
     /*
         컴파일) javac ParameterTest.java
     인터프리터) java ParameterTest "길동" "라임" "주원"
         ===> String [] args={"길동", "라임", "주원"};
         
          java ParameterTest 홍 길동 길라임 김주원
         ===> String [] args={"홍","길동","길라임","김주원"};
         
          java ParameterTest "홍 길동" 길라임 김주원
         ===> String [] args={"홍 길동","길라임","김주원"};
         
          java ParameterTest 11 22 33
          ===> String [] args={"11","22","33"}   
          
c:\jaelee\workspace\JavaApp\bin>java com.encore.j0508.ParameterTest 11 22 33
main()메소드 파라미터 데이터 출력!!
args[0]=11
args[1]=22
args[2]=33                 
                 
      */
       System.out.println("main()메소드 파라미터 데이터 출력!!");
       for(int i=0; i<args.length; i++) {
    	  System.out.println("args["+i+"]="+ args[i]); 
       }
    	
	}//main
}







