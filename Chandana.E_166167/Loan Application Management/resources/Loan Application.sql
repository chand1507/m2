 create table Customer(Cust_id number Primary key,Cust_name varchar2(25) not null,Address varchar2(25) not null,Email varchar2(30),MobileNo varchar2(10));

Table created.

SQL> create sequence Cust_seq
  2  start with 10001;

Sequence created.