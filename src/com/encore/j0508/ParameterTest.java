package com.encore.j0508;

public class ParameterTest {
    public static void main(String[] args) {
     /*
         ������) javac ParameterTest.java
     ����������) java ParameterTest "�浿" "����" "�ֿ�"
         ===> String [] args={"�浿", "����", "�ֿ�"};
         
          java ParameterTest ȫ �浿 ����� ���ֿ�
         ===> String [] args={"ȫ","�浿","�����","���ֿ�"};
         
          java ParameterTest "ȫ �浿" ����� ���ֿ�
         ===> String [] args={"ȫ �浿","�����","���ֿ�"};
         
          java ParameterTest 11 22 33
          ===> String [] args={"11","22","33"}   
          
c:\jaelee\workspace\JavaApp\bin>java com.encore.j0508.ParameterTest 11 22 33
main()�޼ҵ� �Ķ���� ������ ���!!
args[0]=11
args[1]=22
args[2]=33                 
                 
      */
       System.out.println("main()�޼ҵ� �Ķ���� ������ ���!!");
       for(int i=0; i<args.length; i++) {
    	  System.out.println("args["+i+"]="+ args[i]); 
       }
    	
	}//main
}







