package com.encore.j0508;

import java.util.Vector;

public class NameMenu2 {
   Vector<String> names;//(이름)데이터 저장소
   //Vector names=null;
   int cnt;//입력된 이름의 수만큼 증가
   
   public NameMenu2() {
	  names = new Vector<>();
   }//생성자
   
   public void insert(String name) {//데이터 입력
	  names.add(name);
   }//insert
   public void select() {//데이터 검색
	 System.out.println("\n#이름목록");  
	 for(int i=0; i<names.size(); i++) {//벡터의 전체 인덱스
		 System.out.println(" "+ names.get(i)); 
	 }
   }//select
   public void update(String oldName, String newName) {//데이터 수정
	   
	  for(int i=0; i<names.size(); i++) {//배열0~4 : 전체
			if(oldName.equals(names.get(i))) {
				//변경할 기존 이름을 찾았다면!!
				//names.set(int index,String element)//이름 변경
				names.set(i, newName);
				break;
			}
		
	  }//for
   }//update
   public void delete(String delName) {//데이터 삭제
	     names.remove(delName);//중복된 이름이 없는경우
	  /*for(int i=0; i<names.size(); i++) {//중복된 이름이 존재하고 일치하는 이름 모두를 삭제
		 //삭제표현: 변수명[번지첨자]=null;
		 if(delName.equals(names.get(i))) {
	     //삭제할 이름 찾기 
		  names.remove(i);
		  cnt--;
		 }
	  }//for
*/   }//delete
   
   //public void duplicateNameCheck() {//중복된 이름 존재
   public boolean existNameCheck(String name) {//존재하는 이름 체크
	  if(names.contains(name))return true;
	  return false;
   }//existNameCheck
}









