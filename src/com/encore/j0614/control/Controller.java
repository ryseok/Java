package com.encore.j0614.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.encore.j0614.model.dao.PersonDAO;
import com.encore.j0614.model.dto.Person;
import com.encore.j0614.view.InputForm;
import com.encore.j0614.view.MainView;
import com.encore.j0614.view.UpForm;

public class Controller implements ActionListener{
   /*
    <컨트롤러의 역할> - 전체 프로그램에 대한 흐름 제어!!
   1. 사용자 요청 분석 (예: 어떤 버튼을 눌렀는지)
   2. 사용자 입력 데이터 얻어오기 (예: 입력폼 또는 수정폼을 통해 입력된 데이터) 
   3. 모델객체생성(예: PersonDAO)
       - 메소드호출
       - 결과값 (리턴값)저장
   4. 페이지(뷰)이동 (예: 메인(JTable) ---> 입력폼)
   
     선택사항) 유효성 검사(valid check) <=== 사용자가 입력한 데이터에 대한	
    */

   //뷰등록
   MainView mainView;
   InputForm form;
   UpForm upForm;
	
   public Controller() {
      mainView = new MainView();
      form = new InputForm();
      upForm = new UpForm();
      
      mainView.displayTable(new PersonDAO().selectAll());
      eventUp();
   }//생성자
   
   private void eventUp() {//이벤트 소스 등록
	  //메인뷰
	  mainView.bt_insert.addActionListener(this); 
	  mainView.bt_update.addActionListener(this); 
	  mainView.bt_del.addActionListener(this); 
	  mainView.bt_exit.addActionListener(this);
	  
	  //입력폼
	  form.bt_submit.addActionListener(this);
	  form.bt_cancel.addActionListener(this);
	  
	  //수정폼
	  upForm.bt_submit.addActionListener(this);
	  upForm.bt_cancel.addActionListener(this);
   }//eventUp
   
   @Override
   public void actionPerformed(ActionEvent e) {
     Object ob = e.getSource();//action이벤트를 발생시킨 이벤트 소스의 주소 얻기
     
     if(ob == mainView.bt_insert) {//1. 메인뷰: 입력버튼
    	 //4. 메인뷰 ---> 입력폼  이동!!
    	 mainView.setVisible(false);
    	 form.setVisible(true);
    	 
     }else if(ob == form.bt_submit) {//1. 입력폼: 입력버튼  (DB입력요청)
    	 //2. 입력데이터 얻기
    	 String name = form.tf_name.getText();
    	 String age = form.tf_age.getText();
    	 String job = form.tf_job.getText();
    	 
    	 
    	 boolean flag=true;
    	 
    	 //옵션!!  유효성검사
    	 //빈값체크
    	 if(name == null || name.length()==0) {
    		 form.showMsg("이름입력!!");
    	 }else if(age.equals("")) {
    		 form.showMsg("나이입력!!");
    	 }else if(!age.matches("[0-9]+")) {//'나이'데이터에 대한 숫자 체크
    		 form.showMsg("숫자입력!!");
    		 form.tf_age.setText("");
         }else if(job.length()==0) {
    		 form.showMsg("직업입력!!");
    	 }else {//적합한 데이터!!
    		 flag=false;
    	 }
    	 
    	 if(flag)return;
    	 
    	 //name,age,job을   하나의 p변수(DTO)로 묶어주기
    	 Person p  = new Person(0, name, Integer.parseInt(age), job);
    	 
    	 //3. DB입력
    	 PersonDAO dao = new PersonDAO();
    	    //dao.insert(name,age,job);
    	 
    	  if(dao.insert(p)) {//입력 성공시!!
    		  
    		  mainView.displayTable(dao.selectAll());
    		  
    		  
    		  //4. 입력폼 ---> 메인뷰 이동
    		  form.setVisible(false);
    		  mainView.setVisible(true);
    	  }
    	 
     }else if(ob==mainView.bt_update) {//1.메인뷰: 수정버튼
    	String  no = mainView.showInput("수정번호:");//2.
    	
    	PersonDAO dao = new PersonDAO(); //3.
    	  Person p = dao.select(Integer.parseInt(no));//Integer.parseInt(no)
    	
    	if(p != null) {//수정번호에 해당하는 데이터(Person)를 얻었을때  
    		upForm.upNo = p.getNo();
    		
	    	upForm.tf_name.setText(p.getName());  
	    	upForm.tf_age.setText(p.getAge()+""); //tf.setText(String text)  
	    	upForm.tf_job.setText(p.getJob());
	    	
	    	mainView.setVisible(false);//4.
	    	upForm.setVisible(true);
    	}else {
    		mainView.showMsg("존재하지 않는 번호입니다!!");
    	}
     }else if(ob== upForm.bt_submit) {//수정폼: 수정버튼 클릭 1.
    	 //upForm.tf_name.getText();
    	 String age = upForm.tf_age.getText();//2.
    	 String job = upForm.tf_job.getText();
    	 
    	 Person p = new Person();//no,name,age,job : 0,null,0,null
    	   p.setAge(Integer.parseInt(age)); //0,null,13,null
    	   p.setJob(job); //0,null,13,"학생"
    	   p.setNo(upForm.upNo); //2,null,13,"학생"
    	    
    	 
    	 PersonDAO dao = new PersonDAO();//3.
    	   if(dao.update(p)) {//DB 수정작업 요청
    	   
    	   //수정된 내용을 JTable에 반영
    	   mainView.displayTable( dao.selectAll() );
    	   
    	     upForm.setVisible(false); //4.
    	     mainView.setVisible(true);
    	   }else {//수정실패!!
    		  upForm.showMsg("입력값을 확인하세요!!"); 
    	   }
     }else if(ob == mainView.bt_del) {//메인뷰: 삭제버튼 클릭 1.삭제요청!!
    	 String delNo = mainView.showInput("삭제번호:");//2.
    	 
    	 PersonDAO dao = new PersonDAO();//3.
    	 if(dao.delete(Integer.parseInt(delNo))) {//DB삭제성공
    		 //삭제된 정보를 JTable에 반영
    		 mainView.displayTable( dao.selectAll() );
    	 }else {
    		 mainView.showMsg("존재하지 않는 번호입니다!!");
    	 }
     }
	   
   }//actionPerformed
	
   public static void main(String[] args) {
	  new Controller();
   }


}
