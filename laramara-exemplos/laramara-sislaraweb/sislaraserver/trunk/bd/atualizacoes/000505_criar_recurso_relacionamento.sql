﻿CREATE TABLE RECURSO_RELACIONAMENTO
(
	ID BIGSERIAL NOT NULL,
	ID_RECURSO BIGINT NOT NULL,
	RELACAO_RECURSO VARCHAR(20) NOT NULL,
	PRIMARY KEY (ID)
) WITHOUT OIDS;

CREATE TABLE USUARIO_RECURSO_RELACIONAMENTO
(
	ID_RECURSO_RELACIONAMENTO BIGINT NOT NULL,
	ID_USUARIO BIGINT NOT NULL
) WITHOUT OIDS;

ALTER TABLE RECURSO_RELACIONAMENTO
	ADD FOREIGN KEY (ID_RECURSO)
	REFERENCES RECURSO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE USUARIO_RECURSO_RELACIONAMENTO
	ADD FOREIGN KEY (ID_RECURSO_RELACIONAMENTO)
	REFERENCES RECURSO_RELACIONAMENTO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE USUARIO_RECURSO_RELACIONAMENTO
	ADD FOREIGN KEY (ID_USUARIO)
	REFERENCES USUARIO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;
