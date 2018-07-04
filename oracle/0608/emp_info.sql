

-- 0608/emp_info.sql
-- 문제) 7788사번을 갖는 사원의 사원번호와 사원명, 급여를 화면에 출력.

declare
  -- 실행부에서 사용할 변수 선언!!
  vempno number(4);--a number(4);
  vename varchar2(15);
  vsal  emp.sal%type;

begin
  -- SQL문 (DQL, DML), 조건문, 반복문
   select empno, ename, sal into vempno, vename, vsal --a,b,c
   from emp
   where empno=7788;
	
   dbms_output.put_line('사원번호: '||vempno);
   dbms_output.put_line('사원명:'|| vename ||', 급여:'|| vsal);
   
end;
/




