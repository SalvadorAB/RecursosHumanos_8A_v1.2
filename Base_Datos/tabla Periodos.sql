create table Periodos(
	idPeriodo int not null,
	Nombre varchar (50),
	Fechainicio date,
	Fechafin date,
	Estatus char not null,
	constraint PK_periodos primary key (idPeriodo)
)
go