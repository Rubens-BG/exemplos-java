﻿ALTER TABLE MODULO_PRE_CADASTRO ADD COLUMN ID_USUARIO_VINCULADO BIGINT;
	
ALTER TABLE MODULO_PRE_CADASTRO
	ADD FOREIGN KEY (ID_USUARIO_VINCULADO)
	REFERENCES USUARIO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;
