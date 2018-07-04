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
	//����) 1.2.3.4.  + �ɼ�
	
	//����
	LoginForm loginForm;
	JoinForm joinForm;
	UpdateForm upForm;
	ServiceForm serviceForm;
	
	String loginId;//�α����� ���̵� ����!!
	boolean adminFlag;//������ �α��� ���� ǥ��
	
    public Controller() {
	   loginForm = new LoginForm();
	   joinForm = new JoinForm();
	   upForm = new UpdateForm();
	   serviceForm = new ServiceForm();
    	
       eventUp();	
	}//������
	
    
    private void afterEventUp() {
      //ȸ��������
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
      //�α�����
      loginForm.bt_login.addActionListener(this);//�α���  ��ư	
      loginForm.bt_join.addActionListener(this);//�ű԰��� ��ư	
    	
      
      //ȸ������ ������
      upForm.bt_submit.addActionListener(this);
      upForm.bt_reset.addActionListener(this);
      upForm.addWindowListener(new WindowAdapter() {
    	 @Override
    	public void windowClosing(WindowEvent e) {
    	    upForm.setVisible(false);
    	    serviceForm.setVisible(true);
    	} 
	  });
      
      //���񽺺�
      serviceForm.bt_sel_all.addActionListener(this);//��ü����
      serviceForm.bt_sel_id.addActionListener(this);//�̸��˻�
      serviceForm.bt_up.addActionListener(this);//���� ��ư
      serviceForm.bt_del.addActionListener(this);//���� ��ư
      serviceForm.bt_exit.addActionListener(this);//���� ��ư
      
      serviceForm.item_confirm.addActionListener(this);//���� ������
      
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
       Object ob = e.getSource();//�̺�Ʈ �ҽ��� �ּ� ���
       
       if(ob==loginForm.bt_login) {//1. �α�����: �α��� ��ư Ŭ�� ==> �α��� ��û!!
    	  String id = loginForm.tf_id.getText(); //2.
    	  String pass = new String(loginForm.tf_pass.getPassword()); //2.
    	   
    	  //��ȿ���˻�(��)
    	  if(id.length()<1) {
    		  loginForm.showMsg("���̵��Է�!!");
    		  loginForm.tf_id.requestFocus();
    		  return;
    	  }
    	  
    	  if(pass.length()==0) {
    		  loginForm.showMsg("��й�ȣ�Է�!!"); 
    		  loginForm.tf_pass.requestFocus();
    		  return;
    	  }
    	  
    	  MemberDAO dao = new MemberDAO();
    	 if(dao.selectLogin2(id,pass)) {//�α��� ����
    		 loginForm.showMsg("�α��� ����^O^");
    		 
    		 //��Ʈ�ѷ��� ����� id����: ��? ������ �α����ߴ��� ���θ� üũ!!
    		 loginId = id;
    		 
    		 serviceForm.displayTable(dao.selectAll());
    		 
    	     loginForm.setVisible(false);
    	     serviceForm.setVisible(true);
    	  }else {
    		 //loginForm.showMsg("�α��� ����!!OTL");
    		  
    		 //loginForm.showMsg("���̵� �������� �ʽ��ϴ�!! �ű԰���?");
    		 //loginForm.showMsg("��й�ȣ�� ��ġ���� �ʽ��ϴ�!!");
    		  
    		  loginForm.showMsg("���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�!!");
    	  }
       }else if(ob == loginForm.bt_join) {//�α�����: �ű԰��� ��ư Ŭ�� 1.
    	   //4.
    	   joinForm = new JoinForm();
    	   afterEventUp();
    	   
    	   loginForm.setVisible(false);
    	   joinForm.setVisible(true);
       }else if(/*joinForm != null &&*/ ob == joinForm.bt_submit) {//ȸ��������: ��Ϲ�ư Ŭ�� 1.
    	  
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
    		  joinForm.showMsg("���̵��Է�!!");
    		  joinForm.tf_id.requestFocus();
    	  }else if(pass.length()==0) {
    		  joinForm.showMsg("����Է�!!");
    		  joinForm.tf_pass.requestFocus();
    	  }else if(pass2.length()==0) {
    		  joinForm.showMsg("����Է�!!");
    		  joinForm.tf_pass2.requestFocus();
    	  }else if(!pass.equals(pass2)) {
    		  joinForm.showMsg("��й�ȣ�� ��ġ�����ʽ��ϴ�!!");
    		  joinForm.tf_pass.setText("");
    		  joinForm.tf_pass2.setText("");
    		  joinForm.tf_pass.requestFocus();
    	  }else if(name.length()==0) {
    		  joinForm.showMsg("�̸��Է�!!");
    		  joinForm.tf_name.requestFocus();
    	  }else if(!ssn1.matches("[0-9]{6}") || !ssn1.matches("[\\d]{7}")) {
    		  joinForm.showMsg("�߸��� �ֹι�ȣ�Դϴ�!!");
    		  joinForm.tf_ssn1.setText("");
    		  joinForm.tf_ssn2.setText("");
    		  joinForm.tf_ssn1.requestFocus();
    	  }else {    	  
    	    Member m = new Member(id, pass, name, 
    			               Integer.parseInt(ssn1), 
    			               Integer.parseInt(ssn2), phone, addr, job);
    	  
    	    MemberDAO dao = new MemberDAO();//3.
    	     if(dao.insert(m)) {//�Է¼���
    	    	 joinForm.showMsg("ȸ�����Լ���!!^^*");
    	    	 joinForm.setVisible(false); //4.
    	    	 loginForm.setVisible(true);
    	     }else {//�Է½���
    	    	 joinForm.showMsg("�Է°��� Ȯ���ϼ���~!!");
    	     }
    	  }
       }else if(ob == serviceForm.bt_up) {//������ : ����
    	   
    	   String id;
    	      if(adminFlag)//������ ���� �޾�����
    	    	 id= serviceForm.showInput("�������̵�:");
    	      else //�Ϲ� ������� ���
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
    		   
    	   }else {//��ġ�ϴ� ���̵� DB���� ã�� ������ ��
    		   serviceForm.showMsg("�������� �ʴ� ���̵��Դϴ�!!");
    	   }
       }else if(ob== upForm.bt_submit) {//������: ��� ��ư Ŭ�� ==> ������û!!
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
    	     
    	   System.out.println("����Member>>"+m); 
    	   
    	   MemberDAO dao = new MemberDAO();
    	   if(dao.update(m)) {
    		  upForm.showMsg("������ �ߵǾ����ϴ�!!"); 
    		  
    		  //����� ������ JTable�� �ݿ�
    		  serviceForm.displayTable(dao.selectAll());
    		  
    		  upForm.setVisible(false);
    		  serviceForm.setVisible(true);
    	   }else {//������ �ȵǾ�����
    		  upForm.showMsg("�Է°��� Ȯ���ϼ���!!"); 
    	   }
       }else if(ob == serviceForm.bt_del) {//������: ������ư Ŭ�� ==> Ư�����̵� ���� ��û!!
    	  
    	  String id;
    	     if(adminFlag)//������ �����Ǿ�����
    	    	id = serviceForm.showInput("�������̵�:");
    	     else //�Ϲ� �����
    	    	id = loginId;
    	     
    	  //���� ���� ���� ����!!
    	  if(serviceForm.showConfirm("���� �����Ͻðڽ��ϱ�?")) {
    	  
    	  MemberDAO dao = new MemberDAO();
    	    if(dao.delete(id)) {
    	    	serviceForm.showMsg("����ó���Ǿ����ϴ�!!");
    	    	serviceForm.displayTable(dao.selectAll());
    	    }else {//���� ����
    	        serviceForm.showMsg("�������� �ʴ� ���̵��Դϴ�!!");	
    	    }
    	  }
       }else if(ob == serviceForm.bt_sel_id) {
    	   //������: '�̸��˻�' ��ư Ŭ����    ----> ������: '�˻�' ��ư Ŭ����
    	   
    	   HashMap<String, String> map =  serviceForm.showOption();
    	   
    	   if(map != null) {
    	     String title = map.get("title");
    	     String keyword = map.get("keyword");
    	     
    	     MemberDAO dao = new MemberDAO();
    	     serviceForm.displayTable(dao.selectKeyword(title,keyword));
    	   }
    	  //String name = serviceForm.showInput("�̸��˻�:");
    	  //MemberDAO dao = new MemberDAO();
    	  //serviceForm.displayTable( dao.selectNames(name) );
       }else if(ob == serviceForm.bt_sel_all) {//������: '��ü�˻�' ��ư Ŭ����
    	   MemberDAO dao = new MemberDAO();
    	   serviceForm.displayTable( dao.selectAll() );    	   
       }else if(ob == joinForm.bt_checkid) {//ȸ��������: '�ߺ�Ȯ��' ��ư Ŭ����
    	   duplicateCheck();
       }else if(ob == serviceForm.item_confirm) {//������ : '����' ������ ����
    	   //'admin' ���̵�� �α��� ���� üũ!!
    	   
    	   if(loginId.equals("admin")) {
    		   serviceForm.showMsg("������ �����Ǿ����ϴ�!!");
    		   adminFlag = true;
    		   
    	   }else {//�Ϲݻ����
    		   serviceForm.showMsg("������ �α����� �ʿ��մϴ�!!");
    		  if(serviceForm.showConfirm("������ �α��� �Ͻðڽ��ϱ�?")) {
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
 	   
 	   String id = joinForm.showInput("���̵�:");
 	   
 	   if(id==null) return;
 	   if(id.length()==0) {
 		  joinForm.showMsg("���̵� �Է��ϼ���!!");
 		  return;
 	   }
 	   
 	   MemberDAO dao = new MemberDAO();
 	     //if(dao.select(id) ==null) {��밡�ɾ��̵�!!}
 	     //else {������� ���̵�!!}
 	  
 	   if(dao.selectDuplicateId(id)) {//�ߺ��� ���̵� �ִٸ�
 		   joinForm.showMsg("�̹� ������� ���̵��Դϴ�!!"); 
 	   }else {
 		   joinForm.showMsg("��밡���� ���̵��Դϴ�!");
 		   if(joinForm.showConfirm("�� ���̵� ����Ͻðڽ��ϱ�?")) {
 			   joinForm.tf_id.setText(id);
 		   }
 	   }	
    }//duplicateCheck
    
	public static void main(String[] args) {
		new Controller();
	}


	
}
