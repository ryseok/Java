package com.encore.person.model;

import java.util.Vector;

public class Model {
    private Vector<Person> personV;  //데이터 저장소 표현
     
    public Model() {
	    personV = new Vector<>();
	}
    
    public Vector<Person> getPersonV() {
		return personV;
	}
    
	public void setPersonV(Vector<Person> personV) {
		this.personV = personV;
	}

	public void insert(Person addp) {//외부에서 전달받은 데이터를 Vector에 저장
       	personV.add(addp);
    }
    
    public Vector<Person> selectAll() {
    	//Vector에 저장된 모든 Person정보를 전달. ==> JTable출력 필요
    	return personV;	
    }
    public void update(Person newp) {//외부에서 변경될 데이터(newPerson)를 전달받아
    	                            //Vector에 저장되어있는 기존 oldPerson을 수정
    	for(int i=0; i<personV.size(); i++) {//변경할 정보를 저장한 newp를 기존 oldPerson에 적용(변경)하기.
    		Person oldp = personV.get(i);//기존 저장된 Person정보
    		if(oldp.getNo() == newp.getNo()) {//일치한 번호를 찾았다면
    			  oldp.setAge(newp.getAge());
    			  oldp.setJob(newp.getJob());
    			  break;
    		}
    	}//for
    }//update
    
    public boolean delete(int delNo) {//외부에서 삭제할 정보(no)를 받아 
    	                  //Vector에 저장된 Person(no)중 일치하는 해당Person을 삭제  
    	for(int i=0; i<personV.size(); i++) {//전체 Vector검색
    	   Person oldp = personV.get(i);
    	   if(oldp.getNo() == delNo) {//일치하는 번호 찾기
    		    //해당 인덱스를 가진 Person을 벡터로 부터 삭제!!
    		   personV.remove(i);//실제 데이터 삭제!!
    		   //break;
    		   return true;//삭제에 성공했음을 표현.
    	   }    		
    	}//for
       return false;//삭제에 실패!!	
    }//delete
    
    public Person select(int selNo) {//외부에서 조회할 정보(no)를 받아
    	                  //Vector에서 일치하는 Person정보를 전달.  ==> 수정폼에서 필요
       for(int i=0; i<personV.size(); i++) {
    	   Person p = personV.get(i);
    	   if(p.getNo() ==  selNo) {
    		   return p;
    	   }
       }
       return null;	//Person 못찾았음!!
    }
    
    
     //Vector<Person> personv  ---변환---> Vector<Object[]> paramv
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





