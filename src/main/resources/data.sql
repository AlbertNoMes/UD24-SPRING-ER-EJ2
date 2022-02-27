DROP table IF EXISTS departamentos;
DROP table IF EXISTS empleados;

CREATE TABLE departamentos(
codigo int auto_increment,
nombre nvarchar(100),
presupuesto int,
primary key (codigo)
);

insert into departamentos (nombre)values('DESARROLLO');

CREATE TABLE empleados(
DNI varchar(8),
nombre nvarchar(100),
apellidos nvarchar(200),
departamento int,
primary key (DNI),
foreign key (departamento) references departamentos (codigo)
);

insert into empleados (DNI, nombre, apellidos, departamento)values('11111111', 'ALBERT', 'NOTARIO MESTRES', 1);