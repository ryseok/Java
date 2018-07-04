package com.encore.j0509;

import java.util.Vector;

public class PersonMenu {
    Vector<Person> persons;//������ �����
    
    public PersonMenu() {
	   persons = new Vector<>();
	}
    
    //������ ����
    //public void insert(String name, int age, String job) {}
    public void insert(Person p) {
    	persons.add(p);//Person�߰��� ���� �ε��� �ο�!!(0~)
    }
    
    //(��ü)������ ��ȸ
    public void select() {
       System.out.println("#������");
       for(int i=0; i<persons.size(); i++) {//������ �ε����� ǥ��
    	   //persons.get(i) == Person p
    	   Person p = persons.get(i);
    	   //System.out.println("1: [ȫ�浿,13,�л�]");
           /*System.out.println(p.getNo()+": ["+p.getName()+","+
    	               p.getAge()+","+p.getJob()+"]");*/
    	   System.out.println(p);
       }
    }
    
    //������ ����
    public void update(Person upPerson) {
       //���������͸� ���� ===> ��ȣ�� ���� ���� ������ ã��
       for(int i=0; i<persons.size(); i++) {//��ü ��ȸ
    	  Person oldPerson = persons.get(i);
    	  
    	  if(upPerson.getNo() == oldPerson.getNo()) {//��ġ�ϴ� ��ȣã��
    		 //���� ���̿� ������ ����
    		  oldPerson.setAge(upPerson.getAge());
    		  oldPerson.setJob(upPerson.getJob());
    		  break;
    	  }    	  
       }//for    	
    }
    
    //������ ����
    public void delete(int delNo) {
        for(int i=0; i<persons.size(); i++) {//���� ��ü��ȸ
        	//Person oldPerson = persons.get(i);
        	//if(delNo == oldPerson.getNo())//������ ��ȣ ã��	
        	if(delNo == persons.get(i).getNo()) {//������ ��ȣ ã��
        		persons.remove(i);
        		break;
        	}
        }//for
    }//delete    
}









