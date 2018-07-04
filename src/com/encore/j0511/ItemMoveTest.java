package com.encore.j0511;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ItemMoveTest extends Frame implements ActionListener{
   List l_list,r_list;
   TextField l_tf, r_tf;
   Button bt_r, bt_r_all, bt_l, bt_l_all;
	
   Panel leftp,centerp,rightp;
   
   public ItemMoveTest() {
	   setTitle("Item움직이기");
	   
	   l_list = new List();
	   r_list = new List();
	   
	   l_tf = new TextField();
	   r_tf = new TextField();
	   
	   bt_r = new Button("▷");
	   bt_r_all = new Button("▶");
	   bt_l = new Button("◁");
	   bt_l_all = new Button("◀");
	   
	   leftp = new Panel();
	     leftp.setLayout(new BorderLayout());
	     leftp.add("Center",l_list);
	     leftp.add("South",l_tf);
	   
	   centerp = new Panel();
	     //centerp.setLayout(new GridLayout(6, 3, 0, 10));
	   centerp.setLayout(null);
	     centerp.setBackground(Color.ORANGE);
//	     centerp.add(new Label());centerp.add(new Label());centerp.add(new Label());
//	     centerp.add(new Label());centerp.add(bt_r);       centerp.add(new Label());
//	     centerp.add(new Label());centerp.add(bt_r_all);   centerp.add(new Label());
//	     centerp.add(new Label());centerp.add(bt_l);       centerp.add(new Label());
//	     centerp.add(new Label());centerp.add(bt_l_all);   centerp.add(new Label());
	     //bt_r.setBounds(x, y, width, height);
	     bt_r.setBounds(35, 40, 30, 30);
	     bt_r_all.setBounds(35, 90, 30, 30);
	     bt_l.setBounds(35, 140, 30, 30);
	     bt_l_all.setBounds(35, 190, 30, 30);
	     
	     centerp.add(bt_r);    
	     centerp.add(bt_r_all);    
	     centerp.add(bt_l);    
	     centerp.add(bt_l_all);    
	     
	     
	   rightp = new Panel();
	     rightp.setLayout(new BorderLayout());
	     rightp.add("Center",r_list);
	     rightp.add("South",r_tf);
	     
	   setLayout(new GridLayout(1, 3));  
	     add(leftp);
	     add(centerp);
	     add(rightp);
	     
	   setSize(300,300);
	   setVisible(true);
	   
	   addWindowListener(new WindowAdapter() {//익명의 내부클래스 anonymous inner클래스		   
		   public void windowClosing(WindowEvent e) {
				  System.exit(0);
	       }});
	   
	   //연결자
	   l_tf.addActionListener(this);
	   r_tf.addActionListener(this);
	   
	   bt_l.addActionListener(this);
	   bt_l_all.addActionListener(this);
	   bt_r.addActionListener(this);
	   bt_r_all.addActionListener(this);
   }//생성자

   @Override
   public void actionPerformed(ActionEvent e) {//EventHandler
	   Object ob = e.getSource();
	   if(ob == l_tf) {//좌측하단 텍스트필드 엔터키 입력
		   //1. 데이터 얻기
		   String str = l_tf.getText().trim();//trim(): 좌우 연속된 공백 제거하기 기능.
		         
		   System.out.println("왼쪽TextField입력값 STR=>>"+ str+"<<");
		   
		   //if(str.equals(""))//str에 빈문자열("")이 저장되었다면, 데이터입력없이 엔터를 쳤다면
		   //if(str.length()==0)//str에 빈문자열("")이 저장되었다면, 데이터입력없이 엔터를 쳤다면
			// return;  
		   
		  if(str.length()>0) { 
		   //2. 데이터 복사
		   l_list.add(str);
		  }
		   
		   //3. (기존)데이터 삭제
		   l_tf.setText("");
		   
	   }else if(ob == r_tf) {
		   String str = r_tf.getText().trim();
		  if(str.length()>0) {
		     r_list.add(str);
		  }
		   r_tf.setText("");
		   
	   }else if(ob == bt_r) {//좌측 리스트에서 선택된 item을 우측 리스트에 이동시키기
		  //String str = l_list.getSelectedItem();//1.
		  int idx = l_list.getSelectedIndex();//1. add된 순서의 인덱스 0~
		  
		  //idx검사!!
		  //if(idx!=-1) {실행할 문장}
		  
		  if(idx==-1) return;
		  
		  r_list.add( l_list.getItem(idx)  );//2.
		  //l_list.remove(str); //3. 중복되는 item이 있을 경우 무조건 가장 인덱스 작은 데이터 삭제!!
		  l_list.remove(idx);//position==index
		  
		  
	   }else if(ob == bt_r_all) {//좌측 리스트의 전체목록(item)을 우측리스트로 옮기기
		  for(int i=0; i< l_list.getItemCount();  i++) {//리스트의 인덱스를 표현
			 String str = l_list.getItem(i);//1.
			 r_list.add(str);//2.
			 //l_list.remove(i);//3.
		  }
		  l_list.removeAll();//좌측 리스트 전체지우기
		   
	   }else if(ob == bt_l) {
		   int idx = r_list.getSelectedIndex();			  
		   if(idx==-1) return;			  
		   l_list.add( r_list.getItem(idx)  );
		   r_list.remove(idx);
	   }else if(ob == bt_l_all) {
		   for(int i=0; i< r_list.getItemCount();  i++) {//리스트의 인덱스를 표현
				 String str = r_list.getItem(i);
				 l_list.add(str);
		   }
		   r_list.removeAll();
	   }
   }//actionPerformed
/*
    1. 버튼에 특수문자 나타내기
       ---> 키보드 한글 'ㅁ' 누르기
       ---> 한자키 누르기 
       ---> 특수문자 '▷'찾아서 선택하기
       
    2. 프레임 X버튼 눌렀을때 프로그램 종료하기
       ---> 기존 작성된 익명의 내부클래스 복사하고 붙여넣기
       ---> extends Frame시  : addWindowListener()
           Frame f 생성시 :  f.addWinodwListener()
      
    3. centerp패널(Grid(6,3))의 Button외의 빈 공간  
      --->  centerp.add(new Label()); 로 채워주기
    
    4. 기능추가를 위한 EventSource분석
       l_tf, r_tf ==> TextField 
       bt_r, bt_r_all, bt_l, bt_l_all ==> Button 
       
       Button클래스와 TextField클래스내의 메소드 중
       add로 시작~ Listener로 끝나는 메소드 찾기
       
       Button ---> addActionListener()!!
       TextField ---> addActionListener()!!
       
       ===> Button이 눌렸을때 
            TextField에 '엔터'키가 입력되었을때를
            Action사건이 발생한 것으로 정의함!!
       
    5. 기능추가
             첫번째, 데이터 얻기!!
             두번째, 데이터 전달(복사)!!
             세번째, 이전 데이터 삭제!!
             
             
    6. 프로그램 실행 중 예상치 못한 상황에 대한 처리!!
       - TextField입력된 데이터   -----> List 옮길때
               데이터가 입력되지 않고 엔터를 치면 빈줄이 List에 추가!!
               
       - '▷' 버튼 클릭시  만약 좌측리스트에 선택된 아이템이 없다면 
          IllegalArgumentException발생!!   <== getSelectedItem()경우
          ArrayIndexOutOfBoundsException발생!! <== getSelectedIndex()경우                     
 */
   
   public static void main(String[] args) {
	  new ItemMoveTest();
   }

}





