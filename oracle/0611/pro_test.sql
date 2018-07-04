
--pro_test.sql (특정부서 삭제)

--create or replace procedure del_dept
--create or replace procedure del_dept(delNo number)
create or replace procedure del_dept(delNo  in  number,
                                tomorrow out varchar2)
is

begin
  tomorrow := '화요일';	
  /*	
  delete from dept3
  where deptno=40;
  dbms_output.put_line('#40번 부서를 삭제하였습니다!!');
  */
  delete from dept3
  where deptno=delNo;
  dbms_output.put_line('#'||delNo||
                   '번 부서를 삭제하였습니다!!');
end;
/



