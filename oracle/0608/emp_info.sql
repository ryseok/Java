

-- 0608/emp_info.sql
-- ����) 7788����� ���� ����� �����ȣ�� �����, �޿��� ȭ�鿡 ���.

declare
  -- ����ο��� ����� ���� ����!!
  vempno number(4);--a number(4);
  vename varchar2(15);
  vsal  emp.sal%type;

begin
  -- SQL�� (DQL, DML), ���ǹ�, �ݺ���
   select empno, ename, sal into vempno, vename, vsal --a,b,c
   from emp
   where empno=7788;
	
   dbms_output.put_line('�����ȣ: '||vempno);
   dbms_output.put_line('�����:'|| vename ||', �޿�:'|| vsal);
   
end;
/




