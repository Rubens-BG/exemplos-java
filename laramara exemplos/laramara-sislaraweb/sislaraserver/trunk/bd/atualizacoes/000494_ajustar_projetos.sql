﻿ALTER TABLE projeto ALTER COLUMN DATA_INICIAL_VIGENCIA TYPE DATE;
ALTER TABLE projeto ALTER COLUMN DATA_INICIAL_VIGENCIA SET NOT NULL;
ALTER TABLE projeto DROP COLUMN DATA_FINAL_VIGENCIA;

