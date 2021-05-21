Create Table FormasPago(
idFormaPago int primary key NOT NULL,
nombre varchar(50) NOT NULL,
estatus char NOT NULL
);

Create Table Periodos(
idPeriodo int primary key NOT NULL,
nombre varchar(50) NOT NULL,
fechaInicio date NOT NULL,
fechaFin date NOT NULL,
estatus char NOT NULL
);

Create Table Deducciones(
idDeduccion int primary key NOT NULL,
nombre varchar(30) NOT NULL,
descripcion varchar(80) NOT NULL,
porcentaje float NOT NULL,
estatus char NOT NULL
);

Create Table Percepciones(
idPercepcion int primary key NOT NULL,
nombre varchar(30) NOT NULL,
descripcion varchar(80) NOT NULL,
diasPagar int NOT NULL,
estatus char NOT NULL
);

Create Table Puestos(
idPuesto int primary key NOT NULL,
nombre varchar(60) NOT NULL,
salarioMinimo float NOT NULL,
salarioMaximo float NOT NULL,
estatus char NOT NULL
);

Create Table Departamentos(
idDepartamento int primary key NOT NULL,
nombre varchar(50) NOT NULL,
estatus char NOT NULL
);

Create Table Turnos(
idTurno int primary key NOT NULL,
nombre varchar(20) NOT NULL,
horaInicio time NOT NULL,
horaFin time NOT NULL,
dias varchar(30) NOT NULL
);

Create Table Estados(
idEstado int primary key NOT NULL,
nombre varchar(60) NOT NULL,
siglas varchar(10) NOT NULL,
estatus char NOT NULL
);

Create Table Ciudades(
idCiudad int primary key NOT NULL,
nombre varchar(80) NOT NULL,
idEstado int NOT NULL,
estatus char NOT NULL,
Constraint fk_Ciudades_Estado FOREIGN KEY (idEstado) REFERENCES Estados (idEstado)
);

Create Table Empleados(
idEmpleado int primary key NOT NULL,
nombre varchar(30) NOT NULL,
apellidoPaterno varchar(30) NOT NULL,
apellidoMaterno varchar(30) NOT NULL,
sexo char NOT NULL,
fechaNacimiento date NOT NULL,
curp varchar(20) NOT NULL,
estadoCivil varchar(20) NOT NULL,
fechaContratacion date NOT NULL,
salarioDiario float NOT NULL,
nss varchar(10) NOT NULL,
diasVacaciones int NOT NULL,
diasPermiso int NOT NULL,
fotografia blob NOT NULL,
direccion varchar(80) NOT NULL,
colonia varchar(50) NOT NULL,
codigoPostal varchar(5) NOT NULL,
escolaridad varchar(80) NOT NULL,
especialidad varchar(100) NOT NULL,
email varchar(100) NOT NULL,
pass varchar(20) NOT NULL,
tipo varchar(10) NOT NULL,
estatus char NOT NULL,
idDepartamento int NOT NULL,
idPuesto int NOT NULL,
idCiudad int NOT NULL,
idSucursal int NOT NULL,
idTurno int NOT NULL,
Constraint fk_Empleados_Ciudades FOREIGN KEY (idCiudad) REFERENCES Ciudades (idCiudad),
Constraint fk_Empleados_Departamentos FOREIGN KEY (idDepartamento) REFERENCES Departamentos (idDepartamento),
Constraint fk_Empleados_Puestos FOREIGN KEY (idPuesto) REFERENCES Puestos (idPuesto),
Constraint fk_Empleados_Turnos FOREIGN KEY (idTurno) REFERENCES Turnos (idTurno)
);

Create Table Asistencias(
idAsistencia int primary key NOT NULL,
fecha date NOT NULL,
horaEntrada time NOT NULL,
horaSalida time NOT NULL,
dia varchar(10) NOT NULL,
idEmpleado int NOT NULL,
estatus char NOT NULL,
Constraint fk_Asistencias_Empleados FOREIGN KEY (idEmpleado) REFERENCES Empleados (idEmpleado)
);

Create Table HistorialPuestos(
idEmpleado int primary key NOT NULL,
idPuesto int NOT NULL,
idDepartamento int NOT NULL,
fechaInicio date NOT NULL,
fechaFin date NOT NULL,
Constraint fk_Historial_Puestos FOREIGN KEY (idPuesto) REFERENCES Puestos (idPuesto),
Constraint fk_Historial_Empleados FOREIGN KEY (idEmpleado) REFERENCES Empleados (idEmpleado),
Constraint fk_Historial_Departamentos FOREIGN KEY (idDepartamento) REFERENCES Departamentos (idDepartamento)
);

Create Table AusenciasJustificadas(
idAudsencia int primary key NOT NULL,
fechaSolicitud date NOT NULL,
fechaInicio date NOT NULL,
fechaFin date NOT NULL,
tipo char NOT NULL,
idEmpleadoSolicita int NOT NULL,
idEmpleadoAutoriza int NOT NULL,
evidencia blob NOT NULL,
estatus char NOT NULL,
motivo varchar(100) NOT NULL,
Constraint fk_AusenciasJustificadas_Empleados_2 FOREIGN KEY (idEmpleadoAutoriza) REFERENCES Empleados (idEmpleado),
Constraint fk_AusenciasJustificadas_Empleados FOREIGN KEY (idEmpleadoSolicita) REFERENCES Empleados (idEmpleado)
);

Create Table DocumentacionEmpleado(
idDocumento int primary key NOT NULL,
nombreDocumento varchar(80) NOT NULL,
fechaEntrega date NOT NULL,
documento blob NOT NULL,
idEmpleado int NOT NULL,
Constraint fk_DocumentacionEmpleado_Empleados FOREIGN KEY (idEmpleado) REFERENCES Empleados (idEmpleado)
);

Create Table Nominas(
idNomina int primary key NOT NULL,
fechaElaboracion date NOT NULL,
fechaPago date NOT NULL,
subtotal float NOT NULL,
retenciones float NOT NULL,
total float NOT NULL,
diasTrabajados int NOT NULL,
estatus char NOT NULL,
idEmpleado int NOT NULL,
idFormaPago int NOT NULL,
idPeriodo int NOT NULL,
Constraint fk_Nominas_FormasPago FOREIGN KEY (idFormaPago) REFERENCES FormasPago (idFormaPago),
Constraint fk_Nominas_Empleados FOREIGN KEY (idEmpleado) REFERENCES Empleados (idEmpleado),
Constraint fk_Nominas_Periodos FOREIGN KEY (idPeriodo) REFERENCES Periodos (idPeriodo)
);

Create Table NominasDeducciones(
idNomina int NOT NULL,
idDeduccion int primary key NOT NULL,
importe float NOT NULL,
Constraint fk_NominasDeducciones_Nominas FOREIGN KEY (idNomina) REFERENCES Nominas (idNomina),
Constraint fk_NominasDeducciones_Deducciones FOREIGN KEY (idDeduccion) REFERENCES Deducciones (idDeduccion)
);

Create Table NominasPercepciones(
idNomina int NOT NULL,
idPercepcion int NOT NULL,
importe float NOT NULL,
estatus char NOT NULL,
Constraint pk_NominasPercepciones PRIMARY KEY (idNomina,idPercepcion),
Constraint fk_NominasPercepciones_Nominas FOREIGN KEY (idNomina) REFERENCES Nominas (idNomina),
Constraint fk_NominasPercepciones_Percepciones FOREIGN KEY (idPercepcion) REFERENCES	Percepciones (idPercepcion)
)
