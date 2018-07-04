package com.encore.person.view;

import java.util.Calendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.encore.person.model.Person;

public class MainView extends JFrame implements Runnable{
   DefaultTableModel dtm;
   public JTable table;
   JScrollPane scroll_table;
   
   public JButton bt_insert, bt_update, bt_del, bt_exit;
   JLabel la_time;	
   
   JPanel southp,northp;
   Calendar cal;
   
   public MainView() {
	 setTitle("MainView");
	 Object [][]rowData = new Object[0][4];
	                      //[0]행 : 생성될 행
               //생성될 행을 0으로 해야 앞으로 addRow()가 0인덱스부터 추가됨.
	 String []columnNames = {"번호","이름","나이","직업"};
	 dtm=new DefaultTableModel(rowData, columnNames);
	 table = new JTable(dtm);
	 scroll_table = new JScrollPane(table);
	 
	 bt_insert = new JButton("입력"); 
	 bt_update = new JButton("수정"); 
	 bt_del = new JButton("삭제"); 
	 bt_exit = new JButton("종료");
	 
	 la_time = new JLabel();
	 
	 southp = new JPanel();
	 southp.add(bt_insert);
	 southp.add(bt_update);
	 southp.add(bt_del);
	 southp.add(bt_exit);
	 
	 northp = new JPanel();
	  northp.add(la_time);
	 
	 add("Center",scroll_table);
	 add("South",southp);
	 add("North",northp);
	 
	 Thread t = new Thread(this);
	 t.start();
	 
	 setBounds(300,200,350,300);
	 setVisible(true);
	 //setDefaultCloseOperation(EXIT_ON_CLOSE);
	 
	 
	 
   }//생성자
   
   @Override
   public void run() {
	   try {
			while(true) {
			  cal = Calendar.getInstance();//시스템 날짜정보를 얻어 cal저장!!
			  
			  String timeStr=cal.get(Calendar.YEAR)+"년 "
					        + (cal.get(Calendar.MONTH)+1)+"월 "
					        +cal.get(Calendar.DATE)+"일 "
					        +cal.get(Calendar.HOUR)+"시 "
					        +cal.get(Calendar.MINUTE)+"분 "
					        +cal.get(Calendar.SECOND)+"초"; 	 
			  la_time.setText(timeStr);
			    Thread.sleep(1000);
			 }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	   
   }
   
   
   public void displayTable(Vector<Object[]> v) {
	   dtm.setRowCount(0);//출력될 포인트 행을 0으로 셋팅
	   
	  //dtm.addRow(Object[] rowData);
	   for(int i=0; i<v.size(); i++) {
		   Object [] rowData = v.get(i);
		   dtm.addRow(rowData);
	   }
   }//displayTable
   
   public void displayTable2(Vector<Person> v) {
	   dtm.setRowCount(0);//출력될 시작행의 위치 0 ---> 첫번째행
	   
	   for(int i=0; i<v.size(); i++) {
		   Person p = v.get(i);
		   Object rowData[]= {p.getNo(),p.getName(),p.getAge(),p.getJob()};
		   dtm.addRow(rowData);
	   }
   }//displayTable

   
}//MainView









