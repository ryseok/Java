package com.encore.person.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.encore.person.model.FileReadWrite;
import com.encore.person.model.FileReadWrite2;
import com.encore.person.model.Model;
import com.encore.person.model.Person;
import com.encore.person.view.InputForm;
import com.encore.person.view.MainView;
import com.encore.person.view.UpForm;

public class Controller implements ActionListener{
	                             // 뷰요청을 받기위한 Listener설정
   //뷰등록
   MainView mainv;
   InputForm form;
   UpForm  upform;
   
   //모델등록
   Model m;
   FileReadWrite frw;
   FileReadWrite2 frw2;
   
   int no;//추가될 Person에 부여할 유일한 번호
   int selNo;//수정요청시 저장할 번호
   
   public Controller() {
      mainv = new MainView();
      form = new InputForm();
      upform = new UpForm();
      
      m = new Model();
      frw = new FileReadWrite();
      frw2 = new FileReadWrite2();
      
      //m.setPersonV(frw.fromFile());  
      //----> 프로그램 시작할때 파일(person.txt)의 내용과 Vector를 동기화
      m.setPersonV(frw2.fromFile());  
      //----> 프로그램 시작할때 파일(person.ser)의 내용과 Vector를 동기화
     
      if(m.getPersonV().size()>0) {
        int maxIdx = m.getPersonV().size()-1;
        no = m.getPersonV().get(maxIdx).getNo();
      }
      mainv.displayTable2(m.getPersonV());
      //mainv.displayTable(m.personToArray  (    m.getPersonV()));
      //JTable출력 <------- Vector<Object[]> <------ Vector<Person>
      
      eventUp();
   }//생성자
   
