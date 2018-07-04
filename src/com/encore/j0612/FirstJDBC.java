package com.encore.j0612;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FirstJDBC {
   public static void main(String[] args) {
	 try{ 
	  //1. ����̹� �ε� Driver loading (= ��ǰ�� ����)
	   //Class.forName("����̹� Ŭ������");
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   
	  //2. ���ᰴü ���� : Connection
	   //getConnection(String url,String user,String password);
	   Connection conn = DriverManager.getConnection(
			       "jdbc:oracle:thin:@localhost:1521:xe", 
			       "scott", "tiger");
	   //"localhost" ==> "127.0.0.1"  : ��PC�� ����
	   
	   System.out.println("DB���Ἲ��~!!"); 
	  
//-------------------------DML(C,S)----------------------------------------
	   
	  //3. ���ఴü ���� : Statement ==> SQL��(DML,DQL) ���� ����!!
	   Statement stmt = conn.createStatement();
	   
	   
	  //����) ���̺� dept_copy���� 10�� �μ��� �����Ͻÿ�.
	  //����) ���̺� dept_copy���� 20��,30�� �μ��� �����Ͻÿ�.
	   // ----> SQL�ۼ�
	  //String sql="delete from dept_copy where deptno=10";
	  String sql="delete from dept_copy where deptno in (20,30)";
	  //������ : sql������ ������ ';' �� �����ؾ� ��!!
	  
	     //stmt.executeUpdate(String sql);
	     //stmt.executeUpdate("DML��");  ---> ���� int (����,������ ���� ����)
	     //stmt.executeQuery("DQL��");   ---> ���� ResultSet (��ȸ�� �࿭)
	  
	     int t = stmt.executeUpdate(sql);//���� ���� (sql���� DB�������� ����)
	       //�ڹ�application���� �����ϴ� ��� �⺻ AutoCommit!!
	       //t: ���� �Ǵ� ������ ���� ����
	  
	     System.out.println("#�μ� ���� ����!! ==> ������ ���� ����: "+ t);
	     
//----------------------��ȸ ���� DQL(C,S,R)----------------------------------	   
      //4. �����ü ���� : ResultSet ==> ��ȸ�� ���(�࿭������)�� ����!!
	     
	   //sql = "select deptno, dname, loc from dept where deptno=20";
	   sql = "select deptno, dname, loc from dept";
	     //DB�ε���:     1       2     3
	   ResultSet rs = stmt.executeQuery(sql);
	   //rs: �࿭ ��� ������!!
	   // ----> �����͸� �����ϴ� ���� :  1. �� ���    2. �������� ���	   
	   
	   
	  /*	      
	   //����) 20�� �μ��� �μ���ȣ, �μ���, �μ���ġ�� ����Ͻÿ�.
	   rs.next();// ====> �� ���
	  
	   //rs.getInt(int columnIndex);  rs.getInt(String columnLabel);
	     int no = rs.getInt(1);//deptno  rs.getInt("deptno");
	     String dname = rs.getString(2);//dname  rs.getString("dname");
	     String loc = rs.getString(3);//loc    rs.getString("loc")
	    System.out.println("no="+ no); 
	    System.out.println("dname="+dname); 
	    System.out.println("loc="+loc); */
	   
	   //����) ��ü �μ��� �μ���ȣ, �μ���, �μ���ġ�� ����Ͻÿ�.
	   while(rs.next()) {//rs.next() ---> ������(������ ��)�� ������ true ����!!
		   int no = rs.getInt("deptno");
		   String dname = rs.getString("dname");
		   String loc = rs.getString("loc");
		   System.out.println("�μ���ȣ: "+ no +
				   ", �μ���: "+dname+ ", ��ġ:"+loc);
	    }//while
	   
	   
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	 
   }//main
}





