


-- 0611/fun_test.sql

create or replace function call_bonus(vename emp.ename%type)  
return number
is
  --��������
  vsal emp.sal%type;
  bonus number;
begin
	dbms_output.put_line('�Լ��ȳ�~!!');
	select sal  into vsal
	from emp
	where  ename=vename;
	
	-- ���ʽ� ���
	bonus := vsal*2;
	
	return bonus;
end;
/



