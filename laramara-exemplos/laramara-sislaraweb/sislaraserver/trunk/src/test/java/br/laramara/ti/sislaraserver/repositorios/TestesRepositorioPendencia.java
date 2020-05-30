package br.laramara.ti.sislaraserver.repositorios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.laramara.ti.sislaracommons.utilitarios.TiposDeTeste;
import br.laramara.ti.sislaraserver.TestesIntegracaoAbstrato;
import br.laramara.ti.sislaraserver.dominio.grupo.Profissional;
import br.laramara.ti.sislaraserver.dominio.pendencia.Pendencia;
import br.laramara.ti.sislaraserver.dominio.pendencia.PendenciaEnvioListaEsperaPorExcessoDeFaltas;
import br.laramara.ti.sislaraserver.dominio.pendencia.TipoPendencia;
import br.laramara.ti.sislaraserver.utilitarios.Registro;

public class TestesRepositorioPendencia extends TestesIntegracaoAbstrato {

	public TestesRepositorioPendencia() {
		super("DadosTestesRepositorioPendencia.xml");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void repositorio_pendencia_pesquisa_todas_nao_resolvidas() {
		RepositorioPendencia repositorio = Registro.obterRepositorioPendencia();

		List<Pendencia> pendenciaObtidas = repositorio
				.obterTodasNaoResolvidas(Arrays.asList(TipoPendencia.ENVIO_LISTA_ESPERA_EXCESSO_DE_FALTAS));
		
		Assert.assertEquals(pendenciaObtidas.size(), 2);
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void repositorio_pendencia_pesquisa_todas_por_profissional() {
		RepositorioPendencia repositorio = Registro.obterRepositorioPendencia();

		List<Pendencia> pendenciaObtidas = repositorio
				.obterPendenciasComDataPassadaOuNulaPor(new Profissional(new Long(1000), "", ""));
		
		Assert.assertEquals(pendenciaObtidas.size(), 2);
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void repositorio_pedencia_inclui_e_obtem_pendencia_com_sucesso() {
		RepositorioPendencia repositorio = Registro.obterRepositorioPendencia();

		List<Profissional> profissionais = new ArrayList<>();
		profissionais.add(new Profissional(new Long(1000), "", ""));
		Pendencia pendencia = new PendenciaEnvioListaEsperaPorExcessoDeFaltas(new Long(12222), profissionais);

		repositorio.salvar(pendencia);

		List<? extends Pendencia> pendenciaObtidas = repositorio
				.obterTodasNaoResolvidas(Arrays.asList(TipoPendencia.ENVIO_LISTA_ESPERA_EXCESSO_DE_FALTAS));

		Assert.assertEquals(pendenciaObtidas.size(), 3);
	}
}
