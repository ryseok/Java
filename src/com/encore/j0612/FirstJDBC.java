package com.encore.j0612;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FirstJDBC {
   public static void main(String[] args) {
	 try{ 
	  //1. 드라이버 로딩 Driver loading (= 제품군 선택)
	   //Class.forName("드라이버 클래스명");
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   
	  //2. 연결객체 생성 : Connection
	   //getConnection(String url,String user,String password);
	   Connection conn = DriverManager.getConnection(
			       "jdbc:oracle:thin:@localhost:1521:xe", 
			       "scott", "tiger");
	   //"localhost" ==> "127.0.0.1"  : 현PC의 서버
	   
	   System.out.println("DB연결성공~!!"); 
	  
//-------------------------DML(C,S)----------------------------------------
	   
	  //3. 실행객체 생성 : Statement ==> SQL문(DML,DQL) 실행 가능!!
	   Statement stmt = conn.createStatement();
	   
	   
	  //문제) 테이블 dept_copy에서 10번 부서를 삭제하시오.
	  //문제) 테이블 dept_copy에서 20번,30번 부서를 삭제하시오.
	   // ----> SQL작성
	  //String sql="delete from dept_copy where deptno=10";
	  String sql="delete from dept_copy where deptno in (20,30)";
	  //※주의 : sql문장의 종결자 ';' 을 생략해야 함!!
	  
	     //stmt.executeUpdate(String sql);
	     //stmt.executeUpdate("DML문");  ---> 리턴 int (수정,삭제된 행의 갯수)
	     //stmt.executeQuery("DQL문");   ---> 리턴 ResultSet (조회된 행열)
	  
	     int t = stmt.executeUpdate(sql);//삭제 시점 (sql문을 DB서버에게 전달)
	       //자바application에서 실행하는 경우 기본 AutoCommit!!
	       //t: 삭제 또는 수정된 행의 개수
	  
	     System.out.println("#부서 삭제 성공!! ==> 삭제된 행의 개수: "+ t);
	     
//----------------------조회 업무 DQL(C,S,R)----------------------------------	   
      //4. 결과객체 생성 : ResultSet ==> 조회된 결과(행열데이터)를 저장!!
	     
	   //sql = "select deptno, dname, loc from dept where deptno=20";
	   sql = "select deptno, dname, loc from dept";
	     //DB인덱스:     1       2     3
	   ResultSet rs = stmt.executeQuery(sql);
	   //rs: 행열 덩어리 데이터!!
	   // ----> 데이터를 추출하는 순서 :  1. 행 얻기    2. 열데이터 얻기	   
	   
	   
	  /*	      
	   //문제) 20번 부서의 부서번호, 부서명, 부서위치를 출력하시오.
	   rs.next();// ====> 행 얻기
	  
	   //rs.getInt(int columnIndex);  rs.getInt(String columnLabel);
	     int no = rs.getInt(1);//deptno  rs.getInt("deptno");
	     String dname = rs.getString(2);//dname  rs.getString("dname");
	     String loc = rs.getString(3);//loc    rs.getString("loc")
	    System.out.println("no="+ no); 
	    System.out.println("dname="+dname); 
	    System.out.println("loc="+loc); */
	   
	   //문제) 전체 부서의 부서번호, 부서명, 부서위치를 출력하시오.
	   while(rs.next()) {//rs.next() ---> 다음행(가져올 행)이 있으면 true 리턴!!
		   int no = rs.getInt("deptno");
		   String dname = rs.getString("dname");
		   String loc = rs.getString("loc");
		   System.out.println("부서번호: "+ no +
				   ", 부서명: "+dname+ ", 위치:"+loc);
	    }//while
	   
	   
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	 
   }//main
}





