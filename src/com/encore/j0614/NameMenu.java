package com.encore.j0614;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NameMenu {
   
   Connection conn;
   Statement stmt;
   ResultSet rs;
   
   public NameMenu() {
	  //����̹� �ε�
	  try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} 
   }//������
   
   private void connect() { //���ᰴü����
		try {
			conn = DriverManager.getConnection(
			     "jdbc:oracle:thin:@localhost:1521:xe",
				  "scott", "tiger");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
   }//connect
   
   private void disconnect() {//DB�ڿ� ��ȯ
		 try {
			if(rs != null)rs.close();
			 if(stmt != null)stmt.close();
			 if(conn != null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
   }//disconnect
   
   
   public void insert(String name) {//������ �Է�
	   try {
		   connect();
		   //���ఴü����
		   stmt = conn.createStatement();
		   
		   //String sql="insert into names (name) values ('ȫ�浿')";
		   //String sql="insert into names (name) values ("+name+")";  (X)
		   //insert into names (name) values (ȫ�浿)
		   
		   String sql="insert into names (name) values ('"+name+"')"; //(O)
		   //insert into names (name) values ('ȫ�浿')
		   
		   System.out.println("insert SQL>>"+ sql);//DB��  ������ sql�� Ȯ��!!
		   
		   //sql���� (sql���� DB����, ��û)
		   stmt.executeUpdate(sql);//sql�� ���� ����!!
		   
	   } catch (SQLException e) {
		e.printStackTrace();
	   } finally {
		  disconnect();
	   }
   }//insert
   
   
   
   
   // List(�������̽�)  ---����--->  Vector    (ArrayList�� ���ؼ� ����ȭ�ڵ尡 �߰�)
   // List(�������̽�)  ---����--->  ArrayList  (Vector�� ���ؼ� ���� ����)
   
   public ArrayList<String> select() {//������ �˻�
	  ArrayList<String> list = new ArrayList<>(); 
	   
	  try {
		   connect();
		   
		  //Statement��ü����	  
		  String sql="select name from names";
		  stmt = conn.createStatement();
		  
		  //ResultSet��ü����
		  rs = stmt.executeQuery(sql);
		   while(rs.next()) {//�� ���
			  String name = rs.getString("name");  //rs.getString(1) ����� ������ ���
			  list.add(name);
		   }
		   
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		disconnect();
	}
	   return list;
   }//select
   
   public void update(String oldName, String newName) {//������ ����
	 connect(); 
	   
     try {
		stmt = conn.createStatement(); 
		   
		 //String sql="update names set name='���浿' where name='ȫ�浿'";
		 String sql="update names set name='"+newName
				     +"' where name='"+oldName+"'";
		 System.out.println("update SQL>>"+ sql);
		 
		 stmt.executeUpdate(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		disconnect();		
	}
	 
   }//update
   
   public boolean delete(String delName) {//������ ����
	 connect();
	 try {
		//String sql="delete from names where name='ȫ�浿'";
		   String sql="delete from names where name='"+delName+"'";
		   System.out.println("delete SQL>>"+ sql);
		   
		 stmt = conn.createStatement();  
		 int t = stmt.executeUpdate(sql);//sql����
		    //t: ������ ���� ����
		 if(t>0) return true;
	  } catch (SQLException e) {
		e.printStackTrace();
	  } finally {
	      disconnect();
	  }
	 return false;
   }//delete
  
   
   public boolean existNameCheck(String name) {//�����ϴ� �̸� üũ
	  connect();
	  try {
		stmt = conn.createStatement(); 
		   
		  //String sql="select name from names where name='ȫ�浿'";
		  //String sql="select count(*) from names where name='ȫ�浿'";
		  String sql="select count(*) count from names where name='"+name+"'";
		  rs = stmt.executeQuery(sql);
		   rs.next();
		   //rs.getInt("count(*)");//���� ==> �׷��Լ����� �÷��� �ڸ��� �� �� ����!!
		   int cnt = rs.getInt(1);//���� ==> �׷��Լ����� �÷��� �ڸ��� �� �� ����!!
		   //rs.getInt("count"); (O)
		  
		   if(cnt>0) return true; //�̸��� �����Ѵٸ� true ����
	  } catch (SQLException e) {
		e.printStackTrace();
	  } finally {
		disconnect();		
	  }
	   
	  return false;
   }//existNameCheck
}









