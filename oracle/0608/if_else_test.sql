

--if_else_test.sql
/*
    예1: 사번7788은 SCOTT사원이고 커미션을 받지 않습니다.
    예2: 사번7654은 MARTIN사원이고 커미션을 1400 받습니다.
 */
declare
  vempno emp.empno%type;
  vename  emp.ename%type;
  vcomm   emp.comm%type;

begin
  
  select empno, ename, comm into vempno, vename, vcomm 
  from emp
  where  empno=7654;
  
  if (vcomm is not null)
    then  dbms_output.put_line('사번'||vempno||'은 '||vename||
                        '사원이고 커미션을 '||vcomm||'받습니다.');
    else  dbms_output.put_line('사번'||vempno||'은 '||vename||
                        '사원이고 커미션을 받지 않습니다.');
  end if;
  
end;
/



