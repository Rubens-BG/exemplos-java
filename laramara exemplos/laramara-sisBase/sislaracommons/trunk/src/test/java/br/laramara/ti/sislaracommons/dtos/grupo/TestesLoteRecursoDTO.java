package br.laramara.ti.sislaracommons.dtos.grupo;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.laramara.ti.sislaracommons.utilitarios.TiposDeTeste;

public class TestesLoteRecursoDTO {

	@Test(groups = { TiposDeTeste.UNITARIO })
	public void lote_recursodto_foi_construido_com_sucesso() {
		Long id = new Long(123);
		RecursoDTO recursoDto = new RecursoDTO(id, "Bengala", false, "100,00");
		String quantidade = "15";
		String valor = "2500,00";
		LoteRecursoDTO loteRecursoDto = new LoteRecursoDTO();
		loteRecursoDto.setId(id);
		loteRecursoDto.setRecursoDto(recursoDto);
		loteRecursoDto.setQuantidade(quantidade);
		loteRecursoDto.setValor(valor);

		Assert.assertEquals(loteRecursoDto.getId(), id);
		Assert.assertEquals(loteRecursoDto.getRecursoDto().getId(), id);
		Assert.assertEquals(loteRecursoDto.getQuantidade(), quantidade);
		Assert.assertEquals(loteRecursoDto.getValor(), valor);
	}
}
