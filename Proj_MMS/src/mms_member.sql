CREATE TABLE mms_member (
	id number not null primary key,
	name varchar2(12) not null unique,
	addr varchar2(50) not null,
	nation varchar2(23) not null,
	email varchar2(30) not null,
	age number
);

create sequence member_id_seq
start with 0
increment by 1
minvalue 0;