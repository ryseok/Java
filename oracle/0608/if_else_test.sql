

--if_else_test.sql
/*
    ��1: ���7788�� SCOTT����̰� Ŀ�̼��� ���� �ʽ��ϴ�.
    ��2: ���7654�� MARTIN����̰� Ŀ�̼��� 1400 �޽��ϴ�.
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
    then  dbms_output.put_line('���'||vempno||'�� '||vename||
                        '����̰� Ŀ�̼��� '||vcomm||'�޽��ϴ�.');
    else  dbms_output.put_line('���'||vempno||'�� '||vename||
                        '����̰� Ŀ�̼��� ���� �ʽ��ϴ�.');
  end if;
  
end;
/



