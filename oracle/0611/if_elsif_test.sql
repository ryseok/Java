

-- 0611/if_elsif_test.sql

/*
문제) 특정사원의 사원번호, 사원명, 소속된 부서명을 출력하시오.
   예: 사번7788은 SCOTT사원이고 RESEARCH부서에 근무합니다.

    DEPTNO DNAME                        LOC
---------- ---------------------------- --------------------------
        10 ACCOUNTING                   NEW YORK
        20 RESEARCH                     DALLAS
        30 SALES                        CHICAGO
        40 OPERATIONS                   BOSTON   
*/
declare
   vename   emp.ename%type;
   vdeptno  emp.deptno%type;
   vdname   dept.dname%type;
   vempno  emp.empno%type;
begin
   vempno := 7788;--7654;
   
   select ename, deptno into vename, vdeptno
   from emp
   where empno=vempno;
   
   if(vdeptno = 10) then vdname := 'ACCOUNTING'; 
     elsif(vdeptno = 20) then vdname := 'RESEARCH'; 
     elsif(vdeptno = 30) then vdname := 'SALES'; 
   --elsif(vdeptno = 40) then vdname := 'OPERATIONS'; 
     else vdname := 'OPERATIONS';    
   end if;
   
   
   dbms_output.put_line('사번'||vempno||'은 '||vename||'사원이고 '
                        ||vdname||'부서에 근무합니다.');
end;
/






