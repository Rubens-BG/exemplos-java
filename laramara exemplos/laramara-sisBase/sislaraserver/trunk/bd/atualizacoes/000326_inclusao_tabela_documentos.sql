﻿CREATE TABLE DEMANDA_DOCUMENTO_SOLICITACAO_DOACAO
(
	ID_DOCUMENTO_SOLICITACAO_DOACAO BIGINT NOT NULL,
	ID_DEMANDA BIGINT NOT NULL
) WITHOUT OIDS;

CREATE TABLE DOCUMENTO_SOLICITACAO_DOACAO
(
	ID BIGSERIAL NOT NULL,
	ID_ARQUIVO BIGINT NOT NULL,
	NOME_DOCUMENTO VARCHAR(250) NOT NULL,
	PRIMARY KEY (ID)
) WITHOUT OIDS;

ALTER TABLE DOCUMENTO_SOLICITACAO_DOACAO
	ADD FOREIGN KEY (ID_ARQUIVO)
	REFERENCES ARQUIVO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE DEMANDA_DOCUMENTO_SOLICITACAO_DOACAO
	ADD FOREIGN KEY (ID_DEMANDA)
	REFERENCES DEMANDA (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DEMANDA_DOCUMENTO_SOLICITACAO_DOACAO
	ADD FOREIGN KEY (ID_DOCUMENTO_SOLICITACAO_DOACAO)
	REFERENCES DOCUMENTO_SOLICITACAO_DOACAO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

insert into descricao_tipo_atendimento_modulo(id_descricao_tipo_atendimento, id_modulo) values(60, 105);