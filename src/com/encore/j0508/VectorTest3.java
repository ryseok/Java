package com.encore.j0508;

import java.util.Vector;

public class VectorTest3 {
	
	//�� Vector�� ������ �߰�, ����, ����, �˻��ϱ�!!
	public static void main(String[] args) {
	    Vector<String> v = new Vector<>();
	    
	    //������ �߰�
	    v.add("�ڹ�");//�ε��� 0
	    v.add("SQL");//�ε��� 1
	    v.add("HTML");//�ε��� 2
	    v.add("JavaScript");//�ε��� 3
	    v.add("JSP");//�ε��� 4
	    v.add("�ڹ�");//�ε��� 5
	    
	    //������ ����
	    //v.remove(int index);
	    //v.remove(Object o);
	    //v.remove(0);//ù��° �����͸� �����ض�!!
	    v.remove("�ڹ�");
	    
	    
	    //������ ����
	    //v.set(int index,String ��ü��element);
	    v.set(4, "�ڹ����α׷���");//5��° �����͸� ����!!
	    
	    
	    //������ ��ȸ
//	    System.out.println("�ټ���° ������: "+ v.get(4));
//	    System.out.println("������° ������: "+ v.get(5));
/*	    for(; �迭��.length ;)//�迭�� ���
    	for(; ���ڿ�.length() ;)//���ڿ��� ���
   		for(; ���͸�.size() ;)//������ ���
*/	    
	    //��ü������ ��ȸ
	    for(int i=0; i<v.size(); i++) {//������ �ε����� ǥ��
	    	String s = v.get(i);
	       System.out.println(i+":"+s);	
	    }
	    
	}

}




