create database mercadodonajoana;

use mercadodonajoana;

/** Criando Tabelas **/

CREATE TABLE clientes(
id INT(11) not null auto_increment,
nome varchar(50) NOT NULL,
telefone varchar(11) NOT NULL,
email varchar(50) NOT NULL,
endereco varchar(50) NOT NULL,
PRIMARY KEY (id));


CREATE TABLE fornecedores(
id INT(11) not null auto_increment,
nome varchar(50) NOT NULL,
telefone varchar(11) NOT NULL,
endereco varchar(50) NOT NULL,
PRIMARY KEY (id));

CREATE TABLE categorias(
id INT(11) not null auto_increment,
nome varchar(50) NOT NULL,
PRIMARY KEY (id));

CREATE TABLE produtos(
id INT(11) not null auto_increment,
nome varchar(50) NOT NULL,
codBarras varchar(11) NOT NULL,
valor decimal(10,2) NOT NULL,
quantidade integer(11) NOT NULL,
fk_categoria int NOT NULL,
fk_fornecedor int NOT NULL,
PRIMARY KEY (id),
foreign key(fk_categoria) references categorias(id),
foreign key(fk_fornecedor) references fornecedores(id));

CREATE TABLE tipoUsuario(
id INT(11) not null auto_increment,
nome varchar(50) NOT NULL,
PRIMARY KEY (id));

CREATE TABLE funcionarios(
id INT(11) not null auto_increment,
nome varchar(50) NOT NULL,
pis INT(11) NOT NULL,
salario decimal(10,2) NOT NULL,
endereco varchar(50) NOT NULL,
telefone varchar(11) NOT NULL,
email varchar(50) NOT NULL,
senha varchar(25) NOT NULL,
fk_tipoUsuario int NOT NULL,
fk_fornecedor int NOT NULL,
PRIMARY KEY (id),
foreign key(fk_tipoUsuario) references tipoUsuario(id));


CREATE TABLE vendas(
id INT(11) not null auto_increment,
fk_cliente int,
fk_funcionario int NOT NULL,
dataVenda datetime NOT NULL,
PRIMARY KEY (id),
foreign key(fk_cliente) references clientes(id),
foreign key(fk_funcionario) references funcionarios(id));


CREATE TABLE receitas(
id INT(11) not null auto_increment,
dataCadastro datetime NOT NULL,
dataPagamento datetime NOT NULL,
dataVencimento date NOT NULL,
valorTotal decimal(10,2) NOT NULL,
valorRecebido decimal(10,2) NOT NULL,
codVenda int(9),
PRIMARY KEY (id));

CREATE TABLE tipoDespesa(
id INT(11) not null auto_increment,
nome varchar(50) NOT NULL,
PRIMARY KEY (id));

CREATE TABLE despesas(
id INT(11) not null auto_increment,
dataCadastro datetime NOT NULL,
dataPagamento datetime NOT NULL,
dataVencimento date NOT NULL,
valorPago decimal(10,2) NOT NULL,
codEntrada int(9),
fk_tipoDespesa int,
PRIMARY KEY (id),
foreign key(fk_tipoDespesa) references tipoDespesa(id));


select * from categorias;

select * from produtos;

select * from fornecedores;