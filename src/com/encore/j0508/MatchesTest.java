package com.encore.j0508;

public class MatchesTest {
   public static void main(String[] args) {
	   String str="";
	          str="a";
	          //str="aa";
	          //str="aaaaaaaaaaaaaaa";
	  
	   //boolean str.matches(String regex);
	   //regex ----> regular expression (���� ǥ����)
	   //regex�� ���� ���޵Ǵ� ���Ͽ� str�� ����(match)�ȴٸ� true�� ����.
	   
	   //����Ƚ���� ���õ� ��ȣ: ?, *, +
	   System.out.println(str.matches("[a]")); //a����: �ѹ�
	   System.out.println(str.matches("[a]?")); //a����: 0,1
	   System.out.println(str.matches("[a]*")); //a����: 0~���Ѵ�
	   System.out.println(str.matches("[a]+")); //a����: 1~���Ѵ�
	   System.out.println("========================");
	   System.out.println(str.matches("[abc]"));//a �Ǵ� b �Ǵ� c ���� �� 1�� ����
	   
	   String name="gildongA";
	   //name������ ���� ������ üũ!!
	   System.out.println("�̸�üũ: "+ 
	         //name.matches("[abcdefghijklmnopqrstuvwxyz]+"));
			   name.matches("[a-zA-Z]+")); //[]�ȿ��� '-'�� ������ ǥ��
	   
	   String su="345678a";
	   //su������ ���� ���� üũ!!
	   System.out.println("����üũ: "+ su.matches("[0-9]+"));
	   
	   String hangul="���ѱ�";
	   //hangul������ ���� �ѱ� üũ!!
	   System.out.println("�ѱ�üũ: "+ hangul.matches("[��-�R]+"));
	   
	   String id="gildong100456";
	   //id������ 8~12�ڸ�, �����ڿ� ��������
	   
	   String idPattern="[a-zA-Z0-9]{8,12}";//8~12
	   //{8,12}  8�̻�~12����    {8,}: 8�̻�    {8} : 8��
	   System.out.println("���̵�üũ: "+ id.matches(idPattern));
	   
	   String juminBunho = "960302-1012345";
	   String juminPattern = "[0-9]{6}-[\\d]{7}";
	   System.out.println("�ֹι�ȣüũ: "+ juminBunho.matches(juminPattern));
	   
	   String test="1";
	   System.out.println(test.matches("^[0-9-[1]]+$"));
	   
   }//main
}







