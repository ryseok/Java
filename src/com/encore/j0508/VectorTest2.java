package com.encore.j0508;

import java.util.Vector;

class A{
   void hello() {
	  System.out.println("AŬ�����ȳ�~!!"); 
   }
}

public class VectorTest2 {
   public static void main(String[] args) {
	  Vector v = new Vector();
	    v.add("�ȳ�");//�ε��� 0�ο�
	    v.add(new A());//�ε��� 1�ο�
	    
	    //v.get(int index)
	    Object ob = v.get(1);//�ι�° ������ ���
	    //ob.hello(); //------> �����߻�!! --> ��? �θ� ���������� ���� �ڽ� ȣ�� �Ұ�!!
	    A a = (A)ob;
	    a.hello();
	    
	  //Vector<A> v2 = new Vector<A>();//---> v2���� AŬ������ü�� ��ڽ��ϴ�!!
	  Vector<A> v2 = new Vector<>();// JDK7�������� <> �� ��ȣ ����
	      v2.add(new A());//�ε���0
	      A obj = new A();
	      v2.add(obj);//�ε���1
	      
	      A aa = v2.get(1); 
	        aa.hello();
	        v2.get(1).hello();
	  
	  
	  /*
	      <>: ���׸� Ÿ�� ---> � �ڷ����� ����� ���� ���(��Ἲ�� ����)  JDK5���� ����
	      
	      <E> : element(���)�� � �ڷ����� ����� �� ���.
	      <K> : key�� � �ڷ����� ����� �� ���.
	      <V> : value�� � �ڷ����� ����� �� ���.
	      <T> : type�� � �ڷ����� ����� �� ���.
	   */
  }
}







 