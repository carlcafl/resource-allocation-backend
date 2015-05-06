drop table tblPlatforms;
create table tblPlatforms(id serial NOT NULL primary key, shortName varchar(15) NOT NULL, fullName varchar(100) NOT NULL, department varchar(50),  owner varchar(100), ownerEmail varchar(50));
drop table tblProjects;
create table tblProjects(id serial NOT NULL, name varchar(50) NOT NULL, startDate date NOT NULL, endDate date,  size varchar(2) not null, platformId int not null references tblPlatforms(id), leadAnalyst varchar(50) not null, leadAnalystEmail varchar(50) not null, status varchar(1) not null);