   private void eventUp() {//이벤트(소스) 등록
	  //메인뷰
	  mainv.bt_insert.addActionListener(this);
	  mainv.bt_update.addActionListener(this);
	  mainv.bt_del.addActionListener(this);
	  mainv.bt_exit.addActionListener(this);
	  mainv.addWindowListener(new WindowAdapter() {
		  @Override
		public void windowClosing(WindowEvent e) {
			frw.toFile(m.getPersonV());
		    System.exit(0);
		}
	  });
	   
	  //입력폼
	  form.bt_submit.addActionListener(this);
	  form.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	//입력폼 ----> 메인뷰
                 form.setVisible(false);
                 mainv.setVisible(true);
            }	     
	  });
	   
	  //수정폼
	  upform.bt_submit.addActionListener(this);
	  upform.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
          	//수정폼 ----> 메인뷰
               upform.setVisible(false);
               mainv.setVisible(true);
          }	     
	  });
	  
	  
   }//eventUp
   
   
   @Override
   public void actionPerformed(ActionEvent e) {//이벤트 처리부
	 Object ob = e.getSource();
	 if(ob==mainv.bt_insert) {//1.메인뷰:입력버튼 클릭  (입력폼 요청)
		//4.화면이동: 메인뷰 ---> 입력폼
		form.initText(); 
		 
		mainv.setVisible(false);
		form.setVisible(true);
	 }else if(ob==form.bt_submit) {//1.입력폼:입력버튼 클릭 (Vector에 데이터 저장 요청)
		//2.
		String name = form.tf_name.getText().trim();
		String age = form.tf_age.getText();
		String job = form.tf_job.getText();
		
		//5.유효성검사 (빈값 체크)
		if(name ==null  || name.equals("")) {
		   JOptionPane.showMessageDialog(form,"이름입력!!");
		   form.tf_name.requestFocus();
		   //return;
		}else if(age.length() < 1) {
			JOptionPane.showMessageDialog(form,"나이입력!!");
			form.tf_age.requestFocus();
		}else if(!age.matches("[\\d]+")){
			JOptionPane.showMessageDialog(form,"숫자입력!!");
			form.tf_age.setText("");//숫자아닌값을 초기화
			form.tf_age.requestFocus();
		}else if(job.length()==0) {
			JOptionPane.showMessageDialog(form,"직업입력!!");
			form.tf_job.requestFocus();
		}else {//이름~직업: 정상적인 데이터
			
			//뷰로부터 입력된 3개의 데이터를 한개의 변수(Person클래스)로 저장하기
			Person addp = new Person(++no, name, Integer.parseInt(age), job);
			
			//3.
			m.insert(addp);//벡터에 p저장
			
			Vector<Person> personv = m.selectAll(); //벡터의 전체 Person정보 얻기
			System.out.println(personv);
			
			Vector<Object[]> paramv = m.personToArray(personv);
			//Person벡터를 뷰가 원하는 Object[]벡터로 변환
					
			mainv.displayTable(paramv);
			
			//4.
			form.setVisible(false);
			mainv.setVisible(true);	
		}
		
		
		
	 }else if(ob==mainv.bt_update) {//1.메인뷰:수정버튼 클릭(수정폼을 요청)
		 
		int row = mainv.table.getSelectedRow(); //선택된 행의 (인덱스)정보
		//선택된 행이 첫째행이라면 : row=0
		//선택된 행이 두번째행이라면 : row=1
		//선택된 행이 없다면 : row=-1
		
		System.out.println("선택된 row="+ row);
		
		if(row == -1) {//선택된 행이 없다면
		   JOptionPane.showMessageDialog(mainv,"수정하고자 하는 행을 선택!!");
		   return;//메소드 종료	
		}
		
		selNo = (int) mainv.table.getValueAt(row, 0);// 0컬럼은 번호컬럼으로 고정!!
		                       // getValueAt(행인덱스, 열인덱스)                         
		
		Person oldp = m.select(selNo);//벡터에 저장된 Person정보 얻기
		
		upform.tf_name.setText(oldp.getName());
		upform.tf_age.setText(oldp.getAge()+"");  //13+"" ---> "13"
		  //JTextField.setText(String text)   
		upform.tf_job.setText(oldp.getJob());
		
		//mainv.table.getValueAt(행인덱스,열인덱스); 
		//System.out.println(mainv.table.getValueAt(0,0)); //첫번째 행의 번호 정보
		//System.out.println(mainv.table.getValueAt(1,0)); //두번째 행의 번호 정보
		 
		//4. 메인뷰 ---> 수정폼
		mainv.setVisible(false);
		upform.setVisible(true);
		
	 }else if(ob == upform.bt_submit) {//1.수정폼: 수정버튼 클릭 ==> Vector데이터수정요청
		//수정정보 얻기 
		 String age = upform.tf_age.getText();
		 String job = upform.tf_job.getText();
		 
		 // 13 ---> 문자열 변환  ---->  13+""  또는 ""+13  ===> "13"
		 // "13" ---> 숫자 변환 ---->  Integer.parseInt("13")  ===> 13
		 
		 //age,job을 newp로 묶어주기
		 Person newp = new Person();  //[no:0, name:null, age:0, job:null]
		    newp.setAge(Integer.parseInt(age)); //newp.setAge(int age)
 		           //[no:0, name:null, age:14, job:null]
		    newp.setJob(job);//[no:0, name:null, age:14, job:"중학생"]
		    newp.setNo(selNo);//[no:1, name:null, age:14, job:"중학생"]
		    
		    
		//Vector에 저장된 Person을 수정
		 m.update(newp);
		 
		//JTable에 변경된 Vector를 반영
		 Vector<Person> v = m.selectAll();//벡터 전체 조회
		 Vector<Object[]> v2 = m.personToArray(v);//메인뷰JTable원하는 벡터 변화		 
		 mainv.displayTable(v2);
		 
		 //mainv.displayTable(m.personToArray(m.selectAll()));
		 
		//페이지 이동 (수정폼(upform) ---> 메인뷰(mainv)) 
		upform.setVisible(false);
		mainv.setVisible(true);
	 }else if(ob == mainv.bt_del) {//1. 메인뷰: 삭제버튼클릭  ==> 특정번호의 Person을 Vector로 부터 삭제요청!!
		//대화상자를 통한 삭제번호 입력
	    //JOptionPane.showInputDialog(Component parentComponent,Object message)	
		String delNo = JOptionPane.showInputDialog(mainv, "삭제번호:");	
		 
		//Vector로 부터 일치하는 번호를 가진 Person삭제
		boolean flag = m.delete(Integer.parseInt(delNo));  //"2"  ----> 2
		 
		if(!flag) {
			JOptionPane.showMessageDialog(mainv, "존재하지 않는 번호입니다!!");
			return;
		}
		
		//삭제된 Vector의 갱신내용을 JTable 에 반영 - displayTable(Vector<Object[]>) 
	    mainv.displayTable(m.personToArray   (m.selectAll()));
     //	   JTable갱신  <---  Vector<Object[]> <--- Vector<Person>
		 
	 }else if(ob == mainv.bt_exit) {//1. 메인뷰: 종료버튼클릭  ==> 전체 응용프로그램 종료 요청!!
		 //frw.toFile(m.getPersonV());
		 //----> 프로그램 종료 직전 벡터와 파일 동기화!!
		 frw2.toFile(m.getPersonV());
		 
		 System.exit(0);
	 }
		
	 
   }//actionPerformed
   
   public static void main(String[] args) {
	  new Controller();
   }

}
