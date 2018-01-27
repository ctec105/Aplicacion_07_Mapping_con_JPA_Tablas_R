CREATE DATABASE IF NOT EXISTS mysqljpa;
USE mysqljpa;

DROP TABLE IF EXISTS tb_empleado;
DROP TABLE IF EXISTS tb_cargo;
DROP TABLE IF EXISTS tb_casillero;
DROP TABLE IF EXISTS tb_secuencia;
CREATE TABLE tb_secuencia(
  descripcion varchar(10) NOT NULL,
  valor int(10) NOT NULL,
  PRIMARY KEY (descripcion  )
) ;

insert into tb_secuencia values('empleado',0);

CREATE TABLE tb_cargo (
 COD_CAR int(10)  NOT NULL AUTO_INCREMENT,
 DES_CAR varchar(45) DEFAULT NULL,
 PRIMARY KEY (COD_CAR)
) ;

CREATE TABLE tb_casillero (
COD_CAS int(6)  NOT NULL AUTO_INCREMENT,
DES_CAS varchar(4) NOT NULL,
EST_CAS char(1) NOT NULL DEFAULT "V",
PRIMARY KEY (COD_CAS)
) ;

DROP TABLE IF EXISTS tb_empleado;
CREATE TABLE tb_empleado (
  COD_EMP int(10) unsigned NOT NULL AUTO_INCREMENT,
  NOM_EMP varchar(45) NOT NULL,
  APE_EMP varchar(45) NOT NULL,
  EDA_EMP int(10) unsigned NOT NULL,
  ARE_EMP varchar(45) NOT NULL,
  FEC_ING_EMP date NOT NULL,
  COD_CAR int(10) NOT NULL,
  COD_CAS int(10) NOT NULL unique,
  PRIMARY KEY (COD_EMP)
) ;

ALTER TABLE tb_empleado
  ADD CONSTRAINT fk_cargo  FOREIGN KEY (COD_CAR)
  REFERENCES tb_cargo (COD_CAR)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
 ALTER TABLE tb_empleado
  ADD CONSTRAINT fk_casillero  FOREIGN KEY (COD_CAS)
  REFERENCES tb_casillero (COD_CAS)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

INSERT INTO tb_casillero (DES_CAS) VALUES ('A-01');
INSERT INTO tb_casillero (DES_CAS) VALUES ('A-02');
INSERT INTO tb_casillero (DES_CAS) VALUES ('A-03');

INSERT INTO tb_cargo (DES_CAR) VALUES ('SECRETARIA');
INSERT INTO tb_cargo (DES_CAR) VALUES ('RECEPCIONISTA');
INSERT INTO tb_cargo (DES_CAR) VALUES ('GERENTE');
