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

	//ä(C) ��(S--->P) ��(R)
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
	}//������
	
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
		  stmt = conn.prepareStatement(sql);//sql���� �̸� ����!!
		    //stmt.setString(����ǥ ����(1~), ������ ������);
		   stmt.setString(1, m.getId());
		   stmt.setString(2, m.getPass());
		   stmt.setString(3, m.getName());
		   stmt.setInt(4, m.getSsn1());
		   stmt.setInt(5, m.getSsn2());
		   stmt.setString(6, m.getPhone());
		   stmt.setString(7, m.getAddr());
		   stmt.setString(8, m.getJob());
		  stmt.executeUpdate(); //sql�� ���� ��û!!
		  
		  return true;//�Է¼���!!
		  
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		disconnect();
	}
	  
	  return false;
    }//insert
	public boolean update(Member m) {
	  //[id=lime, pass=9876,phone=010-1234-7777, addr=����, job=�л�]
	  connect();
	  
      try {
		String sql="update member set pass=?, phone=?, addr=?, job=? "
				     +"where id=?";
		  stmt = conn.prepareStatement(sql);//�����͸� ������ sql�� �̸� ����
		    stmt.setString(1, m.getPass());
		    stmt.setString(2, m.getPhone());
		    stmt.setString(3, m.getAddr());
		    stmt.setString(4, m.getJob());
		    stmt.setString(5, m.getId());
		  int t = stmt.executeUpdate();//sql�� ���� ��û
		  if(t == 1 )return true;//t:������ ���� ����
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
			 return true;//������ ���� ���� 1�϶�
			 
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
	  Member m = null;	//null ---> ����� ������ ǥ��
	  try {
		String sql="select pass,name,ssn1,ssn2,phone,addr,job from member "
		  		    + "where id=?";
		  stmt = conn.prepareStatement(sql); //sql�� �̸�����
		    //?����ŭ�� ������ ����
		   stmt.setString(1, id);
		  rs = stmt.executeQuery();
		    if(rs.next()) {//���̵� ��ġ�ϴ� ���� ã�Ҵٸ�
		       m = new Member(id, 
		    		         rs.getString("pass"),
		    		         rs.getString("name"),
		    		         rs.getInt("ssn1"),
		    		         rs.getInt("ssn2"),
		    		         rs.getString("phone"),
		    		         rs.getString("addr"),
		    		         rs.getString("job"));
		    }
		    /*else {//���̵� ��ġ�ϴ� ���� ã�� ���ߴٸ�
		       return null; //������ ������ ����!!	
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
		  stmt = conn.prepareStatement(sql);//sql �̸� ����!!
		    
		  rs = stmt.executeQuery();//sql���� ��û!!
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
					//+ "from member where name like 'ȫ%'";	
			stmt = conn.prepareStatement(sql);//sql �̸� ����!!
			  stmt.setString(1, name+"%");
			rs = stmt.executeQuery();//sql���� ��û!!
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
	
	
	/*public boolean selectLogin(String id, String pass) {//�α��� ������ true����!!
//	   String sql="select * from member";
//	   String sql="select id,pass from member";
//	   String sql="select id,pass from member where id=id";
		
	   connect();
	   
	   try {
		stmt = conn.createStatement();
		   String sql="select count(*) from member where id='"+id+"' "
		   		     + "and pass='"+pass+"'";
		   //id : �Է� ������ ==> a' or 1=1-- 
		   
		   //select count(*) from member where id='a' or 1=1--' and pass=''
		   
		   System.out.println("login SQL>>"+ sql);
		   
		   rs = stmt.executeQuery(sql);

		   rs.next();
		   int cnt = rs.getInt(1);
		   if(cnt>0) return true;//�α��� ����
		   
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	   
	   return false;
	}//selectLogin
*/	
	public boolean selectLogin2(String id, String pass) {//�α��� ������ true����!!
		/*
		    <member���̺� ȸ������ 100�� ����> 
		 
		    select * from member   ---> 100�� 8��: �־�
		    while(rs.next){
		        new Member(rs.get�ڷ���(),rs.get�ڷ���(),rs.get�ڷ���()...)
		        ----> ��ü����(�޸� �Ҵ� 100��)
		    }
		    
		    select id,pass from meber; ---> 100�� 2��
		    select id,pass from meber where id=id and pass=pass; ---> 1�� 2��
		    
		    select pass from meber where id=id; ---> 1�� 1��
		       if(rs.next()){// ���̵� ����!!
		          
		          String dpass = rs.getString("pass");
		          if(pass.equals(dpass)){// ���̵� ����, ��� ��ġ
		             return "success";
		          }else{// ���̵� ����, ��� ����ġ
		             return "fail_pass";
		          }
		          
		       }else{//���̵� ����X
		          return "fail_id";
		       }   
		    
		 */
		
		
		connect();
		
		try {
			String sql="select count(*) from member where id=? and pass=?";
			System.out.println("login SQL>>"+ sql);
			stmt = conn.prepareStatement(sql);//�̸� sql���� ����
			//id : �Է� ������ ==> a' or 1=1-- 
			   //������) ����ǥ(���ε� ����)�� ����ŭ set�ڷ���(������); �� �־�� ��!!
			  //stmt.setString(int ����ǥ����, String ���޵�����);
			  stmt.setString(1, id);  //"a' or 1=1--"
			  stmt.setString(2, pass);
			rs = stmt.executeQuery();//�������, �����û
			
			rs.next();
			int cnt = rs.getInt(1);
			//if(cnt>0) return true;//�α��� ����
			if(cnt == 1) return true;//�α��� ����
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return false;
	}//selectLogin

	public boolean selectDuplicateId(String id) {
		//�ߺ��� ���̵� ���� true ����
	    connect();
		try {
			String sql="select count(*) count from member where id=?";
			stmt = conn.prepareStatement(sql);//sql�� ���� ---->DB����(sql�� �Ľ�)
			  stmt.setString(1, id);
			rs = stmt.executeQuery();//�����û
			
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
			if(title.equals("�̸�")) {
				sql += "where name like ?";
			}else if(title.equals("���̵�")) {
				sql += "where id like ?";
			}else {//if(title.equals("�ּ�"))
				sql += "where addr like ?";
			}
					
			stmt = conn.prepareStatement(sql);//sql �̸� ����!!
			  stmt.setString(1, keyword+"%");
			rs = stmt.executeQuery();//sql���� ��û!!
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



