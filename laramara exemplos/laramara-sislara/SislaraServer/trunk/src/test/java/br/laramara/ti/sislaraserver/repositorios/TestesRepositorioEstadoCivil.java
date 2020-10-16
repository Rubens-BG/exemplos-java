package br.laramara.ti.sislaraserver.repositorios;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.laramara.ti.sislaracommons.utilitarios.TiposDeTeste;
import br.laramara.ti.sislaraserver.TestesIntegracaoAbstrato;
import br.laramara.ti.sislaraserver.dominio.usuario.EstadoCivil;
import br.laramara.ti.sislaraserver.utilitarios.Registro;

public class TestesRepositorioEstadoCivil extends TestesIntegracaoAbstrato {
	
	public TestesRepositorioEstadoCivil(){
		super("DadosTestesRepositorioEstadoCivil.xml");
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void repositorio_estado_civil_pesquisa_todos() {
		RepositorioEstadoCivil repositorio = Registro
				.obterRepositorioEstadoCivil();

		List<EstadoCivil> estadoCivilObtidas = repositorio.obterTodos();

		Assert.assertEquals(estadoCivilObtidas.size(), 2);
	}
}
