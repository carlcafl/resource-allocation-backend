insert into tblPlatforms(shortName, fullName, department, owner, ownerEmail) values 
('CORE_SEG','Core de Seguros','Negocios de Seguros', 'Luz Elvira Vásquez Monsalve', 'levasquez@sura.com.co'),
('AUTOM_PROC','Automatización de Procesos', 'Automatización de Procesos', 'Mildred María Marín Ramírez', 'mmarinr@sura.com.co'),
('ASISTENCIA','Asistencia','Gestión de Riesgos y Asistencia', 'Carlos Alberto Carmona Flórez', 'cacarmona@sura.com.co'),
('GESTION_RGOS','Gestión de Riesgos','Gestión de Riesgos y Asistencia', 'Carlos Alberto Carmona Flórez', 'cacarmona@sura.com.co'),
('EVALUACION','Evaluación de Riesgos','Gestión de Riesgos y Asistencia', 'Carlos Alberto Carmona Flórez', 'cacarmona@sura.com.co'),
('CORE_ARL','Core ARL','Negocio ARL', 'Jonathan Alexander Diosa Giraldo', 'jdiosa@sura.com.co')
;

insert into tblProjects (name, startDate, endDate, size, platformId, leadAnalyst, leadAnalystEmail, status) values
('Evaluación del Core de Seguros', date '2015-04-01', null, 'XL', 1, 'David Cardona', 'dacardona@sura.com.co' ,'P'),
('Rediseño de modernización Autos', date '2015-04-15', null, 'L', 2, 'Juan Camilo Pérez', 'jcperezh@sura.com.co' ,'P'),
('Asistencia', date '2015-04-01', null, 'XL', 3, 'Edwin Salinas', 'esalinas@sura.com.co' ,'P'),
('Nuevo modelo de negocio CGR', date '2014-05-12', null, 'XL', 4, 'Dubier Estrada', 'destrada@sura.com.co' ,'P');
