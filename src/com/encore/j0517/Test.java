package com.encore.j0517;

import java.util.Vector;

import com.encore.person.model.Person;

class A{ int su=10;}

public class Test {
   public static void main(String[] args) {
	  Vector<String> v = new Vector<>();
	    v.add("길동");
	    v.add("라임");
	    v.add("주원");
	    
	   System.out.println(v);//v.toString()
	   
     Vector<A> v2 = new Vector<>();
        v2.add(new A());
        v2.add(new A());
        v2.add(new A());
        
      System.out.println(v2);  
      
     Vector<Person> v3 = new Vector<>(); 
       v3.add(new Person(1, "홍길동", 13, "학생"));
       v3.add(new Person(2, "길라임", 15, "학생"));
       
      System.out.println(v3); 
  }
}




