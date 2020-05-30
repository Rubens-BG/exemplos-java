﻿CREATE TABLE HISTORICO_STATUS_RETIRADA
(
	ID BIGSERIAL NOT NULL,
	ID_CONTA_ACESSO BIGINT NOT NULL,
	DATA_INICIAL_VIGENCIA TIMESTAMP NOT NULL,
	DATA_FINAL_VIGENCIA TIMESTAMP,
	STATUS VARCHAR(25) NOT NULL,
	PRIMARY KEY (ID)
) WITHOUT OIDS;

CREATE TABLE RETIRADA
(
	ID BIGSERIAL NOT NULL,
	PRONTUARIO BIGINT NOT NULL,
	ID_PROFISSIONAL BIGINT NOT NULL,
	ID_VOLUNTARIO BIGINT,
	PRIMARY KEY (ID)
) WITHOUT OIDS;

CREATE TABLE RETIRADA_HISTORICO_STATUS_RETIRADA
(
	ID_RETIRADA BIGINT NOT NULL,
	ID_HISTORICO_STATUS_RETIRADA BIGINT NOT NULL
) WITHOUT OIDS;

ALTER TABLE HISTORICO_STATUS_RETIRADA
	ADD FOREIGN KEY (ID_CONTA_ACESSO)
	REFERENCES CONTA_ACESSO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE RETIRADA_HISTORICO_STATUS_RETIRADA
	ADD FOREIGN KEY (ID_HISTORICO_STATUS_RETIRADA)
	REFERENCES HISTORICO_STATUS_RETIRADA (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE RETIRADA
	ADD FOREIGN KEY (ID_VOLUNTARIO)
	REFERENCES PROFISSIONAL (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE RETIRADA
	ADD FOREIGN KEY (ID_PROFISSIONAL)
	REFERENCES PROFISSIONAL (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE RETIRADA_HISTORICO_STATUS_RETIRADA
	ADD FOREIGN KEY (ID_RETIRADA)
	REFERENCES RETIRADA (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;