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
    endereco_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (endereco_id) REFERENCES endereco (id)
)


USE banco;

CREATE TABLE endereco(
    id int AUTO_INCREMENT,
    cep varchar(9) NOT NULL,
    rua varchar(50) NOT NULL,
    bairro varchar(50) NOT NULL,
    numero int NOT NULL,
    cidade varchar(50) NOT NULL,
    uf varchar(4) NOT NULL,
    PRIMARY KEY (id)
)