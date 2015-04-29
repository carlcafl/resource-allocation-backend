drop table tblPlatforms;
create table tblPlatforms(id serial NOT NULL, shortName varchar(15) NOT NULL, fullName varchar(100) NOT NULL, department varchar(50),  owner varchar(100), ownerEmail varchar(50));
insert into tblPlatforms(shortName, fullName, department, owner, ownerEmail) values 
('CORE_SEG','Core de Seguros','Negocios de Seguros', 'Luz Elvira Vásquez Monsalve', 'levasquez@sura.com.co'),
('AUTOM_PROC','Automatización de Procesos', 'Automatización de Procesos', 'Mildred María Marín Ramírez', 'mmarinr@sura.com.co');
