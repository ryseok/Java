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
	                             // ���û�� �ޱ����� Listener����
   //����
   MainView mainv;
   InputForm form;
   UpForm  upform;
   
   //�𵨵��
   Model m;
   FileReadWrite frw;
   FileReadWrite2 frw2;
   
   int no;//�߰��� Person�� �ο��� ������ ��ȣ
   int selNo;//������û�� ������ ��ȣ
   
   public Controller() {
      mainv = new MainView();
      form = new InputForm();
      upform = new UpForm();
      
      m = new Model();
      frw = new FileReadWrite();
      frw2 = new FileReadWrite2();
      
      //m.setPersonV(frw.fromFile());  
      //----> ���α׷� �����Ҷ� ����(person.txt)�� ����� Vector�� ����ȭ
      m.setPersonV(frw2.fromFile());  
      //----> ���α׷� �����Ҷ� ����(person.ser)�� ����� Vector�� ����ȭ
     
      if(m.getPersonV().size()>0) {
        int maxIdx = m.getPersonV().size()-1;
        no = m.getPersonV().get(maxIdx).getNo();
      }
      mainv.displayTable2(m.getPersonV());
      //mainv.displayTable(m.personToArray  (    m.getPersonV()));
      //JTable��� <------- Vector<Object[]> <------ Vector<Person>
      
      eventUp();
   }//������
   
   private void eventUp() {//�̺�Ʈ(�ҽ�) ���
	  //���κ�
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
	   
	  //�Է���
	  form.bt_submit.addActionListener(this);
	  form.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	//�Է��� ----> ���κ�
                 form.setVisible(false);
                 mainv.setVisible(true);
            }	     
	  });
	   
	  //������
	  upform.bt_submit.addActionListener(this);
	  upform.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
          	//������ ----> ���κ�
               upform.setVisible(false);
               mainv.setVisible(true);
          }	     
	  });
	  
	  
   }//eventUp
   
   
   @Override
   public void actionPerformed(ActionEvent e) {//�̺�Ʈ ó����
	 Object ob = e.getSource();
	 if(ob==mainv.bt_insert) {//1.���κ�:�Է¹�ư Ŭ��  (�Է��� ��û)
		//4.ȭ���̵�: ���κ� ---> �Է���
		form.initText(); 
		 
		mainv.setVisible(false);
		form.setVisible(true);
	 }else if(ob==form.bt_submit) {//1.�Է���:�Է¹�ư Ŭ�� (Vector�� ������ ���� ��û)
		//2.
		String name = form.tf_name.getText().trim();
		String age = form.tf_age.getText();
		String job = form.tf_job.getText();
		
		//5.��ȿ���˻� (�� üũ)
		if(name ==null  || name.equals("")) {
		   JOptionPane.showMessageDialog(form,"�̸��Է�!!");
		   form.tf_name.requestFocus();
		   //return;
		}else if(age.length() < 1) {
			JOptionPane.showMessageDialog(form,"�����Է�!!");
			form.tf_age.requestFocus();
		}else if(!age.matches("[\\d]+")){
			JOptionPane.showMessageDialog(form,"�����Է�!!");
			form.tf_age.setText("");//���ھƴѰ��� �ʱ�ȭ
			form.tf_age.requestFocus();
		}else if(job.length()==0) {
			JOptionPane.showMessageDialog(form,"�����Է�!!");
			form.tf_job.requestFocus();
		}else {//�̸�~����: �������� ������
			
			//��κ��� �Էµ� 3���� �����͸� �Ѱ��� ����(PersonŬ����)�� �����ϱ�
			Person addp = new Person(++no, name, Integer.parseInt(age), job);
			
			//3.
			m.insert(addp);//���Ϳ� p����
			
			Vector<Person> personv = m.selectAll(); //������ ��ü Person���� ���
			System.out.println(personv);
			
			Vector<Object[]> paramv = m.personToArray(personv);
			//Person���͸� �䰡 ���ϴ� Object[]���ͷ� ��ȯ
					
			mainv.displayTable(paramv);
			
			//4.
			form.setVisible(false);
			mainv.setVisible(true);	
		}
		
		
		
	 }else if(ob==mainv.bt_update) {//1.���κ�:������ư Ŭ��(�������� ��û)
		 
		int row = mainv.table.getSelectedRow(); //���õ� ���� (�ε���)����
		//���õ� ���� ù°���̶�� : row=0
		//���õ� ���� �ι�°���̶�� : row=1
		//���õ� ���� ���ٸ� : row=-1
		
		System.out.println("���õ� row="+ row);
		
		if(row == -1) {//���õ� ���� ���ٸ�
		   JOptionPane.showMessageDialog(mainv,"�����ϰ��� �ϴ� ���� ����!!");
		   return;//�޼ҵ� ����	
		}
		
		selNo = (int) mainv.table.getValueAt(row, 0);// 0�÷��� ��ȣ�÷����� ����!!
		                       // getValueAt(���ε���, ���ε���)                         
		
		Person oldp = m.select(selNo);//���Ϳ� ����� Person���� ���
		
		upform.tf_name.setText(oldp.getName());
		upform.tf_age.setText(oldp.getAge()+"");  //13+"" ---> "13"
		  //JTextField.setText(String text)   
		upform.tf_job.setText(oldp.getJob());
		
		//mainv.table.getValueAt(���ε���,���ε���); 
		//System.out.println(mainv.table.getValueAt(0,0)); //ù��° ���� ��ȣ ����
		//System.out.println(mainv.table.getValueAt(1,0)); //�ι�° ���� ��ȣ ����
		 
		//4. ���κ� ---> ������
		mainv.setVisible(false);
		upform.setVisible(true);
		
	 }else if(ob == upform.bt_submit) {//1.������: ������ư Ŭ�� ==> Vector�����ͼ�����û
		//�������� ��� 
		 String age = upform.tf_age.getText();
		 String job = upform.tf_job.getText();
		 
		 // 13 ---> ���ڿ� ��ȯ  ---->  13+""  �Ǵ� ""+13  ===> "13"
		 // "13" ---> ���� ��ȯ ---->  Integer.parseInt("13")  ===> 13
		 
		 //age,job�� newp�� �����ֱ�
		 Person newp = new Person();  //[no:0, name:null, age:0, job:null]
		    newp.setAge(Integer.parseInt(age)); //newp.setAge(int age)
 		           //[no:0, name:null, age:14, job:null]
		    newp.setJob(job);//[no:0, name:null, age:14, job:"���л�"]
		    newp.setNo(selNo);//[no:1, name:null, age:14, job:"���л�"]
		    
		    
		//Vector�� ����� Person�� ����
		 m.update(newp);
		 
		//JTable�� ����� Vector�� �ݿ�
		 Vector<Person> v = m.selectAll();//���� ��ü ��ȸ
		 Vector<Object[]> v2 = m.personToArray(v);//���κ�JTable���ϴ� ���� ��ȭ		 
		 mainv.displayTable(v2);
		 
		 //mainv.displayTable(m.personToArray(m.selectAll()));
		 
		//������ �̵� (������(upform) ---> ���κ�(mainv)) 
		upform.setVisible(false);
		mainv.setVisible(true);
	 }else if(ob == mainv.bt_del) {//1. ���κ�: ������ưŬ��  ==> Ư����ȣ�� Person�� Vector�� ���� ������û!!
		//��ȭ���ڸ� ���� ������ȣ �Է�
	    //JOptionPane.showInputDialog(Component parentComponent,Object message)	
		String delNo = JOptionPane.showInputDialog(mainv, "������ȣ:");	
		 
		//Vector�� ���� ��ġ�ϴ� ��ȣ�� ���� Person����
		boolean flag = m.delete(Integer.parseInt(delNo));  //"2"  ----> 2
		 
		if(!flag) {
			JOptionPane.showMessageDialog(mainv, "�������� �ʴ� ��ȣ�Դϴ�!!");
			return;
		}
		
		//������ Vector�� ���ų����� JTable �� �ݿ� - displayTable(Vector<Object[]>) 
	    mainv.displayTable(m.personToArray   (m.selectAll()));
     //	   JTable����  <---  Vector<Object[]> <--- Vector<Person>
		 
	 }else if(ob == mainv.bt_exit) {//1. ���κ�: �����ưŬ��  ==> ��ü �������α׷� ���� ��û!!
		 //frw.toFile(m.getPersonV());
		 //----> ���α׷� ���� ���� ���Ϳ� ���� ����ȭ!!
		 frw2.toFile(m.getPersonV());
		 
		 System.exit(0);
	 }
		
	 
   }//actionPerformed
   
   public static void main(String[] args) {
	  new Controller();
   }

}
