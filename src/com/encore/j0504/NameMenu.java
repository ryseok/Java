package com.encore.j0504;

public class NameMenu {
   String []names;//(이름)데이터 저장소
   
   int cnt;//입력된 이름의 수만큼 증가
   
   public NameMenu() {
	  names = new String[5];
	  //names[0]번지~names[4]번지 방만들기
	  //각 방에는 null값을 입력
   }//생성자
   
   public void insert(String name) {//데이터 입력
	 //main()통해 전달받은 이름을 배열에 저장!!
	 //빈공간(null)을 찾아서 이름을 저장!! 
//	   if(names[0] == null)names[0]=name;
//	   else if(names[1] == null)names[1]=name; 
//	   else if(names[2] == null)names[2]=name;
	   for(int i=0; i<names.length; i++) {//0~4
		   if(names[i] == null) {//빈공간찾기!!
			   names[i]=name;
			   cnt++;
			   break;
		   }
	   }//for
   }//insert
   public void select() {//데이터 검색
	 System.out.println("\n#이름목록");  
	 for(int i=0; i<names.length; i++) {//배열의 전체 인덱스
		//System.out.print("names["+i+"]번지=");
	    if(names[i] != null)	 
		 System.out.println(" "+names[i]); 
	 }
   }
   public void update(String oldName, String newName) {//데이터 수정
	  for(int i=0; i<names.length; i++) {//배열0~4 : 전체
		/*if(names[i] != null) {//널이 아닐때  
		  if(names[i].equals(oldName)) {
		   //변경할 기존 이름을 찾았다면!!
		     names[i]=newName;//이름 변경
		     break;
		  }
		}*/
		       //"".equals("")
			if(oldName.equals(names[i])) {
				//변경할 기존 이름을 찾았다면!!
				names[i]=newName;//이름 변경
				break;
			}
		
	  }//for
   }//update
   public void delete(String delName) {//데이터 삭제
	   
	  for(int i=0; i<names.length; i++) {
		 //삭제표현: 변수명[번지첨자]=null;
		 if(delName.equals(names[i])) {
	     //삭제할 이름 찾기 
		  names[i]=null;
		  cnt--;
		  break;
		 }
	  }//for
   }//delete
   
   //public void duplicateNameCheck() {//중복된 이름 존재
   public boolean existNameCheck(String name) {//존재하는 이름 체크
	  for(int i=0; i<names.length; i++) {
		  if(name.equals(names[i])) {//일치하는 이름발견시!!
			 return true; 
		  }
	  }
	  return false;
   }//existNameCheck
}









