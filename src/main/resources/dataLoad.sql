insert into tblDepartments(departmentType, name, active, parentId) values
('GERENCIA','TI Seguros', TRUE, NULL),
('DIRECCION','Seguros Generales', TRUE, 1),
('DIRECCION','Seguros de Vida', TRUE, 1),
('DIRECCION','Plataformas Transversales', TRUE, 1),
('DIRECCION','Salud', TRUE, 1),
('DIRECCION','Procesos de Suscripci�n', TRUE, 1),
('DIRECCION','Modelos de Venta', TRUE, 1)
;


insert into tblProjectTypes(projectType) values
('Corporativo'),
('Estrat�gico'),
('Operativo'),
('Interno de TI')
;

insert into tblPlatforms(shortName, fullName, department, owner, ownerEmail) values 
('CORE_SEG_GRLES','Core de Seguros Generales', 2, 'Luz Elvira V�squez Monsalve', 'levasquez@sura.com.co'),
('AUTOM_PROC','Automatizaci�n de Procesos', 6, 'Mildred Mar�a Mar�n Ram�rez', 'mmarinr@sura.com.co'),
('ASISTENCIA','Asistencia', 2 , 'Carlos Alberto Carmona Fl�rez', 'cacarmona@sura.com.co'),
('EVALUACION','Evaluaci�n de Riesgos',6, 'Carlos Alberto Carmona Fl�rez', 'cacarmona@sura.com.co')
;

insert into tblProjects (name, projectType, startDate, endDate, size, platformId, leadAnalyst, leadAnalystEmail, status) values
('Evaluaci�n del Core de Seguros', 2, date '2015-04-01', null, 'XL', 1, 'David Cardona', 'dacardona@sura.com.co' ,'EnProceso'),
('Redise�o de modernizaci�n Autos', 4, date '2015-04-15', null, 'L', 2, 'Juan Camilo P�rez', 'jcperezh@sura.com.co' ,'EnProceso'),
('Asistencia', 2, date '2015-04-01', null, 'XL', 3, 'Edwin Salinas', 'esalinas@sura.com.co' ,'EnProceso'),
('Nuevo modelo de negocio CGR', 1, date '2014-05-12', null, 'XL', 4, 'Dubier Estrada', 'destrada@sura.com.co' ,'EnProceso'),
('Proyecto SEIS: Sistema de Evaluaci�n Integral Sura', 3, date '2014-05-12', null, 'L', 5, 'Johan Ru�z', 'jmruiz@sura.com.co' ,'EnProceso')
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
(1, 'Johan Miguel Ru�z Rodr�guez', 'Architect', 1)
;

insert into tblPlatformsByProject(projectId, teamMemberId, size, assignedCapacity) values
(5, 1, 'L', 0.75);

insert into tblApplications(name, platformId, applicationType, programmingLanguage, securityType, sourceControlURL, jenkinsProjectName, sourceAnalysisURL, serverName, webContainerName, webContextName, dbType, dbInstanceName, dbOwnerUser, dbConnectionUser) values 
('MEVI', 5, 'WEB', 'Java', 'SEUS', null, null, null, null, null, null, 'Oracle', 'PDN', 'OPS$MEVI', 'OPS$ADM_MEVI'),
('SIA', 5, 'WEB', 'Java', 'SEUS', null, null, null, null, null, null, 'Oracle', 'PDN', 'OPS$SIA', 'OPS$ADM_SIA'),
('SGR', 5, 'WEB', 'Java', 'SEUS', null, null, null, null, null, null, 'Oracle', 'PDN', 'OPS$SGR', 'OPS$ADM_SGR'),
('Requisitos', 5, 'WEB', 'Java', 'SEUS', null, null, null, null, null, null, 'Oracle', 'PDN', 'OPS$REQ', 'OPS$ADM_REQ'),
('MIC', 5, 'WEB', 'PL/SQL', 'Propio', null, null, null, null, null, null, 'Oracle', 'PDN', 'ONYXCONS', 'ONYXCONS'),
('MIC 1.5', 5, 'WEB', 'Java', 'SEUS', null, null, null, null, null, null, 'Oracle', 'PDN', 'OPS$MIC', 'OPS$ADM_MIC'),
('MIC 2', 5, 'WEB', 'Java', 'SEUS', null, null, null, null, null, null, 'Oracle', 'PDN', 'OPS$MIC', 'OPS$ADM_MIC')
;

