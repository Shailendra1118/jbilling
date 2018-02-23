create table STORE(id number(10) primary key, uname varchar2(50), pwd varchar2(10));
create table NGO(ngo_id number(10) primary key, short_desc varchar2(20), long_desc varchar2(100), summary varchar2(200), type varchar2(20), img_url varchar2(50), rating varchar2(10));
create table CAUSE(cause_id number(10) primary key, short_desc varchar2(40), long_desc varchar2(500), type varchar2(20),  img_url varchar2(50), opening_tag varchar2(200), situation varchar2(300), total_cost number(10), accumulated_tillnow number(10), currency varchar2(2));
create table NGO_CAUSE(ncid number(10) primary key, ngo_id number(10), cause_id number(10));
