

-- 0611/if_elsif_test.sql

/*
����) Ư������� �����ȣ, �����, �Ҽӵ� �μ����� ����Ͻÿ�.
   ��: ���7788�� SCOTT����̰� RESEARCH�μ��� �ٹ��մϴ�.

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
   
   
   dbms_output.put_line('���'||vempno||'�� '||vename||'����̰� '
                        ||vdname||'�μ��� �ٹ��մϴ�.');
end;
/






