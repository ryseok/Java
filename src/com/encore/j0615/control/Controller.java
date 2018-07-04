package com.encore.j0615.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import com.encore.j0615.model.dao.MemberDAO;
import com.encore.j0615.model.vo.Member;
import com.encore.j0615.view.JoinForm;
import com.encore.j0615.view.LoginForm;
import com.encore.j0615.view.ServiceForm;
import com.encore.j0615.view.UpdateForm;

public class Controller implements ActionListener{
	//역할) 1.2.3.4.  + 옵션
	
	//뷰등록
	LoginForm loginForm;
	JoinForm joinForm;
	UpdateForm upForm;
	ServiceForm serviceForm;
	
	String loginId;//로그인한 아이디 저장!!
	boolean adminFlag;//관리자 로그인 상태 표현
	
    public Controller() {
	   loginForm = new LoginForm();
	   joinForm = new JoinForm();
	   upForm = new UpdateForm();
	   serviceForm = new ServiceForm();
    	
       eventUp();	
	}//생성자
	
    
    private void afterEventUp() {
      //회원가입폼
	    joinForm.bt_submit.addActionListener(this);
	    joinForm.bt_reset.addActionListener(this);
	    joinForm.bt_checkid.addActionListener(this);
	    joinForm.tf_id.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		duplicateCheck();
	    	}
		});
	    joinForm.addWindowListener(new WindowAdapter() {
	    	 @Override
	    	public void windowClosing(WindowEvent e) {
	    		loginForm.initForm(); 
	    		 
	    	    joinForm.setVisible(false);
	    	    loginForm.setVisible(true);
	    	} 
		  });
    }
    
    private void eventUp() {
      //로그인폼
      loginForm.bt_login.addActionListener(this);//로그인  버튼	
      loginForm.bt_join.addActionListener(this);//신규가입 버튼	
    	
      
      //회원정보 수정폼
      upForm.bt_submit.addActionListener(this);
      upForm.bt_reset.addActionListener(this);
      upForm.addWindowListener(new WindowAdapter() {
    	 @Override
    	public void windowClosing(WindowEvent e) {
    	    upForm.setVisible(false);
    	    serviceForm.setVisible(true);
    	} 
	  });
      
      //서비스뷰
      serviceForm.bt_sel_all.addActionListener(this);//전체보기
      serviceForm.bt_sel_id.addActionListener(this);//이름검색
      serviceForm.bt_up.addActionListener(this);//수정 버튼
      serviceForm.bt_del.addActionListener(this);//삭제 버튼
      serviceForm.bt_exit.addActionListener(this);//종료 버튼
      
      serviceForm.item_confirm.addActionListener(this);//인증 아이템
      
      serviceForm.addWindowListener(new WindowAdapter() {
     	 @Override
     	public void windowClosing(WindowEvent e) {
     		loginForm.initForm(); 
     		 
     	    serviceForm.setVisible(false);
     	    loginForm.setVisible(true);
     	} 
 	  });
    }//eventUp
    
    @Override
    public void actionPerformed(ActionEvent e) {    
       Object ob = e.getSource();//이벤트 소스의 주소 얻기
       
       if(ob==loginForm.bt_login) {//1. 로그인폼: 로그인 버튼 클릭 ==> 로그인 요청!!
    	  String id = loginForm.tf_id.getText(); //2.
    	  String pass = new String(loginForm.tf_pass.getPassword()); //2.
    	   
    	  //유효성검사(빈값)
    	  if(id.length()<1) {
    		  loginForm.showMsg("아이디입력!!");
    		  loginForm.tf_id.requestFocus();
    		  return;
    	  }
    	  
    	  if(pass.length()==0) {
    		  loginForm.showMsg("비밀번호입력!!"); 
    		  loginForm.tf_pass.requestFocus();
    		  return;
    	  }
    	  
    	  MemberDAO dao = new MemberDAO();
    	 if(dao.selectLogin2(id,pass)) {//로그인 성공
    		 loginForm.showMsg("로그인 성공^O^");
    		 
    		 //컨트롤러의 멤버에 id저장: 왜? 관리자 로그인했는지 여부를 체크!!
    		 loginId = id;
    		 
    		 serviceForm.displayTable(dao.selectAll());
    		 
    	     loginForm.setVisible(false);
    	     serviceForm.setVisible(true);
    	  }else {
    		 //loginForm.showMsg("로그인 실패!!OTL");
    		  
    		 //loginForm.showMsg("아이디가 존재하지 않습니다!! 신규가입?");
    		 //loginForm.showMsg("비밀번호가 일치하지 않습니다!!");
    		  
    		  loginForm.showMsg("아이디 또는 비밀번호가 일치하지 않습니다!!");
    	  }
       }else if(ob == loginForm.bt_join) {//로그인폼: 신규가입 버튼 클릭 1.
    	   //4.
    	   joinForm = new JoinForm();
    	   afterEventUp();
    	   
    	   loginForm.setVisible(false);
    	   joinForm.setVisible(true);
       }else if(/*joinForm != null &&*/ ob == joinForm.bt_submit) {//회원가입폼: 등록버튼 클릭 1.
    	  
    	  String id = joinForm.tf_id.getText();
    	  String pass =  new String(joinForm.tf_pass.getPassword());
    	  String pass2 = new String(joinForm.tf_pass2.getPassword());
    	  String name = joinForm.tf_name.getText();
    	  String ssn1 = joinForm.tf_ssn1.getText();
    	  String ssn2 = new String(joinForm.tf_ssn2.getPassword());
    	  String phone = joinForm.tf_phone1.getText()+"-"+
    	                 joinForm.tf_phone2.getText()+"-"+
    	                 joinForm.tf_phone3.getText();
    	  String addr = joinForm.tf_addr.getText();
    	  String job =  (String) joinForm.cb_job.getSelectedItem();
    	  
    	  if(id.length()==0) {
    		  joinForm.showMsg("아이디입력!!");
    		  joinForm.tf_id.requestFocus();
    	  }else if(pass.length()==0) {
    		  joinForm.showMsg("비번입력!!");
    		  joinForm.tf_pass.requestFocus();
    	  }else if(pass2.length()==0) {
    		  joinForm.showMsg("비번입력!!");
    		  joinForm.tf_pass2.requestFocus();
    	  }else if(!pass.equals(pass2)) {
    		  joinForm.showMsg("비밀번호가 일치하지않습니다!!");
    		  joinForm.tf_pass.setText("");
    		  joinForm.tf_pass2.setText("");
    		  joinForm.tf_pass.requestFocus();
    	  }else if(name.length()==0) {
    		  joinForm.showMsg("이름입력!!");
    		  joinForm.tf_name.requestFocus();
    	  }else if(!ssn1.matches("[0-9]{6}") || !ssn1.matches("[\\d]{7}")) {
    		  joinForm.showMsg("잘못된 주민번호입니다!!");
    		  joinForm.tf_ssn1.setText("");
    		  joinForm.tf_ssn2.setText("");
    		  joinForm.tf_ssn1.requestFocus();
    	  }else {    	  
    	    Member m = new Member(id, pass, name, 
    			               Integer.parseInt(ssn1), 
    			               Integer.parseInt(ssn2), phone, addr, job);
    	  
    	    MemberDAO dao = new MemberDAO();//3.
    	     if(dao.insert(m)) {//입력성공
    	    	 joinForm.showMsg("회원가입성공!!^^*");
    	    	 joinForm.setVisible(false); //4.
    	    	 loginForm.setVisible(true);
    	     }else {//입력실패
    	    	 joinForm.showMsg("입력값을 확인하세요~!!");
    	     }
    	  }
       }else if(ob == serviceForm.bt_up) {//서비스폼 : 수정
    	   
    	   String id;
    	      if(adminFlag)//관리자 인증 받았을때
    	    	 id= serviceForm.showInput("수정아이디:");
    	      else //일반 사용자의 경우
    	    	 id= loginId;
    	   MemberDAO dao = new MemberDAO();
    	      Member m = dao.select(id);
    	   if(m != null) {
    		   upForm.tf_id.setText(m.getId());
    		     String pass = m.getPass();
    		   upForm.tf_pass.setText(pass);   
    		   upForm.tf_pass2.setText(pass);
    		   
    		   upForm.tf_name.setText(m.getName());   
    		   upForm.tf_ssn1.setText(m.getSsn1()+"");   
    		   upForm.tf_ssn2.setText(m.getSsn2()+"");
    		     //String phone =  m.getPhone();
    		     //phone = "010-1234-5678"
    		     String []phones =  m.getPhone().split("-");
    		     //phones = {"010","1234","5678"};
    		     
    		   upForm.tf_phone1.setText(phones[0]);   
    		   upForm.tf_phone2.setText(phones[1]);   
    		   upForm.tf_phone3.setText(phones[2]);   
    		   
    		   upForm.tf_addr.setText(m.getAddr());   
    		   upForm.cb_job.setSelectedItem(m.getJob());
    		   
    		   serviceForm.setVisible(false);
    		   upForm.setVisible(true);
    		   
    	   }else {//일치하는 아이디를 DB에서 찾지 못했을 때
    		   serviceForm.showMsg("존재하지 않는 아이디입니다!!");
    	   }
       }else if(ob== upForm.bt_submit) {//수정폼: 등록 버튼 클릭 ==> 수정요청!!
    	   String id = upForm.tf_id.getText();
    	   String pass = new String(upForm.tf_pass.getPassword());
    	   String phone = upForm.tf_phone1.getText()+"-"+
    	                  upForm.tf_phone2.getText()+"-"+
    	                  upForm.tf_phone3.getText();
    	   String addr = upForm.tf_addr.getText();
    	   String job = (String) upForm.cb_job.getSelectedItem();
    	   
    	   Member m = new Member();
    	     m.setId(id);
    	     m.setPass(pass);
    	     m.setPhone(phone);
    	     m.setAddr(addr);
    	     m.setJob(job);
    	     
    	   System.out.println("수정Member>>"+m); 
    	   
    	   MemberDAO dao = new MemberDAO();
    	   if(dao.update(m)) {
    		  upForm.showMsg("수정이 잘되었습니다!!"); 
    		  
    		  //변경된 내용을 JTable에 반영
    		  serviceForm.displayTable(dao.selectAll());
    		  
    		  upForm.setVisible(false);
    		  serviceForm.setVisible(true);
    	   }else {//수정이 안되었을때
    		  upForm.showMsg("입력값을 확인하세요!!"); 
    	   }
       }else if(ob == serviceForm.bt_del) {//서비스폼: 삭제버튼 클릭 ==> 특정아이디 삭제 요청!!
    	  
    	  String id;
    	     if(adminFlag)//관리자 인증되었을때
    	    	id = serviceForm.showInput("삭제아이디:");
    	     else //일반 사용자
    	    	id = loginId;
    	     
    	  //삭제 진행 여부 묻기!!
    	  if(serviceForm.showConfirm("정말 삭제하시겠습니까?")) {
    	  
    	  MemberDAO dao = new MemberDAO();
    	    if(dao.delete(id)) {
    	    	serviceForm.showMsg("삭제처리되었습니다!!");
    	    	serviceForm.displayTable(dao.selectAll());
    	    }else {//삭제 실패
    	        serviceForm.showMsg("존재하지 않는 아이디입니다!!");	
    	    }
    	  }
       }else if(ob == serviceForm.bt_sel_id) {
    	   //서비스폼: '이름검색' 버튼 클릭시    ----> 서비스폼: '검색' 버튼 클릭시
    	   
    	   HashMap<String, String> map =  serviceForm.showOption();
    	   
    	   if(map != null) {
    	     String title = map.get("title");
    	     String keyword = map.get("keyword");
    	     
    	     MemberDAO dao = new MemberDAO();
    	     serviceForm.displayTable(dao.selectKeyword(title,keyword));
    	   }
    	  //String name = serviceForm.showInput("이름검색:");
    	  //MemberDAO dao = new MemberDAO();
    	  //serviceForm.displayTable( dao.selectNames(name) );
       }else if(ob == serviceForm.bt_sel_all) {//서비스폼: '전체검색' 버튼 클릭시
    	   MemberDAO dao = new MemberDAO();
    	   serviceForm.displayTable( dao.selectAll() );    	   
       }else if(ob == joinForm.bt_checkid) {//회원가입폼: '중복확인' 버튼 클릭시
    	   duplicateCheck();
       }else if(ob == serviceForm.item_confirm) {//서비스폼 : '인증' 아이템 선택
    	   //'admin' 아이디로 로그인 여부 체크!!
    	   
    	   if(loginId.equals("admin")) {
    		   serviceForm.showMsg("관리자 인증되었습니다!!");
    		   adminFlag = true;
    		   
    	   }else {//일반사용자
    		   serviceForm.showMsg("관리자 로그인이 필요합니다!!");
    		  if(serviceForm.showConfirm("관리자 로그인 하시겠습니까?")) {
    			   loginForm.tf_id.setText("");
    			   loginForm.tf_pass.setText("");
    			  
    			   serviceForm.setVisible(false);
    			   loginForm.setVisible(true);
    		  }
    	   }
    	   
       }
    }//actionPerformed
    
    
    private void duplicateCheck() {
    	//String id = joinForm.tf_id.getText();
 	   
 	   String id = joinForm.showInput("아이디:");
 	   
 	   if(id==null) return;
 	   if(id.length()==0) {
 		  joinForm.showMsg("아이디를 입력하세요!!");
 		  return;
 	   }
 	   
 	   MemberDAO dao = new MemberDAO();
 	     //if(dao.select(id) ==null) {사용가능아이디!!}
 	     //else {사용중인 아이디!!}
 	  
 	   if(dao.selectDuplicateId(id)) {//중복된 아이디가 있다면
 		   joinForm.showMsg("이미 사용중인 아이디입니다!!"); 
 	   }else {
 		   joinForm.showMsg("사용가능한 아이디입니다!");
 		   if(joinForm.showConfirm("이 아이디를 사용하시겠습니까?")) {
 			   joinForm.tf_id.setText(id);
 		   }
 	   }	
    }//duplicateCheck
    
	public static void main(String[] args) {
		new Controller();
	}


	
}
