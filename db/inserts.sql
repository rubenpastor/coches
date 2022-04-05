
INSERT INTO Usuario
VALUES ('ruben', '12345');
INSERT INTO PACIENTE (id_paciente,nombre, apellido1, apellido2, nif, email, telefono,fecha_nacimiento,codusuario)
VALUES(1,'Rubén','Pastor','Corrales','53655253B','correo@correo.com',654654654,STR_TO_DATE('02/02/1988','%d/%m/%Y'), 'ruben');
INSERT INTO MEDICO (id_medico, nombre, apellido1, apellido2, nif, email, telefono, especialidad, num_colegiado)
VALUES (1, 'Rafael', 'Puerto', 'Pérez', '98356738G','rpupe@citapp.com',636378990,'Traumatología',2600356);
INSERT INTO MEDICO (id_medico, nombre, apellido1, apellido2, nif, email, telefono, especialidad, num_colegiado)
VALUES (2, 'Nieves', 'López', 'Martinez', '87466738F','nloma@citapp.com',687468598,'Medicina familiar',2784564);
INSERT INTO MEDICO (id_medico, nombre, apellido1, apellido2, nif, email, telefono, especialidad, num_colegiado)
VALUES (3, 'Raquel', 'Pastor', 'Aguilar', '45368378B','rpaag@citapp.com',676090362,'Ginecología',2987465);
INSERT INTO MEDICO (id_medico, nombre, apellido1, apellido2, nif, email, telefono, especialidad, num_colegiado)
VALUES (4, 'Francisco', 'Puerto', 'Iniesta', '49874738Y','fpuin@citapp.com',612306408,'Odontología',9834656);
INSERT INTO Diagnostico (id_diagnostico, nombre_diagnostico, descripcion, tratamiento)
VALUES (1, 'Esguince de tobillo', 'El paciente tiene dolor al realizar movimientos y al andar en el tobillo', 'Reposo durante 15 días. En caso de dolor puede tomar ibuprofeno cada 8 horas.');
INSERT INTO Cita (id_cita, id_diagnostico, fecha, codigo_cita, id_medico, id_paciente)
VALUES (1, NULL,STR_TO_DATE('02/02/2021 10:00','%d/%m/%Y %h:%i'), '4F57C2',4,1);
INSERT INTO Cita (id_cita, id_diagnostico, fecha, codigo_cita, id_medico, id_paciente)
VALUES (2, 1,STR_TO_DATE('02/03/2020 12:00','%d/%m/%Y %h:%i'), '4U57O7',1,1);