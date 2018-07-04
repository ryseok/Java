package com.encore.j0501;

import java.io.IOException;

public class GugudanTest {
   public static void main(String[] args) throws IOException {
	
	   //Gugudan g = new Gugudan();     
	   Gugudan2 g = new Gugudan2();     
	     //호출하는메소드의 리턴형      변수명   = g.inputDan();
	     //int dan = g.inputDan();	   
	     //g.outputDan(dan);
	   System.out.println("<<구구단>>");   
	   while(true) {
	      g.outputDan(g.inputDan());
	      boolean flag=true;
	      char yn;
	      do {
		       yn= g.continueDan();
		      //yn : 'y', 'n'
		        if(  !(yn=='y' || yn=='Y'|| yn=='n' || yn=='N')  ) {
		        	//yn!='y' && yn!='Y'&& yn!='n' && yn!='N'
		          System.out.println("#잘못된 문자입력입니다!!\n 'y'또는'n'을 입력하세요~!!");
		        }else {
		           flag=false;	
		        }
	      }
	      
	      while(flag);//반복문 ---> 잘못된 문자가 입력되었을때
	      
	      if(yn == 'n' || yn=='N') break;
	      System.out.println();
	   }
	   System.out.println("-- END --");
	     //int su=13;
	     //A a = new A();
	     //a.hello();  new A().hello();
	     
   }//main
}
