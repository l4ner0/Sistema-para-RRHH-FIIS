USE MASTER 
GO
if db_id('sistema_gph') is not null  --CONDICION DE EXISTENCIA
begin
drop database sistema_gph
end
GO
CREATE DATABASE sistema_gph
GO

USE sistema_gph
GO

--DROP DATABASE sistema_rrhh2

--CREACION DE TABLAS
if exists(select name from sysobjects where type='U' and name='Usuarios')    
begin
drop table Usuarios
end
GO
CREATE TABLE Usuarios
(
 nombre varchar (20) not null,
 apellido varchar(20) not null,
 Usuario varchar(20) primary key not null,
 contraseña varchar(10) not null
)
GO


if exists(select name from sysobjects where type='U' and name='areasEmpresa')    
begin
drop table areasEmpresa
end
GO
CREATE TABLE areasEmpresa
(idArea int PRIMARY KEY IDENTITY(1,1),
 nombreArea varchar(20),
 descripcionArea text
)
GO

if exists(select name from sysobjects where type='U' and name='horario')    
begin
drop table horario
end
GO
CREATE TABLE horario 
(
 idHorario int PRIMARY KEY IDENTITY(1,1) NOT NULL,
 turno varchar(7) check (turno IN('Mañana','Tarde')) NOT NULL,
 horaEntrada time NOT NULL,
 horaSalida time NOT NULL,
)
GO

if exists(select name from sysobjects where type='U' and name='retencion')    
begin
drop table retencion
end
GO
CREATE TABLE retencion
(
 idRetencion int PRIMARY KEY IDENTITY(1,1) NOT NULL,
 nombreRetencion varchar(10) NOT NULL,
 aporteObligatorio decimal(2,2) NOT NULL,
 comision  decimal(2,2) NOT NULL,
 primaSeguro decimal(2,2) NOT NULL
)
GO

if exists(select name from sysobjects where type='U' and name='puesto')    
begin
drop table puesto
end
GO
CREATE TABLE puesto 
(
 idPuesto int PRIMARY KEY IDENTITY(1,1),
 nombrePuesto varchar(40) NOT NULL,
 descripcionPuesto text NOT NULL,
 requerimientosPuesto text NOT NULL,
 sueldoBasico decimal(7,2) NOT NULL,
 vacantes int Not null,
 idArea int FOREIGN KEY REFERENCES areasEmpresa(idArea) NOT NULL
 
)
GO

if exists(select name from sysobjects where type='U' and name='HorarioPuesto')    
begin
drop table HorarioPuesto
end
GO

CREATE TABLE HorarioPuesto 
(
 idHoraPuesto int PRIMARY KEY IDENTITY(1,1),
 idPuesto int FOREIGN KEY REFERENCES puesto(idPuesto) NOT NULL,
 idHorario int FOREIGN KEY REFERENCES horario(idHorario) NOT NULL
)
GO

