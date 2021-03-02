-- Creación de tabla Nominas

use RecursosHumanos

Create Table Nominas
(
idNomina INT not null,
fechaElaboracion DATE not null,
fechaPago DATE not null,
subtotal FLOAT not null,
retenciones FLOAT not null,
total FLOAT not null,
diasTrabajados INT not null,
estatus CHAR not null,
CONSTRAINT pk_idNomina PRIMARY KEY (idNomina),
CONSTRAINT fk_idEmpleado FOREIGN KEY (idEmpleado) REFERENCES Empleados (idEmpleado),
CONSTRAINT fk_FormaPago FOREIGN KEY (idFormaPago) REFERENCES FormasPago (idFormaPago)
)