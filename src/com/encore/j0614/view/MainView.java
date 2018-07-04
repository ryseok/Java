package com.encore.j0614.view;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.encore.j0614.model.dto.Person;

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
	                      //[0]�� : ������ ��
               //������ ���� 0���� �ؾ� ������ addRow()�� 0�ε������� �߰���.
	 String []columnNames = {"��ȣ","�̸�","����","����"};
	 dtm=new DefaultTableModel(rowData, columnNames);
	 table = new JTable(dtm);
	 scroll_table = new JScrollPane(table);
	 
	 bt_insert = new JButton("�Է�"); 
	 bt_update = new JButton("����"); 
	 bt_del = new JButton("����"); 
	 bt_exit = new JButton("����");
	 
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
	 
	 
	 
   }//������
   
   @Override
   public void run() {
	   try {
			while(true) {
			  cal = Calendar.getInstance();//�ý��� ��¥������ ��� cal����!!
			  
			  String timeStr=cal.get(Calendar.YEAR)+"�� "
					        + (cal.get(Calendar.MONTH)+1)+"�� "
					        +cal.get(Calendar.DATE)+"�� "
					        +cal.get(Calendar.HOUR)+"�� "
					        +cal.get(Calendar.MINUTE)+"�� "
					        +cal.get(Calendar.SECOND)+"��"; 	 
			  la_time.setText(timeStr);
			    Thread.sleep(1000);
			 }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	   
   }
 
   
   public void displayTable(ArrayList<Person> list) {
	   dtm.setRowCount(0);//��µ� �������� ��ġ 0 ---> ù��°��
	   
	   for(int i=0; i< list.size(); i++) {
		   Person p = list.get(i);
		   Object rowData[]= {p.getNo(),p.getName(),p.getAge(),p.getJob()};
		   dtm.addRow(rowData);
	   }
   }//displayTable

   public void showMsg(String msg) {//���� ���� �Ǵ� ���� �޽��� ���
	   JOptionPane.showMessageDialog(this, msg);
   }//showMsg
   
   public String showInput(String msg) {//������ȣ �Ǵ� ������ȣ �Է�
	  return JOptionPane.showInputDialog(this,msg);
   }//showInput
   
}//MainView









