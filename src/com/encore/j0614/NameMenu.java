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
	  //드라이버 로딩
	  try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} 
   }//생성자
   
   private void connect() { //연결객체생성
		try {
			conn = DriverManager.getConnection(
			     "jdbc:oracle:thin:@localhost:1521:xe",
				  "scott", "tiger");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
   }//connect
   
   private void disconnect() {//DB자원 반환
		 try {
			if(rs != null)rs.close();
			 if(stmt != null)stmt.close();
			 if(conn != null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
   }//disconnect
   
   
   public void insert(String name) {//데이터 입력
	   try {
		   connect();
		   //실행객체생성
		   stmt = conn.createStatement();
		   
		   //String sql="insert into names (name) values ('홍길동')";
		   //String sql="insert into names (name) values ("+name+")";  (X)
		   //insert into names (name) values (홍길동)
		   
		   String sql="insert into names (name) values ('"+name+"')"; //(O)
		   //insert into names (name) values ('홍길동')
		   
		   System.out.println("insert SQL>>"+ sql);//DB에  전달할 sql문 확인!!
		   
		   //sql실행 (sql문을 DB전달, 요청)
		   stmt.executeUpdate(sql);//sql문 실행 시점!!
		   
	   } catch (SQLException e) {
		e.printStackTrace();
	   } finally {
		  disconnect();
	   }
   }//insert
   
   
   
   
   // List(인터페이스)  ---구현--->  Vector    (ArrayList와 비교해서 동기화코드가 추가)
   // List(인터페이스)  ---구현--->  ArrayList  (Vector와 비교해서 빠른 실행)
   
   public ArrayList<String> select() {//데이터 검색
	  ArrayList<String> list = new ArrayList<>(); 
	   
	  try {
		   connect();
		   
		  //Statement객체생성	  
		  String sql="select name from names";
		  stmt = conn.createStatement();
		  
		  //ResultSet객체생성
		  rs = stmt.executeQuery(sql);
		   while(rs.next()) {//행 얻기
			  String name = rs.getString("name");  //rs.getString(1) 행안의 데이터 얻기
			  list.add(name);
		   }
		   
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		disconnect();
	}
	   return list;
   }//select
   
   public void update(String oldName, String newName) {//데이터 수정
	 connect(); 
	   
     try {
		stmt = conn.createStatement(); 
		   
		 //String sql="update names set name='나길동' where name='홍길동'";
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
   
   public boolean delete(String delName) {//데이터 삭제
	 connect();
	 try {
		//String sql="delete from names where name='홍길동'";
		   String sql="delete from names where name='"+delName+"'";
		   System.out.println("delete SQL>>"+ sql);
		   
		 stmt = conn.createStatement();  
		 int t = stmt.executeUpdate(sql);//sql실행
		    //t: 삭제된 행의 갯수
		 if(t>0) return true;
	  } catch (SQLException e) {
		e.printStackTrace();
	  } finally {
	      disconnect();
	  }
	 return false;
   }//delete
  
   
   public boolean existNameCheck(String name) {//존재하는 이름 체크
	  connect();
	  try {
		stmt = conn.createStatement(); 
		   
		  //String sql="select name from names where name='홍길동'";
		  //String sql="select count(*) from names where name='홍길동'";
		  String sql="select count(*) count from names where name='"+name+"'";
		  rs = stmt.executeQuery(sql);
		   rs.next();
		   //rs.getInt("count(*)");//에러 ==> 그룹함수명은 컬럼명 자리에 올 수 없음!!
		   int cnt = rs.getInt(1);//에러 ==> 그룹함수명은 컬럼명 자리에 올 수 없음!!
		   //rs.getInt("count"); (O)
		  
		   if(cnt>0) return true; //이름인 존재한다면 true 리턴
	  } catch (SQLException e) {
		e.printStackTrace();
	  } finally {
		disconnect();		
	  }
	   
	  return false;
   }//existNameCheck
}









