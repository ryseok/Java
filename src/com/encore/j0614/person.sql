




-- person.sql (person���̺� ���õ� DDL�� DML����)

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
   
-- ����(constraint) �߰�   
   
   
-- DML(insert)�߰� : ���õ����� �߰�
   
   
   
   