package com.encore.j0614.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.encore.j0614.model.dto.Person;

public class PersonDAO {//DAO : Data(Base) Access Object
	                    //       ----> DB ���� Ŭ����	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	Properties pro;
	
	
	public PersonDAO() {
		try {
			pro = new Properties();
			pro.load(new FileReader("conn/conn.properties"));//driver,url,user,pass
			
			Class.forName(pro.getProperty("driver"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//������
	
	private void connect() {
		try {
			/*conn = DriverManager.getConnection(pro.getProperty("url"),
					                           pro.getProperty("user"),
					                           pro.getProperty("password"));*/
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);
			System.out.println("DB���� ����!!^^*");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//connect
	
	private void disconnect() {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//disconnect
	
	
    //---------DML-------------
	public boolean insert(Person p) {
	  connect();	
	  try {
		stmt = conn.createStatement();
		  String sql="insert into person (no,name,age,job) "
		  		+ "values (person_seq.nextval, '"+p.getName()+"', "
				+p.getAge()+", '"+p.getJob()+"')";
		  //---> insert into person vlaues (1, ȫ�浿, 13, �л�); (X)
		  //---> insert into person vlaues (1, 'ȫ�浿', 13, '�л�'); (O)
		  stmt.executeUpdate(sql);//SQL�������!!		  
		  return true;
	  } catch (SQLException e) {
		e.printStackTrace();
	  } finally {
		disconnect();
	  }
	  return false;
    }//insert
	
	public boolean update(Person p) {	
	  connect();
	  try {
		stmt = conn.createStatement();	
		  String sql="update person set age="+p.getAge()+", job='"+p.getJob()+"' "
		  		      + "where no="+p.getNo();
		  System.out.println("update SQL>>"+ sql);
		  
		  int t = stmt.executeUpdate(sql);
		  if(t==1) return true;//������ ���� ������ 1�̸� true ����
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
	      disconnect();
		}
	  return false;
    }//update
	
	public boolean delete(int no) {//Ư�� ���� ����
	  //������ ���� ������ 1�̸� true ����
	  connect();	
	  try {
		stmt = conn.createStatement();	
		  String sql="delete from person where no="+no;	
		  int t = stmt.executeUpdate(sql);
		  if(t==1)return true;
	  } catch (SQLException e) {
		e.printStackTrace();
	  } finally {
		  disconnect();
	  }
	  return false;
	}//delete
	
	//---------DQL-------------
	public Person select(int no) {//Ư�� ������(Person) ���� ��ȸ  ===> �뵵: ������
	   connect();//Connection��ü ����
	   
	   try {
		stmt = conn.createStatement(); //SQL����  ������ �غ�!!
		   
		   String sql="select name,age,job from person where no="+no;
		   rs = stmt.executeQuery(sql);//SQL���� ����!!
		     //rs: �࿭ ������!!
		   
		   if(rs.next()) { //���� (��� ���� �ִٸ� true)
		   
		     Person p = new Person( no, 
		                         rs.getString("name"),//�� ���� ������ ���
		                         rs.getInt("age"),
		                         rs.getString("job"));
		     return p;
		   }
	   } catch (SQLException e) {
		e.printStackTrace();
	   } finally {
	      disconnect();
	   }
	   return null;
	}//select
	
	public ArrayList<Person> selectAll() {
	   connect();	
	   ArrayList<Person> list = new ArrayList<>();
		
	   try {
		stmt = conn.createStatement();
		   //���̺��� ��� ������(Person) ��ȸ ===> �뵵: ���κ��� JTable
		   String sql="select no,name,age,job from person";	
		   rs = stmt.executeQuery(sql);
			while(rs.next()) { //�� ����
				
				//�� ���� ������ �÷� ������ ���
		   		int no = rs.getInt("no"); 
		   		String name = rs.getString("name");
		   		int age = rs.getInt("age");
		   		String job = rs.getString("job");
		   		
		   		//4���� ������ no,name,age,job�� �Ѱ��� ������(p)���� ����
		   		Person p = new Person(no, name, age, job);
		   		
		   		//������ Person (p)��  �Ѱ��� ������(list)���� ���� 
		   		list.add(p);
			}
	   } catch (SQLException e) {
		e.printStackTrace();
	   } finally {
		   disconnect();
	   }
   	   return list;
	}//selectAll
	
}//class PersonDAO




