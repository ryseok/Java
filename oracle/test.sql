

-- test.sql

select empno,ename,sal from emp;


/*
   emp7���̺� ����  ===> emp���̺��� empno,ename,sal,deptno �÷��� ����(������ ����X)
 */

create table emp7
as select empno,ename,sal,deptno
   from EMP
   where 1=0;
   
select * from emp7;   
   
---------------------------------------------------------------------
drop table names;
create table names(
   name varchar2(15)
);

select * from names;
    
    
    
   
   
   