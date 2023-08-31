CREATE DATABASE  IF NOT EXISTS `clonestackoverflow`;
USE `clonestackoverflow`;

 
CREATE TABLE `Usuarios` (
    GOOGLE_ID VARCHAR(100) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL,
    NOME VARCHAR(100),
    DATA_CRIACAO TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`GOOGLE_ID`)
);

CREATE TABLE `Perguntas`
(
    ID               int  not null AUTO_INCREMENT,
    TITULO_PERGUNTA                  varchar(500) not null,
    DESCRICAO_PERGUNTA       varchar(5000) not null,
    DATA_PERGUNTA            TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    GOOGLE_ID_USUARIO             VARCHAR(100) not null,
    PRIMARY KEY (`ID`),
    FOREIGN KEY (`GOOGLE_ID_USUARIO`) REFERENCES `Usuarios` (`GOOGLE_ID`)
);

CREATE TABLE `Respostas` 
(
  ID             int  not null AUTO_INCREMENT,
  DESCRICAO_RESPOSTA             varchar(5000) NOT NULL,
  DATA_RESPOSTA             TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  ID_PERGUNTA             int not null,
  GOOGLE_ID_USUARIO             VARCHAR(100) not null,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`ID_PERGUNTA`) REFERENCES `Perguntas` (`ID`),
  FOREIGN KEY (`GOOGLE_ID_USUARIO`) REFERENCES `Usuarios` (`GOOGLE_ID`)
);