﻿CREATE TABLE USUARIO_HISTORICO_INSTITUICAO_OUTROS_AEE
(
	ID_USUARIO BIGINT NOT NULL,
	ID_HISTORICO_INSTITUICAO BIGINT NOT NULL
) WITHOUT OIDS;

ALTER TABLE USUARIO_HISTORICO_INSTITUICAO_OUTROS_AEE
	ADD FOREIGN KEY (ID_HISTORICO_INSTITUICAO)
	REFERENCES HISTORICO_INSTITUICAO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE USUARIO_HISTORICO_INSTITUICAO_OUTROS_AEE
	ADD FOREIGN KEY (ID_USUARIO)
	REFERENCES USUARIO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;