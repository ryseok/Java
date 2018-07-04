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
	                    //       ----> DB 전담 클래스	
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
	}//생성자
	
	private void connect() {
		try {
			/*conn = DriverManager.getConnection(pro.getProperty("url"),
					                           pro.getProperty("user"),
					                           pro.getProperty("password"));*/
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);
			System.out.println("DB연결 성공!!^^*");
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
		  //---> insert into person vlaues (1, 홍길동, 13, 학생); (X)
		  //---> insert into person vlaues (1, '홍길동', 13, '학생'); (O)
		  stmt.executeUpdate(sql);//SQL실행시점!!		  
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
		  if(t==1) return true;//수정된 행의 갯수가 1이면 true 리턴
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
	      disconnect();
		}
	  return false;
    }//update
	
	public boolean delete(int no) {//특정 행을 삭제
	  //삭제된 행의 갯수가 1이면 true 리턴
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
	public Person select(int no) {//특정 데이터(Person) 한행 조회  ===> 용도: 수정폼
	   connect();//Connection객체 생성
	   
	   try {
		stmt = conn.createStatement(); //SQL문을  전달할 준비!!
		   
		   String sql="select name,age,job from person where no="+no;
		   rs = stmt.executeQuery(sql);//SQL문을 전달!!
		     //rs: 행열 데이터!!
		   
		   if(rs.next()) { //행얻기 (결과 행이 있다면 true)
		   
		     Person p = new Person( no, 
		                         rs.getString("name"),//행 안의 데이터 얻기
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
		   //테이블내의 모든 데이터(Person) 조회 ===> 용도: 메인뷰의 JTable
		   String sql="select no,name,age,job from person";	
		   rs = stmt.executeQuery(sql);
			while(rs.next()) { //한 행얻기
				
				//행 내의 각각의 컬럼 데이터 얻기
		   		int no = rs.getInt("no"); 
		   		String name = rs.getString("name");
		   		int age = rs.getInt("age");
		   		String job = rs.getString("job");
		   		
		   		//4개의 변수명 no,name,age,job을 한개의 변수명(p)으로 정의
		   		Person p = new Person(no, name, age, job);
		   		
		   		//여러개 Person (p)을  한개의 변수명(list)으로 정의 
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




