

-- member.sql

drop table member;

create table member(
   id    varchar2(20) constraint member_pk primary key,
   pass  varchar2(20)  not null,
   name  varchar2(20) not null,
   ssn1  number(6) not null,
   ssn2  number(7) not null,
   phone varchar2(14), --'010-1234-5678'
   addr  varchar2(100),
   job   varchar2(30)
);

insert into MEMBER values ('gildong','1234','홍길동',900203,1012345,'010-1234-5678','남터','학생');
insert into MEMBER values ('lime','9876','길라임',900306,2012345,'010-1234-7777','고터','학생');
insert into MEMBER values ('juwon','1234','김주원',900306,1012345,'010-1234-7777','고터','학생');
insert into MEMBER values ('yousin','1234','길유신',900306,1012345,'010-1234-7777','고터','학생');
insert into MEMBER values ('gildong2','1234','나길동',900306,1012345,'010-1234-7777','고터','학생');
insert into MEMBER values ('lime2','1234','홍라임',900306,2012345,'010-1234-7777','고터','학생');
insert into MEMBER values ('juwon2','1234','홍주원',900306,2012345,'010-1234-7777','고터','학생');
insert into MEMBER values ('yoosin','1234','홍유신',900306,1012345,'010-1234-7777','고터','학생');
insert into MEMBER values ('soonsin','1234','김순신',900306,2012345,'010-1234-7777','고터','학생');
insert into MEMBER values ('hwasin','1234','홍화신',900306,2012345,'010-1234-7777','고터','학생');

insert into MEMBER (id,pass,name,ssn1,ssn2)
      values ('admin','manager','매니저',111111,2222222);







