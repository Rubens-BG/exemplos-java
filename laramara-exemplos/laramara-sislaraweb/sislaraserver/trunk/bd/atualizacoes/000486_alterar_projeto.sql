﻿CREATE TABLE PROJETO_RECURSO_DISPONIVEL
(
	ID_PROJETO BIGINT NOT NULL,
	ID_RECURSO_DISPONIVEL BIGINT NOT NULL
) WITHOUT OIDS;

CREATE TABLE RECURSO_DISPONIVEL
(
	ID BIGSERIAL NOT NULL,
	ID_RECURSO BIGINT NOT NULL,
	VALOR_UNITARIO DECIMAL NOT NULL,
	QUANTIDADE INT NOT NULL,
	PRIMARY KEY (ID)
) WITHOUT OIDS;


ALTER TABLE PROJETO_RECURSO_DISPONIVEL
	ADD FOREIGN KEY (ID_PROJETO)
	REFERENCES PROJETO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE RECURSO_DISPONIVEL
	ADD FOREIGN KEY (ID_RECURSO)
	REFERENCES RECURSO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE PROJETO_RECURSO_DISPONIVEL
	ADD FOREIGN KEY (ID_RECURSO_DISPONIVEL)
	REFERENCES RECURSO_DISPONIVEL (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE PROJETO ADD COLUMN IDADE_MINIMA INT;
ALTER TABLE PROJETO ADD COLUMN IDADE_MAXIMA INT;
