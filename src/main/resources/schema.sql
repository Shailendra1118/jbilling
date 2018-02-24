create table STORE(id number(10) primary key, 
store_name varchar2(50), 
description varchar2(50), 
location varchar2(10));

create table PRODUCT(id number(10) primary key, 
product_name varchar2(20), 
description varchar2(50), 
base_price number(10), 
product_type varchar2(20), 
img_url varchar2(50), 
rating varchar2(10));

create table STORE_PRICE(id number(10) primary key, 
product_id number(10),
store_id number(10), 
store_price number(10),  
currency varchar2(50),
created_at timestamp,
updated_at timestamp);

CREATE INDEX prod_idx ON STORE_PRICE(product_id);
CREATE INDEX stor_idx ON STORE_PRICE(store_id);


create table PRICE_INFO(id number(10) primary key, 
product_id number(10),
ideal_price number(10),  
currency varchar2(50),
created_at timestamp,
updated_at timestamp);
