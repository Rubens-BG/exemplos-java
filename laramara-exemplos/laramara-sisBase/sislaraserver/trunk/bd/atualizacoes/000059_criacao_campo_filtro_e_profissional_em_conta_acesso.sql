﻿ALTER TABLE CONTA_ACESSO ADD COLUMN FILTRO_GRUPO BOOLEAN DEFAULT 'false' NOT NULL;
ALTER TABLE CONTA_ACESSO ADD COLUMN ID_PROFISSIONAL BIGINT;
ALTER TABLE CONTA_ACESSO ADD FOREIGN KEY (ID_PROFISSIONAL) REFERENCES PROFISSIONAL (ID)  ON UPDATE RESTRICT ON DELETE RESTRICT;