
--pro_test2.sql
create or replace procedure del_ename(delEname varchar2)
is
begin
  delete from emp3
  --where ename='ADAMS';
  where ename=delEname;
  
  dbms_output.put_line(delEname||'사원을 삭제했습니다!!');
end;
/
show errors;