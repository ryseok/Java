package com.encore.j0523;

public class ASCIIGetBytesTest {
   public static void main(String[] args) {
	 //byte[]�迭���� �����͸� ���ڷ� ���!!
	 /*
	   
	             str.toCharArray()             str.getBytes() 
	             <-----------                 --------------->
	  char ch[]               String str="abc"                  byte b[]
	   ={'a','b','c'}                                            ={97,98,99}
	              ----------->                <--------------
	               ch.~  (X)                      b.~  (X)
	           String s1 =                     String s2 =
	               new String(ch);                     new String(b);
	  */
	   
	   String str="hi java stream!!";
	   byte []b = str.getBytes();//byte�ڷ����� ������ �ƽ�Ű�ڵ带 ������!!
       for (int i = 0; i < b.length; i++) {
		  System.out.write(b[i]);//byte�迭�� ���ڸ� ȭ�鿡 ���
		  if(i%3==2)System.out.write('\n'); //�� �ٿ� ������ ���ھ� ���
	   }
       //System.out.write('\n');
       System.out.flush();//��°�ü�� ��� ���ۿ� ��� ������� ���� ����ִ�(����ϴ�) ���.
    }//main
}





