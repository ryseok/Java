package com.encore.j0504;

public class StringTest3 {
    public static void main(String[] args) {
	    String str="JavaProgramming";
	    
	    //Ư�����ڿ��� �����ϴ��� üũ    boolean str.startsWith(String prefix)
	    System.out.println("str�� 'Jav'�� �����ϴ°�? "+ str.startsWith("Jav"));
	    System.out.println("str�� 'av'�� �����ϴ°�? "+ str.startsWith("av"));
	    
	    //Ư�����ڿ��� �������� üũ     boolean str.endsWith(String suffix)
	    System.out.println("ing�� �����°�? "+ str.endsWith("ing"));
	    
	    //Ư�����ڿ��� ���ԵǾ����� üũ	boolean str.contains(CharSequence s)
	    System.out.println("Pro�� �����ϴ°�? "+ str.contains("Pro"));
	    
	    String tel="010-1234-4567";
	              //01234567890
	    
	   //����) String tel1,tel2,tel3������ ����  "02","123","4567"�� �����ϰ� ȭ�鿡 ����Ͻÿ�.
	   //      ��Ʈ: indexOf()�޼ҵ�� substring()�� ���.
	    
	    //ù��° '-'�� ���� �ε���
	    int idx=tel.indexOf('-');
	    System.out.println("idx="+ idx);//3
	    //�ι�° '-'�� ���� �ε��� indexOf(int ch, int fromIndex)
	    int idx2= tel.indexOf('-', idx+1);
	        idx2 = tel.lastIndexOf('-'); //<----- �ڿ��� ���� '-' ��ȸ
	    System.out.println("idx2="+ idx2);//8
	    
	    //String tel="010-1234-4567";
             	    //01234567890
	    
	    String tel1= tel.substring(0,2);//0~1  
	           tel1 = tel.substring(0,idx); 
	    String tel2= tel.substring(3,6);//3~5  
	           tel2 = tel.substring(idx+1, idx2);
	    String tel3= tel.substring(7);//7~������
	           tel3 = tel.substring(idx2+1);
	    
	    System.out.println("tel1="+tel1);
	    System.out.println("tel2="+tel2);
	    System.out.println("tel3="+tel3);
	    
	}
}





