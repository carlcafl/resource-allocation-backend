insert into tblProjectTypes(projectType) values
('Corporativo'),
('Estratégico'),
('Operativo'),
('Interno de TI')
;

insert into tblPlatforms(shortName, fullName, department, owner, ownerEmail) values 
('CORE_SEG','Core de Seguros','Negocios de Seguros', 'Luz Elvira Vásquez Monsalve', 'levasquez@sura.com.co'),
('AUTOM_PROC','Automatización de Procesos', 'Automatización de Procesos', 'Mildred María Marín Ramírez', 'mmarinr@sura.com.co'),
('ASISTENCIA','Asistencia','Gestión de Riesgos y Asistencia', 'Carlos Alberto Carmona Flórez', 'cacarmona@sura.com.co'),
('GESTION_RGOS','Gestión de Riesgos','Gestión de Riesgos y Asistencia', 'Carlos Alberto Carmona Flórez', 'cacarmona@sura.com.co'),
('EVALUACION','Evaluación de Riesgos','Gestión de Riesgos y Asistencia', 'Carlos Alberto Carmona Flórez', 'cacarmona@sura.com.co'),
('CORE_ARL','Core ARL','Negocio ARL', 'Jonathan Alexander Diosa Giraldo', 'jdiosa@sura.com.co')
;

insert into tblProjects (name, projectType, startDate, endDate, size, platformId, leadAnalyst, leadAnalystEmail, status) values
('Evaluación del Core de Seguros', 2, date '2015-04-01', null, 'XL', 1, 'David Cardona', 'dacardona@sura.com.co' ,'EnProceso'),
('Rediseño de modernización Autos', 4, date '2015-04-15', null, 'L', 2, 'Juan Camilo Pérez', 'jcperezh@sura.com.co' ,'EnProceso'),
('Asistencia', 2, date '2015-04-01', null, 'XL', 3, 'Edwin Salinas', 'esalinas@sura.com.co' ,'EnProceso'),
('Nuevo modelo de negocio CGR', 1, date '2014-05-12', null, 'XL', 4, 'Dubier Estrada', 'destrada@sura.com.co' ,'EnProceso'),
('Proyecto SEIS: Sistema de Evaluación Integral Sura', 3, date '2014-05-12', null, 'L', 5, 'Johan Ruíz', 'jmruiz@sura.com.co' ,'EnProceso')
;

insert into tblPlatformCapacity(platformId, startDate, endDate, maintenanceCapacity, supportCapacity) values
(5, date '2015-01-01', null, 1.6, 0.4)
;

insert into tblPlatformProjectConfig(platformId, projectSize, capacity) values
(5, 'S', 0.25),
(5, 'M', 0.3),
(5, 'L', 0.75),
(5, 'XL', 1)
;

insert into tblPlatformProjectCapacity(capacityId, teamMemberName, role, capacity) values
(1, 'Johan Miguel Ruíz Rodríguez', 'Architect', 1)
;

insert into tblPlatformsByProject(projectId, teamMemberId, size, assignedCapacity) values
(5, 1, 'L', 0.75);
