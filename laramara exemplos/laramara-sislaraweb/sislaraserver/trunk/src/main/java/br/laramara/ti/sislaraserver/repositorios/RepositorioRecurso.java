package br.laramara.ti.sislaraserver.repositorios;

import java.util.List;

import br.laramara.ti.sislaraserver.dominio.grupo.Recurso;

public interface RepositorioRecurso {
	public List<Recurso> obterTodos();
	public List<Recurso> obterDisponivelParaDemanda();
	public Recurso obterPorId(Long id);
}