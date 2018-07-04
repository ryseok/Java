package com.encore.j0504;

public class StringTest2 {
   public static void main(String[] args) {
	   String s1 = "java";
	   String s2 = "JaVA";
	   
	   //���ڿ� s1,s2�� ��(���ڿ� �����)�Ͻÿ�.
	   
	   System.out.println("s1.equals(s2) = "+ s1.equals(s2));//false: ��ҹ��ڸ� �����ϱ� ������ 
	   //"java".equals("JAVA")
	   
	   //��ҹ��� ���о��� s1�� s2 ö�ڸ� ���Ͻÿ�!!
	   System.out.println("�빮�� ��ȯ: s1.toUpperCase(): "+ s1.toUpperCase());
	   System.out.println("�ҹ��� ��ȯ: s2.toLowerCase(): "+ s2.toLowerCase());
	   
	   System.out.println("�ҹ��ڷ� ��ü ������ ��: "+s1.toLowerCase().equals(s2.toLowerCase()));
	   
	   System.out.println("��ҹ��� ���о��� ��: equalsIgnoreCase():"+ s1.equalsIgnoreCase(s2));
	   
	   String str="Java3Pro7gra9mm0ing";
	   
	   //����) ���ڿ� str���� ������ ������ ����Ͻÿ�.
	   //    --->��Ʈ) ���ڿ����� �� ���ڵ��� �ε����� ���´�!!
	   int cnt=0;
       for(int i=0; i<str.length();  i++) {//str���ڿ� ���̸�ŭ �ݺ�
    	   char ch = str.charAt(i); //'3' ---> 51 
    	   if(ch >= '0'  &&   ch<= '9') {
    		   cnt++;
    	   }
       }
       System.out.println("str�� ���� ����: "+ cnt);
     /*
                   st.getBytes();                  st.toCharArray()
               <-----------------                ---------------->
       byte b[]                  String st="abc";                  char ch[]
         ={97,98,99};                                                  ={'a','b','c'}; 
               ----------------->                 <----------------
                  new String(b);                     new String(ch);          
               
     */
        String st="abc";
        
        //byte�迭 ��ȯ
        byte []b = str.getBytes();
        cnt=0;
        for (int i = 0; i < b.length; i++) {
			System.out.println("b["+i+"]="+b[i]);
			if(b[i] >= '0' &&  b[i]<= '9') {//b[i] >= 48 &&  b[i]<=57) {//���ڷ� ������ ���ڶ��
		       cnt++;		
			}
		}
        System.out.println("byte[]�迭 ��ȯ�� ���� ī��Ʈ: "+ cnt);
        //char�迭 ��ȯ
        char []ch = st.toCharArray();
        for (int i = 0; i < ch.length; i++) {
        	System.out.println("ch["+i+"]="+ch[i]);
		}
        
        //byte[]b��  ���ڿ��� ��ȯ
        String st2 = new String(b);
        System.out.println("ST2 = "+ st2);
        
        //char[]ch��  ���ڿ��� ��ȯ
        String st3 = new String(ch);
	    System.out.println("ST3 = "+ st3);
	   
   }//main
   
}









