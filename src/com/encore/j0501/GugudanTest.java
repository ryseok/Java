package com.encore.j0501;

import java.io.IOException;

public class GugudanTest {
   public static void main(String[] args) throws IOException {
	
	   //Gugudan g = new Gugudan();     
	   Gugudan2 g = new Gugudan2();     
	     //ȣ���ϴ¸޼ҵ��� ������      ������   = g.inputDan();
	     //int dan = g.inputDan();	   
	     //g.outputDan(dan);
	   System.out.println("<<������>>");   
	   while(true) {
	      g.outputDan(g.inputDan());
	      boolean flag=true;
	      char yn;
	      do {
		       yn= g.continueDan();
		      //yn : 'y', 'n'
		        if(  !(yn=='y' || yn=='Y'|| yn=='n' || yn=='N')  ) {
		        	//yn!='y' && yn!='Y'&& yn!='n' && yn!='N'
		          System.out.println("#�߸��� �����Է��Դϴ�!!\n 'y'�Ǵ�'n'�� �Է��ϼ���~!!");
		        }else {
		           flag=false;	
		        }
	      }
	      
	      while(flag);//�ݺ��� ---> �߸��� ���ڰ� �ԷµǾ�����
	      
	      if(yn == 'n' || yn=='N') break;
	      System.out.println();
	   }
	   System.out.println("-- END --");
	     //int su=13;
	     //A a = new A();
	     //a.hello();  new A().hello();
	     
   }//main
}
