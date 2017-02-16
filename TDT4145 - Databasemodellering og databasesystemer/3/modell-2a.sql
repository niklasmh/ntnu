CREATE SCHEMA IF NOT EXISTS mydb;
USE mydb;

CREATE TABLE IF NOT EXISTS mydb.poststed (
  postnr                CHAR(4)             NOT NULL,
  poststed              VARCHAR(45)         NULL,
  PRIMARY KEY (postnr)
)

CREATE TABLE IF NOT EXISTS mydb.kunde (
  idkunde              INT           NOT NULL AUTO_INCREMENT,
  navn                 VARCHAR(45)   NULL,
  kredittgrense        INT           NULL,
  poststed_postnr      INT           NOT NULL,
  PRIMARY KEY (idkunde)
  FOREIGN KEY (poststed_postnr) REFERENCES mydb.poststed (postnr)
)

CREATE TABLE IF NOT EXISTS mydb.artikkel (
  artnr                INT           NOT NULL AUTO_INCREMENT,
  navn                 VARCHAR(45)   NULL,
  ant                  INT           NULL,
  pris                 DECIMAL(10,2) NULL,
  PRIMARY KEY (artnr),
  UNIQUE (navn)
)

CREATE TABLE IF NOT EXISTS mydb.bestilling (
  kvantum              INT           NULL,
  kunde_idkunde        INT           NOT NULL,
  artikkel_artnr       INT           NOT NULL,
  PRIMARY KEY (kunde_idkunde, artikkel_artnr)
  FOREIGN KEY (kunde_idkunde) REFERENCES mydb.kunde (idkunde)
  FOREIGN KEY (artikkel_artnr) REFERENCES mydb.artikkel (artnr)
)
