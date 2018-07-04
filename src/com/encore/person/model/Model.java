package com.encore.person.model;

import java.util.Vector;

public class Model {
    private Vector<Person> personV;  //������ ����� ǥ��
     
    public Model() {
	    personV = new Vector<>();
	}
    
    public Vector<Person> getPersonV() {
		return personV;
	}
    
	public void setPersonV(Vector<Person> personV) {
		this.personV = personV;
	}

	public void insert(Person addp) {//�ܺο��� ���޹��� �����͸� Vector�� ����
       	personV.add(addp);
    }
    
    public Vector<Person> selectAll() {
    	//Vector�� ����� ��� Person������ ����. ==> JTable��� �ʿ�
    	return personV;	
    }
    public void update(Person newp) {//�ܺο��� ����� ������(newPerson)�� ���޹޾�
    	                            //Vector�� ����Ǿ��ִ� ���� oldPerson�� ����
    	for(int i=0; i<personV.size(); i++) {//������ ������ ������ newp�� ���� oldPerson�� ����(����)�ϱ�.
    		Person oldp = personV.get(i);//���� ����� Person����
    		if(oldp.getNo() == newp.getNo()) {//��ġ�� ��ȣ�� ã�Ҵٸ�
    			  oldp.setAge(newp.getAge());
    			  oldp.setJob(newp.getJob());
    			  break;
    		}
    	}//for
    }//update
    
    public boolean delete(int delNo) {//�ܺο��� ������ ����(no)�� �޾� 
    	                  //Vector�� ����� Person(no)�� ��ġ�ϴ� �ش�Person�� ����  
    	for(int i=0; i<personV.size(); i++) {//��ü Vector�˻�
    	   Person oldp = personV.get(i);
    	   if(oldp.getNo() == delNo) {//��ġ�ϴ� ��ȣ ã��
    		    //�ش� �ε����� ���� Person�� ���ͷ� ���� ����!!
    		   personV.remove(i);//���� ������ ����!!
    		   //break;
    		   return true;//������ ���������� ǥ��.
    	   }    		
    	}//for
       return false;//������ ����!!	
    }//delete
    
    public Person select(int selNo) {//�ܺο��� ��ȸ�� ����(no)�� �޾�
    	                  //Vector���� ��ġ�ϴ� Person������ ����.  ==> ���������� �ʿ�
       for(int i=0; i<personV.size(); i++) {
    	   Person p = personV.get(i);
    	   if(p.getNo() ==  selNo) {
    		   return p;
    	   }
       }
       return null;	//Person ��ã����!!
    }
    
    
     //Vector<Person> personv  ---��ȯ---> Vector<Object[]> paramv
  	public Vector<Object[]>  personToArray (Vector<Person> personv) {
      Vector<Object[]> paramv = new Vector<>();
  	  for(int i=0; i<personv.size(); i++) {
  		  Person p = personv.get(i);
  	      Object []rowdata= { p.getNo(), p.getName(), p.getAge(), p.getJob()};
  	      paramv.add(rowdata);
  	  }
  	  return paramv;
  	}
    
}//Model





