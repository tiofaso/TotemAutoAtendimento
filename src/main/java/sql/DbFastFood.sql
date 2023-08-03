CREATE DATABASE fastfood;

CREATE TABLE tb_lanche(id SERIAL PRIMARY KEY, nomelanche varchar(15),
ingredientelanche varchar (100), valor decimal);

CREATE TABLE tb_bebida(id SERIAL PRIMARY KEY, nomebebida varchar(15),
valor decimal);

CREATE TABLE tb_pedido(id SERIAL PRIMARY KEY, numpedido varchar(10),
tipopagamento varchar(10),troco decimal, valorconta decimal);

CREATE TABLE tb_carrinho(id SERIAL PRIMARY KEY, numpedido varchar(10),
tipopedido SERIAL, nomepedido varchar(15), escolhapedido int, quantidadepedido int,
valorpedido decimal, estadopedido boolean);

ALTER TABLE tb_carrinho
ADD CONSTRAINT fk_bebida
FOREIGN KEY (tipopedido)
REFERENCES tb_bebida(id);

ALTER TABLE tb_carrinho
ADD CONSTRAINT fk_lanche
FOREIGN KEY (tipopedido)
REFERENCES tb_lanche(id);