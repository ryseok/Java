package com.encore.j0612;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	//JDBC 연습
    Connection conn;
    Statement stmt;
    //---------------DML업무(insert,delete,update)
    
    
    ResultSet rs;
    //---------------DQL업무(select)
	
	public JDBCTest() {//1.드라이버 2.Connection 3.Statement 4.ResultSet
	  try {
		  //▶[1] 드라이버 로딩(제품군 선택)
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  //▶[2] Connection연결객체생성
		  conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
				         "scott", "tiger");
		  
		  //▶[3] Statement실행객체생성
		  stmt = conn.createStatement();
		  
		  /*
		      문제1) 사원테이블(emp7)에 사원정보를 등록하시오.
		       ===> 7000, 홍길동, 2000, 10	
		       ===> 7002, 길라임, 3000, 20	
		       ===> 7003, 김주원, 4000, 30	
		   */
		  String sql="insert into emp7 (empno,ename,sal,deptno) values "
		  		+ "(7000, '홍길동', 2000, 10)";
		  
		  //sql문을 실행!! ------> execute()메소드 사용!!
		  //만약 DML을 실행하고 싶다!! ----> stmt.executeUpdate(sql)
		  //만약 DQL을 실행하고 싶다!! ----> stmt.executeQuery(sql)
		  
		   //stmt.executeUpdate(sql);//DB에 sql전달 ----> 실행!!
		  sql="insert into emp7 values (7002, '길라임', 3000, 20)";
		   //stmt.executeUpdate(sql);
		  
		  sql="insert into emp7 values (7003, '김주원', 4000, 30)";
		   //stmt.executeUpdate(sql);
		  
		  System.out.println("#입력성공!!");
		  //--------------------------------------------------------
		  
		  //문제2) 길라임 사원을 삭제
		  sql="delete from emp7 where ename='길라임'";
		   int t = stmt.executeUpdate(sql);// sql문 전송, DBMS에게 sql문 실행 요청!!
		  
		  System.out.println("#삭제성공!!==> "+ t);//t:삭제된 행의 갯수
		  //--------------------------------------------------------
          
		  //문제3) 김주원 사원을 10번 부서로 이동
		  sql = "update emp7 set deptno=10 where ename='김주원'";
		    t = stmt.executeUpdate(sql);//update실행요청
		    //t: 수정된 행의 갯수
		  
		  if(t > 0) {
		    System.out.println("#수정성공!!==> "+ t);
		  }else {
			 System.out.println("#존재하는 이름이 없습니다!!"); 
		  }
		    
		    
		  //--------------------------------------------------------
		  
		  //문제4) 전체 사원에 대한 정보(조회) 출력
		  //▶[4] ResultSet객체 생성
		  sql="select empno,ename,sal,deptno from emp7";
		    rs = stmt.executeQuery(sql); //sql실행 요청!!
		    //1. rs.next() 행얻기   
		    //2. rs.get자료형("컬럼명");  데이터 얻기
		   
		    /*
		     rs.next(); // select count(*) from emp; 
		     if(rs.next()){} //select ename from emp where empno=7788;  
		     while(rs.next()){} //select ename from emp;
		     */
		   System.out.println("=== 전체 사원 정보 ===");
		   while(rs.next()) {
			   int empno = rs.getInt("empno");
			   String ename =  rs.getString("ename");
			   Double sal = rs.getDouble("sal");
			   int deptno = rs.getInt("deptno");
			   System.out.println("사번:"+empno+",사원명:"+ename+
					      ",급여:"+sal+",부서번호:"+deptno);
		   }
		    
		  
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		
	}//생성자

	
	public static void main(String[] args) {
	   new JDBCTest();	
	}
}
