

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

insert into MEMBER values ('gildong','1234','ȫ�浿',900203,1012345,'010-1234-5678','����','�л�');
insert into MEMBER values ('lime','9876','�����',900306,2012345,'010-1234-7777','����','�л�');
insert into MEMBER values ('juwon','1234','���ֿ�',900306,1012345,'010-1234-7777','����','�л�');
insert into MEMBER values ('yousin','1234','������',900306,1012345,'010-1234-7777','����','�л�');
insert into MEMBER values ('gildong2','1234','���浿',900306,1012345,'010-1234-7777','����','�л�');
insert into MEMBER values ('lime2','1234','ȫ����',900306,2012345,'010-1234-7777','����','�л�');
insert into MEMBER values ('juwon2','1234','ȫ�ֿ�',900306,2012345,'010-1234-7777','����','�л�');
insert into MEMBER values ('yoosin','1234','ȫ����',900306,1012345,'010-1234-7777','����','�л�');
insert into MEMBER values ('soonsin','1234','�����',900306,2012345,'010-1234-7777','����','�л�');
insert into MEMBER values ('hwasin','1234','ȫȭ��',900306,2012345,'010-1234-7777','����','�л�');

insert into MEMBER (id,pass,name,ssn1,ssn2)
      values ('admin','manager','�Ŵ���',111111,2222222);







