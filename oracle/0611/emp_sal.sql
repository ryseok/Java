

-- emp_sal.sql

/*
Ư����� �Ѹ��� �����ȣ, �����, ������ ����Ͻÿ�.
     (��������� �޿�*12+COMM)
     
    ===> where empno=7788;     where empno=7654;  
    ===> ��) ��� 7788�� SCOTT����̰� ������ 36000�Դϴ�.
*/
declare
  vempno  emp.empno%type;
  vename  emp.ename%type;
  vsal    emp.sal%type;   
  vcomm   emp.comm%type;
  
  --����
  annsal number;
  
begin
  -- SQL�� (select,insert,delete,update)
  select empno,ename,sal,comm into vempno, vename, vsal,vcomm
  from emp
  where empno=7788;
  
  -- annsal  := vsal*12+vcomm;
  -- SCOTT��� ��� 3000*12+null    ---> null
  -- MARTIN��� ��� 1250*12+1400   ---> 16400
  
  if(vcomm is null)
    then annsal := vsal*12+ 0;
    else annsal := vsal*12+vcomm;
  end if;
  
  dbms_output.put_line('��� '||vempno||'�� '||vename||'����̰� ������ '||
                        annsal||'�Դϴ�.');
  
end;
/









