package com.encore.j0511;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class HelloEventTest extends Frame implements ActionListener, ItemListener {
   TextField tf;
   Checkbox cb1,cb2,cb3;//<==이벤트소스  3개: Checkbox : addItemListener()
   Button bt_hello,bt_clear,bt_exit;//<==이벤트 소스 3개 : Button : addActionListener()
   
   Panel northp,centerp,southp;
   
   CheckboxGroup cg;//멤버변수: 클래스내의 메소드간의 공유 데이터!!
   
   public HelloEventTest() {
	   setTitle("안녕이벤트");
	   tf = new TextField(15);
	   
	   cg = new CheckboxGroup();
       cb1 = new Checkbox("자바초급", cg, true);
       cb2 = new Checkbox("자바중급", cg, false);
       cb3 = new Checkbox("자바고급", cg, false);
	   
       bt_hello = new Button("안녕");
       bt_clear = new Button("지우기");
       bt_exit = new Button("종료");
       
       //System.out.println("northp="+northp);
       //System.out.println("tf="+tf);
	   northp = new Panel();
	    northp.setBackground(Color.orange);
	    northp.add(tf);
	    
	   centerp = new Panel();
	    centerp.setLayout(new GridLayout(3, 1));
	    centerp.add(cb1);
	    centerp.add(cb2);
	    centerp.add(cb3);
	    
	   southp = new Panel();
	    southp.setBackground(Color.pink);
	    southp.add(bt_hello);
	    southp.add(bt_clear);
	    southp.add(bt_exit);
	   
	   add("North",northp);
	   add("Center",centerp);
	   add("South",southp);
	
	   setSize(350, 300);
	   setVisible(true);
	   
	   //감시 연결자 등록 
	   bt_hello.addActionListener(this);
	   bt_clear.addActionListener(this);
	   bt_exit.addActionListener(this);
	   
	   cb1.addItemListener(this);
	   cb2.addItemListener(this);
	   cb3.addItemListener(this);
   }//생성자
   
   @Override
   public void itemStateChanged(ItemEvent e) {//체크박스에 대한 이벤트 핸들러
	   tf.setText(cg.getSelectedCheckbox().getLabel()+"안녕~??");
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e) {//이벤트 핸들러(<=== 기능정의)
	   Object ob = e.getSource();//ob= bt_hello 또는 bt_clear 또는 bt_exit 중 눌려진 버튼의 주소값
	   if(ob == bt_hello) {//안녕 버튼 클릭시
		  
		  /*if(cb1.getState())//if(cb1이 선택된 상태라면) if(cb1.getState()==true) 
		    tf.setText("자바초급안녕~!!");
		  else if(cb2.getState())//else if(cb2가 선택된 상태라면)
		    tf.setText("자바중급안녕~!!"); 
		  else
			tf.setText("자바고급안녕~!!");*/ 
		  
		//CheckboxGroup cg  <----- cb1,cb2,cb3
		  Checkbox cb = cg.getSelectedCheckbox();//선택되어진 체크박스 (주소)정보 얻어오기 
		         //cb = cb1 또는 cb2 또는 cb3
		  /*if(cb == cb1) tf.setText("자바초급안녕~~!!");
		  else if(cb == cb2) tf.setText("자바중급안녕~~!!");
		  else if(cb == cb3) tf.setText("자바고급안녕~~!!");*/
		  tf.setText(cb.getLabel()+"안녕~!!!");
		   
		   
	   }else if(ob == bt_clear) {//지우기 버튼 클릭시
		  //tf.setText("지우기");
		  tf.setText(" "); 
		  tf.setText(""); 
	   }else {//if(ob == bt_exit){//종료 버튼 클릭시
		  System.exit(0);   
	   }
   }
   
   public static void main(String[] args) {
	  new HelloEventTest();
   }


}






