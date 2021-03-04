create table Percepciones(
	idPercepcion int not null,
	Nombre varchar (30),
	Descripcion varchar(80),
	DiasPagar int not null,
	constraint PK_Percepciones primary key (idPercepcion)
)
go