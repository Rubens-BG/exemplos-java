﻿ALTER TABLE MODULO_PRE_CADASTRO DROP COLUMN ORIGEM_COMUNIDADE;

ALTER TABLE MODULO_PRE_CADASTRO ADD COLUMN ID_TIPO_VINCULO BIGINT NOT NULL;

ALTER TABLE MODULO_PRE_CADASTRO
	ADD FOREIGN KEY (ID_TIPO_VINCULO)
	REFERENCES TIPO_VINCULO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

INSERT INTO TIPO_VINCULO(descricao)values('Usuário sem prontuário');
