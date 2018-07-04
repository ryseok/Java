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
		
		radio_id = new JRadioButton("���̵�",true); 
		radio_name = new JRadioButton("�̸�"); 
		radio_addr = new JRadioButton("�ּ�");
		
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
		  subp2.add(new JLabel("�˻���:"));
		  subp2.add(tf_search);
		  
		optionp = new JPanel();
		  optionp.setLayout(new GridLayout(2,1));
		
		optionp.add(subp1);  
		optionp.add(subp2);  
		  
		item_confirm = new JMenuItem("����");
		
		menu_admin = new JMenu("������");
		  menu_admin.add(item_confirm);
		bar = new JMenuBar();
		  bar.add(menu_admin);
		
		setJMenuBar(bar);
		
		
		Object rowData[][]= new String[0][7];		
		Object colNames[]={"ID","�̸�","����","����","��ȭ��ȣ","�ּ�","����"};		
		
		dtm = new DefaultTableModel(rowData, colNames);
		table = new JTable(dtm);	
		 
		JScrollPane scrol = new JScrollPane(table); 
		
	    bt_up = new JButton("����");
	    bt_del = new JButton("����");
	    bt_sel_all = new JButton("��ü����");
	    //bt_sel_id = new JButton("�̸��˻�");
	    bt_sel_id = new JButton("�˻�");
	    bt_exit = new JButton("����");
	    
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
	}//������	

	public void displayTable(ArrayList<Member> list) {
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		
		dtm.setRowCount(0);
		for(int i=0; i<list.size(); i++) {
			Member m = list.get(i);
			
		/*
		  <���׿�����>
		  ����)   ���ǽ�  ? A : B;
		      ==> ���ǽ� ����� ���̸� A ����, �����̸� B ����
		  
		 ���) �ڷ��� ������ =  10%2 == 0   ? "¦��" : "Ȧ��";
		  	
		*/
		   int ssn1 = m.getSsn1(); //900203
		   int ssn2 = m.getSsn2(); //1012345
			
		   int j = ssn2/1000000;
		   String gender = j%2==0 ? "����":"����";
			
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
	    //��, �ƴϿ�, ���, X  ---> 0,1,2,-1	
		if(t==0)return true;
		//else
		  return false;
	}//confirmMsg
	
	
	
	public  HashMap<String, String>  showOption() {
		HashMap<String, String> map = null;
		
		
	//���� Ÿ��  ==> String[] �Ǵ� ArrayList<String> �Ǵ� Map<String,String>	
	//List�������̽�(ArrayList,Vector)  ��  Map�������̽�(HashMap,HashTable)	
		
		//String []options= {"Ȯ��2","���2"};
		
	    int t = JOptionPane.showOptionDialog(this, optionp, "Search",
	    		        JOptionPane.OK_CANCEL_OPTION, 
	    		        JOptionPane.PLAIN_MESSAGE,//JOptionPane.ERROR_MESSAGE,// 
	    		        null,
	    		        null,//options,
	    		        null);//options[1]);
	    //t ==> Ȯ��,���,X  : 0,1,-1
	   if(t==0) { 
		  map =  new HashMap<>(); 
		   
	    String keyword = tf_search.getText();
	    System.out.println("t:"+ t +", �˻���:"+ keyword);	    
	    String title;//�׷� Ÿ��Ʋ ����
	    
		    if(radio_id.isSelected()) {
		    	title="���̵�";
		    }else if(radio_name.isSelected()) {
		    	title="�̸�";
		    }else {//�ּ� ����
		      	title="�ּ�";
		    }
	    
	      //map.put(String key, String value)
	      map.put("keyword", keyword);
	      map.put("title", title);
	   }
	   return map; 
	}//showOption
	
}//ServiceForm class





