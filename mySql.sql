create database bank;
use bank;
create table employees(emp_id int,emp_salary integer,emp_name varchar(30),emp_branchname varchar(30),emp_branchid int primary key, emp_age int
check(age>18));
insert into employees values(1,1000,"navenn","Salem","19",33),(5,200,"Prabha","chennai","12",34),(3,30000,"MGR","salem","13",26);

use bank;
create table customer(cus_address varchar(20),cus_accno varchar(30),cus_pinno int,cus_name varchar(20),cus_balan int,cus_pan integer,cus_branchid int ,cus_acctyp varchar(20));
insert into customer values("vasulraja","hauyd56",321,"powerstart",10000,917,13,"current"),("ooihsxyo","235io",322,"helan",101,92,14,"saving"),("raja","236kl",323,"tamilselvi",102,93,14,"deposit"),("prema","585ok",569,"vasulraja",124,54,78,"saving");
select * from customer;
