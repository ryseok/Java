package com.encore.j0509;

import java.util.Vector;

public class DataStoreSearchTest {
   public static void main(String[] args) {
	  //����������(�ֱ�): set,  ��������ȸ(���): get
	   
	  //������ ������ ����
	   String name="���浿";
	   System.out.println(name);//name�� "���浿"
	   System.out.println("���浿 ����==>"+ name.length());
	   
      //�迭�� ������ ���� 
	   //String [] names= {"�ʱ浿"};
	   String [] names = new String[3];//names[0]����~names[2]���� ����
	      names[0] = "�ʱ浿";
	   System.out.println(names[0]);    
	   System.out.println("�ʱ浿 ����==>"+ names[0].length());
	   
      //���Ϳ� ������ ���� 
	  Vector<String> v = new Vector<>();
	     v.add("�츮�浿");
	   System.out.println(v.get(0));//���Ϳ� ����� ù��° ������ ������
	   System.out.println("�츮�浿 ����==>"+ v.get(0).length());
	  //�� name == names[�ε���]  == ���͸�.get(�ε���)  == String������!!
	  //       == �����.getName()
	   
	   
	  //��� ������ ���� 
        Person p = new Person();//new Person("������½");
        //p.name="������½";
        //System.out.println(p.name);
          p.setName("������½");
       System.out.println(p.getName());
       System.out.println("������½ ����==>"+ p.getName().length());
   }//main
}











