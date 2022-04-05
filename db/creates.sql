
CREATE TABLE Usuario (
  cod_usuario varchar(20) NOT NULL,
  password varchar(20),
  PRIMARY KEY (cod_usuario)
);

CREATE TABLE HT_Usuario (
  id_ht INTEGER NOT NULL AUTO_INCREMENT,
  cod_usuario varchar(20),
  fecha_conexion DATETIME  NOT NULL,
  PRIMARY KEY (id_ht),
  CONSTRAINT FK_cod_usuarioHT FOREIGN KEY (cod_usuario) REFERENCES Usuario(cod_usuario)
);

CREATE TABLE Diagnostico (
  id_diagnostico INTEGER NOT NULL AUTO_INCREMENT,
  nombre_diagnostico varchar(100),
  descripcion varchar(500),
  tratamiento varchar(500),
  PRIMARY KEY (id_diagnostico)
);
CREATE INDEX diagnostico_nombre ON Diagnostico(nombre_diagnostico);
CREATE INDEX diagnostico_descripcion ON Diagnostico(descripcion);

CREATE TABLE Paciente (
  id_paciente INTEGER NOT NULL AUTO_INCREMENT,
  nombre varchar(50) NOT NULL,
  apellido1 varchar(20) NOT NULL,
  apellido2 varchar(20),
  nif varchar(10) NOT NULL,
  email varchar(100),
  telefono INTEGER,
  fecha_nacimiento DATETIME,
  codusuario varchar(20),
  num_sip INTEGER,
  num_seg_social INTEGER,
  PRIMARY KEY (id_paciente),
  CONSTRAINT FK_cod_usuario FOREIGN KEY (codUsuario) REFERENCES Usuario(cod_usuario)
);
CREATE INDEX paciente_nombre ON Paciente(nombre);
CREATE INDEX paciente_apellido1 ON Paciente(apellido1);
CREATE INDEX paciente_apellido2 ON Paciente(apellido2);

CREATE TABLE Medico (
  id_medico INTEGER NOT NULL AUTO_INCREMENT,
  nombre varchar(50) NOT NULL,
  apellido1 varchar(20) NOT NULL,
  apellido2 varchar(20),
  nif varchar(10) NOT NULL,
  email varchar(100),
  telefono INTEGER,
  especialidad varchar(50),
  num_colegiado INTEGER,
  PRIMARY KEY (id_medico)
);
CREATE INDEX medico_nombre ON Medico(nombre);
CREATE INDEX medico_apellido1 ON Medico(apellido1);
CREATE INDEX medico_apellido2 ON Medico(apellido2);
/*
CREATE TABLE Usuario_CM (
  id_medico INTEGER NOT NULL,
  cod_usuario varchar(20) NOT NULL,
  password varchar(20),
  PRIMARY KEY (cod_usuario),
  CONSTRAINT FK_id_medico FOREIGN KEY (id_medico) REFERENCES Medico(id_medico)
);*/

CREATE TABLE Cita (
  id_cita INTEGER NOT NULL AUTO_INCREMENT,
  id_diagnostico INTEGER,
  fecha DATETIME,
  codigo_cita varchar(10),
  id_medico INTEGER NOT NULL,
  id_paciente INTEGER NOT NULL,
  PRIMARY KEY (id_cita),
  CONSTRAINT FK_id_diagnostico FOREIGN KEY (id_diagnostico) REFERENCES Diagnostico(id_diagnostico),
  CONSTRAINT FK_id_medicoCita FOREIGN KEY (id_medico) REFERENCES Medico(id_medico),
  CONSTRAINT FK_id_pacienteCita FOREIGN KEY (id_paciente) REFERENCES Paciente(id_paciente)
);
/*
CREATE TABLE HT_Medico (
  id_medico INTEGER NOT NULL,
  id_cita INTEGER NOT NULL,
  PRIMARY KEY (id_medico, id_cita),
  CONSTRAINT FK_id_medicoHT FOREIGN KEY (id_medico) REFERENCES Medico(id_medico),
  CONSTRAINT FK_id_citaHT FOREIGN KEY (id_cita) REFERENCES Cita(id_cita)
);

CREATE TABLE HT_Paciente (
  id_paciente INTEGER NOT NULL,
  id_cita INTEGER NOT NULL,
  PRIMARY KEY (id_paciente, id_cita),
  CONSTRAINT FK_id_pacienteHTPac FOREIGN KEY (id_paciente) REFERENCES Paciente(id_paciente),
  CONSTRAINT FK_id_citaHTPac FOREIGN KEY (id_cita) REFERENCES Cita(id_cita)
);*/

CREATE TABLE Medico_Paciente (
  id_paciente INTEGER NOT NULL,
  id_medico INTEGER NOT NULL,
  PRIMARY KEY (id_paciente, id_medico),
  CONSTRAINT FK_id_pacienteMP FOREIGN KEY (id_paciente) REFERENCES Paciente(id_paciente),
  CONSTRAINT FK_id_medicoMP FOREIGN KEY (id_medico) REFERENCES Medico(id_medico)
);