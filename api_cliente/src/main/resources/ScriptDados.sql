drop database banco;

USE banco;
drop TABLE cliente

create database banco;

GRANT ALL PRIVILEGES ON banco.* TO 'root' @'localhost';

USE banco;

CREATE TABLE cliente(
    id int AUTO_INCREMENT,
    cpf varchar(14) NOT NULL,
    nome varchar(50) NOT NULL,
    sexo varchar(1) NOT NULL,
    nascimento date,
    PRIMARY KEY (id)
)