ALTER TABLE acao_conduta ADD COLUMN ID_SETOR VARCHAR(10);
ALTER TABLE acao_conduta ADD COLUMN DATA_EXPECTATIVA DATE;

ALTER TABLE ACAO_CONDUTA
	ADD FOREIGN KEY (ID_SETOR)
	REFERENCES SETOR (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;