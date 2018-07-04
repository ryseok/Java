package com.encore.j0509;

import java.util.Vector;

public class PersonMenu {
    Vector<Person> persons;//데이터 저장소
    
    public PersonMenu() {
	   persons = new Vector<>();
	}
    
    //데이터 저장
    //public void insert(String name, int age, String job) {}
    public void insert(Person p) {
    	persons.add(p);//Person추가시 마다 인덱스 부여!!(0~)
    }
    
    //(전체)데이터 조회
    public void select() {
       System.out.println("#사람목록");
       for(int i=0; i<persons.size(); i++) {//벡터의 인덱스를 표현
    	   //persons.get(i) == Person p
    	   Person p = persons.get(i);
    	   //System.out.println("1: [홍길동,13,학생]");
           /*System.out.println(p.getNo()+": ["+p.getName()+","+
    	               p.getAge()+","+p.getJob()+"]");*/
    	   System.out.println(p);
       }
    }
    
    //데이터 수정
    public void update(Person upPerson) {
       //기존데이터를 변경 ===> 번호를 통해 기존 데이터 찾기
       for(int i=0; i<persons.size(); i++) {//전체 조회
    	  Person oldPerson = persons.get(i);
    	  
    	  if(upPerson.getNo() == oldPerson.getNo()) {//일치하는 번호찾기
    		 //기존 나이와 직업을 변경
    		  oldPerson.setAge(upPerson.getAge());
    		  oldPerson.setJob(upPerson.getJob());
    		  break;
    	  }    	  
       }//for    	
    }
    
    //데이터 삭제
    public void delete(int delNo) {
        for(int i=0; i<persons.size(); i++) {//벡터 전체조회
        	//Person oldPerson = persons.get(i);
        	//if(delNo == oldPerson.getNo())//삭제할 번호 찾기	
        	if(delNo == persons.get(i).getNo()) {//삭제할 번호 찾기
        		persons.remove(i);
        		break;
        	}
        }//for
    }//delete    
}