if exists(select name from sysobjects where type='U' and name='empleado')    
begin
drop table empleado
end
GO
CREATE TABLE empleado 
(
 idEmpleado char(13) PRIMARY KEY NOT NULL,
 fotoEmpleado varchar(200) NOT NULL,
 nombres varchar(20) NOT NULL,
 apellidoPaterno varchar(20) NOT NULL,
 apellidoMaterno varchar(20) NOT NULL,
 sexo varchar(10) check (sexo IN ('Masculino','Femenino')) NOT NULL,
 DNI char(8) CONSTRAINT AK_DNI UNIQUE(DNI) NOT NULL,
 fechaNacimiento date NOT NULL,
 DistritoResidencia varchar(15) NOT NULL,
 direccion varchar(40) NOT NULL,
 telefono char(9) check (telefono like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')unique NULL,
 correoElectronico varchar(100) unique NULL,
 asignacionFamiliar varchar(2) check (asignacionFamiliar IN ('Si','No')) NOT NULL,
 idArea int FOREIGN KEY REFERENCES areasEmpresa(idArea) NOT NULL,
 idPuesto int FOREIGN KEY REFERENCES puesto(idPuesto) NOT NULL,
 idRetencion int FOREIGN KEY REFERENCES retencion(idRetencion) NOT NULL
)
GO

if exists(select name from sysobjects where type='U' and name='asistencia')    
begin
drop table asistencia
end
GO
CREATE TABLE asistencia
(
 idAsistencia int primary key NOT NULL,
 fechaAsistencia date NOT NULL,
 horaEntrada time NOT NULL,
 horaSalida time NOT NULL,
 idEmpleado char(13) FOREIGN KEY REFERENCES empleado(idEmpleado) NOT NULL,
 idHorario int FOREIGN KEY REFERENCES horario(idHorario) NOT NULL
)
GO

--LLENADO PARA PRUEBAS

--Usuario
insert into Usuarios Values('july','torres','Stich','sabe')

--areas
INSERT INTO areasEmpresa VALUES('MARKETING','Se encarga de realizar las investigación en el mercado, determinar
cuál será el siguiente producto o mantenimiento de producto para llegar a una negociación en el mercado, asi como
posicionar en el mercado y presentarse al mismo por medio de la publicidad')
INSERT INTO areasEmpresa VALUES('SISTEMAS','Se encarga de proveer la información, así como de las herramientas 
necesarias para manipularla, es capaz de convertir simples datos en información, satisfacer necesidades y preparación
computacional a toda la empresa. Responsable de ofrecer soluciones informáticas.')
GO

--horario
INSERT INTO horario VALUES('MAÑANA','8:00','4:00')
INSERT INTO horario VALUES('TARDE','14:00','22:00')
GO

--retencion
INSERT INTO retencion VALUES('SNP/ONP',0.13,0,0)
INSERT INTO retencion VALUES('PRIMA',0.15,0.02,0.03)
INSERT INTO retencion VALUES('HORIZONTE',0.16,0.02,0.03)
INSERT INTO retencion VALUES('INTEGRA',0.17,0.02,0.03)
INSERT INTO retencion VALUES('PROFUTURO',0.18,0.02,0.03)
GO

--puesto
Declare @CodArea int
Select @CodArea= (Select idArea From areasEmpresa Where nombreArea='MARKETING')
Insert puesto Values('Analista de Publicidad','Ejecutar la plataforma de comunicación de los productos corporativos.
					Desarrollar piezas adecuadas en cada medio. Identificar medios masivos directos y efectivos para comunicar 
					nuestra oferta. Monitorear acciones de la competencia en los segmentos residencial y corporativos.','1. Formación universitaria completa en Marketing, Publicidad, Comunicación o Administración.'+
                       '2. Experiencia en comunicación masiva de productos corporativos.',1200,2,@CodArea)
GO
Declare @CodArea int
Select @CodArea= (Select idArea From areasEmpresa Where nombreArea='SISTEMAS')
Insert puesto Values('Analista programador','Ejecutar la plataforma de comunicación de los productos corporativos.
					Desarrollar piezas adecuadas en cada medio. Identificar medios masivos directos y efectivos para comunicar 
					nuestra oferta. Monitorear acciones de la competencia en los segmentos residencial y corporativos.',
					'1. Conocimientos en diagramación de sistemas UML. 2. Lenguaje de consulta de bases de datos SQL
					3. Conocimiento real de al menos un lenguaje de programación. 4. Técnicas de calidad de software.',1400,2,@CodArea)


--HorarioPuesto
Insert HorarioPuesto Values('1','1')
Insert HorarioPuesto Values('1','2')
Insert HorarioPuesto Values('2','2')

--empleado
INSERT INTO empleado VALUES('E001','rutaFoto','July','Torres','Chavez','Femenino','48433198','04/01/1994','Rimac','Jr. Corregidores 147','980775464',
							'july.tc19@gmail.com','Si',1,1,4)
INSERT INTO empleado VALUES('E002','rutaFoto','Carlos','Montero','Rosas','Masculino','48533198','09/08/1994','Los olivos','Jr. olivares 123','984652904',
							'carlos.oli@gmail.com','No',2,2,3)

select*from empleado


--asistencia
--INSERT INTO asistencia VALUES()

/*PROCEDIMIENTOS ALMACENDADOS*/
--areas-----------------------------------------------------------------------------------------------------------------------
create proc  usp_mostrar_areas
as
begin
     select * from areasEmpresa
end
go

create proc usp_graba_areas
@NOM VARCHAR(20), @DES text
AS
begin
INSERT INTO areasEmpresa VALUES(@NOM,@DES)
end
go
--EJECUTANDO P.A.
EXEC usp_graba_areas 'RECURSOS HUMANOS','Se encarga de la planificacion, reclutamiennto, seleccion y contratacion del personal'
SELECT*FROM areasEmpresa

create proc usp_modifica_areas
@idArea int, @NOM VARCHAR(20), @DES text
AS
begin
	update areasEmpresa set nombreArea=@nom, descripcionArea=@DES
	where idArea=@idArea
end
go

create proc usp_elimina_areas
@idArea int
as
begin
	delete from areasEmpresa where idArea=@idArea
end
go

CREATE PROC usp_buscar_idArea
@nombreArea VARCHAR(20)
AS
BEGIN
	select idArea from areasEmpresa where nombreArea=@nombreArea
END
go


--horario----------------------------------------------------------------------------------------------------------------------
create proc usp_graba_horario
@TURNO VARCHAR(7), @HORAEN TIME,@HORASA TIME
AS
begin
INSERT INTO horario VALUES(@TURNO,@HORAEN,@HORASA);
end
GO

CREATE PROC usp_mostrar_horarios 
AS
BEGIN
	select * from horario 
	
END
go

CREATE PROC usp_verifica_horario
@idEmpleado VARCHAR(13)
AS
BEGIN
	select * from horario where idHorario = (select idHorario from HorarioPuesto where idPuesto =(select idPuesto from empleado where idEmpleado=@idEmpleado))
END 
GO	
	

--puesto-----------------------------------------------------------------------------------------------------------------------
create proc usp_graba_puesto
@NOMPUESTO VARCHAR(40), @DESPUESTO TEXT,@REQUEPUESTO TEXT,
@SUELDO DECIMAL(7,2), @VACAN INT, @IdAREA INT 
AS
begin
INSERT INTO puesto VALUES(@NOMPUESTO,@DESPUESTO,@REQUEPUESTO,@SUELDO,@VACAN,@IdAREA);
end
GO

CREATE PROC usp_buscar_idPuesto
@nombrePuesto VARCHAR(40)
AS
BEGIN
	select idPuesto from puesto where nombrePuesto=@nombrePuesto
END
GO

CREATE PROC usp_mostrar_puestos
AS
BEGIN
	select * from puesto
END
GO

CREATE PROC usp_mostrar_puestos2
@nombreArea VARCHAR(20)
AS
BEGIN
	select nombrePuesto from puesto where idArea=(select idArea from areasEmpresa where nombreArea=@nombreArea)
END
GO

create proc usu_sueldtotal
@idempleado char(13)
as 
begin
select sueldoBasico from puesto where idPuesto=(select idPuesto from empleado where idEmpleado=@idempleado)
end

--HorarioPuesto----------------------------------------------------------------------------------------------------------------
CREATE PROC usp_graba_HorarioPuesto
@IdPUESTO INT, @IdHORARIO INT
AS
begin
INSERT INTO HorarioPuesto VALUES(@IdPUESTO,@IdHORARIO);
end
GO

CREATE PROC usp_mostrar_horarioP
AS
BEGIN
	select * from HorarioPuesto
	
END
go

CREATE PROC usp_eliminar_horarioPuesto
@idHoraPuesto int
AS
BEGIN
 delete from HorarioPuesto where idHoraPuesto=@idHoraPuesto
 END
 GO

--EJECUTANDO P.A.
EXEC usp_graba_HorarioPuesto '2','1'
SELECT*FROM HorarioPuesto

--Empleado---------------------------------------------------------------------------------------------------------------------
create proc usp_mostrar_empleados
as
begin
     select * from empleado
end
go

create proc usp_graba_empleado
@IdEMPLE CHAR(13),@fotoEmpleado VARCHAR(200), @NOMEMPLE VARCHAR(20), @APEPATERNO VARCHAR(20),
@APEMATERNO VARCHAR(20), @SEXO VARCHAR(10), @DNI CHAR(8),
@FECHANACI VARCHAR(100), @DISTRITO VARCHAR(15), @DIREC VARCHAR(40),
@TELEF CHAR(9),@CORREO VARCHAR(100), @ASIGFAMILI VARCHAR(2),
@IdAREA INT, @IdPUESTO INT, @IdRETENCION INT
AS
begin 
	INSERT INTO empleado VALUES(@IdEMPLE,@fotoEMPLEADO,@NOMEMPLE,@APEPATERNO,@APEMATERNO,
	@SEXO,@DNI,@FECHANACI,@DISTRITO,@DIREC,@TELEF,@CORREO,@ASIGFAMILI,@IdAREA,@IdPUESTO,@IdRETENCION);
end
go

create proc usp_modifica_empleado
@IdEMPLE CHAR(13),@fotoEmpleado VARCHAR(200), @NOMEMPLE VARCHAR(20), @APEPATERNO VARCHAR(20),
@APEMATERNO VARCHAR(20), @SEXO VARCHAR(10), 
@FECHANACI DATE, @DISTRITO VARCHAR(15), @DIREC VARCHAR(40),
@TELEF CHAR(9),@CORREO VARCHAR(100), @ASIGFAMILI VARCHAR(2)
AS
begin
	update empleado set fotoEmpleado=@fotoEmpleado,nombres=@NOMEMPLE,apellidoPaterno=@APEPATERNO,apellidoMaterno=@APEMATERNO,
			sexo=@SEXO,fechaNacimiento=@FECHANACI,DistritoResidencia= @DISTRITO,direccion=@DIREC,telefono=@TELEF,
			correoElectronico=@CORREO,asignacionFamiliar=@ASIGFAMILI 
			where idEmpleado=@IdEMPLE
end 
go

create proc usp_elimina_empleado
@IdEMPLE char(13)
as
begin
	delete from empleado where idEmpleado=@IdEMPLE
end
GO

CREATE PROC usp_buscar_empleado
@idEmpleado CHAR(13)
AS
BEGIN
	select idEmpleado,fotoEmpleado,nombres,apellidoPaterno,apellidoMaterno,sexo,DNI,fechaNacimiento,
	DistritoResidencia,direccion,telefono,correoElectronico,asignacionFamiliar,(select nombreArea from areasEmpresa where idArea=(select idArea from empleado where idEmpleado=@idEmpleado)),
	(select nombrePuesto from puesto where idPuesto=(select idPuesto from empleado where idEmpleado=@idEmpleado)),idRetencion from empleado where idEmpleado=@idEmpleado
END
GO

--Asistencia-------------------------------------------------------------------------------------------------------------------
CREATE PROC usp_graba_asistencia
@IdASISTENCIA INT, @FECHA DATE, @HORAENTRA TIME, @HORASALE TIME,
@IdEMPLE CHAR(8),@IdHORARIO INT
AS
begin
INSERT INTO asistencia VALUES(@IdASISTENCIA,@FECHA,@HORAENTRA,@HORASALE,@IdEMPLE,@IdHORARIO);
end
GO


/*VISTAS*/

/*create view listadoEmpleado
as
select  idEmpleado,nombres,apellidoPaterno,apellidoMaterno,sexo,DNI,DistritoResidencia,direccion,telefono,
		correoElectronico,asignacionFamiliar,nombreArea,nombrePuesto,nombreRetencion
        from empleado e inner join areasEmpresa a
		 on e.idArea=a.idArea inner join puesto p
		 on e.idPuesto=p.idPuesto inner join retencion r
		 on e.idRetencion=r.idRetencion

create view horariosDeEmpleado
as
select idEmpleado,nombres + ' '+ apellidoPaterno +' '+ apellidoMaterno as nombre,nombrePuesto,turno,HoraEntrada,horaSalida
		from empleado e inner join puesto p 
		on e.idPuesto=p.idPuesto inner join HorarioPuesto HP
		on P.idPuesto=HP.idHoraPuesto inner join horario h
		on hp.idHorario=h.idHorario

*/

