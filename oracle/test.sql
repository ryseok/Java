

-- test.sql

select empno,ename,sal from emp;


/*
   emp7테이블 생성  ===> emp테이블의 empno,ename,sal,deptno 컬럼만 복사(데이터 복사X)
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
    
    
    
   
   
   