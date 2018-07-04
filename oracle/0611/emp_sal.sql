

-- emp_sal.sql

/*
특정사원 한명의 사원번호, 사원명, 연봉을 출력하시오.
     (연봉계산은 급여*12+COMM)
     
    ===> where empno=7788;     where empno=7654;  
    ===> 예) 사번 7788은 SCOTT사원이고 연봉은 36000입니다.
*/
declare
  vempno  emp.empno%type;
  vename  emp.ename%type;
  vsal    emp.sal%type;   
  vcomm   emp.comm%type;
  
  --연봉
  annsal number;
  
begin
  -- SQL문 (select,insert,delete,update)
  select empno,ename,sal,comm into vempno, vename, vsal,vcomm
  from emp
  where empno=7788;
  
  -- annsal  := vsal*12+vcomm;
  -- SCOTT사원 경우 3000*12+null    ---> null
  -- MARTIN사원 경우 1250*12+1400   ---> 16400
  
  if(vcomm is null)
    then annsal := vsal*12+ 0;
    else annsal := vsal*12+vcomm;
  end if;
  
  dbms_output.put_line('사번 '||vempno||'은 '||vename||'사원이고 연봉은 '||
                        annsal||'입니다.');
  
end;
/









