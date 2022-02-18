create database [hms1]
on primary
(
	Name = 'hmsDB',
	FileName = 'C:\Users\User\Desktop\HMS\Hotel Management System\hotelManagementSystem\src\hotelmanagementsystem\MY DATABASE\hmsDB.mdf',
	Size = 500MB,
	MaxSize = 2GB,
	Filegrowth = 100MB
)
Log on
(
	Name = 'hmsDB_LOG',
	FileName = 'C:\Users\User\Desktop\HMS\Hotel Management System\hotelManagementSystem\src\hotelmanagementsystem\MY DATABASE\hmsDB_LOG.ldf',
	Size = 10MB,
	MaxSize = 1GB,
	Filegrowth = 10MB
)
drop database [hms1]

use hms1

create table Login
(
	ID int identity(1,1) Primary Key,
	UserName varchar(100) not null,
	Password varchar(100) not null
)
insert into Login values('Admin','12345')

select * from Login
drop table Login