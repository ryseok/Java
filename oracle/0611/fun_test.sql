


-- 0611/fun_test.sql

create or replace function call_bonus(vename emp.ename%type)  
return number
is
  --변수선언
  vsal emp.sal%type;
  bonus number;
begin
	dbms_output.put_line('함수안녕~!!');
	select sal  into vsal
	from emp
	where  ename=vename;
	
	-- 보너스 계산
	bonus := vsal*2;
	
	return bonus;
end;
/



