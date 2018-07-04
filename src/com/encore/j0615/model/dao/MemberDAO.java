package com.encore.j0615.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.encore.j0615.model.vo.Member;

public class MemberDAO {

	//채(C) 시(S--->P) 라(R)
	Connection conn;
	//Statement stmt;
	PreparedStatement stmt;
	ResultSet rs;
	
	Properties pro;
	
	public MemberDAO() {
	   try {
		  pro = new Properties();
		  pro.load(new FileReader("conn/conn.properties"));
		  Class.forName(pro.getProperty("driver"));
	  } catch (Exception e) {
		e.printStackTrace();
	  }
	}//생성자
	
	private void connect() {
	   try {
		conn = DriverManager.getConnection(pro.getProperty("url"),pro);
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
	
	
	
	public boolean insert(Member m) {
	  connect();	
		
	  try {
		String sql="insert into member (id,pass,name,ssn1,ssn2,phone,addr,job) "
		  		+ "values (?,?,?,?,?,?,?,?)";
		  stmt = conn.prepareStatement(sql);//sql문을 미리 전달!!
		    //stmt.setString(물음표 순서(1~), 설정할 데이터);
		   stmt.setString(1, m.getId());
		   stmt.setString(2, m.getPass());
		   stmt.setString(3, m.getName());
		   stmt.setInt(4, m.getSsn1());
		   stmt.setInt(5, m.getSsn2());
		   stmt.setString(6, m.getPhone());
		   stmt.setString(7, m.getAddr());
		   stmt.setString(8, m.getJob());
		  stmt.executeUpdate(); //sql문 실행 요청!!
		  
		  return true;//입력성공!!
		  
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		disconnect();
	}
	  
	  return false;
    }//insert
	public boolean update(Member m) {
	  //[id=lime, pass=9876,phone=010-1234-7777, addr=고터, job=학생]
	  connect();
	  
      try {
		String sql="update member set pass=?, phone=?, addr=?, job=? "
				     +"where id=?";
		  stmt = conn.prepareStatement(sql);//데이터를 제외한 sql문 미리 전달
		    stmt.setString(1, m.getPass());
		    stmt.setString(2, m.getPhone());
		    stmt.setString(3, m.getAddr());
		    stmt.setString(4, m.getJob());
		    stmt.setString(5, m.getId());
		  int t = stmt.executeUpdate();//sql문 실행 요청
		  if(t == 1 )return true;//t:수정된 행의 갯수
	   } catch (SQLException e) {		
		  e.printStackTrace();
	   } finally {
		   disconnect();
	    }      
	  return false;
    }//update
	
	
	public boolean delete(String id) {
	  connect();
	  try {
		String sql="delete from member where id=?";	
		  stmt = conn.prepareStatement(sql);
		    stmt.setString(1, id);
		  int t = stmt.executeUpdate();
		  if(t==1) {
			 return true;//삭제된 행의 수가 1일때
			 
		  }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		  disconnect();
		}
	  return false;
	}//delete
	
	public Member select(String id) {
	  connect();	
	  Member m = null;	//null ---> 결과값 없음을 표현
	  try {
		String sql="select pass,name,ssn1,ssn2,phone,addr,job from member "
		  		    + "where id=?";
		  stmt = conn.prepareStatement(sql); //sql문 미리전달
		    //?수만큼의 데이터 설정
		   stmt.setString(1, id);
		  rs = stmt.executeQuery();
		    if(rs.next()) {//아이디 일치하는 행을 찾았다면
		       m = new Member(id, 
		    		         rs.getString("pass"),
		    		         rs.getString("name"),
		    		         rs.getInt("ssn1"),
		    		         rs.getInt("ssn2"),
		    		         rs.getString("phone"),
		    		         rs.getString("addr"),
		    		         rs.getString("job"));
		    }
		    /*else {//아이디 일치하는 행을 찾지 못했다면
		       return null; //전달할 데이터 없음!!	
		    }*/
		  
	   } catch (SQLException e) {		
		   e.printStackTrace();
	   } finally {
		   disconnect();
	   }
	  return m;
	}//select
	
	public ArrayList<Member> selectAll() {
      connect();		
      ArrayList<Member> list = new ArrayList<>(); //list.size() ==> 0
		
	  try {
		String sql="select id,pass,name,ssn1,ssn2,phone,addr,job from member "
				+ "where id != 'admin'";	
		  stmt = conn.prepareStatement(sql);//sql 미리 전달!!
		    
		  rs = stmt.executeQuery();//sql실행 요청!!
		  while(rs.next()) {
			 Member m = new Member( 
								  rs.getString("id"),   
								  rs.getString("pass"),   
								  rs.getString("name"),   
								  rs.getInt("ssn1"),   
								  rs.getInt("ssn2"),   
								  rs.getString("phone"),   
								  rs.getString("addr"),   
								  rs.getString("job"));  
			 list.add(m);
		  }//while
	   } catch (SQLException e) {
		e.printStackTrace();
	   } finally {
	        disconnect();
	   }
	  return list;
	}//selectAll
	
	
	public ArrayList<Member> selectNames(String name) {
		connect();		
		ArrayList<Member> list = new ArrayList<>(); //list.size() ==> 0
		
		try {
			String sql="select id,pass,name,ssn1,ssn2,phone,addr,job "
					  + "from member where name like ?";	
					//+ "from member where name like '홍%'";	
			stmt = conn.prepareStatement(sql);//sql 미리 전달!!
			  stmt.setString(1, name+"%");
			rs = stmt.executeQuery();//sql실행 요청!!
			while(rs.next()) {
				Member m = new Member( 
						rs.getString("id"),   
						rs.getString("pass"),   
						rs.getString("name"),   
						rs.getInt("ssn1"),   
						rs.getInt("ssn2"),   
						rs.getString("phone"),   
						rs.getString("addr"),   
						rs.getString("job"));  
				list.add(m);
			}//while
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}//selectNames
	
	
	/*public boolean selectLogin(String id, String pass) {//로그인 성공시 true리턴!!
//	   String sql="select * from member";
//	   String sql="select id,pass from member";
//	   String sql="select id,pass from member where id=id";
		
	   connect();
	   
	   try {
		stmt = conn.createStatement();
		   String sql="select count(*) from member where id='"+id+"' "
		   		     + "and pass='"+pass+"'";
		   //id : 입력 데이터 ==> a' or 1=1-- 
		   
		   //select count(*) from member where id='a' or 1=1--' and pass=''
		   
		   System.out.println("login SQL>>"+ sql);
		   
		   rs = stmt.executeQuery(sql);

		   rs.next();
		   int cnt = rs.getInt(1);
		   if(cnt>0) return true;//로그인 성공
		   
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	   
	   return false;
	}//selectLogin
*/	
	public boolean selectLogin2(String id, String pass) {//로그인 성공시 true리턴!!
		/*
		    <member테이블에 회원정보 100개 저장> 
		 
		    select * from member   ---> 100행 8열: 최악
		    while(rs.next){
		        new Member(rs.get자료형(),rs.get자료형(),rs.get자료형()...)
		        ----> 객체생성(메모리 할당 100번)
		    }
		    
		    select id,pass from meber; ---> 100행 2열
		    select id,pass from meber where id=id and pass=pass; ---> 1행 2열
		    
		    select pass from meber where id=id; ---> 1행 1열
		       if(rs.next()){// 아이디 존재!!
		          
		          String dpass = rs.getString("pass");
		          if(pass.equals(dpass)){// 아이디 존재, 비번 일치
		             return "success";
		          }else{// 아이디 존재, 비번 불일치
		             return "fail_pass";
		          }
		          
		       }else{//아이디 존재X
		          return "fail_id";
		       }   
		    
		 */
		
		
		connect();
		
		try {
			String sql="select count(*) from member where id=? and pass=?";
			System.out.println("login SQL>>"+ sql);
			stmt = conn.prepareStatement(sql);//미리 sql문을 전달
			//id : 입력 데이터 ==> a' or 1=1-- 
			   //※주의) 물음표(바인드 변수)의 수만큼 set자료형(데이터); 가 있어야 함!!
			  //stmt.setString(int 물음표순서, String 전달데이터);
			  stmt.setString(1, id);  //"a' or 1=1--"
			  stmt.setString(2, pass);
			rs = stmt.executeQuery();//실행시점, 실행요청
			
			rs.next();
			int cnt = rs.getInt(1);
			//if(cnt>0) return true;//로그인 성공
			if(cnt == 1) return true;//로그인 성공
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return false;
	}//selectLogin

	public boolean selectDuplicateId(String id) {
		//중복된 아이디 존재 true 리턴
	    connect();
		try {
			String sql="select count(*) count from member where id=?";
			stmt = conn.prepareStatement(sql);//sql문 전달 ---->DB서버(sql문 파싱)
			  stmt.setString(1, id);
			rs = stmt.executeQuery();//실행요청
			
			rs.next();
			int count = rs.getInt("count");//rs.getInt(1);
			if(count==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return false;
	}//selectDuplicateId

	public ArrayList<Member> selectKeyword(String title, String keyword) {
		
		connect();		
		ArrayList<Member> list = new ArrayList<>(); //list.size() ==> 0
		
		try {
			String sql="select id,pass,name,ssn1,ssn2,phone,addr,job "
					  + "from member ";
			if(title.equals("이름")) {
				sql += "where name like ?";
			}else if(title.equals("아이디")) {
				sql += "where id like ?";
			}else {//if(title.equals("주소"))
				sql += "where addr like ?";
			}
					
			stmt = conn.prepareStatement(sql);//sql 미리 전달!!
			  stmt.setString(1, keyword+"%");
			rs = stmt.executeQuery();//sql실행 요청!!
			while(rs.next()) {
				Member m = new Member( 
						rs.getString("id"),   
						rs.getString("pass"),   
						rs.getString("name"),   
						rs.getInt("ssn1"),   
						rs.getInt("ssn2"),   
						rs.getString("phone"),   
						rs.getString("addr"),   
						rs.getString("job"));  
				list.add(m);
			}//while
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}//selectKeyword
	
	
}//MemberDAO



