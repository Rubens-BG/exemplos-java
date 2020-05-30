﻿ALTER TABLE CONTRIBUINTE ADD COLUMN CONTRIBUICAO DECIMAL DEFAULT 0.00 NOT NULL;

CREATE TABLE HISTORICO_STATUS_CONTRIBUINTE
(
	ID BIGSERIAL NOT NULL,
	DATA_INICIAL_VIGENCIA TIMESTAMP NOT NULL,
	DATA_FINAL_VIGENCIA TIMESTAMP,
	STATUS VARCHAR(25),
	PRIMARY KEY (ID)
) WITHOUT OIDS;
CREATE TABLE CONTRIBUINTE_HISTORICO_STATUS_CONTRIBUINTE
(
	ID_CONTRIBUINTE BIGINT NOT NULL,
	ID_HISTORICO_STATUS_CONTRIBUINTE BIGINT NOT NULL
) WITHOUT OIDS;

ALTER TABLE CONTRIBUINTE_HISTORICO_STATUS_CONTRIBUINTE
	ADD FOREIGN KEY (ID_CONTRIBUINTE)
	REFERENCES CONTRIBUINTE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

CREATE SEQUENCE NOSSO_NUMERO_SEQ INCREMENT 1 START 96755;