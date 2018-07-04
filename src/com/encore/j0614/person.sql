




-- person.sql (person테이블에 관련된 DDL과 DML저장)

drop table person;
   create table person(
     no   number    constraint  person_pk  primary key,
     name varchar2(15),
     age  number(3),
     job  varchar2(15)
   );
      
drop sequence person_seq;   
   create sequence person_seq
   start with 1
   increment by 1
   nocycle
   nocache;
   
select * from PERSON;   
   
-- 제약(constraint) 추가   
   
   
-- DML(insert)추가 : 샘플데이터 추가
   
   
   
   