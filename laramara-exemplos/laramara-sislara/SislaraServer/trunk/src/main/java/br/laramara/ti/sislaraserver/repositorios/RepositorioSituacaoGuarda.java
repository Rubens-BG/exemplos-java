package br.laramara.ti.sislaraserver.repositorios;

import java.util.List;

import br.laramara.ti.sislaraserver.dominio.usuario.SituacaoGuarda;

public interface RepositorioSituacaoGuarda {
	public List<SituacaoGuarda> obterTodos();
}
