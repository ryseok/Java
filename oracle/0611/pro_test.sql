
--pro_test.sql (Ư���μ� ����)

--create or replace procedure del_dept
--create or replace procedure del_dept(delNo number)
create or replace procedure del_dept(delNo  in  number,
                                tomorrow out varchar2)
is

begin
  tomorrow := 'ȭ����';	
  /*	
  delete from dept3
  where deptno=40;
  dbms_output.put_line('#40�� �μ��� �����Ͽ����ϴ�!!');
  */
  delete from dept3
  where deptno=delNo;
  dbms_output.put_line('#'||delNo||
                   '�� �μ��� �����Ͽ����ϴ�!!');
end;
/



