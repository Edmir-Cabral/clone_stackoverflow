CREATE DATABASE  IF NOT EXISTS `clonestackoverflow`;
USE `clonestackoverflow`;

 

CREATE TABLE `Usuarios` (
    ID int  not null AUTO_INCREMENT,
    GOOGLE_ID int,
    EMAIL VARCHAR(255) NOT NULL,
    NOME VARCHAR(100),
    DATA_CRIACAO TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`ID`)
);


CREATE TABLE `Perguntas`
(
    ID               int  not null AUTO_INCREMENT,
    TITULO_PERGUNTA                  varchar(500) not null,
    DESCRICAO_PERGUNTA       varchar(500) not null,
    DATA_PERGUNTA            TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ID_USUARIO             int not null,
    PRIMARY KEY (`ID`),
    FOREIGN KEY (`ID_USUARIO`) REFERENCES `Usuarios` (`ID`)
);

 

CREATE TABLE `Respostas` 
(
  ID             int  not null AUTO_INCREMENT,
  RESPOSTA             varchar(500) NOT NULL,
  DATA_RESPOSTA             TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  ID_PERGUNTA             int not null,
  ID_USUARIO             int not null,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`ID_USUARIO`) REFERENCES `Usuarios` (`ID`),
  FOREIGN KEY (`ID_PERGUNTA`) REFERENCES `Perguntas` (`ID`)
);