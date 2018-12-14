create table usertbl(
	no int auto_increment primary key,
	name varchar(10),
	birthday date,
	address varchar(20)
);

create table goodsinfo(
	code varchar(5) not null,
	title varchar(50) not null,
	writer varchar(20),
	price int not null,
	primary key(code)
);

insert into goodsinfo values('1001','뇌를 자극하는 JSP','김윤명',27000);
insert into goodsinfo values('1002','뇌를 자극하는 JAVA','김윤명',27000);
insert into goodsinfo values('1003','뇌를 자극하는 ORACLE','김윤명',27000);
insert into goodsinfo values('1004','어서와 JAVA는 처음이지','천인국',28000);
insert into goodsinfo values('1005','Power JAVA','천인국',33000);

select * from goodsinfo;

show tables;

