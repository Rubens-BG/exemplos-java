
/* Drop Tables */

DROP TABLE IF EXISTS MOVIMENTACAO_HISTORICO_STATUS;
DROP TABLE IF EXISTS HISTORICO_STATUS;
DROP TABLE IF EXISTS CONTA_ACESSO;
DROP TABLE IF EXISTS MOVIMENTACAO;
DROP TABLE IF EXISTS PERFIL_PERMISSOES;
DROP TABLE IF EXISTS PERFIL;
DROP TABLE IF EXISTS PROFISSIONAL;




/* Create Tables */

CREATE TABLE CONTA_ACESSO
(
	ID BIGSERIAL NOT NULL,
	ID_PERFIL BIGINT NOT NULL,
	LOGIN VARCHAR(100) NOT NULL,
	SENHA VARCHAR(100) NOT NULL,
	BLOQUEADO BOOLEAN NOT NULL,
	EXTENSAO_RELATORIOS VARCHAR(3) NOT NULL,
	FILTRO_GRUPO BOOLEAN DEFAULT 'false' NOT NULL,
	ID_PROFISSIONAL BIGINT,
	TOKEN VARCHAR(36),
	PALAVRA_CHAVE_GRUPO VARCHAR(20000),
	CONSTRAINT conta_acesso_pkey PRIMARY KEY (ID)
) WITHOUT OIDS;


CREATE TABLE HISTORICO_STATUS
(
	ID BIGSERIAL NOT NULL,
	DATA_INICIAL_VIGENCIA TIMESTAMP NOT NULL,
	DATA_FINAL_VIGENCIA TIMESTAMP,
	STATUS VARCHAR(100) NOT NULL,
	ID_CONTA_ACESSO BIGINT NOT NULL,
	PRIMARY KEY (ID)
) WITHOUT OIDS;


CREATE TABLE MOVIMENTACAO
(
	ID BIGSERIAL NOT NULL,
	GL VARCHAR(50),
	CLIENTE VARCHAR(200),
	CODIGO_PRODUTO VARCHAR(50),
	DESCRICAO VARCHAR(200),
	DESCRICAO_PRODUTO VARCHAR(200),
	QUANTIDADE_COR VARCHAR(50),
	COR VARCHAR(100),
	FIBRA VARCHAR(50),
	DIRECAO_FIBRA VARCHAR(50),
	FORMATO VARCHAR(50),
	CODIGO_ANTERIOR VARCHAR(100),
	GRAMATURA VARCHAR(50),
	PAPEL VARCHAR(50),
	LAETUS VARCHAR(50),
	SANGRIA VARCHAR(3),
	ABDB VARCHAR(2),
	ESPECIFICACAO VARCHAR(3),
	OBS_ESPECIFICACAO VARCHAR(1000),
	OBS_ARTE VARCHAR(1000),
	GR VARCHAR(50),
	PASTA VARCHAR(50),
	BOBINA VARCHAR(50),
	PLANA_PAPEL VARCHAR(50),
	TIPO_PROVA VARCHAR(50),
	PRIMARY KEY (ID)
) WITHOUT OIDS;


CREATE TABLE MOVIMENTACAO_HISTORICO_STATUS
(
	ID_MOVIMENTACAO BIGINT NOT NULL,
	ID_HISTORICO_STATUS BIGINT NOT NULL
) WITHOUT OIDS;


CREATE TABLE PERFIL
(
	ID BIGSERIAL NOT NULL,
	DESCRICAO VARCHAR(100),
	CONSTRAINT perfil_pkey PRIMARY KEY (ID)
) WITHOUT OIDS;


CREATE TABLE PERFIL_PERMISSOES
(
	ID_PERFIL BIGINT NOT NULL,
	PERMISSAO VARCHAR(100)
) WITHOUT OIDS;


CREATE TABLE PROFISSIONAL
(
	ID BIGSERIAL NOT NULL,
	CHAPA VARCHAR(10),
	NOME VARCHAR(100) NOT NULL,
	HABILITADO BOOLEAN DEFAULT 'true' NOT NULL,
	VOLUNTARIO BOOLEAN DEFAULT 'false' NOT NULL,
	PROFISSIONAL BOOLEAN DEFAULT 'false' NOT NULL,
	PRIMARY KEY (ID)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE HISTORICO_STATUS
	ADD FOREIGN KEY (ID_CONTA_ACESSO)
	REFERENCES CONTA_ACESSO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE MOVIMENTACAO_HISTORICO_STATUS
	ADD FOREIGN KEY (ID_HISTORICO_STATUS)
	REFERENCES HISTORICO_STATUS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE MOVIMENTACAO_HISTORICO_STATUS
	ADD FOREIGN KEY (ID_MOVIMENTACAO)
	REFERENCES MOVIMENTACAO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE CONTA_ACESSO
	ADD FOREIGN KEY (ID_PERFIL)
	REFERENCES PERFIL (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE PERFIL_PERMISSOES
	ADD FOREIGN KEY (ID_PERFIL)
	REFERENCES PERFIL (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE CONTA_ACESSO
	ADD FOREIGN KEY (ID_PROFISSIONAL)
	REFERENCES PROFISSIONAL (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



