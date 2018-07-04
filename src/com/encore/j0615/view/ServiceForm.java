package com.encore.j0615.view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.encore.j0615.model.vo.Member;

public class ServiceForm extends JFrame {
	public JTable table;
	JLabel la;
	DefaultTableModel dtm;
    
	public JButton bt_up, bt_del, bt_sel_all, bt_sel_id, bt_exit;
	JPanel southp;
	
	public JMenuItem item_confirm;
	JMenu  menu_admin;
	JMenuBar bar;
	
	JRadioButton radio_id,radio_name,radio_addr;
	ButtonGroup bg;
	JTextField tf_search;
	JPanel optionp,subp1,subp2;
	
	public ServiceForm() {
		setTitle("Display Data");
		
		radio_id = new JRadioButton("아이디",true); 
		radio_name = new JRadioButton("이름"); 
		radio_addr = new JRadioButton("주소");
		
		bg = new ButtonGroup();
		  bg.add(radio_id);
		  bg.add(radio_name);
		  bg.add(radio_addr);
		
		subp1 = new JPanel();
		  subp1.add(radio_id);
		  subp1.add(radio_name);
		  subp1.add(radio_addr);
		  
		tf_search = new JTextField(15);  
		  
		subp2 = new JPanel();
		  subp2.add(new JLabel("검색어:"));
		  subp2.add(tf_search);
		  
		optionp = new JPanel();
		  optionp.setLayout(new GridLayout(2,1));
		
		optionp.add(subp1);  
		optionp.add(subp2);  
		  
		item_confirm = new JMenuItem("인증");
		
		menu_admin = new JMenu("관리자");
		  menu_admin.add(item_confirm);
		bar = new JMenuBar();
		  bar.add(menu_admin);
		
		setJMenuBar(bar);
		
		
		Object rowData[][]= new String[0][7];		
		Object colNames[]={"ID","이름","나이","성별","전화번호","주소","직업"};		
		
		dtm = new DefaultTableModel(rowData, colNames);
		table = new JTable(dtm);	
		 
		JScrollPane scrol = new JScrollPane(table); 
		
	    bt_up = new JButton("수정");
	    bt_del = new JButton("삭제");
	    bt_sel_all = new JButton("전체보기");
	    //bt_sel_id = new JButton("이름검색");
	    bt_sel_id = new JButton("검색");
	    bt_exit = new JButton("종료");
	    
	    southp = new JPanel();
	      southp.add(bt_sel_all);
	      southp.add(bt_up);
	      southp.add(bt_del);
	      southp.add(bt_sel_id);
	      southp.add(bt_exit);
		
		add("Center", scrol);
		add("South", southp);
		
		setBounds(300,200,500,300);
		setResizable(false);	
	}//생성자	

	public void displayTable(ArrayList<Member> list) {
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		
		dtm.setRowCount(0);
		for(int i=0; i<list.size(); i++) {
			Member m = list.get(i);
			
		/*
		  <삼항연산자>
		  형식)   조건식  ? A : B;
		      ==> 조건식 결과가 참이면 A 리턴, 거짓이면 B 리턴
		  
		 사용) 자료형 변수명 =  10%2 == 0   ? "짝수" : "홀수";
		  	
		*/
		   int ssn1 = m.getSsn1(); //900203
		   int ssn2 = m.getSsn2(); //1012345
			
		   int j = ssn2/1000000;
		   String gender = j%2==0 ? "여자":"남자";
			
		   int age;
		    if(j<3)
		      age= year - (1900+ ssn1/10000) +1;
		    else
		      age= year - (2000+ ssn1/10000) +1;
		   
		   Object []rowData= {m.getId(),
				   m.getName(),age, gender, m.getPhone(), m.getAddr(), m.getJob()};	
			
			dtm.addRow(rowData);
		}
		
	}//displayTable
	
	public String showInput(String msg) {
		return JOptionPane.showInputDialog(this,msg);
	}
	
	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this,msg);
	}
	
	public boolean showConfirm(String msg) {
		int t = JOptionPane.showConfirmDialog(this, msg);
	    //예, 아니오, 취소, X  ---> 0,1,2,-1	
		if(t==0)return true;
		//else
		  return false;
	}//confirmMsg
	
	
	
	public  HashMap<String, String>  showOption() {
		HashMap<String, String> map = null;
		
		
	//리턴 타입  ==> String[] 또는 ArrayList<String> 또는 Map<String,String>	
	//List인터페이스(ArrayList,Vector)  와  Map인터페이스(HashMap,HashTable)	
		
		//String []options= {"확인2","취소2"};
		
	    int t = JOptionPane.showOptionDialog(this, optionp, "Search",
	    		        JOptionPane.OK_CANCEL_OPTION, 
	    		        JOptionPane.PLAIN_MESSAGE,//JOptionPane.ERROR_MESSAGE,// 
	    		        null,
	    		        null,//options,
	    		        null);//options[1]);
	    //t ==> 확인,취소,X  : 0,1,-1
	   if(t==0) { 
		  map =  new HashMap<>(); 
		   
	    String keyword = tf_search.getText();
	    System.out.println("t:"+ t +", 검색어:"+ keyword);	    
	    String title;//그룹 타이틀 저장
	    
		    if(radio_id.isSelected()) {
		    	title="아이디";
		    }else if(radio_name.isSelected()) {
		    	title="이름";
		    }else {//주소 선택
		      	title="주소";
		    }
	    
	      //map.put(String key, String value)
	      map.put("keyword", keyword);
	      map.put("title", title);
	   }
	   return map; 
	}//showOption
	
}//ServiceForm class





