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
    <��Ʈ�ѷ��� ����> - ��ü ���α׷��� ���� �帧 ����!!
   1. ����� ��û �м� (��: � ��ư�� ��������)
   2. ����� �Է� ������ ������ (��: �Է��� �Ǵ� �������� ���� �Էµ� ������) 
   3. �𵨰�ü����(��: PersonDAO)
       - �޼ҵ�ȣ��
       - ����� (���ϰ�)����
   4. ������(��)�̵� (��: ����(JTable) ---> �Է���)
   
     ���û���) ��ȿ�� �˻�(valid check) <=== ����ڰ� �Է��� �����Ϳ� ����	
    */

   //����
   MainView mainView;
   InputForm form;
   UpForm upForm;
	
   public Controller() {
      mainView = new MainView();
      form = new InputForm();
      upForm = new UpForm();
      
      mainView.displayTable(new PersonDAO().selectAll());
      eventUp();
   }//������
   
   private void eventUp() {//�̺�Ʈ �ҽ� ���
	  //���κ�
	  mainView.bt_insert.addActionListener(this); 
	  mainView.bt_update.addActionListener(this); 
	  mainView.bt_del.addActionListener(this); 
	  mainView.bt_exit.addActionListener(this);
	  
	  //�Է���
	  form.bt_submit.addActionListener(this);
	  form.bt_cancel.addActionListener(this);
	  
	  //������
	  upForm.bt_submit.addActionListener(this);
	  upForm.bt_cancel.addActionListener(this);
   }//eventUp
   
   @Override
   public void actionPerformed(ActionEvent e) {
     Object ob = e.getSource();//action�̺�Ʈ�� �߻���Ų �̺�Ʈ �ҽ��� �ּ� ���
     
     if(ob == mainView.bt_insert) {//1. ���κ�: �Է¹�ư
    	 //4. ���κ� ---> �Է���  �̵�!!
    	 mainView.setVisible(false);
    	 form.setVisible(true);
    	 
     }else if(ob == form.bt_submit) {//1. �Է���: �Է¹�ư  (DB�Է¿�û)
    	 //2. �Էµ����� ���
    	 String name = form.tf_name.getText();
    	 String age = form.tf_age.getText();
    	 String job = form.tf_job.getText();
    	 
    	 
    	 boolean flag=true;
    	 
    	 //�ɼ�!!  ��ȿ���˻�
    	 //��üũ
    	 if(name == null || name.length()==0) {
    		 form.showMsg("�̸��Է�!!");
    	 }else if(age.equals("")) {
    		 form.showMsg("�����Է�!!");
    	 }else if(!age.matches("[0-9]+")) {//'����'�����Ϳ� ���� ���� üũ
    		 form.showMsg("�����Է�!!");
    		 form.tf_age.setText("");
         }else if(job.length()==0) {
    		 form.showMsg("�����Է�!!");
    	 }else {//������ ������!!
    		 flag=false;
    	 }
    	 
    	 if(flag)return;
    	 
    	 //name,age,job��   �ϳ��� p����(DTO)�� �����ֱ�
    	 Person p  = new Person(0, name, Integer.parseInt(age), job);
    	 
    	 //3. DB�Է�
    	 PersonDAO dao = new PersonDAO();
    	    //dao.insert(name,age,job);
    	 
    	  if(dao.insert(p)) {//�Է� ������!!
    		  
    		  mainView.displayTable(dao.selectAll());
    		  
    		  
    		  //4. �Է��� ---> ���κ� �̵�
    		  form.setVisible(false);
    		  mainView.setVisible(true);
    	  }
    	 
     }else if(ob==mainView.bt_update) {//1.���κ�: ������ư
    	String  no = mainView.showInput("������ȣ:");//2.
    	
    	PersonDAO dao = new PersonDAO(); //3.
    	  Person p = dao.select(Integer.parseInt(no));//Integer.parseInt(no)
    	
    	if(p != null) {//������ȣ�� �ش��ϴ� ������(Person)�� �������  
    		upForm.upNo = p.getNo();
    		
	    	upForm.tf_name.setText(p.getName());  
	    	upForm.tf_age.setText(p.getAge()+""); //tf.setText(String text)  
	    	upForm.tf_job.setText(p.getJob());
	    	
	    	mainView.setVisible(false);//4.
	    	upForm.setVisible(true);
    	}else {
    		mainView.showMsg("�������� �ʴ� ��ȣ�Դϴ�!!");
    	}
     }else if(ob== upForm.bt_submit) {//������: ������ư Ŭ�� 1.
    	 //upForm.tf_name.getText();
    	 String age = upForm.tf_age.getText();//2.
    	 String job = upForm.tf_job.getText();
    	 
    	 Person p = new Person();//no,name,age,job : 0,null,0,null
    	   p.setAge(Integer.parseInt(age)); //0,null,13,null
    	   p.setJob(job); //0,null,13,"�л�"
    	   p.setNo(upForm.upNo); //2,null,13,"�л�"
    	    
    	 
    	 PersonDAO dao = new PersonDAO();//3.
    	   if(dao.update(p)) {//DB �����۾� ��û
    	   
    	   //������ ������ JTable�� �ݿ�
    	   mainView.displayTable( dao.selectAll() );
    	   
    	     upForm.setVisible(false); //4.
    	     mainView.setVisible(true);
    	   }else {//��������!!
    		  upForm.showMsg("�Է°��� Ȯ���ϼ���!!"); 
    	   }
     }else if(ob == mainView.bt_del) {//���κ�: ������ư Ŭ�� 1.������û!!
    	 String delNo = mainView.showInput("������ȣ:");//2.
    	 
    	 PersonDAO dao = new PersonDAO();//3.
    	 if(dao.delete(Integer.parseInt(delNo))) {//DB��������
    		 //������ ������ JTable�� �ݿ�
    		 mainView.displayTable( dao.selectAll() );
    	 }else {
    		 mainView.showMsg("�������� �ʴ� ��ȣ�Դϴ�!!");
    	 }
     }
	   
   }//actionPerformed
	
   public static void main(String[] args) {
	  new Controller();
   }


}
