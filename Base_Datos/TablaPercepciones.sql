-- Creación de tabla Percepciones

use RecursosHumanos

Create Table Percepciones
(
idPercepcion INT not null,
nombre VARCHAR(60) not null,
descripcion VARCHAR (60) not null,
CONSTRAINT pk_idPercepcion PRIMARY KEY (idPercepcion),
)