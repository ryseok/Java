package com.encore.j0504;

public class StringTest {
  public static void main(String[] args) {
	
	 //String ���ڿ� : ���ڵ��� ����!!
	 String str="JavaProgramming";
	 //�ε���           012345678901234
	 
	 //str.~  StringŬ������ �ִ�~
	 
	 //���ڿ� ����(���� ����)
	 System.out.println("str���ڿ�����(���ڰ���): "+ str.length());
	 
	 //�κй��ڿ� ---> "Pro"���ڿ� ���
	 System.out.println("str.substring(4,7)="+str.substring(4,7));//beginIndex����, endIndex������
	 
	 //�κй��ڿ� ---> "Programming"���ڿ� ���
	 System.out.println("str.substring(4)="+str.substring(4));
	 
	 
	 //Ư���ε����� ���� ������ :char   str.charAt(int index)   
	 System.out.println("str.charAt(4)="+str.charAt(4));
	 
	 //Ư�������� �ε��� ������:int    str.indexOf(int ch)
	 System.out.println("str.indexOf('P')="+str.indexOf('P'));//str.indexOf(97)); //97 == 'a'
	 
	 
	 System.out.println("str.indexOf(\"am\")="+str.indexOf("am"));
	 //���ڿ��� ���ǹ��ڰ� ���ٸ� -1 ����!!
	 
	 //String str="JavaProgramming";
	   //�ε���           012345678901234
	 
	 //���ڿ� ġȯ(��ü)
	 //replace(char oldChar, char newChar)
	 System.out.println("str.replace('a', 'o')="+ str.replace('a', 'o'));
	 //str = str.replace('a', 'o');
     System.out.println("STR="+ str);
     
     //"JavaProgramming"  ---> "�ڹ�Programming"���� �����Ͻÿ�.
     //replace(CharSequence target,CharSequence replacement)
     System.out.println("str.replace(\"Java\", \"�ڹ�\")="+ str.replace("Java", "�ڹ�"));
	 
     //���ڿ��� ���� �߰�!!
     str = "  "+str+"  ";//�տ� ����2��, �ڿ� ����2��
     System.out.println("�����߰��� STR="+ str);
     System.out.println("STR���ڿ� ����="+ str.length());
     
     //���ڿ�����!!
     str = str.trim();//�¿� ���ӵ� ����(white space ---> �Ѱ��̻��� space,tab,enter�� ����)�� ����      
	 System.out.println("���������� STR���ڿ� ����= "+ str.length());
  }//main
}







