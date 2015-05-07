insert into tblPlatforms(shortName, fullName, department, owner, ownerEmail) values 
('CORE_SEG','Core de Seguros','Negocios de Seguros', 'Luz Elvira V�squez Monsalve', 'levasquez@sura.com.co'),
('AUTOM_PROC','Automatizaci�n de Procesos', 'Automatizaci�n de Procesos', 'Mildred Mar�a Mar�n Ram�rez', 'mmarinr@sura.com.co'),
('ASISTENCIA','Asistencia','Gesti�n de Riesgos y Asistencia', 'Carlos Alberto Carmona Fl�rez', 'cacarmona@sura.com.co'),
('GESTION_RGOS','Gesti�n de Riesgos','Gesti�n de Riesgos y Asistencia', 'Carlos Alberto Carmona Fl�rez', 'cacarmona@sura.com.co'),
('EVALUACION','Evaluaci�n de Riesgos','Gesti�n de Riesgos y Asistencia', 'Carlos Alberto Carmona Fl�rez', 'cacarmona@sura.com.co'),
('CORE_ARL','Core ARL','Negocio ARL', 'Jonathan Alexander Diosa Giraldo', 'jdiosa@sura.com.co')
;

insert into tblProjects (name, startDate, endDate, size, platformId, leadAnalyst, leadAnalystEmail, status) values
('Evaluaci�n del Core de Seguros', date '2015-04-01', null, 'XL', 1, 'David Cardona', 'dacardona@sura.com.co' ,'P'),
('Redise�o de modernizaci�n Autos', date '2015-04-15', null, 'L', 2, 'Juan Camilo P�rez', 'jcperezh@sura.com.co' ,'P'),
('Asistencia', date '2015-04-01', null, 'XL', 3, 'Edwin Salinas', 'esalinas@sura.com.co' ,'P'),
('Nuevo modelo de negocio CGR', date '2014-05-12', null, 'XL', 4, 'Dubier Estrada', 'destrada@sura.com.co' ,'P');
