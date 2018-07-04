package com.encore.j0612;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	//JDBC ����
    Connection conn;
    Statement stmt;
    //---------------DML����(insert,delete,update)
    
    
    ResultSet rs;
    //---------------DQL����(select)
	
	public JDBCTest() {//1.����̹� 2.Connection 3.Statement 4.ResultSet
	  try {
		  //��[1] ����̹� �ε�(��ǰ�� ����)
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  //��[2] Connection���ᰴü����
		  conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
				         "scott", "tiger");
		  
		  //��[3] Statement���ఴü����
		  stmt = conn.createStatement();
		  
		  /*
		      ����1) ������̺�(emp7)�� ��������� ����Ͻÿ�.
		       ===> 7000, ȫ�浿, 2000, 10	
		       ===> 7002, �����, 3000, 20	
		       ===> 7003, ���ֿ�, 4000, 30	
		   */
		  String sql="insert into emp7 (empno,ename,sal,deptno) values "
		  		+ "(7000, 'ȫ�浿', 2000, 10)";
		  
		  //sql���� ����!! ------> execute()�޼ҵ� ���!!
		  //���� DML�� �����ϰ� �ʹ�!! ----> stmt.executeUpdate(sql)
		  //���� DQL�� �����ϰ� �ʹ�!! ----> stmt.executeQuery(sql)
		  
		   //stmt.executeUpdate(sql);//DB�� sql���� ----> ����!!
		  sql="insert into emp7 values (7002, '�����', 3000, 20)";
		   //stmt.executeUpdate(sql);
		  
		  sql="insert into emp7 values (7003, '���ֿ�', 4000, 30)";
		   //stmt.executeUpdate(sql);
		  
		  System.out.println("#�Է¼���!!");
		  //--------------------------------------------------------
		  
		  //����2) ����� ����� ����
		  sql="delete from emp7 where ename='�����'";
		   int t = stmt.executeUpdate(sql);// sql�� ����, DBMS���� sql�� ���� ��û!!
		  
		  System.out.println("#��������!!==> "+ t);//t:������ ���� ����
		  //--------------------------------------------------------
          
		  //����3) ���ֿ� ����� 10�� �μ��� �̵�
		  sql = "update emp7 set deptno=10 where ename='���ֿ�'";
		    t = stmt.executeUpdate(sql);//update�����û
		    //t: ������ ���� ����
		  
		  if(t > 0) {
		    System.out.println("#��������!!==> "+ t);
		  }else {
			 System.out.println("#�����ϴ� �̸��� �����ϴ�!!"); 
		  }
		    
		    
		  //--------------------------------------------------------
		  
		  //����4) ��ü ����� ���� ����(��ȸ) ���
		  //��[4] ResultSet��ü ����
		  sql="select empno,ename,sal,deptno from emp7";
		    rs = stmt.executeQuery(sql); //sql���� ��û!!
		    //1. rs.next() ����   
		    //2. rs.get�ڷ���("�÷���");  ������ ���
		   
		    /*
		     rs.next(); // select count(*) from emp; 
		     if(rs.next()){} //select ename from emp where empno=7788;  
		     while(rs.next()){} //select ename from emp;
		     */
		   System.out.println("=== ��ü ��� ���� ===");
		   while(rs.next()) {
			   int empno = rs.getInt("empno");
			   String ename =  rs.getString("ename");
			   Double sal = rs.getDouble("sal");
			   int deptno = rs.getInt("deptno");
			   System.out.println("���:"+empno+",�����:"+ename+
					      ",�޿�:"+sal+",�μ���ȣ:"+deptno);
		   }
		    
		  
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		
	}//������

	
	public static void main(String[] args) {
	   new JDBCTest();	
	}
}
