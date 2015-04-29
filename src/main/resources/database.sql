drop table tblPlatforms;
create table tblPlatforms(id serial NOT NULL, shortName varchar(15) NOT NULL, fullName varchar(100) NOT NULL, department varchar(50),  owner varchar(100), ownerEmail varchar(50));
insert into tblPlatforms(shortName, fullName, department, owner, ownerEmail) values 
('CORE_SEG','Core de Seguros','Negocios de Seguros', 'Luz Elvira V�squez Monsalve', 'levasquez@sura.com.co'),
('AUTOM_PROC','Automatizaci�n de Procesos', 'Automatizaci�n de Procesos', 'Mildred Mar�a Mar�n Ram�rez', 'mmarinr@sura.com.co');
