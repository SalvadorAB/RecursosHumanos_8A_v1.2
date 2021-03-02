--Crear la base de datos
IF EXISTS (
  SELECT * 
    FROM sys.databases 
   WHERE name = N'RecursosHumanos'
)
  DROP DATABASE RecursosHumanos
GO

CREATE DATABASE RecursosHumanos
ON PRIMARY
	(NAME = RecursosHumanos_dat,
	  FILENAME = N'C:\Base_Datos\RecursosHumanos\RecursoHumanos_dat.mdf',
          SIZE = 5MB,
          MAXSIZE = 10MB,
          FILEGROWTH = 2MB),

FILEGROUP RecursosHumanos_FG1
	( NAME = RecursosHumanos_sec1,
	  FILENAME = N'C:\Base_Datos\RecursosHumanos\RecursosHumanos_sec1.ndf',
          SIZE = 5MB,
          MAXSIZE = 10MB,
          FILEGROWTH = 2MB),

FILEGROUP RecursosHumanos_FG2
	( NAME = RecursosHumanos_sec2,
	  FILENAME = N'C:\Base_Datos\RecursosHumanos\RecursosHumanos_sec2.ndf',
          SIZE = 5MB,
          MAXSIZE = 10MB,
          FILEGROWTH = 2MB)

LOG ON
	( NAME = RecursosHumanos_log,
	  FILENAME = N'C:\Base_Datos\RecursosHumanos\RecursosHumanos_log.ldf',
          SIZE = 3MB,
          MAXSIZE = 10MB,
          FILEGROWTH = 2MB)
GO
--Revisar la estructura de la BD
exec sp_helpdb RecursosHumanos
go