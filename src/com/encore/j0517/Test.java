package com.encore.j0517;

import java.util.Vector;

import com.encore.person.model.Person;

class A{ int su=10;}

public class Test {
   public static void main(String[] args) {
	  Vector<String> v = new Vector<>();
	    v.add("�浿");
	    v.add("����");
	    v.add("�ֿ�");
	    
	   System.out.println(v);//v.toString()
	   
     Vector<A> v2 = new Vector<>();
        v2.add(new A());
        v2.add(new A());
        v2.add(new A());
        
      System.out.println(v2);  
      
     Vector<Person> v3 = new Vector<>(); 
       v3.add(new Person(1, "ȫ�浿", 13, "�л�"));
       v3.add(new Person(2, "�����", 15, "�л�"));
       
      System.out.println(v3); 
  }
}




