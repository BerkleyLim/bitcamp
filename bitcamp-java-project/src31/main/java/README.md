# 변경 내역
- build.gradle 변경
- eclipse 설정 파일 갱신
- pms_board 테이블 생성
- pms_member 테이블 생성
- pms_classroom 테이블 생성
- pms_team 테이블 생성
- pms_teammember 테이블 생성
- pms_task 테이블 생성

```
create table pms_board (
    bno int not null,
    titl varchar(255) not null,
    cont text,
    cdt datetime not null
);

alter table pms_board
    add constraint pms_board_pk primary key (bno);
    
alter table pms_board
    modify column bno int not null auto_increment;
    
<-- 테이블 통째로 지우기-->
drop table pms_board;
    
<-- 테이블 내용 확인-->
desc pms_board;
    
----------------------------------------------------------------
    
create table pms_member (
    mid varchar(20) not null,
    email varchar(255) not null,
    pwd varchar(100)
);

alter table pms_member
    add constraint pms_member_pk primary key (mid);
    
<-- 테이블 통째로 지우기-->
drop table pms_member;
    
<-- 테이블 내용 확인-->
desc pms_member;

<멤버 데이터 삽입>
insert into pms_member(mid, email, pwd) 
       values('user02', 'user02@test.com', sha2('1111', 224));
       
=> sha2("암호명", 길이제한) : 해당 문자열을 해쉬값으로 저장

----------------------------------------------------------------

create table pms_classroom (
    crno int not null,
    titl varchar(255) not null,
    sdt datetime not null,
    edt datetime not null,
    room varchar(50)
);

alter table pms_classroom
    add constraint pms_classroom_pk primary key (crno);

alter table pms_classroom
    modify column crno int not null auto_increment;
    
<-- 테이블 통째로 지우기-->
drop table pms_classroom;
    
<-- 테이블 내용 확인-->
desc pms_classroom;

<수업 데이터 삽입>
insert into pms_classroom(title,sdt,edt,room) 
       values('');


--------------------------------------------------------------
create table pms_team(
    name varchar(100) not null,
    dscrt text,
    mqt int not null,
    sdt datetime not null,
    edt datetime not null
);

alter table pms_team
    add constraint pms_team_pk primary key (name);

<-- 테이블 통째로 지우기-->
drop table pms_team;
    
<-- 테이블 내용 확인-->
desc pms_team;

<팀 데이터 삽입>
insert into pms_tean(title,sdt,edt,room) 
       values('');

--------------------------------------------------------------
create table pms_team_member(
    tnm varchar(100) not null,
    mid varchar(20) not null,
    
    primary key (tnm, mid)
);

    
<-- 테이블 통째로 지우기-->
drop table pms_team_member;

--------------------------------------------------------------
create table pms_task(
    tano int not null,
    titl varchar(255) not null,
    sdt datetime not null,
    edt datetime not null,
    stat int default 0,
    mid varchar(20) not null,
    tnm varchar(100) not null,
    
    primary key (tano),
    foreign key (mid) references pms_member(mid),
    foreign key (tnm) references pms_team (name)
);

alter table pms_task
    modify column tano int not null auto_increment;

<-- 테이블 통째로 지우기-->
drop table pms_task;
```