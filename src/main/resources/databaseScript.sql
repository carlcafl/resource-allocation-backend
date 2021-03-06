create type typDepartmentType AS ENUM ('GERENCIA','DIRECCION');
drop table tblDepartments cascade;
create table tblDepartments(id serial NOT NULL primary key, departmentType typDepartmentType NOT NULL, name varchar(30) NOT NULL, active BOOLEAN DEFAULT TRUE, parentId int);
drop table tblProjectTypes cascade;
create table tblProjectTypes(id serial NOT NULL primary key, projectType varchar(30) NOT NULL);
drop table tblPlatforms cascade;
create table tblPlatforms(id serial NOT NULL primary key, shortName varchar(15) NOT NULL UNIQUE, fullName varchar(100) NOT NULL, department int not null references tblDepartments(id),  owner varchar(100), ownerEmail varchar(50));
drop table tblPlatformCapacity cascade;
create table tblPlatformCapacity(id serial NOT NULL primary key, platformId int not null references tblPlatforms(id), startDate date not null, endDate date, maintenanceCapacity numeric(5,2) not null, supportCapacity numeric(5,2) not null);
drop table tblPlatformProjectConfig cascade;
create table tblPlatformProjectConfig(id serial NOT NULL primary key, platformId int not null references tblPlatforms(id), projectSize varchar(2), capacity numeric(5,2) not null);
drop table tblPlatformProjectCapacity cascade;
create table tblPlatformProjectCapacity(id serial NOT NULL primary key, capacityId int not null references tblPlatformCapacity(id), teamMemberName varchar(100) not null, role varchar(30), capacity numeric(5,2) not null);
drop table tblProjects cascade;
create table tblProjects(id serial NOT NULL primary key, name varchar(50) NOT NULL, projectType int not null references tblProjectTypes(id), startDate date NOT NULL, endDate date,  size varchar(2) not null, platformId int not null references tblPlatforms(id), leadAnalyst varchar(50) not null, leadAnalystEmail varchar(50) not null, status varchar(20) not null);
drop table tblPlatformsByProject;
create table tblPlatformsByProject(id serial NOT NULL primary key, projectId int not null references tblProjects(id), teamMemberId int not null references tblPlatformProjectCapacity(id), size varchar(2) not null, assignedCapacity numeric(5,2) not null)

drop table tblApplications;
create table tblApplications(id serial NOT NULL primary key, name varchar(50) NOT NULL, platformId int not null references tblPlatforms(id), applicationType varchar(10) NOT NULL, programmingLanguage varchar(50), securityType varchar(10), sourceControlURL varchar(250), jenkinsProjectName varchar(250), sourceAnalysisURL varchar(250), serverName varchar(50), webContainerName varchar(50), webContextName varchar(50), dbType varchar(10), dbInstanceName varchar(50), dbOwnerUser varchar(30), dbConnectionUser varchar(30));
drop table tblLibraries;
create table tblLibraries(id serial NOT NULL primary key, name varchar(50) NOT NULL, platformId int not null references tblPlatforms(id), description varchar(250));
