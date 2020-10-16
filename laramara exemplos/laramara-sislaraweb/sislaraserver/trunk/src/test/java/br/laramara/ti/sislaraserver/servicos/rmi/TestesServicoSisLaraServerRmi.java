package br.laramara.ti.sislaraserver.servicos.rmi;

import java.io.File;
import java.nio.charset.Charset;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import br.laramara.ti.sislaracommons.Identificavel;
import br.laramara.ti.sislaracommons.dtos.ArquivoDTO;
import br.laramara.ti.sislaracommons.dtos.ChavePesquisaDTO;
import br.laramara.ti.sislaracommons.dtos.HorarioDTO;
import br.laramara.ti.sislaracommons.dtos.InformacaoEssencialDTO;
import br.laramara.ti.sislaracommons.dtos.ResultadoAlteracaoSenhaDTO;
import br.laramara.ti.sislaracommons.dtos.ResultadoListagemArquivoDisponivelDTO;
import br.laramara.ti.sislaracommons.dtos.ResultadoListagemSimNaoDTO;
import br.laramara.ti.sislaracommons.dtos.ResultadoListagemTipoTelefoneDTO;
import br.laramara.ti.sislaracommons.dtos.ResultadoValidacaoTelefoneDTO;
import br.laramara.ti.sislaracommons.dtos.SimNaoDTO;
import br.laramara.ti.sislaracommons.dtos.TelefoneDTO;
import br.laramara.ti.sislaracommons.dtos.TipoTelefoneDTO;
import br.laramara.ti.sislaracommons.dtos.agenda.AgendamentoDTO;
import br.laramara.ti.sislaracommons.dtos.agenda.EspecificacaoAssociacaoAgendamentoDTO;
import br.laramara.ti.sislaracommons.dtos.agenda.EspecificacaoGeracaoAgendamentoDTO;
import br.laramara.ti.sislaracommons.dtos.agenda.EspecificacaoGeracaoCopiaAgendamentoDTO;
import br.laramara.ti.sislaracommons.dtos.agenda.EspecificacaoPesquisaAgendamentoDTO;
import br.laramara.ti.sislaracommons.dtos.agenda.MotivoCancelamentoDTO;
import br.laramara.ti.sislaracommons.dtos.agenda.ResultadoEdicaoAgendamentoDTO;
import br.laramara.ti.sislaracommons.dtos.agenda.ResultadoGeracaoAgendamentoDTO;
import br.laramara.ti.sislaracommons.dtos.agenda.ResultadoListagemAgendamentoDTO;
import br.laramara.ti.sislaracommons.dtos.agenda.ResultadoListagemMotivoCancelamentoDTO;
import br.laramara.ti.sislaracommons.dtos.agenda.ResultadoListagemStatusAgendamentoDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.AcaoCondutaDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.AtendimentoComunidadeDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.AtendimentoGrupoDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.AtendimentoIndividualDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.AtendimentoPreCadastroDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.AtendimentoProfissionalDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.AtendimentoUsuarioDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.EspecificacaoCopiaAtendimentoIndividualDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.EspecificacaoPesquisaAtendimentoIndividualDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.OpcaoIntegracaoDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.ParticipacaoDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.ParticipacaoDetalhadaDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.ResultadoEdicaoAtendimentoIndividualDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.ResultadoListagemAtendimentoIndividualDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.ResultadoListagemOpcaoIntegracaoDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.ResultadoListagemParticipacaoDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.ResultadoListagemTipoAcaoCondutaDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.ResultadoListagemTipoVinculoDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.ResultadoValidacaoAcaoCondutaDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.ResultadoValidacaoParticipacaoDetalhadaDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.StatusAtendimentoDTO;
import br.laramara.ti.sislaracommons.dtos.atendimento.TipoAcaoCondutaDTO;
import br.laramara.ti.sislaracommons.dtos.contribuicao.ContribuinteDTO;
import br.laramara.ti.sislaracommons.dtos.contribuicao.EspecificacaoPesquisaContribuinteDTO;
import br.laramara.ti.sislaracommons.dtos.contribuicao.ResultadoEdicaoContribuinteDTO;
import br.laramara.ti.sislaracommons.dtos.contribuicao.ResultadoEdicaoReciboDTO;
import br.laramara.ti.sislaracommons.dtos.contribuicao.ResultadoListagemContribuinteDTO;
import br.laramara.ti.sislaracommons.dtos.contribuicao.ResultadoListagemMotivoDesativacaoDTO;
import br.laramara.ti.sislaracommons.dtos.contribuicao.ResultadoListagemStatusContribuinteDTO;
import br.laramara.ti.sislaracommons.dtos.contribuicao.StatusContribuinteDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.DemandaDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.DocumentoSolicitacaoDoacaoDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.EspecificacaoCaptacaoDemandaDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.EspecificacaoGeracaoDemandaDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.EspecificacaoPesquisaDemandaDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.EspecificacaoPesquisaProjetoDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.EspecificacaoPesquisaReciboDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.NomeDocumentoDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.PatrocinioDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.ProjetoDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.ReciboDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.RecursoDisponivelDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.ResultadoCaptacaoCartelaDeSelosDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.ResultadoEdicaoDemandaDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.ResultadoEdicaoProjetoDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.ResultadoGeracaoDemandaDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.ResultadoListagemDemandaDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.ResultadoListagemEmpresaDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.ResultadoListagemFilialDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.ResultadoListagemNomeDocumentoDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.ResultadoListagemPrestacaoContaDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.ResultadoListagemProjetoDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.ResultadoListagemReciboDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.ResultadoListagemStatusDemandaDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.ResultadoProrrogacaoCartelaDeSelosDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.ResultadoReciboDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.ResultadoValidacaoRecursoDisponivelDTO;
import br.laramara.ti.sislaracommons.dtos.doacao.StatusDemandaDTO;
import br.laramara.ti.sislaracommons.dtos.endereco.EnderecoCEPDTO;
import br.laramara.ti.sislaracommons.dtos.endereco.EnderecoDTO;
import br.laramara.ti.sislaracommons.dtos.endereco.MunicipioDTO;
import br.laramara.ti.sislaracommons.dtos.endereco.PaisDTO;
import br.laramara.ti.sislaracommons.dtos.endereco.ResultadoConsultaCEP;
import br.laramara.ti.sislaracommons.dtos.endereco.UfDTO;
import br.laramara.ti.sislaracommons.dtos.endereco.ZonaDTO;
import br.laramara.ti.sislaracommons.dtos.escola.InformacaoEducacionalDTO;
import br.laramara.ti.sislaracommons.dtos.escola.ResultadoListagemAreaFormacaoDTO;
import br.laramara.ti.sislaracommons.dtos.escola.ResultadoListagemDiretoriaEnsinoDTO;
import br.laramara.ti.sislaracommons.dtos.escola.ResultadoListagemDreCefaiDTO;
import br.laramara.ti.sislaracommons.dtos.escola.ResultadoListagemEscolaridadeDTO;
import br.laramara.ti.sislaracommons.dtos.escola.ResultadoListagemPeriodoDTO;
import br.laramara.ti.sislaracommons.dtos.escola.ResultadoListagemSituacaoDTO;
import br.laramara.ti.sislaracommons.dtos.escola.ResultadoListagemTipoApoioDTO;
import br.laramara.ti.sislaracommons.dtos.escola.ResultadoListagemTipoEspecialidadeDTO;
import br.laramara.ti.sislaracommons.dtos.escola.ResultadoValidacaoInformacaoEducacionalDTO;
import br.laramara.ti.sislaracommons.dtos.espera.EspecificacaoPesquisaEsperaDTO;
import br.laramara.ti.sislaracommons.dtos.espera.EsperaDTO;
import br.laramara.ti.sislaracommons.dtos.espera.ResultadoEdicaoEsperaDTO;
import br.laramara.ti.sislaracommons.dtos.espera.ResultadoListagemEsperaDTO;
import br.laramara.ti.sislaracommons.dtos.espera.ResultadoListagemStatusEsperaDTO;
import br.laramara.ti.sislaracommons.dtos.espera.ResultadoListagemTipoEsperaDTO;
import br.laramara.ti.sislaracommons.dtos.espera.StatusEsperaDTO;
import br.laramara.ti.sislaracommons.dtos.espera.TipoEsperaDTO;
import br.laramara.ti.sislaracommons.dtos.evento.DescricaoEventoDTO;
import br.laramara.ti.sislaracommons.dtos.evento.ResultadoListagemTipoDescricaoEventoDTO;
import br.laramara.ti.sislaracommons.dtos.evento.ResultadoValidacaoDescricaoEventoDTO;
import br.laramara.ti.sislaracommons.dtos.familiar.FamiliarDTO;
import br.laramara.ti.sislaracommons.dtos.familiar.ResultadoListagemParentescoDTO;
import br.laramara.ti.sislaracommons.dtos.familiar.ResultadoValidacaoFamiliarDTO;
import br.laramara.ti.sislaracommons.dtos.familiar.ResultadoValidacaoPatrocinioDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.DescricaoTipoAtendimentoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.DiaSemanaDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.DiaSemanaEHorarioDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.EspecificacaoGeracaoAtendimentoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.EspecificacaoPesquisaGrupoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.FrequenciaDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.GrupoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.LoteRecursoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ModuloDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ModuloPeriodoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ModuloPreCadastroDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ModuloUsuarioDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.NomeGrupoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ProfissionalDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ProgramacaoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ResultadoEdicaoAtendimentoGrupoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ResultadoEdicaoGrupoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ResultadoEdicaoModuloPeriodoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ResultadoGeracaoAtendimentoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ResultadoListagemDiaSemanaDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ResultadoListagemFrequenciaDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ResultadoListagemGrupoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ResultadoListagemLocalAtendimentoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ResultadoListagemNomeCompletoGrupoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ResultadoListagemProfissionalDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ResultadoListagemRecursoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ResultadoListagemStatusRelacaoUsuarioModuloDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ResultadoListagemTipoAtendimentoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ResultadoValidacaoAtendimentoBaseDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ResultadoValidacaoDiaSemanaEHorarioDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ResultadoValidacaoLoteRecursoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ResultadoValidacaoModuloPeriodoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ResultadoValidacaoModuloRelacaoBaseDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.ResultadoValidacaoProgramacaoDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.StatusRelacaoComModuloDTO;
import br.laramara.ti.sislaracommons.dtos.grupo.TipoAtendimentoDTO;
import br.laramara.ti.sislaracommons.dtos.instituicao.EspecificacaoPesquisaInstituicaoDTO;
import br.laramara.ti.sislaracommons.dtos.instituicao.InstituicaoDTO;
import br.laramara.ti.sislaracommons.dtos.instituicao.ResultadoEdicaoInstituicaoDTO;
import br.laramara.ti.sislaracommons.dtos.instituicao.ResultadoListagemClassificacaoInstituicaoDTO;
import br.laramara.ti.sislaracommons.dtos.instituicao.ResultadoListagemInstituicaoDTO;
import br.laramara.ti.sislaracommons.dtos.instituicao.ResultadoListagemTipoInstituicaoDTO;
import br.laramara.ti.sislaracommons.dtos.pendencia.PendenciaDTO;
import br.laramara.ti.sislaracommons.dtos.pendencia.ResultadoListagemPendenciaDTO;
import br.laramara.ti.sislaracommons.dtos.precadastro.EspecificacaoPesquisaPreCadastroDTO;
import br.laramara.ti.sislaracommons.dtos.precadastro.PreCadastroDTO;
import br.laramara.ti.sislaracommons.dtos.precadastro.ResultadoEdicaoPreCadastroDTO;
import br.laramara.ti.sislaracommons.dtos.precadastro.ResultadoListagemPreCadastroDTO;
import br.laramara.ti.sislaracommons.dtos.retirada.ResultadoEdicaoRetiradaDTO;
import br.laramara.ti.sislaracommons.dtos.retirada.RetiradaDTO;
import br.laramara.ti.sislaracommons.dtos.seguranca.ContaAcessoDTO;
import br.laramara.ti.sislaracommons.dtos.seguranca.CredencialDTO;
import br.laramara.ti.sislaracommons.dtos.seguranca.EspecificacaoPesquisaContaAcessoDTO;
import br.laramara.ti.sislaracommons.dtos.seguranca.EspecificacaoPesquisaPerfilDTO;
import br.laramara.ti.sislaracommons.dtos.seguranca.GeralContaAcessoBloqueadoDTO;
import br.laramara.ti.sislaracommons.dtos.seguranca.PerfilDTO;
import br.laramara.ti.sislaracommons.dtos.seguranca.ResultadoAlteracaoExtensaoRelatorioDTO;
import br.laramara.ti.sislaracommons.dtos.seguranca.ResultadoAutenticacaoDTO;
import br.laramara.ti.sislaracommons.dtos.seguranca.ResultadoCoordenacaoEdicaoDTO;
import br.laramara.ti.sislaracommons.dtos.seguranca.ResultadoEdicaoContaAcessoDTO;
import br.laramara.ti.sislaracommons.dtos.seguranca.ResultadoEdicaoPerfilDTO;
import br.laramara.ti.sislaracommons.dtos.seguranca.ResultadoListagemContaAcessoDTO;
import br.laramara.ti.sislaracommons.dtos.seguranca.ResultadoListagemGeralBloqueadosDTO;
import br.laramara.ti.sislaracommons.dtos.seguranca.ResultadoListagemPerfilDTO;
import br.laramara.ti.sislaracommons.dtos.seguranca.ResultadoListagemPermissaoDTO;
import br.laramara.ti.sislaracommons.dtos.seguranca.ResultadoOperacaoFiltroGrupoDTO;
import br.laramara.ti.sislaracommons.dtos.seguranca.TokenDTO;
import br.laramara.ti.sislaracommons.dtos.solicitacao.ElaboradorDTO;
import br.laramara.ti.sislaracommons.dtos.solicitacao.EspecificacaoPesquisaSolicitacaoRelatorioDTO;
import br.laramara.ti.sislaracommons.dtos.solicitacao.FinalidadeRelatorioDTO;
import br.laramara.ti.sislaracommons.dtos.solicitacao.ResultadoEdicaoSolicitacaoRelatorioDTO;
import br.laramara.ti.sislaracommons.dtos.solicitacao.ResultadoListagemElaboradorDTO;
import br.laramara.ti.sislaracommons.dtos.solicitacao.ResultadoListagemFinalidadeRelatorioDTO;
import br.laramara.ti.sislaracommons.dtos.solicitacao.ResultadoListagemSolicitacaoRelatorioDTO;
import br.laramara.ti.sislaracommons.dtos.solicitacao.ResultadoListagemStatusSolicitacaoRelatorioDTO;
import br.laramara.ti.sislaracommons.dtos.solicitacao.SolicitacaoRelatorioDTO;
import br.laramara.ti.sislaracommons.dtos.solicitacao.StatusSolicitacaoRelatorioDTO;
import br.laramara.ti.sislaracommons.dtos.trabalho.InformacaoTrabalhoCompletaDTO;
import br.laramara.ti.sislaracommons.dtos.trabalho.ResultadoListagemCargoDTO;
import br.laramara.ti.sislaracommons.dtos.trabalho.ResultadoListagemLocalTrabalhoDTO;
import br.laramara.ti.sislaracommons.dtos.trabalho.ResultadoValidacaoInformacaoTrabalhoCompletaDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.CertidaoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.CustoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.EspecificacaoPesquisaUsuarioDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.OrigemEncaminhamentoDetalhadoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.PeriodoBeneficioDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.PeriodoComprometimentoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.PeriodoDeficienciaDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.PeriodoDoencaDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ProntuarioEscaneadoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.RecursoRelacionamentoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoConsultaCidDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoEdicaoUsuarioDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemBeneficioDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemClassificacaoSocialDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemComprometimentoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemCondicaoMoradiaDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemConvenioDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemDeficienciaDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemDoencaDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemEpocaIncidenciaDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemEstadoCivilDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemExpectativaDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemGeneroDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemGrupoEtnicoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemHabitacaoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemInfraestruturaBasicaDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemItensCustoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemMunicipioDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemNecessidadeDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemOrigemEncaminhamentoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemPaisDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemProntuarioEscaneadoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemRecursoMoradiaDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemRelacaoRecursoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemServicoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemSetorDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemSituacaoGuardaDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemSituacaoHabitacionalDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemStatusBeneficioDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemStatusDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemTipoCertidaoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemTipoConstrucaoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemTipoLeituraDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemUfDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemUsuarioDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemVulnerabilidadeDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoListagemZonaDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoValidacaoCertidaoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoValidacaoCustoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoValidacaoEncaminhamentoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoValidacaoPeriodoBeneficioDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoValidacaoPeriodoComprometimentoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoValidacaoPeriodoDeficienciaDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoValidacaoPeriodoDoencaDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.ResultadoValidacaoRecursoRelacionamentoDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.SetorDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.StatusDTO;
import br.laramara.ti.sislaracommons.dtos.usuario.UsuarioDTO;
import br.laramara.ti.sislaracommons.servicos.ServicoSisLaraServer;
import br.laramara.ti.sislaracommons.utilitarios.DataHoraUtils;
import br.laramara.ti.sislaracommons.utilitarios.MaquinaTempo;
import br.laramara.ti.sislaracommons.utilitarios.TiposDeTeste;
import br.laramara.ti.sislaraserver.TestesIntegracaoAbstrato;
import br.laramara.ti.sislaraserver.dominio.SimNao;
import br.laramara.ti.sislaraserver.dominio.TipoArquivoDisponivel;
import br.laramara.ti.sislaraserver.dominio.atendimento.OpcaoIntegracao;
import br.laramara.ti.sislaraserver.dominio.atendimento.Participacao;
import br.laramara.ti.sislaraserver.dominio.atendimento.TipoAcaoConduta;
import br.laramara.ti.sislaraserver.dominio.contribuicao.AutomatizadorContribuicao;
import br.laramara.ti.sislaraserver.dominio.doacao.NomeDocumento;
import br.laramara.ti.sislaraserver.dominio.doacao.StatusDemanda;
import br.laramara.ti.sislaraserver.dominio.endereco.UF;
import br.laramara.ti.sislaraserver.dominio.endereco.Zona;
import br.laramara.ti.sislaraserver.dominio.espera.StatusEspera;
import br.laramara.ti.sislaraserver.dominio.espera.TipoEspera;
import br.laramara.ti.sislaraserver.dominio.grupo.Frequencia;
import br.laramara.ti.sislaraserver.dominio.grupo.StatusRelacaoComModulo;
import br.laramara.ti.sislaraserver.dominio.solicitacao.StatusSolicitacaoRelatorio;
import br.laramara.ti.sislaraserver.dominio.usuario.Setor;
import br.laramara.ti.sislaraserver.dominio.usuario.Status;
import br.laramara.ti.sislaraserver.fabricas.ContextoAcaoConduta;
import br.laramara.ti.sislaraserver.fabricas.ContextoArquivo;
import br.laramara.ti.sislaraserver.fabricas.ContextoAtendimentoIndividual;
import br.laramara.ti.sislaraserver.fabricas.ContextoAtendimentoPreCadastro;
import br.laramara.ti.sislaraserver.fabricas.ContextoAtendimentoProfissional;
import br.laramara.ti.sislaraserver.fabricas.ContextoAtendimentoUsuario;
import br.laramara.ti.sislaraserver.fabricas.ContextoCertidao;
import br.laramara.ti.sislaraserver.fabricas.ContextoContribuinte;
import br.laramara.ti.sislaraserver.fabricas.ContextoCusto;
import br.laramara.ti.sislaraserver.fabricas.ContextoDescricaoEvento;
import br.laramara.ti.sislaraserver.fabricas.ContextoDescricaoTipoAtendimento;
import br.laramara.ti.sislaraserver.fabricas.ContextoDiasSemanaEHorarios;
import br.laramara.ti.sislaraserver.fabricas.ContextoEspecificacaoGeracaoAgendamento;
import br.laramara.ti.sislaraserver.fabricas.ContextoEspecificacaoGeracaoCopiaAgendamento;
import br.laramara.ti.sislaraserver.fabricas.ContextoEspecificacaoGeracaoDemanda;
import br.laramara.ti.sislaraserver.fabricas.ContextoEspecificacaoPesquidaDemanda;
import br.laramara.ti.sislaraserver.fabricas.ContextoEspecificacaoPesquisaEspera;
import br.laramara.ti.sislaraserver.fabricas.ContextoEspera;
import br.laramara.ti.sislaraserver.fabricas.ContextoFamiliar;
import br.laramara.ti.sislaraserver.fabricas.ContextoGenerico;
import br.laramara.ti.sislaraserver.fabricas.ContextoGrupo;
import br.laramara.ti.sislaraserver.fabricas.ContextoInformacaoAtendimento;
import br.laramara.ti.sislaraserver.fabricas.ContextoInformacaoEducacional;
import br.laramara.ti.sislaraserver.fabricas.ContextoInformacaoTrabalhoCompleta;
import br.laramara.ti.sislaraserver.fabricas.ContextoInstituicao;
import br.laramara.ti.sislaraserver.fabricas.ContextoLocalAtendimento;
import br.laramara.ti.sislaraserver.fabricas.ContextoLoteRecurso;
import br.laramara.ti.sislaraserver.fabricas.ContextoModulo;
import br.laramara.ti.sislaraserver.fabricas.ContextoModuloPeriodo;
import br.laramara.ti.sislaraserver.fabricas.ContextoModuloPreCadastro;
import br.laramara.ti.sislaraserver.fabricas.ContextoModuloUsuario;
import br.laramara.ti.sislaraserver.fabricas.ContextoMotivoCancelamento;
import br.laramara.ti.sislaraserver.fabricas.ContextoOrigemEncaminhamentoDetalhado;
import br.laramara.ti.sislaraserver.fabricas.ContextoParticipacaoDetalhada;
import br.laramara.ti.sislaraserver.fabricas.ContextoPatrocinio;
import br.laramara.ti.sislaraserver.fabricas.ContextoPeriodoBeneficio;
import br.laramara.ti.sislaraserver.fabricas.ContextoPeriodoComprometimento;
import br.laramara.ti.sislaraserver.fabricas.ContextoPeriodoDeficiencia;
import br.laramara.ti.sislaraserver.fabricas.ContextoPeriodoDoenca;
import br.laramara.ti.sislaraserver.fabricas.ContextoPreCadastro;
import br.laramara.ti.sislaraserver.fabricas.ContextoProfissional;
import br.laramara.ti.sislaraserver.fabricas.ContextoProgramacao;
import br.laramara.ti.sislaraserver.fabricas.ContextoProjeto;
import br.laramara.ti.sislaraserver.fabricas.ContextoRecibo;
import br.laramara.ti.sislaraserver.fabricas.ContextoRecurso;
import br.laramara.ti.sislaraserver.fabricas.ContextoRecursoDescricaoRecurso;
import br.laramara.ti.sislaraserver.fabricas.ContextoRecursoDisponivel;
import br.laramara.ti.sislaraserver.fabricas.ContextoRecursoRelacionamento;
import br.laramara.ti.sislaraserver.fabricas.ContextoSolicitacaoRelatorio;
import br.laramara.ti.sislaraserver.fabricas.ContextoTelefone;
import br.laramara.ti.sislaraserver.fabricas.ContextoTipoVinculo;
import br.laramara.ti.sislaraserver.fabricas.ContextoUsuario;
import br.laramara.ti.sislaraserver.fabricas.FabricaGrupo;
import br.laramara.ti.sislaraserver.repositorios.RepositorioSislara;
import br.laramara.ti.sislaraserver.utilitarios.Configuracao;
import br.laramara.ti.sislaraserver.utilitarios.Registro;
import br.laramara.ti.sislaraserver.utilitarios.tarefas.AutomatizadorTarefas;

public class TestesServicoSisLaraServerRmi extends TestesIntegracaoAbstrato {

	private ServicoSisLaraServer servicoSisLaraServerRmi;

	public TestesServicoSisLaraServerRmi() {
		super("DadosTestesServicoSisLaraServerRmi.xml");
		servicoSisLaraServerRmi = Registro.obterServicoSisLaraServer();
		Registro.obterAutomatizadorTarefas().desativarAtualizacaoPendencias();
	}

	private Identificavel obterDaRelacaoPorId(List<? extends Identificavel> objetosDto, Long id) {
		for (Identificavel identificavel : objetosDto) {
			if (identificavel.getId().equals(id)) {
				return identificavel;
			}
		}
		return null;
	}

	private Identificavel obterDaRelacaoPorId(List<ModuloUsuarioDTO> objetosDto, List<Long> ids) {
		for (Identificavel identificavel : objetosDto) {
			for (Long id : ids) {
				if (((ModuloUsuarioDTO) identificavel).getUsuarioDto().getId().equals(id)) {
					return identificavel;
				}
			}
		}
		return null;
	}

	private ModuloPeriodoDTO obterModuloPeriodoDto(List<GrupoDTO> gruposDto, Long idGrupo, Long idModuloPeriodo) {
		GrupoDTO grupoDTO = (GrupoDTO) obterDaRelacaoPorId(gruposDto, idGrupo);
		ModuloPeriodoDTO moduloPeriodoDTO = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoDTO.getModulosPeriodosDto(),
				idModuloPeriodo);
		return moduloPeriodoDTO;
	}

	private void alterarParticipacaoDetalhada(AtendimentoGrupoDTO atendimentoGrupoDto) {
		atendimentoGrupoDto.getAtendimentosUsuariosDto()
				.forEach(atendimentoUsuarioDTO -> atendimentoUsuarioDTO.getInformacaoAtendimentoDto()
						.setParticipadaoDetalhadaDto(
								Arrays.asList(ContextoParticipacaoDetalhada.contruirParticipacaoDetalhadaDto())));
	}
	
	private AtendimentoUsuarioDTO obterAtendimentoDoUsuarioPeloProntuario(
			List<AtendimentoUsuarioDTO> atendimentosUsuariosDto, Long prontuario) {
		for (AtendimentoUsuarioDTO atendimentoUsuarioDTO : atendimentosUsuariosDto) {
			if (atendimentoUsuarioDTO.getUsuarioDto().getId().equals(prontuario)) {
				return atendimentoUsuarioDTO;
			}
		}
		return null;
	}

	private ModuloPreCadastroDTO obterAtendimentoDoUsuarioPeloPreCadastro(
			List<ModuloPreCadastroDTO> modulosPreCadastroDto, Long idPreCadastro) {
		for (ModuloPreCadastroDTO moduloPreCadastroDto : modulosPreCadastroDto) {
			if (moduloPreCadastroDto.getPreCadastroDto().getId().equals(idPreCadastro)) {
				return moduloPreCadastroDto;
			}
		}
		return null;
	}

	private AtendimentoGrupoDTO obterAtendimentoGrupoDto(List<GrupoDTO> gruposDto, Long idGrupo, Long idModuloPeriodo,
			Long idAtendimentoGrupo) {
		ModuloPeriodoDTO moduloPeriodoDTO = obterModuloPeriodoDto(gruposDto, idGrupo, idModuloPeriodo);
		AtendimentoGrupoDTO atendimentoGrupoDTO = (AtendimentoGrupoDTO) obterDaRelacaoPorId(
				moduloPeriodoDTO.getAtendimentosGrupoDto(), idAtendimentoGrupo);
		return atendimentoGrupoDTO;
	}

	private ModuloUsuarioDTO obterPeloIdUsuario(ModuloPeriodoDTO moduloPeriodo, UsuarioDTO usuarioDto) {
		for (ModuloUsuarioDTO moduloUsuario : moduloPeriodo.getModulosUsuariosDto()) {
			if (moduloUsuario.getUsuarioDto().equals(usuarioDto)) {
				return moduloUsuario;
			}
		}
		return null;
	}

	private AcaoCondutaDTO obterAcaoCondutaDTO(UsuarioDTO usuarioDTO, String data) throws RemoteException {
		EspecificacaoPesquisaAtendimentoIndividualDTO especificacaoPesquisaAtendimentoIndividualDTO = new EspecificacaoPesquisaAtendimentoIndividualDTO();
		especificacaoPesquisaAtendimentoIndividualDTO.setProntuario(usuarioDTO.getId().toString());
		
		ResultadoListagemAtendimentoIndividualDTO resultadoListagemAtendimentoIndividualADto = servicoSisLaraServerRmi
				.obterListagemAtendimentoIndividual(especificacaoPesquisaAtendimentoIndividualDTO);
		AtendimentoIndividualDTO atendimentoIndividualADto = obterPelaData(
				resultadoListagemAtendimentoIndividualADto.getObjetosDto(), data);
		return atendimentoIndividualADto.getAcoesDeCondutasDto().get(0);
	}
	
	private AtendimentoIndividualDTO obterPelaData(List<AtendimentoIndividualDTO> atendimentoIndiviuaisDto,
			String data) {
		return atendimentoIndiviuaisDto.stream()
				.filter(atendimentoIndividual -> atendimentoIndividual.getData().equals(data)).findFirst().orElse(null);
	}
	
	private ResultadoEdicaoAtendimentoGrupoDTO gerar_atendimento_de_grupo_com_frequencia_fu(
			ResultadoAutenticacaoDTO resultadoDto, String nomeGrupo, Long idGrupo, Long idModuloPeriodo,
			String dataLancamento, Long prontuario) throws RemoteException {
		ResultadoListagemGrupoDTO resultadoListagemGrupoSS = servicoSisLaraServerRmi.obterListagemGrupoAtivo(nomeGrupo);
		GrupoDTO grupoDTOSS = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupoSS.getObjetosDto(), idGrupo);
		EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentosDTO = new EspecificacaoGeracaoAtendimentoDTO(
				obterDaRelacaoPorId(grupoDTOSS.getModulosPeriodosDto(), idModuloPeriodo).getId(),
				dataLancamento, new HorarioDTO("22:22", "23:00"));
		ResultadoGeracaoAtendimentoDTO resultadoGeracaoAtendimento = servicoSisLaraServerRmi
				.gerarAtendimentos(especificacaoGeracaoAtendimentosDTO, resultadoDto.getToken());
		alterarParticipacaoDetalhada((AtendimentoGrupoDTO)resultadoGeracaoAtendimento.obterObjetoDtoEditado());
		AtendimentoUsuarioDTO atendimentoUsuarioDTO = obterAtendimentoDoUsuarioPeloProntuario(
				((AtendimentoGrupoDTO)resultadoGeracaoAtendimento.obterObjetoDtoEditado()).getAtendimentosUsuariosDto(), prontuario);
		atendimentoUsuarioDTO.getInformacaoAtendimentoDto().setFrequenciaDto(new FrequenciaDTO("FU"));
		atendimentoUsuarioDTO.getInformacaoAtendimentoDto().setParticipadaoDetalhadaDto(Arrays.asList());
		ModuloPeriodoDTO moduloPeriodoDTO = new ModuloPeriodoDTO();
		moduloPeriodoDTO.setId(idModuloPeriodo);
		return servicoSisLaraServerRmi.editarAtendimentoGrupo(moduloPeriodoDTO,
				((AtendimentoGrupoDTO)resultadoGeracaoAtendimento.obterObjetoDtoEditado()), resultadoDto.getToken());
	}

	private void servico_cria_tres_atendimentos_individuais_com_frequencia_fu_em_dias_diferentes(
			ResultadoAutenticacaoDTO resultadoDto, Long prontuario) throws RemoteException {
		servico_cria_tres_atendimentos_individuais_com_frequencia_fu_em_dias_diferentes_adicionando_profissional(
				resultadoDto, prontuario, null);
	}

	private ResultadoEdicaoAtendimentoGrupoDTO gerarEEditarAtendimento(EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentoDTO,
			TokenDTO tokenDto) throws RemoteException {
		ResultadoGeracaoAtendimentoDTO resultadoGeracaoAtendimentoGrupoDTO = servicoSisLaraServerRmi
				.gerarAtendimentos(especificacaoGeracaoAtendimentoDTO, tokenDto);
		AtendimentoGrupoDTO atendimentoGrupoDto = (AtendimentoGrupoDTO) resultadoGeracaoAtendimentoGrupoDTO
				.obterObjetoDtoEditado();
		alterarParticipacaoDetalhada(atendimentoGrupoDto);
		ModuloPeriodoDTO moduloPeriodoDTO = new ModuloPeriodoDTO();
		moduloPeriodoDTO.setId(especificacaoGeracaoAtendimentoDTO.getIdModuloPeriodoDto());
		return servicoSisLaraServerRmi.editarAtendimentoGrupo(moduloPeriodoDTO, atendimentoGrupoDto, tokenDto);
	}
	
	private void servico_cria_tres_atendimentos_individuais_com_frequencia_fu_em_dias_diferentes_adicionando_profissional(
			ResultadoAutenticacaoDTO resultadoDto, Long prontuario,
			AtendimentoProfissionalDTO atendimentoProfissionalDTO) throws RemoteException {
		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setId(null);
		atendimentoIndividualDto.getUsuarioDto().setId(prontuario);
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("12:00", "13:00"));
		atendimentoIndividualDto.getInformacaoAtendimentoDto().setFrequenciaDto(new FrequenciaDTO("FU"));
		atendimentoIndividualDto.getInformacaoAtendimentoDto().setParticipadaoDetalhadaDto(Arrays.asList());
		if (atendimentoProfissionalDTO != null) {
			atendimentoIndividualDto.getAtendimentosProfissionalDto().add(atendimentoProfissionalDTO);
		}
		for (int i = 1; i <= 3; i++) {
			atendimentoIndividualDto.setData("0" + i + "/03/2017");
			servicoSisLaraServerRmi.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());
		}
	}

	private void servico_gera_tres_atendimentos_de_grupo_com_datas_diferentes_e_altera_a_frenquencia_do_prontuario_para_fu(
			GrupoDTO grupoDto, Long idModuloPeriodo, ResultadoAutenticacaoDTO resultadoDto, Long prontuario)
			throws RemoteException {
		for (int i = 1; i <= 3; i++) {
			String dada = "0" + i + "/03/2017";
			ResultadoGeracaoAtendimentoDTO resultadoGeracaoAtendimentoDTO = servicoSisLaraServerRmi
					.gerarAtendimentos(new EspecificacaoGeracaoAtendimentoDTO(
							obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(), new Long(idModuloPeriodo)).getId(),
							dada, new HorarioDTO("09:00", "19:00")), resultadoDto.getToken());
			AtendimentoGrupoDTO atendimentoGrupoDTO = (AtendimentoGrupoDTO) resultadoGeracaoAtendimentoDTO
					.obterObjetoDtoEditado();
			alterarParticipacaoDetalhada(atendimentoGrupoDTO);
			AtendimentoUsuarioDTO atendimentoUsuarioDto = obterAtendimentoDoUsuarioPeloProntuario(atendimentoGrupoDTO.getAtendimentosUsuariosDto(), prontuario);
			atendimentoUsuarioDto.getInformacaoAtendimentoDto().setFrequenciaDto(new FrequenciaDTO("FU"));
			atendimentoUsuarioDto.getInformacaoAtendimentoDto().setParticipadaoDetalhadaDto(Arrays.asList());
			ModuloPeriodoDTO moduloPeriodoDTO = new ModuloPeriodoDTO();
			moduloPeriodoDTO.setId(idModuloPeriodo);
			servicoSisLaraServerRmi.editarAtendimentoGrupo(moduloPeriodoDTO, atendimentoGrupoDTO, resultadoDto.getToken());
		}
	}

	private void criar_espera_e_agendamento_e_efetuar_associacao_entre_os_dois(ResultadoAutenticacaoDTO resultadoDto)
			throws RemoteException {
		EspecificacaoGeracaoAgendamentoDTO especificacaoGeracaoAgendamentoDTO = ContextoEspecificacaoGeracaoAgendamento
				.fabricarAgendamentoUnicoComTodosOsDados();
		especificacaoGeracaoAgendamentoDTO.setUsuarioDto(null);
		especificacaoGeracaoAgendamentoDTO.setDataInicio(DataHoraUtils.formatarData(MaquinaTempo.obterInstancia().obterCalendarioAtual()));

		ResultadoGeracaoAgendamentoDTO resultadoGeracaoAgendamento = servicoSisLaraServerRmi
				.gerarAgendamento(especificacaoGeracaoAgendamentoDTO, resultadoDto.getToken());
		AgendamentoDTO agendamentoDto = resultadoGeracaoAgendamento.getObjetosDto().get(0);

		EsperaDTO esperaDto = ContextoEspera.construirEsperaDTO();
		esperaDto.setPreCadastroDto(null);
		esperaDto.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacao());

		ResultadoEdicaoEsperaDTO resultadoInclusaoEspera = servicoSisLaraServerRmi.editarEspera(esperaDto,
				resultadoDto.getToken());

		EsperaDTO esperaDTOIncluida = (EsperaDTO) resultadoInclusaoEspera.obterObjetoDtoEditado();

		EspecificacaoAssociacaoAgendamentoDTO especificacaoAssociacaoAgendamentoDTO = new EspecificacaoAssociacaoAgendamentoDTO();
		especificacaoAssociacaoAgendamentoDTO.setAgendamentoDto(agendamentoDto);
		especificacaoAssociacaoAgendamentoDTO.setEsperaDto(esperaDTOIncluida);
		servicoSisLaraServerRmi.editarEsperaEAssociarAgendamento(especificacaoAssociacaoAgendamentoDTO,
				resultadoDto.getToken());
	}

	private ModuloUsuarioDTO servico_atualiza_status_de_usuario_e_inclui_em_grupo_com_modulo_de_reuniao_de_integracao_com_sucesso(
			ResultadoAutenticacaoDTO resultadoAutenticacaoDTO, StatusRelacaoComModulo statusUsuario, String nomeGrupoSolicitante, Long idGrupoSolicitante,
			Long idModuloPeriodoSolicitante, Long idModuloUsuarioSolicitante, String nomeGrupoDeReuniaoIntegracao,
			Long idGrupoComModuloReuniaoIntegracao, Long idModuloPeriodoReuniaoIntegracao, Long idUsuario)
			throws RemoteException {
		servico_altera_relacao_de_modulo_usuario_e_retornar_usuario_refenciado(resultadoAutenticacaoDTO,
				servicoSisLaraServerRmi.obterListagemGrupoAtivo(nomeGrupoSolicitante), statusUsuario,
				idGrupoSolicitante, idModuloPeriodoSolicitante, idModuloUsuarioSolicitante);
		Registro.obterAutomatizadorPendencia().atualizarPendencias();

		GrupoDTO grupoComModuloReuniaoIntegracao = (GrupoDTO) obterDaRelacaoPorId(
				servicoSisLaraServerRmi.obterListagemGrupoAtivo(nomeGrupoDeReuniaoIntegracao).getObjetosDto(),
				idGrupoComModuloReuniaoIntegracao);

		ModuloPeriodoDTO moduloPeriodoReuniaoIntegracaoDTO = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoComModuloReuniaoIntegracao.getModulosPeriodosDto(), idModuloPeriodoReuniaoIntegracao);
		return (ModuloUsuarioDTO) obterPeloIdUsuario(moduloPeriodoReuniaoIntegracaoDTO, new UsuarioDTO(idUsuario));
	}

	private ResultadoEdicaoAtendimentoGrupoDTO servico_gera_atendimento_de_grupo_e_altera_frequencia_para_fu(
			EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentosDTO, Long idProntuario,
			ResultadoAutenticacaoDTO resultadoDto) throws RemoteException {
		ResultadoGeracaoAtendimentoDTO resultadoGeracaoAtendimentoDTO = servicoSisLaraServerRmi
				.gerarAtendimentos(especificacaoGeracaoAtendimentosDTO, resultadoDto.getToken());
		ModuloPeriodoDTO moduloPeriodoDTO = (ModuloPeriodoDTO) resultadoGeracaoAtendimentoDTO.getModuloPeriodoDTO();
		AtendimentoGrupoDTO atendimentoGrupoDTO = moduloPeriodoDTO.getAtendimentosGrupoDto()
				.get(moduloPeriodoDTO.getAtendimentosGrupoDto().size() - 1);
		alterarParticipacaoDetalhada(atendimentoGrupoDTO);
		AtendimentoUsuarioDTO atendimentoUsuarioDTO = obterAtendimentoDoUsuarioPeloProntuario(atendimentoGrupoDTO.getAtendimentosUsuariosDto(), idProntuario);
		atendimentoUsuarioDTO.getInformacaoAtendimentoDto().setFrequenciaDto(new FrequenciaDTO("FU"));
		atendimentoUsuarioDTO.getInformacaoAtendimentoDto().setParticipadaoDetalhadaDto(Arrays.asList());
		return servicoSisLaraServerRmi.editarAtendimentoGrupo(moduloPeriodoDTO, atendimentoGrupoDTO, resultadoDto.getToken());
	}

	private UsuarioDTO servico_salva_atendimento_individual_com_setor_frequencia_descricao_e_modulo(Long prontuario,
			SetorDTO setorDTO, FrequenciaDTO frequenciaDTO, DescricaoTipoAtendimentoDTO descricaoTipoAtendimentoDTO,
			ModuloDTO moduloDTO) throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.getUsuarioDto().setId(prontuario);
		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(descricaoTipoAtendimentoDTO);
		atendimentoIndividualDto.setModuloDto(moduloDTO);
		atendimentoIndividualDto.setSetorDto(setorDTO);
		atendimentoIndividualDto.getInformacaoAtendimentoDto().setFrequenciaDto(frequenciaDTO);
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("12:00", "13:00"));
		atendimentoIndividualDto.setArquivos(ContextoArquivo.obterArquivoDtoDocumentoAVFUN());

		servicoSisLaraServerRmi.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		EspecificacaoPesquisaUsuarioDTO especificacao = new EspecificacaoPesquisaUsuarioDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.PRONTUARIO, prontuario.toString());
		ResultadoListagemUsuarioDTO resultadoListagemDto = servicoSisLaraServerRmi.pesquisarUsuarioPor(especificacao);
		return (UsuarioDTO) obterDaRelacaoPorId(resultadoListagemDto.getObjetosDto(), prontuario);

	}

	private CredencialDTO construirCredencialDtoValida() {
		return new CredencialDTO("pabsantos", "1234", "1234");
	}

	private CredencialDTO construirCredencialDtoValidaAdailza() {
		return new CredencialDTO("adailza", "1234", "1234");
	}

	private CredencialDTO construirCredencialDtoValidaVVitalino() {
		return new CredencialDTO("vvitalino", "1234", "1234");
	}

	private CredencialDTO construirCredencialDtoValidaShivas() {
		return new CredencialDTO("shivas", "1234", "1234");
	}

	private CredencialDTO construirCredencialDtoValidaVeraPereira() {
		return new CredencialDTO("vera.pereira", "1234", "1234");
	}

	private CredencialDTO construirCredencialDtoRLemeDtoValida() {
		return new CredencialDTO("rleme", "a", "a");
	}

	private CredencialDTO construirCredencialAlternativaDtoInvalida() {
		return new CredencialDTO("paulo", "a", "c");
	}

	private CredencialDTO construirCredencialDtoValidaSemSenha() {
		return new CredencialDTO("pabsantos", "", "");
	}

	private CredencialDTO construirCredencialDtoSemPermissao() {
		return new CredencialDTO("teste", "teste", "teste");
	}

	private boolean valorExatoDeBytes(byte[] bytesObitido, byte[] bytesEsperado) {
		return bytesObitido.length == bytesEsperado.length;
	}
	
	// Variacao existente em decorr�ncia das datas nao deterministicas no rodape
	// do
	// relatorio
	private boolean variacaoMaximaDeBytes(byte[] bytesObitido, byte[] bytesEsperado) {
		int tamanhoByteObtido = bytesObitido.length;
		int tamanhoByteEsperado = bytesEsperado.length;
		int diferenca = Math.abs(tamanhoByteObtido - tamanhoByteEsperado);
		double porcentagemDiferenca = (Double.valueOf(diferenca) / Double.valueOf(tamanhoByteObtido)) * 100;
		return porcentagemDiferenca < Double.valueOf(4);
	}

	private void servico_altera_vagas_do_grupo_pelo_modulo_periodo(String nomeGrupo, Long idModuloPeriodo, String vagas,
			TokenDTO tokenDTO) throws RemoteException {
		GrupoDTO grupoSS1Dto = servicoSisLaraServerRmi.obterListagemGrupoAtivo(nomeGrupo).getObjetosDto().get(0);
		ModuloPeriodoDTO moduloPeriodoDTO = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoSS1Dto.getModulosPeriodosDto(),
				idModuloPeriodo);
		moduloPeriodoDTO.setVagas(vagas);
		servicoSisLaraServerRmi.editarModuloPeriodo(moduloPeriodoDTO, tokenDTO);
	}

	private ResultadoEdicaoGrupoDTO servico_tenta_desativar_grupo_com_usuarios_no_status(
			StatusRelacaoComModulo statusRelacaoComModulo) throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaShivas());
		String nomeGrupo = "G08-1";
		ResultadoListagemGrupoDTO resultadoListagemGrupoAEEPisico = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo(nomeGrupo);

		Long idGrupo = new Long(15555);
		Long idModuloPeriodo =  new Long(12345);
		GrupoDTO grupoAeePisicoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupoAEEPisico.getObjetosDto(),
				idGrupo);

		ModuloPeriodoDTO moduloPeriodoAEEDto = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoAeePisicoDto.getModulosPeriodosDto(), idModuloPeriodo);

		ModuloUsuarioDTO moduloUsuarioDTO = (ModuloUsuarioDTO) obterDaRelacaoPorId(
				moduloPeriodoAEEDto.getModulosUsuariosDto(), new Long(12345));
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO(statusRelacaoComModulo.toString()));
		moduloUsuarioDTO.setDataOcorrencia("01/01/2000");

		servicoSisLaraServerRmi.editarModuloPeriodo(moduloPeriodoAEEDto, resultadoDto.getToken());

		ResultadoListagemGrupoDTO resultadoListagemGrupoAEEPisicoAposAtualizacao = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo(nomeGrupo);

		GrupoDTO grupoAeePisicoDtoAposAtualizacao = (GrupoDTO) obterDaRelacaoPorId(
				resultadoListagemGrupoAEEPisicoAposAtualizacao.getObjetosDto(), idGrupo);
		grupoAeePisicoDtoAposAtualizacao.setAtivo(false);

		return servicoSisLaraServerRmi.editarGrupo(grupoAeePisicoDtoAposAtualizacao, resultadoDto.getToken());
	}
	
	private boolean contem(List<PendenciaDTO> pendenciasDto, String obs){
		return pendenciasDto.stream().anyMatch(pendencia -> pendencia.toString().contains(obs));
	}
	
	private ModuloUsuarioDTO servico_inclui_usuario_com_status_de_relacao_no_aee_e_retorna_o_psicossocial_do_grupo(
			StatusRelacaoComModulo statusAtualizadoNoAEE) throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaShivas());
		String nomeGrupo = "G08-1";
		Long idGrupo = new Long(15555);
		
		ResultadoListagemGrupoDTO resultadoListagemGrupoAEEPisico = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo(nomeGrupo);

		GrupoDTO grupoAeePisicoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupoAEEPisico.getObjetosDto(),
				idGrupo);

		ModuloPeriodoDTO moduloPeriodoAEEDto = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoAeePisicoDto.getModulosPeriodosDto(), new Long(12345));

		ModuloUsuarioDTO moduloUsuarioDto = obterPeloIdUsuario(moduloPeriodoAEEDto, new UsuarioDTO(new Long(16666)));
		moduloUsuarioDto.setStatusDto(new StatusRelacaoComModuloDTO(statusAtualizadoNoAEE.toString()));
		moduloUsuarioDto.setDataOcorrencia("01/01/2000");
		moduloUsuarioDto.setObs("A analisar.");

		servicoSisLaraServerRmi.editarModuloPeriodo(moduloPeriodoAEEDto, resultadoDto.getToken());

		ResultadoListagemGrupoDTO resultadoListagemGrupoAEEPisicoAposAtualizacao = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo(nomeGrupo);

		GrupoDTO grupoAeePisicoDtoAposAtualizacao = (GrupoDTO) obterDaRelacaoPorId(
				resultadoListagemGrupoAEEPisicoAposAtualizacao.getObjetosDto(), idGrupo);

		ModuloPeriodoDTO moduloPeriodoPsicossocialDtoAposAtualizacao = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoAeePisicoDtoAposAtualizacao.getModulosPeriodosDto(), new Long(1234567));

		return obterPeloIdUsuario(moduloPeriodoPsicossocialDtoAposAtualizacao, moduloUsuarioDto.getUsuarioDto());
	}

	private ModuloPeriodoDTO alterar_status_relacao_usuario_no_modulo_periodo(
			ResultadoListagemGrupoDTO resultadoListagemGrupo, Long idGrupo, Long idModuloPeriodo, Long idModuloUsuario,
			String statusRelacaoUsuario) {
		ModuloPeriodoDTO moduloPeriodoDto = obterModuloPeriodoDto(resultadoListagemGrupo.getObjetosDto(), idGrupo,
				idModuloPeriodo);
		ModuloUsuarioDTO moduloUsuarioDTO = (ModuloUsuarioDTO) obterDaRelacaoPorId(
				moduloPeriodoDto.getModulosUsuariosDto(), idModuloUsuario);
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO(statusRelacaoUsuario));
		return moduloPeriodoDto;
	}

	private ModuloUsuarioDTO servico_atualiza_status_de_relacao_do_aee_e_retorna_o_psicossocial_do_grupo(
			StatusRelacaoComModulo statusAtualizadoNoAEE) throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupoAEEPisico = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("G02-1");

		GrupoDTO grupoAeePisicoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupoAEEPisico.getObjetosDto(),
				new Long(12222));

		ModuloPeriodoDTO moduloPeriodoAEEDto = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoAeePisicoDto.getModulosPeriodosDto(), new Long(11111));

		ModuloUsuarioDTO moduloUsuarioDTO = (ModuloUsuarioDTO) obterDaRelacaoPorId(
				moduloPeriodoAEEDto.getModulosUsuariosDto(), new Long(11111));
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO(statusAtualizadoNoAEE.toString()));
		moduloUsuarioDTO.setDataOcorrencia("01/01/2000");
		moduloUsuarioDTO.setObs("Texto de OBS.");

		servicoSisLaraServerRmi.editarModuloPeriodo(moduloPeriodoAEEDto, resultadoDto.getToken());

		ResultadoListagemGrupoDTO resultadoListagemGrupoAEEPisicoAposAtualizacao = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("G02-1");

		GrupoDTO grupoAeePisicoDtoAposAtualizacao = (GrupoDTO) obterDaRelacaoPorId(
				resultadoListagemGrupoAEEPisicoAposAtualizacao.getObjetosDto(), new Long(12222));

		ModuloPeriodoDTO moduloPeriodoPsicossocialDtoAposAtualizacao = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoAeePisicoDtoAposAtualizacao.getModulosPeriodosDto(), new Long(22222));

		return (ModuloUsuarioDTO) obterDaRelacaoPorId(
				moduloPeriodoPsicossocialDtoAposAtualizacao.getModulosUsuariosDto(), new Long(11111));
	}

	private ResultadoListagemPendenciaDTO servico_resolve_pendencia_de_atendimento_invidual_de_servico_social_com_pre_cadastro_apos_geracao_de_atendimento_com_pre_cadastro(
			ResultadoAutenticacaoDTO resultadoDto, PreCadastroDTO preCadastroDto) throws RemoteException {
		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);

		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(18888));
		agendamentoDto.setPreCadastroDto(preCadastroDto);
		agendamentoDto.setData(DataHoraUtils.formatarData(MaquinaTempo.obterInstancia().obterCalendarioAtual()));

		servicoSisLaraServerRmi.editarAgendamento(agendamentoDto, resultadoDto.getToken());

		ResultadoListagemPendenciaDTO pendenciasAntesResolucaoDto = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setUsuarioDto(null);
		atendimentoIndividualDto.setPreCadastroDto(agendamentoDto.getPreCadastroDto());
		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(agendamentoDto.getDescricaoTipoAtendimentoDto());
		atendimentoIndividualDto.setModuloDto(agendamentoDto.getModuloDto());
		atendimentoIndividualDto.setData(agendamentoDto.getData());
		atendimentoIndividualDto.setHorarioDto(agendamentoDto.getHorarioDto());
		AtendimentoProfissionalDTO atendimentoProfissionalDTO = ContextoAtendimentoProfissional
				.construirAtendimentoProfissionalDTOComAT();
		atendimentoProfissionalDTO.setProfissionalDto(ContextoProfissional.construirProfissionalDTO());
		atendimentoIndividualDto.setAtendimentosProfissionalDto(Arrays.asList(atendimentoProfissionalDTO));

		servicoSisLaraServerRmi.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());
		return pendenciasAntesResolucaoDto;
	}

	private ResultadoEdicaoModuloPeriodoDTO servico_altera_relacao_de_modulo_usuario_e_retorno_modulo_periodo(
			ResultadoListagemGrupoDTO resultadoListagemGrupo, StatusRelacaoComModulo statusRelacaoComModulo,
			Long idGrupo, Long idModuloPeriodo, Long idModuloUsuario, TokenDTO tokenDto) throws RemoteException {

		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), idGrupo);
		ModuloPeriodoDTO moduloPeriodoDto = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(),
				idModuloPeriodo);
		ModuloUsuarioDTO moduloUsuarioDTO = (ModuloUsuarioDTO) obterDaRelacaoPorId(
				moduloPeriodoDto.getModulosUsuariosDto(), idModuloUsuario);
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO(statusRelacaoComModulo.toString()));

		return servicoSisLaraServerRmi.editarModuloPeriodo(moduloPeriodoDto, tokenDto);
	}

	private ResultadoEdicaoModuloPeriodoDTO integrar_usuario_ao_grupo_e_modulo_perido(
			ResultadoAutenticacaoDTO resultadoAutenticacaoDto, String nomeGrupo, Long idGrupo, Long idModuloPerido)
			throws RemoteException {
		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo(nomeGrupo);

		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), idGrupo);
		ModuloPeriodoDTO moduloPeriodoDTO = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(),
				idModuloPerido);

		ModuloUsuarioDTO moduloUsuarioDTO = ContextoModuloUsuario.fabricarModuloUsuarioDTO();
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.INTEGRADO.toString()));
		moduloPeriodoDTO.setModulosUsuariosDto(Arrays.asList(moduloUsuarioDTO));

		return servicoSisLaraServerRmi.editarModuloPeriodo(moduloPeriodoDTO, resultadoAutenticacaoDto.getToken());
	}

	public UsuarioDTO servico_altera_relacao_de_modulo_usuario_e_retornar_usuario_refenciado(
			ResultadoAutenticacaoDTO resultadoAutenticacaoDTO, ResultadoListagemGrupoDTO resultadoListagemGrupo, StatusRelacaoComModulo statusRelacaoComModulo,
			Long idGrupo, Long idModuloPeriodo, Long idModuloUsuario) throws RemoteException {
		ResultadoEdicaoModuloPeriodoDTO resultadoEdicaoModuloPeriodoDTO = servico_altera_relacao_de_modulo_usuario_e_retorno_modulo_periodo(
				resultadoListagemGrupo, statusRelacaoComModulo, idGrupo, idModuloPeriodo, idModuloUsuario,
				resultadoAutenticacaoDTO.getToken());

		ModuloPeriodoDTO moduloPeriodoDto = (ModuloPeriodoDTO) resultadoEdicaoModuloPeriodoDTO.obterObjetoDtoEditado();

		ModuloUsuarioDTO moduloUsuarioDTO = (ModuloUsuarioDTO) obterDaRelacaoPorId(
				moduloPeriodoDto.getModulosUsuariosDto(), idModuloUsuario);

		EspecificacaoPesquisaUsuarioDTO especificacaoPesquisaUsuarioDTO = new EspecificacaoPesquisaUsuarioDTO();
		especificacaoPesquisaUsuarioDTO.adicionarParametro(ChavePesquisaDTO.PRONTUARIO,
				moduloUsuarioDTO.getUsuarioDto().getId().toString());
		ResultadoListagemUsuarioDTO resultadoListagemUsuarioDto = servicoSisLaraServerRmi
				.pesquisarUsuarioPor(especificacaoPesquisaUsuarioDTO);
		return resultadoListagemUsuarioDto.getObjetosDto().get(0);
	}

	private List<DocumentoSolicitacaoDoacaoDTO> obterTodosDocumentos(String conteudoArquivo) {
		List<DocumentoSolicitacaoDoacaoDTO> documentos = new ArrayList<>();

		for (NomeDocumento nomeDocumento : NomeDocumento.values()) {
			DocumentoSolicitacaoDoacaoDTO documentoSolicitacaoDoacaoDTO = new DocumentoSolicitacaoDoacaoDTO();
			documentoSolicitacaoDoacaoDTO.setArquivoDTO(
					new ArquivoDTO(null, nomeDocumento.ordinal() + "Teste.pdf", conteudoArquivo.getBytes(), null));
			documentoSolicitacaoDoacaoDTO.setNomeDocumentoDTO(new NomeDocumentoDTO(nomeDocumento.toString()));
			documentos.add(documentoSolicitacaoDoacaoDTO);
		}
		return documentos;
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_efetua_login_bloqueado() throws RemoteException {
		CredencialDTO credencialDto = new CredencialDTO("marcos", "marcos", "marcos");
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(credencialDto);

		Assert.assertFalse(resultadoDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_efetua_pesquisa_todas_contas_acesso() throws RemoteException {
		EspecificacaoPesquisaContaAcessoDTO especificacaoPesquisaContasAcessoDTO = new EspecificacaoPesquisaContaAcessoDTO();
		especificacaoPesquisaContasAcessoDTO.adicionarParametro(ChavePesquisaDTO.TODOS_CONTAS_ACESSO, "");

		ResultadoListagemContaAcessoDTO listagemContaAcessoDto = servicoSisLaraServerRmi
				.pesquisarContaAcessoPor(especificacaoPesquisaContasAcessoDTO);

		Assert.assertTrue(listagemContaAcessoDto.sucesso());
		Assert.assertEquals(listagemContaAcessoDto.getObjetosDto().size(), 10);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_perfil() throws RemoteException {
		ResultadoListagemPerfilDTO resultadoListagemPerfil = servicoSisLaraServerRmi.obterListagemPerfil();

		Assert.assertTrue(resultadoListagemPerfil.sucesso());
		Assert.assertFalse(resultadoListagemPerfil.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
		Assert.assertEquals(resultadoListagemPerfil.getObjetosDto().size(), 2);
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_relacao_recurso() throws RemoteException {
		ResultadoListagemRelacaoRecursoDTO resultadoListagemRelacaoRecurso = servicoSisLaraServerRmi
				.obterListagemRelacaoRecurso();

		Assert.assertTrue(resultadoListagemRelacaoRecurso.sucesso());
		Assert.assertFalse(resultadoListagemRelacaoRecurso.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
		Assert.assertEquals(resultadoListagemRelacaoRecurso.getObjetosDto().size(), 2);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_perfil_atraves_de_especificacao() throws RemoteException {
		EspecificacaoPesquisaPerfilDTO especificacao = new EspecificacaoPesquisaPerfilDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.TODOS_PERFIS, "");
		ResultadoListagemPerfilDTO resultadoListagemPerfilDto = servicoSisLaraServerRmi
				.pesquisarPerfilPor(especificacao);

		Assert.assertTrue(resultadoListagemPerfilDto.sucesso());
		Assert.assertFalse(resultadoListagemPerfilDto.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.CONTRIBUINTE })
	public void servico_listagem_contribuinte_por_nome() throws RemoteException {
		EspecificacaoPesquisaContribuinteDTO especificacao = new EspecificacaoPesquisaContribuinteDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.NOME_CONTRIBUINTE, "ARAKEN");
		ResultadoListagemContribuinteDTO resultadoListagemContribuintesDto = servicoSisLaraServerRmi
				.pesquisarContribuintePor(especificacao);

		Assert.assertTrue(resultadoListagemContribuintesDto.sucesso());
		Assert.assertEquals(resultadoListagemContribuintesDto.getObjetosDto().size(), 1);
	}

	@Test(groups = { TiposDeTeste.CONTRIBUINTE })
	public void servico_pesquisa_listagem_todos_contribuintes() throws RemoteException {
		EspecificacaoPesquisaContribuinteDTO especificacao = new EspecificacaoPesquisaContribuinteDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.TODOS_CONTRIBUINTES, "");
		ResultadoListagemContribuinteDTO resultadoListagemContribuintesDto = servicoSisLaraServerRmi
				.pesquisarContribuintePor(especificacao);

		Assert.assertTrue(resultadoListagemContribuintesDto.sucesso());
		Assert.assertEquals(resultadoListagemContribuintesDto.getObjetosDto().size(), 2);
	}

	@Test(groups = { TiposDeTeste.RECIBO })
	public void servico_pesquisa_listagem_todos_recibos() throws RemoteException {
		EspecificacaoPesquisaReciboDTO especificacao = new EspecificacaoPesquisaReciboDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.TODOS_RECIBOS, "");
		ResultadoListagemReciboDTO resultadoListagemRecibosDto = servicoSisLaraServerRmi
				.pesquisarReciboPor(especificacao);

		Assert.assertTrue(resultadoListagemRecibosDto.sucesso());
		Assert.assertEquals(resultadoListagemRecibosDto.getObjetosDto().size(), 2);
	}
	
	@Test(groups = { TiposDeTeste.RECIBO })
	public void servico_nao_pesquisa_listagem_recibo_sem_dados_para_pesquisa() throws RemoteException {
		EspecificacaoPesquisaReciboDTO especificacao = new EspecificacaoPesquisaReciboDTO();
		ResultadoListagemReciboDTO resultadoListagemRecibosDto = servicoSisLaraServerRmi
				.pesquisarReciboPor(especificacao);

		Assert.assertFalse(resultadoListagemRecibosDto.sucesso());
		Assert.assertTrue(resultadoListagemRecibosDto.obterMensagens().contains("Insira o tipo e dados para pesquisa."));
	}
	
	@Test(groups = { TiposDeTeste.PROJETO })
	public void servico_nao_pesquisa_listagem_projeto_sem_dados_para_pesquisa() throws RemoteException {
		EspecificacaoPesquisaProjetoDTO especificacao = new EspecificacaoPesquisaProjetoDTO();
		ResultadoListagemProjetoDTO resultadoListagemRecibosDto = servicoSisLaraServerRmi
				.pesquisarProjetoPor(especificacao);

		Assert.assertFalse(resultadoListagemRecibosDto.sucesso());
		Assert.assertTrue(resultadoListagemRecibosDto.obterMensagens().contains("Insira o tipo e dados para pesquisa."));
	}
	
	@Test(groups = { TiposDeTeste.CONTRIBUINTE })
	public void servico_nao_pesquisa_contribuintes() throws RemoteException {
		EspecificacaoPesquisaContribuinteDTO especificacao = new EspecificacaoPesquisaContribuinteDTO();

		ResultadoListagemContribuinteDTO resultadoListagemContribuintesDto = servicoSisLaraServerRmi
				.pesquisarContribuintePor(especificacao);

		Assert.assertFalse(resultadoListagemContribuintesDto.sucesso());
		Assert.assertEquals(resultadoListagemContribuintesDto.obterMensagens(),
				"Insira o tipo e dados para pesquisa.\nNenhum registro encontrado.\n");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_permissao() throws RemoteException {
		ResultadoListagemPermissaoDTO resultadoListagemPermissao = servicoSisLaraServerRmi.obterListagemPermissao();

		Assert.assertTrue(resultadoListagemPermissao.sucesso());
		Assert.assertFalse(resultadoListagemPermissao.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
		Assert.assertEquals(resultadoListagemPermissao.getObjetosDto().size(), 105);
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_prestacao_conta() throws RemoteException {
		ResultadoListagemPrestacaoContaDTO resultadoListagemPrestacaoConta = servicoSisLaraServerRmi.obterListagemPrestacaoConta();

		Assert.assertTrue(resultadoListagemPrestacaoConta.sucesso());
		Assert.assertFalse(resultadoListagemPrestacaoConta.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
		Assert.assertEquals(resultadoListagemPrestacaoConta.getObjetosDto().size(), 2);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_inclui_perfil_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		PerfilDTO perfilDto = new PerfilDTO(null, "Teste");

		ResultadoEdicaoPerfilDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarPerfil(perfilDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_inclui_perfil_sem_sucesso_por_falta_de_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		PerfilDTO perfilDto = new PerfilDTO(null, "Teste");

		ResultadoEdicaoPerfilDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarPerfil(perfilDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_efetua_autenticacao_a_partir_de_credencial_valida() throws Exception {
		CredencialDTO credencialDto = construirCredencialDtoValida();

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(credencialDto);

		Assert.assertTrue(resultadoDto.sucesso(), "A conta de acesso deveria ter sido autenticada.");
		Assert.assertNotNull(resultadoDto.getToken(), "Um token deveria ser gerado.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nega_autenticacao_a_partir_de_credencial_invalida() throws Exception {
		CredencialDTO credencialDto = new CredencialDTO("invalida", "999999", "999999");

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(credencialDto);

		Assert.assertFalse(resultadoDto.sucesso(), "A autentica��o deveria ser negada.");
		Assert.assertEquals(resultadoDto.obterMensagens(), "Usu�rio ou senha inv�lido. Tente novamente.\n");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_inclui_nova_conta_acesso_pelo_administrador_com_sucesso() throws Exception {
		ResultadoAutenticacaoDTO tokenDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ContaAcessoDTO contaAcessoDto = new ContaAcessoDTO();
		contaAcessoDto.setUsuario("josep");
		contaAcessoDto.setSenha("meaza");
		contaAcessoDto.setPerfilDto(new PerfilDTO(new Long(1111), "Administrador"));

		ResultadoEdicaoContaAcessoDTO resultadoEdicaoContaAcessoDto = servicoSisLaraServerRmi
				.editarContaAcesso(contaAcessoDto, tokenDto.getToken());

		Assert.assertTrue(resultadoEdicaoContaAcessoDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_inclui_nova_conta_acesso_pelo_administrador_sem_sucesso() throws Exception {
		ResultadoAutenticacaoDTO tokenDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ContaAcessoDTO contaAcessoDto = new ContaAcessoDTO();
		contaAcessoDto.setUsuario("josep");
		contaAcessoDto.setSenha("meaza");
		contaAcessoDto.setPerfilDto(new PerfilDTO(new Long(1111), "Administrador"));

		ResultadoEdicaoContaAcessoDTO resultadoEdicaoContaAcessoDto = servicoSisLaraServerRmi
				.editarContaAcesso(contaAcessoDto, tokenDto.getToken());

		Assert.assertFalse(resultadoEdicaoContaAcessoDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_inclui_nova_conta_acesso_invalida_pelo_administrador_sem_sucesso() throws Exception {
		ResultadoAutenticacaoDTO tokenDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ContaAcessoDTO contaAcessoDto = new ContaAcessoDTO();

		ResultadoEdicaoContaAcessoDTO resultadoEdicaoContaAcessoDto = servicoSisLaraServerRmi
				.editarContaAcesso(contaAcessoDto, tokenDto.getToken());

		Assert.assertFalse(resultadoEdicaoContaAcessoDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_ativa_filtro_grupo_na_conta_cesso_sem_sucesso() throws Exception {
		ResultadoAutenticacaoDTO tokenDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoOperacaoFiltroGrupoDTO resultadoOperacaoFiltroGrupoDto = servicoSisLaraServerRmi
				.ativarFiltroGrupo(tokenDto.getToken());

		boolean filtroAtivo = servicoSisLaraServerRmi.filtroEstaAtivado(tokenDto.getToken());

		Assert.assertTrue(resultadoOperacaoFiltroGrupoDto.sucesso());
		Assert.assertTrue(filtroAtivo);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_desativa_filtro_grupo_na_conta_cesso_sem_sucesso() throws Exception {
		ResultadoAutenticacaoDTO tokenDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		servicoSisLaraServerRmi.ativarFiltroGrupo(tokenDto.getToken());
		ResultadoOperacaoFiltroGrupoDTO resultadoOperacaoFiltroGrupoDto = servicoSisLaraServerRmi
				.desativarFiltroGrupo(tokenDto.getToken());

		boolean filtroAtivo = servicoSisLaraServerRmi.filtroEstaAtivado(tokenDto.getToken());

		Assert.assertTrue(resultadoOperacaoFiltroGrupoDto.sucesso());
		Assert.assertFalse(filtroAtivo);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_classificacaosocial() throws RemoteException {
		ResultadoListagemClassificacaoSocialDTO resultadoDto = servicoSisLaraServerRmi
				.obterListagemClassificacaoSocial();

		Assert.assertTrue(resultadoDto.sucesso());
		Assert.assertFalse(resultadoDto.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_status() throws RemoteException {
		ResultadoListagemStatusDTO resultadoListagemStatus = servicoSisLaraServerRmi.obterListagemStatus();

		Assert.assertTrue(resultadoListagemStatus.sucesso());
		Assert.assertFalse(resultadoListagemStatus.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_filial() throws RemoteException {
		ResultadoListagemFilialDTO resultadoListagemFilial = servicoSisLaraServerRmi.obterListagemFilial();

		Assert.assertTrue(resultadoListagemFilial.sucesso());
		Assert.assertFalse(resultadoListagemFilial.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
		Assert.assertEquals(resultadoListagemFilial.getObjetosDto().size(), 1);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_status_contribuinte() throws RemoteException {
		ResultadoListagemStatusContribuinteDTO resultadoListagemStatus = servicoSisLaraServerRmi
				.obterListagemStatusContribuinte();

		Assert.assertTrue(resultadoListagemStatus.sucesso());
		Assert.assertFalse(resultadoListagemStatus.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_motivo_desativacao() throws RemoteException {
		ResultadoListagemMotivoDesativacaoDTO resultadoListagemMotivoDesativacao = servicoSisLaraServerRmi
				.obterListagemMotivoDesativacao();

		Assert.assertTrue(resultadoListagemMotivoDesativacao.sucesso());
		Assert.assertFalse(resultadoListagemMotivoDesativacao.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_status_familiar() throws RemoteException {
		ResultadoListagemStatusDTO resultadoListagemStatus = servicoSisLaraServerRmi.obterListagemStatusFamiliar();

		Assert.assertTrue(resultadoListagemStatus.sucesso());
		Assert.assertFalse(resultadoListagemStatus.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_status_atendimento_individual() throws RemoteException {
		ResultadoListagemStatusDTO resultadoListagemStatus = servicoSisLaraServerRmi
				.obterListagemStatusDisponiveisParaAtendimentoIndividual();

		Assert.assertTrue(resultadoListagemStatus.sucesso());
		Assert.assertFalse(resultadoListagemStatus.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_status_para_integracao() throws RemoteException {
		ResultadoListagemGrupoDTO resultadoListagemGrupoDTO = servicoSisLaraServerRmi.obterListagemGrupoAtivo("OSE-1");
		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupoDTO.getObjetosDto(), new Long(821582));

		StatusRelacaoComModuloDTO resultadoStatus = servicoSisLaraServerRmi.obterStatusRelacaoPadrao(grupoDto);

		Assert.assertEquals(resultadoStatus.toString(), StatusRelacaoComModulo.EVENTUAL.toString());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_status_para_agendamento() throws RemoteException {
		ResultadoListagemStatusDTO resultadoListagemStatus = servicoSisLaraServerRmi
				.obterListagemStatusDisponiveisParaAgendamento();

		Assert.assertTrue(resultadoListagemStatus.sucesso());
		Assert.assertFalse(resultadoListagemStatus.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_genero() throws RemoteException {
		ResultadoListagemGeneroDTO resultadoListagemGenero = servicoSisLaraServerRmi.obterListagemGenero();

		Assert.assertTrue(resultadoListagemGenero.sucesso());
		Assert.assertFalse(resultadoListagemGenero.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_vulnerabilidade_para_familia() throws RemoteException {
		ResultadoListagemVulnerabilidadeDTO resultadoListagemVulnerabilidadeFamilia = servicoSisLaraServerRmi
				.obterListagemVulnerabilidadeParaFamilia();

		Assert.assertTrue(resultadoListagemVulnerabilidadeFamilia.sucesso());
		Assert.assertEquals(resultadoListagemVulnerabilidadeFamilia.getObjetosDto().size(), 1);
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_vulnerabilidade_para_usuario() throws RemoteException {
		ResultadoListagemVulnerabilidadeDTO resultadoListagemVulnerabilidadeUsuario = servicoSisLaraServerRmi
				.obterListagemVulnerabilidadeParaUsuario();

		Assert.assertTrue(resultadoListagemVulnerabilidadeUsuario.sucesso());
		Assert.assertEquals(resultadoListagemVulnerabilidadeUsuario.getObjetosDto().size(), 1);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_status_beneficio() throws RemoteException {
		ResultadoListagemStatusBeneficioDTO resultadoListagemStatusBeneficio = servicoSisLaraServerRmi
				.obterListagemStatusBeneficio();

		Assert.assertTrue(resultadoListagemStatusBeneficio.sucesso());
		Assert.assertFalse(resultadoListagemStatusBeneficio.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_epoca_incidencia() throws RemoteException {
		ResultadoListagemEpocaIncidenciaDTO resultadoListagemEpocaIncidencia = servicoSisLaraServerRmi
				.obterListagemEpocaIncidencia();

		Assert.assertTrue(resultadoListagemEpocaIncidencia.sucesso());
		Assert.assertFalse(resultadoListagemEpocaIncidencia.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_uf() throws RemoteException {
		ResultadoListagemUfDTO resultadoListagemUf = servicoSisLaraServerRmi.obterListagemUf();

		Assert.assertTrue(resultadoListagemUf.sucesso());
		Assert.assertFalse(resultadoListagemUf.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_estadoscivil() throws RemoteException {
		ResultadoListagemEstadoCivilDTO resultadoListagemEstadoCivil = servicoSisLaraServerRmi
				.obterListagemEstadoCivil();

		Assert.assertTrue(resultadoListagemEstadoCivil.sucesso());
		Assert.assertFalse(resultadoListagemEstadoCivil.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_grupoetnico() throws RemoteException {
		ResultadoListagemGrupoEtnicoDTO resultadoListagemGrupoEtnico = servicoSisLaraServerRmi
				.obterListagemGrupoEtnico();

		Assert.assertTrue(resultadoListagemGrupoEtnico.sucesso());
		Assert.assertFalse(resultadoListagemGrupoEtnico.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_zona() throws RemoteException {
		ResultadoListagemZonaDTO resultadoListagemZona = servicoSisLaraServerRmi.obterListagemZona();

		Assert.assertTrue(resultadoListagemZona.sucesso());
		Assert.assertFalse(resultadoListagemZona.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_simnao() throws RemoteException {
		ResultadoListagemSimNaoDTO resultadoListagemSimNao = servicoSisLaraServerRmi.obterListagemSimNao();

		Assert.assertTrue(resultadoListagemSimNao.sucesso());
		Assert.assertFalse(resultadoListagemSimNao.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_setor() throws RemoteException {
		ResultadoListagemSetorDTO resultadoListagemSetor = servicoSisLaraServerRmi.obterListagemSetor();

		Assert.assertTrue(resultadoListagemSetor.sucesso());
		Assert.assertFalse(resultadoListagemSetor.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_setor_para_projetos() throws RemoteException {
		ResultadoListagemSetorDTO resultadoListagemSetorParaProjetos = servicoSisLaraServerRmi
				.obterListagemSetorParaProjetos();

		Assert.assertTrue(resultadoListagemSetorParaProjetos.sucesso());
		Assert.assertFalse(resultadoListagemSetorParaProjetos.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_paises() throws RemoteException {
		ResultadoListagemPaisDTO resultadoListagemPais = servicoSisLaraServerRmi.obterListagemPais();

		Assert.assertTrue(resultadoListagemPais.sucesso());
		Assert.assertFalse(resultadoListagemPais.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_area_formacao() throws RemoteException {
		ResultadoListagemAreaFormacaoDTO resultadoListagemAreaFormacao = servicoSisLaraServerRmi
				.obterListagemAreaFormacao();

		Assert.assertTrue(resultadoListagemAreaFormacao.sucesso());
		Assert.assertFalse(resultadoListagemAreaFormacao.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_municipios() throws RemoteException {
		ResultadoListagemMunicipioDTO resultadoListagemMunicipios = servicoSisLaraServerRmi
				.obterListagemMunicipio(new UfDTO("SP"));

		Assert.assertTrue(resultadoListagemMunicipios.sucesso());
		Assert.assertFalse(resultadoListagemMunicipios.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_escolaridade() throws RemoteException {
		ResultadoListagemEscolaridadeDTO resultadoListagemEscolaridade = servicoSisLaraServerRmi
				.obterListagemEscolaridade();

		Assert.assertTrue(resultadoListagemEscolaridade.sucesso());
		Assert.assertFalse(resultadoListagemEscolaridade.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_situacao() throws RemoteException {
		ResultadoListagemSituacaoDTO resultadoListagemSituacao = servicoSisLaraServerRmi.obterListagemSituacao();

		Assert.assertTrue(resultadoListagemSituacao.sucesso());
		Assert.assertFalse(resultadoListagemSituacao.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_periodo() throws RemoteException {
		ResultadoListagemPeriodoDTO resultadoListagemPeriodo = servicoSisLaraServerRmi.obterListagemPeriodo();

		Assert.assertTrue(resultadoListagemPeriodo.sucesso());
		Assert.assertFalse(resultadoListagemPeriodo.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}
	
	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_inclui_novo_usuario() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		UsuarioDTO usuarioASalvar = ContextoUsuario.construirUsuarioDTO();
		ResultadoEdicaoUsuarioDTO resultadoInclusaoUsuaro = servicoSisLaraServerRmi.editarUsuario(usuarioASalvar,
				resultadoDto.getToken());

		UsuarioDTO usuarioIncluido = (UsuarioDTO) resultadoInclusaoUsuaro.obterObjetoDtoEditado();

		Assert.assertTrue(resultadoInclusaoUsuaro.sucesso());
		Assert.assertEquals(usuarioIncluido.getStatusUsuarioAtualDto().toString(), Status.CASO_NOVO.toString());
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_altera_usuario_existente() throws RemoteException {
		ResultadoAutenticacaoDTO tokenDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		UsuarioDTO usuarioNovo = ContextoUsuario.construirUsuarioDTO();
		ResultadoEdicaoUsuarioDTO resultadoInclusaoUsuario = servicoSisLaraServerRmi.editarUsuario(usuarioNovo,
				tokenDto.getToken());
		UsuarioDTO usuarioSalvo = (UsuarioDTO) resultadoInclusaoUsuario.obterObjetoDtoEditado();
		ResultadoEdicaoUsuarioDTO resultadoAlteracaoUsuario = servicoSisLaraServerRmi.editarUsuario(usuarioSalvo,
				tokenDto.getToken());

		Assert.assertTrue(resultadoAlteracaoUsuario.sucesso());
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_nao_muda_status_usuario_ja_existente() throws RemoteException {
		ResultadoAutenticacaoDTO tokenDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaUsuarioDTO especificacao = new EspecificacaoPesquisaUsuarioDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.NOME, "Carlos");
		ResultadoListagemUsuarioDTO resultadoListagemUsuario = servicoSisLaraServerRmi
				.pesquisarUsuarioPor(especificacao);
		UsuarioDTO usuarioSemStatusJaExistente = (UsuarioDTO) obterDaRelacaoPorId(
				resultadoListagemUsuario.getObjetosDto(), new Long(13333));
		usuarioSemStatusJaExistente.setAssociadoAoSetorCTO(true);
		usuarioSemStatusJaExistente.getInformacaoEssencialDto().setRg("1234");
		usuarioSemStatusJaExistente.setResponsavelPorSiMesmo(true);
		EnderecoDTO enderecoDto = new EnderecoDTO();
		enderecoDto.setCep("01151000");
		enderecoDto.setEndereco("Rua Brigadeiro Galv�o");
		enderecoDto.setNumero("344A");
		enderecoDto.setComplemento("AP444");
		enderecoDto.setZonaDto(new ZonaDTO(Zona.LESTE.toString()));
		enderecoDto.setBairro("Marambaia");
		enderecoDto.setMunicipioDto(new MunicipioDTO(new Long(4850), "S�o Paulo", new UfDTO("SP")));
		enderecoDto.setUfDto(new UfDTO(UF.SP.toString()));
		enderecoDto.setPaisDto(new PaisDTO(new Long(1), "Brasil"));
		usuarioSemStatusJaExistente.getInformacaoEssencialDto().setEnderecoDto(enderecoDto);

		ResultadoEdicaoUsuarioDTO resultadoAlteracaoUsuario = servicoSisLaraServerRmi
				.editarUsuario(usuarioSemStatusJaExistente, tokenDto.getToken());

		UsuarioDTO usuarioSemStatusJaExistenteAposEdicao = (UsuarioDTO) resultadoAlteracaoUsuario
				.obterObjetoDtoEditado();
		Assert.assertTrue(resultadoAlteracaoUsuario.sucesso());
		Assert.assertNull(usuarioSemStatusJaExistenteAposEdicao.getStatusUsuarioAtualDto());
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_nao_altera_usuario_devido_a_concorrencia() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaUsuarioDTO especificacao = new EspecificacaoPesquisaUsuarioDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.NOME, "Augusto");

		ResultadoListagemUsuarioDTO resultadoDto = servicoSisLaraServerRmi.pesquisarUsuarioPor(especificacao);

		UsuarioDTO usuarioNovo = (UsuarioDTO) obterDaRelacaoPorId(resultadoDto.getObjetosDto(), new Long(12222));
		usuarioNovo.setVersao("12222");

		ResultadoEdicaoUsuarioDTO resultadoAlteracaoUsuario = servicoSisLaraServerRmi.editarUsuario(usuarioNovo,
				resultadoAutenticacaoDto.getToken());

		Assert.assertFalse(resultadoAlteracaoUsuario.sucesso());
		Assert.assertEquals(resultadoAlteracaoUsuario.obterMensagens(),
				"Os dados foram alterados por outro usu�rio do sistema. Por favor, tente novamente.\n");
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_inclui_usuario_com_inconsistencia() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		UsuarioDTO usuarioASalvar = ContextoUsuario.construirUsuarioDTO();
		usuarioASalvar.getInformacaoEssencialDto().setCpf("32487239847");
		ResultadoEdicaoUsuarioDTO resultadoInclusaoUsuaro = servicoSisLaraServerRmi.editarUsuario(usuarioASalvar,
				resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoUsuaro.sucesso());
		Assert.assertNotNull(resultadoInclusaoUsuaro.obterMensagens());
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_inclui_usuario_sem_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		UsuarioDTO usuarioASalvar = ContextoUsuario.construirUsuarioDTO();
		ResultadoEdicaoUsuarioDTO resultadoInclusaoUsuaro = servicoSisLaraServerRmi.editarUsuario(usuarioASalvar,
				resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoUsuaro.sucesso());
		Assert.assertNotNull(resultadoInclusaoUsuaro.obterMensagens());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_permissao_por_conta_acesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		ResultadoListagemPermissaoDTO resultadoListagemPermissaoDto = servicoSisLaraServerRmi
				.obterPermissoes(resultadoDto.getToken());

		Assert.assertTrue(resultadoListagemPermissaoDto.sucesso());
		Assert.assertEquals(resultadoListagemPermissaoDto.getObjetosDto().size(), 68);
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_efetua_pesquisa_por_usuarios_a_partir_de_nome() throws RemoteException {
		EspecificacaoPesquisaUsuarioDTO especificacao = new EspecificacaoPesquisaUsuarioDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.NOME, "Augusto");

		ResultadoListagemUsuarioDTO resultadoDto = servicoSisLaraServerRmi.pesquisarUsuarioPor(especificacao);

		Assert.assertEquals(resultadoDto.getObjetosDto().size(), 2);
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_efetua_pesquisa_por_usuarios_a_partir_de_familiar() throws RemoteException {
		EspecificacaoPesquisaUsuarioDTO especificacao = new EspecificacaoPesquisaUsuarioDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.FAMILIAR, "Jose");

		ResultadoListagemUsuarioDTO resultadoDto = servicoSisLaraServerRmi.pesquisarUsuarioPor(especificacao);

		Assert.assertEquals(resultadoDto.getObjetosDto().size(), 1);
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_efetua_pesquisa_por_usuarios_a_partir_de_instituicao() throws RemoteException {
		EspecificacaoPesquisaUsuarioDTO especificacao = new EspecificacaoPesquisaUsuarioDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.NOME, "Augusto");

		ResultadoListagemUsuarioDTO resultadoDto = servicoSisLaraServerRmi.pesquisarUsuarioPor(especificacao);

		Assert.assertEquals(resultadoDto.getObjetosDto().size(), 2);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_permite_autorizacao_acesso_a_funcionalidade() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		boolean possuiAutorizacao = servicoSisLaraServerRmi.possuiAutorizacao(resultadoDto.getToken(),
				"USUARIO_EDICAO");

		Assert.assertTrue(possuiAutorizacao);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nega_autorizacao_acesso_a_funcionalidade() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		boolean possuiNegado = servicoSisLaraServerRmi.possuiAutorizacao(resultadoDto.getToken(), "USUARIO_EDICAO");

		Assert.assertFalse(possuiNegado);
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_efetua_pesquisa_por_usuarios_a_partir_de_rg() throws RemoteException {
		EspecificacaoPesquisaUsuarioDTO especificacao = new EspecificacaoPesquisaUsuarioDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.RG, "23456");

		ResultadoListagemUsuarioDTO resultadoDto = servicoSisLaraServerRmi.pesquisarUsuarioPor(especificacao);

		Assert.assertEquals(resultadoDto.getObjetosDto().size(), 1);
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_efetua_pesquisa_por_usuarios_inexistentes_a_partir_de_nome() throws RemoteException {
		EspecificacaoPesquisaUsuarioDTO especificacao = new EspecificacaoPesquisaUsuarioDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.NOME, "Chivas");

		ResultadoListagemUsuarioDTO resultadoDto = servicoSisLaraServerRmi.pesquisarUsuarioPor(especificacao);

		Assert.assertEquals(resultadoDto.getObjetosDto().size(), 0);
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_efetua_pesquisa_por_usuarios_inexistentes_a_partir_de_rg() throws RemoteException {
		EspecificacaoPesquisaUsuarioDTO especificacao = new EspecificacaoPesquisaUsuarioDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.RG, "178278");

		ResultadoListagemUsuarioDTO resultadoDto = servicoSisLaraServerRmi.pesquisarUsuarioPor(especificacao);

		Assert.assertEquals(resultadoDto.getObjetosDto().size(), 0);
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_efetua_pesquisa_por_usuario_a_partir_de_prontuario() throws RemoteException {
		EspecificacaoPesquisaUsuarioDTO especificacao = new EspecificacaoPesquisaUsuarioDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.PRONTUARIO, "12222");

		ResultadoListagemUsuarioDTO resultadoDto = servicoSisLaraServerRmi.pesquisarUsuarioPor(especificacao);

		Assert.assertEquals(resultadoDto.getObjetosDto().size(), 1);
	}
	
	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_efetua_pesquisa_por_usuario_com_resumo_de_atendimentos_do_psicossocial_a_partir_de_prontuario() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());
		
		EspecificacaoPesquisaUsuarioDTO especificacao = new EspecificacaoPesquisaUsuarioDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.PRONTUARIO, "12222");

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("11:00", "12:00"));
		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(ContextoDescricaoTipoAtendimento.construirDescricaoServicoSocialDTO());
		atendimentoIndividualDto.setModuloDto(ContextoModulo.construirModuloAvaliacaoETriagemDTO());
		
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDTO = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		ResultadoListagemUsuarioDTO resultadoUsuarioDto = servicoSisLaraServerRmi.pesquisarUsuarioPor(especificacao);
		UsuarioDTO usuarioDtoEditado = resultadoUsuarioDto.getObjetosDto().get(0);
		
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDTO.sucesso());
		Assert.assertTrue(usuarioDtoEditado.getResumoAtendimentosPsicossocial()
				.contains("Aten��o Psicossocial - Servico Social - Avalia��o e Triagem"));
		Assert.assertTrue(usuarioDtoEditado.getResumoAtendimentosPsicossocial()
				.contains("31/12/2012 - 11:00 �s 12:00 - PAULO AUGUSTO BANDEIRA DOS SANTOS"));
		Assert.assertTrue(usuarioDtoEditado.getResumoAtendimentosPsicossocial().contains("Grande descri��o"));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_efetua_pesquisa_por_usuario_inexistente_a_partir_de_prontuario() throws RemoteException {
		EspecificacaoPesquisaUsuarioDTO especificacao = new EspecificacaoPesquisaUsuarioDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.PRONTUARIO, "99999");

		ResultadoListagemUsuarioDTO resultadoDto = servicoSisLaraServerRmi.pesquisarUsuarioPor(especificacao);

		Assert.assertEquals(resultadoDto.getObjetosDto().size(), 0);
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_efetua_pesquisa_por_usuario_a_partir_de_prontuario_invalido() throws RemoteException {
		EspecificacaoPesquisaUsuarioDTO especificacao = new EspecificacaoPesquisaUsuarioDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.PRONTUARIO, "AAAAAAAAABBBBBAAAAAA");

		ResultadoListagemUsuarioDTO resultadoDto = servicoSisLaraServerRmi.pesquisarUsuarioPor(especificacao);

		Assert.assertFalse(resultadoDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_efetua_pesquisa_por_usuarios_a_partir_de_especificacao_vazia() throws RemoteException {
		EspecificacaoPesquisaUsuarioDTO especificacao = new EspecificacaoPesquisaUsuarioDTO();

		ResultadoListagemUsuarioDTO resultadoDto = servicoSisLaraServerRmi.pesquisarUsuarioPor(especificacao);

		Assert.assertEquals(resultadoDto.sucesso(), false);
		Assert.assertFalse(resultadoDto.obterMensagens().isEmpty());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_tipoinstituicao() throws RemoteException {
		ResultadoListagemTipoInstituicaoDTO resultadoListagemTipoInstituicao = servicoSisLaraServerRmi
				.obterListagemTipoInstituicao();

		Assert.assertTrue(resultadoListagemTipoInstituicao.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemTipoInstituicao.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_classificaoinstituicao() throws RemoteException {
		ResultadoListagemClassificacaoInstituicaoDTO resultadoListagemClassificaocaoInstituicao = servicoSisLaraServerRmi
				.obterListagemClassificacaoInstituicao();

		Assert.assertTrue(resultadoListagemClassificaocaoInstituicao.sucesso(),
				"A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemClassificaocaoInstituicao.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_tipocertidao() throws RemoteException {
		ResultadoListagemTipoCertidaoDTO resultadoListagemTipoCertidao = servicoSisLaraServerRmi
				.obterListagemTipoCertidao();

		Assert.assertTrue(resultadoListagemTipoCertidao.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemTipoCertidao.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_tipoleitura() throws RemoteException {
		ResultadoListagemTipoLeituraDTO resultadoListagemTipoLeitura = servicoSisLaraServerRmi
				.obterListagemTipoLeitura();

		Assert.assertTrue(resultadoListagemTipoLeitura.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemTipoLeitura.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_cargo() throws RemoteException {
		ResultadoListagemCargoDTO resultadoListagemCargo = servicoSisLaraServerRmi.obterListagemCargo();

		Assert.assertTrue(resultadoListagemCargo.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemCargo.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_origem_encaminhamento() throws RemoteException {
		ResultadoListagemOrigemEncaminhamentoDTO resultadoListagemOrigemEncaminhamento = servicoSisLaraServerRmi
				.obterListagemOrigemEncaminhamento();

		Assert.assertTrue(resultadoListagemOrigemEncaminhamento.sucesso(),
				"A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemOrigemEncaminhamento.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_local_trabalho() throws RemoteException {
		ResultadoListagemLocalTrabalhoDTO resultadoListagemLocalTrabalho = servicoSisLaraServerRmi
				.obterListagemLocalTrabalho();

		Assert.assertTrue(resultadoListagemLocalTrabalho.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemLocalTrabalho.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_tipoespecialidade() throws RemoteException {
		ResultadoListagemTipoEspecialidadeDTO resultadoListagemTipoEspecialidade = servicoSisLaraServerRmi
				.obterListagemTipoEspecialidade();

		Assert.assertTrue(resultadoListagemTipoEspecialidade.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemTipoEspecialidade.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_tipoapoio() throws RemoteException {
		ResultadoListagemTipoApoioDTO resultadoListagemTipoApoio = servicoSisLaraServerRmi.obterListagemTipoApoio();

		Assert.assertTrue(resultadoListagemTipoApoio.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemTipoApoio.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_drecefai() throws RemoteException {
		ResultadoListagemDreCefaiDTO resultadoListagemDreCefai = servicoSisLaraServerRmi.obterListagemDreCefai();

		Assert.assertTrue(resultadoListagemDreCefai.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemDreCefai.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_diretoriaensino() throws RemoteException {
		ResultadoListagemDiretoriaEnsinoDTO resultadoListagemDiretoriaEnsino = servicoSisLaraServerRmi
				.obterListagemDiretoriaEnsino();

		Assert.assertTrue(resultadoListagemDiretoriaEnsino.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemDiretoriaEnsino.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_instituicoes() throws RemoteException {
		ResultadoListagemInstituicaoDTO resultadoListagemInstituicoes = servicoSisLaraServerRmi
				.obterListagemInstituicao();

		Assert.assertTrue(resultadoListagemInstituicoes.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemInstituicoes.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_instituicoes_com_srms() throws RemoteException {
		ResultadoListagemInstituicaoDTO resultadoListagemInstituicoes = servicoSisLaraServerRmi
				.obterListagemInstituicaoComSRMs();

		Assert.assertTrue(resultadoListagemInstituicoes.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemInstituicoes.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_instituicoes_com_sala_recurso() throws RemoteException {
		ResultadoListagemInstituicaoDTO resultadoListagemInstituicoes = servicoSisLaraServerRmi
				.obterListagemInstituicaoComSalaRecurso();

		Assert.assertTrue(resultadoListagemInstituicoes.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemInstituicoes.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_instituicoes_com_outros_aee() throws RemoteException {
		ResultadoListagemInstituicaoDTO resultadoListagemInstituicoes = servicoSisLaraServerRmi
				.obterListagemInstituicaoComOutrosAEE();

		Assert.assertTrue(resultadoListagemInstituicoes.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemInstituicoes.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_recursos() throws RemoteException {
		ResultadoListagemRecursoDTO resultadoListagemRecurso = servicoSisLaraServerRmi.obterListagemRecurso();

		Assert.assertTrue(resultadoListagemRecurso.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemRecurso.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_servico() throws RemoteException {
		ResultadoListagemServicoDTO resultadoListagemServico = servicoSisLaraServerRmi.obterListagemServico();

		Assert.assertTrue(resultadoListagemServico.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemServico.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_necessidade() throws RemoteException {
		ResultadoListagemNecessidadeDTO resultadoListagemNecessidade = servicoSisLaraServerRmi
				.obterListagemNecessidade();

		Assert.assertTrue(resultadoListagemNecessidade.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemNecessidade.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_recurso_moradia() throws RemoteException {
		ResultadoListagemRecursoMoradiaDTO resultadoListagemRecursoMoradia = servicoSisLaraServerRmi
				.obterListagemRecursoProximoMoradia();

		Assert.assertTrue(resultadoListagemRecursoMoradia.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemRecursoMoradia.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_expectativa() throws RemoteException {
		ResultadoListagemExpectativaDTO resultadoListagemExpectativa = servicoSisLaraServerRmi.obterListagemExpectativa();

		Assert.assertTrue(resultadoListagemExpectativa.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemExpectativa.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_condicao_moradia() throws RemoteException {
		ResultadoListagemCondicaoMoradiaDTO resultadoListagemCondicaoMoradia = servicoSisLaraServerRmi.obterListagemCondicaoMoradia();

		Assert.assertTrue(resultadoListagemCondicaoMoradia.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemCondicaoMoradia.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_situacao_habitacional() throws RemoteException {
		ResultadoListagemSituacaoHabitacionalDTO resultadoListagemSituacaoHabitacional = servicoSisLaraServerRmi.obterListagemSituacaoHabitacional();

		Assert.assertTrue(resultadoListagemSituacaoHabitacional.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemSituacaoHabitacional.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_habitacao() throws RemoteException {
		ResultadoListagemHabitacaoDTO resultadoListagemHabitacao = servicoSisLaraServerRmi.obterListagemHabitacao();

		Assert.assertTrue(resultadoListagemHabitacao.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemHabitacao.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_tipo_construcao() throws RemoteException {
		ResultadoListagemTipoConstrucaoDTO resultadoListagemTipoConstrucao = servicoSisLaraServerRmi.obterListagemTipoConstrucao();

		Assert.assertTrue(resultadoListagemTipoConstrucao.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemTipoConstrucao.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_infraestrutura_basica() throws RemoteException {
		ResultadoListagemInfraestruturaBasicaDTO resultadoListagemInfraestruturaBasica = servicoSisLaraServerRmi
				.obterListagemInfraestruturaBasica();

		Assert.assertTrue(resultadoListagemInfraestruturaBasica.sucesso(),
				"A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemInfraestruturaBasica.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INSTITUICAO })
	public void servico_inclui_nova_instituicao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		InstituicaoDTO instituicaoASalvar = ContextoInstituicao.construirInstitucaoDTO();

		ResultadoEdicaoInstituicaoDTO resultadoInclusaoInstituicao = servicoSisLaraServerRmi
				.editarInstituicao(instituicaoASalvar, resultadoDto.getToken());

		Assert.assertTrue(resultadoInclusaoInstituicao.sucesso());
		Assert.assertEquals(instituicaoASalvar.getNome(),
				((InstituicaoDTO) resultadoInclusaoInstituicao.obterObjetoDtoEditado()).getNome());
	}

	@Test(groups = { TiposDeTeste.INSTITUICAO })
	public void servico_nao_inclui_nova_instituicao_repetida() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		InstituicaoDTO instituicaoASalvar = ContextoInstituicao.construirInstitucaoDTO();
		instituicaoASalvar.setId(null);
		instituicaoASalvar.setNome("TESTE");

		ResultadoEdicaoInstituicaoDTO resultadoInclusaoInstituicao = servicoSisLaraServerRmi
				.editarInstituicao(instituicaoASalvar, resultadoDto.getToken());

		ResultadoEdicaoInstituicaoDTO resultadoInclusaoInstituicaoDuplicado = servicoSisLaraServerRmi
				.editarInstituicao(instituicaoASalvar, resultadoDto.getToken());

		Assert.assertTrue(resultadoInclusaoInstituicao.sucesso());
		Assert.assertFalse(resultadoInclusaoInstituicaoDuplicado.sucesso());
	}

	@Test(groups = { TiposDeTeste.INSTITUICAO })
	public void servico_altera_instituicao_existente() throws RemoteException {
		ResultadoAutenticacaoDTO tokenDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		InstituicaoDTO instituicaoNovaDto = ContextoInstituicao.construirInstitucaoDTO();
		ResultadoEdicaoInstituicaoDTO resultadoInclusaoInstituicao = servicoSisLaraServerRmi
				.editarInstituicao(instituicaoNovaDto, tokenDto.getToken());
		InstituicaoDTO instituicaoSalva = (InstituicaoDTO) resultadoInclusaoInstituicao.obterObjetoDtoEditado();
		instituicaoNovaDto.setId(instituicaoSalva.getId());
		instituicaoNovaDto.setNome("NOVO NOME");
		ResultadoEdicaoInstituicaoDTO resultadoAlteracaoUsuario = servicoSisLaraServerRmi
				.editarInstituicao(instituicaoNovaDto, tokenDto.getToken());

		Assert.assertTrue(resultadoAlteracaoUsuario.sucesso());
	}

	@Test(groups = { TiposDeTeste.INSTITUICAO })
	public void servico_nao_atualiza_instituicao_repetida() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		InstituicaoDTO instituicaoASalvar = ContextoInstituicao.construirInstitucaoDTO();
		instituicaoASalvar.setId(new Long(12222));

		ResultadoEdicaoInstituicaoDTO resultadoInclusaoInstituicao = servicoSisLaraServerRmi
				.editarInstituicao(instituicaoASalvar, resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoInstituicao.sucesso());
	}

	@Test(groups = { TiposDeTeste.INSTITUICAO })
	public void servico_nao_inclui_instituicao_com_inconsistencia() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		List<TelefoneDTO> telefonesDto = new ArrayList<>();
		telefonesDto.add(new TelefoneDTO(new TipoTelefoneDTO("RESIDENCIAL"), "12345678901234567", "1234", "Paulo"));

		InstituicaoDTO instituicaoASalvar = ContextoInstituicao.construirInstitucaoDTO();
		instituicaoASalvar.getContatoDto().setTelefonesDto(telefonesDto);
		ResultadoEdicaoInstituicaoDTO resultadoInclusaoInstituicao = servicoSisLaraServerRmi
				.editarInstituicao(instituicaoASalvar, resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoInstituicao.sucesso());
		Assert.assertNotNull(resultadoInclusaoInstituicao.obterMensagens());
	}

	@Test(groups = { TiposDeTeste.INSTITUICAO })
	public void servico_inclui_instituicao_sem_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		InstituicaoDTO instituicaoASalvar = ContextoInstituicao.construirInstitucaoDTO();
		ResultadoEdicaoInstituicaoDTO resultadoInclusaoInstituicao = servicoSisLaraServerRmi
				.editarInstituicao(instituicaoASalvar, resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoInstituicao.sucesso());
		Assert.assertNotNull(resultadoInclusaoInstituicao.obterMensagens());
	}

	@Test(groups = { TiposDeTeste.INSTITUICAO })
	public void servico_efetua_pesquisa_por_instituicao_a_partir_de_nome() throws RemoteException {
		EspecificacaoPesquisaInstituicaoDTO especificacao = new EspecificacaoPesquisaInstituicaoDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.NOME_INSTITUICAO, "Escola Joao");

		ResultadoListagemInstituicaoDTO resultadoDto = servicoSisLaraServerRmi.pesquisarInstituicaoPor(especificacao);

		Assert.assertEquals(resultadoDto.getObjetosDto().size(), 1);
	}

	@Test(groups = { TiposDeTeste.SOLICITACAO_RELATORIO })
	public void servico_efetua_pesquisa_por_solicitacao_relatorio_a_partir_de_prontuario() throws RemoteException {
		EspecificacaoPesquisaSolicitacaoRelatorioDTO especificacao = new EspecificacaoPesquisaSolicitacaoRelatorioDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.PRONTUARIO, "12222");

		ResultadoListagemSolicitacaoRelatorioDTO resultadoDto = servicoSisLaraServerRmi
				.pesquisarSolicitacaoRelatorioPor(especificacao);

		Assert.assertEquals(resultadoDto.getObjetosDto().size(), 2);
	}

	@Test(groups = { TiposDeTeste.INSTITUICAO })
	public void servico_efetua_pesquisa_por_instituicao_inexistentes_a_partir_de_nome() throws RemoteException {
		EspecificacaoPesquisaInstituicaoDTO especificacao = new EspecificacaoPesquisaInstituicaoDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.NOME_INSTITUICAO, "Instituto NOVO");

		ResultadoListagemInstituicaoDTO resultadoDto = servicoSisLaraServerRmi.pesquisarInstituicaoPor(especificacao);

		Assert.assertTrue(resultadoDto.getObjetosDto().isEmpty());
	}

	@Test(groups = { TiposDeTeste.INSTITUICAO })
	public void servico_efetua_pesquisa_por_instituicao_a_partir_de_especificacao_vazia() throws RemoteException {
		EspecificacaoPesquisaInstituicaoDTO especificacao = new EspecificacaoPesquisaInstituicaoDTO();

		ResultadoListagemInstituicaoDTO resultadoDto = servicoSisLaraServerRmi.pesquisarInstituicaoPor(especificacao);

		Assert.assertEquals(resultadoDto.sucesso(), false);
		Assert.assertFalse(resultadoDto.obterMensagens().isEmpty());
	}

	@Test(groups = { TiposDeTeste.PRE_CADASTRO })
	public void servico_efetua_pesquisa_por_precadastro_a_partir_de_nome() throws RemoteException {
		EspecificacaoPesquisaPreCadastroDTO especificacao = new EspecificacaoPesquisaPreCadastroDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.PRE_CADASTRO, "Josep Meaza");

		ResultadoListagemPreCadastroDTO resultadoDto = servicoSisLaraServerRmi.pesquisarPreCadastroPor(especificacao);

		Assert.assertEquals(resultadoDto.getObjetosDto().size(), 2);
	}

	@Test(groups = { TiposDeTeste.PRE_CADASTRO })
	public void servico_inclui_novo_precadastro() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		PreCadastroDTO preCadastroASalvar = ContextoPreCadastro.construirPreCadastroDTOsemIdentificacao();
		preCadastroASalvar.getInformacaoEssencialDto().setRg("88888X");

		ResultadoEdicaoPreCadastroDTO resultadoInclusaoPreCadastro = servicoSisLaraServerRmi
				.editarPreCadastro(preCadastroASalvar, resultadoDto.getToken());

		Assert.assertTrue(resultadoInclusaoPreCadastro.sucesso());
		Assert.assertEquals(preCadastroASalvar.getInformacaoEssencialDto().getNome(),
				((PreCadastroDTO) resultadoInclusaoPreCadastro.obterObjetoDtoEditado()).getInformacaoEssencialDto()
						.getNome());
	}

	@Test(groups = { TiposDeTeste.PRE_CADASTRO })
	public void servico_nao_inclui_novo_precadastro_com_cpf_duplicado() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		PreCadastroDTO preCadastroASalvar = ContextoPreCadastro.construirPreCadastroDTOsemIdentificacao();
		preCadastroASalvar.getInformacaoEssencialDto().setCpf("71894810287");

		servicoSisLaraServerRmi.editarPreCadastro(preCadastroASalvar, resultadoDto.getToken());
		ResultadoEdicaoPreCadastroDTO resultadoInclusaoPreCadastro = servicoSisLaraServerRmi
				.editarPreCadastro(preCadastroASalvar, resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoPreCadastro.sucesso());
		Assert.assertEquals(resultadoInclusaoPreCadastro.obterMensagens().trim(), "Cpf j� foi cadastrado.");
	}

	@Test(groups = { TiposDeTeste.PRE_CADASTRO })
	public void servico_nao_altera_precadastro_com_cpf_duplicado() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		EspecificacaoPesquisaPreCadastroDTO especificacao = new EspecificacaoPesquisaPreCadastroDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.PRE_CADASTRO, "Josep Meaza");
		ResultadoListagemPreCadastroDTO resultadoPesquisaPreCadastroDto = servicoSisLaraServerRmi
				.pesquisarPreCadastroPor(especificacao);

		PreCadastroDTO preCadastroDto = (PreCadastroDTO) obterDaRelacaoPorId(
				resultadoPesquisaPreCadastroDto.getObjetosDto(), new Long(12222));

		preCadastroDto.getInformacaoEssencialDto().setCpf("71894810287");
		ResultadoEdicaoPreCadastroDTO resultadoAlteracaoPreCadastro = servicoSisLaraServerRmi
				.editarPreCadastro(preCadastroDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoAlteracaoPreCadastro.sucesso());
		Assert.assertEquals(resultadoAlteracaoPreCadastro.obterMensagens().trim(), "Cpf j� foi cadastrado.");
	}

	@Test(groups = { TiposDeTeste.SOLICITACAO_RELATORIO })
	public void servico_inclui_solicitacao_relatorio_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		SolicitacaoRelatorioDTO solicitacaoRelatorioASalvar = ContextoSolicitacaoRelatorio
				.construirSolicitacaoRelatorioDTO();

		ResultadoEdicaoSolicitacaoRelatorioDTO resultadoInclusaoSolicitacaoRelatorio = servicoSisLaraServerRmi
				.editarSolicitacaoRelatorio(solicitacaoRelatorioASalvar, resultadoDto.getToken());

		Assert.assertTrue(resultadoInclusaoSolicitacaoRelatorio.sucesso());
	}

	@Test(groups = { TiposDeTeste.SOLICITACAO_RELATORIO })
	public void servico_nao_inclui_solicitacao_relatorio_pois_ja_existe_solicitacao_feita_a_menos_de_seis_meses()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		MaquinaTempo.mudarDataAtual("01/01/2016");
		SolicitacaoRelatorioDTO solicitacaoRelatorioASalvar = ContextoSolicitacaoRelatorio
				.construirSolicitacaoRelatorioDTO();
		solicitacaoRelatorioASalvar.setFinalidadesRelatoriosDto(Arrays.asList(new FinalidadeRelatorioDTO("ATESTADO")));
		solicitacaoRelatorioASalvar.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoA());

		ResultadoEdicaoSolicitacaoRelatorioDTO resultadoInclusaoSolicitacaoRelatorio = servicoSisLaraServerRmi
				.editarSolicitacaoRelatorio(solicitacaoRelatorioASalvar, resultadoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertFalse(resultadoInclusaoSolicitacaoRelatorio.sucesso());
		Assert.assertEquals(resultadoInclusaoSolicitacaoRelatorio.obterMensagens(),
				"N�o � poss�vel realizar a opera��o. J� foi solicitado relat�rio nos �ltimos 6 meses.\n");
	}

	@Test(groups = { TiposDeTeste.SOLICITACAO_RELATORIO })
	public void servico_inclui_solicitacao_relatorio_pois_ja_passou_seis_meses_desde_a_ultima_solicitacao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		MaquinaTempo.mudarDataAtual("01/07/2016");
		SolicitacaoRelatorioDTO solicitacaoRelatorioASalvar = ContextoSolicitacaoRelatorio
				.construirSolicitacaoRelatorioDTO();
		solicitacaoRelatorioASalvar.setFinalidadesRelatoriosDto(Arrays.asList(new FinalidadeRelatorioDTO("ATESTADO")));
		solicitacaoRelatorioASalvar.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoA());

		ResultadoEdicaoSolicitacaoRelatorioDTO resultadoInclusaoSolicitacaoRelatorio = servicoSisLaraServerRmi
				.editarSolicitacaoRelatorio(solicitacaoRelatorioASalvar, resultadoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertTrue(resultadoInclusaoSolicitacaoRelatorio.sucesso());
	}

	@Test(groups = { TiposDeTeste.SOLICITACAO_RELATORIO })
	public void servico_inclui_solicitacao_relatorio_com_menos_de_seis_meses_e_finalidade_inss()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		MaquinaTempo.mudarDataAtual("01/01/2016");
		SolicitacaoRelatorioDTO solicitacaoRelatorioASalvar = ContextoSolicitacaoRelatorio
				.construirSolicitacaoRelatorioDTO();
		solicitacaoRelatorioASalvar.setFinalidadesRelatoriosDto(Arrays.asList(new FinalidadeRelatorioDTO("INSS")));
		solicitacaoRelatorioASalvar.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoA());

		ResultadoEdicaoSolicitacaoRelatorioDTO resultadoInclusaoSolicitacaoRelatorio = servicoSisLaraServerRmi
				.editarSolicitacaoRelatorio(solicitacaoRelatorioASalvar, resultadoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertTrue(resultadoInclusaoSolicitacaoRelatorio.sucesso());
	}

	@Test(groups = { TiposDeTeste.SOLICITACAO_RELATORIO })
	public void servico_inclui_solicitacao_relatorio_com_menos_de_seis_meses_elaborado_pela_ortoptica()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		MaquinaTempo.mudarDataAtual("01/01/2016");
		SolicitacaoRelatorioDTO solicitacaoRelatorioASalvar = ContextoSolicitacaoRelatorio
				.construirSolicitacaoRelatorioDTO();
		solicitacaoRelatorioASalvar.setElaboradorDto(new ElaboradorDTO("ORTOPTICA"));
		solicitacaoRelatorioASalvar.setFinalidadesRelatoriosDto(Arrays.asList(new FinalidadeRelatorioDTO("ATESTADO")));
		solicitacaoRelatorioASalvar.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoA());

		ResultadoEdicaoSolicitacaoRelatorioDTO resultadoInclusaoSolicitacaoRelatorio = servicoSisLaraServerRmi
				.editarSolicitacaoRelatorio(solicitacaoRelatorioASalvar, resultadoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertTrue(resultadoInclusaoSolicitacaoRelatorio.sucesso());
	}

	@Test(groups = { TiposDeTeste.SOLICITACAO_RELATORIO })
	public void servico_inclui_solicitacao_relatorio_com_menos_de_seis_meses_elaborado_pela_oftalmologia_com_existencia_de_outra_solicitacao_de_elaboracao_da_ortoptica()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		MaquinaTempo.mudarDataAtual("01/01/2016");
		SolicitacaoRelatorioDTO solicitacaoRelatorioOrtopticaASalvar = ContextoSolicitacaoRelatorio
				.construirSolicitacaoRelatorioDTO();
		solicitacaoRelatorioOrtopticaASalvar.setElaboradorDto(new ElaboradorDTO("ORTOPTICA"));
		solicitacaoRelatorioOrtopticaASalvar
				.setFinalidadesRelatoriosDto(Arrays.asList(new FinalidadeRelatorioDTO("ATESTADO")));
		solicitacaoRelatorioOrtopticaASalvar
				.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoB());

		SolicitacaoRelatorioDTO solicitacaoRelatorioOftalmologiaASalvar = ContextoSolicitacaoRelatorio
				.construirSolicitacaoRelatorioDTO();
		solicitacaoRelatorioOftalmologiaASalvar.setElaboradorDto(new ElaboradorDTO("OFTALMOLOGIA"));
		solicitacaoRelatorioOftalmologiaASalvar
				.setFinalidadesRelatoriosDto(Arrays.asList(new FinalidadeRelatorioDTO("ATESTADO")));
		solicitacaoRelatorioOftalmologiaASalvar
				.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoB());

		ResultadoEdicaoSolicitacaoRelatorioDTO resultadoInclusaoSolicitacaoRelatorioOrtoptica = servicoSisLaraServerRmi
				.editarSolicitacaoRelatorio(solicitacaoRelatorioOrtopticaASalvar, resultadoDto.getToken());

		ResultadoEdicaoSolicitacaoRelatorioDTO resultadoInclusaoSolicitacaoRelatorioOftalmologia = servicoSisLaraServerRmi
				.editarSolicitacaoRelatorio(solicitacaoRelatorioOftalmologiaASalvar, resultadoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertTrue(resultadoInclusaoSolicitacaoRelatorioOrtoptica.sucesso());
		Assert.assertTrue(resultadoInclusaoSolicitacaoRelatorioOftalmologia.sucesso());
	}

	@Test(groups = { TiposDeTeste.SOLICITACAO_RELATORIO })
	public void servico_efetua_encaminhamento_recepcao_da_solicitacao_relatorio_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		SolicitacaoRelatorioDTO solicitacaoRelatorioASalvar = ContextoSolicitacaoRelatorio
				.construirSolicitacaoRelatorioDTO();

		ResultadoEdicaoSolicitacaoRelatorioDTO resultadoEncaminhamentoPelaRecepcaoDeSolicitacaoRelatorio = servicoSisLaraServerRmi
				.efetuarEncaminhamentoRecepcao(solicitacaoRelatorioASalvar, resultadoDto.getToken());

		Assert.assertTrue(resultadoEncaminhamentoPelaRecepcaoDeSolicitacaoRelatorio.sucesso());
	}

	@Test(groups = { TiposDeTeste.SOLICITACAO_RELATORIO })
	public void servico_efetua_emissao_profissional_da_solicitacao_relatorio_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		SolicitacaoRelatorioDTO solicitacaoRelatorioASalvar = ContextoSolicitacaoRelatorio
				.construirSolicitacaoRelatorioDTO();

		ResultadoEdicaoSolicitacaoRelatorioDTO resultadoEmissaoProfissionalSolicitacaoRelatorio = servicoSisLaraServerRmi
				.efetuarEmissaoProfissional(solicitacaoRelatorioASalvar, resultadoDto.getToken());

		Assert.assertTrue(resultadoEmissaoProfissionalSolicitacaoRelatorio.sucesso());
	}

	@Test(groups = { TiposDeTeste.SOLICITACAO_RELATORIO })
	public void servico_efetua_entrega_da_solicitacao_relatorio_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		SolicitacaoRelatorioDTO solicitacaoRelatorioASalvar = ContextoSolicitacaoRelatorio
				.construirSolicitacaoRelatorioDTO();
		solicitacaoRelatorioASalvar.setStatusDaEntrega(
				new StatusSolicitacaoRelatorioDTO(StatusSolicitacaoRelatorio.ENTREGUE_PARA_FAMILIA.toString()));

		ResultadoEdicaoSolicitacaoRelatorioDTO resultadoEntregaSolicitacaoRelatorio = servicoSisLaraServerRmi
				.efetuarEntrega(solicitacaoRelatorioASalvar, resultadoDto.getToken());

		Assert.assertTrue(resultadoEntregaSolicitacaoRelatorio.sucesso());
	}

	@Test(groups = { TiposDeTeste.SOLICITACAO_RELATORIO })
	public void servico_efetua_cancelamento_da_solicitacao_relatorio_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		SolicitacaoRelatorioDTO solicitacaoRelatorioASalvar = ContextoSolicitacaoRelatorio
				.construirSolicitacaoRelatorioDTO();

		ResultadoEdicaoSolicitacaoRelatorioDTO resultadoEntregaSolicitacaoRelatorio = servicoSisLaraServerRmi
				.efetuarCancelamento(solicitacaoRelatorioASalvar, resultadoDto.getToken());

		Assert.assertTrue(resultadoEntregaSolicitacaoRelatorio.sucesso());
	}

	@Test(groups = { TiposDeTeste.SOLICITACAO_RELATORIO })
	public void servico_nao_efetua_cancelamento_da_solicitacao_relatorio_sem_usuario() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		SolicitacaoRelatorioDTO solicitacaoRelatorioASalvar = ContextoSolicitacaoRelatorio
				.construirSolicitacaoRelatorioDTO();
		solicitacaoRelatorioASalvar.setUsuarioDto(null);

		ResultadoEdicaoSolicitacaoRelatorioDTO resultadoEntregaSolicitacaoRelatorio = servicoSisLaraServerRmi
				.efetuarCancelamento(solicitacaoRelatorioASalvar, resultadoDto.getToken());

		Assert.assertFalse(resultadoEntregaSolicitacaoRelatorio.sucesso());
		Assert.assertEquals(resultadoEntregaSolicitacaoRelatorio.obterMensagens(), "Insira um Usu�rio.\n\n");
	}

	@Test(groups = { TiposDeTeste.SOLICITACAO_RELATORIO })
	public void servico_nao_efetua_emissao_da_solicitacao_relatorio_sem_usuario() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		SolicitacaoRelatorioDTO solicitacaoRelatorioASalvar = ContextoSolicitacaoRelatorio
				.construirSolicitacaoRelatorioDTO();
		solicitacaoRelatorioASalvar.setUsuarioDto(null);

		ResultadoEdicaoSolicitacaoRelatorioDTO resultadoEntregaSolicitacaoRelatorio = servicoSisLaraServerRmi
				.efetuarEmissaoProfissional(solicitacaoRelatorioASalvar, resultadoDto.getToken());

		Assert.assertFalse(resultadoEntregaSolicitacaoRelatorio.sucesso());
		Assert.assertEquals(resultadoEntregaSolicitacaoRelatorio.obterMensagens(), "Insira um Usu�rio.\n\n");
	}

	@Test(groups = { TiposDeTeste.SOLICITACAO_RELATORIO })
	public void servico_nao_efetua_encaminhamento_da_solicitacao_relatorio_sem_usuario() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		SolicitacaoRelatorioDTO solicitacaoRelatorioASalvar = ContextoSolicitacaoRelatorio
				.construirSolicitacaoRelatorioDTO();
		solicitacaoRelatorioASalvar.setUsuarioDto(null);

		ResultadoEdicaoSolicitacaoRelatorioDTO resultadoEntregaSolicitacaoRelatorio = servicoSisLaraServerRmi
				.efetuarEncaminhamentoRecepcao(solicitacaoRelatorioASalvar, resultadoDto.getToken());

		Assert.assertFalse(resultadoEntregaSolicitacaoRelatorio.sucesso());
		Assert.assertEquals(resultadoEntregaSolicitacaoRelatorio.obterMensagens(), "Insira um Usu�rio.\n\n");
	}

	@Test(groups = { TiposDeTeste.SOLICITACAO_RELATORIO })
	public void servico_nao_efetua_entrega_da_solicitacao_relatorio_sem_usuario() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		SolicitacaoRelatorioDTO solicitacaoRelatorioASalvar = ContextoSolicitacaoRelatorio
				.construirSolicitacaoRelatorioDTO();
		solicitacaoRelatorioASalvar.setUsuarioDto(null);

		ResultadoEdicaoSolicitacaoRelatorioDTO resultadoEntregaSolicitacaoRelatorio = servicoSisLaraServerRmi
				.efetuarEntrega(solicitacaoRelatorioASalvar, resultadoDto.getToken());

		Assert.assertFalse(resultadoEntregaSolicitacaoRelatorio.sucesso());
		Assert.assertEquals(resultadoEntregaSolicitacaoRelatorio.obterMensagens(),
				"Insira um Usu�rio.\nInsira um Status de Entrega.\n\n");
	}

	@Test(groups = { TiposDeTeste.SOLICITACAO_RELATORIO })
	public void servico_nao_inclui_solicitacao_relatorio_sem_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		SolicitacaoRelatorioDTO solicitacaoRelatorioASalvar = ContextoSolicitacaoRelatorio
				.construirSolicitacaoRelatorioDTO();

		ResultadoEdicaoSolicitacaoRelatorioDTO resultadoInclusaoSolicitacaoRelatorio = servicoSisLaraServerRmi
				.editarSolicitacaoRelatorio(solicitacaoRelatorioASalvar, resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoSolicitacaoRelatorio.sucesso());
	}

	@Test(groups = { TiposDeTeste.SOLICITACAO_RELATORIO })
	public void servico_nao_inclui_solicitacao_relatorio_sem_usuario() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		SolicitacaoRelatorioDTO solicitacaoRelatorioASalvar = ContextoSolicitacaoRelatorio
				.construirSolicitacaoRelatorioDTO();
		solicitacaoRelatorioASalvar.setUsuarioDto(null);

		ResultadoEdicaoSolicitacaoRelatorioDTO resultadoInclusaoSolicitacaoRelatorio = servicoSisLaraServerRmi
				.editarSolicitacaoRelatorio(solicitacaoRelatorioASalvar, resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoSolicitacaoRelatorio.sucesso());
		Assert.assertEquals(resultadoInclusaoSolicitacaoRelatorio.obterMensagens(), "Insira um Usu�rio.\n\n");
	}

	@Test(groups = { TiposDeTeste.PRE_CADASTRO })
	public void servico_altera_precadastro_existente() throws RemoteException {
		ResultadoAutenticacaoDTO tokenDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		PreCadastroDTO preCadastroNovaDto = ContextoPreCadastro.construirPreCadastroDTOsemIdentificacao();

		ResultadoEdicaoPreCadastroDTO resultadoInclusaoPreCadastro = servicoSisLaraServerRmi
				.editarPreCadastro(preCadastroNovaDto, tokenDto.getToken());

		InformacaoEssencialDTO informacaoEssencialDto = ((PreCadastroDTO) resultadoInclusaoPreCadastro
				.obterObjetoDtoEditado()).getInformacaoEssencialDto();
		informacaoEssencialDto.setNome("NOVO NOME");

		PreCadastroDTO preCadastroSalva = (PreCadastroDTO) resultadoInclusaoPreCadastro.obterObjetoDtoEditado();
		preCadastroSalva.setInformacaoEssencialDto(informacaoEssencialDto);

		ResultadoEdicaoPreCadastroDTO resultadoAlteracaoPreCadastro = servicoSisLaraServerRmi
				.editarPreCadastro(preCadastroSalva, tokenDto.getToken());

		Assert.assertTrue(resultadoAlteracaoPreCadastro.sucesso());
	}

	@Test(groups = { TiposDeTeste.PRE_CADASTRO })
	public void servico_nao_inclui_precadastro_com_inconsistencia() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		List<TelefoneDTO> telefonesDTOs = new ArrayList<>();
		telefonesDTOs.add(new TelefoneDTO(new TipoTelefoneDTO("CELULAR"), "12345678901234567", "1234", "Paulo"));

		PreCadastroDTO preCadastroASalvar = ContextoPreCadastro.construirPreCadastroDTOsemIdentificacao();
		preCadastroASalvar.getInformacaoEssencialDto().getContatoDto().setTelefonesDto(telefonesDTOs);

		ResultadoEdicaoPreCadastroDTO resultadoInclusaoPreCadastro = servicoSisLaraServerRmi
				.editarPreCadastro(preCadastroASalvar, resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoPreCadastro.sucesso());
		Assert.assertNotNull(resultadoInclusaoPreCadastro.obterMensagens());
	}

	@Test(groups = { TiposDeTeste.PRE_CADASTRO })
	public void servico_nao_inclui_precadastro_com_rg_duplicado() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		PreCadastroDTO preCadastroASalvar = ContextoPreCadastro.construirPreCadastroDTOsemIdentificacao();

		servicoSisLaraServerRmi.editarPreCadastro(preCadastroASalvar, resultadoDto.getToken());

		PreCadastroDTO preCadastroASalvarComRGRepetido = ContextoPreCadastro.construirPreCadastroDTOsemIdentificacao();
		preCadastroASalvarComRGRepetido.getInformacaoEssencialDto().setCpf("22804540170");

		ResultadoEdicaoPreCadastroDTO resultadoInclusaoPreCadastro = servicoSisLaraServerRmi
				.editarPreCadastro(preCadastroASalvarComRGRepetido, resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoPreCadastro.sucesso());
		Assert.assertEquals(resultadoInclusaoPreCadastro.obterMensagens(), "O RG do Usu�rio j� est� Pr� Cadastrado.\n");
	}

	@Test(groups = { TiposDeTeste.PRE_CADASTRO })
	public void servico_inclui_precadastro_sem_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		PreCadastroDTO preCadastroASalvar = ContextoPreCadastro.construirPreCadastroDTO();
		ResultadoEdicaoPreCadastroDTO resultadoInclusaoPreCadastro = servicoSisLaraServerRmi
				.editarPreCadastro(preCadastroASalvar, resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoPreCadastro.sucesso());
		Assert.assertNotNull(resultadoInclusaoPreCadastro.obterMensagens());
	}

	@Test(groups = { TiposDeTeste.PRE_CADASTRO })
	public void servico_efetua_pesquisa_por_precadastro_a_partir_de_especificacao_vazia() throws RemoteException {
		EspecificacaoPesquisaPreCadastroDTO especificacao = new EspecificacaoPesquisaPreCadastroDTO();

		ResultadoListagemPreCadastroDTO resultadoDto = servicoSisLaraServerRmi.pesquisarPreCadastroPor(especificacao);

		Assert.assertFalse(resultadoDto.sucesso());
		Assert.assertFalse(resultadoDto.obterMensagens().isEmpty());
	}

	@Test(groups = { TiposDeTeste.PRE_CADASTRO })
	public void servico_efetua_pesquisa_por_precadastro_inexistentes_a_partir_de_nome() throws RemoteException {
		EspecificacaoPesquisaPreCadastroDTO especificacao = new EspecificacaoPesquisaPreCadastroDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.PRE_CADASTRO, "Pre-Cadastro NOVO");

		ResultadoListagemPreCadastroDTO resultadoDto = servicoSisLaraServerRmi.pesquisarPreCadastroPor(especificacao);

		Assert.assertTrue(resultadoDto.getObjetosDto().isEmpty());
	}

	@Test(groups = { TiposDeTeste.PRE_CADASTRO })
	public void servico_efetua_pesquisa_por_precadastro_inexistentes_a_partir_de_rg() throws RemoteException {
		EspecificacaoPesquisaPreCadastroDTO especificacao = new EspecificacaoPesquisaPreCadastroDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.RG, "2323232");

		ResultadoListagemPreCadastroDTO resultadoDto = servicoSisLaraServerRmi.pesquisarPreCadastroPor(especificacao);

		Assert.assertTrue(resultadoDto.getObjetosDto().isEmpty());
	}

	@Test(groups = { TiposDeTeste.PRE_CADASTRO })
	public void servico_efetua_pesquisa_por_precadastro_existente_a_partir_de_rg() throws RemoteException {
		EspecificacaoPesquisaPreCadastroDTO especificacao = new EspecificacaoPesquisaPreCadastroDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.RG, "384744");

		ResultadoListagemPreCadastroDTO resultadoDto = servicoSisLaraServerRmi.pesquisarPreCadastroPor(especificacao);

		Assert.assertTrue(resultadoDto.sucesso());
		Assert.assertEquals(resultadoDto.getObjetosDto().size(), 2);
	}

	@Test(groups = { TiposDeTeste.PRE_CADASTRO })
	public void servico_efetua_pesquisa_por_precadastro_existente_a_partir_de_cpf() throws RemoteException {
		EspecificacaoPesquisaPreCadastroDTO especificacao = new EspecificacaoPesquisaPreCadastroDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.CPF, "71894810287");

		ResultadoListagemPreCadastroDTO resultadoDto = servicoSisLaraServerRmi.pesquisarPreCadastroPor(especificacao);

		Assert.assertTrue(resultadoDto.sucesso());
		Assert.assertEquals(resultadoDto.getObjetosDto().size(), 1);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_tipoatendimento() throws RemoteException {
		ResultadoListagemTipoAtendimentoDTO resultadoListagemTipoAtendimento = servicoSisLaraServerRmi
				.obterListagemTipoAtendimento();

		Assert.assertTrue(resultadoListagemTipoAtendimento.sucesso());
		Assert.assertEquals(resultadoListagemTipoAtendimento.getObjetosDto().size(), 8,
				"A lista deveria conter 8 itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_parentesco() throws RemoteException {
		ResultadoListagemParentescoDTO resultadoListagemParentesco = servicoSisLaraServerRmi.obterListagemParentesco();

		Assert.assertTrue(resultadoListagemParentesco.sucesso());
		Assert.assertFalse(resultadoListagemParentesco.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_com_erro_diasemanaehorario() throws RemoteException {
		DiaSemanaEHorarioDTO diaSemanaEHorarioDto = new DiaSemanaEHorarioDTO();
		ResultadoValidacaoDiaSemanaEHorarioDTO resultadoValidacaoDiaSemanaEHorarioDTOS = servicoSisLaraServerRmi
				.validarDiaSemanaEHorario(diaSemanaEHorarioDto);

		Assert.assertFalse(resultadoValidacaoDiaSemanaEHorarioDTOS.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_sem_erro_diasemanaehorario() throws RemoteException {
		DiaSemanaEHorarioDTO diaSemanaEHorarioDto = ContextoDiasSemanaEHorarios.construirDiaSemanaEHorarioDTO();
		ResultadoValidacaoDiaSemanaEHorarioDTO resultadoValidacaoDiaSemanaEHorarioDTOS = servicoSisLaraServerRmi
				.validarDiaSemanaEHorario(diaSemanaEHorarioDto);

		Assert.assertTrue(resultadoValidacaoDiaSemanaEHorarioDTOS.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_com_erro_familiar() throws RemoteException {
		FamiliarDTO familiarDto = new FamiliarDTO();
		ResultadoValidacaoFamiliarDTO resultadoValidacaoFamiliar = servicoSisLaraServerRmi.validarFamiliar(familiarDto);

		Assert.assertFalse(resultadoValidacaoFamiliar.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_sem_erro_familiar() throws RemoteException {
		FamiliarDTO familiarDto = ContextoFamiliar.construirFamiliarDTO();
		familiarDto.setId(null);
		ResultadoValidacaoFamiliarDTO resultadoValidacaoFamiliar = servicoSisLaraServerRmi.validarFamiliar(familiarDto);

		Assert.assertTrue(resultadoValidacaoFamiliar.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_com_erro_custo() throws RemoteException {
		CustoDTO custoDto = new CustoDTO();
		ResultadoValidacaoCustoDTO resultadoValidacaoCusto = servicoSisLaraServerRmi.validarCusto(custoDto);

		Assert.assertFalse(resultadoValidacaoCusto.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_com_erro_custo_valor_errado() throws RemoteException {
		CustoDTO custoDto = ContextoCusto.fabricarCustoDTOComTodosOsDados();
		custoDto.setValor("ASKDGKA");
		ResultadoValidacaoCustoDTO resultadoValidacaoCusto = servicoSisLaraServerRmi.validarCusto(custoDto);

		Assert.assertFalse(resultadoValidacaoCusto.sucesso());
		Assert.assertEquals(resultadoValidacaoCusto.obterMensagens(), "Insira um Valor de Custo v�lido.\n\n");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_sem_erro_custo() throws RemoteException {
		CustoDTO custoDto = ContextoCusto.fabricarCustoDTOComTodosOsDados();
		ResultadoValidacaoCustoDTO resultadoValidacaoCusto = servicoSisLaraServerRmi.validarCusto(custoDto);

		Assert.assertTrue(resultadoValidacaoCusto.sucesso());
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_sem_erro_recurso_relacionamento() throws RemoteException {
		RecursoRelacionamentoDTO recursoRelacionamentoDto = ContextoRecursoRelacionamento
				.construirRecursoRelacionamentoDTO();
		ResultadoValidacaoRecursoRelacionamentoDTO resultadoValidacaoRecursoRelacionamento = servicoSisLaraServerRmi
				.validarRecursoRelacionamento(recursoRelacionamentoDto);

		Assert.assertTrue(resultadoValidacaoRecursoRelacionamento.sucesso());
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_com_erro_recurso_relacionamento() throws RemoteException {
		RecursoRelacionamentoDTO recursoRelacionamentoDto = new RecursoRelacionamentoDTO();
		ResultadoValidacaoRecursoRelacionamentoDTO resultadoValidacaoRecursoRelacionamento = servicoSisLaraServerRmi
				.validarRecursoRelacionamento(recursoRelacionamentoDto);

		Assert.assertFalse(resultadoValidacaoRecursoRelacionamento.sucesso());
		Assert.assertNotNull(resultadoValidacaoRecursoRelacionamento.obterMensagens());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_situacao_guarda() throws RemoteException {
		ResultadoListagemSituacaoGuardaDTO resultadoListagemSituacaoGuarda = servicoSisLaraServerRmi
				.obterListagemSituacaoGuarda();

		Assert.assertTrue(resultadoListagemSituacaoGuarda.sucesso());
		Assert.assertFalse(resultadoListagemSituacaoGuarda.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_beneficio() throws RemoteException {
		ResultadoListagemBeneficioDTO resultadoListagemBeneficio = servicoSisLaraServerRmi.obterListagemBeneficio();

		Assert.assertTrue(resultadoListagemBeneficio.sucesso());
		Assert.assertFalse(resultadoListagemBeneficio.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_deficiencia() throws RemoteException {
		ResultadoListagemDeficienciaDTO resultadoListagemDeficiencia = servicoSisLaraServerRmi
				.obterListagemDeficiencia();

		Assert.assertTrue(resultadoListagemDeficiencia.sucesso());
		Assert.assertFalse(resultadoListagemDeficiencia.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_doenca() throws RemoteException {
		ResultadoListagemDoencaDTO resultadoListagemDoenca = servicoSisLaraServerRmi.obterListagemDoenca();

		Assert.assertTrue(resultadoListagemDoenca.sucesso());
		Assert.assertFalse(resultadoListagemDoenca.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_comprometimento() throws RemoteException {
		ResultadoListagemComprometimentoDTO resultadoListagemComprometimento = servicoSisLaraServerRmi.obterListagemComprometimento();

		Assert.assertTrue(resultadoListagemComprometimento.sucesso());
		Assert.assertFalse(resultadoListagemComprometimento.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_convenio() throws RemoteException {
		ResultadoListagemConvenioDTO resultadoListagemConvenio = servicoSisLaraServerRmi.obterListagemConvenio();

		Assert.assertTrue(resultadoListagemConvenio.sucesso());
		Assert.assertFalse(resultadoListagemConvenio.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_com_erro_informacao_educacional() throws RemoteException {
		InformacaoEducacionalDTO informacaoEducacionalDto = new InformacaoEducacionalDTO();
		ResultadoValidacaoInformacaoEducacionalDTO resultadoValidacaoInformacaoEscolar = servicoSisLaraServerRmi
				.validarInformacaoEducacional(informacaoEducacionalDto);

		Assert.assertFalse(resultadoValidacaoInformacaoEscolar.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_sem_erro_informacao_educacional() throws RemoteException {
		InformacaoEducacionalDTO informacaoEducacionalDto = ContextoInformacaoEducacional
				.construirInformacaoEducacionalDTO();
		ResultadoValidacaoInformacaoEducacionalDTO resultadoValidacaoInformacaoEscolar = servicoSisLaraServerRmi
				.validarInformacaoEducacional(informacaoEducacionalDto);

		Assert.assertTrue(resultadoValidacaoInformacaoEscolar.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_tipo_telefone() throws RemoteException {
		ResultadoListagemTipoTelefoneDTO resultadoListagemTipoTelefone = servicoSisLaraServerRmi
				.obterListagemTipoTelefone();

		Assert.assertTrue(resultadoListagemTipoTelefone.sucesso());
		Assert.assertFalse(resultadoListagemTipoTelefone.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_sem_erro_telefone() throws RemoteException {
		TelefoneDTO telefoneDto = ContextoTelefone.construirTelefoneDTO();
		ResultadoValidacaoTelefoneDTO resultadoValidacaoTelefone = servicoSisLaraServerRmi.validarTelefone(telefoneDto);

		Assert.assertTrue(resultadoValidacaoTelefone.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_com_erro_telefone() throws RemoteException {
		TelefoneDTO telefoneDto = ContextoTelefone.construirTelefoneDTOIncompleto();
		ResultadoValidacaoTelefoneDTO resultadoValidacaoTelefone = servicoSisLaraServerRmi.validarTelefone(telefoneDto);

		Assert.assertFalse(resultadoValidacaoTelefone.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_sem_erro_certidao() throws RemoteException {
		CertidaoDTO cetidaoDto = ContextoCertidao.fabricarCertidaoDTOComTodosOsDados();
		ResultadoValidacaoCertidaoDTO resultadoValidacaoCertidao = servicoSisLaraServerRmi.validarCertidao(cetidaoDto);

		Assert.assertTrue(resultadoValidacaoCertidao.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_com_erro_certidao() throws RemoteException {
		CertidaoDTO cetidaoDto = new CertidaoDTO();
		ResultadoValidacaoCertidaoDTO resultadoValidacaoCertidao = servicoSisLaraServerRmi.validarCertidao(cetidaoDto);

		Assert.assertFalse(resultadoValidacaoCertidao.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_sem_erro_informacao_trabalho_completa() throws RemoteException {
		InformacaoTrabalhoCompletaDTO informacaoTrabalhoCompletaDto = ContextoInformacaoTrabalhoCompleta
				.fabricarInformacaoTrabalhoDTOCompletaComTodosOsDados();
		ResultadoValidacaoInformacaoTrabalhoCompletaDTO resultadoValidacaoInformacaoTrabalhoCompleta = servicoSisLaraServerRmi
				.validarInformacaoTrabalhoCompleta(informacaoTrabalhoCompletaDto);

		Assert.assertTrue(resultadoValidacaoInformacaoTrabalhoCompleta.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_com_erro_informacao_trabalho_completa() throws RemoteException {
		InformacaoTrabalhoCompletaDTO informacaoTrabalhoCompletaDto = new InformacaoTrabalhoCompletaDTO();
		ResultadoValidacaoInformacaoTrabalhoCompletaDTO resultadoValidacaoInformacaoTrabalhoCompleta = servicoSisLaraServerRmi
				.validarInformacaoTrabalhoCompleta(informacaoTrabalhoCompletaDto);

		Assert.assertFalse(resultadoValidacaoInformacaoTrabalhoCompleta.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_sem_erro_periodo_beneficio() throws RemoteException {
		PeriodoBeneficioDTO periodoBeneficioDto = ContextoPeriodoBeneficio.construirPeriodoBeneficioDTO();
		ResultadoValidacaoPeriodoBeneficioDTO resultadoValidacaoPeriodoBeneficio = servicoSisLaraServerRmi
				.validarPeriodoBeneficio(periodoBeneficioDto);

		Assert.assertTrue(resultadoValidacaoPeriodoBeneficio.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_com_erro_periodo_beneficio() throws RemoteException {
		PeriodoBeneficioDTO periodoBeneficioDto = new PeriodoBeneficioDTO();
		ResultadoValidacaoPeriodoBeneficioDTO resultadoValidacaoPeriodoBeneficio = servicoSisLaraServerRmi
				.validarPeriodoBeneficio(periodoBeneficioDto);

		Assert.assertFalse(resultadoValidacaoPeriodoBeneficio.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_sem_erro_periodo_deficiencia() throws RemoteException {
		PeriodoDeficienciaDTO periodoDeficienciaDto = ContextoPeriodoDeficiencia.construirPeriodoDeficienciaDTO();
		ResultadoValidacaoPeriodoDeficienciaDTO resultadoValidacaoPeriodoBeneficio = servicoSisLaraServerRmi
				.validarPeriodoDeficiencia(periodoDeficienciaDto);

		Assert.assertTrue(resultadoValidacaoPeriodoBeneficio.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_com_erro_periodo_deficiencia() throws RemoteException {
		PeriodoDeficienciaDTO periodoDeficienciaDto = new PeriodoDeficienciaDTO();
		ResultadoValidacaoPeriodoDeficienciaDTO resultadoValidacaoPeriodoDeficiencia = servicoSisLaraServerRmi
				.validarPeriodoDeficiencia(periodoDeficienciaDto);

		Assert.assertFalse(resultadoValidacaoPeriodoDeficiencia.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_sem_erro_periodo_doenca() throws RemoteException {
		PeriodoDoencaDTO periodoDoencaDto = ContextoPeriodoDoenca.construirPeriodoDoencaDTO();
		ResultadoValidacaoPeriodoDoencaDTO resultadoValidacaoPeriodoDoenca = servicoSisLaraServerRmi
				.validarPeriodoDoenca(periodoDoencaDto);

		Assert.assertTrue(resultadoValidacaoPeriodoDoenca.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_com_erro_periodo_doenca() throws RemoteException {
		PeriodoDoencaDTO periodoDoencaDto = new PeriodoDoencaDTO();
		ResultadoValidacaoPeriodoDoencaDTO resultadoValidacaoPeriodoDoenca = servicoSisLaraServerRmi
				.validarPeriodoDoenca(periodoDoencaDto);

		Assert.assertFalse(resultadoValidacaoPeriodoDoenca.sucesso());
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_sem_erro_periodo_comprometimento() throws RemoteException {
		PeriodoComprometimentoDTO periodoComrpometimentoDto = ContextoPeriodoComprometimento.construirPeriodoComprometimentoDTO();
		ResultadoValidacaoPeriodoComprometimentoDTO resultadoValidacaoPeriodoComprometimento = servicoSisLaraServerRmi
				.validarPeriodoComprometimento(periodoComrpometimentoDto);

		Assert.assertTrue(resultadoValidacaoPeriodoComprometimento.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_com_erro_periodo_comprometimento() throws RemoteException {
		PeriodoComprometimentoDTO periodoComprometimentoDto = new PeriodoComprometimentoDTO();
		ResultadoValidacaoPeriodoComprometimentoDTO resultadoValidacaoPeriodoComprometimento = servicoSisLaraServerRmi
				.validarPeriodoComprometimento(periodoComprometimentoDto);

		Assert.assertFalse(resultadoValidacaoPeriodoComprometimento.sucesso());
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_bloqueia_prontuario_em_edicao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoAutenticacaoDTO resultado2Dto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoRLemeDtoValida());

		UsuarioDTO usuarioDTO = new UsuarioDTO(new Long(12345));

		servicoSisLaraServerRmi.bloquearEdicao(usuarioDTO.obterNome(), resultadoDto.getToken());

		Assert.assertTrue(
				servicoSisLaraServerRmi.estaBloqueadoParaEdicao(usuarioDTO.obterNome(), resultado2Dto.getToken()));
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_bloqueia_grupo_em_edicao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoAutenticacaoDTO resultado2Dto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoRLemeDtoValida());

		GrupoDTO grupoDTO = new GrupoDTO();
		grupoDTO.setId(new Long(232323));
		grupoDTO.setNomeGrupoDto(new NomeGrupoDTO(new Long(1002), "G02"));
		grupoDTO.setTurma("02");
		grupoDTO.setDataInicio("31/12/2012");

		servicoSisLaraServerRmi.bloquearEdicao(grupoDTO.obterNome(), resultadoDto.getToken());

		Assert.assertTrue(
				servicoSisLaraServerRmi.estaBloqueadoParaEdicao(grupoDTO.obterNome(), resultado2Dto.getToken()));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_adiciona_e_remove_bloqueio_usuario_em_edicao_com_identificacao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		UsuarioDTO usuarioDTO = new UsuarioDTO(new Long(12345));

		servicoSisLaraServerRmi.bloquearEdicao(usuarioDTO.obterNome(), resultadoDto.getToken());

		servicoSisLaraServerRmi.desbloquearEdicaoGeral(new GeralContaAcessoBloqueadoDTO(usuarioDTO.obterNome(), null),
				resultadoDto.getToken());

		Assert.assertFalse(
				servicoSisLaraServerRmi.estaBloqueadoParaEdicao(usuarioDTO.obterNome(), resultadoDto.getToken()));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_adiciona_e_remove_bloqueio_usuario_em_edicao_com_dto() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		UsuarioDTO usuarioDTO = new UsuarioDTO(new Long(344444));

		servicoSisLaraServerRmi.bloquearEdicao(usuarioDTO.obterNome(), resultadoDto.getToken());

		servicoSisLaraServerRmi.desbloquearEdicao(usuarioDTO.obterNome(), resultadoDto.getToken());

		Assert.assertFalse(
				servicoSisLaraServerRmi.estaBloqueadoParaEdicao(usuarioDTO.obterNome(), resultadoDto.getToken()));
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_adiciona_e_remove_bloqueio_grupo_em_edicao_com_identificacao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		GrupoDTO grupoDTO = new GrupoDTO();
		grupoDTO.setId(new Long(232323));
		grupoDTO.setNomeGrupoDto(new NomeGrupoDTO(new Long(1002), "G02"));
		grupoDTO.setTurma("02");
		grupoDTO.setDataInicio("31/12/2012");

		servicoSisLaraServerRmi.bloquearEdicao(grupoDTO.obterNome(), resultadoDto.getToken());

		servicoSisLaraServerRmi.desbloquearEdicao(grupoDTO.obterNome(), resultadoDto.getToken());

		Assert.assertFalse(
				servicoSisLaraServerRmi.estaBloqueadoParaEdicao(grupoDTO.obterNome(), resultadoDto.getToken()));
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_adiciona_e_remove_bloqueio_grupo_em_edicao_com_dto() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		GrupoDTO grupoDTO = new GrupoDTO();
		grupoDTO.setId(new Long(2222));
		grupoDTO.setNomeGrupoDto(new NomeGrupoDTO(new Long(1002), "G02"));
		grupoDTO.setTurma("02");
		grupoDTO.setDataInicio("31/12/2012");

		servicoSisLaraServerRmi.bloquearEdicao(grupoDTO.obterNome(), resultadoDto.getToken());

		servicoSisLaraServerRmi.desbloquearEdicao(grupoDTO.obterNome(), resultadoDto.getToken());

		Assert.assertFalse(
				servicoSisLaraServerRmi.estaBloqueadoParaEdicao(grupoDTO.obterNome(), resultadoDto.getToken()));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_obtem_conta_acesso_editando_prontuario() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		UsuarioDTO usuarioDTO = new UsuarioDTO(new Long(12345));

		servicoSisLaraServerRmi.bloquearEdicao(usuarioDTO.obterNome(), resultadoDto.getToken());

		ResultadoCoordenacaoEdicaoDTO nomeContaAcessoAlterandoUsuario = servicoSisLaraServerRmi
				.obterContaAcessoEditando(usuarioDTO.obterNome());

		Assert.assertTrue(nomeContaAcessoAlterandoUsuario.sucesso());
		Assert.assertEquals(nomeContaAcessoAlterandoUsuario.obterMensagens(),
				"O item est� sendo editado pelo(a): pabsantos\n");
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_obtem_conta_acesso_editando_grupo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		GrupoDTO grupoDTO = new GrupoDTO();
		grupoDTO.setId(new Long(1222));
		grupoDTO.setNomeGrupoDto(new NomeGrupoDTO(new Long(1002), "G2"));
		grupoDTO.setTurma("03");
		grupoDTO.setDataInicio("31/12/2012");

		servicoSisLaraServerRmi.bloquearEdicao(grupoDTO.obterNome(), resultadoDto.getToken());

		ResultadoCoordenacaoEdicaoDTO nomeContaAcessoAlterandoGrupo = servicoSisLaraServerRmi
				.obterContaAcessoEditando(grupoDTO.obterNome());

		Assert.assertTrue(nomeContaAcessoAlterandoGrupo.sucesso());
		Assert.assertEquals(nomeContaAcessoAlterandoGrupo.obterMensagens(),
				"O item est� sendo editado pelo(a): pabsantos\n");
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_nao_bloqueia_grupo_sendo_editado_por_mesmo_usuario() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		GrupoDTO grupoDTO = new GrupoDTO();
		grupoDTO.setId(new Long(1222));
		grupoDTO.setNomeGrupoDto(new NomeGrupoDTO(new Long(1002), "G2"));
		grupoDTO.setTurma("03");
		grupoDTO.setDataInicio("31/12/2012");

		servicoSisLaraServerRmi.bloquearEdicao(grupoDTO.obterNome(), resultadoDto.getToken());

		Assert.assertFalse(
				servicoSisLaraServerRmi.estaBloqueadoParaEdicao(grupoDTO.obterNome(), resultadoDto.getToken()));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_nao_bloqueia_usuario_sendo_editado_por_mesmo_usuario() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		UsuarioDTO usuarioDTO = new UsuarioDTO(new Long(12345));

		servicoSisLaraServerRmi.bloquearEdicao(usuarioDTO.obterNome(), resultadoDto.getToken());

		Assert.assertFalse(
				servicoSisLaraServerRmi.estaBloqueadoParaEdicao(usuarioDTO.obterNome(), resultadoDto.getToken()));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_obtem_usuarios_conta_acesso_bloqueados_para_edicao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoAutenticacaoDTO resultadoDto2 = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoRLemeDtoValida());

		UsuarioDTO usuarioDTO = new UsuarioDTO(new Long(12345));

		servicoSisLaraServerRmi.bloquearEdicao(usuarioDTO.obterNome(), resultadoDto.getToken());

		UsuarioDTO usuarioDTO2 = new UsuarioDTO(new Long(123456));
		servicoSisLaraServerRmi.bloquearEdicao(usuarioDTO2.obterNome(), resultadoDto2.getToken());

		ResultadoListagemGeralBloqueadosDTO resultadoListagemBloqueadosDTO = servicoSisLaraServerRmi
				.obterListagemBloqueados();

		Assert.assertTrue(resultadoListagemBloqueadosDTO.sucesso());
		Assert.assertEquals(resultadoListagemBloqueadosDTO.getObjetosDto().size(), 2);
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_obtem_grupos_conta_acesso_bloqueados_para_edicao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoAutenticacaoDTO resultadoDto2 = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoRLemeDtoValida());

		GrupoDTO grupoDTO = new GrupoDTO();
		grupoDTO.setId(new Long(233333));
		grupoDTO.setNomeGrupoDto(new NomeGrupoDTO(new Long(1002), "G2"));
		grupoDTO.setTurma("22");
		grupoDTO.setDataInicio("31/12/2012");

		servicoSisLaraServerRmi.bloquearEdicao(grupoDTO.obterNome(), resultadoDto.getToken());

		GrupoDTO grupoDTO2 = new GrupoDTO();
		grupoDTO2.setId(new Long(12223));
		grupoDTO2.setNomeGrupoDto(new NomeGrupoDTO(new Long(1002), "G2"));
		grupoDTO2.setTurma("12");
		grupoDTO2.setDataInicio("11/12/2012");

		servicoSisLaraServerRmi.bloquearEdicao(grupoDTO2.obterNome(), resultadoDto.getToken());

		GrupoDTO grupoDTO3 = new GrupoDTO();
		grupoDTO3.setId(new Long(12223));
		grupoDTO3.setNomeGrupoDto(new NomeGrupoDTO(new Long(1002), "G1"));
		grupoDTO3.setTurma("1");
		grupoDTO3.setDataInicio("10/12/2012");

		servicoSisLaraServerRmi.bloquearEdicao(grupoDTO3.obterNome(), resultadoDto2.getToken());

		ResultadoListagemGeralBloqueadosDTO resultadoListagemGeralBloqueadosDTO = servicoSisLaraServerRmi
				.obterListagemBloqueados();

		Assert.assertTrue(resultadoListagemGeralBloqueadosDTO.sucesso());
		Assert.assertEquals(resultadoListagemGeralBloqueadosDTO.getObjetosDto().size(), 2);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_todos_grupos_ativos_a_partir_nome() throws RemoteException {
		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");

		Assert.assertTrue(resultadoListagemGrupo.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemGrupo.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_nenhum_grupos_ativos_a_partir_nome() throws RemoteException {
		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("XXX");

		Assert.assertFalse(resultadoListagemGrupo.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_mais_de_um_grupos_ativos_a_partir_nome() throws RemoteException {
		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G04-1");

		Assert.assertFalse(resultadoListagemGrupo.sucesso());
		Assert.assertEquals(resultadoListagemGrupo.obterMensagens(), "Mais de um grupo foi encontrado.\n");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_local_atendimento() throws RemoteException {
		ResultadoListagemLocalAtendimentoDTO resultadoListagemLocalAtendimento = servicoSisLaraServerRmi
				.obterListagemLocalAtendimento();

		Assert.assertTrue(resultadoListagemLocalAtendimento.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemLocalAtendimento.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_tipodescricaoevento_com_sucesso() throws RemoteException {
		ResultadoListagemTipoDescricaoEventoDTO resultadoListagemTipoDescricaoEventoDTO = servicoSisLaraServerRmi
				.obterListagemTipoDescricaoEvento();

		Assert.assertTrue(resultadoListagemTipoDescricaoEventoDTO.sucesso());
		Assert.assertEquals(resultadoListagemTipoDescricaoEventoDTO.getObjetosDto().size(), 11);
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_descricao_evento_com_erro() throws RemoteException {
		DescricaoEventoDTO descricaoEventoDto = new DescricaoEventoDTO();
		ResultadoValidacaoDescricaoEventoDTO resultadoValidacaoDescricaoEventoDTO = servicoSisLaraServerRmi
				.validarDescricaoEvento(descricaoEventoDto);

		Assert.assertFalse(resultadoValidacaoDescricaoEventoDTO.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_descricao_evento_sem_erro() throws RemoteException {
		DescricaoEventoDTO descricaoEventoDto = ContextoDescricaoEvento.construirDescricaoEventoDescricaoEmentaDTO();
		ResultadoValidacaoDescricaoEventoDTO resultadoValidacaoDescricaoEventoDTO = servicoSisLaraServerRmi
				.validarDescricaoEvento(descricaoEventoDto);

		Assert.assertTrue(resultadoValidacaoDescricaoEventoDTO.sucesso());
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_profissional_ativo() throws RemoteException {
		ResultadoListagemProfissionalDTO resultadoListagemProfissional = servicoSisLaraServerRmi
				.obterListagemProfissionalAtivos();

		Assert.assertTrue(resultadoListagemProfissional.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertTrue(resultadoListagemProfissional.getObjetosDto().size() == 9);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_voluntario_ativo() throws RemoteException {
		ResultadoListagemProfissionalDTO resultadoListagemVoluntario = servicoSisLaraServerRmi
				.obterListagemVoluntarioAtivos();

		Assert.assertTrue(resultadoListagemVoluntario.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertTrue(resultadoListagemVoluntario.getObjetosDto().size() == 1);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_item_custo_da_doenca() throws RemoteException {
		ResultadoListagemItensCustoDTO resultadoListagemItensCusto = servicoSisLaraServerRmi
				.obterListagemItensCustoDoenca();

		Assert.assertTrue(resultadoListagemItensCusto.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertTrue(resultadoListagemItensCusto.getObjetosDto().size() == 2);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_item_custo_da_deficiencia() throws RemoteException {
		ResultadoListagemItensCustoDTO resultadoListagemItensCusto = servicoSisLaraServerRmi
				.obterListagemItensCustoDeficiencia();

		Assert.assertTrue(resultadoListagemItensCusto.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertTrue(resultadoListagemItensCusto.getObjetosDto().size() == 2);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_todos_profissionais() throws RemoteException {
		ResultadoListagemProfissionalDTO resultadoListagemProfissional = servicoSisLaraServerRmi
				.obterListagemTodosProfissionais();

		Assert.assertTrue(resultadoListagemProfissional.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemProfissional.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_dias_semana() throws RemoteException {
		ResultadoListagemDiaSemanaDTO resultadoListagemDiaSemana = servicoSisLaraServerRmi.obterListagemDiaSemana();

		Assert.assertTrue(resultadoListagemDiaSemana.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemDiaSemana.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_empresas() throws RemoteException {
		ResultadoListagemEmpresaDTO resultadoListagemEmpresa = servicoSisLaraServerRmi.obterListagemEmpresa();

		Assert.assertTrue(resultadoListagemEmpresa.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemEmpresa.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_status_relacao_usuario_modulo_cto() throws RemoteException {
		EspecificacaoPesquisaGrupoDTO especificacaoPesquisaGrupoDTO = new EspecificacaoPesquisaGrupoDTO();
		especificacaoPesquisaGrupoDTO.adicionarParametro(ChavePesquisaDTO.GRUPOS_ATIVOS, "G");

		ResultadoListagemGrupoDTO listagemGrupoDto = servicoSisLaraServerRmi
				.pesquisarGrupoPor(especificacaoPesquisaGrupoDTO);
		ModuloPeriodoDTO moduloPeriodoDTO = obterModuloPeriodoDto(listagemGrupoDto.getObjetosDto(), new Long(14444),
				new Long(77777));

		ResultadoListagemStatusRelacaoUsuarioModuloDTO resultadoListagemStatus = servicoSisLaraServerRmi
				.obterListagemStatusRelacaoUsuarioModulo(moduloPeriodoDTO);

		Assert.assertTrue(resultadoListagemStatus.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertEquals(resultadoListagemStatus.getObjetosDto().size(), 9);
		Assert.assertFalse(resultadoListagemStatus.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_status_relacao_usuario_modulo_proceja() throws RemoteException {
		EspecificacaoPesquisaGrupoDTO especificacaoPesquisaGrupoDTO = new EspecificacaoPesquisaGrupoDTO();
		especificacaoPesquisaGrupoDTO.adicionarParametro(ChavePesquisaDTO.GRUPOS_ATIVOS, "G");

		ResultadoListagemGrupoDTO listagemGrupoDto = servicoSisLaraServerRmi
				.pesquisarGrupoPor(especificacaoPesquisaGrupoDTO);
		ModuloPeriodoDTO moduloPeriodoDTO = obterModuloPeriodoDto(listagemGrupoDto.getObjetosDto(), new Long(12222),
				new Long(11111));

		ResultadoListagemStatusRelacaoUsuarioModuloDTO resultadoListagemStatus = servicoSisLaraServerRmi
				.obterListagemStatusRelacaoUsuarioModulo(moduloPeriodoDTO);

		Assert.assertTrue(resultadoListagemStatus.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertEquals(resultadoListagemStatus.getObjetosDto().size(), 11);
		Assert.assertFalse(resultadoListagemStatus.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_status_relacao_usuario_modulo_disponiveis_para_inclusao()
			throws RemoteException {
		ResultadoListagemStatusRelacaoUsuarioModuloDTO resultadoListagemStatus = servicoSisLaraServerRmi
				.obterListagemStatusRelacaoUsuarioModuloDisponiveisParaInclusao(ContextoGrupo.construirGrupoDTO());

		Assert.assertTrue(resultadoListagemStatus.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertEquals(resultadoListagemStatus.getObjetosDto().size(), 3);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_frequencia() throws RemoteException {
		ResultadoListagemFrequenciaDTO resultadoListagemFrequenciaDoUsuario = servicoSisLaraServerRmi
				.obterListagemFrequenciaDoUsuario();
		ResultadoListagemFrequenciaDTO resultadoListagemFrequenciaDoProfissional = servicoSisLaraServerRmi
				.obterListagemFrequenciaDoProfissional();

		Assert.assertTrue(resultadoListagemFrequenciaDoUsuario.sucesso(), "A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemFrequenciaDoUsuario.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
		Assert.assertTrue(resultadoListagemFrequenciaDoProfissional.sucesso(),
				"A listagem deveria ser gerada com sucesso.");
		Assert.assertFalse(resultadoListagemFrequenciaDoProfissional.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_efetua_pesquisa_todos_grupos() throws RemoteException {
		EspecificacaoPesquisaGrupoDTO especificacaoPesquisaGrupoDTO = new EspecificacaoPesquisaGrupoDTO();
		especificacaoPesquisaGrupoDTO.adicionarParametro(ChavePesquisaDTO.GRUPOS_INATIVOS, "G");

		ResultadoListagemGrupoDTO listagemGrupoDto = servicoSisLaraServerRmi
				.pesquisarGrupoPor(especificacaoPesquisaGrupoDTO);

		Assert.assertTrue(listagemGrupoDto.sucesso());
		Assert.assertEquals(listagemGrupoDto.getObjetosDto().size(), 1);
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_efetua_pesquisa_apenas_grupos_ativos() throws RemoteException {
		EspecificacaoPesquisaGrupoDTO especificacaoPesquisaGrupoDTO = new EspecificacaoPesquisaGrupoDTO();
		especificacaoPesquisaGrupoDTO.adicionarParametro(ChavePesquisaDTO.GRUPOS_ATIVOS, "G02");

		ResultadoListagemGrupoDTO listagemGrupoDto = servicoSisLaraServerRmi
				.pesquisarGrupoPor(especificacaoPesquisaGrupoDTO);

		Assert.assertTrue(listagemGrupoDto.sucesso());
		Assert.assertEquals(listagemGrupoDto.getObjetosDto().size(), 1);
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_efetua_pesquisa_grupo_inativos_por_nome() throws RemoteException {
		EspecificacaoPesquisaGrupoDTO especificacaoPesquisaGrupoDTO = new EspecificacaoPesquisaGrupoDTO();
		especificacaoPesquisaGrupoDTO.adicionarParametro(ChavePesquisaDTO.GRUPOS_INATIVOS, "G00");

		ResultadoListagemGrupoDTO listagemGrupoDto = servicoSisLaraServerRmi
				.pesquisarGrupoPor(especificacaoPesquisaGrupoDTO);

		Assert.assertTrue(listagemGrupoDto.sucesso());
		Assert.assertEquals(listagemGrupoDto.getObjetosDto().size(), 1);
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_efetua_pesquisa_grupo_por_nomes_completos_por_nome() throws RemoteException {

		ResultadoListagemNomeCompletoGrupoDTO resultado = servicoSisLaraServerRmi.pesquisarNomeGrupoPor("G02");

		Assert.assertEquals(resultado.getObjetosDto().size(), 1);
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_efetua_pesquisa_grupo_inexistente_por_nome() throws RemoteException {
		EspecificacaoPesquisaGrupoDTO especificacaoPesquisaGrupoDTO = new EspecificacaoPesquisaGrupoDTO();
		especificacaoPesquisaGrupoDTO.adicionarParametro(ChavePesquisaDTO.GRUPOS_INATIVOS, "AA");
		ResultadoListagemGrupoDTO listagemGrupoDto = servicoSisLaraServerRmi
				.pesquisarGrupoPor(especificacaoPesquisaGrupoDTO);

		Assert.assertFalse(listagemGrupoDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_efetua_pesquisa_por_grupo_a_partir_de_especificacao_vazia() throws RemoteException {
		EspecificacaoPesquisaGrupoDTO especificacao = new EspecificacaoPesquisaGrupoDTO();

		ResultadoListagemGrupoDTO resultadoDto = servicoSisLaraServerRmi.pesquisarGrupoPor(especificacao);

		Assert.assertEquals(resultadoDto.sucesso(), false);
		Assert.assertFalse(resultadoDto.obterMensagens().isEmpty());
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_inclui_novo_grupo_com_descricao_tipo_atendimento_cursos_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		GrupoDTO grupoASalvarDto = ContextoGrupo.fabricarGrupoDTOComDescricaoTipoAtendimentoCursosValido();

		ResultadoEdicaoGrupoDTO resultadoInclusaoGrupo = servicoSisLaraServerRmi.editarGrupo(grupoASalvarDto,
				resultadoDto.getToken());
		
		Assert.assertTrue(resultadoInclusaoGrupo.sucesso());		
	}
	
	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_inclui_novo_grupo_com_descricao_tipo_atendimento_cursos_sem_descricaoementa_sem_sucesso()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		GrupoDTO grupoASalvarDto = ContextoGrupo.fabricarGrupoDTOComDescricaoTipoAtendimentoCursosValido();

		grupoASalvarDto.setDescricoesEventoDto(Arrays.asList(ContextoDescricaoEvento.construirDescricaoEventoCoordenacaoDTO()));

		ResultadoEdicaoGrupoDTO resultadoInclusaoGrupo = servicoSisLaraServerRmi.editarGrupo(grupoASalvarDto,
				resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoGrupo.sucesso());
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_inclui_novo_grupo_com_descricao_tipo_atendimento_cursos_sem_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		GrupoDTO grupoASalvarDto = ContextoGrupo.fabricarGrupoDTOComDescricaoTipoAtendimentoCursosInvalido();

		ResultadoEdicaoGrupoDTO resultadoInclusaoGrupo = servicoSisLaraServerRmi.editarGrupo(grupoASalvarDto,
				resultadoDto.getToken());
		
		Assert.assertFalse(resultadoInclusaoGrupo.sucesso());		
	}
	
	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_inclui_novo_grupo_com_descricao_tipo_atendimento_cursos_com_mais_de_um_modulo_periodo_sem_sucesso()
			throws RemoteException {
		String erro = "Existem M�dulos duplicados nesse grupo.\n"+
				"S� � poss�vel inserir um m�dulo per�odo por curso.";
		
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		GrupoDTO grupoASalvarDto = ContextoGrupo.fabricarGrupoDTOComDescricaoTipoAtendimentoCursosValido();

		List<ModuloPeriodoDTO> modulosPeriodosDto = new ArrayList<>();
		
		modulosPeriodosDto.add(ContextoModuloPeriodo.fabricarModuloPeriodoDTOComTodosOsDadosBraille());
		modulosPeriodosDto.add(ContextoModuloPeriodo.fabricarModuloPeriodoDTOComTodosOsDadosBraille());
		
		grupoASalvarDto.setModulosPeriodosDto(modulosPeriodosDto);				

		ResultadoEdicaoGrupoDTO resultadoInclusaoGrupo = servicoSisLaraServerRmi.editarGrupo(grupoASalvarDto,
				resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoGrupo.sucesso());
		Assert.assertTrue(resultadoInclusaoGrupo.obterMensagens().contains(erro));
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_inclui_novo_grupo_e_gera_pendencias_de_atendimento_de_grupo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		GrupoDTO grupoASalvarDto = ContextoGrupo.construirGrupoDTOSemAtendimentos();

		ResultadoEdicaoGrupoDTO resultadoInclusaoGrupo = servicoSisLaraServerRmi.editarGrupo(grupoASalvarDto,
				resultadoDto.getToken());
		
		MaquinaTempo.mudarDataAtual(grupoASalvarDto.getDataTermino());
		ResultadoListagemPendenciaDTO resultadoListagemPendenciaDTO = servicoSisLaraServerRmi.obterListagemPendencia(resultadoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();
		
		Assert.assertTrue(resultadoInclusaoGrupo.sucesso());
		Assert.assertEquals(resultadoListagemPendenciaDTO.getObjetosDto().size(), 4);
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_inclui_novo_grupo_e_gera_pendencias_desativando_pendencias_apos_desativacao_de_grupo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		GrupoDTO grupoASalvarDto = ContextoGrupo.construirGrupoDTOSemAtendimentos();

		ResultadoEdicaoGrupoDTO resultadoInclusaoGrupo = servicoSisLaraServerRmi.editarGrupo(grupoASalvarDto,
				resultadoDto.getToken());
		
		MaquinaTempo.mudarDataAtual(grupoASalvarDto.getDataTermino());
		ResultadoListagemPendenciaDTO resultadoListagemPendenciaAntesDesativacaoDTO = servicoSisLaraServerRmi.obterListagemPendencia(resultadoDto.getToken());
		
		GrupoDTO grupoDto = (GrupoDTO)resultadoInclusaoGrupo.obterObjetoDtoEditado();
		grupoDto.setAtivo(false);
		servicoSisLaraServerRmi.editarGrupo(grupoDto, resultadoDto.getToken());
		
		ResultadoListagemPendenciaDTO resultadoListagemPendenciaAposDesativacaoDTO = servicoSisLaraServerRmi.obterListagemPendencia(resultadoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();
				
		Assert.assertTrue(resultadoInclusaoGrupo.sucesso());
		Assert.assertTrue(resultadoListagemPendenciaAntesDesativacaoDTO.sucesso());
		Assert.assertEquals(resultadoListagemPendenciaAntesDesativacaoDTO.getObjetosDto().size(), 4);
		Assert.assertTrue(resultadoListagemPendenciaAposDesativacaoDTO.sucesso());
		Assert.assertEquals(resultadoListagemPendenciaAposDesativacaoDTO.getObjetosDto().size(), 0);
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_gera_pendencias_de_atendimento_de_grupo_e_listagem_de_pendencias_desconsidera_data_com_atendimento_de_grupo_efetuado()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaVVitalino());
		
		ResultadoAutenticacaoDTO resultadoPBandeiraDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());
						
		String dataInicial = "11/01/2016";
		MaquinaTempo.mudarDataAtual(dataInicial);
		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222));

		gerarEEditarAtendimento(new EspecificacaoGeracaoAtendimentoDTO(
				obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(), new Long(11111)).getId(), dataInicial, new HorarioDTO("09:00",
				"10:00")), resultadoDto.getToken());
		
		ResultadoListagemGrupoDTO resultadoListagemGrupoAposGeracaoAtendimento = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("G02-1");
		GrupoDTO grupoDtoAposGeracaoAtendimento = (GrupoDTO) obterDaRelacaoPorId(
				resultadoListagemGrupoAposGeracaoAtendimento.getObjetosDto(), new Long(12222));
		grupoDtoAposGeracaoAtendimento.setDataTermino("31/01/2016");

		servicoSisLaraServerRmi.editarGrupo(grupoDtoAposGeracaoAtendimento, resultadoDto.getToken());

		MaquinaTempo.mudarDataAtual(grupoDto.getDataTermino());
		ResultadoListagemPendenciaDTO resultadoListagemPendenciaPBandeiraDTO = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoPBandeiraDto.getToken());
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertEquals(resultadoListagemPendenciaPBandeiraDTO.getObjetosDto().size(), 3);
		Assert.assertTrue(contem(resultadoListagemPendenciaPBandeiraDTO.getObjetosDto(),
				"Atendimento do grupo no G02-01, Data: 04/01/2016, M�dulo: Atendimento Especifico Especializado"));
		Assert.assertFalse(contem(resultadoListagemPendenciaPBandeiraDTO.getObjetosDto(),
				"Atendimento do grupo no G02-01, Data: 11/01/2016, M�dulo: Atendimento Especifico Especializado"));
		Assert.assertTrue(contem(resultadoListagemPendenciaPBandeiraDTO.getObjetosDto(),
				"Atendimento do grupo no G02-01, Data: 18/01/2016, M�dulo: Atendimento Especifico Especializado"));
		Assert.assertTrue(contem(resultadoListagemPendenciaPBandeiraDTO.getObjetosDto(),
				"Atendimento do grupo no G02-01, Data: 25/01/2016, M�dulo: Atendimento Especifico Especializado"));
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_resolve_pendencia_de_grupo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		String data = "02/01/2115";
		MaquinaTempo.mudarDataAtual(data);
		ResultadoListagemPendenciaDTO pendenciasAntesResolucaoDto = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		PendenciaDTO pendenciaDTO = (PendenciaDTO) obterDaRelacaoPorId(pendenciasAntesResolucaoDto.getObjetosDto(),
				new Long(5000));

		ResultadoGeracaoAtendimentoDTO resultadoGeracaoAtendimentoDTO = servicoSisLaraServerRmi
				.gerarAtendimentos(pendenciaDTO, resultadoDto.getToken());
		AtendimentoGrupoDTO atendimentoGrupoDTO = (AtendimentoGrupoDTO) resultadoGeracaoAtendimentoDTO.obterObjetoDtoEditado();
		alterarParticipacaoDetalhada(atendimentoGrupoDTO);
		atendimentoGrupoDTO.setData("01/01/2115");
		atendimentoGrupoDTO.setHorarioDto(new HorarioDTO("09:00", "10:00"));
		
		ResultadoEdicaoAtendimentoGrupoDTO resultadoEdicaoAtendimentoGrupoDTO = servicoSisLaraServerRmi
				.editarAtendimentoGrupo(resultadoGeracaoAtendimentoDTO.getModuloPeriodoDTO(), atendimentoGrupoDTO,
						resultadoDto.getToken());

		ResultadoListagemPendenciaDTO pendenciasAposResolucaoDto = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertTrue(resultadoEdicaoAtendimentoGrupoDTO.sucesso());
		Assert.assertEquals(pendenciasAntesResolucaoDto.getObjetosDto().size(), 2);
		Assert.assertEquals(pendenciasAposResolucaoDto.getObjetosDto().size(), 1);
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_gera_atendimentos_a_partir_de_pendencia_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		MaquinaTempo.mudarDataAtual("01/01/2117");
		ResultadoListagemPendenciaDTO pendenciasDto = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		PendenciaDTO pendenciaDTO = (PendenciaDTO) obterDaRelacaoPorId(pendenciasDto.getObjetosDto(),
				new Long(5000));

		ResultadoGeracaoAtendimentoDTO resultadoGeracaoAtendimentoDTO = servicoSisLaraServerRmi
				.gerarAtendimentos(pendenciaDTO, resultadoDto.getToken());
		
		AtendimentoGrupoDTO atendimentoGrupoDto = (AtendimentoGrupoDTO)resultadoGeracaoAtendimentoDTO.obterObjetoDtoEditado();
		MaquinaTempo.restaurarDataOriginal();
		
		Assert.assertNull(atendimentoGrupoDto.getId());
		Assert.assertFalse(atendimentoGrupoDto.getAtendimentosUsuariosDto().isEmpty());
		Assert.assertFalse(atendimentoGrupoDto.getAtendimentosProfissionaisDto().isEmpty());
		Assert.assertEquals(atendimentoGrupoDto.getData(), "01/01/2115");
		Assert.assertEquals(atendimentoGrupoDto.getHorarioDto().getHoraInicio(), "09:00");
		Assert.assertEquals(atendimentoGrupoDto.getHorarioDto().getHoraTermino(), "10:00");
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_gera_atendimentos_a_partir_de_especificacao_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		String data = "01/01/2015";
		String horaInicio = "09:00";
		String horaTermino = "10:00";
		EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentoDTO = new EspecificacaoGeracaoAtendimentoDTO(
				new Long(11111), data, new HorarioDTO(horaInicio, horaTermino));
		ResultadoGeracaoAtendimentoDTO resultadoGeracaoAtendimentoDTO = servicoSisLaraServerRmi
				.gerarAtendimentos(especificacaoGeracaoAtendimentoDTO, resultadoDto.getToken());
		
		AtendimentoGrupoDTO atendimentoGrupoDto = (AtendimentoGrupoDTO)resultadoGeracaoAtendimentoDTO.obterObjetoDtoEditado();
		
		Assert.assertNull(atendimentoGrupoDto.getId());
		Assert.assertFalse(atendimentoGrupoDto.getAtendimentosUsuariosDto().isEmpty());
		Assert.assertFalse(atendimentoGrupoDto.getAtendimentosProfissionaisDto().isEmpty());
		Assert.assertEquals(atendimentoGrupoDto.getData(), data);
		Assert.assertEquals(atendimentoGrupoDto.getHorarioDto().getHoraInicio(), horaInicio);
		Assert.assertEquals(atendimentoGrupoDto.getHorarioDto().getHoraTermino(), horaTermino);
	}

	@Test(groups = { TiposDeTeste.PENDENCIA })
	public void servico_resolve_pendencia_de_atendimento_invidual_de_servico_social_avaliacao_e_triagem_com_geracao_de_atendimento_de_acompanhamento()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		MaquinaTempo.mudarDataAtual("01/01/2117");
		ResultadoListagemPendenciaDTO pendenciasAntesResolucaoDto = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		AtendimentoProfissionalDTO atendimentoProfissionalDTO = ContextoAtendimentoProfissional
				.construirAtendimentoProfissionalDTOComAT();
		atendimentoProfissionalDTO.setProfissionalDto(ContextoProfissional.construirProfissionalDTOComId3000());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto
				.setDescricaoTipoAtendimentoDto(ContextoDescricaoTipoAtendimento.construirDescricaoServicoSocialDTO());
		atendimentoIndividualDto.setModuloDto(ContextoModulo.construirModuloAcompanhamentoDTO());
		atendimentoIndividualDto.getUsuarioDto().setId(new Long(82222));
		atendimentoIndividualDto.setData("31/01/2012");
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("09:00", "11:00"));
		atendimentoIndividualDto.getAtendimentosProfissionalDto().add(atendimentoProfissionalDTO);

		servicoSisLaraServerRmi.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Registro.obterAutomatizadorPendencia().atualizarPendencias();

		ResultadoListagemPendenciaDTO pendenciasAposResolucaoDto = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertEquals(pendenciasAntesResolucaoDto.getObjetosDto().size(), 2);
		Assert.assertEquals(pendenciasAposResolucaoDto.getObjetosDto().size(), 1);
	}

	@Test(groups = { TiposDeTeste.PENDENCIA })
	public void servico_resolve_pendencia_de_atendimento_invidual_de_avaliacao_de_servico_de_atencao_especializada_em_ortoptica_com_geracao_de_atendimento_de_acompanhamento()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaAdailza());

		MaquinaTempo.mudarDataAtual("01/01/2117");
		ResultadoListagemPendenciaDTO pendenciasAntesResolucaoDto = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		AtendimentoProfissionalDTO atendimentoProfissionalDTO = ContextoAtendimentoProfissional
				.construirAtendimentoProfissionalDTOComAT();
		atendimentoProfissionalDTO.setProfissionalDto(ContextoProfissional.construirProfissionalDTOComId4000());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAcompanhamentoServicoOrtoptica());
		atendimentoIndividualDto.setModuloDto(ContextoModulo.construirModuloAEE());
		atendimentoIndividualDto.getUsuarioDto().setId(new Long(16666));
		atendimentoIndividualDto.setData("31/01/2012");
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("09:00", "11:00"));
		atendimentoIndividualDto.getAtendimentosProfissionalDto().add(atendimentoProfissionalDTO);

		servicoSisLaraServerRmi.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Registro.obterAutomatizadorPendencia().atualizarPendencias();

		ResultadoListagemPendenciaDTO pendenciasAposResolucaoDto = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertEquals(pendenciasAntesResolucaoDto.getObjetosDto().size(), 1);
		Assert.assertEquals(pendenciasAposResolucaoDto.getObjetosDto().size(), 0);
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_resolve_pendencia_de_grupo_resolvida_por_outro_usuario() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		MaquinaTempo.mudarDataAtual("01/01/2117");

		ResultadoListagemPendenciaDTO pendenciasDto = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		PendenciaDTO pendenciaDTO = (PendenciaDTO) obterDaRelacaoPorId(pendenciasDto.getObjetosDto(), new Long(5000));

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222));

		String dataInicial = "01/01/2115";
		EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentosDTO = new EspecificacaoGeracaoAtendimentoDTO(
				obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(), new Long(11111)).getId(),
				dataInicial, new HorarioDTO("22:22", "23:00"));
		gerarEEditarAtendimento(
				especificacaoGeracaoAtendimentosDTO, resultadoDto.getToken());		
		
		ResultadoGeracaoAtendimentoDTO resultadoGeracaoAtendimentoDTO = servicoSisLaraServerRmi
				.gerarAtendimentos(pendenciaDTO, resultadoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertFalse(resultadoGeracaoAtendimentoDTO.sucesso());
		Assert.assertTrue(resultadoGeracaoAtendimentoDTO.obterMensagens().contains("A pendencia j� foi resolvida."));
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_resolve_pendencia_de_grupo_devido_alteracao_concorrente() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		ResultadoAutenticacaoDTO resultadoAlternativoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoRLemeDtoValida());

		MaquinaTempo.mudarDataAtual("01/01/2117");
		ResultadoListagemPendenciaDTO pendenciasDto = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		PendenciaDTO pendenciaDTO = (PendenciaDTO) obterDaRelacaoPorId(pendenciasDto.getObjetosDto(), new Long(5000));

		ResultadoListagemGrupoDTO gruposDto = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");

		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(gruposDto.getObjetosDto(), new Long(12222));
		ModuloPeriodoDTO moduloPeriodoDto = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(),
				new Long(11111));
		servicoSisLaraServerRmi.editarModuloPeriodo(moduloPeriodoDto, resultadoDto.getToken());
		servicoSisLaraServerRmi.bloquearEdicao("G02-1", resultadoAlternativoDto.getToken());
		ResultadoGeracaoAtendimentoDTO resultadoGeracaoAtendimentoDTO = servicoSisLaraServerRmi
				.gerarAtendimentos(pendenciaDTO, resultadoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertFalse(resultadoGeracaoAtendimentoDTO.sucesso());
		Assert.assertEquals(resultadoGeracaoAtendimentoDTO.obterMensagens(),
				"O item est� sendo editado pelo(a): rleme\n\n");
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_atualiza_atendimento_no_grupo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		String nomeArquivo = "teste.pdf";
		String nomeGrupo = "G02-1";
		String conteudoA = "Conteudo do arquivo de teste A.";
		String conteudoB = "Conteudo do arquivo de teste B.";
		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo(nomeGrupo);
		Long idModuloPeriodo = new Long(11111);
		
		AtendimentoGrupoDTO atendimentoGrupoDto = obterAtendimentoGrupoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), idModuloPeriodo, new Long(11111));
		atendimentoGrupoDto.setDescricao(conteudoA);
		ArquivoDTO arquivoAtendimetoGrupoDTO = new ArquivoDTO(null, nomeArquivo, conteudoA.getBytes(), null);
		atendimentoGrupoDto.setArquivos(Arrays.asList(arquivoAtendimetoGrupoDTO));
		AtendimentoUsuarioDTO atendimentoUsuarioDTO = (AtendimentoUsuarioDTO) obterDaRelacaoPorId(
				atendimentoGrupoDto.getAtendimentosUsuariosDto(), new Long(12222));
		ArquivoDTO arquivoAtendimentoUsuarioDTO = new ArquivoDTO(null, nomeArquivo, conteudoB.getBytes(), null);
		atendimentoUsuarioDTO.setArquivos(Arrays.asList(arquivoAtendimentoUsuarioDTO));

		ModuloPeriodoDTO moduloPeriodoDTO = new ModuloPeriodoDTO();
		moduloPeriodoDTO.setId(idModuloPeriodo);
		ResultadoEdicaoAtendimentoGrupoDTO resultadoAtualizacaoAtendimentoGrupo = servicoSisLaraServerRmi
				.editarAtendimentoGrupo(moduloPeriodoDTO, atendimentoGrupoDto, resultadoDto.getToken());

		ResultadoListagemGrupoDTO listagemGrupoAposAtualizacaoDto = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("G02-1");
		AtendimentoGrupoDTO atendimentoGrupoAposAtualizacaoDto = obterAtendimentoGrupoDto(
				listagemGrupoAposAtualizacaoDto.getObjetosDto(), new Long(12222), new Long(11111), new Long(11111));
		AtendimentoUsuarioDTO atendimentoUsuarioAtualizadoDTO = (AtendimentoUsuarioDTO) obterDaRelacaoPorId(
				atendimentoGrupoAposAtualizacaoDto.getAtendimentosUsuariosDto(), new Long(12222));
		ArquivoDTO arquivoAtendimentoGrupoSalvoDTO = servicoSisLaraServerRmi.obterArquivoAtendimentoGrupoDTO(
				atendimentoGrupoAposAtualizacaoDto, atendimentoGrupoAposAtualizacaoDto.getArquivos().get(0));
		ArquivoDTO arquivoAtendimentoUsuarioSalvoDTO = servicoSisLaraServerRmi.obterArquivoAtendimentoUsuarioDTO(
				atendimentoUsuarioAtualizadoDTO, atendimentoUsuarioAtualizadoDTO.getArquivos().get(0));
		ArquivoDTO arquivoDisponivelAtendimentoUsuarioDto = servicoSisLaraServerRmi.obterArquivoDisponivelDTO(
				atendimentoUsuarioAtualizadoDTO.getId().toString(), nomeArquivo,
				TipoArquivoDisponivel.USUARIO_NO_GRUPO.toString());
		ArquivoDTO arquivoDisponivelAtendimentoGrupoBDto = servicoSisLaraServerRmi.obterArquivoDisponivelDTO(
				atendimentoGrupoDto.getId().toString(), nomeArquivo, TipoArquivoDisponivel.GRUPO.toString());
		ResultadoListagemArquivoDisponivelDTO resultadoListagemArquivoDisponivelSomenteGrupoDto = servicoSisLaraServerRmi
				.obterListagemArquivoDisponivelDTO(nomeGrupo + "-01/01/2016", true);

		Assert.assertTrue(resultadoAtualizacaoAtendimentoGrupo.sucesso());
		Assert.assertTrue(atendimentoGrupoAposAtualizacaoDto.getDescricao().equals(conteudoA));
		Assert.assertNotEquals(atendimentoGrupoDto.getVersao(), atendimentoGrupoAposAtualizacaoDto.getVersao());
		Assert.assertEquals(arquivoAtendimentoGrupoSalvoDTO.obterConteudo(), arquivoAtendimetoGrupoDTO.obterConteudo());
		Assert.assertEquals(arquivoAtendimentoUsuarioSalvoDTO.obterConteudo(),
				arquivoAtendimentoUsuarioDTO.obterConteudo());
		Assert.assertEquals(arquivoDisponivelAtendimentoUsuarioDto.obterConteudo(),
				arquivoAtendimentoUsuarioDTO.obterConteudo());
		Assert.assertEquals(arquivoDisponivelAtendimentoGrupoBDto.obterConteudo(),
				arquivoAtendimetoGrupoDTO.obterConteudo());
		Assert.assertEquals(resultadoListagemArquivoDisponivelSomenteGrupoDto.getObjetosDto().size(), 1);
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_nao_integra_usuario_em_modulo_reuniao_de_integracao_em_grupos_ativos_distintos()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaVeraPereira());

		integrar_usuario_ao_grupo_e_modulo_perido(resultadoDto, "SS-1", new Long(66666), new Long(99999));

		ResultadoEdicaoModuloPeriodoDTO resultadoEdicaoModuloPeriodoDTO = integrar_usuario_ao_grupo_e_modulo_perido(
				resultadoDto, "SS-2", new Long(77777), new Long(44444));

		Assert.assertFalse(resultadoEdicaoModuloPeriodoDTO.sucesso());
		Assert.assertEquals(resultadoEdicaoModuloPeriodoDTO.obterMensagens(),
				"Usu�rios 12222 - Paulo j� est�o integrados em um grupo de reuni�o de integra��o.\n");
	}

	private EsperaDTO obterEsperaComObs(List<EsperaDTO> esperas, String obs) {
		return esperas.stream().filter(espera -> espera.getObs().contains(obs)).findFirst().orElse(null);
	}

	@Test(groups = { TiposDeTeste.PENDENCIA })
	public void servico_atualiza_atendimento_e_envia_para_lista_de_espera_por_excesso_de_faltas_e_inclui_pendencia()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222));
		Long prontuario = new Long(12222);

		// Ref M�dulo Per�odo Informatica
		servico_gera_tres_atendimentos_de_grupo_com_datas_diferentes_e_altera_a_frenquencia_do_prontuario_para_fu(
				grupoDto, new Long(11111), resultadoDto, prontuario);

		EspecificacaoPesquisaEsperaDTO especificacao = new EspecificacaoPesquisaEsperaDTO();
		especificacao.setProntuario(prontuario.toString());
		especificacao.setInteresse(false);
		especificacao.setLmLigou(false);
		especificacao.setPendencias(false);
		especificacao.setStatusEsperadoDto(new StatusEsperaDTO(StatusEspera.AGUARDANDO.toString()));

		ResultadoListagemEsperaDTO resultado = servicoSisLaraServerRmi.obterListagemEspera(especificacao);

		ResultadoListagemPendenciaDTO resultadoListagemPendenciaDTO = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		Assert.assertEquals(resultado.getObjetosDto().size(), 3);
		Assert.assertEquals(resultadoListagemPendenciaDTO.getObjetosDto().size(), 1);
	}

	@Test(groups = { TiposDeTeste.PENDENCIA })
	public void servico_atualiza_atendimento_e_envia_para_lista_de_espera_por_excesso_de_faltas_e_inclui_pendencia_e_remove_pendencia_apos_resolucao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222));
		Long prontuario = new Long(12222);

		// Ref M�dulo Per�odo Informatica
		servico_gera_tres_atendimentos_de_grupo_com_datas_diferentes_e_altera_a_frenquencia_do_prontuario_para_fu(
				grupoDto, new Long(11111), resultadoDto, prontuario);

		EspecificacaoPesquisaEsperaDTO especificacao = new EspecificacaoPesquisaEsperaDTO();
		especificacao.setProntuario(prontuario.toString());
		especificacao.setInteresse(false);
		especificacao.setLmLigou(false);
		especificacao.setPendencias(false);
		especificacao.setStatusEsperadoDto(new StatusEsperaDTO(StatusEspera.AGUARDANDO.toString()));

		ResultadoListagemEsperaDTO resultado = servicoSisLaraServerRmi.obterListagemEspera(especificacao);

		ResultadoListagemPendenciaDTO resultadoListagemPendenciaAntesResolucaoDTO = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		EsperaDTO esperaIncluida = obterEsperaComObs(resultado.getObjetosDto(),
				"Inclu�do automaticamente por excesso de faltas n�o justificadas.");
		esperaIncluida.setJustificativaCancelamento("Justificativa.");
		servicoSisLaraServerRmi.cancelarEspera(esperaIncluida, resultadoDto.getToken());
		Registro.obterAutomatizadorPendencia().atualizarPendencias();

		ResultadoListagemPendenciaDTO resultadoListagemPendenciaAposResolucaoDTO = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		Assert.assertEquals(resultadoListagemPendenciaAntesResolucaoDTO.getObjetosDto().size(), 1);
		Assert.assertEquals(resultadoListagemPendenciaAposResolucaoDTO.getObjetosDto().size(), 0);
	}

	@Test(groups = { TiposDeTeste.PENDENCIA })
	public void servico_atualiza_atendimento_e_nao_envia_para_lista_de_espera_devido_atendimento_no_mesmo_dia_de_aee_e_pisicosocial()
			throws RemoteException {
		ResultadoAutenticacaoDTO contaAcessoPBandeiraDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());
		
		ResultadoAutenticacaoDTO contaAcessoVVitalinoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaVVitalino());

		ResultadoListagemGrupoDTO resultadoListagemGrupoAEEPisico = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("G02-1");
		
		GrupoDTO grupoContendoModuloAeeEPisicoDto = (GrupoDTO) obterDaRelacaoPorId(
				resultadoListagemGrupoAEEPisico.getObjetosDto(), new Long(12222));
		Long prontuario = new Long(72222);

		ResultadoEdicaoAtendimentoGrupoDTO resultadoA = servico_gera_atendimento_de_grupo_e_altera_frequencia_para_fu(
				new EspecificacaoGeracaoAtendimentoDTO(
						obterDaRelacaoPorId(grupoContendoModuloAeeEPisicoDto.getModulosPeriodosDto(), new Long(11111))
								.getId(),
						"03/03/2015", new HorarioDTO("09:00", "19:00")),
				prontuario, contaAcessoPBandeiraDto);

		ResultadoEdicaoAtendimentoGrupoDTO resultadoB = servico_gera_atendimento_de_grupo_e_altera_frequencia_para_fu(
				new EspecificacaoGeracaoAtendimentoDTO(
						obterDaRelacaoPorId(grupoContendoModuloAeeEPisicoDto.getModulosPeriodosDto(), new Long(11111))
								.getId(),
						"02/03/2015", new HorarioDTO("09:00", "19:00")),
				prontuario, contaAcessoPBandeiraDto);

		ResultadoEdicaoAtendimentoGrupoDTO resultadoC = servico_gera_atendimento_de_grupo_e_altera_frequencia_para_fu(
				new EspecificacaoGeracaoAtendimentoDTO(
						obterDaRelacaoPorId(grupoContendoModuloAeeEPisicoDto.getModulosPeriodosDto(), new Long(22222))
								.getId(),
						"02/03/2015", new HorarioDTO("09:00", "19:00")),
				prontuario, contaAcessoVVitalinoDto);

		EspecificacaoPesquisaEsperaDTO especificacao = new EspecificacaoPesquisaEsperaDTO();
		especificacao.setProntuario(prontuario.toString());
		especificacao.setInteresse(false);
		especificacao.setLmLigou(false);
		especificacao.setPendencias(false);

		ResultadoListagemEsperaDTO resultado = servicoSisLaraServerRmi.obterListagemEspera(especificacao);

		Assert.assertEquals(resultado.getObjetosDto().size(), 1);
		Assert.assertTrue(resultadoA.sucesso());
		Assert.assertTrue(resultadoB.sucesso());
		Assert.assertTrue(resultadoC.sucesso());
	}

	@Test(groups = { TiposDeTeste.PENDENCIA })
	public void servico_atualiza_atendimento_e_nao_envia_para_lista_de_espera_por_excesso_de_faltas_pois_esta_liberado_e_nao_envia_para_relacao_de_pendencias()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaVVitalino());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("OSE-1");
		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(821582));
		Long prontuario = new Long(16666);

		servico_gera_tres_atendimentos_de_grupo_com_datas_diferentes_e_altera_a_frenquencia_do_prontuario_para_fu(
				grupoDto, new Long(821582), resultadoDto, prontuario);

		EspecificacaoPesquisaEsperaDTO especificacao = new EspecificacaoPesquisaEsperaDTO();
		especificacao.setProntuario(prontuario.toString());
		especificacao.setInteresse(false);
		especificacao.setLmLigou(false);
		especificacao.setPendencias(false);
		especificacao.setStatusEsperadoDto(new StatusEsperaDTO(StatusEspera.AGUARDANDO.toString()));
		DescricaoTipoAtendimentoDTO descricaoTipoAtendimentoDTO = ContextoDescricaoTipoAtendimento.construirDescricaoServicoSocialDTO();
		especificacao.setDescricaoTipoAtendimentoDto(descricaoTipoAtendimentoDTO);
		especificacao.setModuloDto(ContextoModulo.construirModuloExcessoDeFaltasDTO());
		
		ResultadoListagemEsperaDTO resultado = servicoSisLaraServerRmi.obterListagemEspera(especificacao);

		ResultadoListagemPendenciaDTO resultadoListagemPendenciaDTO = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		Assert.assertEquals(resultado.getObjetosDto().size(), 0);
		Assert.assertEquals(resultadoListagemPendenciaDTO.getObjetosDto().size(), 0);
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_atualiza_atendimento_no_grupo_com_erro_obrigatoriedade() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");

		Long idModuloPeriodo = new Long(11111);
		ModuloPeriodoDTO moduloPeriodoDTO = new ModuloPeriodoDTO();
		moduloPeriodoDTO.setId(idModuloPeriodo);
		
		AtendimentoGrupoDTO atendimentoGrupoDto = obterAtendimentoGrupoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), idModuloPeriodo, new Long(11111));
		atendimentoGrupoDto.setData(null);

		ResultadoEdicaoAtendimentoGrupoDTO resultadoAtualizacaoAtendimentoGrupo = servicoSisLaraServerRmi
				.editarAtendimentoGrupo(moduloPeriodoDTO, atendimentoGrupoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoAtualizacaoAtendimentoGrupo.sucesso());
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_atualiza_atendimento_no_grupo_com_frequencia_AT_sem_participacao_detalhada()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		
		Long idModuloPeriodo = new Long(11111);
		ModuloPeriodoDTO moduloPeriodoDTO = new ModuloPeriodoDTO();
		moduloPeriodoDTO.setId(idModuloPeriodo);
		
		AtendimentoGrupoDTO atendimentoGrupoDto = obterAtendimentoGrupoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), idModuloPeriodo, new Long(11111));
		atendimentoGrupoDto.getAtendimentosUsuariosDto().get(0).getInformacaoAtendimentoDto()
				.setParticipadaoDetalhadaDto(Arrays.asList());

		ResultadoEdicaoAtendimentoGrupoDTO resultadoAtualizacaoAtendimentoGrupo = servicoSisLaraServerRmi
				.editarAtendimentoGrupo(moduloPeriodoDTO, atendimentoGrupoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoAtualizacaoAtendimentoGrupo.sucesso());
		Assert.assertTrue(resultadoAtualizacaoAtendimentoGrupo.obterMensagens()
				.contains("Insira uma Participa��o no atendimento com frequencia AT."));
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_atualiza_atendimento_no_grupo_com_frequencia_FU_removendo_participacao_detalhada()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		
		Long idModuloPeriodo = new Long(11111);
		ModuloPeriodoDTO moduloPeriodoDTO = new ModuloPeriodoDTO();
		moduloPeriodoDTO.setId(idModuloPeriodo);
		
		AtendimentoGrupoDTO atendimentoGrupoDto = obterAtendimentoGrupoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), idModuloPeriodo, new Long(11111));
		atendimentoGrupoDto.getAtendimentosUsuariosDto().get(0).getInformacaoAtendimentoDto()
				.setFrequenciaDto(new FrequenciaDTO(Frequencia.FU.toString()));
		AtendimentoUsuarioDTO atendimentoUsuarioDTOAntes = (AtendimentoUsuarioDTO) obterDaRelacaoPorId(atendimentoGrupoDto.getAtendimentosUsuariosDto(), new Long(12222));

		ResultadoEdicaoAtendimentoGrupoDTO resultadoAtualizacaoAtendimentoGrupo = servicoSisLaraServerRmi
				.editarAtendimentoGrupo(moduloPeriodoDTO, atendimentoGrupoDto, resultadoDto.getToken());
		
		AtendimentoGrupoDTO atendimentoGrupoDTOApos = (AtendimentoGrupoDTO) resultadoAtualizacaoAtendimentoGrupo.obterObjetoDtoEditado();
		AtendimentoUsuarioDTO atendimentoUsuarioDTOApos = (AtendimentoUsuarioDTO) obterDaRelacaoPorId(atendimentoGrupoDTOApos.getAtendimentosUsuariosDto(), new Long(12222));

		Assert.assertTrue(resultadoAtualizacaoAtendimentoGrupo.sucesso());
		Assert.assertFalse(
				atendimentoUsuarioDTOAntes.getInformacaoAtendimentoDto().getParticipacaoDetalhadaDto().isEmpty());
		Assert.assertTrue(
				atendimentoUsuarioDTOApos.getInformacaoAtendimentoDto().getParticipacaoDetalhadaDto().isEmpty());
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_atualiza_atendimento_no_grupo_com_frequencia_FP_sem_participacoes_devido_frequencia_FP_em_todos_os_profissionais_e_usuarios()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		Long idModuloPeriodo = new Long(11111);
		
		AtendimentoGrupoDTO atendimentoGrupoDto = obterAtendimentoGrupoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), idModuloPeriodo, new Long(11111));
		AtendimentoProfissionalDTO atendimentoProfissionalDTO = (AtendimentoProfissionalDTO) obterDaRelacaoPorId(
				atendimentoGrupoDto.getAtendimentosProfissionaisDto(), new Long(12222));
		atendimentoProfissionalDTO.getInformacaoAtendimentoDto().setFrequenciaDto(new FrequenciaDTO("FP"));

		ModuloPeriodoDTO moduloPeriodoDTO = new ModuloPeriodoDTO();
		moduloPeriodoDTO.setId(idModuloPeriodo);
		ResultadoEdicaoAtendimentoGrupoDTO resultadoAtualizacaoAtendimentoGrupo = servicoSisLaraServerRmi
				.editarAtendimentoGrupo(moduloPeriodoDTO, atendimentoGrupoDto, resultadoDto.getToken());
		
		AtendimentoGrupoDTO atendimentoGrupoDTOApos = (AtendimentoGrupoDTO) resultadoAtualizacaoAtendimentoGrupo
				.obterObjetoDtoEditado();
		AtendimentoUsuarioDTO atendimentoUsuarioDTOApos = (AtendimentoUsuarioDTO) obterDaRelacaoPorId(
				atendimentoGrupoDTOApos.getAtendimentosUsuariosDto(), new Long(12222));

		Assert.assertTrue(resultadoAtualizacaoAtendimentoGrupo.sucesso());
		Assert.assertEquals(atendimentoUsuarioDTOApos.getInformacaoAtendimentoDto().getFrequenciaDto(),
				new FrequenciaDTO(Frequencia.FP.toString()));
		Assert.assertTrue(atendimentoUsuarioDTOApos.getInformacaoAtendimentoDto().getParticipacaoDetalhadaDto().isEmpty());
	}

	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_inclui_atendimento_individual_com_frequencia_FP_sem_participacoes_devido_frequencia_FP_em_todos_os_profissionais_e_usuario()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosPreCadastro();
		atendimentoIndividualDto.getAtendimentosProfissionalDto().get(0).getInformacaoAtendimentoDto()
				.setFrequenciaDto(new FrequenciaDTO("FP"));
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("12:00", "13:00"));

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());
		
		AtendimentoIndividualDTO atendimentoIndividualDTOApos = (AtendimentoIndividualDTO) resultadoEdicaoAtendimentoIndividualDto
				.obterObjetoDtoEditado();

		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertEquals(atendimentoIndividualDTOApos.getInformacaoAtendimentoDto().getFrequenciaDto(),
				new FrequenciaDTO(Frequencia.FP.toString()));
		Assert.assertTrue(atendimentoIndividualDTOApos.getInformacaoAtendimentoDto().getParticipacaoDetalhadaDto().isEmpty());
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_atualiza_atendimento_no_grupo_concorrente() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		
		Long idModuloPeriodo = new Long(11111);
		ModuloPeriodoDTO moduloPeriodoDTO = new ModuloPeriodoDTO();
		moduloPeriodoDTO.setId(idModuloPeriodo);
		
		AtendimentoGrupoDTO atendimentoGrupoDto = obterAtendimentoGrupoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), idModuloPeriodo, new Long(11111));

		ResultadoEdicaoAtendimentoGrupoDTO resultadoAtualizacaoAtendimentoGrupo = servicoSisLaraServerRmi
				.editarAtendimentoGrupo(moduloPeriodoDTO, atendimentoGrupoDto, resultadoDto.getToken());

		ResultadoEdicaoAtendimentoGrupoDTO resultadoAtualizacaoAtendimentoGrupoConcorrente = servicoSisLaraServerRmi
				.editarAtendimentoGrupo(moduloPeriodoDTO, atendimentoGrupoDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoAtualizacaoAtendimentoGrupo.sucesso());
		Assert.assertTrue(resultadoAtualizacaoAtendimentoGrupoConcorrente.sucesso());
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_atualiza_modulo_periodo_no_grupo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		String vagas = "123";
		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		ModuloPeriodoDTO moduloPeriodoDto = obterModuloPeriodoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), new Long(11111));
		moduloPeriodoDto.setVagas(vagas);

		ResultadoEdicaoModuloPeriodoDTO resultadoAtualizacaoModuloPeriodoGrupo = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoDto.getToken());

		ResultadoListagemGrupoDTO listagemGrupoAposAtualizacaoDto = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("G02-1");
		ModuloPeriodoDTO moduloPeriodoAposAtualizacaoDto = obterModuloPeriodoDto(
				listagemGrupoAposAtualizacaoDto.getObjetosDto(), new Long(12222), new Long(11111));

		Assert.assertTrue(resultadoAtualizacaoModuloPeriodoGrupo.sucesso());
		Assert.assertTrue(moduloPeriodoAposAtualizacaoDto.getVagas().equals(vagas));
		Assert.assertNotEquals(moduloPeriodoDto.getVersao(), moduloPeriodoAposAtualizacaoDto.getVersao());
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_atualiza_modulo_periodo_no_grupo_devido_ausencia_de_atendimento_esperado_de_usuario_integrado_em_grupo_de_reuniao_de_integracao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		ResultadoAutenticacaoDTO resultadoAutenticacoSSDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaVeraPereira());

		ModuloUsuarioDTO moduloUsuarioDTO = ContextoModuloUsuario.fabricarModuloUsuarioAlternativoBDTO();
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.INTEGRADO.toString()));
		
		ResultadoListagemGrupoDTO obterListagemGrupoSS1 = servicoSisLaraServerRmi.obterListagemGrupoAtivo("SS-1");
		GrupoDTO grupoSS1Dto = (GrupoDTO) obterDaRelacaoPorId(obterListagemGrupoSS1.getObjetosDto(), new Long(66666));
		ModuloPeriodoDTO moduloPeriodoSS1DTO = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoSS1Dto.getModulosPeriodosDto(), new Long(99999));
		moduloPeriodoSS1DTO.getModulosUsuariosDto().add(moduloUsuarioDTO);
		servicoSisLaraServerRmi.editarModuloPeriodo(moduloPeriodoSS1DTO, resultadoAutenticacoSSDto.getToken());
		
		
		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		ModuloPeriodoDTO moduloPeriodoDto = obterModuloPeriodoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), new Long(11111));
		moduloPeriodoDto.getModulosUsuariosDto().add(moduloUsuarioDTO);

		ResultadoEdicaoModuloPeriodoDTO resultadoAtualizacaoModuloPeriodoGrupo = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoAtualizacaoModuloPeriodoGrupo.sucesso());
		Assert.assertTrue(resultadoAtualizacaoModuloPeriodoGrupo.obterMensagens().contains(
				"Usu�rios 82222 - Paulo possuem pend�ncia de atendimento de RI a lan�ar ou est�o com frequ�ncia diferente de AT na RI mais recente."));
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_atualiza_modulo_periodo_no_grupo_devido_atendimento_com_frequencia_diferente_de_AT_de_usuario_integrado_em_grupo_de_reuniao_de_integracao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		ResultadoAutenticacaoDTO resultadoAutenticacoVeraPereiraDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaVeraPereira());

		ModuloUsuarioDTO moduloUsuarioDTO = ContextoModuloUsuario.fabricarModuloUsuarioAlternativoBDTO();
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.INTEGRADO.toString()));
		
		ResultadoListagemGrupoDTO obterListagemGrupoSS1 = servicoSisLaraServerRmi.obterListagemGrupoAtivo("SS-1");
		GrupoDTO grupoSS1Dto = (GrupoDTO) obterDaRelacaoPorId(obterListagemGrupoSS1.getObjetosDto(), new Long(66666));
		ModuloPeriodoDTO moduloPeriodoSS1DTO = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoSS1Dto.getModulosPeriodosDto(), new Long(99999));
		moduloPeriodoSS1DTO.getModulosUsuariosDto().add(moduloUsuarioDTO);
		ResultadoEdicaoModuloPeriodoDTO resultadoEdicaoModuloPeriodoDTO = servicoSisLaraServerRmi.editarModuloPeriodo(moduloPeriodoSS1DTO, resultadoAutenticacoVeraPereiraDto.getToken());
		
		ResultadoEdicaoAtendimentoGrupoDTO resultadoEdicaoAtendimentoGrupo = gerar_atendimento_de_grupo_com_frequencia_fu(
				resultadoAutenticacoVeraPereiraDto, "SS-1", new Long(66666), new Long(99999), "01/01/2000",
				moduloUsuarioDTO.getUsuarioDto().getId());
		
		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		ModuloPeriodoDTO moduloPeriodoDto = obterModuloPeriodoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), new Long(11111));
		moduloPeriodoDto.getModulosUsuariosDto().add(moduloUsuarioDTO);

		ResultadoEdicaoModuloPeriodoDTO resultadoAtualizacaoModuloPeriodoGrupo = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoEdicaoAtendimentoGrupo.sucesso());
		Assert.assertTrue(resultadoEdicaoModuloPeriodoDTO.sucesso());
		Assert.assertFalse(resultadoAtualizacaoModuloPeriodoGrupo.sucesso());
		Assert.assertTrue(resultadoAtualizacaoModuloPeriodoGrupo.obterMensagens().contains(
				"Usu�rios 82222 - Paulo possuem pend�ncia de atendimento de RI a lan�ar ou est�o com frequ�ncia diferente de AT na RI mais recente."));
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_inclui_usuario_com_status_provisorio_no_grupo_AEE_com_usuario_contendo_status_provisorio_acesso_ou_integrado_em_grupo_distinto_com_descricao_do_mesmo_tipo()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaShivas());
		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G08-1");
		ModuloPeriodoDTO moduloPeriodoDto = obterModuloPeriodoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(15555), new Long(12345));
		ModuloUsuarioDTO moduloUsuarioDTO = ContextoModuloUsuario.fabricarModuloUsuarioDTO();
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.PROVISORIO.toString()));
		moduloPeriodoDto.getModulosUsuariosDto().add(moduloUsuarioDTO);
		
		ResultadoEdicaoModuloPeriodoDTO resultadoAtualizacaoModuloPeriodoGrupo = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoAtualizacaoModuloPeriodoGrupo.sucesso());
		Assert.assertTrue(resultadoAtualizacaoModuloPeriodoGrupo.obterMensagens().contains(
				"Usu�rio(s) 12222 - Paulo j� est�o com status PROVISORIO, ACESSO ou INTEGRADO em outro grupo ativo de Atendimento Especializado Global, m�dulo AEE."));
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_altera_usuario_com_status_provisorio_no_grupo_AEE_com_usuario_contendo_status_provisorio_acesso_ou_integrado_em_grupo_distinto_com_descricao_do_mesmo_tipo()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaShivas());
		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G06-1");
		ModuloPeriodoDTO moduloPeriodoDto = obterModuloPeriodoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(14444), new Long(77777));
		ModuloUsuarioDTO moduloUsuarioDTO = (ModuloUsuarioDTO) obterDaRelacaoPorId(
				moduloPeriodoDto.getModulosUsuariosDto(), new Long(44444));
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.PROVISORIO.toString()));
		moduloPeriodoDto.getModulosUsuariosDto().add(moduloUsuarioDTO);
		
		ResultadoEdicaoModuloPeriodoDTO resultadoAtualizacaoModuloPeriodoGrupo = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoAtualizacaoModuloPeriodoGrupo.sucesso());
		Assert.assertTrue(resultadoAtualizacaoModuloPeriodoGrupo.obterMensagens().contains(
				"Usu�rio(s) 12222 - Jose Augusto Siqueira j� est�o com status PROVISORIO, ACESSO ou INTEGRADO em outro grupo ativo de Atendimento Especializado Global, m�dulo AEE."));
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_propaga_status_afastado_nos_modulos_periodos_no_mesmo_grupo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		Long idGrupo = new Long(12222);
		Long idModuloPeriodo = new Long(11111);
		Long idModuloUsuario = new Long(11111);
		String status = "AFASTADO";
		String nomeGrupo = "G02-1";

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo(nomeGrupo);
		ModuloPeriodoDTO moduloPeriodoDto = alterar_status_relacao_usuario_no_modulo_periodo(resultadoListagemGrupo,
				idGrupo, idModuloPeriodo, idModuloUsuario, status);

		servicoSisLaraServerRmi.editarModuloPeriodo(moduloPeriodoDto, resultadoDto.getToken());

		ResultadoListagemGrupoDTO listagemGrupoAposAtualizacaoDto = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo(nomeGrupo);

		ModuloPeriodoDTO moduloPeriodoAposAtualizacaoDto = obterModuloPeriodoDto(
				listagemGrupoAposAtualizacaoDto.getObjetosDto(), idGrupo, idModuloPeriodo);
		ModuloUsuarioDTO moduloUsuarioAPosAtualizacaoDTO = (ModuloUsuarioDTO) obterDaRelacaoPorId(
				moduloPeriodoAposAtualizacaoDto.getModulosUsuariosDto(), idModuloUsuario);

		Assert.assertEquals(new StatusDTO(status).toString(),
				moduloUsuarioAPosAtualizacaoDTO.getStatusDto().toString());
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	// Depende de data de inicio dos grupos id 12222 e 14444 atualizados para o
	// ano corrente
	public void servico_atualiza_status_de_usuario_para_desligado_apos_atualizacao_de_relacao_com_modulo_periodo_no_grupo()
			throws RemoteException {
		
		ResultadoAutenticacaoDTO resultadoAutenticacaoDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		
  		MaquinaTempo.mudarDataAtual("01/01/2016");
		UsuarioDTO usuarioDTO = servico_altera_relacao_de_modulo_usuario_e_retornar_usuario_refenciado(resultadoAutenticacaoDTO,
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1"), StatusRelacaoComModulo.DESLIGADO,
				new Long(12222), new Long(11111), new Long(11111));
		MaquinaTempo.restaurarDataOriginal();
		
		Assert.assertTrue(
				usuarioDTO.getStatusUsuarioAtualDto().toString().equals(StatusRelacaoComModulo.DESLIGADO.toString()));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	// Depende de data de inicio dos grupos id 12222 e 14444 atualizados para o
	// ano corrente
	public void servico_atualiza_status_de_usuario_para_integrado_apos_atualizacao_de_relacao_com_modulo_periodo_no_grupo()
			throws RemoteException {
		
		ResultadoAutenticacaoDTO resultadoAutenticacaoDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		ResultadoAutenticacaoDTO resultadoAutenticacaoShivasDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaShivas());

		MaquinaTempo.mudarDataAtual("01/01/2016");
		servico_altera_relacao_de_modulo_usuario_e_retornar_usuario_refenciado(resultadoAutenticacaoShivasDTO, 
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("G06-1"), StatusRelacaoComModulo.AFASTADO,
				new Long(14444), new Long(77777), new Long(44444));

		UsuarioDTO usuarioDTO = servico_altera_relacao_de_modulo_usuario_e_retornar_usuario_refenciado(resultadoAutenticacaoDTO, 
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1"), StatusRelacaoComModulo.INTEGRADO,
				new Long(12222), new Long(11111), new Long(11111));
		MaquinaTempo.restaurarDataOriginal();
		
		Assert.assertTrue(
				usuarioDTO.getStatusUsuarioAtualDto().toString().equals(StatusRelacaoComModulo.INTEGRADO.toString()));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_atualiza_status_de_usuario_do_cto_para_desistente_apos_periodo_de_retorno_explirar_e_remove_todas_as_esperas_aguardando()
			throws RemoteException {

		Long prontuario = new Long(12222);

		EspecificacaoPesquisaEsperaDTO especificacao = new EspecificacaoPesquisaEsperaDTO();
		especificacao.setProntuario(prontuario.toString());
		especificacao.setStatusEsperadoDto(new StatusEsperaDTO(StatusEspera.AGUARDANDO.toString()));
		especificacao.setInteresse(false);
		especificacao.setLmLigou(false);
		especificacao.setPendencias(false);

		ResultadoListagemEsperaDTO resultadoListagemEsperaAntesAplicacaoRegra = servicoSisLaraServerRmi
				.obterListagemEspera(especificacao);

		AutomatizadorTarefas automatizadorTarefas = Registro.obterAutomatizadorTarefas();
		automatizadorTarefas.executar();

		ResultadoListagemEsperaDTO resultadoListagemEsperaAposAplicacaoRegra = servicoSisLaraServerRmi
				.obterListagemEspera(especificacao);

		EspecificacaoPesquisaUsuarioDTO especificacaoPesquisaUsuarioDTO = new EspecificacaoPesquisaUsuarioDTO();
		especificacaoPesquisaUsuarioDTO.adicionarParametro(ChavePesquisaDTO.PRONTUARIO, prontuario.toString());
		ResultadoListagemUsuarioDTO resultadoPesquisaUsuarioDTO = servicoSisLaraServerRmi
				.pesquisarUsuarioPor(especificacaoPesquisaUsuarioDTO);
		UsuarioDTO usuarioDto = (UsuarioDTO) obterDaRelacaoPorId(resultadoPesquisaUsuarioDTO.getObjetosDto(),
				prontuario);

		Assert.assertTrue(
				usuarioDto.getStatusUsuarioAtualDto().toString().equals(StatusRelacaoComModulo.DESISTENTE.toString()));
		Assert.assertTrue(resultadoListagemEsperaAntesAplicacaoRegra.getObjetosDto().size() == 2);
		Assert.assertTrue(resultadoListagemEsperaAposAplicacaoRegra.getObjetosDto().isEmpty());
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_atualiza_status_de_usuario_menor_21_anos_somente_cto_de_integrado_para_retorno_apos_verificar_que_usuario_nao_esta_em_nenhum_grupo_ativo()
			throws RemoteException {

		String prontuarioEmNunhumGrupoAtivo = "18888";
		String prontuarioEmGrupoAtivo = "19999";
				
		EspecificacaoPesquisaUsuarioDTO especificacaoPesquisaUsuarioDTO = new EspecificacaoPesquisaUsuarioDTO();
		especificacaoPesquisaUsuarioDTO.adicionarParametro(ChavePesquisaDTO.PRONTUARIO, prontuarioEmNunhumGrupoAtivo);
		
		UsuarioDTO usuarioEmNennhumGrupoAtivoAntesDto = (UsuarioDTO) obterDaRelacaoPorId(
				servicoSisLaraServerRmi.pesquisarUsuarioPor(especificacaoPesquisaUsuarioDTO).getObjetosDto(),
				new Long(prontuarioEmNunhumGrupoAtivo));
		
		especificacaoPesquisaUsuarioDTO.adicionarParametro(ChavePesquisaDTO.PRONTUARIO, prontuarioEmGrupoAtivo);
		UsuarioDTO usuarioEmGrupoAtivoAntesDto = (UsuarioDTO) obterDaRelacaoPorId(
				servicoSisLaraServerRmi.pesquisarUsuarioPor(especificacaoPesquisaUsuarioDTO).getObjetosDto(),
				new Long(prontuarioEmGrupoAtivo));
		
		AutomatizadorTarefas automatizadorTarefas = Registro.obterAutomatizadorTarefas();
		automatizadorTarefas.atualizarStatusDeUsuariosSomenteCTOMenor21AnosEmNenhumGrupoAtivoDeIntegradoParaRetorno();
		
		especificacaoPesquisaUsuarioDTO.adicionarParametro(ChavePesquisaDTO.PRONTUARIO, prontuarioEmNunhumGrupoAtivo);
		UsuarioDTO usuarioEmNenhumGrupoAtivoAposDto = (UsuarioDTO) obterDaRelacaoPorId(servicoSisLaraServerRmi
				.pesquisarUsuarioPor(especificacaoPesquisaUsuarioDTO).getObjetosDto(),
				new Long(prontuarioEmNunhumGrupoAtivo));
		
		especificacaoPesquisaUsuarioDTO.adicionarParametro(ChavePesquisaDTO.PRONTUARIO, prontuarioEmGrupoAtivo);
		UsuarioDTO usuarioEmGrupoAtivoAposDto = (UsuarioDTO) obterDaRelacaoPorId(servicoSisLaraServerRmi
				.pesquisarUsuarioPor(especificacaoPesquisaUsuarioDTO).getObjetosDto(),
				new Long(prontuarioEmGrupoAtivo));

		Assert.assertTrue(usuarioEmNennhumGrupoAtivoAntesDto.isAssociadoAoSetorCTO());
		Assert.assertTrue(usuarioEmGrupoAtivoAntesDto.isAssociadoAoSetorCTO());
		Assert.assertEquals(usuarioEmNennhumGrupoAtivoAntesDto.getStatusUsuarioAtualDto(),
				new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.INTEGRADO.toString()));
		Assert.assertEquals(usuarioEmGrupoAtivoAntesDto.getStatusUsuarioAtualDto(),
				new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.INTEGRADO.toString()));
		Assert.assertEquals(usuarioEmNenhumGrupoAtivoAposDto.getStatusUsuarioAtualDto(),
				new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.RETORNO.toString()));
		Assert.assertEquals(usuarioEmGrupoAtivoAposDto.getStatusUsuarioAtualDto(),
				new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.INTEGRADO.toString()));
	}
	
	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_mantem_status_de_usuario_do_cto_como_desistente_apos_periodo_de_retorno_explirar_e_mais_de_uma_execucao_do_processo_ser_efetivada()
			throws RemoteException {

		AutomatizadorTarefas automatizadorTarefas = Registro.obterAutomatizadorTarefas();
		automatizadorTarefas.executar();
		automatizadorTarefas.executar();

		EspecificacaoPesquisaUsuarioDTO especificacaoPesquisaUsuarioDTO = new EspecificacaoPesquisaUsuarioDTO();
		especificacaoPesquisaUsuarioDTO.adicionarParametro(ChavePesquisaDTO.PRONTUARIO, "82222");
		ResultadoListagemUsuarioDTO resultadoPesquisaUsuarioDTO = servicoSisLaraServerRmi
				.pesquisarUsuarioPor(especificacaoPesquisaUsuarioDTO);
		UsuarioDTO usuarioDto = (UsuarioDTO) obterDaRelacaoPorId(resultadoPesquisaUsuarioDTO.getObjetosDto(),
				new Long(82222));

		Assert.assertTrue(
				usuarioDto.getStatusUsuarioAtualDto().toString().equals(StatusRelacaoComModulo.DESISTENTE.toString()));
	}

	@Test(groups = { TiposDeTeste.CONTRIBUINTE })
	public void servico_gera_arquivo_de_cobranca_de_contribuicoes_com_sucesso() throws Exception {
		RepositorioSislara repositorioSislara = Registro.obterRepositorioSislara();
		repositorioSislara.aplicarSequence(new Long(96755));
		AutomatizadorContribuicao automatizadorContribuicao = Registro.obterAutomatizadorContribuicao();
		automatizadorContribuicao.gerarArquivosCobranca(DataHoraUtils.criar("03/08/2015"));
		Collection<File> arquivoDeConfiguracaoECobranca = FileUtils.listFiles(
				new File(new Configuracao().obterConfiguracao(Configuracao.DIRETORIO_ARQUIVOS_COBRANCAS)), null, true);
		String conteudoArquivoCobranca = "";
		for (File arquivo : arquivoDeConfiguracaoECobranca) {
			if (!arquivo.getName().endsWith("zip")) {
				conteudoArquivoCobranca = FileUtils.readFileToString(arquivo, Charset.defaultCharset());
			}
		}

		// 2 arquivos, o original e o zipado.
		Assert.assertTrue(arquivoDeConfiguracaoECobranca.size() == 2);
		Assert.assertEquals(conteudoArquivoCobranca,
				"01REMESSA01COBRANCA       197600018000        LARAMARA ASS.BRAS.ASSIST.AO DE341BANCO ITAU SA  030815                                                                                                                                                                                                                                                                                                      000001\n"
						+ "611976000180001730009675590REAL000000000500096755           99A03081500000000000000000ARAKEN A. GOMES                        R. DONA EPONIMA AFONSECA, 226                       04720010SAO PAULO      SP                                                                                                                                                01000000000000000                               000002\n"
						+ "62LARAMARA ASSOC.BRAS.DE ASSIST.AO DEF.VISUAL                          CNPJ.67.640.441/0001-29                                              PABX 3660-6400                 SITE: WWW.LARAMARA.ORG.BR             TEL: 3660-6447                                                                                                                                                                           000003\n"
						+ "63                                                                     LARAMARA - AJUDANDO A TRANSFORMAR VIDAS                                                                                                   FINALIDADE: DONATIVO - PAGAVEL EM QUALQUER BANCO                                                                                                                                         000004\n"
						+ "611976000180001730009675670REAL000000000200096756           99A03081500000000000000000ANTONIO ALUIZIO RUSSO                  RUA FRANCISCO FAREL, 209 AP 100                     05436070SAO PAULO      SP                                                                                                                                                01000000000000000                               000005\n"
						+ "62LARAMARA ASSOC.BRAS.DE ASSIST.AO DEF.VISUAL                          CNPJ.67.640.441/0001-29                                              PABX 3660-6400                 SITE: WWW.LARAMARA.ORG.BR             TEL: 3660-6447                                                                                                                                                                           000006\n"
						+ "63                                                                     LARAMARA - AJUDANDO A TRANSFORMAR VIDAS                                                                                                   FINALIDADE: DONATIVO - PAGAVEL EM QUALQUER BANCO                                                                                                                                         000007\n"
						+ "9                                                                                                                                                                                                                                                                                                                                                                                                         000008\n");
	}

	@Test(groups = { TiposDeTeste.CONTRIBUINTE })
	public void servico_gera_arquivo_de_cobranca_de_contribuicoes_com_sucesso_anternativo() throws Exception {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		boolean resultado = servicoSisLaraServerRmi.solicitarGeracaoArquivoCobranca(resultadoDto.getToken());

		Assert.assertTrue(resultado);
	}

	@Test(groups = { TiposDeTeste.CONTRIBUINTE })
	public void servico_nao_gera_arquivo_de_cobranca_de_contribuicoes_sem_permissao() throws Exception {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());
		boolean resultado = servicoSisLaraServerRmi.solicitarGeracaoArquivoCobranca(resultadoDto.getToken());

		Assert.assertFalse(resultado);
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_atualiza_status_de_usuario_para_retorno_por_ter_menos_de_21_anos_e_estar_com_status_desistente()
			throws RemoteException {

		AutomatizadorTarefas automatizadorTarefas = Registro.obterAutomatizadorTarefas();
		automatizadorTarefas.executar();

		EspecificacaoPesquisaUsuarioDTO especificacaoPesquisaUsuarioDTO = new EspecificacaoPesquisaUsuarioDTO();
		especificacaoPesquisaUsuarioDTO.adicionarParametro(ChavePesquisaDTO.PRONTUARIO, "72222");
		ResultadoListagemUsuarioDTO resultadoPesquisaUsuarioDTO = servicoSisLaraServerRmi
				.pesquisarUsuarioPor(especificacaoPesquisaUsuarioDTO);
		UsuarioDTO usuarioDto = (UsuarioDTO) obterDaRelacaoPorId(resultadoPesquisaUsuarioDTO.getObjetosDto(),
				new Long(72222));

		Assert.assertTrue(
				usuarioDto.getStatusUsuarioAtualDto().toString().equals(StatusRelacaoComModulo.RETORNO.toString()));
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_calcula_valor_total_a_partir_recurso_e_quantidade() throws RemoteException {
		String valorTotal = servicoSisLaraServerRmi.obterValorTotalPorDeRecurso(ContextoRecurso.construirRecursoDTO(),
				"3");

		Assert.assertEquals(valorTotal, "7500,00");
	}
	//TODO: REMOVER
	/*
	@Test(groups = { TiposDeTeste.PROJETO })
	public void servico_recalcula_totais_projeto_com_sucesso() throws RemoteException {

		String quantidade = "3";
		ResultadoListagemProjetoDTO resultadoListagemProjetos = servicoSisLaraServerRmi.obterListagemProjetoAtivos();
		ProjetoDTO projetoDto = (ProjetoDTO) obterDaRelacaoPorId(resultadoListagemProjetos.getObjetosDto(),
				new Long(1222));

		String valorSomaTotalProdutoAntesRecalculacao = projetoDto.getSomaTotalProdutos();
		RecursoDisponivelDTO recursoDisponivelDTO = ((RecursoDisponivelDTO) obterDaRelacaoPorId(projetoDto.getRecursoDisponivelDto(),
				new Long(12345)));
		recursoDisponivelDTO.setQuantidade(quantidade);
		recursoDisponivelDTO
				.setValorUnitario(servicoSisLaraServerRmi.obterValorTotalPorDeRecurso(recursoDisponivelDTO.getRecursoDto(), quantidade));

		ResultadoEdicaoProjetoDTO resultadoEdicaoProjetoAposRecalculacaoDTO = servicoSisLaraServerRmi.calcularTotais(projetoDto);

		Assert.assertEquals(valorSomaTotalProdutoAntesRecalculacao, "5100,00");
		Assert.assertEquals(((ProjetoDTO) resultadoEdicaoProjetoAposRecalculacaoDTO.obterObjetoDtoEditado()).getSomaTotalProdutos(),
				"7600,00");
	}
	*/
	@Test(groups = { TiposDeTeste.ESPERA })
	public void servico_remove_espera_com_data_expectavia_expirada_ha_mais_de_dois_anos_com_usuario_menor_de_21_anos_sem_nenhum_atendimento_no_periodo()
			throws RemoteException {
		
		EspecificacaoPesquisaEsperaDTO especificacaoPesquisaEsperaDto = new EspecificacaoPesquisaEsperaDTO();
		especificacaoPesquisaEsperaDto.setDataInicio("01/01/2000");
		especificacaoPesquisaEsperaDto.setDataTermino("31/12/2999");
		especificacaoPesquisaEsperaDto.setStatusEsperadoDto(new StatusEsperaDTO(StatusEspera.AGUARDANDO.toString()));
		especificacaoPesquisaEsperaDto.setInteresse(false);
		especificacaoPesquisaEsperaDto.setLmLigou(false);
		especificacaoPesquisaEsperaDto.setPendencias(false);
		
		ResultadoListagemEsperaDTO resultadoListagemEsperaAntesDTO = servicoSisLaraServerRmi.obterListagemEspera(especificacaoPesquisaEsperaDto);
		
		MaquinaTempo.mudarDataAtual("03/11/2010");
		Registro.obterAutomatizadorTarefas().executar();
		ResultadoListagemEsperaDTO resultadoListagemEsperaAguardandoDTO = servicoSisLaraServerRmi.obterListagemEspera(especificacaoPesquisaEsperaDto);
		EsperaDTO esperaAguardandoDTO = (EsperaDTO) obterDaRelacaoPorId(resultadoListagemEsperaAguardandoDTO.getObjetosDto(), new Long(15555));
		MaquinaTempo.restaurarDataOriginal();
		
		MaquinaTempo.mudarDataAtual("03/06/2017");
		Registro.obterAutomatizadorTarefas().executar();
		especificacaoPesquisaEsperaDto.setStatusEsperadoDto(new StatusEsperaDTO(StatusEspera.CANCELADO.toString()));
		ResultadoListagemEsperaDTO resultadoListagemEsperaCanceladaDTO = servicoSisLaraServerRmi.obterListagemEspera(especificacaoPesquisaEsperaDto);
		EsperaDTO esperaCanceladaDTO = (EsperaDTO) obterDaRelacaoPorId(resultadoListagemEsperaCanceladaDTO.getObjetosDto(), new Long(16666));
		MaquinaTempo.restaurarDataOriginal();
		
		especificacaoPesquisaEsperaDto.setStatusEsperadoDto(new StatusEsperaDTO(StatusEspera.AGUARDANDO.toString()));
		ResultadoListagemEsperaDTO resultadoListagemEsperaAposDTO = servicoSisLaraServerRmi.obterListagemEspera(especificacaoPesquisaEsperaDto);
		
		Assert.assertEquals(resultadoListagemEsperaAntesDTO.getObjetosDto().size(), 6);
		Assert.assertEquals(resultadoListagemEsperaAposDTO.getObjetosDto().size(), 2);
		Assert.assertEquals(esperaAguardandoDTO.getStatusDto(),
				new StatusEsperaDTO(StatusEspera.AGUARDANDO.toString()));
		Assert.assertEquals(esperaCanceladaDTO.getStatusDto(), new StatusEsperaDTO(StatusEspera.CANCELADO.toString()));
		Assert.assertTrue(esperaCanceladaDTO.getJustificativaCancelamento().contains(
				"Em caso de interesse agendar SOMENTE SERVI�O SOCIAL. Cancelamento efetuado automaticamente na espera de avalia��o CTO com data de expectativa expirada h� 2 anos, com usu�rio menor de 21 anos, sem nenhum atendimento no per�odo."));
	}
	//TODO: AJUSTAR
	/*
	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_reserva_recursos_para_demandas_aguardando()
			throws RemoteException {
		
		StatusDemandaDTO statusDemandaReservadoDto = new StatusDemandaDTO("RESERVADO");
		StatusDemandaDTO statusDemandaAguardandoDto = new StatusDemandaDTO("AGUARDANDO");
		
		EspecificacaoPesquisaDemandaDTO especificacao = new EspecificacaoPesquisaDemandaDTO();
		especificacao.setRecursoDto(ContextoRecurso.construirRecursoDTO());
		ResultadoListagemDemandaDTO resultadoListagemDemandasMaquinaBrailleAntes = servicoSisLaraServerRmi.obterListagemDemanda(especificacao);
		especificacao.setRecursoDto(ContextoRecurso.construirRecursoAlternativoDTO());
		ResultadoListagemDemandaDTO resultadoListagemDemandasBengalaAntes = servicoSisLaraServerRmi.obterListagemDemanda(especificacao);

		ResultadoListagemProjetoDTO resultadoListagemProjetosAntesReservas = servicoSisLaraServerRmi.obterListagemProjetoAtivos();
		ProjetoDTO projetoAntesReservasDto = (ProjetoDTO) obterDaRelacaoPorId(
				resultadoListagemProjetosAntesReservas.getObjetosDto(), new Long(12222));
		
		DemandaDTO demandaMaquinaDto13333AguardandoAntes = (DemandaDTO) obterDaRelacaoPorId(
				resultadoListagemDemandasMaquinaBrailleAntes.getObjetosDto(), new Long(13333));
		DemandaDTO demandaMaquinaDto14444AguardandoAntes = (DemandaDTO) obterDaRelacaoPorId(
				resultadoListagemDemandasMaquinaBrailleAntes.getObjetosDto(), new Long(14444));	
		DemandaDTO demandaMaquinaDto15555AguardandoAntes = (DemandaDTO) obterDaRelacaoPorId(
				resultadoListagemDemandasMaquinaBrailleAntes.getObjetosDto(), new Long(15555));	
		DemandaDTO demandaBengalaDto16666AguardandoAntes = (DemandaDTO) obterDaRelacaoPorId(
				resultadoListagemDemandasBengalaAntes.getObjetosDto(), new Long(16666));	
		DemandaDTO demandaBengalaDto17777AguardandoAntes = (DemandaDTO) obterDaRelacaoPorId(
				resultadoListagemDemandasBengalaAntes.getObjetosDto(), new Long(17777));	
				
		Registro.obterAutomatizadorTarefas().executar();

		especificacao.setRecursoDto(ContextoRecurso.construirRecursoDTO());
		ResultadoListagemDemandaDTO resultadoListagemDemandasMaquinaBrailleApos = servicoSisLaraServerRmi.obterListagemDemanda(especificacao);
		especificacao.setRecursoDto(ContextoRecurso.construirRecursoAlternativoDTO());
		ResultadoListagemDemandaDTO resultadoListagemDemandasBengalaApos= servicoSisLaraServerRmi.obterListagemDemanda(especificacao);
				
		ResultadoListagemProjetoDTO resultadoListagemProjetosAposReservas = servicoSisLaraServerRmi.obterListagemProjetoAtivos();
		ProjetoDTO projetoAposReservasDto = (ProjetoDTO) obterDaRelacaoPorId(
				resultadoListagemProjetosAposReservas.getObjetosDto(), new Long(12222));
		
		DemandaDTO demandaMaquinaDto13333ReservadaApos = (DemandaDTO) obterDaRelacaoPorId(
				resultadoListagemDemandasMaquinaBrailleApos.getObjetosDto(), new Long(13333));
		DemandaDTO demandaMaquinaDto14444ReservadaApos = (DemandaDTO) obterDaRelacaoPorId(
				resultadoListagemDemandasMaquinaBrailleApos.getObjetosDto(), new Long(14444));		
		DemandaDTO demandaMaquinaDto15555AguardandoApos = (DemandaDTO) obterDaRelacaoPorId(
				resultadoListagemDemandasMaquinaBrailleApos.getObjetosDto(), new Long(15555));		
		DemandaDTO demandaBengalaDto16666ReservadaApos = (DemandaDTO) obterDaRelacaoPorId(
				resultadoListagemDemandasBengalaApos.getObjetosDto(), new Long(16666));		
		DemandaDTO demandaBengalaDto17777AguardandoApos = (DemandaDTO) obterDaRelacaoPorId(
				resultadoListagemDemandasBengalaApos.getObjetosDto(), new Long(17777));		
		
		Assert.assertEquals(demandaMaquinaDto13333AguardandoAntes.getStatusDemandaDto(), statusDemandaAguardandoDto);
		Assert.assertEquals(demandaMaquinaDto14444AguardandoAntes.getStatusDemandaDto(), statusDemandaAguardandoDto);
		Assert.assertEquals(demandaMaquinaDto15555AguardandoAntes.getStatusDemandaDto(), statusDemandaAguardandoDto);
		Assert.assertEquals(demandaMaquinaDto15555AguardandoApos.getStatusDemandaDto(), statusDemandaAguardandoDto);
		Assert.assertEquals(demandaBengalaDto16666AguardandoAntes.getStatusDemandaDto(), statusDemandaAguardandoDto);
		Assert.assertEquals(demandaBengalaDto17777AguardandoAntes.getStatusDemandaDto(), statusDemandaAguardandoDto);
		Assert.assertEquals(demandaBengalaDto17777AguardandoApos.getStatusDemandaDto(), statusDemandaAguardandoDto);
		Assert.assertTrue(projetoAntesReservasDto.getResumoReservas().isEmpty());
		
		Assert.assertEquals(demandaMaquinaDto13333ReservadaApos.getStatusDemandaDto(), statusDemandaReservadoDto);
		Assert.assertEquals(demandaMaquinaDto14444ReservadaApos.getStatusDemandaDto(), statusDemandaReservadoDto);
		Assert.assertEquals(demandaBengalaDto16666ReservadaApos.getStatusDemandaDto(), statusDemandaReservadoDto);
		Assert.assertTrue(projetoAposReservasDto.getResumoReservas().equals("Maquina Braille Laramara - 5000,00\nBengala - 100,00\n"));
	}
	*/
	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_nao_atualiza_status_de_usuario_para_retorno_devido_falta_no_atendido_em_avaliacao_funcional()
			throws RemoteException {

		UsuarioDTO usuarioDTO = servico_salva_atendimento_individual_com_setor_frequencia_descricao_e_modulo(
				new Long(16666), new SetorDTO("CTO"), new FrequenciaDTO("FU"),
				ContextoDescricaoTipoAtendimento.construirDescricaoAvaliacaoFuncionalDTO(),
				ContextoModulo.construirModuloAEE());

		Assert.assertTrue(
				usuarioDTO.getStatusUsuarioAtualDto().toString().equals(StatusRelacaoComModulo.CASO_NOVO.toString()));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_nao_atualiza_status_de_usuario_para_retorno_devido_falta_no_atendido_em_servico_social_avaliacao_e_triagem_do_PROCEJA()
			throws RemoteException {

		UsuarioDTO usuarioDTO = servico_salva_atendimento_individual_com_setor_frequencia_descricao_e_modulo(
				new Long(16666), new SetorDTO("PROCEJA"), new FrequenciaDTO("FU"),
				ContextoDescricaoTipoAtendimento.construirDescricaoServicoSocialDTO(),
				ContextoModulo.construirModuloAvaliacaoETriagemDTO());

		Assert.assertTrue(
				usuarioDTO.getStatusUsuarioAtualDto().toString().equals(StatusRelacaoComModulo.CASO_NOVO.toString()));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_nao_atualiza_usuario_caso_novo_para_retorno_por_ter_sido_efetivamente_atendido_outra_descricao_atendimento()
			throws RemoteException {

		UsuarioDTO usuarioDTO = servico_salva_atendimento_individual_com_setor_frequencia_descricao_e_modulo(
				new Long(16666), new SetorDTO("CTO"), new FrequenciaDTO("AT"),
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOftalmologia(),
				ContextoModulo.construirModuloAEE());

		Assert.assertTrue(
				usuarioDTO.getStatusUsuarioAtualDto().toString().equals(StatusRelacaoComModulo.CASO_NOVO.toString()));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_atualiza_usuario_sem_status_para_retorno_por_ter_sido_efetivamente_atendido_em_avaliacao_funcional()
			throws RemoteException {

		UsuarioDTO usuarioDTO = servico_salva_atendimento_individual_com_setor_frequencia_descricao_e_modulo(
				new Long(13333), new SetorDTO("CTO"), new FrequenciaDTO("AT"),
				ContextoDescricaoTipoAtendimento.construirDescricaoAvaliacaoFuncionalDTO(),
				ContextoModulo.construirModuloAEE());

		Assert.assertTrue(
				usuarioDTO.getStatusUsuarioAtualDto().toString().equals(StatusRelacaoComModulo.RETORNO.toString()));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_atualiza_usuario_sem_status_para_retorno_por_ter_sido_efetivamente_atendido_em_servico_social_avaliacao_e_triagem_do_PROCEJA()
			throws RemoteException {

		UsuarioDTO usuarioDTO = servico_salva_atendimento_individual_com_setor_frequencia_descricao_e_modulo(
				new Long(13333), new SetorDTO("PROCEJA"), new FrequenciaDTO("AT"),
				ContextoDescricaoTipoAtendimento.construirDescricaoServicoSocialDTO(),
				ContextoModulo.construirModuloAvaliacaoETriagemDTO());

		Assert.assertTrue(
				usuarioDTO.getStatusUsuarioAtualDto().toString().equals(StatusRelacaoComModulo.RETORNO.toString()));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_atualiza_usuario_caso_novo_para_retorno_por_ter_sido_efetivamente_atendido_em_avaliacao_funcional()
			throws RemoteException {

		UsuarioDTO usuarioDTO = servico_salva_atendimento_individual_com_setor_frequencia_descricao_e_modulo(
				new Long(16666), new SetorDTO("CTO"), new FrequenciaDTO("AT"),
				ContextoDescricaoTipoAtendimento.construirDescricaoAvaliacaoFuncionalDTO(),
				ContextoModulo.construirModuloAEE());

		Assert.assertTrue(
				usuarioDTO.getStatusUsuarioAtualDto().toString().equals(StatusRelacaoComModulo.RETORNO.toString()));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_atualiza_usuario_caso_novo_para_retorno_por_ter_sido_efetivamente_atendido_em_servico_social_avaliacao_e_triagem_do_PROCEJA()
			throws RemoteException {

		UsuarioDTO usuarioDTO = servico_salva_atendimento_individual_com_setor_frequencia_descricao_e_modulo(
				new Long(16666), new SetorDTO("PROCEJA"), new FrequenciaDTO("AT"),
				ContextoDescricaoTipoAtendimento.construirDescricaoServicoSocialDTO(),
				ContextoModulo.construirModuloAvaliacaoETriagemDTO());

		Assert.assertTrue(
				usuarioDTO.getStatusUsuarioAtualDto().toString().equals(StatusRelacaoComModulo.RETORNO.toString()));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	// Depende de data de inicio dos grupos id 12222 e 14444 atualizados para o
	// ano corrente
	public void servico_atualiza_status_de_usuario_para_afastado_apos_atualizacao_de_relacao_com_modulo_periodo_no_grupo()
			throws RemoteException {
		
		ResultadoAutenticacaoDTO resultadoAutenticacaoDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		ResultadoAutenticacaoDTO resultadoAutenticacaoShivasDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaShivas());
		
		MaquinaTempo.mudarDataAtual("31/12/2016");
		servico_altera_relacao_de_modulo_usuario_e_retornar_usuario_refenciado(resultadoAutenticacaoShivasDTO,
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("G06-1"), StatusRelacaoComModulo.DESISTENTE,
				new Long(14444), new Long(77777), new Long(44444));

		UsuarioDTO usuarioDTO = servico_altera_relacao_de_modulo_usuario_e_retornar_usuario_refenciado(resultadoAutenticacaoDTO,
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1"), StatusRelacaoComModulo.AFASTADO,
				new Long(12222), new Long(11111), new Long(11111));
		MaquinaTempo.restaurarDataOriginal();
		
		Assert.assertTrue(
				usuarioDTO.getStatusUsuarioAtualDto().toString().equals(StatusRelacaoComModulo.AFASTADO.toString()));
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_atualiza_status_de_usuario_para_provisorio_e_inclui_em_grupo_com_modulo_de_reuniao_de_integracao_com_sucesso()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaShivas());
		
		ModuloUsuarioDTO moduloUsuarioDTO = servico_atualiza_status_de_usuario_e_inclui_em_grupo_com_modulo_de_reuniao_de_integracao_com_sucesso(resultadoAutenticacaoDTO,
				StatusRelacaoComModulo.PROVISORIO, "G08-1", new Long(15555), new Long(12345), new Long(12345), "SS-1",
				new Long(66666), new Long(99999), new Long(16666));
		Assert.assertTrue(moduloUsuarioDTO.getObs()
				.contains("Inclus�o autom�tica de usu�rio INTEGRADO, PROVISORIO ou ACESSO em Reuni�o de Integra��o."));
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_atualiza_status_de_usuario_para_acesso_e_inclui_em_grupo_com_modulo_de_reuniao_de_integracao_com_sucesso()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaShivas());
		
		ModuloUsuarioDTO moduloUsuarioDTO = servico_atualiza_status_de_usuario_e_inclui_em_grupo_com_modulo_de_reuniao_de_integracao_com_sucesso(resultadoAutenticacaoDTO,
				StatusRelacaoComModulo.ACESSO, "G08-1", new Long(15555), new Long(12345), new Long(12345), "SS-1",
				new Long(66666), new Long(99999), new Long(16666));
		Assert.assertTrue(moduloUsuarioDTO.getObs()
				.contains("Inclus�o autom�tica de usu�rio INTEGRADO, PROVISORIO ou ACESSO em Reuni�o de Integra��o."));
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_atualiza_status_de_usuarios_para_provisorio_e_acesso_e_inclui_em_grupos_distintos_com_modulo_de_reuniao_de_integracao_com_sucesso()
			throws RemoteException {
		
		ResultadoAutenticacaoDTO resultadoAutenticacaoDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		ResultadoAutenticacaoDTO resultadoAutenticacaoShivasDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaShivas());

		ModuloUsuarioDTO moduloUsuarioAposInclusaoReuniaoIntegracaoSS1DTO = servico_atualiza_status_de_usuario_e_inclui_em_grupo_com_modulo_de_reuniao_de_integracao_com_sucesso(resultadoAutenticacaoDTO,
				StatusRelacaoComModulo.ACESSO, "G02-1", new Long(12222), new Long(11111), new Long(11111), "SS-1",
				new Long(66666), new Long(99999), new Long(12222));

		ModuloUsuarioDTO moduloUsuarioAposInclusaoReuniaoIntegracaoSS2DTO = servico_atualiza_status_de_usuario_e_inclui_em_grupo_com_modulo_de_reuniao_de_integracao_com_sucesso(resultadoAutenticacaoShivasDTO,
				StatusRelacaoComModulo.PROVISORIO, "G08-1", new Long(15555), new Long(12345), new Long(12345), "SS-1",
				new Long(66666), new Long(99999), new Long(16666));

		Assert.assertTrue(moduloUsuarioAposInclusaoReuniaoIntegracaoSS1DTO.getObs()
				.contains("Inclus�o autom�tica de usu�rio INTEGRADO, PROVISORIO ou ACESSO em Reuni�o de Integra��o. "));
		Assert.assertTrue(
				moduloUsuarioAposInclusaoReuniaoIntegracaoSS1DTO.getObs().contains("Solicitado pelo Grupo: G02-1"));
		Assert.assertTrue(
				moduloUsuarioAposInclusaoReuniaoIntegracaoSS1DTO.getObs().contains("Periodo referencia: [MATUTINO]"));
		Assert.assertTrue(moduloUsuarioAposInclusaoReuniaoIntegracaoSS2DTO.getObs()
				.contains("Inclus�o autom�tica de usu�rio INTEGRADO, PROVISORIO ou ACESSO em Reuni�o de Integra��o. "));
		Assert.assertTrue(
				moduloUsuarioAposInclusaoReuniaoIntegracaoSS2DTO.getObs().contains("Solicitado pelo Grupo: G08-1"));
		Assert.assertTrue(
				moduloUsuarioAposInclusaoReuniaoIntegracaoSS2DTO.getObs().contains("Periodo referencia: [VESPERTINO]"));
	}

	@Test(groups = { TiposDeTeste.PENDENCIA })
	public void servico_atualiza_status_de_usuario_para_acesso_e_nao_inclui_em_grupo_com_modulo_de_reuniao_de_integracao_devido_falta_vaga_e_deixa_na_pendencia()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaVeraPereira());
		
		ResultadoAutenticacaoDTO resultadoShivasDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaShivas());

		servico_altera_vagas_do_grupo_pelo_modulo_periodo("SS-1", new Long(99999), "0", resultadoDto.getToken());
		servico_altera_vagas_do_grupo_pelo_modulo_periodo("SS-2", new Long(44444), "0", resultadoDto.getToken());
		servico_altera_vagas_do_grupo_pelo_modulo_periodo("SS-5", new Long(54321), "0", resultadoDto.getToken());
		servico_altera_vagas_do_grupo_pelo_modulo_periodo("SS-6", new Long(654321), "0", resultadoDto.getToken());
		servico_altera_vagas_do_grupo_pelo_modulo_periodo("SS-7", new Long(7654321), "0", resultadoDto.getToken());

		servico_altera_relacao_de_modulo_usuario_e_retorno_modulo_periodo(
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("G08-1"), StatusRelacaoComModulo.ACESSO,
				new Long(15555), new Long(12345), new Long(12345), resultadoShivasDto.getToken());
		
		Registro.obterAutomatizadorPendencia().atualizarPendencias();

		ResultadoListagemPendenciaDTO resultadoListagemPendenciaDTO = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		Assert.assertEquals(resultadoListagemPendenciaDTO.getObjetosDto().size(), 1);
		Assert.assertEquals(resultadoListagemPendenciaDTO.getObjetosDto().get(0).toString(),
				"Inclus�o autom�tica do Prontu�rio 16666 em reuni�o de integra��o ser� efetuada.");
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_atualiza_status_de_usuario_para_integrado_e_inclui_em_diversos_grupos_com_modulo_de_reuniao_de_integracao_compativeis()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaVeraPereira());

		ResultadoAutenticacaoDTO resultadoPBandeiraDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		servico_altera_vagas_do_grupo_pelo_modulo_periodo("SS-1", new Long(99999), "1", resultadoDto.getToken());

		servico_altera_relacao_de_modulo_usuario_e_retorno_modulo_periodo(
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1"), StatusRelacaoComModulo.INTEGRADO,
				new Long(12222), new Long(11111), new Long(11111), resultadoPBandeiraDto.getToken());
		Registro.obterAutomatizadorPendencia().atualizarPendencias();

		List<Long> prontuariosAfetados = Arrays.asList(new Long[] { new Long(12222), new Long(72222) });

		ResultadoListagemGrupoDTO obterListagemGrupoSS1 = servicoSisLaraServerRmi.obterListagemGrupoAtivo("SS-1");
		GrupoDTO grupoSS1Dto = (GrupoDTO) obterDaRelacaoPorId(obterListagemGrupoSS1.getObjetosDto(), new Long(66666));
		ModuloPeriodoDTO moduloPeriodoSS1DTO = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoSS1Dto.getModulosPeriodosDto(), new Long(99999));
		ModuloUsuarioDTO moduloUsuarioSS1DTO = (ModuloUsuarioDTO) obterDaRelacaoPorId(
				moduloPeriodoSS1DTO.getModulosUsuariosDto(), prontuariosAfetados);

		ResultadoListagemGrupoDTO obterListagemGrupoSS2 = servicoSisLaraServerRmi.obterListagemGrupoAtivo("SS-2");
		GrupoDTO grupoSS2Dto = (GrupoDTO) obterDaRelacaoPorId(obterListagemGrupoSS2.getObjetosDto(), new Long(77777));
		ModuloPeriodoDTO moduloPeriodoSS2DTO = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoSS2Dto.getModulosPeriodosDto(), new Long(44444));
		ModuloUsuarioDTO moduloUsuarioSS2DTO = (ModuloUsuarioDTO) obterDaRelacaoPorId(
				moduloPeriodoSS2DTO.getModulosUsuariosDto(), prontuariosAfetados);

		Assert.assertTrue(moduloUsuarioSS1DTO.getObs()
				.contains("Inclus�o autom�tica de usu�rio INTEGRADO, PROVISORIO ou ACESSO em Reuni�o de Integra��o."));
		Assert.assertTrue(moduloUsuarioSS1DTO.getObs().contains("Solicitado pelo Grupo: G02-1"));
		Assert.assertTrue(moduloUsuarioSS1DTO.getObs().contains("Periodo referencia: [MATUTINO]"));
		Assert.assertTrue(moduloUsuarioSS2DTO.getObs()
				.contains("Inclus�o autom�tica de usu�rio INTEGRADO, PROVISORIO ou ACESSO em Reuni�o de Integra��o."));
		Assert.assertTrue(moduloUsuarioSS2DTO.getObs().contains("Solicitado pelo Grupo: G02-1"));
		Assert.assertTrue(moduloUsuarioSS2DTO.getObs().contains("Periodo referencia: [MATUTINO]"));
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_atualiza_status_de_usuario_para_acesso_antes_e_apos_atendimento_de_reuniao_de_integracao_e_nao_inclui_mais_de_uma_vez_em_grupo_com_modulo_de_reuniao_de_integracao_distintos()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		ResultadoAutenticacaoDTO resultadoVeraPereiraDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaVeraPereira());
		
		String nomeGrupo = "G02-1";
		Long idGrupo = new Long(12222);
		Long idModuloPeriodo = new Long(11111);
		Long idModuloUsuario = new Long(11111);
		
		servico_altera_relacao_de_modulo_usuario_e_retorno_modulo_periodo(
				servicoSisLaraServerRmi.obterListagemGrupoAtivo(nomeGrupo), StatusRelacaoComModulo.ACESSO,
				idGrupo, idModuloPeriodo, idModuloUsuario, resultadoDto.getToken());

		Registro.obterAutomatizadorPendencia().atualizarPendencias();
		
		EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentosDTO = new EspecificacaoGeracaoAtendimentoDTO(
				new Long(99999), DataHoraUtils.formatarData(MaquinaTempo.obterInstancia().obterCalendarioAtual()), new HorarioDTO("09:00",
				"10:00"));

		ResultadoEdicaoAtendimentoGrupoDTO resultadoEdicaoAtendimentoGrupoDTO = gerarEEditarAtendimento(
				especificacaoGeracaoAtendimentosDTO, resultadoVeraPereiraDto.getToken());
	
		servico_altera_relacao_de_modulo_usuario_e_retorno_modulo_periodo(
				servicoSisLaraServerRmi.obterListagemGrupoAtivo(nomeGrupo), StatusRelacaoComModulo.ACESSO,
				idGrupo, idModuloPeriodo, idModuloUsuario, resultadoDto.getToken());

		ResultadoListagemGrupoDTO resultadoListagemGrupoComReuniaoIntegracaoSemUsuarioIntegradoPorJaTerSidoIncluidoEmOutroGrupoDto = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("SS-5");
		GrupoDTO grupoComReuniaoIntegracaoSemUsuarioIntegradoPorJaTerSidoIncluidoEmOutroGrupoDto = (GrupoDTO) obterDaRelacaoPorId(
				resultadoListagemGrupoComReuniaoIntegracaoSemUsuarioIntegradoPorJaTerSidoIncluidoEmOutroGrupoDto
						.getObjetosDto(),
				new Long(54321));
		ModuloPeriodoDTO moduloPeriodoReuniaoIntegracaoSemUsuarioIntegradosPorJaTerSidoIncluidoEmOutroGrupo = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoComReuniaoIntegracaoSemUsuarioIntegradoPorJaTerSidoIncluidoEmOutroGrupoDto.getModulosPeriodosDto(),
				new Long(54321));

		Assert.assertTrue(resultadoEdicaoAtendimentoGrupoDTO.sucesso());
		Assert.assertTrue(moduloPeriodoReuniaoIntegracaoSemUsuarioIntegradosPorJaTerSidoIncluidoEmOutroGrupo
				.getModulosUsuariosDto().isEmpty()); 
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_atualiza_status_de_usuario_para_acesso_e_nao_inclui_em_grupo_com_modulo_de_reuniao_de_integracao_por_nao_ser_grupo_de_atendimento_global()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoEdicaoModuloPeriodoDTO resultadoEdicaoModuloPeriodoDTO = servico_altera_relacao_de_modulo_usuario_e_retorno_modulo_periodo(
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("CL-2"), StatusRelacaoComModulo.ACESSO,
				new Long(445566), new Long(445566), new Long(445566), resultadoDto.getToken());

		ModuloUsuarioDTO moduloUsuarioDTO = (ModuloUsuarioDTO) obterDaRelacaoPorId(
				((ModuloPeriodoDTO) resultadoEdicaoModuloPeriodoDTO.obterObjetoDtoEditado()).getModulosUsuariosDto(),
				new Long(445566));

		Assert.assertTrue(moduloUsuarioDTO.getObs().isEmpty());
		Assert.assertTrue(moduloUsuarioDTO.getStatusDto().toString().equals(StatusRelacaoComModulo.ACESSO.toString()));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	// Depende de data de inicio dos grupos id 12222 e 14444 atualizados para o
	// ano corrente
	public void servico_atualiza_status_de_usuario_para_desistente_apos_atualizacao_de_relacao_com_modulo_periodo_no_grupo()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		ResultadoAutenticacaoDTO resultadoAutenticacaoShivasDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaShivas());
		
  		MaquinaTempo.mudarDataAtual("01/01/2016");
		servico_altera_relacao_de_modulo_usuario_e_retornar_usuario_refenciado(resultadoAutenticacaoShivasDTO,
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("G06-1"), StatusRelacaoComModulo.DESISTENTE,
				new Long(14444), new Long(77777), new Long(44444));

		UsuarioDTO usuarioDTO = servico_altera_relacao_de_modulo_usuario_e_retornar_usuario_refenciado(resultadoAutenticacaoDTO,
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1"), StatusRelacaoComModulo.DESISTENTE,
				new Long(12222), new Long(11111), new Long(11111));
		MaquinaTempo.restaurarDataOriginal();
		
		Assert.assertTrue(
				usuarioDTO.getStatusUsuarioAtualDto().toString().equals(StatusRelacaoComModulo.DESISTENTE.toString()));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	// Depende de data de inicio dos grupos id 12222 e 14444 atualizados para o
	// ano corrente
	public void servico_atualiza_status_de_usuario_para_eventual_apos_atualizacao_de_relacao_com_modulo_periodo_no_grupo()
			throws RemoteException {
		
		ResultadoAutenticacaoDTO resultadoAutenticacaoDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		ResultadoAutenticacaoDTO resultadoAutenticacaoShivasDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaShivas());
		
  		MaquinaTempo.mudarDataAtual("01/01/2016");
		servico_altera_relacao_de_modulo_usuario_e_retornar_usuario_refenciado(resultadoAutenticacaoShivasDTO,
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("G06-1"), StatusRelacaoComModulo.EVENTUAL,
				new Long(14444), new Long(77777), new Long(44444));

		UsuarioDTO usuarioDTO = servico_altera_relacao_de_modulo_usuario_e_retornar_usuario_refenciado(resultadoAutenticacaoDTO,
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1"), StatusRelacaoComModulo.EVENTUAL,
				new Long(12222), new Long(11111), new Long(11111));
		MaquinaTempo.restaurarDataOriginal();
		
		Assert.assertTrue(
				usuarioDTO.getStatusUsuarioAtualDto().toString().equals(StatusRelacaoComModulo.EVENTUAL.toString()));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	// Depende de data de inicio dos grupos id 12222 e 14444 atualizados para o
	// ano corrente
	public void servico_atualiza_status_de_usuario_para_desistente_apos_atualizacao_de_relacao_com_modulo_periodo_equivalente_concluido_no_grupo()
			throws RemoteException {
		
		ResultadoAutenticacaoDTO resultadoAutenticacaoDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		ResultadoAutenticacaoDTO resultadoAutenticacaoShivasDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaShivas());
		
  		MaquinaTempo.mudarDataAtual("01/01/2016");
		servico_altera_relacao_de_modulo_usuario_e_retornar_usuario_refenciado(resultadoAutenticacaoShivasDTO,
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("G06-1"), StatusRelacaoComModulo.CONCLUIDO,
				new Long(14444), new Long(77777), new Long(44444));

		UsuarioDTO usuarioDTO = servico_altera_relacao_de_modulo_usuario_e_retornar_usuario_refenciado(resultadoAutenticacaoDTO,
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1"), StatusRelacaoComModulo.CONCLUIDO,
				new Long(12222), new Long(11111), new Long(11111));
		MaquinaTempo.restaurarDataOriginal();
		
		Assert.assertTrue(
				usuarioDTO.getStatusUsuarioAtualDto().toString().equals(StatusRelacaoComModulo.DESISTENTE.toString()));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	// Depende de data de inicio dos grupos id 12222 e 14444 atualizados para o
	// ano corrente
	public void servico_atualiza_status_de_usuario_para_desistente_apos_atualizacao_de_relacao_com_modulo_periodo_equivalente_frequentou_no_grupo()
			throws RemoteException {
		
		ResultadoAutenticacaoDTO resultadoAutenticacaoDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		ResultadoAutenticacaoDTO resultadoAutenticacaoShivasDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaShivas());
		
  		MaquinaTempo.mudarDataAtual("01/01/2016");
		servico_altera_relacao_de_modulo_usuario_e_retornar_usuario_refenciado(resultadoAutenticacaoShivasDTO,
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("G06-1"), StatusRelacaoComModulo.FREQUENTOU,
				new Long(14444), new Long(77777), new Long(44444));

		UsuarioDTO usuarioDTO = servico_altera_relacao_de_modulo_usuario_e_retornar_usuario_refenciado(resultadoAutenticacaoDTO,
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1"), StatusRelacaoComModulo.FREQUENTOU,
				new Long(12222), new Long(11111), new Long(11111));
		MaquinaTempo.restaurarDataOriginal();
		
		Assert.assertTrue(
				usuarioDTO.getStatusUsuarioAtualDto().toString().equals(StatusRelacaoComModulo.DESISTENTE.toString()));
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	// Depende de data de inicio dos grupos id 12222 e 14444 atualizados para o
	// ano corrente
	public void servico_atualiza_status_de_usuario_para_desistente_apos_atualizacao_de_relacao_com_modulo_periodo_equivalente_participou_no_grupo()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		ResultadoAutenticacaoDTO resultadoAutenticacaoShivasDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaShivas());
		
  		MaquinaTempo.mudarDataAtual("01/01/2016");
		servico_altera_relacao_de_modulo_usuario_e_retornar_usuario_refenciado(resultadoAutenticacaoShivasDTO,
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("G06-1"), StatusRelacaoComModulo.PARTICIPOU,
				new Long(14444), new Long(77777), new Long(44444));

		UsuarioDTO usuarioDTO = servico_altera_relacao_de_modulo_usuario_e_retornar_usuario_refenciado(resultadoAutenticacaoDTO,
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1"), StatusRelacaoComModulo.PARTICIPOU,
				new Long(12222), new Long(11111), new Long(11111));
		MaquinaTempo.restaurarDataOriginal();
		
		Assert.assertTrue(
				usuarioDTO.getStatusUsuarioAtualDto().toString().equals(StatusRelacaoComModulo.DESISTENTE.toString()));
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_atualiza_modulo_periodo_no_grupo_com_erro_obrigatoriedade() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		ModuloPeriodoDTO moduloPeriodoDto = obterModuloPeriodoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), new Long(11111));
		moduloPeriodoDto.getDiasSemanaEHorariosDaAtividadeDto().clear();

		ResultadoEdicaoModuloPeriodoDTO resultadoAtualizacaoModuloPeriodoGrupo = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoAtualizacaoModuloPeriodoGrupo.sucesso());
		Assert.assertEquals(resultadoAtualizacaoModuloPeriodoGrupo.obterMensagens(),
				"Insira um conjunto de Dia da Semana e Horario.\n\n");
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_atualiza_modulo_periodo_no_grupo_com_erro_concorrencia() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		ModuloPeriodoDTO moduloPeriodoDto = obterModuloPeriodoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), new Long(11111));

		ResultadoEdicaoModuloPeriodoDTO resultadoAtualizacaoModuloPeriodoGrupo = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoDto.getToken());

		ResultadoEdicaoModuloPeriodoDTO resultadoAtualizacaoModuloPeriodoGrupoConcorrente = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoAtualizacaoModuloPeriodoGrupo.sucesso());
		Assert.assertFalse(resultadoAtualizacaoModuloPeriodoGrupoConcorrente.sucesso());
		Assert.assertEquals(resultadoAtualizacaoModuloPeriodoGrupoConcorrente.obterMensagens(),
				"Os dados foram alterados por outro usu�rio do sistema. Por favor, tente novamente.\n");
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_atualiza_modulo_periodo_no_grupo_com_erro_concorrencia_apos_edicao_grupo()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		ModuloPeriodoDTO moduloPeriodoDto = obterModuloPeriodoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), new Long(11111));

		ResultadoEdicaoGrupoDTO resultadoAtualizacaoGrupo = servicoSisLaraServerRmi.editarGrupo(
				(GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222)),
				resultadoDto.getToken());

		ResultadoEdicaoModuloPeriodoDTO resultadoAtualizacaoModuloPeriodoGrupoConcorrente = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoAtualizacaoGrupo.sucesso());
		Assert.assertFalse(resultadoAtualizacaoModuloPeriodoGrupoConcorrente.sucesso());
		Assert.assertEquals(resultadoAtualizacaoModuloPeriodoGrupoConcorrente.obterMensagens(),
				"Os dados foram alterados por outro usu�rio do sistema. Por favor, tente novamente.\n");
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_atualiza_modulo_periodo_no_grupo_com_erro_concorrencia_apos_geracao_atendimento()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		ModuloPeriodoDTO moduloPeriodoDto = obterModuloPeriodoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), new Long(11111));

		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222));

		EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentosDTO = new EspecificacaoGeracaoAtendimentoDTO(
				((ModuloPeriodoDTO) obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(), new Long(11111))).getId(),
				"31/12/2012", new HorarioDTO("22:22", "23:00"));

		ResultadoEdicaoAtendimentoGrupoDTO resultadoGeracaoAtendimentosGrupo = gerarEEditarAtendimento(
				especificacaoGeracaoAtendimentosDTO, resultadoDto.getToken());

		ResultadoEdicaoModuloPeriodoDTO resultadoAtualizacaoModuloPeriodoGrupoConcorrente = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoGeracaoAtendimentosGrupo.sucesso());
		Assert.assertFalse(resultadoAtualizacaoModuloPeriodoGrupoConcorrente.sucesso());
		Assert.assertEquals(resultadoAtualizacaoModuloPeriodoGrupoConcorrente.obterMensagens(),
				"Os dados foram alterados por outro usu�rio do sistema. Por favor, tente novamente.\n");
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_atualiza_modulo_periodo_no_grupo_com_erro_concorrencia_apos_edicao_atendimento_grupo()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");

		ModuloPeriodoDTO moduloPeriodoDto = obterModuloPeriodoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), new Long(11111));

		AtendimentoGrupoDTO atendimentoGrupoDto = obterAtendimentoGrupoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), new Long(11111), new Long(11111));

		ResultadoEdicaoAtendimentoGrupoDTO resultadoAtualizacaoAtendimentoGrupo = servicoSisLaraServerRmi
				.editarAtendimentoGrupo(moduloPeriodoDto, atendimentoGrupoDto, resultadoDto.getToken());

		ResultadoEdicaoModuloPeriodoDTO resultadoAtualizacaoModuloPeriodoGrupoConcorrente = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoAtualizacaoAtendimentoGrupo.sucesso());
		Assert.assertFalse(resultadoAtualizacaoModuloPeriodoGrupoConcorrente.sucesso());
		Assert.assertEquals(resultadoAtualizacaoModuloPeriodoGrupoConcorrente.obterMensagens(),
				"Os dados foram alterados por outro usu�rio do sistema. Por favor, tente novamente.\n");
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_atualiza_modulo_periodo_no_grupo_sem_autorizacao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		ModuloPeriodoDTO moduloPeriodoDto = obterModuloPeriodoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), new Long(11111));

		ResultadoEdicaoModuloPeriodoDTO resultadoAtualizacaoModuloPeriodoGrupo = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoAtualizacaoModuloPeriodoGrupo.sucesso());
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_altera_grupo_por_causa_da_concorrencia() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemDto = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");

		GrupoDTO grupoAAlterarDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemDto.getObjetosDto(),
				new Long(12222));
		grupoAAlterarDto.setVersao("1222");

		ResultadoEdicaoGrupoDTO resultadoAlteracaoGrupo = servicoSisLaraServerRmi.editarGrupo(grupoAAlterarDto,
				resultadoDto.getToken());

		Assert.assertFalse(resultadoAlteracaoGrupo.sucesso());
		Assert.assertEquals(resultadoAlteracaoGrupo.obterMensagens(),
				"Os dados foram alterados por outro usu�rio do sistema. Por favor, tente novamente.\n");
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_inclui_novo_grupo_com_incosistencia() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		GrupoDTO grupoASalvarDto = ContextoGrupo.construirGrupoDTO();
		grupoASalvarDto.setNivel("AAA");

		ResultadoEdicaoGrupoDTO resultadoInclusaoGrupo = servicoSisLaraServerRmi.editarGrupo(grupoASalvarDto,
				resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoGrupo.sucesso());
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_inclui_novo_grupo_duplicado() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		GrupoDTO grupoASalvarDto = ContextoGrupo.construirGrupoDTOSemAtendimentos();

		ResultadoEdicaoGrupoDTO resultadoInclusaoGrupo = servicoSisLaraServerRmi.editarGrupo(grupoASalvarDto,
				resultadoDto.getToken());

		ResultadoEdicaoGrupoDTO resultadoInclusaoGrupoComErro = servicoSisLaraServerRmi.editarGrupo(grupoASalvarDto,
				resultadoDto.getToken());

		Assert.assertTrue(resultadoInclusaoGrupo.sucesso());
		Assert.assertFalse(resultadoInclusaoGrupoComErro.sucesso());
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_inclui_grupo_sem_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		GrupoDTO grupoASalvarDto = ContextoGrupo.construirGrupoDTO();

		ResultadoEdicaoGrupoDTO resultadoInclusaoGrupo = servicoSisLaraServerRmi.editarGrupo(grupoASalvarDto,
				resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoGrupo.sucesso());
		Assert.assertNotNull(resultadoInclusaoGrupo.obterMensagens());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_modulo_periodo_com_erro() throws RemoteException {
		ModuloPeriodoDTO moduloPeriodoDto = new ModuloPeriodoDTO();
		ResultadoValidacaoModuloPeriodoDTO resultadoValidacaoModuloPeriodo = servicoSisLaraServerRmi
				.validarModuloPeriodo(moduloPeriodoDto);

		Assert.assertFalse(resultadoValidacaoModuloPeriodo.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_modulo_pre_cadastro_e_usuario_com_erro_duplicacao() throws RemoteException {

		ModuloUsuarioDTO moduloUsuarioDTO = ContextoModuloUsuario.fabricarModuloUsuarioDTO();
		moduloUsuarioDTO.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacao());
		List<ModuloUsuarioDTO> modulosUsuario = new ArrayList<ModuloUsuarioDTO>();
		modulosUsuario.add(moduloUsuarioDTO);

		ModuloPreCadastroDTO moduloPreCadastroDTO = ContextoModuloPreCadastro.fabricarModuloPreCadastroDTO();
		moduloPreCadastroDTO.setPreCadastroDto(ContextoPreCadastro.construirPreCadastroDTO());
		List<ModuloPreCadastroDTO> modulosPreCadastro = new ArrayList<ModuloPreCadastroDTO>();
		modulosPreCadastro.add(moduloPreCadastroDTO);

		ResultadoValidacaoModuloRelacaoBaseDTO resultadoValidacaoModuloUsuario = servicoSisLaraServerRmi
				.validarModuloRelacaoBase(modulosUsuario, moduloUsuarioDTO);
		ResultadoValidacaoModuloRelacaoBaseDTO resultadoValidacaoModuloPreCadastro = servicoSisLaraServerRmi
				.validarModuloRelacaoBase(modulosPreCadastro, moduloPreCadastroDTO);

		Assert.assertFalse(resultadoValidacaoModuloUsuario.sucesso());
		Assert.assertTrue(resultadoValidacaoModuloUsuario.obterMensagens().contains("O Usu�rio j� est� integrado."));
		Assert.assertFalse(resultadoValidacaoModuloPreCadastro.sucesso());
		Assert.assertTrue(resultadoValidacaoModuloPreCadastro.obterMensagens().contains("O Pr�-Cadastro j� est� integrado."));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_modulo_pre_cadastro_usuario_sem_erro_duplicacao() throws RemoteException {

		ModuloUsuarioDTO moduloUsuarioDTO = ContextoModuloUsuario.fabricarModuloUsuarioDTO();
		moduloUsuarioDTO.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacao());
		List<ModuloUsuarioDTO> modulosUsuario = new ArrayList<ModuloUsuarioDTO>();

		ModuloPreCadastroDTO moduloPreCadastroDTO = ContextoModuloPreCadastro.fabricarModuloPreCadastroDTOSemErro();
		moduloPreCadastroDTO.setPreCadastroDto(ContextoPreCadastro.construirPreCadastroDTO());
		List<ModuloPreCadastroDTO> modulosPreCadastro = new ArrayList<ModuloPreCadastroDTO>();

		ResultadoValidacaoModuloRelacaoBaseDTO resultadoValidacaoModuloUsuario = servicoSisLaraServerRmi
				.validarModuloRelacaoBase(modulosUsuario, moduloUsuarioDTO);
		ResultadoValidacaoModuloRelacaoBaseDTO resultadoValidacaoModuloPreCadastro = servicoSisLaraServerRmi
				.validarModuloRelacaoBase(modulosPreCadastro, moduloPreCadastroDTO);

		Assert.assertTrue(resultadoValidacaoModuloUsuario.sucesso());
		Assert.assertTrue(resultadoValidacaoModuloPreCadastro.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_modulo_periodo_sem_erro() throws RemoteException {
		ModuloPeriodoDTO moduloPeriodoDto = ContextoModuloPeriodo.fabricarModuloPeriodoDTO();
		ResultadoValidacaoModuloPeriodoDTO resultadoValidacaoModuloPeriodo = servicoSisLaraServerRmi
				.validarModuloPeriodo(moduloPeriodoDto);

		Assert.assertTrue(resultadoValidacaoModuloPeriodo.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_atendimento_usuario_com_erro() throws RemoteException {
		AtendimentoUsuarioDTO atendimentoUsuarioDto = new AtendimentoUsuarioDTO();
		ResultadoValidacaoAtendimentoBaseDTO resultadoValidacaoAtendimentoUsuarioDto = servicoSisLaraServerRmi
				.validarAtendimentoAuxiliarBase(atendimentoUsuarioDto);

		Assert.assertFalse(resultadoValidacaoAtendimentoUsuarioDto.sucesso());
		Assert.assertTrue(resultadoValidacaoAtendimentoUsuarioDto.obterMensagens().contains("Insira o Usu�rio."));
		Assert.assertTrue(resultadoValidacaoAtendimentoUsuarioDto.obterMensagens().contains("Insira uma Frequ�ncia."));
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_atendimento_usuario_com_erro_contendo_frequencia_AT_sem_participacao_detalhada() throws RemoteException {
		AtendimentoUsuarioDTO atendimentoUsuarioDto = ContextoAtendimentoUsuario.construirAtendimentoUsuarioDTO();
		atendimentoUsuarioDto.getInformacaoAtendimentoDto().setFrequenciaDto(new FrequenciaDTO("AT"));
		atendimentoUsuarioDto.getInformacaoAtendimentoDto().setParticipadaoDetalhadaDto(Arrays.asList());
		ResultadoValidacaoAtendimentoBaseDTO resultadoValidacaoAtendimentoUsuarioDto = servicoSisLaraServerRmi
				.validarAtendimentoAuxiliarBase(atendimentoUsuarioDto);

		Assert.assertFalse(resultadoValidacaoAtendimentoUsuarioDto.sucesso());
		Assert.assertTrue(resultadoValidacaoAtendimentoUsuarioDto.obterMensagens().contains("Insira uma Participa��o no atendimento com frequencia AT"));
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_atendimento_usuario_com_erro_contendo_frequencia_AT_e_participacao_conflitante() throws RemoteException {
		ParticipacaoDetalhadaDTO participacaoDetalhadaApenasFamiliaDTO = ContextoParticipacaoDetalhada
				.contruirParticipacaoDetalhadaDto();
		ParticipacaoDetalhadaDTO participacaoDetalhadaComFamiliaDTO = ContextoParticipacaoDetalhada
				.contruirParticipacaoDetalhadaDto();
		participacaoDetalhadaComFamiliaDTO.setParticipacaoDto(new ParticipacaoDTO(Participacao.COM_FAMILIA.toString()));

		AtendimentoUsuarioDTO atendimentoUsuarioDto = ContextoAtendimentoUsuario.construirAtendimentoUsuarioDTO();
		atendimentoUsuarioDto.getInformacaoAtendimentoDto().setFrequenciaDto(new FrequenciaDTO("AT"));
		atendimentoUsuarioDto.getInformacaoAtendimentoDto().setParticipadaoDetalhadaDto(
				Arrays.asList(participacaoDetalhadaApenasFamiliaDTO, participacaoDetalhadaComFamiliaDTO));
		ResultadoValidacaoAtendimentoBaseDTO resultadoValidacaoAtendimentoUsuarioDto = servicoSisLaraServerRmi
				.validarAtendimentoAuxiliarBase(atendimentoUsuarioDto);

		Assert.assertFalse(resultadoValidacaoAtendimentoUsuarioDto.sucesso());
		Assert.assertTrue(resultadoValidacaoAtendimentoUsuarioDto.obterMensagens()
				.contains("As participa��es APENAS_FAMILIA, APENAS_ACOMPANHANTE e APENAS_USUARIO devem ser exclusivas."));
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_atendimento_usuario_sem_erro_contendo_frequencia_AT_e_participacao_SOMENTE_FAMILIA_e_SOMENTE_ACOMPANHANTE() throws RemoteException {
		ParticipacaoDetalhadaDTO participacaoDetalhadaApenasFamiliaDTO = ContextoParticipacaoDetalhada
				.contruirParticipacaoDetalhadaDto();
		ParticipacaoDetalhadaDTO participacaoDetalhadaApenasAcompanhanteDTO = ContextoParticipacaoDetalhada
				.contruirParticipacaoDetalhadaDto();
		participacaoDetalhadaApenasAcompanhanteDTO.setParticipacaoDto(new ParticipacaoDTO(Participacao.APENAS_ACOMPANHANTE.toString()));

		AtendimentoUsuarioDTO atendimentoUsuarioDto = ContextoAtendimentoUsuario.construirAtendimentoUsuarioDTO();
		atendimentoUsuarioDto.getInformacaoAtendimentoDto().setFrequenciaDto(new FrequenciaDTO("AT"));
		atendimentoUsuarioDto.getInformacaoAtendimentoDto().setParticipadaoDetalhadaDto(
				Arrays.asList(participacaoDetalhadaApenasFamiliaDTO, participacaoDetalhadaApenasAcompanhanteDTO));
		ResultadoValidacaoAtendimentoBaseDTO resultadoValidacaoAtendimentoUsuarioDto = servicoSisLaraServerRmi
				.validarAtendimentoAuxiliarBase(atendimentoUsuarioDto);

		Assert.assertTrue(resultadoValidacaoAtendimentoUsuarioDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_atendimento_usuario_sem_erro() throws RemoteException {
		AtendimentoUsuarioDTO atendimentoUsuarioDto = ContextoAtendimentoUsuario.construirAtendimentoUsuarioDTO();
		ResultadoValidacaoAtendimentoBaseDTO resultadoValidacaoAtendimentoUsuario = servicoSisLaraServerRmi
				.validarAtendimentoAuxiliarBase(atendimentoUsuarioDto);

		Assert.assertTrue(resultadoValidacaoAtendimentoUsuario.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_atendimento_pre_cadastro_com_erro() throws RemoteException {
		AtendimentoPreCadastroDTO atendimentoPreCadastroDto = new AtendimentoPreCadastroDTO();
		ResultadoValidacaoAtendimentoBaseDTO resultadoValidacaoAtendimentoPreCadastroDto = servicoSisLaraServerRmi
				.validarAtendimentoAuxiliarBase(atendimentoPreCadastroDto);

		Assert.assertFalse(resultadoValidacaoAtendimentoPreCadastroDto.sucesso());
		Assert.assertTrue(resultadoValidacaoAtendimentoPreCadastroDto.obterMensagens().contains("Insira o Pr�-Cadastro."));
		Assert.assertTrue(resultadoValidacaoAtendimentoPreCadastroDto.obterMensagens().contains("Insira uma Frequ�ncia."));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_atendimento_pre_cadastro_sem_erro() throws RemoteException {
		AtendimentoPreCadastroDTO atendimentoPreCadastroDto = ContextoAtendimentoPreCadastro
				.construirAtendimentoPreCadastroDTO();
		ResultadoValidacaoAtendimentoBaseDTO resultadoValidacaoAtendimentoPreCadastro = servicoSisLaraServerRmi
				.validarAtendimentoAuxiliarBase(atendimentoPreCadastroDto);

		Assert.assertTrue(resultadoValidacaoAtendimentoPreCadastro.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_atendimento_profissional_com_erro() throws RemoteException {
		AtendimentoProfissionalDTO atendimentoProfissinalDto = new AtendimentoProfissionalDTO();
		ResultadoValidacaoAtendimentoBaseDTO resultadoValidacaoAtendimentoProfissionalDto = servicoSisLaraServerRmi
				.validarAtendimentoAuxiliarBase(atendimentoProfissinalDto);

		Assert.assertFalse(resultadoValidacaoAtendimentoProfissionalDto.sucesso());
		Assert.assertTrue(resultadoValidacaoAtendimentoProfissionalDto.obterMensagens().contains("Insira o Profissional."));
		Assert.assertTrue(resultadoValidacaoAtendimentoProfissionalDto.obterMensagens().contains("Insira uma Frequ�ncia."));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_atendimento_profissional_sem_erro() throws RemoteException {
		AtendimentoProfissionalDTO atendimentoProfissionalDto = ContextoAtendimentoProfissional
				.construirAtendimentoProfissionalDTO();
		ResultadoValidacaoAtendimentoBaseDTO resultadoValidacaoAtendimentoProfissional = servicoSisLaraServerRmi
				.validarAtendimentoAuxiliarBase(atendimentoProfissionalDto);

		Assert.assertTrue(resultadoValidacaoAtendimentoProfissional.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_atendimento_comunidade_com_erro() throws RemoteException {
		AtendimentoComunidadeDTO atendimentoComunidadeDto = new AtendimentoComunidadeDTO();
		ResultadoValidacaoAtendimentoBaseDTO resultadoValidacaoAtendimentoComundiadeDto = servicoSisLaraServerRmi
				.validarAtendimentoAuxiliarBase(atendimentoComunidadeDto);

		Assert.assertFalse(resultadoValidacaoAtendimentoComundiadeDto.sucesso());
		Assert.assertTrue(resultadoValidacaoAtendimentoComundiadeDto.obterMensagens().contains("Insira um Pr� Cadastro."));
		Assert.assertTrue(resultadoValidacaoAtendimentoComundiadeDto.obterMensagens().contains("Insira uma Forma��o."));
		Assert.assertTrue(resultadoValidacaoAtendimentoComundiadeDto.obterMensagens().contains("Insira uma Frequ�ncia."));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_atendimento_comunidade_sem_erro() throws RemoteException {
		AtendimentoComunidadeDTO atendimentoComunidadeDto = new AtendimentoComunidadeDTO();
		atendimentoComunidadeDto.setPreCadastroDto(ContextoPreCadastro.construirPreCadastroDTO());
		atendimentoComunidadeDto.setTipoVinculoDto(ContextoTipoVinculo.fabricarDTOComTodosOsDados());
		atendimentoComunidadeDto
				.setInformacaoAtendimentoDto(ContextoInformacaoAtendimento.construirInformacaoAtendimentoDTO());
		ResultadoValidacaoAtendimentoBaseDTO resultadoValidacaoAtendimentoComundiadeDto = servicoSisLaraServerRmi
				.validarAtendimentoAuxiliarBase(atendimentoComunidadeDto);

		Assert.assertTrue(resultadoValidacaoAtendimentoComundiadeDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_modulo_usuario_com_erro() throws RemoteException {
		ModuloUsuarioDTO moduloUsuarioDto = new ModuloUsuarioDTO();
		moduloUsuarioDto.setUsuarioDto(ContextoUsuario.construirUsuarioDTO());
		ResultadoValidacaoModuloRelacaoBaseDTO resultadoValidacaoModuloUsuario = servicoSisLaraServerRmi
				.validarModuloRelacaoBase(moduloUsuarioDto);

		Assert.assertFalse(resultadoValidacaoModuloUsuario.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_modulo_usuario_sem_erro() throws RemoteException {
		ModuloUsuarioDTO moduloUsuarioDto = ContextoModuloUsuario.fabricarModuloUsuarioDTO();
		ResultadoValidacaoModuloRelacaoBaseDTO resultadoValidacaoModuloUsuario = servicoSisLaraServerRmi
				.validarModuloRelacaoBase(moduloUsuarioDto);

		Assert.assertTrue(resultadoValidacaoModuloUsuario.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_modulo_pre_cadastro_com_erro() throws RemoteException {
		ModuloPreCadastroDTO moduloPreCadastroDto = new ModuloPreCadastroDTO();
		moduloPreCadastroDto.setPreCadastroDto(ContextoPreCadastro.construirPreCadastroDTO());
		ResultadoValidacaoModuloRelacaoBaseDTO resultadoValidacaoModuloPreCadastro = servicoSisLaraServerRmi
				.validarModuloRelacaoBase(moduloPreCadastroDto);

		Assert.assertFalse(resultadoValidacaoModuloPreCadastro.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_modulo_pre_cadastro_sem_erro() throws RemoteException {
		ModuloPreCadastroDTO moduloPreCadastroDto = ContextoModuloPreCadastro.fabricarModuloPreCadastroDTOSemErro();
		ResultadoValidacaoModuloRelacaoBaseDTO resultadoValidacaoModuloPreCadastro = servicoSisLaraServerRmi
				.validarModuloRelacaoBase(moduloPreCadastroDto);

		Assert.assertTrue(resultadoValidacaoModuloPreCadastro.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_programacao_com_erro() throws RemoteException {
		ProgramacaoDTO programacaoDto = new ProgramacaoDTO();
		ResultadoValidacaoProgramacaoDTO resultadoValidacaoProgramacao = servicoSisLaraServerRmi
				.validarProgramacao(programacaoDto);

		Assert.assertFalse(resultadoValidacaoProgramacao.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_programacao_sem_erro() throws RemoteException {
		ProgramacaoDTO programacaoDto = ContextoProgramacao.construirProgramacaoDTO();
		ResultadoValidacaoProgramacaoDTO resultadoValidacaoProgramacao = servicoSisLaraServerRmi
				.validarProgramacao(programacaoDto);

		Assert.assertTrue(resultadoValidacaoProgramacao.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_participacao_detalhada_com_erro() throws RemoteException {
		ParticipacaoDetalhadaDTO participacaoDetalhadaDto = new ParticipacaoDetalhadaDTO();
		ResultadoValidacaoParticipacaoDetalhadaDTO resultadoValidacaoParticipacaoDetalahda = servicoSisLaraServerRmi
				.validarParticipacaoDetalhada(participacaoDetalhadaDto);

		Assert.assertFalse(resultadoValidacaoParticipacaoDetalahda.sucesso());
		Assert.assertTrue(
				resultadoValidacaoParticipacaoDetalahda.obterMensagens().contains("Selecione uma Participa��o."));
		Assert.assertTrue(
				resultadoValidacaoParticipacaoDetalahda.obterMensagens().contains("Insira uma Quantidade v�lida."));
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_participacao_detalhada_apenas_usuario_contendo_mais_de_uma_pessoa_com_erro() throws RemoteException {
		ParticipacaoDetalhadaDTO participacaoDetalhadaDto = new ParticipacaoDetalhadaDTO();
		participacaoDetalhadaDto.setParticipacaoDto(new ParticipacaoDTO(Participacao.APENAS_USUARIO.toString()));
		participacaoDetalhadaDto.setQuantidade("2");
		ResultadoValidacaoParticipacaoDetalhadaDTO resultadoValidacaoParticipacaoDetalahda = servicoSisLaraServerRmi
				.validarParticipacaoDetalhada(participacaoDetalhadaDto);

		Assert.assertFalse(resultadoValidacaoParticipacaoDetalahda.sucesso());
		Assert.assertTrue(
				resultadoValidacaoParticipacaoDetalahda.obterMensagens().contains("Insira somente uma pessoa na participa��o."));
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_participacao_detalhada_sem_erro() throws RemoteException {
		ParticipacaoDetalhadaDTO participacaoDetalhadaDto = ContextoParticipacaoDetalhada.contruirParticipacaoDetalhadaDto();
		ResultadoValidacaoParticipacaoDetalhadaDTO resultadoValidacaoParticipacaoDetalahda = servicoSisLaraServerRmi
				.validarParticipacaoDetalhada(participacaoDetalhadaDto);

		Assert.assertTrue(resultadoValidacaoParticipacaoDetalahda.sucesso());
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_encaminhamento_com_suceso() throws RemoteException {
		OrigemEncaminhamentoDetalhadoDTO encaminhamentoDto = ContextoOrigemEncaminhamentoDetalhado.fabricarEncaminhamentoDto();
		ResultadoValidacaoEncaminhamentoDTO resultadoValidacaoEncaminhamentoDto = servicoSisLaraServerRmi
				.validarEncaminhamento(encaminhamentoDto);

		Assert.assertTrue(resultadoValidacaoEncaminhamentoDto.sucesso());
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_validacao_encaminhamento_sem_suceso() throws RemoteException {
		OrigemEncaminhamentoDetalhadoDTO encaminhamentoDto = ContextoOrigemEncaminhamentoDetalhado.fabricarEncaminhamentoDto();
		encaminhamentoDto.setProfissionalLiberal(ContextoGenerico.obterGrande());
		ResultadoValidacaoEncaminhamentoDTO resultadoValidacaoEncaminhamentoDto = servicoSisLaraServerRmi
				.validarEncaminhamento(encaminhamentoDto);

		Assert.assertFalse(resultadoValidacaoEncaminhamentoDto.sucesso());
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_solicita_geracao_atendimentos_a_partir_de_grupo_sem_erro() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222));

		String dataInicial = "31/12/2012";
		EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentosDTO = new EspecificacaoGeracaoAtendimentoDTO(
				obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(), new Long(11111)).getId(),
				dataInicial, new HorarioDTO("22:22", "23:00"));
		ResultadoEdicaoAtendimentoGrupoDTO resultadoGeracaoAtendimento = gerarEEditarAtendimento(
				especificacaoGeracaoAtendimentosDTO, resultadoDto.getToken());		

		EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentosDTO2 = new EspecificacaoGeracaoAtendimentoDTO(
				obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(), new Long(11111)).getId(),
				dataInicial, new HorarioDTO("23:00", "23:30"));
		ResultadoEdicaoAtendimentoGrupoDTO resultadoGeracaoAtendimento2 = gerarEEditarAtendimento(
				especificacaoGeracaoAtendimentosDTO2, resultadoDto.getToken());	

		ResultadoListagemGrupoDTO resultadoListagemGrupoDtoAposGeracaoDeDoisAtendimentos = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("G02-1");

		Assert.assertTrue(resultadoGeracaoAtendimento.sucesso());
		Assert.assertTrue(resultadoGeracaoAtendimento2.sucesso());
		Assert.assertEquals(
				obterModuloPeriodoDto(resultadoListagemGrupoDtoAposGeracaoDeDoisAtendimentos.getObjetosDto(),
						new Long(12222), new Long(11111)).getAtendimentosGrupoDto().size(),
				3);
		Assert.assertNotEquals(
				((ModuloPeriodoDTO) obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(), new Long(11111))).getVersao(),
				obterModuloPeriodoDto(resultadoListagemGrupoDtoAposGeracaoDeDoisAtendimentos.getObjetosDto(),
						new Long(12222), new Long(11111)).getVersao());
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_geracao_atendimentos_a_partir_de_grupo_com_data_futura() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222));

		MaquinaTempo.mudarDataAtual("01/01/2016");
		
		EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentosDTO = new EspecificacaoGeracaoAtendimentoDTO(
				obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(), new Long(11111)).getId(),
				"31/12/2016", new HorarioDTO("09:00", "19:00"));

		ResultadoEdicaoAtendimentoGrupoDTO resultadoGeracaoAtendimento = gerarEEditarAtendimento(
				especificacaoGeracaoAtendimentosDTO, resultadoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertFalse(resultadoGeracaoAtendimento.sucesso());
		Assert.assertEquals(resultadoGeracaoAtendimento.obterMensagens(),
				"Insira uma data igual ou anterior ao dia de hoje.\n\n");
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_geracao_dois_atendimentos_com_frequencia_AT_sem_participacao_detalhada_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222));

		EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentosPrimeiroDTO = new EspecificacaoGeracaoAtendimentoDTO(
				obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(), new Long(11111)).getId(),
				"30/12/2000", new HorarioDTO("09:00", "19:00"));

		ResultadoGeracaoAtendimentoDTO resultadoGeracaoAtendimentoPrimeiro = servicoSisLaraServerRmi
				.gerarAtendimentos(especificacaoGeracaoAtendimentosPrimeiroDTO, resultadoDto.getToken());
	
		AtendimentoGrupoDTO atendimentoGrupoDTO = (AtendimentoGrupoDTO) resultadoGeracaoAtendimentoPrimeiro
				.obterObjetoDtoEditado();

		Assert.assertTrue(resultadoGeracaoAtendimentoPrimeiro.sucesso());
		Assert.assertNull(atendimentoGrupoDTO.getId());
		Assert.assertTrue(atendimentoGrupoDTO.getAtendimentosUsuariosDto().get(0)
				.getInformacaoAtendimentoDto().getParticipacaoDetalhadaDto().isEmpty());
		Assert.assertEquals(atendimentoGrupoDTO.getAtendimentosUsuariosDto().get(0)
				.getInformacaoAtendimentoDto().getFrequenciaDto().toString(), Frequencia.AT.toString());
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_gera_atendimentos_de_reuniao_de_integracao_duplicado() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaVeraPereira());
		
		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("SS-1");
		ModuloPeriodoDTO moduloPeriodoDto = obterModuloPeriodoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(66666), new Long(99999));
		
		ModuloUsuarioDTO moduloUsuarioDTO = ContextoModuloUsuario.fabricarModuloUsuarioDTO();
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.INTEGRADO.toString()));
		moduloPeriodoDto.setModulosUsuariosDto(Arrays.asList(moduloUsuarioDTO));
		
		servicoSisLaraServerRmi.editarModuloPeriodo(moduloPeriodoDto, resultadoDto.getToken());

		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(66666));
		EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentosDTO = new EspecificacaoGeracaoAtendimentoDTO(
				obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(), new Long(99999)).getId(),
				"31/12/2000", new HorarioDTO("09:00", "19:00"));

		gerarEEditarAtendimento(
				especificacaoGeracaoAtendimentosDTO, resultadoDto.getToken());
		
		ResultadoEdicaoAtendimentoGrupoDTO resultadoEdicaoAtendimentoGrupoDTO = gerarEEditarAtendimento(
				especificacaoGeracaoAtendimentosDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoGrupoDTO.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoGrupoDTO.obterMensagens()
				.contains("N�o � poss�vel existir mais de um atendimento em Reuni�o de Integra��o com status NORMAL."));
	}	

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_solicita_cancelamento_atendimento_a_partir_de_grupo_sem_erro() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		AtendimentoGrupoDTO atendimentoGropoDto = obterAtendimentoGrupoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), new Long(11111), new Long(11111));

		ResultadoEdicaoAtendimentoGrupoDTO resultadoCancelamentoAtendimento = servicoSisLaraServerRmi
				.cancelarAtendimentoGrupo(atendimentoGropoDto, resultadoDto.getToken());

		AtendimentoGrupoDTO atendimentoGrupoDto = (AtendimentoGrupoDTO) resultadoCancelamentoAtendimento
				.obterObjetoDtoEditado();

		Assert.assertTrue(resultadoCancelamentoAtendimento.sucesso());
		Assert.assertTrue(atendimentoGrupoDto.getStatusAtendimentoDto().equals(new StatusAtendimentoDTO("CANCELADO")));
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_solicita_cancelamento_atendimento_com_sucesso_em_concorrencia() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");

		servicoSisLaraServerRmi.editarGrupo(
				(GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222)),
				resultadoDto.getToken());

		AtendimentoGrupoDTO atendimentoGropoDto = obterAtendimentoGrupoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), new Long(11111), new Long(11111));

		ResultadoEdicaoAtendimentoGrupoDTO resultadoCancelamentoAtendimento = servicoSisLaraServerRmi
				.cancelarAtendimentoGrupo(atendimentoGropoDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoCancelamentoAtendimento.sucesso());
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_solicita_edicao_atendimentos_de_grupo_a_partir_de_grupo_com_erro_por_falta_de_permissao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222));

		ModuloPeriodoDTO moduloPeriodoAEEDto = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoDto.getModulosPeriodosDto(), new Long(11111));

		AtendimentoGrupoDTO atendimentoGrupoDTO = (AtendimentoGrupoDTO) obterDaRelacaoPorId(
				moduloPeriodoAEEDto.getAtendimentosGrupoDto(), new Long(11111));

		ResultadoEdicaoAtendimentoGrupoDTO resultadoEdicaoAtendimentoGrupoDTO = servicoSisLaraServerRmi
				.editarAtendimentoGrupo(moduloPeriodoAEEDto, atendimentoGrupoDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoGrupoDTO.sucesso());
		Assert.assertEquals(resultadoEdicaoAtendimentoGrupoDTO.getMensagem(), "Voc� n�o possui autoriza��o para realizar a opera��o.\n");
	}
	
	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_solicita_geracao_atendimentos_de_grupo_com_participacao_detalhada_padrao_apenas_usuario()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("OSE-1");
		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(821582));

		EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentosDTO = new EspecificacaoGeracaoAtendimentoDTO(
				obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(), new Long(821582)).getId(),
				"31/12/2012", new HorarioDTO("09:00", "19:00"));
		ResultadoGeracaoAtendimentoDTO resultadoGeracaoAtendimento = servicoSisLaraServerRmi
				.gerarAtendimentos(especificacaoGeracaoAtendimentosDTO, resultadoDto.getToken());
		
		AtendimentoGrupoDTO atendimentoGrupoDto = (AtendimentoGrupoDTO) resultadoGeracaoAtendimento
				.obterObjetoDtoEditado();
		AtendimentoUsuarioDTO atendimentoUsuarioDto = atendimentoGrupoDto.getAtendimentosUsuariosDto().get(0);
		ParticipacaoDTO participacaoDto = atendimentoUsuarioDto.getInformacaoAtendimentoDto()
				.getParticipacaoDetalhadaDto().get(0).getParticipacaoDto();
		
		Assert.assertTrue(resultadoGeracaoAtendimento.sucesso());
		Assert.assertEquals(participacaoDto.toString(), Participacao.APENAS_USUARIO.toString());
	}
	
	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_solicita_geracao_atendimentos_de_grupo_com_participacao_detalhada_padrao_com_familia()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("MT-1");
		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(123456));

		EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentosDTO = new EspecificacaoGeracaoAtendimentoDTO(
				obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(), new Long(123456)).getId(),
				"31/12/2012", new HorarioDTO("09:00", "19:00"));
		ResultadoGeracaoAtendimentoDTO resultadoGeracaoAtendimento = servicoSisLaraServerRmi
				.gerarAtendimentos(especificacaoGeracaoAtendimentosDTO, resultadoDto.getToken());
		
		AtendimentoGrupoDTO atendimentoGrupoDto = (AtendimentoGrupoDTO) resultadoGeracaoAtendimento
				.obterObjetoDtoEditado();
		AtendimentoUsuarioDTO atendimentoUsuarioDto = atendimentoGrupoDto.getAtendimentosUsuariosDto().get(0);
		ParticipacaoDTO participacaoDto = atendimentoUsuarioDto.getInformacaoAtendimentoDto()
				.getParticipacaoDetalhadaDto().get(0).getParticipacaoDto();
		
		Assert.assertTrue(resultadoGeracaoAtendimento.sucesso());
		Assert.assertEquals(participacaoDto.toString(), Participacao.COM_FAMILIA.toString());
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_solicita_geracao_atendimentos_de_grupo_com_erro_de_horario_em_conflito()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222));

		EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentosDTO = new EspecificacaoGeracaoAtendimentoDTO(
				obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(), new Long(11111)).getId(),
				"31/12/2012", new HorarioDTO("09:00", "19:00"));
		
		ResultadoEdicaoAtendimentoGrupoDTO resultadoGeracaoAtendimento = gerarEEditarAtendimento(
				especificacaoGeracaoAtendimentosDTO, resultadoDto.getToken());

		ResultadoEdicaoAtendimentoGrupoDTO resultadoGeracaoAtendimentoConflito = gerarEEditarAtendimento(
				especificacaoGeracaoAtendimentosDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoAtendimento.sucesso());
		Assert.assertFalse(resultadoGeracaoAtendimentoConflito.sucesso());
		Assert.assertEquals(resultadoGeracaoAtendimentoConflito.obterMensagens(),
				"N�o � poss�vel gerar um novo atendimento de grupo em hor�rio conflitante com um atendimento j� existente.\n\n");
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_solicita_cancelamento_atendimento_de_grupo_a_partir_de_grupo_com_erro_por_falta_de_permissao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		AtendimentoGrupoDTO atendimentoGropoDto = obterAtendimentoGrupoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), new Long(11111), new Long(11111));
		ResultadoEdicaoAtendimentoGrupoDTO resultadoCancelamentoAtendimento = servicoSisLaraServerRmi
				.cancelarAtendimentoGrupo(atendimentoGropoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoCancelamentoAtendimento.sucesso());
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_solicita_geracao_atendimentos_de_grupo_a_partir_de_grupo_com_erro_por_falta_de_usuarios_ou_precadastros()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaShivas());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("SS-1");
		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(66666));

		EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentosDTO = new EspecificacaoGeracaoAtendimentoDTO(
				obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(), new Long(99999)).getId(),
				"31/12/2012", new HorarioDTO("09:00", "19:00"));
		ResultadoGeracaoAtendimentoDTO resultadoGeracaoAtendimentoGrupo = servicoSisLaraServerRmi
				.gerarAtendimentos(especificacaoGeracaoAtendimentosDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoAtendimentoGrupo.sucesso());
		Assert.assertEquals(resultadoGeracaoAtendimentoGrupo.obterMensagens(),
				"N�o � poss�vel gerar atendimentos para um grupo sem integrantes.\n\n");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_e_xls_de_atendimento_de_usuario_em_grupo_simples() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		GrupoDTO grupoDto = new GrupoDTO();
		grupoDto.setId(new Long(12222));
		ModuloPeriodoDTO moduloPeriodoDto = new ModuloPeriodoDTO();
		moduloPeriodoDto.setId(new Long(22222));

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioAtendimentoDeUsuarioNoGrupoSimples(grupoDto,
				moduloPeriodoDto, resultadoAutenticacaoPDFDto.getToken());

		ResultadoAutenticacaoDTO resultadoAutenticacaoXLSDto = servicoSisLaraServerRmi
				.autenticarLogin(new CredencialDTO("vvitalino", "1234", "1234"));
		ArquivoDTO relatorioXLS = servicoSisLaraServerRmi.gerarRelatorioAtendimentoDeUsuarioNoGrupoSimples(grupoDto,
				moduloPeriodoDto, resultadoAutenticacaoXLSDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(relatorioXLS.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32749]));
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioXLS.obterConteudo(), new byte[43008]));
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_gera_relatorio_pdf_de_atendimento_de_usuario_em_grupo_detalhado() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		GrupoDTO grupoDto = new GrupoDTO();
		grupoDto.setId(new Long(12222));
		ModuloPeriodoDTO moduloPeriodoDto = new ModuloPeriodoDTO();
		moduloPeriodoDto.setId(new Long(22222));
		UsuarioDTO usuarioDto = new UsuarioDTO(new Long(12222));

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioAtendimentoDeUsuarioNoGrupoDetalhado(grupoDto,
				moduloPeriodoDto, usuarioDto, resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32802]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_folha_de_rosto() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());
		
		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioFolhaDeRosto(new Long(12222),
				resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[33236]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_geracao_atendimentos_individuais_e_grupo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioGeracaoAtendimentosIndividuaisEGrupo(
				"31/01/2001", "31/12/2013", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32629]));
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_xls_de_frequencia_de_atendimentos_globais_por_usuario_no_periodo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorio = servicoSisLaraServerRmi.gerarRelatorioFrequenciasDeAtendimentoGlobaisPorUsuarioNoPeriodo(
				"12222, 13333", "01/12/2012", "31/12/2012", resultadoAutenticacaoDto.getToken());

		Assert.assertTrue(relatorio.sucesso());
		Assert.assertTrue(valorExatoDeBytes(relatorio.obterConteudo(), new byte[233]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_xls_de_frequencia_de_atendimentos_globais_por_usuario_no_periodo_sem_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorio = servicoSisLaraServerRmi.gerarRelatorioFrequenciasDeAtendimentoGlobaisPorUsuarioNoPeriodo(
				"12222, 13333", "01/12/2012", "31/12/2012", resultadoAutenticacaoDto.getToken());

		Assert.assertFalse(relatorio.sucesso());
		Assert.assertTrue(relatorio.obterMensagens().contains("Voc� n�o possui autoriza��o para realizar a opera��o."));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_xls_de_frequencia_de_atendimentos_globais_por_usuario_no_periodo_com_dados_inconsistentes() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorio = servicoSisLaraServerRmi.gerarRelatorioFrequenciasDeAtendimentoGlobaisPorUsuarioNoPeriodo(
				"12222, asdh, 13333", "01/12/XXXX", "31/12/YYYY", resultadoAutenticacaoDto.getToken());

		Assert.assertFalse(relatorio.sucesso());
		Assert.assertTrue(relatorio.obterMensagens().contains("Erro durante opera��o. Verifique a consist�ncia dos dados."));
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_vagas_em_grupos_ativos() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi
				.gerarRelatorioVagasEmGruposAtivos(resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32950]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_vagas_em_grupos_ativos() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialAlternativaDtoInvalida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi
				.gerarRelatorioVagasEmGruposAtivos(resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_todas_frequencias_ordenado_por_data_lancamento() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioTodasFrequenciasOrdenadoPorDataLancamento(
				new Long(12222), resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[33003]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_acompanhamento_programacao_de_grupo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioAcompanhamentoProgramacaoNoGrupo(
				"G02-1-01/01/2016", resultadoAutenticacaoPDFDto.getToken());
		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[33060]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_fluxo_de_atendimento_casos_novos_de_avaliacao_funcional()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioFluxoAtendimentoCasosNovosDeAvaliacaoFuncional(
				"01/01/2010", "31/12/2010", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32713]));
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_gera_relatorio_xls_de_mailing_de_visita_monitorada() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());
		
		EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentosDTO = new EspecificacaoGeracaoAtendimentoDTO(
				new Long(999999), "01/01/2016", new HorarioDTO("09:00", "10:00"));
		gerarEEditarAtendimento(especificacaoGeracaoAtendimentosDTO,
				resultadoAutenticacaoDto.getToken());

		ArquivoDTO relatorioXLS = servicoSisLaraServerRmi
				.gerarRelatorioMailingVisitaMonitorada("01/01/2016", "31/12/2016",
						Arrays.asList(ContextoTipoVinculo.fabricarEstudanteDTOComTodosOsDados(),
								ContextoTipoVinculo.fabricarPrivadoDTOComTodosOsDados()),
						resultadoAutenticacaoDto.getToken());

		Assert.assertTrue(relatorioXLS.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioXLS.obterConteudo(), new byte[41472]));
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_xls_de_mailing_de_visita_monitorada_sem_autorizacao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioXLS = servicoSisLaraServerRmi
				.gerarRelatorioMailingVisitaMonitorada("01/01/2016", "31/12/2016",
						Arrays.asList(ContextoTipoVinculo.fabricarEstudanteDTOComTodosOsDados(),
								ContextoTipoVinculo.fabricarPrivadoDTOComTodosOsDados()),
						resultadoAutenticacaoDto.getToken());

		Assert.assertFalse(relatorioXLS.sucesso());
		Assert.assertTrue(relatorioXLS.obterMensagens().contains("Voc� n�o possui autoriza��o para realizar a opera��o.\n"));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_fluxo_de_atendimento_retornos_de_avaliacao_funcional()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioFluxoAtendimentoRetornosDeAvaliacaoFuncional(
				"01/01/2015", "31/12/2015", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32712]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_acompanhamento_programacao_de_grupo_por_falta_permissao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioAcompanhamentoProgramacaoNoGrupo(
				"G02-1-31/12/2011", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_programacao_do_grupo_para_familia() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		GrupoDTO grupoDto = new GrupoDTO();
		grupoDto.setId(new Long(12222));
		ModuloPeriodoDTO moduloPeriodoDto = new ModuloPeriodoDTO();
		moduloPeriodoDto.setId(new Long(11111));

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioProgramacaoDoGrupoParaFamilia("01/01/1900",
				"31/12/2999", grupoDto, moduloPeriodoDto, resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32746]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_solicitacao_relatorio() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioSolicitacaoRelatorio(new Long(12222),
				resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[33271]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_solicitacao_relatorio() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioSolicitacaoRelatorio(new Long(12222),
				resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_carga_horaria_de_usuarios_por_grupo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioCargaHorariaDeUsuarioPorGrupo(
				"G02-1-01/01/2016", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32804]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_carga_horaria_de_usuarios_por_grupo_sem_permissao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioCargaHorariaDeUsuarioPorGrupo(
				"G02-1-31/12/2011", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_quantidade_atendidos_por_comunidade_visita_monitorada()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioQuantidadeAtendidosPorVisitaMonitorada(
				"01/01/2000", "31/12/2099", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32547]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_todos_usuarios_com_status_provisorio_ou_acesso_nos_grupos()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi
				.gerarRelatorioTodosUsuarioComStatusDeGrupoProvisorioOuAcesso(resultadoAutenticacaoPDFDto.getToken());
		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32964]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_quantidade_atendidos_por_comunidade_visita_monitorada()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioQuantidadeAtendidosPorVisitaMonitorada(
				"01/01/2000", "31/12/2099", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_participacao_usuario_em_grupo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioParticipacaoUsuarioEmGrupos(new Long(12222),
				resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32834]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_todos_atendimentos_do_usuario_ordenado_por_grupo()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioTodosAtendimentosDoUsuarioOrdenadoPorGrupo(
				new Long(12222), resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32824]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_todos_atendimentos_do_usuario_ordenado_por_data_lancamento()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi
				.gerarRelatorioTodosAtendimentosDoUsuarioOrdenadoPorDataLancamento(new Long(12222),
						resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32943]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_todos_atendimentos_individuais_do_usuario_ordenado_por_data_lancamento()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi
				.gerarRelatorioTodosAtendimentosIndividuaisDoUsuarioOrdenadoPorDataLancamento(new Long(12222),
						resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[33124]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_quantidade_usuario_por_idade() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi
				.gerarRelatorioQuantidadeUsuarioOrdenadoPorIdade(resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32535]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_quantidade_pessoas_na_lista_de_espera_ordernado_por_expectativa()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi
				.gerarRelatorioQuantidadePessoasNaListaDeEsperaOrdenadoPorExpectativa(
						resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32746]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_quantidade_pessoas_na_lista_de_espera_por_faixa_idade()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioQuantidadePessoasNaListaDeEsperaPorFaixaIdade(
				new Long(0), new Long(90), resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32742]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_retirada_de_prontuarios_no_agendamento() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioRetiradaProntuariosNoAgendamento("31/01/2012",
				resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32650]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_quantidade_atendimentos_individuais() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioQuantidadeAtendimentosIndividuais("01/01/2000",
				"31/12/2994", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32825]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_todos_atendimentos_individuais_do_usuario_ordenado_por_data_lancamento_por_falta_autorizacao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi
				.gerarRelatorioTodosAtendimentosIndividuaisDoUsuarioOrdenadoPorDataLancamento(new Long(12222),
						resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	/* TODO Atualizar contabiliza��o de participantes	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_do_comas_atendidos_e_atendimentos_por_tipo_atendimento()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioComasAtendidosAtendimentosPorTipoAtendimento(
				"01/01/2012", "31/12/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[1676]));
	}
	*/

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_do_comas_atendidos_e_atendimentos_por_tipo_atendimento_por_falta_autorizacao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioComasAtendidosAtendimentosPorTipoAtendimento(
				"01/01/2012", "31/12/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_do_comas_atendidos_e_atendimentos_por_uf() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioComasAtendidosAtendimentosPorUF("01/01/2012",
				"31/12/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[1508]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_do_comas_atendidos_e_atendimentos_por_uf_por_falta_autorizacao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioComasAtendidosAtendimentosPorUF("01/01/2012",
				"31/12/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_do_comas_atendidos_e_atendimentos_por_renda() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioComasAtendidosAtendimentosPorRenda("01/01/2012",
				"31/12/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[1484]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_do_comas_atendidos_e_atendimentos_por_renda_por_falta_autorizacao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioComasAtendidosAtendimentosPorRenda("01/01/2012",
				"31/12/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_do_comas_atendidos_e_atendimentos_por_regiao_sp() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioComasAtendidosAtendimentosPorRegiaoSP(
				"01/01/2012", "31/12/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[1512]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_do_comas_atendidos_e_atendimentos_por_regiao_sp_por_falta_autorizacao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioComasAtendidosAtendimentosPorRegiaoSP(
				"01/01/2012", "31/12/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_do_comas_atendidos_e_atendimentos_por_municipio_sp() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioComasAtendidosAtendimentosPorMunicipioSP(
				"01/01/2012", "31/12/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[1515]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_do_comas_atendidos_e_atendimentos_por_municipio_SP_por_falta_autorizacao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioComasAtendidosAtendimentosPorMunicipioSP(
				"01/01/2012", "31/12/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_do_comas_atendidos_e_atendimentos_por_escolaridade() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioComasAtendidosAtendimentosPorEscolaridade(
				"01/01/2012", "31/12/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[1517]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_do_comas_atendidos_e_atendimentos_por_escolaridade_por_falta_autorizacao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioComasAtendidosAtendimentosPorEscolaridade(
				"01/01/2012", "31/12/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_do_comas_atendidos_e_atendimentos_por_deficiencia() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioComasAtendidosAtendimentosPorDeficiencia(
				"01/01/2012", "31/12/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[1535]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_do_comas_atendidos_e_atendimentos_por_deficiencia_por_falta_autorizacao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioComasAtendidosAtendimentosPorDeficiencia(
				"01/01/2012", "31/12/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_do_comas_atendidos_e_atendimentos_por_classificacao_instituicao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi
				.gerarRelatorioComasAtendidosAtendimentosPorClassificacaoInstituicao("01/01/2012", "31/12/2012",
						resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[1516]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_do_comas_atendidos_e_atendimentos_por_classificacao_instituicao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi
				.gerarRelatorioComasAtendidosAtendimentosPorClassificacaoInstituicao("01/01/2012", "31/12/2012",
						resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_do_comas_atendidos_e_atendimentos_por_beneficio() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioComasAtendidosAtendimentosPorBeneficio(
				"01/01/2012", "31/12/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[1546]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_do_comas_atendidos_e_atendimentos_por_beneficio_por_falta_autorizacao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioComasAtendidosAtendimentosPorBeneficio(
				"01/01/2012", "31/12/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_do_comas_atendidos_por_idade_e_genero() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioComasAtendidosPorIdadeEGenero("01/01/2012",
				"31/12/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[1634]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_do_comas_atendidos_por_idade_por_falta_autorizacao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioComasAtendidosPorIdadeEGenero("01/01/2012",
				"31/12/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_atendidos_sem_informacao_deficiencia() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioAtendidosSemInformacaoDeficiencia("01/01/2000",
				"31/12/2099", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_atendidos_sem_informacao_deficiencia() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioAtendidosSemInformacaoDeficiencia("01/01/2000",
				"31/12/2099", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32656]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_quantidade_atendidos_por_tipos_vinculos() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioQuantidadeAtendidosPorTiposVinculos(
				"01/01/2000", "31/12/2994", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32609]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_quantidade_atendimentos_para_prefeitura() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioQuantidadeAtendimentosParaPrefeitura(
				"01/01/2000", "31/12/2994", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32683]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_quantidade_atendidos_por_tipos_vinculos_por_grupo()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioQuantidadeAtendidosPorTiposVinculosPorGrupo(
				"01/01/2000", "31/12/2994", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32598]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_todas_retiradas_pendentes() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi
				.gerarRelatorioTodasRetiradasPendentes(resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32590]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_todas_retiradas_por_prontuario() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioTodasRetiradasPorProntuario(new Long(13333),
				resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32601]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_participacao_usuario_em_grupo_por_falta_de_autorizacao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioParticipacaoUsuarioEmGrupos(new Long(12222),
				resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_quantidade_atendimentos_para_prefeitura() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioQuantidadeAtendimentosParaPrefeitura(
				"01/01/2000", "31/12/2994", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_folha_de_rosto() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioFolhaDeRosto(new Long(12222),
				resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_geracao_atendimentos_individuais_e_grupo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioGeracaoAtendimentosIndividuaisEGrupo(
				"31/01/2001", "31/12/2013", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_acompanhamento_programacao_de_grupo_por_falta_autorizacao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioAcompanhamentoProgramacaoNoGrupo(
				"G02-1-31/12/2011", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_atendimento_de_usuario_em_grupo_simples_por_falta_de_autorizacao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		GrupoDTO grupoDto = new GrupoDTO();
		grupoDto.setId(new Long(12222));
		ModuloPeriodoDTO moduloPeriodoDto = new ModuloPeriodoDTO();
		moduloPeriodoDto.setId(new Long(22222));

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioAtendimentoDeUsuarioNoGrupoSimples(grupoDto,
				moduloPeriodoDto, resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
		Assert.assertNotNull(relatorioPDF.obterMensagens());
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_nao_gera_relatorio_pdf_de_atendimento_de_usuario_em_grupo_detalhado_por_falta_de_autorizacao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		GrupoDTO grupoDto = new GrupoDTO();
		grupoDto.setId(new Long(12222));
		ModuloPeriodoDTO moduloPeriodoDto = new ModuloPeriodoDTO();
		moduloPeriodoDto.setId(new Long(22222));
		UsuarioDTO usuarioDto = new UsuarioDTO(new Long(12222));

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioAtendimentoDeUsuarioNoGrupoDetalhado(grupoDto,
				moduloPeriodoDto, usuarioDto, resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
		Assert.assertNotNull(relatorioPDF.obterMensagens());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_todos_atendimentos_do_usuario_ordenado_por_grupo_por_falta_autorizacao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioTodosAtendimentosDoUsuarioOrdenadoPorGrupo(
				new Long(12222), resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
		Assert.assertNotNull(relatorioPDF.obterMensagens());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_todos_atendimentos_do_usuario_ordenado_por_data_lancamento_por_falta_autorizacao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi
				.gerarRelatorioTodosAtendimentosDoUsuarioOrdenadoPorDataLancamento(new Long(12222),
						resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
		Assert.assertNotNull(relatorioPDF.obterMensagens());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_retirada_de_prontuarios_no_agendamento_por_falta_de_autorizacao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioRetiradaProntuariosNoAgendamento("03/02/2012",
				resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
		Assert.assertNotNull(relatorioPDF.obterMensagens());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_quantidade_atendimentos_individuais() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioQuantidadeAtendimentosIndividuais("01/01/2012",
				"01/01/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
		Assert.assertNotNull(relatorioPDF.obterMensagens());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_quantidade_atendidos_por_tipos_vinculos() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioQuantidadeAtendidosPorTiposVinculos(
				"01/01/2012", "01/01/2012", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
		Assert.assertNotNull(relatorioPDF.obterMensagens());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_quantidade_pessoas_na_lista_de_espera_ordernado_por_expectativa()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi
				.gerarRelatorioQuantidadePessoasNaListaDeEsperaOrdenadoPorExpectativa(
						resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_quantidade_pessoas_na_lista_de_espera_por_faixa_de_idade()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioQuantidadePessoasNaListaDeEsperaPorFaixaIdade(
				new Long(23), new Long(23), resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_conferencia_agendamento_e_atendimentos_individual()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());
		
		EspecificacaoGeracaoAgendamentoDTO especificacaoGeracaoAgendamentoDTO = ContextoEspecificacaoGeracaoAgendamento
				.fabricarAgendamentoUnicoComTodosOsDados();
		especificacaoGeracaoAgendamentoDTO
				.setDataInicio(DataHoraUtils.formatarData(MaquinaTempo.obterInstancia().obterCalendarioAtual()));

		servicoSisLaraServerRmi
				.gerarAgendamento(especificacaoGeracaoAgendamentoDTO, resultadoAutenticacaoPDFDto.getToken());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi
				.gerarRelatorioConferenciaDeAgendamentosEAtendimentosIndividuais(
						resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32686]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_conferencia_agendamento_e_atendimentos_individual()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi
				.gerarRelatorioConferenciaDeAgendamentosEAtendimentosIndividuais(
						resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
		Assert.assertNotNull(relatorioPDF.obterMensagens());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_todas_retiradas_pendentes() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi
				.gerarRelatorioTodasRetiradasPendentes(resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_todas_retiradas_por_prontuario() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioTodasRetiradasPorProntuario(new Long(13333),
				resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_altera_extensao_relatorio_padrao_para_xls() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ResultadoAlteracaoExtensaoRelatorioDTO resultadoAlteracaoDto = servicoSisLaraServerRmi
				.alterarExtensaoRelatorioParaXLS(resultadoAutenticacaoDto.getToken());

		Assert.assertTrue(resultadoAlteracaoDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_altera_extensao_relatorio_padrao_para_pdf() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ResultadoAlteracaoExtensaoRelatorioDTO resultadoAlteracaoDto = servicoSisLaraServerRmi
				.alterarExtensaoRelatorioParaPDF(resultadoAutenticacaoDto.getToken());

		Assert.assertTrue(resultadoAlteracaoDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_altera_senha_conta_acesso_com_sucesso() throws RemoteException {
		CredencialDTO credencialDto = construirCredencialDtoRLemeDtoValida();

		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi.autenticarLogin(credencialDto);

		ResultadoAlteracaoSenhaDTO resultadoAlteracaoSenhaDto = servicoSisLaraServerRmi.alterarSenha(credencialDto,
				resultadoAutenticacaoDto.getToken());

		ResultadoAutenticacaoDTO resultadoAutenticacaoAposAlteracaoDto = servicoSisLaraServerRmi
				.autenticarLogin(credencialDto);

		Assert.assertTrue(resultadoAlteracaoSenhaDto.sucesso());
		Assert.assertTrue(resultadoAutenticacaoAposAlteracaoDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_altera_senha_conta_acesso_com_senha_diferente() throws RemoteException {
		CredencialDTO credencialDto = construirCredencialAlternativaDtoInvalida();

		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi.autenticarLogin(credencialDto);

		ResultadoAlteracaoSenhaDTO resultadoAlteracaoSenhaDto = servicoSisLaraServerRmi.alterarSenha(credencialDto,
				resultadoAutenticacaoDto.getToken());

		Assert.assertFalse(resultadoAlteracaoSenhaDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_altera_senha_conta_acesso_sem_senha_em_branco() throws RemoteException {
		CredencialDTO credencialDto = construirCredencialDtoValida();

		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi.autenticarLogin(credencialDto);

		ResultadoAlteracaoSenhaDTO resultadoAlteracaoSenhaDto = servicoSisLaraServerRmi
				.alterarSenha(construirCredencialDtoValidaSemSenha(), resultadoAutenticacaoDto.getToken());

		Assert.assertFalse(resultadoAlteracaoSenhaDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_obtem_listagem_prontuarios_escaneados_por_usuario() throws RemoteException {
		UsuarioDTO usuarioDto = new UsuarioDTO(new Long(12222));

		ResultadoListagemProntuarioEscaneadoDTO resultadoListagemProntuarioEscaneado = servicoSisLaraServerRmi
				.obterListagemProntuariosEscaneados(usuarioDto);

		Assert.assertTrue(resultadoListagemProntuarioEscaneado.sucesso());
		Assert.assertEquals(resultadoListagemProntuarioEscaneado.getObjetosDto().size(), 2);
		Assert.assertFalse(resultadoListagemProntuarioEscaneado.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.USUARIO })
	public void servico_obtem_prontuario_escaneado() throws RemoteException {
		UsuarioDTO usuarioDto = new UsuarioDTO(new Long(12222));

		ResultadoListagemProntuarioEscaneadoDTO resultadoListagemProntuarioEscaneado = servicoSisLaraServerRmi
				.obterListagemProntuariosEscaneados(usuarioDto);

		ProntuarioEscaneadoDTO prontuarioEscaneado = servicoSisLaraServerRmi.obterProntuarioEscaneado(usuarioDto,
				resultadoListagemProntuarioEscaneado.getObjetosDto().get(0));

		Assert.assertNotNull(prontuarioEscaneado);
		Assert.assertTrue(prontuarioEscaneado.getArquivoDto().obterConteudo().length != 0);
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_geracao_agendamento_unico_a_partir_de_especificacao_invalida()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		DescricaoTipoAtendimentoDTO descricaoTipoAtendimentoDTO = ContextoDescricaoTipoAtendimento
				.construirDescricaoTipoAtendimentoDTO();
		descricaoTipoAtendimentoDTO.setId(new Long(12222));
		EspecificacaoGeracaoAgendamentoDTO especificacaoGeracaoAgendamentoDto = new EspecificacaoGeracaoAgendamentoDTO();
		ResultadoGeracaoAgendamentoDTO resultadoGeracaoAgendamento = servicoSisLaraServerRmi
				.gerarAgendamento(especificacaoGeracaoAgendamentoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoAgendamento.sucesso());
		Assert.assertFalse(resultadoGeracaoAgendamento.obterMensagens().isEmpty());
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_geracao_agendamento_por_modulo_bloqueado() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoAgendamentoDTO especificacaoGeracaoAgendamentoDto = new EspecificacaoGeracaoAgendamentoDTO();
		DescricaoTipoAtendimentoDTO descricaoTipoAtendimentoDTO = ContextoDescricaoTipoAtendimento
				.construirDescricaoTipoAtendimentoDTO();
		descricaoTipoAtendimentoDTO.setId(new Long(12222));
		especificacaoGeracaoAgendamentoDto.setDescricaoTipoAtendimentoDto(descricaoTipoAtendimentoDTO);
		especificacaoGeracaoAgendamentoDto.setModuloDto(ContextoModulo.construirModuloDTO());
		List<ProfissionalDTO> profissionais = new ArrayList<>();
		profissionais.add(ContextoProfissional.construirProfissionalDTO());
		especificacaoGeracaoAgendamentoDto.setProfissionaisDto(profissionais);
		especificacaoGeracaoAgendamentoDto.setSetorDto(new SetorDTO("CTO"));
		especificacaoGeracaoAgendamentoDto
				.setLocalAtendimentoDto(ContextoLocalAtendimento.construirLocalAtendimentoDTO());
		especificacaoGeracaoAgendamentoDto.setDataInicio("01/01/2020");
		especificacaoGeracaoAgendamentoDto.setHorarioDto(new HorarioDTO("09:00", "10:00"));
		especificacaoGeracaoAgendamentoDto.setReservaStatusDto(new StatusDTO("CASO_NOVO"));

		ResultadoGeracaoAgendamentoDTO resultadoGeracaoAgendamento = servicoSisLaraServerRmi
				.gerarAgendamento(especificacaoGeracaoAgendamentoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoAgendamento.sucesso());
		Assert.assertFalse(resultadoGeracaoAgendamento.obterMensagens().isEmpty());
		Assert.assertEquals(resultadoGeracaoAgendamento.obterMensagens(), "M�dulo / Atividade est� bloqueado.\n");
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_efetua_agendamento_unico_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoAgendamentoDTO especificacaoGeracaoAgendamentoDTO = ContextoEspecificacaoGeracaoAgendamento
				.fabricarAgendamentoUnicoComTodosOsDados();
		especificacaoGeracaoAgendamentoDTO.setDataInicio("27/07/2099");

		ResultadoGeracaoAgendamentoDTO resultadoGeracaoAgendamento = servicoSisLaraServerRmi
				.gerarAgendamento(especificacaoGeracaoAgendamentoDTO, resultadoDto.getToken());

		Assert.assertTrue(resultadoGeracaoAgendamento.sucesso());
		Assert.assertTrue(resultadoGeracaoAgendamento.getObjetosDto().size() == 1);
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_agendamento_por_bloqueio_de_excesso_de_faltas() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoAgendamentoDTO especificacaoGeracaoAgendamentoDTO = ContextoEspecificacaoGeracaoAgendamento
				.fabricarAgendamentoUnicoComTodosOsDados();
		especificacaoGeracaoAgendamentoDTO.setDataInicio("27/07/2099");

		servico_cria_tres_atendimentos_individuais_com_frequencia_fu_em_dias_diferentes(resultadoDto,
				especificacaoGeracaoAgendamentoDTO.getUsuarioDto().getId());

		ResultadoGeracaoAgendamentoDTO resultadoGeracaoAgendamento = servicoSisLaraServerRmi
				.gerarAgendamento(especificacaoGeracaoAgendamentoDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoAgendamento.sucesso());
		Assert.assertEquals(resultadoGeracaoAgendamento.obterMensagens(),
				"O Usu�rio est� bloqueado por excesso de faltas n�o justificadas.\n");
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_agendamento_unico_sem_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		EspecificacaoGeracaoAgendamentoDTO especificacaoGeracaoAgendamentoDTO = ContextoEspecificacaoGeracaoAgendamento
				.fabricarAgendamentoUnicoComTodosOsDados();

		ResultadoGeracaoAgendamentoDTO resultadoGeracaoAgendamento = servicoSisLaraServerRmi
				.gerarAgendamento(especificacaoGeracaoAgendamentoDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoAgendamento.sucesso());
		Assert.assertFalse(resultadoGeracaoAgendamento.obterMensagens().isEmpty());
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_agendamento_unico_por_conta_de_conflito_de_horario() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoAgendamentoDTO especificacaoGeracaoAgendamentoDTO = ContextoEspecificacaoGeracaoAgendamento
				.fabricarAgendamentoUnicoComTodosOsDados();

		List<ProfissionalDTO> profissionalDTOs = new ArrayList<>();
		profissionalDTOs.add(ContextoProfissional.construirProfissionalDTOAlternativo());
		especificacaoGeracaoAgendamentoDTO.setProfissionaisDto(profissionalDTOs);

		ResultadoGeracaoAgendamentoDTO resultadoGeracaoAgendamento = servicoSisLaraServerRmi
				.gerarAgendamento(especificacaoGeracaoAgendamentoDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoAgendamento.sucesso());
		Assert.assertFalse(resultadoGeracaoAgendamento.obterMensagens().isEmpty());
		Assert.assertEquals(resultadoGeracaoAgendamento.obterMensagens(),
				"O profissinal j� possui agendamentos. VICTOR VITALINO, 31/01/2112, 09:00 �s 11:00. VICTOR VITALINO, 31/01/2112, 09:00 �s 11:00\n");
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_agendamento_unico_por_conta_de_conflito_de_data_anterior_atual()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoAgendamentoDTO especificacaoGeracaoAgendamentoDTO = ContextoEspecificacaoGeracaoAgendamento
				.fabricarAgendamentoUnicoComTodosOsDados();
		especificacaoGeracaoAgendamentoDTO.setDataInicio("01/01/2000");

		List<ProfissionalDTO> profissionalDTOs = new ArrayList<>();
		profissionalDTOs.add(ContextoProfissional.construirProfissionalDTOAlternativo());
		especificacaoGeracaoAgendamentoDTO.setProfissionaisDto(profissionalDTOs);

		ResultadoGeracaoAgendamentoDTO resultadoGeracaoAgendamento = servicoSisLaraServerRmi
				.gerarAgendamento(especificacaoGeracaoAgendamentoDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoAgendamento.sucesso());
		Assert.assertFalse(resultadoGeracaoAgendamento.obterMensagens().isEmpty());
		Assert.assertEquals(resultadoGeracaoAgendamento.obterMensagens(),
				"Agendamento com data anterior a data atual. \n");
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_efetua_agendamento_multiplo_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoAgendamentoDTO especificacaoGeracaoAgendamentoDTO = ContextoEspecificacaoGeracaoAgendamento
				.fabricarAgendamentoMultiploComTodosOsDados();
		especificacaoGeracaoAgendamentoDTO.setDiaSemanaDto(new DiaSemanaDTO("QUARTA"));
		especificacaoGeracaoAgendamentoDTO.setDataInicio("04/02/2099");
		especificacaoGeracaoAgendamentoDTO.setDataTermino("25/02/2099");

		ResultadoGeracaoAgendamentoDTO resultadoGeracaoAgendamento = servicoSisLaraServerRmi
				.gerarAgendamento(especificacaoGeracaoAgendamentoDTO, resultadoDto.getToken());

		Assert.assertTrue(resultadoGeracaoAgendamento.sucesso());
		Assert.assertEquals(resultadoGeracaoAgendamento.getObjetosDto().get(0).getData(), "04/02/2099");
		Assert.assertEquals(resultadoGeracaoAgendamento.getObjetosDto()
				.get(resultadoGeracaoAgendamento.getObjetosDto().size() - 1).getData(), "25/02/2099");
		Assert.assertTrue(resultadoGeracaoAgendamento.getObjetosDto().size() == 8);
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_agendamento_multiplo_sem_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		EspecificacaoGeracaoAgendamentoDTO especificacaoGeracaoAgendamentoDTO = ContextoEspecificacaoGeracaoAgendamento
				.fabricarAgendamentoMultiploComConflito();

		ResultadoGeracaoAgendamentoDTO resultadoGeracaoAgendamento = servicoSisLaraServerRmi
				.gerarAgendamento(especificacaoGeracaoAgendamentoDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoAgendamento.sucesso());
		Assert.assertFalse(resultadoGeracaoAgendamento.obterMensagens().isEmpty());
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_agendamento_multiplo_por_conta_de_conflito_de_horario() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoAgendamentoDTO especificacaoGeracaoAgendamentoDTO = ContextoEspecificacaoGeracaoAgendamento
				.fabricarAgendamentoMultiploComConflito();

		servicoSisLaraServerRmi.gerarAgendamento(especificacaoGeracaoAgendamentoDTO, resultadoDto.getToken());

		ResultadoGeracaoAgendamentoDTO resultadoGeracaoAgendamentoComConflito = servicoSisLaraServerRmi
				.gerarAgendamento(especificacaoGeracaoAgendamentoDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoAgendamentoComConflito.sucesso());
		Assert.assertFalse(resultadoGeracaoAgendamentoComConflito.obterMensagens().isEmpty());
		Assert.assertEquals(resultadoGeracaoAgendamentoComConflito.obterMensagens(),
				"O profissinal j� possui agendamentos. PAULO AUGUSTO BANDEIRA DOS SANTOS, 05/01/2112, 09:00 �s 11:00. PAULO AUGUSTO BANDEIRA DOS SANTOS, 12/01/2112, 09:00 �s 11:00. PAULO AUGUSTO BANDEIRA DOS SANTOS, 19/01/2112, 09:00 �s 11:00. PAULO AUGUSTO BANDEIRA DOS SANTOS, 26/01/2112, 09:00 �s 11:00\n");
	}
	
	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_efetua_agendamento_multiplo_filtrando_conflitos_de_feriado_e_ponte()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoAgendamentoDTO especificacaoGeracaoAgendamentoDTO = ContextoEspecificacaoGeracaoAgendamento
				.fabricarAgendamentoMultiplo();

		ResultadoGeracaoAgendamentoDTO resultadoGeracaoAgendamentoComConflito = servicoSisLaraServerRmi
				.gerarAgendamento(especificacaoGeracaoAgendamentoDTO, resultadoDto.getToken());

		Assert.assertTrue(resultadoGeracaoAgendamentoComConflito.sucesso());
		Assert.assertEquals(resultadoGeracaoAgendamentoComConflito.getObjetosDto().size(), 2);
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_copia_agendamento_nao_cancelado() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoCopiaAgendamentoDTO especificacaoGeracaoCopiaAgendamentoDTO = ContextoEspecificacaoGeracaoCopiaAgendamento
				.fabricarComTodosOsDados();

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(18888));

		ResultadoEdicaoAgendamentoDTO resultadoGeracaoCopiaAgendamento = servicoSisLaraServerRmi
				.copiarAgendamento(especificacaoGeracaoCopiaAgendamentoDTO, agendamentoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoCopiaAgendamento.sucesso());
		Assert.assertFalse(resultadoGeracaoCopiaAgendamento.obterMensagens().isEmpty());
		Assert.assertEquals(resultadoGeracaoCopiaAgendamento.obterMensagens(), "O Agendamento n�o pode ser copiado.\n");
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_copia_agendamento_modulo_bloqueado() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoCopiaAgendamentoDTO especificacaoGeracaoCopiaAgendamentoDTO = ContextoEspecificacaoGeracaoCopiaAgendamento
				.fabricarComTodosOsDados();

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(3000), "Josep", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(17777));

		ResultadoEdicaoAgendamentoDTO resultadoGeracaoCopiaAgendamento = servicoSisLaraServerRmi
				.copiarAgendamento(especificacaoGeracaoCopiaAgendamentoDTO, agendamentoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoCopiaAgendamento.sucesso());
		Assert.assertFalse(resultadoGeracaoCopiaAgendamento.obterMensagens().isEmpty());
		Assert.assertEquals(resultadoGeracaoCopiaAgendamento.obterMensagens(), "M�dulo / Atividade est� bloqueado.\n");
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_copia_agendamento_sem_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		EspecificacaoGeracaoCopiaAgendamentoDTO especificacaoGeracaoCopiaAgendamentoDTO = ContextoEspecificacaoGeracaoCopiaAgendamento
				.fabricarComTodosOsDados();

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(12222));

		ResultadoEdicaoAgendamentoDTO resultadoGeracaoCopiaAgendamento = servicoSisLaraServerRmi
				.copiarAgendamento(especificacaoGeracaoCopiaAgendamentoDTO, agendamentoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoCopiaAgendamento.sucesso());
		Assert.assertFalse(resultadoGeracaoCopiaAgendamento.obterMensagens().isEmpty());
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_copia_agendamento_por_conta_de_conflito_de_data_e_horario() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoCopiaAgendamentoDTO especificacaoGeracaoCopiaAgendamentoDTO = ContextoEspecificacaoGeracaoCopiaAgendamento
				.fabricarComTodosOsDados();
		especificacaoGeracaoCopiaAgendamentoDTO.setData("31/01/2112");

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(6000), "Paulo", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(79999));

		ResultadoEdicaoAgendamentoDTO resultadoGeracaoCopiaAgendamento = servicoSisLaraServerRmi
				.copiarAgendamento(especificacaoGeracaoCopiaAgendamentoDTO, agendamentoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoCopiaAgendamento.sucesso());
		Assert.assertFalse(resultadoGeracaoCopiaAgendamento.obterMensagens().isEmpty());
		Assert.assertEquals(resultadoGeracaoCopiaAgendamento.obterMensagens(),
				"O profissinal j� possui agendamentos. JOAO, 31/01/2112, 09:00 �s 11:00\n");
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_copia_agendamento_por_conta_de_data_e_horario_invalido() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoCopiaAgendamentoDTO especificacaoGeracaoCopiaAgendamentoDTO = ContextoEspecificacaoGeracaoCopiaAgendamento
				.fabricarComTodosOsDados();
		especificacaoGeracaoCopiaAgendamentoDTO.setData("99/07/2012");

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(2000), "Paulo", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(13333));

		ResultadoEdicaoAgendamentoDTO resultadoGeracaoCopiaAgendamento = servicoSisLaraServerRmi
				.copiarAgendamento(especificacaoGeracaoCopiaAgendamentoDTO, agendamentoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoCopiaAgendamento.sucesso());
		Assert.assertFalse(resultadoGeracaoCopiaAgendamento.obterMensagens().isEmpty());
		Assert.assertEquals(resultadoGeracaoCopiaAgendamento.obterMensagens(), "Insira uma Data v�lida.\n\n");
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_efetua_copia_agendamento_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoCopiaAgendamentoDTO especificacaoGeracaoCopiaAgendamentoDTO = ContextoEspecificacaoGeracaoCopiaAgendamento
				.fabricarComTodosOsDados();

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(6000), "Paulo", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(79999));

		ResultadoEdicaoAgendamentoDTO resultadoGeracaoCopiaAgendamento = servicoSisLaraServerRmi
				.copiarAgendamento(especificacaoGeracaoCopiaAgendamentoDTO, agendamentoDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoGeracaoCopiaAgendamento.sucesso());
		Assert.assertNotNull(resultadoGeracaoCopiaAgendamento.obterObjetoDtoEditado());
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_efetua_liberacao_agendamento_cancelando_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(2000), "Josep", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);

		AgendamentoDTO agendamentoDTO = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(13333));
		agendamentoDTO.setMotivoCancelamentoDTO(new MotivoCancelamentoDTO(new Long(1), "Motivo"));

		ResultadoEdicaoAgendamentoDTO resultadoLiberadoDto = servicoSisLaraServerRmi
				.liberarAgendamentoCancelando(agendamentoDTO, resultadoDto.getToken());

		ResultadoListagemAgendamentoDTO resultadoAposLiberacao = servicoSisLaraServerRmi
				.obterListagemAgendamento(especificacao);

		Assert.assertTrue(resultadoLiberadoDto.sucesso());
		Assert.assertEquals(resultadoAposLiberacao.getObjetosDto().size(), 5);
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_liberacao_agendamento_cancelando_sem_motivo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(2000), "Josep", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);

		AgendamentoDTO agendamentoDTO = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(15555));

		ResultadoEdicaoAgendamentoDTO resultadoLiberadoDto = servicoSisLaraServerRmi
				.liberarAgendamentoCancelando(agendamentoDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoLiberadoDto.sucesso());
		Assert.assertEquals(resultadoLiberadoDto.obterMensagens(),
				"O Agendamento n�o pode ser liberado por aus�ncia de motivo.\n");
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_liberacao_agendamento_cancelando_sem_autorizacao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(2000), "Josep", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);

		AgendamentoDTO agendamentoDTO = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(15555));

		ResultadoEdicaoAgendamentoDTO resultadoLiberadoDto = servicoSisLaraServerRmi
				.liberarAgendamentoCancelando(agendamentoDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoLiberadoDto.sucesso());
		Assert.assertEquals(resultadoLiberadoDto.obterMensagens(),
				"Voc� n�o possui autoriza��o para realizar a opera��o.\n");
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_liberacao_agendamento_cancelando_com_modulo_bloqueado() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(3000), "Josep", "1234"));

		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);

		// Id 17777
		AgendamentoDTO agendamentoDTO = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(17777));
		agendamentoDTO.setMotivoCancelamentoDTO(new MotivoCancelamentoDTO(new Long(1), "Motivo"));

		ResultadoEdicaoAgendamentoDTO resultadoLiberadoDto = servicoSisLaraServerRmi
				.liberarAgendamentoCancelando(agendamentoDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoLiberadoDto.sucesso());
		Assert.assertEquals(resultadoLiberadoDto.obterMensagens(), "M�dulo / Atividade est� bloqueado.\n");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_agendamento_com_especificacao() throws RemoteException {
		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);

		Assert.assertTrue(resultado.sucesso());
		Assert.assertFalse(resultado.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_agendamento_disponiveis_com_especificacao() throws RemoteException {

		TipoAtendimentoDTO tipoAtendimentoDto = new TipoAtendimentoDTO();
		tipoAtendimentoDto.setId(new Long(22222));
		DescricaoTipoAtendimentoDTO descricaoTipoAtendimentoDTO = new DescricaoTipoAtendimentoDTO();
		descricaoTipoAtendimentoDTO.setId(new Long(12222));
		descricaoTipoAtendimentoDTO.setTipoAtendimentoDto(tipoAtendimentoDto);
		List<NomeGrupoDTO> nomesGruposDto = new ArrayList<>();
		nomesGruposDto.add(new NomeGrupoDTO(new Long(21), "G0"));
		descricaoTipoAtendimentoDTO.setNomesGruposDto(nomesGruposDto);
		ModuloDTO moduloDto = new ModuloDTO(new Long(2), "Info");

		EspecificacaoPesquisaAgendamentoDTO especificacaoPesquisaAgendamento = new EspecificacaoPesquisaAgendamentoDTO();
		especificacaoPesquisaAgendamento.setProfissionalDto(new ProfissionalDTO(new Long(2000), "Josep", "1234"));
		especificacaoPesquisaAgendamento.setDescricaoTipoAtendimentoDTO(descricaoTipoAtendimentoDTO);
		especificacaoPesquisaAgendamento.setModuloDTO(moduloDto);
		ResultadoListagemAgendamentoDTO resultadoAgendamento = servicoSisLaraServerRmi
				.obterListagemAgendamentoDisponiveis(especificacaoPesquisaAgendamento);

		Assert.assertTrue(resultadoAgendamento.sucesso());
		Assert.assertFalse(resultadoAgendamento.getObjetosDto().isEmpty());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_obtem_listagem_agendamento_com_especificacao_invalida() throws RemoteException {
		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setDataInicio("erro");
		especificacao.setDataTermino("erro");
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);

		Assert.assertFalse(resultado.sucesso());
		Assert.assertFalse(resultado.obterMensagens().isEmpty());
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_efetua_cancelamento_agendamento_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(12222));

		agendamentoDto.setMotivoCancelamentoDTO(new MotivoCancelamentoDTO(new Long(1), "Nao Justificou"));
		agendamentoDto.setJustificativaCancelamento("Grande texto de justificativa");

		ResultadoEdicaoAgendamentoDTO resultadoEdicaoAgendamentoDto = servicoSisLaraServerRmi
				.cancelarAgendamento(agendamentoDto, resultadoDto.getToken());

		ResultadoListagemAgendamentoDTO resultadoAposCancelamento = servicoSisLaraServerRmi
				.obterListagemAgendamento(especificacao);
		AgendamentoDTO agendamentoDtoAposCancelamento = (AgendamentoDTO) obterDaRelacaoPorId(
				resultadoAposCancelamento.getObjetosDto(), new Long(12222));

		Assert.assertTrue(resultadoEdicaoAgendamentoDto.sucesso());
		Assert.assertTrue(agendamentoDtoAposCancelamento.isEstaCancelado());
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_cancelamento_agendamento_por_falta_motivo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(12222));

		ResultadoEdicaoAgendamentoDTO resultadoEdicaoAgendamentoDto = servicoSisLaraServerRmi
				.cancelarAgendamento(agendamentoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAgendamentoDto.sucesso());
		Assert.assertEquals(resultadoEdicaoAgendamentoDto.obterMensagens(), "Insira um motivo de cancelamento.\n\n");
	}

	@Test(groups = { TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_cancelamento_agendamento_sem_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(12222));

		agendamentoDto.setMotivoCancelamentoDTO(new MotivoCancelamentoDTO(new Long(1), "Nao Justificou"));

		ResultadoEdicaoAgendamentoDTO resultadoEdicaoAgendamentoDto = servicoSisLaraServerRmi
				.editarAgendamento(agendamentoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAgendamentoDto.sucesso());
		Assert.assertFalse(resultadoEdicaoAgendamentoDto.obterMensagens().isEmpty());
	}

	@Test(groups = { TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_agendamento_com_usuario_e_pre_cadastro_atribuidos() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(12222));
		agendamentoDto.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacao());
		agendamentoDto.setPreCadastroDto(ContextoPreCadastro.construirPreCadastroDTO());

		ResultadoEdicaoAgendamentoDTO resultadoEdicaoAgendamentoDto = servicoSisLaraServerRmi
				.editarAgendamento(agendamentoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAgendamentoDto.sucesso());
		Assert.assertFalse(resultadoEdicaoAgendamentoDto.obterMensagens().isEmpty());
		Assert.assertEquals(resultadoEdicaoAgendamentoDto.obterMensagens(),
				"� poss�vel associar somente Oftalmologia ou Servico Social.\nInserir somente um Usu�rio ou um Pr�-cadastro.\n\n");
	}

	@Test(groups = { TiposDeTeste.AGENDAMENTO })
	public void servico_nao_efetua_agendamento_com_associacao_pre_cadastro_restrito() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(12222));
		agendamentoDto.setUsuarioDto(null);
		agendamentoDto.setPreCadastroDto(ContextoPreCadastro.construirPreCadastroDTO());

		ResultadoEdicaoAgendamentoDTO resultadoEdicaoAgendamentoDto = servicoSisLaraServerRmi
				.editarAgendamento(agendamentoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAgendamentoDto.sucesso());
		Assert.assertFalse(resultadoEdicaoAgendamentoDto.obterMensagens().isEmpty());
		Assert.assertEquals(resultadoEdicaoAgendamentoDto.obterMensagens(),
				"� poss�vel associar somente Oftalmologia ou Servico Social.\nInserir somente um Usu�rio ou um Pr�-cadastro.\n\n");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_motivo_cancelamento_agendamento() throws RemoteException {
		ResultadoListagemMotivoCancelamentoDTO resultadoListagemMotivoCancelamentoAgendamentoDto = servicoSisLaraServerRmi
				.obterListagemMotivoCancelamentoAgendamento();

		Assert.assertTrue(resultadoListagemMotivoCancelamentoAgendamentoDto.sucesso());
		Assert.assertEquals(resultadoListagemMotivoCancelamentoAgendamentoDto.getObjetosDto().size(), 2);
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_motivo_cancelamento_demanda() throws RemoteException {
		ResultadoListagemMotivoCancelamentoDTO resultadoListagemMotivoDemandaDto = servicoSisLaraServerRmi
				.obterListagemMotivoCancelamentoDemanda();

		Assert.assertTrue(resultadoListagemMotivoDemandaDto.sucesso());
		Assert.assertEquals(resultadoListagemMotivoDemandaDto.getObjetosDto().size(), 1);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_status_de_agendamento() throws RemoteException {
		ResultadoListagemStatusAgendamentoDTO resultadoListagemStatusAgendamentoDto = servicoSisLaraServerRmi
				.obterListagemStatusAgendamento();

		Assert.assertTrue(resultadoListagemStatusAgendamentoDto.sucesso());
		Assert.assertFalse(resultadoListagemStatusAgendamentoDto.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_status_entrega_de_solicitacao_relatorio() throws RemoteException {
		ResultadoListagemStatusSolicitacaoRelatorioDTO resultadoListagemStatusAgendamentoDto = servicoSisLaraServerRmi
				.obterListagemStatusEntrega();

		Assert.assertTrue(resultadoListagemStatusAgendamentoDto.sucesso());
		Assert.assertFalse(resultadoListagemStatusAgendamentoDto.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_status_de_solicitacao_relatorio() throws RemoteException {
		ResultadoListagemStatusSolicitacaoRelatorioDTO resultadoListagemStatusAgendamentoDto = servicoSisLaraServerRmi
				.obterListagemStatusSolicitacaoRelatorio();

		Assert.assertTrue(resultadoListagemStatusAgendamentoDto.sucesso());
		Assert.assertFalse(resultadoListagemStatusAgendamentoDto.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_finalidades_relatorio() throws RemoteException {
		ResultadoListagemFinalidadeRelatorioDTO resultadoListagemFinalidadesRelatorioDto = servicoSisLaraServerRmi
				.obterListagemFinalidadeRelatorio();

		Assert.assertTrue(resultadoListagemFinalidadesRelatorioDto.sucesso());
		Assert.assertFalse(resultadoListagemFinalidadesRelatorioDto.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_elaborador_relatorio() throws RemoteException {
		ResultadoListagemElaboradorDTO resultadoListagemElaboradorDto = servicoSisLaraServerRmi
				.obterListagemElaborador();

		Assert.assertTrue(resultadoListagemElaboradorDto.sucesso());
		Assert.assertFalse(resultadoListagemElaboradorDto.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_status_de_espera() throws RemoteException {
		ResultadoListagemStatusEsperaDTO resultadoListagemStatusEsperaDto = servicoSisLaraServerRmi
				.obterListagemStatusEspera();

		Assert.assertTrue(resultadoListagemStatusEsperaDto.sucesso());
		Assert.assertFalse(resultadoListagemStatusEsperaDto.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_tipo_de_espera() throws RemoteException {
		ResultadoListagemTipoEsperaDTO resultadoListagemTipoEsperaDto = servicoSisLaraServerRmi
				.obterListagemTipoEsperaTotal();

		Assert.assertTrue(resultadoListagemTipoEsperaDto.sucesso());
		Assert.assertFalse(resultadoListagemTipoEsperaDto.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_espera_com_especificacao() throws RemoteException {
		EspecificacaoPesquisaEsperaDTO especificacao = new EspecificacaoPesquisaEsperaDTO();
		especificacao.setTipoEsperaDto(new TipoEsperaDTO(TipoEspera.RET.toString()));
		especificacao.setInteresse(false);
		especificacao.setLmLigou(false);
		especificacao.setPendencias(false);
		ResultadoListagemEsperaDTO resultado = servicoSisLaraServerRmi.obterListagemEspera(especificacao);

		Assert.assertTrue(resultado.sucesso());
		Assert.assertFalse(resultado.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_obtem_listagem_espera_com_especificacao_invalida() throws RemoteException {
		EspecificacaoPesquisaEsperaDTO especificacao = new EspecificacaoPesquisaEsperaDTO();
		especificacao.setInteresse(false);
		especificacao.setLmLigou(false);
		especificacao.setPendencias(false);

		ResultadoListagemEsperaDTO resultado = servicoSisLaraServerRmi.obterListagemEspera(especificacao);

		Assert.assertFalse(resultado.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_observacoes_historicas_de_espera_com_informacao_essencial() throws RemoteException {

		InformacaoEssencialDTO informacaoEssencialDto = new InformacaoEssencialDTO();
		informacaoEssencialDto.setId(new Long(44444));
		String resultado = servicoSisLaraServerRmi.obterObservacoesHistoricasEspera(informacaoEssencialDto);

		String esperadoA = "Descri��o: Atendimento de Teste\nM�dulo: Atendimento Especifico Especializado\nExpectativa: 01/01/2012\nobs 1\nSolicitada por: VICTOR VITALINO\n----";
		String esperadoB = "\nDescri��o: Atendimento de Teste\nM�dulo: Acompanhamento\nExpectativa: 02/01/2012\nobs 2\nSolicitada por: VICTOR VITALINO\n----";
		String esperadoC = "\nDescri��o: Atendimento de Teste\nM�dulo: Ingl�s\nExpectativa: 02/01/2012\nobs 2\nSolicitada por: VICTOR VITALINO\n----";

		Assert.assertTrue(resultado.contains(esperadoA));
		Assert.assertTrue(resultado.contains(esperadoB));
		Assert.assertTrue(resultado.contains(esperadoC));
	}

	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_nao_inclui_nova_espera_impossibilidade_modulo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EsperaDTO esperaDto = ContextoEspera.construirEsperaDTO();
		esperaDto.getPreCadastroDto().setId(new Long(12222));
		esperaDto.getDescricaoTipoAtendimentoDto().setId(new Long(12222));
		esperaDto.setModuloDto(new ModuloDTO(new Long(3), "Modulo Bloqueado"));

		ResultadoEdicaoEsperaDTO resultadoInclusaoEspera = servicoSisLaraServerRmi.editarEspera(esperaDto,
				resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoEspera.sucesso());
		Assert.assertEquals(resultadoInclusaoEspera.obterMensagens(), "M�dulo/Atividade n�o permite a inclus�o.\n");
	}

	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_inclui_nova_espera() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EsperaDTO esperaDto = ContextoEspera.construirEsperaDTO();
		esperaDto.setPreCadastroDto(null);
		esperaDto.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacao());

		ResultadoEdicaoEsperaDTO resultadoInclusaoEspera = servicoSisLaraServerRmi.editarEspera(esperaDto,
				resultadoDto.getToken());

		EsperaDTO esperaDTOIncluida = (EsperaDTO) resultadoInclusaoEspera.obterObjetoDtoEditado();

		Assert.assertTrue(resultadoInclusaoEspera.sucesso());
		Assert.assertTrue(esperaDTOIncluida.estaAguardando());
	}

	@Test(groups = { TiposDeTeste.PENDENCIA })
	public void servico_gera_pendencia_atendimento_individual_apos_associacao_espera_ao_agendamento_com_sucesso()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		criar_espera_e_agendamento_e_efetuar_associacao_entre_os_dois(resultadoDto);

		ResultadoListagemPendenciaDTO listagemPendencia = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		Assert.assertEquals(listagemPendencia.getObjetosDto().size(), 1);
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_resolve_pendencia_atendimento_grupo_apos_criacao_atendimento_de_grupo_com_sucesso()
			throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		MaquinaTempo.mudarDataAtual("01/01/2117");
		ResultadoListagemPendenciaDTO listagemPendenciaAntesAtualizacao = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222));

		gerarEEditarAtendimento(new EspecificacaoGeracaoAtendimentoDTO(
				obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(), new Long(11111)).getId(), "01/01/2115", new HorarioDTO("09:00",
				"19:00")), resultadoDto.getToken());

		Registro.obterAutomatizadorPendencia().atualizarPendencias();

		ResultadoListagemPendenciaDTO listagemPendenciaAposAtualizacao = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertEquals(listagemPendenciaAntesAtualizacao.getObjetosDto().size(), 2);
		Assert.assertEquals(listagemPendenciaAposAtualizacao.getObjetosDto().size(), 1);
	}

	@Test(groups = { TiposDeTeste.PENDENCIA })
	public void servico_resolve_pendencia_atendimento_individual_com_usuario_apos_criacao_atendimento_individual_com_sucesso()
			throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		
		ResultadoAutenticacaoDTO resultadoShivasDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaShivas());
		Long idPendencia = new Long(5001);

		MaquinaTempo.mudarDataAtual("01/01/2117");
		criar_espera_e_agendamento_e_efetuar_associacao_entre_os_dois(resultadoDto);

		ResultadoListagemPendenciaDTO listagemPendenciaAntesResolucao = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		PendenciaDTO pendencia = (PendenciaDTO) obterDaRelacaoPorId(listagemPendenciaAntesResolucao.getObjetosDto(), idPendencia);

		AtendimentoIndividualDTO atendimentoIndividualDTO = pendencia.getAtendimentoIndividualDTOReferenciaParaGeracao();
		atendimentoIndividualDTO.setData("31/01/2012");
		atendimentoIndividualDTO.setPrimeiraVezOuRetornoDto(new StatusDTO(Status.RETORNO.toString()));
		atendimentoIndividualDTO.setOpcaoIntegracaoDto(new OpcaoIntegracaoDTO(OpcaoIntegracao.INTEGRACAO.toString()));
		atendimentoIndividualDTO.setDiscussaoCasoSimNaoDto(new SimNaoDTO(SimNao.SIM.toString()));
		atendimentoIndividualDTO.getInformacaoAtendimentoDto().setParticipadaoDetalhadaDto(
				Arrays.asList(ContextoParticipacaoDetalhada.contruirParticipacaoDetalhadaDto()));
		
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDTO = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDTO, resultadoShivasDto.getToken());

		Registro.obterAutomatizadorPendencia().atualizarPendencias();

		ResultadoListagemPendenciaDTO listagemPendenciaAposResolucao = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();

		PendenciaDTO pendenciaNaoExistente = (PendenciaDTO) obterDaRelacaoPorId(
				listagemPendenciaAposResolucao.getObjetosDto(), idPendencia);
		
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDTO.sucesso());
		Assert.assertEquals(listagemPendenciaAntesResolucao.getObjetosDto().size(), 3);
		Assert.assertEquals(listagemPendenciaAposResolucao.getObjetosDto().size(), 2);
		Assert.assertNull(pendenciaNaoExistente);
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_resolve_pendencia_atendimento_individual_apos_cancelamento_agendamento_com_sucesso()
			throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		criar_espera_e_agendamento_e_efetuar_associacao_entre_os_dois(resultadoDto);

		ResultadoListagemPendenciaDTO listagemPendenciaAntesResolucao = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		EspecificacaoPesquisaAgendamentoDTO especificacaoPesquisaAgendamentoDTO = new EspecificacaoPesquisaAgendamentoDTO();
		especificacaoPesquisaAgendamentoDTO.setDataInicio(DataHoraUtils.formatarData(MaquinaTempo.obterInstancia().obterCalendarioAtual()));
		ResultadoListagemAgendamentoDTO agendamentosDto = servicoSisLaraServerRmi
				.obterListagemAgendamento(especificacaoPesquisaAgendamentoDTO);
		AgendamentoDTO agendamentoDTO = agendamentosDto.getObjetosDto().get(0);
		agendamentoDTO.setMotivoCancelamentoDTO(new MotivoCancelamentoDTO(new Long(1), "Nao explicou"));
		servicoSisLaraServerRmi.cancelarAgendamento(agendamentoDTO, resultadoDto.getToken());

		Registro.obterAutomatizadorPendencia().atualizarPendencias();

		ResultadoListagemPendenciaDTO listagemPendenciaAposResolucao = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		Assert.assertEquals(listagemPendenciaAntesResolucao.getObjetosDto().size(), 1);
		Assert.assertEquals(listagemPendenciaAposResolucao.getObjetosDto().size(), 0);
	}

	@Test(groups = { TiposDeTeste.CONTRIBUINTE })
	public void servico_altera_contribuinte_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaContribuinteDTO especificacao = new EspecificacaoPesquisaContribuinteDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.NOME_CONTRIBUINTE, "ARAKEN");
		ResultadoListagemContribuinteDTO resultadoListagemContribuintesDto = servicoSisLaraServerRmi
				.pesquisarContribuintePor(especificacao);

		ContribuinteDTO contribuinteIncluidoDto = (ContribuinteDTO) obterDaRelacaoPorId(
				resultadoListagemContribuintesDto.getObjetosDto(), new Long(88888));
		contribuinteIncluidoDto.setNomeEmpresa("TESTE");
		contribuinteIncluidoDto.getEnderecoDto().setNumero("123");
		contribuinteIncluidoDto.setStatusContribuinteDto(new StatusContribuinteDTO("DESATIVADO"));

		ResultadoEdicaoContribuinteDTO resultadoInclusaoContribuinte = servicoSisLaraServerRmi
				.editarContribuinte(contribuinteIncluidoDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoInclusaoContribuinte.sucesso());
	}

	@Test(groups = { TiposDeTeste.CONTRIBUINTE })
	public void servico_inclui_contribuinte() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ContribuinteDTO contribuinteDto = ContextoContribuinte.fabricarContribuinteDtoComTodosOsDados();
		contribuinteDto.setId(null);

		ResultadoEdicaoContribuinteDTO resultadoInclusaoContribuinte = servicoSisLaraServerRmi
				.editarContribuinte(contribuinteDto, resultadoDto.getToken());

		ContribuinteDTO contribuinteIncluidoDto = (ContribuinteDTO) resultadoInclusaoContribuinte
				.obterObjetoDtoEditado();

		Assert.assertTrue(resultadoInclusaoContribuinte.sucesso());
		Assert.assertNotNull(contribuinteIncluidoDto.getId());
	}

	@Test(groups = { TiposDeTeste.CONTRIBUINTE })
	public void servico_nao_inclui_contribuinte_sem_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ContribuinteDTO contribuinteDto = ContextoContribuinte.fabricarContribuinteDtoComTodosOsDados();

		ResultadoEdicaoContribuinteDTO resultadoInclusaoContribuinte = servicoSisLaraServerRmi
				.editarContribuinte(contribuinteDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoContribuinte.sucesso());
		Assert.assertEquals(resultadoInclusaoContribuinte.obterMensagens(),
				"Voc� n�o possui autoriza��o para realizar a opera��o.\n");
	}

	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_inclui_nova_espera_triagem_oftalmologica() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EsperaDTO esperaDto = ContextoEspera.construirEsperaDTO();
		esperaDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOftalmologia());
		esperaDto.setModuloDto(ContextoModulo.construirModuloDTOTriagemOftalmologia());
		esperaDto.setPreCadastroDto(null);
		esperaDto.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacao());

		ResultadoEdicaoEsperaDTO resultadoInclusaoEspera = servicoSisLaraServerRmi.editarEspera(esperaDto,
				resultadoDto.getToken());

		EsperaDTO esperaDTOIncluida = (EsperaDTO) resultadoInclusaoEspera.obterObjetoDtoEditado();

		Assert.assertTrue(resultadoInclusaoEspera.sucesso());
		Assert.assertTrue(esperaDTOIncluida.estaTriando());
	}

	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_nao_inclui_nova_espera_triagem_oftalmologica_duplicada() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EsperaDTO esperaDto = ContextoEspera.construirEsperaDTO();
		esperaDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOftalmologia());
		esperaDto.setModuloDto(ContextoModulo.construirModuloDTOTriagemOftalmologia());
		esperaDto.setPreCadastroDto(null);
		esperaDto.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacao());

		ResultadoEdicaoEsperaDTO resultadoInclusaoEspera = servicoSisLaraServerRmi.editarEspera(esperaDto,
				resultadoDto.getToken());

		ResultadoEdicaoEsperaDTO resultadoInclusaoEsperaDuplicada = servicoSisLaraServerRmi.editarEspera(esperaDto,
				resultadoDto.getToken());

		Assert.assertTrue(resultadoInclusaoEspera.sucesso());
		Assert.assertFalse(resultadoInclusaoEsperaDuplicada.sucesso());
		Assert.assertEquals(resultadoInclusaoEsperaDuplicada.obterMensagens(),
				"O Usu�rio n�o pode estar na espera para Triagem e Avalia��o Oftalmol�gica simultaneamente.\n");
	}

	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_nao_inclui_nova_espera_triagem_oftalmologica_duplicada_aguardando() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EsperaDTO esperaDto = ContextoEspera.construirEsperaDTO();
		esperaDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOftalmologia());
		esperaDto.setModuloDto(ContextoModulo.construirModuloDTOTriagemOftalmologia());
		esperaDto.setPreCadastroDto(null);
		esperaDto.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacao());

		ResultadoEdicaoEsperaDTO resultadoInclusaoEspera = servicoSisLaraServerRmi.editarEspera(esperaDto,
				resultadoDto.getToken());

		ResultadoEdicaoEsperaDTO resultadoConclusaoEspera = servicoSisLaraServerRmi
				.concluirEspera((EsperaDTO) resultadoInclusaoEspera.obterObjetoDtoEditado(), resultadoDto.getToken());

		EsperaDTO esperaDTOAguardando = (EsperaDTO) resultadoConclusaoEspera.obterObjetoDtoEditado();
		esperaDTOAguardando.setId(null);
		ResultadoEdicaoEsperaDTO resultadoInclusaoEsperaDuplicada = servicoSisLaraServerRmi
				.editarEspera(esperaDTOAguardando, resultadoDto.getToken());

		Assert.assertTrue(resultadoInclusaoEspera.sucesso());
		Assert.assertFalse(resultadoInclusaoEsperaDuplicada.sucesso());
		Assert.assertEquals(resultadoInclusaoEsperaDuplicada.obterMensagens(),
				"O Usu�rio ou Pr�-cadastro j� est� inclu�do na lista de espera do tipo selecionado.\n");
	}

	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_nao_inclui_nova_espera_triagem_oftalmologica_duplicada_triando() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EsperaDTO esperaDto = ContextoEspera.construirEsperaDTO();
		esperaDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOftalmologia());
		esperaDto.setModuloDto(ContextoModulo.construirModuloDTOTriagemOftalmologia());
		esperaDto.setPreCadastroDto(null);
		esperaDto.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacao());

		ResultadoEdicaoEsperaDTO resultadoInclusaoEspera = servicoSisLaraServerRmi.editarEspera(esperaDto,
				resultadoDto.getToken());

		EsperaDTO esperaDTOTriando = (EsperaDTO) resultadoInclusaoEspera.obterObjetoDtoEditado();
		esperaDTOTriando.setId(null);
		ResultadoEdicaoEsperaDTO resultadoInclusaoEsperaDuplicada = servicoSisLaraServerRmi
				.editarEspera(esperaDTOTriando, resultadoDto.getToken());

		Assert.assertTrue(resultadoInclusaoEspera.sucesso());
		Assert.assertFalse(resultadoInclusaoEsperaDuplicada.sucesso());
		Assert.assertEquals(resultadoInclusaoEsperaDuplicada.obterMensagens(),
				"O Usu�rio n�o pode estar na espera para Triagem e Avalia��o Oftalmol�gica simultaneamente.\n");
	}

	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_nao_inclui_nova_espera_triagem_oftalmologica_simultanea_e_atendimento_especifico_especializado()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EsperaDTO esperaDto = ContextoEspera.construirEsperaDTO();
		esperaDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOftalmologia());
		esperaDto.setModuloDto(ContextoModulo.construirModuloDTOTriagemOftalmologia());
		esperaDto.setPreCadastroDto(null);
		esperaDto.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacao());

		ResultadoEdicaoEsperaDTO resultadoInclusaoEsperaTriagemOftalmologica = servicoSisLaraServerRmi
				.editarEspera(esperaDto, resultadoDto.getToken());

		esperaDto.setModuloDto(ContextoModulo.construirModuloDTO());
		ResultadoEdicaoEsperaDTO resultadoInclusaoEsperaAtendimentoEspecificoEspecializado = servicoSisLaraServerRmi
				.editarEspera(esperaDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoInclusaoEsperaTriagemOftalmologica.sucesso());
		Assert.assertFalse(resultadoInclusaoEsperaAtendimentoEspecificoEspecializado.sucesso());
		Assert.assertEquals(resultadoInclusaoEsperaAtendimentoEspecificoEspecializado.obterMensagens(),
				"O Usu�rio n�o pode estar na espera para Triagem e Avalia��o Oftalmol�gica simultaneamente.\n");
	}

	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_inclui_nova_espera_outra_descricao_mesmo_com_triagem_oftalmologica_existente()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EsperaDTO esperaDto = ContextoEspera.construirEsperaDTO();
		esperaDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOftalmologia());
		esperaDto.setModuloDto(ContextoModulo.construirModuloDTOTriagemOftalmologia());
		esperaDto.setPreCadastroDto(null);
		esperaDto.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacao());

		ResultadoEdicaoEsperaDTO resultadoInclusaoEsperaTriagemOftalmologica = servicoSisLaraServerRmi
				.editarEspera(esperaDto, resultadoDto.getToken());

		esperaDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTO());
		esperaDto.setModuloDto(ContextoModulo.construirModuloInglesDTO());
		ResultadoEdicaoEsperaDTO resultadoInclusaoEsperaIngles = servicoSisLaraServerRmi.editarEspera(esperaDto,
				resultadoDto.getToken());

		Assert.assertTrue(resultadoInclusaoEsperaTriagemOftalmologica.sucesso());
		Assert.assertTrue(resultadoInclusaoEsperaIngles.sucesso());
	}

	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_nao_inclui_nova_espera_por_conta_de_data_invalida() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EsperaDTO esperaDto = ContextoEspera.construirEsperaDTO();
		esperaDto.setDataExpectativa("928374SS");

		ResultadoEdicaoEsperaDTO resultadoInclusaoEspera = servicoSisLaraServerRmi.editarEspera(esperaDto,
				resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoEspera.sucesso());
		Assert.assertEquals(resultadoInclusaoEspera.obterMensagens(), "Insira a Data de Expectativa v�lida.\n\n");
	}

	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_nao_inclui_nova_espera_por_conta_de_duplicacao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EsperaDTO esperaDto = ContextoEspera.construirEsperaDTO();
		esperaDto.setPreCadastroDto(null);
		esperaDto.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacao());
		servicoSisLaraServerRmi.editarEspera(esperaDto, resultadoDto.getToken());

		EspecificacaoPesquisaEsperaDTO especificacaoPesquisaEsperaDTO = new EspecificacaoPesquisaEsperaDTO();
		especificacaoPesquisaEsperaDTO.setDescricaoTipoAtendimentoDto(esperaDto.getDescricaoTipoAtendimentoDto());
		especificacaoPesquisaEsperaDTO.setModuloDto(esperaDto.getModuloDto());
		especificacaoPesquisaEsperaDTO.setInteresse(false);
		especificacaoPesquisaEsperaDTO.setLmLigou(false);
		especificacaoPesquisaEsperaDTO.setPendencias(false);

		ResultadoListagemEsperaDTO resultadoListagemEsperaDtoIncluida = servicoSisLaraServerRmi
				.obterListagemEspera(especificacaoPesquisaEsperaDTO);
		EsperaDTO esperaDtoIncluida = resultadoListagemEsperaDtoIncluida.getObjetosDto().get(0);
		esperaDtoIncluida.setId(null);

		ResultadoEdicaoEsperaDTO resultadoInclusaoEsperaDuplicado = servicoSisLaraServerRmi
				.editarEspera(esperaDtoIncluida, resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoEsperaDuplicado.sucesso());
		Assert.assertEquals(resultadoInclusaoEsperaDuplicado.obterMensagens(),
				"O Usu�rio ou Pr�-cadastro j� est� inclu�do na lista de espera do tipo selecionado.\n");
	}

	@Test(groups = { TiposDeTeste.ESPERA })
	public void servico_cancela_espera() throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaEsperaDTO especificacao = new EspecificacaoPesquisaEsperaDTO();
		especificacao.setTipoEsperaDto(new TipoEsperaDTO(TipoEspera.RET.toString()));
		especificacao.setInteresse(false);
		especificacao.setLmLigou(false);
		especificacao.setPendencias(false);

		ResultadoListagemEsperaDTO resultado = servicoSisLaraServerRmi.obterListagemEspera(especificacao);

		EsperaDTO espera = (EsperaDTO) obterDaRelacaoPorId(resultado.getObjetosDto(), new Long(13333));
		espera.setJustificativaCancelamento("Justificativa do cancelamento.");
		ResultadoEdicaoEsperaDTO resultadoCancelamentoEspera = servicoSisLaraServerRmi.cancelarEspera(espera,
				resultadoDto.getToken());

		Assert.assertTrue(resultadoCancelamentoEspera.sucesso());
		Assert.assertTrue(((EsperaDTO) resultadoCancelamentoEspera.obterObjetoDtoEditado()).estaCancelado());
	}

	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_conclui_espera() throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaEsperaDTO especificacao = new EspecificacaoPesquisaEsperaDTO();
		especificacao.setTipoEsperaDto(new TipoEsperaDTO(TipoEspera.RET.toString()));
		especificacao.setInteresse(false);
		especificacao.setLmLigou(false);
		especificacao.setPendencias(false);

		ResultadoListagemEsperaDTO resultado = servicoSisLaraServerRmi.obterListagemEspera(especificacao);

		EsperaDTO espera = (EsperaDTO) obterDaRelacaoPorId(resultado.getObjetosDto(), new Long(13333));

		ResultadoEdicaoEsperaDTO resultadoInclusaoEspera = servicoSisLaraServerRmi.concluirEspera(espera,
				resultadoDto.getToken());

		Assert.assertTrue(resultadoInclusaoEspera.sucesso());
		Assert.assertEquals(((EsperaDTO) resultadoInclusaoEspera.obterObjetoDtoEditado()).getStatusDto().toString(),
				new StatusDTO(StatusEspera.AGENDADO.toString()).toString());
	}

	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_conclui_espera_em_triagem() throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EsperaDTO esperaDto = ContextoEspera.construirEsperaDTO();
		esperaDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOftalmologia());
		esperaDto.setModuloDto(ContextoModulo.construirModuloDTOTriagemOftalmologia());
		esperaDto.setPreCadastroDto(null);
		esperaDto.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacao());

		EsperaDTO esperaDTOIncluida = (EsperaDTO) servicoSisLaraServerRmi
				.editarEspera(esperaDto, resultadoDto.getToken()).obterObjetoDtoEditado();

		ResultadoEdicaoEsperaDTO resultadoInclusaoEspera = servicoSisLaraServerRmi.concluirEspera(esperaDTOIncluida,
				resultadoDto.getToken());

		EsperaDTO esperaDtoAgendada = (EsperaDTO) resultadoInclusaoEspera.obterObjetoDtoEditado();

		Assert.assertTrue(resultadoInclusaoEspera.sucesso());
		Assert.assertTrue(esperaDtoAgendada.estaAguardando());
	}

	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_nao_conclui_espera_em_triagem_por_falta_de_autorizacao() throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoRLemeDtoValida());

		EsperaDTO esperaDto = ContextoEspera.construirEsperaDTO();
		esperaDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOftalmologia());
		esperaDto.setModuloDto(ContextoModulo.construirModuloDTOTriagemOftalmologia());
		esperaDto.setPreCadastroDto(null);
		esperaDto.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacao());

		EsperaDTO esperaDTOIncluida = (EsperaDTO) servicoSisLaraServerRmi
				.editarEspera(esperaDto, resultadoDto.getToken()).obterObjetoDtoEditado();

		ResultadoEdicaoEsperaDTO resultadoConlusaoEspera = servicoSisLaraServerRmi.concluirEspera(esperaDTOIncluida,
				resultadoDto.getToken());

		Assert.assertFalse(resultadoConlusaoEspera.sucesso());
		Assert.assertEquals(resultadoConlusaoEspera.obterMensagens(),
				"Somente a oftalmologia tem autoriza��o para concluir ou cancelar a triagem.\n\n");
	}
	
	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_nao_cancela_espera_em_triagem_por_falta_de_autorizacao() throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoRLemeDtoValida());

		EsperaDTO esperaDto = ContextoEspera.construirEsperaDTO();
		esperaDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOftalmologia());
		esperaDto.setModuloDto(ContextoModulo.construirModuloDTOTriagemOftalmologia());
		esperaDto.setPreCadastroDto(null);
		esperaDto.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacao());

		EsperaDTO esperaDTOIncluida = (EsperaDTO) servicoSisLaraServerRmi
				.editarEspera(esperaDto, resultadoDto.getToken()).obterObjetoDtoEditado();

		ResultadoEdicaoEsperaDTO resultadoConlusaoEspera = servicoSisLaraServerRmi.cancelarEspera(esperaDTOIncluida,
				resultadoDto.getToken());

		Assert.assertFalse(resultadoConlusaoEspera.sucesso());
		Assert.assertEquals(resultadoConlusaoEspera.obterMensagens(),
				"Somente a oftalmologia tem autoriza��o para concluir ou cancelar a triagem.\n\n");
	}
	
	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_associa_agendamento_atraves_de_espera() throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		TipoAtendimentoDTO tipoAtendimentoDto = new TipoAtendimentoDTO();
		tipoAtendimentoDto.setId(new Long(22222));
		DescricaoTipoAtendimentoDTO descricaoTipoAtendimentoDTO = new DescricaoTipoAtendimentoDTO();
		descricaoTipoAtendimentoDTO.setId(new Long(17));
		descricaoTipoAtendimentoDTO.setTipoAtendimentoDto(tipoAtendimentoDto);
		List<NomeGrupoDTO> nomesGruposDto = new ArrayList<>();
		nomesGruposDto.add(new NomeGrupoDTO(new Long(21), "G0"));
		descricaoTipoAtendimentoDTO.setNomesGruposDto(nomesGruposDto);
		ModuloDTO moduloDto = new ModuloDTO(new Long(1), "Info");
		
		ProfissionalDTO profissionalDTO = new ProfissionalDTO(new Long(5000), "Josep", "1234");

		EspecificacaoPesquisaAgendamentoDTO especificacaoPesquisaAgendamento = new EspecificacaoPesquisaAgendamentoDTO();
		especificacaoPesquisaAgendamento.setProfissionalDto(profissionalDTO);
		especificacaoPesquisaAgendamento.setDescricaoTipoAtendimentoDTO(descricaoTipoAtendimentoDTO);
		especificacaoPesquisaAgendamento.setModuloDTO(moduloDto);
		ResultadoListagemAgendamentoDTO resultadoAgendamento = servicoSisLaraServerRmi
				.obterListagemAgendamentoDisponiveis(especificacaoPesquisaAgendamento);
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultadoAgendamento.getObjetosDto(),
				new Long(99999));
		EspecificacaoPesquisaEsperaDTO especificacaoPesquisaEsperaDto = new EspecificacaoPesquisaEsperaDTO();
		especificacaoPesquisaEsperaDto.setDescricaoTipoAtendimentoDto(descricaoTipoAtendimentoDTO);
		especificacaoPesquisaEsperaDto.setModuloDto(moduloDto);
		especificacaoPesquisaEsperaDto.setInteresse(false);
		especificacaoPesquisaEsperaDto.setLmLigou(false);
		especificacaoPesquisaEsperaDto.setPendencias(false);
		ResultadoListagemEsperaDTO resultadoListagemEsperaDto = servicoSisLaraServerRmi
				.obterListagemEspera(especificacaoPesquisaEsperaDto);
		EsperaDTO esperaDto = (EsperaDTO) obterDaRelacaoPorId(resultadoListagemEsperaDto.getObjetosDto(),
				new Long(17777));

		EspecificacaoAssociacaoAgendamentoDTO especificacao = new EspecificacaoAssociacaoAgendamentoDTO();
		especificacao.setAgendamentoDto(agendamentoDto);
		especificacao.setEsperaDto(esperaDto);

		ResultadoEdicaoEsperaDTO resultado = servicoSisLaraServerRmi.editarEsperaEAssociarAgendamento(especificacao,
				resultadoDto.getToken());

		EsperaDTO espera = (EsperaDTO) resultado.obterObjetoDtoEditado();

		EspecificacaoPesquisaAgendamentoDTO especificacaoPesquisaAgendamentoAposAssociacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacaoPesquisaAgendamentoAposAssociacao
				.setProfissionalDto(profissionalDTO);
		especificacaoPesquisaAgendamentoAposAssociacao.setDescricaoTipoAtendimentoDTO(descricaoTipoAtendimentoDTO);
		especificacaoPesquisaAgendamentoAposAssociacao.setModuloDTO(moduloDto);
		ResultadoListagemAgendamentoDTO resultadoAgendamentoAposAssociacao = servicoSisLaraServerRmi
				.obterListagemAgendamentoDisponiveis(especificacaoPesquisaAgendamento);

		Assert.assertTrue(resultado.sucesso());
		Assert.assertEquals(espera.getStatusDto().toString(), StatusEspera.AGENDADO.toString());
		Assert.assertTrue(resultadoAgendamentoAposAssociacao.getObjetosDto().isEmpty());
	}
	
	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_nao_associa_agendamento_atraves_de_espera_com_usuario_de_setor_incompativel() throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		TipoAtendimentoDTO tipoAtendimentoDto = new TipoAtendimentoDTO();
		tipoAtendimentoDto.setId(new Long(22222));
		DescricaoTipoAtendimentoDTO descricaoTipoAtendimentoDTO = new DescricaoTipoAtendimentoDTO();
		descricaoTipoAtendimentoDTO.setId(new Long(12222));
		descricaoTipoAtendimentoDTO.setTipoAtendimentoDto(tipoAtendimentoDto);
		List<NomeGrupoDTO> nomesGruposDto = new ArrayList<>();
		nomesGruposDto.add(new NomeGrupoDTO(new Long(21), "G0"));
		descricaoTipoAtendimentoDTO.setNomesGruposDto(nomesGruposDto);
		ModuloDTO moduloDto = new ModuloDTO(new Long(2), "Info");

		EspecificacaoPesquisaAgendamentoDTO especificacaoPesquisaAgendamento = new EspecificacaoPesquisaAgendamentoDTO();
		especificacaoPesquisaAgendamento.setDataInicio("01/01/0001");
		especificacaoPesquisaAgendamento.setDataTermino("01/01/2999");
		ResultadoListagemAgendamentoDTO resultadoAgendamento = servicoSisLaraServerRmi
				.obterListagemAgendamentoDisponiveis(especificacaoPesquisaAgendamento);
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultadoAgendamento.getObjetosDto(),
				new Long(16666));
		EspecificacaoPesquisaEsperaDTO especificacaoPesquisaEsperaDto = new EspecificacaoPesquisaEsperaDTO();
		especificacaoPesquisaEsperaDto.setDescricaoTipoAtendimentoDto(descricaoTipoAtendimentoDTO);
		especificacaoPesquisaEsperaDto.setModuloDto(moduloDto);
		especificacaoPesquisaEsperaDto.setInteresse(false);
		especificacaoPesquisaEsperaDto.setLmLigou(false);
		especificacaoPesquisaEsperaDto.setPendencias(false);
		ResultadoListagemEsperaDTO resultadoListagemEsperaDto = servicoSisLaraServerRmi
				.obterListagemEspera(especificacaoPesquisaEsperaDto);
		EsperaDTO esperaDto = (EsperaDTO) obterDaRelacaoPorId(resultadoListagemEsperaDto.getObjetosDto(),
				new Long(13333));

		EspecificacaoAssociacaoAgendamentoDTO especificacao = new EspecificacaoAssociacaoAgendamentoDTO();
		especificacao.setAgendamentoDto(agendamentoDto);
		especificacao.setEsperaDto(esperaDto);

		ResultadoEdicaoEsperaDTO resultado = servicoSisLaraServerRmi.editarEsperaEAssociarAgendamento(especificacao,
				resultadoDto.getToken());

		Assert.assertFalse(resultado.sucesso());
		Assert.assertTrue(resultado.obterMensagens().contains("N�o � poss�vel agendar um usu�rio de setor incompat�vel com o solicitado pelo agendamento."));
	}
	
	@Test(groups = { TiposDeTeste.PENDENCIA })
	public void servico_resolve_pendencia_de_atendimento_invidual_de_servico_social_com_pre_cadastro_apos_geracao_de_atendimento_com_pre_cadastro_contendo_prontuario_associado()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemPendenciaDTO pendenciasAntesResolucaoDto = servico_resolve_pendencia_de_atendimento_invidual_de_servico_social_com_pre_cadastro_apos_geracao_de_atendimento_com_pre_cadastro(
				resultadoDto, ContextoPreCadastro.construirPreCadastroDTO());

		Registro.obterAutomatizadorPendencia().atualizarPendencias();

		ResultadoListagemPendenciaDTO pendenciasAposResolucaoDto = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		Assert.assertEquals(pendenciasAntesResolucaoDto.getObjetosDto().size(), 1);
		Assert.assertEquals(pendenciasAposResolucaoDto.getObjetosDto().size(), 0);
	}

	@Test(groups = { TiposDeTeste.PENDENCIA })
	public void servico_resolve_pendencia_de_atendimento_invidual_de_servico_social_com_pre_cadastro_apos_geracao_de_atendimento_com_pre_cadastro_sem_conter_prontuario_associado()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemPendenciaDTO pendenciasAntesResolucaoDto = servico_resolve_pendencia_de_atendimento_invidual_de_servico_social_com_pre_cadastro_apos_geracao_de_atendimento_com_pre_cadastro(
				resultadoDto, ContextoPreCadastro.construirPreCadastroDTOAlternativo());

		Registro.obterAutomatizadorPendencia().atualizarPendencias();

		ResultadoListagemPendenciaDTO pendenciasAposResolucaoDto = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		Assert.assertEquals(pendenciasAntesResolucaoDto.getObjetosDto().size(), 1);
		Assert.assertEquals(pendenciasAposResolucaoDto.getObjetosDto().size(), 0);
	}

	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_associa_agendamento_atraves_de_espera_e_inclui_pendencia_de_atendimento_individual_com_pre_cadastro()
			throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		
		MaquinaTempo.mudarDataAtual("02/03/2018");
		
		EsperaDTO esperaDto = ContextoEspera.construirEsperaDTO();
		esperaDto.setPreCadastroDto(ContextoPreCadastro.construirPreCadastroDTO());
		esperaDto.setUsuarioDto(null);

		ResultadoEdicaoEsperaDTO resultadoInclusaoEspera = servicoSisLaraServerRmi.editarEspera(esperaDto,
				resultadoDto.getToken());

		EsperaDTO esperaDTOIncluida = (EsperaDTO) resultadoInclusaoEspera.obterObjetoDtoEditado();

		EspecificacaoGeracaoAgendamentoDTO especificacaoGeracaoAgendamentoDTO = ContextoEspecificacaoGeracaoAgendamento
				.fabricarAgendamentoUnicoComTodosOsDados();
		especificacaoGeracaoAgendamentoDTO
				.setDescricaoTipoAtendimentoDto(esperaDTOIncluida.getDescricaoTipoAtendimentoDto());
		especificacaoGeracaoAgendamentoDTO.setModuloDto(esperaDTOIncluida.getModuloDto());
		especificacaoGeracaoAgendamentoDTO.setDataInicio(DataHoraUtils.formatarData(MaquinaTempo.obterInstancia().obterCalendarioAtual()));
		especificacaoGeracaoAgendamentoDTO.setUsuarioDto(null);

		ResultadoGeracaoAgendamentoDTO resultadoGeracaoAgendamento = servicoSisLaraServerRmi
				.gerarAgendamento(especificacaoGeracaoAgendamentoDTO, resultadoDto.getToken());

		EspecificacaoAssociacaoAgendamentoDTO especificacao = new EspecificacaoAssociacaoAgendamentoDTO();
		especificacao.setAgendamentoDto(resultadoGeracaoAgendamento.getObjetosDto().get(0));
		especificacao.setEsperaDto(esperaDTOIncluida);

		ResultadoEdicaoEsperaDTO resultado = servicoSisLaraServerRmi.editarEsperaEAssociarAgendamento(especificacao,
				resultadoDto.getToken());

		ResultadoListagemPendenciaDTO pendenciasDto = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());
		
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertTrue(resultado.sucesso());
		Assert.assertEquals(pendenciasDto.getObjetosDto().size(), 1);
		Assert.assertTrue(contem(pendenciasDto.getObjetosDto(),
				"Atendimento individual do pr�-cadastro Josep Meaza, Data: 02/03/2018, Tipo: Atendimento Educacional Especializado, Descri��o: Curso de Informatica Avancado, M�dulo: Atendimento Especifico Especializado"));
	}
	
	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_associa_agendamento_atraves_de_espera_e_inclui_pendencia_de_atendimento_individual_com_usuario()
			throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		MaquinaTempo.mudarDataAtual("02/03/2018");
		
		criar_espera_e_agendamento_e_efetuar_associacao_entre_os_dois(resultadoDto);
		
		ResultadoListagemPendenciaDTO pendenciasDto = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());
		
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertEquals(pendenciasDto.getObjetosDto().size(), 1);
		Assert.assertTrue(contem(pendenciasDto.getObjetosDto(),
				"Atendimento individual do Prontu�rio 12222, Data: 02/03/2018, Tipo: Atendimento Educacional Especializado, Descri��o: Curso de Informatica Avancado, M�dulo: Atendimento Especifico Especializado"));
	}

	@Test(groups = { TiposDeTeste.PENDENCIA })
	public void servico_associa_agendamento_servico_social_e_inclui_pendencia_de_atendimento_individual_com_pre_cadastro()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);

		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(18888));
		agendamentoDto.setPreCadastroDto(ContextoPreCadastro.construirPreCadastroDTO());
		agendamentoDto.setData(DataHoraUtils.formatarData(MaquinaTempo.obterInstancia().obterCalendarioAtual()));

		ResultadoEdicaoAgendamentoDTO resultadoEdicaoAgendamentoDto = servicoSisLaraServerRmi
				.editarAgendamento(agendamentoDto, resultadoDto.getToken());

		ResultadoListagemPendenciaDTO pendenciasDto = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoDto.getToken());

		Assert.assertTrue(resultadoEdicaoAgendamentoDto.sucesso());
		Assert.assertEquals(pendenciasDto.getObjetosDto().size(), 1);
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_associa_agendamento_servico_social_avaliacao_e_triagem_atraves_de_espera_com_excesso_de_faltas()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		UsuarioDTO usuarioDTO = ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoA();

		EspecificacaoPesquisaAgendamentoDTO especificacaoAgendamento = new EspecificacaoPesquisaAgendamentoDTO();
		especificacaoAgendamento.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi
				.obterListagemAgendamento(especificacaoAgendamento);
		// Ref. id 18888
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(18888));
		agendamentoDto.setUsuarioDto(usuarioDTO);

		servico_cria_tres_atendimentos_individuais_com_frequencia_fu_em_dias_diferentes(resultadoDto,
				usuarioDTO.getId());

		EspecificacaoPesquisaEsperaDTO especificacaoPesquisaEsperaDto = new EspecificacaoPesquisaEsperaDTO();
		especificacaoPesquisaEsperaDto.setProntuario(usuarioDTO.getId().toString());
		especificacaoPesquisaEsperaDto.setInteresse(false);
		especificacaoPesquisaEsperaDto.setLmLigou(false);
		especificacaoPesquisaEsperaDto.setPendencias(false);
		ResultadoListagemEsperaDTO resultadoListagemEsperaDto = servicoSisLaraServerRmi
				.obterListagemEspera(especificacaoPesquisaEsperaDto);
		EsperaDTO esperaDto = (EsperaDTO) obterDaRelacaoPorId(resultadoListagemEsperaDto.getObjetosDto(),
				new Long(17777));

		EspecificacaoAssociacaoAgendamentoDTO especificacao = new EspecificacaoAssociacaoAgendamentoDTO();
		especificacao.setAgendamentoDto(agendamentoDto);
		especificacao.setEsperaDto(esperaDto);

		ResultadoEdicaoEsperaDTO resultadoEdicaoEspera = servicoSisLaraServerRmi
				.editarEsperaEAssociarAgendamento(especificacao, resultadoDto.getToken());

		Assert.assertTrue(resultadoEdicaoEspera.sucesso());
	}

	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_nao_associa_agendamento_a_espera_ja_agendada() throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		TipoAtendimentoDTO tipoAtendimentoDto = new TipoAtendimentoDTO();
		tipoAtendimentoDto.setId(new Long(22222));
		DescricaoTipoAtendimentoDTO descricaoTipoAtendimentoDTO = new DescricaoTipoAtendimentoDTO();
		descricaoTipoAtendimentoDTO.setId(new Long(17));
		descricaoTipoAtendimentoDTO.setTipoAtendimentoDto(tipoAtendimentoDto);
		List<NomeGrupoDTO> nomesGruposDto = new ArrayList<>();
		nomesGruposDto.add(new NomeGrupoDTO(new Long(21), "G0"));
		descricaoTipoAtendimentoDTO.setNomesGruposDto(nomesGruposDto);
		ModuloDTO moduloDto = new ModuloDTO(new Long(1), "Info");

		EspecificacaoPesquisaAgendamentoDTO especificacaoPesquisaAgendamento = new EspecificacaoPesquisaAgendamentoDTO();
		especificacaoPesquisaAgendamento.setProfissionalDto(new ProfissionalDTO(new Long(5000), "Josep", "1234"));
		especificacaoPesquisaAgendamento.setDescricaoTipoAtendimentoDTO(descricaoTipoAtendimentoDTO);
		especificacaoPesquisaAgendamento.setModuloDTO(moduloDto);
		ResultadoListagemAgendamentoDTO resultadoAgendamento = servicoSisLaraServerRmi
				.obterListagemAgendamentoDisponiveis(especificacaoPesquisaAgendamento);
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultadoAgendamento.getObjetosDto(),
				new Long(99999));

		EspecificacaoPesquisaEsperaDTO especificacaoPesquisaEsperaDto = new EspecificacaoPesquisaEsperaDTO();
		especificacaoPesquisaEsperaDto.setDescricaoTipoAtendimentoDto(descricaoTipoAtendimentoDTO);
		especificacaoPesquisaEsperaDto.setModuloDto(moduloDto);
		especificacaoPesquisaEsperaDto.setInteresse(false);
		especificacaoPesquisaEsperaDto.setLmLigou(false);
		especificacaoPesquisaEsperaDto.setPendencias(false);

		ResultadoListagemEsperaDTO resultadoListagemEsperaDto = servicoSisLaraServerRmi
				.obterListagemEspera(especificacaoPesquisaEsperaDto);
		EsperaDTO esperaDto = (EsperaDTO) obterDaRelacaoPorId(resultadoListagemEsperaDto.getObjetosDto(),
				new Long(17777));

		EspecificacaoAssociacaoAgendamentoDTO especificacao = new EspecificacaoAssociacaoAgendamentoDTO();
		especificacao.setAgendamentoDto(agendamentoDto);
		especificacao.setEsperaDto(esperaDto);

		servicoSisLaraServerRmi.editarEsperaEAssociarAgendamento(especificacao, resultadoDto.getToken());

		ResultadoEdicaoEsperaDTO resultadoComErro = servicoSisLaraServerRmi
				.editarEsperaEAssociarAgendamento(especificacao, resultadoDto.getToken());
		Assert.assertFalse(resultadoComErro.sucesso());
		Assert.assertEquals(resultadoComErro.obterMensagens(),
				"A Espera j� foi agendada ou o M�dulo / Atividade est� bloqueado.\n");
	}
	
	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_nao_associa_agendamento_a_partir_de_espera_com_mesma_informacao_essencial_de_agendamento_ja_existente() throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		TipoAtendimentoDTO tipoAtendimentoDto = new TipoAtendimentoDTO();
		tipoAtendimentoDto.setId(new Long(22222));
		DescricaoTipoAtendimentoDTO descricaoTipoAtendimentoDTO = new DescricaoTipoAtendimentoDTO();
		descricaoTipoAtendimentoDTO.setId(new Long(17));
		descricaoTipoAtendimentoDTO.setTipoAtendimentoDto(tipoAtendimentoDto);
		List<NomeGrupoDTO> nomesGruposDto = new ArrayList<>();
		nomesGruposDto.add(new NomeGrupoDTO(new Long(21), "G0"));
		descricaoTipoAtendimentoDTO.setNomesGruposDto(nomesGruposDto);
		ModuloDTO moduloDto = new ModuloDTO(new Long(1), "Info");

		EspecificacaoPesquisaAgendamentoDTO especificacaoPesquisaAgendamento = new EspecificacaoPesquisaAgendamentoDTO();
		especificacaoPesquisaAgendamento.setProfissionalDto(new ProfissionalDTO(new Long(5000), "Josep", "1234"));
		especificacaoPesquisaAgendamento.setDescricaoTipoAtendimentoDTO(descricaoTipoAtendimentoDTO);
		especificacaoPesquisaAgendamento.setModuloDTO(moduloDto);
		ResultadoListagemAgendamentoDTO resultadoAgendamento = servicoSisLaraServerRmi
				.obterListagemAgendamentoDisponiveis(especificacaoPesquisaAgendamento);
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultadoAgendamento.getObjetosDto(),
				new Long(99999));

		EspecificacaoPesquisaEsperaDTO especificacaoPesquisaEsperaDto = new EspecificacaoPesquisaEsperaDTO();
		especificacaoPesquisaEsperaDto.setDescricaoTipoAtendimentoDto(descricaoTipoAtendimentoDTO);
		especificacaoPesquisaEsperaDto.setModuloDto(moduloDto);
		especificacaoPesquisaEsperaDto.setInteresse(false);
		especificacaoPesquisaEsperaDto.setLmLigou(false);
		especificacaoPesquisaEsperaDto.setPendencias(false);

		ResultadoListagemEsperaDTO resultadoListagemEsperaDto = servicoSisLaraServerRmi
				.obterListagemEspera(especificacaoPesquisaEsperaDto);
		EsperaDTO esperaDto = (EsperaDTO) obterDaRelacaoPorId(resultadoListagemEsperaDto.getObjetosDto(),
				new Long(18888));

		EspecificacaoAssociacaoAgendamentoDTO especificacao = new EspecificacaoAssociacaoAgendamentoDTO();
		especificacao.setAgendamentoDto(agendamentoDto);
		especificacao.setEsperaDto(esperaDto);

		servicoSisLaraServerRmi.editarEsperaEAssociarAgendamento(especificacao, resultadoDto.getToken());

		ResultadoEdicaoEsperaDTO resultadoComErro = servicoSisLaraServerRmi
				.editarEsperaEAssociarAgendamento(especificacao, resultadoDto.getToken());
		Assert.assertFalse(resultadoComErro.sucesso());
		Assert.assertTrue(resultadoComErro.obterMensagens().contains("O Usu�rio/Pr�-cadastro j� est� agendado."));
	}

	@Test(groups = {TiposDeTeste.ESPERA})
	public void servico_nao_associa_agendamento_a_espera_com_usuario_bloqueado_por_excesso_de_falta()
			throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		TipoAtendimentoDTO tipoAtendimentoDto = new TipoAtendimentoDTO();
		tipoAtendimentoDto.setId(new Long(22222));
		DescricaoTipoAtendimentoDTO descricaoTipoAtendimentoDTO = new DescricaoTipoAtendimentoDTO();
		descricaoTipoAtendimentoDTO.setId(new Long(12222));
		descricaoTipoAtendimentoDTO.setTipoAtendimentoDto(tipoAtendimentoDto);
		List<NomeGrupoDTO> nomesGruposDto = new ArrayList<>();
		nomesGruposDto.add(new NomeGrupoDTO(new Long(21), "G0"));
		descricaoTipoAtendimentoDTO.setNomesGruposDto(nomesGruposDto);
		ModuloDTO moduloDto = new ModuloDTO(new Long(2), "Info");

		EspecificacaoPesquisaAgendamentoDTO especificacaoPesquisaAgendamento = new EspecificacaoPesquisaAgendamentoDTO();
		especificacaoPesquisaAgendamento.setProfissionalDto(new ProfissionalDTO(new Long(2000), "Josep", "1234"));
		especificacaoPesquisaAgendamento.setDescricaoTipoAtendimentoDTO(descricaoTipoAtendimentoDTO);

		especificacaoPesquisaAgendamento.setModuloDTO(moduloDto);
		ResultadoListagemAgendamentoDTO resultadoAgendamento = servicoSisLaraServerRmi
				.obterListagemAgendamentoDisponiveis(especificacaoPesquisaAgendamento);
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultadoAgendamento.getObjetosDto(),
				new Long(15555));

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setId(null);
		atendimentoIndividualDto.setUsuarioDto(agendamentoDto.getUsuarioDto());
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("12:00", "13:00"));
		atendimentoIndividualDto.getInformacaoAtendimentoDto().setFrequenciaDto(new FrequenciaDTO("FU"));
		atendimentoIndividualDto.getInformacaoAtendimentoDto().setParticipadaoDetalhadaDto(Arrays.asList());
		for (int i = 1; i <= 3; i++) {
			atendimentoIndividualDto.setData("0" + i + "/03/2015");
			servicoSisLaraServerRmi.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());
		}

		EspecificacaoPesquisaEsperaDTO especificacaoPesquisaEsperaDto = new EspecificacaoPesquisaEsperaDTO();
		especificacaoPesquisaEsperaDto.setDescricaoTipoAtendimentoDto(descricaoTipoAtendimentoDTO);
		especificacaoPesquisaEsperaDto.setModuloDto(moduloDto);
		especificacaoPesquisaEsperaDto.setInteresse(false);
		especificacaoPesquisaEsperaDto.setLmLigou(false);
		especificacaoPesquisaEsperaDto.setPendencias(false);

		ResultadoListagemEsperaDTO resultadoListagemEsperaDto = servicoSisLaraServerRmi
				.obterListagemEspera(especificacaoPesquisaEsperaDto);
		EsperaDTO esperaDto = (EsperaDTO) obterDaRelacaoPorId(resultadoListagemEsperaDto.getObjetosDto(),
				new Long(13333));

		EspecificacaoAssociacaoAgendamentoDTO especificacao = new EspecificacaoAssociacaoAgendamentoDTO();
		especificacao.setAgendamentoDto(agendamentoDto);
		especificacao.setEsperaDto(esperaDto);

		ResultadoEdicaoEsperaDTO resultadoComErro = servicoSisLaraServerRmi
				.editarEsperaEAssociarAgendamento(especificacao, resultadoDto.getToken());
		Assert.assertFalse(resultadoComErro.sucesso());
		Assert.assertEquals(resultadoComErro.obterMensagens(),
				"O Usu�rio est� bloqueado por excesso de faltas n�o justificadas.\n");
	}

	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_nao_associa_agendamento_atraves_de_espera_sem_permissao() throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());
		EspecificacaoAssociacaoAgendamentoDTO especificacao = new EspecificacaoAssociacaoAgendamentoDTO();

		ResultadoEdicaoEsperaDTO resultado = servicoSisLaraServerRmi.editarEsperaEAssociarAgendamento(especificacao,
				resultadoDto.getToken());

		Assert.assertFalse(resultado.sucesso());
		Assert.assertFalse(resultado.obterMensagens().isEmpty());
	}

	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_nao_efetua_cancelamento_por_falta_de_justificativa_invalida() throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaEsperaDTO especificacao = new EspecificacaoPesquisaEsperaDTO();
		especificacao.setTipoEsperaDto(new TipoEsperaDTO(TipoEspera.RET.toString()));
		especificacao.setInteresse(false);
		especificacao.setLmLigou(false);
		especificacao.setPendencias(false);

		ResultadoListagemEsperaDTO resultado = servicoSisLaraServerRmi.obterListagemEspera(especificacao);

		EsperaDTO espera = (EsperaDTO) obterDaRelacaoPorId(resultado.getObjetosDto(), new Long(13333));
		espera.setJustificativaCancelamento(ContextoGenerico.obterGrande());

		ResultadoEdicaoEsperaDTO resultadoInclusaoEspera = servicoSisLaraServerRmi.cancelarEspera(espera,
				resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoEspera.sucesso());
		Assert.assertEquals(resultadoInclusaoEspera.obterMensagens(),
				"Insira uma Justificativa de Cancelamento contendo at� 20000 caracteres.\n\n");
	}

	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_inclui_atendimento_individual_de_pre_cadastro_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		String conteudoArquivo = "Conte�do do arquivo.";

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosPreCadastro();
		atendimentoIndividualDto.setPrimeiraVezOuRetornoDto(new StatusDTO("PRIMEIRA_VEZ"));
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("12:00", "13:00"));
		ArquivoDTO arquivoDTO = new ArquivoDTO(null, "Teste.pdf", conteudoArquivo.getBytes(), null);
		atendimentoIndividualDto.setArquivos(Arrays.asList(arquivoDTO));

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		AtendimentoIndividualDTO atendimentoIndividualSalvoDTO = (AtendimentoIndividualDTO) resultadoEdicaoAtendimentoIndividualDto
				.obterObjetoDtoEditado();
		ArquivoDTO arquivoDtoSalvo = servicoSisLaraServerRmi.obterArquivoAtendimentoIndividualDTO(
				atendimentoIndividualSalvoDTO, atendimentoIndividualSalvoDTO.getArquivos().get(0));
		ArquivoDTO arquivoDisponivelDto = servicoSisLaraServerRmi.obterArquivoDisponivelDTO(
				atendimentoIndividualSalvoDTO.getId().toString(), "Teste.pdf",
				TipoArquivoDisponivel.INDIVIDUAL.toString());
		ResultadoListagemArquivoDisponivelDTO resultadoListagemArquivoDisponivelDto = servicoSisLaraServerRmi
				.obterListagemArquivoDisponivelDTO(atendimentoIndividualSalvoDTO.getUsuarioDto().getId().toString(),
						false);

		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertEquals(arquivoDtoSalvo.obterConteudo(), arquivoDTO.obterConteudo());
		Assert.assertEquals(arquivoDisponivelDto.obterConteudo(), arquivoDTO.obterConteudo());
		Assert.assertEquals(resultadoListagemArquivoDisponivelDto.getObjetosDto().size(), 1);
	}

	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_inclui_atendimento_individual_de_usuario_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("12:00", "13:00"));

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.sucesso());
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_inclui_atendimento_individual_de_usuario_com_frequencia_FU_removendo_participacao_detalhada() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("12:00", "13:00"));
		atendimentoIndividualDto.getInformacaoAtendimentoDto().setFrequenciaDto(new FrequenciaDTO(Frequencia.FU.toString()));
		
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());
		
		AtendimentoIndividualDTO atendimentoIndividualDTOApos = (AtendimentoIndividualDTO) resultadoEdicaoAtendimentoIndividualDto.obterObjetoDtoEditado();

		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertFalse(
				atendimentoIndividualDto.getInformacaoAtendimentoDto().getParticipacaoDetalhadaDto().isEmpty());
		Assert.assertTrue(
				atendimentoIndividualDTOApos.getInformacaoAtendimentoDto().getParticipacaoDetalhadaDto().isEmpty());
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_inclui_atendimento_individual_de_avaliacao_funcional_com_usuario_primeira_vez_sem_documento_de_AVFUN() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoAvaliacaoFuncionalDTO());
		atendimentoIndividualDto.setModuloDto(ContextoModulo.construirModuloAEE());
		atendimentoIndividualDto.setPrimeiraVezOuRetornoDto(new StatusDTO(Status.PRIMEIRA_VEZ.toString()));
		
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.obterMensagens()
				.contains("Insira o relat�rio de AVFUN nos arquivos."));
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_inclui_atendimento_individual_de_avaliacao_funcional_com_usuario_primeira_vez_sem_documento_de_AVFUN_com_relatorio_nao_confeccionado_sem_motivo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoAvaliacaoFuncionalDTO());
		atendimentoIndividualDto.setModuloDto(ContextoModulo.construirModuloAEE());
		atendimentoIndividualDto.setPrimeiraVezOuRetornoDto(new StatusDTO(Status.PRIMEIRA_VEZ.toString()));
		atendimentoIndividualDto.setRelatorioAvfunNaoConfeccionado(true);
		
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.obterMensagens()
				.contains("Insira o motivo da n�o confec��o do relat�rio de AVFUN."));
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_inclui_atendimento_individual_de_avaliacao_funcional_de_retorno_que_nao_recebeu_atendimento_de_avaliacao_funcional_nos_ultimos_6_meses_sem_documento_de_AVFUN() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoAvaliacaoFuncionalDTO());
		atendimentoIndividualDto.setModuloDto(ContextoModulo.construirModuloAEE());
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("14:00", "15:00"));
		atendimentoIndividualDto.setPrimeiraVezOuRetornoDto(new StatusDTO(Status.RETORNO.toString()));
		
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.obterMensagens()
				.contains("Insira o relat�rio de AVFUN nos arquivos."));
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_inclui_atendimento_individual_de_avaliacao_funcional_com_usuario_retorno_que_recebeu_atendimento_de_avaliacao_funcional_nos_ultimos_6_meses_sem_documento_de_AVFUN() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		UsuarioDTO usuarioDto = ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoB();
		atendimentoIndividualDto.setUsuarioDto(usuarioDto);
		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoAvaliacaoFuncionalDTO());
		atendimentoIndividualDto.setModuloDto(ContextoModulo.construirModuloAEE());
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("14:00", "15:00"));
		atendimentoIndividualDto.setPrimeiraVezOuRetornoDto(new StatusDTO(Status.RETORNO.toString()));
		atendimentoIndividualDto.setData("31/12/2015");
		
		MaquinaTempo.mudarDataAtual("01/01/2016");
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.sucesso());
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_inclui_atendimento_individual_incompativel_com_acao_de_conduta_de_integracao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		
		AcaoCondutaDTO acaoCondutaDTOA = ContextoAcaoConduta.fabricarAcoesCondutaDto();
		GrupoDTO grupoADto = new FabricaGrupo()
				.converterParaDTO(Registro.obterRepositorioGrupo().obterGrupoPorId(new Long(14444)));
		acaoCondutaDTOA.setGrupoDto(grupoADto);
		
		AcaoCondutaDTO acaoCondutaDTOB = ContextoAcaoConduta.fabricarAcoesCondutaDto();
		GrupoDTO grupoBDto = new FabricaGrupo()
				.converterParaDTO(Registro.obterRepositorioGrupo().obterGrupoPorId(new Long(11555)));
		acaoCondutaDTOB.setGrupoDto(grupoBDto);
		
		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuarioAlternativo();
		
		UsuarioDTO usuarioDTO = ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoA();
		atendimentoIndividualDto.setUsuarioDto(usuarioDTO);
		atendimentoIndividualDto.setAcoesDeCondutasDto(Arrays.asList(acaoCondutaDTOA, acaoCondutaDTOB));
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("12:00", "13:00"));

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.obterMensagens()
				.contains("N�o � poss�vel incluir condutas em atendimento diferente de Avalia��o Funcional."));
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_inclui_atendimento_individual_com_frequencia_FU_e_integracao_e_discussao_de_caso_na_acao_de_conduta_de_integracao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		
		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuarioAlternativo();
		
		UsuarioDTO usuarioDTO = ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoA();
		atendimentoIndividualDto.setUsuarioDto(usuarioDTO);
		atendimentoIndividualDto.setAcoesDeCondutasDto(Arrays.asList());
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("12:00", "13:00"));
		atendimentoIndividualDto.getInformacaoAtendimentoDto()
				.setFrequenciaDto(new FrequenciaDTO(Frequencia.FU.toString()));
		atendimentoIndividualDto.getDescricaoTipoAtendimentoDto().setId(new Long(17));
		atendimentoIndividualDto.setOpcaoIntegracaoDto(new OpcaoIntegracaoDTO(OpcaoIntegracao.INTEGRACAO.toString()));
		atendimentoIndividualDto.setDiscussaoCasoSimNaoDto(new SimNaoDTO(SimNao.SIM.toString()));

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.obterMensagens()
				.contains("N�o � poss�vel incluir um posicionamento de integra��o ou triagem em atendimentos com frequ�ncia diferente de AT."));
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_inclui_atendimento_individual_de_avaliacao_funcional_com_frequencia_FU_sem_integracao_e_discussao_de_caso_com_acao_de_conduta_de_retorno()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());
		
		AcaoCondutaDTO acaoCondutaDTOA = ContextoAcaoConduta.fabricarAcoesCondutaDto();
		acaoCondutaDTOA.setTipoAcaoCondutaDto(new TipoAcaoCondutaDTO(TipoAcaoConduta.RETORNAR.toString()));
		acaoCondutaDTOA.setSetorDto(new SetorDTO(Setor.CTO.toString()));
		acaoCondutaDTOA.setDataExpectativa("01/01/2000");
		acaoCondutaDTOA.setObs("TExto de obs.");
		acaoCondutaDTOA.setGrupoDto(null);
		
		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuarioAlternativo();
		
		UsuarioDTO usuarioDTO = ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoA();
		atendimentoIndividualDto.setUsuarioDto(usuarioDTO);
		atendimentoIndividualDto.setAcoesDeCondutasDto(Arrays.asList(acaoCondutaDTOA));
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("12:00", "13:00"));
		atendimentoIndividualDto.getInformacaoAtendimentoDto()
				.setFrequenciaDto(new FrequenciaDTO(Frequencia.FU.toString()));
		atendimentoIndividualDto.getInformacaoAtendimentoDto().setParticipadaoDetalhadaDto(Arrays.asList());
		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(ContextoDescricaoTipoAtendimento.construirDescricaoAvaliacaoFuncionalDTO());
		atendimentoIndividualDto.setOpcaoIntegracaoDto(null);
		atendimentoIndividualDto.setDiscussaoCasoSimNaoDto(null);

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.sucesso());
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_inclui_atendimento_individual_com_acao_de_conduta_de_integracao_com_sucesso()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO listagemGrupoGDtoAntesAcaoCondutaIntegracao = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("G08-1");
		ModuloPeriodoDTO moduloPeriodoAEEGDtoAntesAcaoCondutaIntegracao = obterModuloPeriodoDto(
				listagemGrupoGDtoAntesAcaoCondutaIntegracao.getObjetosDto(), new Long(15555), new Long(12345));
		
		ResultadoListagemGrupoDTO listagemGrupoBRDtoAntesAcaoCondutaIntegracao = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("BR-2");
		ModuloPeriodoDTO moduloPeriodoAEEBRDtoAntesAcaoCondutaIntegracao = obterModuloPeriodoDto(
				listagemGrupoBRDtoAntesAcaoCondutaIntegracao.getObjetosDto(), new Long(112233), new Long(112233));
		
		AcaoCondutaDTO acaoCondutaDTOA = ContextoAcaoConduta.fabricarAcoesCondutaDto();
		GrupoDTO grupoADto = new FabricaGrupo()
				.converterParaDTO(Registro.obterRepositorioGrupo().obterGrupoPorId(new Long(15555)));
		acaoCondutaDTOA.setGrupoDto(grupoADto);
		
		AcaoCondutaDTO acaoCondutaDTOB = ContextoAcaoConduta.fabricarAcoesCondutaDto();
		GrupoDTO grupoBDto = new FabricaGrupo()
				.converterParaDTO(Registro.obterRepositorioGrupo().obterGrupoPorId(new Long(112233)));
		acaoCondutaDTOB.setGrupoDto(grupoBDto);
		
		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuarioAlternativo();
		atendimentoIndividualDto.getDescricaoTipoAtendimentoDto().setId(new Long(17));
		AcaoCondutaDTO acaoCondutaDTO = ContextoAcaoConduta.fabricarAcoesCondutaDto();
		acaoCondutaDTO.setId(null);
		atendimentoIndividualDto.setAcoesDeCondutasDto(Arrays.asList(acaoCondutaDTO));
		atendimentoIndividualDto.setArquivos(ContextoArquivo.obterArquivoDtoDocumentoAVFUN());
		
		UsuarioDTO usuarioDTO = ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoB();
		usuarioDTO.setId(new Long(17777));
		atendimentoIndividualDto.setUsuarioDto(usuarioDTO);
		atendimentoIndividualDto.setAcoesDeCondutasDto(Arrays.asList(acaoCondutaDTOA, acaoCondutaDTOB));
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("12:00", "13:00"));

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Registro.obterAutomatizadorTarefas().executar();
		Registro.obterAutomatizadorTarefas().executar();

		ResultadoListagemGrupoDTO listagemGrupoGDtoAposAcaoCondutaIntegracao = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("G08-1");
		ModuloPeriodoDTO moduloPeriodoAEEGDtoAposAcaoCondutaIntegracao = obterModuloPeriodoDto(
				listagemGrupoGDtoAposAcaoCondutaIntegracao.getObjetosDto(), new Long(15555), new Long(12345));
		ModuloUsuarioDTO moduloUsuarioGDTOAposAcaoCondutaIntegracao = obterPeloIdUsuario(
				moduloPeriodoAEEGDtoAposAcaoCondutaIntegracao, usuarioDTO);
		
		ResultadoListagemGrupoDTO listagemGrupoBRDtoAposAcaoCondutaIntegracao = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("BR-2");
		ModuloPeriodoDTO moduloPeriodoAEEBRDtoAposAcaoCondutaIntegracao = obterModuloPeriodoDto(
				listagemGrupoBRDtoAposAcaoCondutaIntegracao.getObjetosDto(), new Long(112233), new Long(112233));
		ModuloUsuarioDTO moduloUsuarioBRDTOAposAcaoCondutaIntegracao = obterPeloIdUsuario(
				moduloPeriodoAEEBRDtoAposAcaoCondutaIntegracao, usuarioDTO);
		
		AcaoCondutaDTO acaoCondutaDTOApos = obterAcaoCondutaDTO(atendimentoIndividualDto.getUsuarioDto(), atendimentoIndividualDto.getData());

		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertTrue(moduloUsuarioGDTOAposAcaoCondutaIntegracao.getStatusDto().toString()
				.equals(StatusRelacaoComModulo.PROVISORIO.toString()));
		Assert.assertTrue(moduloUsuarioBRDTOAposAcaoCondutaIntegracao.getStatusDto().toString()
				.equals(StatusRelacaoComModulo.PROVISORIO.toString()));
		Assert.assertTrue(
				moduloUsuarioGDTOAposAcaoCondutaIntegracao.getObs().equals("Inserido automaticamente pela conduta de integra��o."));
		Assert.assertTrue(
				moduloUsuarioBRDTOAposAcaoCondutaIntegracao.getObs().equals("Inserido automaticamente pela conduta de integra��o."));
		Assert.assertTrue(moduloPeriodoAEEGDtoAntesAcaoCondutaIntegracao.getModulosUsuariosDto().size() == 1);
		Assert.assertTrue(moduloPeriodoAEEBRDtoAntesAcaoCondutaIntegracao.getModulosUsuariosDto().size() == 2);
		Assert.assertTrue(moduloPeriodoAEEGDtoAposAcaoCondutaIntegracao.getModulosUsuariosDto().size() == 2);
		Assert.assertTrue(moduloPeriodoAEEBRDtoAposAcaoCondutaIntegracao.getModulosUsuariosDto().size() == 3);
		Assert.assertTrue(acaoCondutaDTOApos.getResultadoProcessamento().contains("Dados armazenados com sucesso."));
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_edita_atendimento_individual_com_frequencia_FU_contendo_acao_de_conduta_de_integracao_ja_processada()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AcaoCondutaDTO acaoCondutaDTOA = ContextoAcaoConduta.fabricarAcoesCondutaDto();
		GrupoDTO grupoADto = new FabricaGrupo()
				.converterParaDTO(Registro.obterRepositorioGrupo().obterGrupoPorId(new Long(14444)));
		acaoCondutaDTOA.setGrupoDto(grupoADto);

		AcaoCondutaDTO acaoCondutaDTOB = ContextoAcaoConduta.fabricarAcoesCondutaDto();
		GrupoDTO grupoBDto = new FabricaGrupo()
				.converterParaDTO(Registro.obterRepositorioGrupo().obterGrupoPorId(new Long(11555)));
		acaoCondutaDTOB.setGrupoDto(grupoBDto);

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuarioAlternativo();
		atendimentoIndividualDto.getDescricaoTipoAtendimentoDto().setId(new Long(17));
		AcaoCondutaDTO acaoCondutaDTO = ContextoAcaoConduta.fabricarAcoesCondutaDto();
		acaoCondutaDTO.setId(null);
		atendimentoIndividualDto.setAcoesDeCondutasDto(Arrays.asList(acaoCondutaDTO));

		UsuarioDTO usuarioDTO = ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoA();
		atendimentoIndividualDto.setUsuarioDto(usuarioDTO);
		atendimentoIndividualDto.setAcoesDeCondutasDto(Arrays.asList(acaoCondutaDTOA, acaoCondutaDTOB));
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("14:00", "15:00"));
		atendimentoIndividualDto.setArquivos(ContextoArquivo.obterArquivoDtoDocumentoAVFUN());

		servicoSisLaraServerRmi.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Registro.obterAutomatizadorTarefas().executar();

		EspecificacaoPesquisaAtendimentoIndividualDTO especificacaoPesquisaAtendimentoIndividualDto = new EspecificacaoPesquisaAtendimentoIndividualDTO();
		especificacaoPesquisaAtendimentoIndividualDto
				.setProntuario(atendimentoIndividualDto.getUsuarioDto().getId().toString());

		ResultadoListagemAtendimentoIndividualDTO resultadoListagemAtendimentoIndividualDto = servicoSisLaraServerRmi
				.obterListagemAtendimentoIndividual(especificacaoPesquisaAtendimentoIndividualDto);
		AtendimentoIndividualDTO atendimentoIndividualDtoAAlterar = resultadoListagemAtendimentoIndividualDto
				.getObjetosDto().get(0);
		atendimentoIndividualDtoAAlterar.getInformacaoAtendimentoDto()
				.setFrequenciaDto(new FrequenciaDTO(Frequencia.FU.toString()));
		atendimentoIndividualDtoAAlterar.setHorarioDto(new HorarioDTO("14:00", "15:00"));

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDTO = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDtoAAlterar, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualDTO.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDTO.obterMensagens().contains(
				"N�o � poss�vel incluir um posicionamento de integra��o ou triagem em atendimentos com frequ�ncia diferente de AT."));
	}
	
	@Test(groups = { TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_permite_cancelamento_de_acao_de_conduta_de_integracao_processada_em_atendimento_individual()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AcaoCondutaDTO acaoCondutaDTOA = ContextoAcaoConduta.fabricarAcoesCondutaDto();
		GrupoDTO grupoADto = new FabricaGrupo()
				.converterParaDTO(Registro.obterRepositorioGrupo().obterGrupoPorId(new Long(14444)));
		acaoCondutaDTOA.setGrupoDto(grupoADto);
		
		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuarioAlternativo();
		UsuarioDTO usuarioDTO = ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoA();
		atendimentoIndividualDto.getDescricaoTipoAtendimentoDto().setId(new Long(17));
		atendimentoIndividualDto.setUsuarioDto(usuarioDTO);
		atendimentoIndividualDto.setAcoesDeCondutasDto(Arrays.asList(acaoCondutaDTOA));
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("12:00", "13:00"));
		AcaoCondutaDTO acaoCondutaDTO = ContextoAcaoConduta.fabricarAcoesCondutaDto();
		acaoCondutaDTO.setId(null);
		atendimentoIndividualDto.setAcoesDeCondutasDto(Arrays.asList(acaoCondutaDTO));
		atendimentoIndividualDto.setArquivos(ContextoArquivo.obterArquivoDtoDocumentoAVFUN());

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualAntesProcessamentoAcaoCondutaDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Registro.obterAutomatizadorTarefas().executar();
		
		AtendimentoIndividualDTO atendimentoIndividualDTOAposProcessamentoDeAcaoConduta = (AtendimentoIndividualDTO) resultadoEdicaoAtendimentoIndividualAntesProcessamentoAcaoCondutaDto
				.obterObjetoDtoEditado();
		
		atendimentoIndividualDTOAposProcessamentoDeAcaoConduta.getAcoesDeCondutasDto().get(0).setCancelada(true);
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualAposProcessamentoAcaoCondutaDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDTOAposProcessamentoDeAcaoConduta, resultadoDto.getToken());

		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualAntesProcessamentoAcaoCondutaDto.sucesso());
		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualAposProcessamentoAcaoCondutaDto.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualAposProcessamentoAcaoCondutaDto.obterMensagens()
				.contains("N�o � poss�vel cancelar uma acao de conduta j� processada."));
	}
	
	@Test(groups = { TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_permite_mais_de_um_grupo_por_tipo_nas_condutas_em_atendimento_individual()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AcaoCondutaDTO acaoCondutaDTOA = ContextoAcaoConduta.fabricarAcoesCondutaDto();
		GrupoDTO grupoADto = new FabricaGrupo()
				.converterParaDTO(Registro.obterRepositorioGrupo().obterGrupoPorId(new Long(14444)));
		acaoCondutaDTOA.setGrupoDto(grupoADto);
		
		AcaoCondutaDTO acaoCondutaDTOB = ContextoAcaoConduta.fabricarAcoesCondutaDto();
		GrupoDTO grupoBDto = new FabricaGrupo()
				.converterParaDTO(Registro.obterRepositorioGrupo().obterGrupoPorId(new Long(15555)));
		acaoCondutaDTOB.setGrupoDto(grupoBDto);

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		UsuarioDTO usuarioDTO = ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoA();
		atendimentoIndividualDto.setUsuarioDto(usuarioDTO);
		atendimentoIndividualDto.setAcoesDeCondutasDto(Arrays.asList(acaoCondutaDTOA, acaoCondutaDTOB));
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("12:00", "13:00"));

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.obterMensagens()
				.contains("N�o � poss�vel existir mais de uma a��o de conduta por tipo de grupo."));
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_inclui_atendimento_individual_com_acao_de_conduta_de_retorno_com_sucesso_sem_duplicacao_na_espera()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AcaoCondutaDTO acaoCondutaDTOA = ContextoAcaoConduta.fabricarAcoesCondutaDto();
		acaoCondutaDTOA.setTipoAcaoCondutaDto(new TipoAcaoCondutaDTO(TipoAcaoConduta.RETORNAR.toString()));
		acaoCondutaDTOA.setSetorDto(new SetorDTO(Setor.CTO.toString()));
		acaoCondutaDTOA.setDataExpectativa("01/01/2017");
		acaoCondutaDTOA.setObs("Texto de obs do retorno.");
		acaoCondutaDTOA.setGrupoDto(null);
		
		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuarioAlternativa();
		atendimentoIndividualDto.getDescricaoTipoAtendimentoDto().setId(new Long(17));
		AcaoCondutaDTO acaoCondutaDTO = ContextoAcaoConduta.fabricarAcoesCondutaDto();
		acaoCondutaDTO.setId(null);
		atendimentoIndividualDto.setAcoesDeCondutasDto(Arrays.asList(acaoCondutaDTO));
		String dataA = "03/01/2017";
		UsuarioDTO usuarioDTO = atendimentoIndividualDto.getUsuarioDto();
		atendimentoIndividualDto.setUsuarioDto(usuarioDTO);
		atendimentoIndividualDto.setAcoesDeCondutasDto(Arrays.asList(acaoCondutaDTOA));
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("12:00", "13:00"));
		atendimentoIndividualDto.setData(dataA);
		atendimentoIndividualDto.setArquivos(ContextoArquivo.obterArquivoDtoDocumentoAVFUN());
		
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualADto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());
		String dataB = "02/01/2017";
		atendimentoIndividualDto.setData(dataB);
		
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualBDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Registro.obterAutomatizadorTarefas().executar();
		Registro.obterAutomatizadorTarefas().executar();

		EspecificacaoPesquisaEsperaDTO especificacaoPesquisaEsperaDTO = new EspecificacaoPesquisaEsperaDTO();
		especificacaoPesquisaEsperaDTO.setProntuario(usuarioDTO.getId().toString());
		especificacaoPesquisaEsperaDTO.setInteresse(false);
		especificacaoPesquisaEsperaDTO.setLmLigou(false);
		especificacaoPesquisaEsperaDTO.setPendencias(false);
		ResultadoListagemEsperaDTO listagemEsperaAposAcaoCondutaRetorno = servicoSisLaraServerRmi
				.obterListagemEspera(especificacaoPesquisaEsperaDTO);
		
		EsperaDTO esperaDto = listagemEsperaAposAcaoCondutaRetorno.getObjetosDto().get(0);
		
		AcaoCondutaDTO acaoCondutaADto = obterAcaoCondutaDTO(usuarioDTO, dataA);
		
		AcaoCondutaDTO acaoCondutaBDto = obterAcaoCondutaDTO(usuarioDTO, dataB);
		
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualADto.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualBDto.sucesso());
		Assert.assertEquals(listagemEsperaAposAcaoCondutaRetorno.getObjetosDto().size(),  1);
		Assert.assertTrue(esperaDto.getObs().contains("Texto de obs do retorno. Inclu�do automaticamente pela conduta do retorno. "));
		Assert.assertTrue(acaoCondutaADto.getResultadoProcessamento().contains("Dados armazenados com sucesso. "));
		Assert.assertTrue(acaoCondutaBDto.getResultadoProcessamento()
				.contains("J� existe na lista de espera de avalia��o funcional."));
	}

	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_inclui_atendimento_individual_com_acao_de_conduta_de_retorno_sem_dados_obrigatorios()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AcaoCondutaDTO acaoCondutaDTOA = ContextoAcaoConduta.fabricarAcoesCondutaDto();
		acaoCondutaDTOA.setTipoAcaoCondutaDto(new TipoAcaoCondutaDTO(TipoAcaoConduta.RETORNAR.toString()));
			
		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuarioAlternativo();
		atendimentoIndividualDto.getDescricaoTipoAtendimentoDto().setId(new Long(17));
		AcaoCondutaDTO acaoCondutaDTO = ContextoAcaoConduta.fabricarAcoesCondutaDto();
		acaoCondutaDTO.setId(null);
		atendimentoIndividualDto.setAcoesDeCondutasDto(Arrays.asList(acaoCondutaDTO));
		
		UsuarioDTO usuarioDTO = ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoA();
		atendimentoIndividualDto.setUsuarioDto(usuarioDTO);
		atendimentoIndividualDto.setAcoesDeCondutasDto(Arrays.asList(acaoCondutaDTOA));
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("12:00", "13:00"));

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.obterMensagens()
				.contains("Existe uma conduta com dados inv�lidos."));
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_inclui_atendimento_individual_com_acao_de_conduta_de_nao_e_caso_para_lm()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AcaoCondutaDTO acaoCondutaDTOA = ContextoAcaoConduta.fabricarAcoesCondutaDto();
		acaoCondutaDTOA.setTipoAcaoCondutaDto(new TipoAcaoCondutaDTO(TipoAcaoConduta.NAO_E_CASO_PARA_LM.toString()));
		acaoCondutaDTOA.setObs("TExto de obs.");
		acaoCondutaDTOA.setGrupoDto(null);
			
		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuarioAlternativo();
		atendimentoIndividualDto.getDescricaoTipoAtendimentoDto().setId(new Long(17));
		AcaoCondutaDTO acaoCondutaDTO = ContextoAcaoConduta.fabricarAcoesCondutaDto();
		acaoCondutaDTO.setId(null);
		atendimentoIndividualDto.setAcoesDeCondutasDto(Arrays.asList(acaoCondutaDTO));
		
		UsuarioDTO usuarioDTO = ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoC();
		atendimentoIndividualDto.setUsuarioDto(usuarioDTO);
		atendimentoIndividualDto.setAcoesDeCondutasDto(Arrays.asList(acaoCondutaDTOA));
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("12:00", "13:00"));
		atendimentoIndividualDto.setArquivos(ContextoArquivo.obterArquivoDtoDocumentoAVFUN());

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Registro.obterAutomatizadorTarefas().executar();
		
		EspecificacaoPesquisaAtendimentoIndividualDTO especificacaoPesquisaAtendimentoIndividualDTO = new EspecificacaoPesquisaAtendimentoIndividualDTO();
		especificacaoPesquisaAtendimentoIndividualDTO.setProntuario(usuarioDTO.getId().toString());
		
		ResultadoListagemAtendimentoIndividualDTO resultadoListagemAtendimentoIndividualDTO = servicoSisLaraServerRmi
				.obterListagemAtendimentoIndividual(especificacaoPesquisaAtendimentoIndividualDTO);

		AtendimentoIndividualDTO atendimentoIndividualDTOAposProcessamento = resultadoListagemAtendimentoIndividualDTO
				.getObjetosDto().get(0);
		AcaoCondutaDTO acaoCondutaDTOAposProcessamento = atendimentoIndividualDTOAposProcessamento
				.getAcoesDeCondutasDto().get(0);
		
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertTrue(
				acaoCondutaDTOAposProcessamento.getResultadoProcessamento().contains("Processado automaticamente pelo sistema."));
	}
	
	@Test(groups = {TiposDeTeste.USUARIO })
	public void servico_altera_status_do_usuario_menor_de_21_anos_desligado_ha_mais_de_um_ano_para_retorno_apos_atendimento_de_servico_social_de_retorno()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		Long prontuario = new Long(17777);
		EspecificacaoPesquisaUsuarioDTO especificacaoPesquisaUsuarioDTO = new EspecificacaoPesquisaUsuarioDTO();
		especificacaoPesquisaUsuarioDTO.adicionarParametro(ChavePesquisaDTO.PRONTUARIO, prontuario.toString());
		ResultadoListagemUsuarioDTO resultadoListagemUsuarioDTO = servicoSisLaraServerRmi
				.pesquisarUsuarioPor(especificacaoPesquisaUsuarioDTO);
		UsuarioDTO usuarioDtoAntesAtualizacaoStatus = (UsuarioDTO) obterDaRelacaoPorId(resultadoListagemUsuarioDTO.getObjetosDto(),
				prontuario);

		String data = "27/07/1982";
		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("12:00", "13:00"));
		atendimentoIndividualDto.setUsuarioDto(usuarioDtoAntesAtualizacaoStatus);
		atendimentoIndividualDto.setData(data);
		atendimentoIndividualDto
				.setDescricaoTipoAtendimentoDto(ContextoDescricaoTipoAtendimento.construirDescricaoServicoSocialDTO());
		atendimentoIndividualDto.setModuloDto(ContextoModulo.construirModuloAvaliacaoETriagemDTO());

		MaquinaTempo.mudarDataAtual(data);
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();

		ResultadoListagemUsuarioDTO resultadoListagemUsuarioDTOAposAtualizacaoStatus = servicoSisLaraServerRmi
				.pesquisarUsuarioPor(especificacaoPesquisaUsuarioDTO);
		UsuarioDTO usuarioDtoAposAtualizacaoStatus = (UsuarioDTO) obterDaRelacaoPorId(
				resultadoListagemUsuarioDTOAposAtualizacaoStatus.getObjetosDto(), prontuario);

		Assert.assertEquals(usuarioDtoAntesAtualizacaoStatus.getStatusUsuarioAtualDto().toString(),
				new StatusDTO("DESLIGADO").toString());
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertEquals(usuarioDtoAposAtualizacaoStatus.getStatusUsuarioAtualDto().toString(),
				new StatusDTO("RETORNO").toString());
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_inclui_atendimento_individual_de_oftalmologia_pela_primeira_vez_e_incluir_automaticamente_em_espera_de_avaliacao_funcional()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoB());
		atendimentoIndividualDto.setData("01/01/2000");
		atendimentoIndividualDto.setPrimeiraVezOuRetornoDto(new StatusDTO("PRIMEIRA_VEZ"));
		atendimentoIndividualDto.setOpcaoIntegracaoDto(new OpcaoIntegracaoDTO(OpcaoIntegracao.INTEGRACAO.toString()));
		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOftalmologia());
		atendimentoIndividualDto.setModuloDto(ContextoModulo.construirModuloAEE());

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualPrimeiraVezDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());
		
		atendimentoIndividualDto.setData("01/02/2000");
		atendimentoIndividualDto.setPrimeiraVezOuRetornoDto(new StatusDTO("RETORNO"));
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualRetornoDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		EspecificacaoPesquisaEsperaDTO especificacao = new EspecificacaoPesquisaEsperaDTO();
		especificacao.setProntuario(atendimentoIndividualDto.getUsuarioDto().getId().toString());
		especificacao.setStatusEsperadoDto(new StatusEsperaDTO(StatusEspera.AGUARDANDO.toString()));
		especificacao.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoAvaliacaoFuncionalDTO());
		especificacao.setTipoEsperaDto(new TipoEsperaDTO("CN"));
		especificacao.setModuloDto(ContextoModulo.construirModuloAEE());
		especificacao.setInteresse(false);
		especificacao.setLmLigou(false);
		especificacao.setPendencias(false);

		ResultadoListagemEsperaDTO listagemEsperaAvaliacaoFuncional = servicoSisLaraServerRmi
				.obterListagemEspera(especificacao);

		EsperaDTO esperaIncluidaAutomaticamenteEmAvaliacaoFuncional = listagemEsperaAvaliacaoFuncional.getObjetosDto()
				.get(0);

		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualPrimeiraVezDto.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualRetornoDto.sucesso());
		Assert.assertEquals(listagemEsperaAvaliacaoFuncional.getObjetosDto().size(), 1);
		Assert.assertTrue(esperaIncluidaAutomaticamenteEmAvaliacaoFuncional.getObs()
				.contains("Inclu�do automaticamente em consequ�ncia ao primeiro atendimento em oftalmologia."));
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_inclui_atendimento_individual_de_oftalmologia_pela_primeira_vez_e_nao_incluir_automaticamente_em_espera_de_avaliacao_funcional_caso_que_nao_e_para_laramara()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoB());
		atendimentoIndividualDto.setData("01/01/2000");
		atendimentoIndividualDto.setPrimeiraVezOuRetornoDto(new StatusDTO("PRIMEIRA_VEZ"));
		atendimentoIndividualDto.setOpcaoIntegracaoDto(new OpcaoIntegracaoDTO(OpcaoIntegracao.NAO_E_CASO_PARA_LM.toString()));
		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOftalmologia());
		atendimentoIndividualDto.setModuloDto(ContextoModulo.construirModuloAEE());

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualPrimeiraVezDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());
		
		EspecificacaoPesquisaEsperaDTO especificacao = new EspecificacaoPesquisaEsperaDTO();
		especificacao.setProntuario(atendimentoIndividualDto.getUsuarioDto().getId().toString());
		especificacao.setStatusEsperadoDto(new StatusEsperaDTO(StatusEspera.AGUARDANDO.toString()));
		especificacao.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoAvaliacaoFuncionalDTO());
		especificacao.setTipoEsperaDto(new TipoEsperaDTO("CN"));
		especificacao.setModuloDto(ContextoModulo.construirModuloAEE());
		especificacao.setInteresse(false);
		especificacao.setLmLigou(false);
		especificacao.setPendencias(false);

		ResultadoListagemEsperaDTO listagemEsperaAvaliacaoFuncional = servicoSisLaraServerRmi
				.obterListagemEspera(especificacao);

		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualPrimeiraVezDto.sucesso());
		Assert.assertTrue(listagemEsperaAvaliacaoFuncional.getObjetosDto().isEmpty());
	}

	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_inclui_atendimento_individual_de_oftalmologia_de_retorno_automaticamente_em_espera_de_avaliacao_funcional()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setUsuarioDto(ContextoUsuario.construirUsuarioDTOComIdentificacaoAlternativoB());
		atendimentoIndividualDto.setData("01/01/2000");
		atendimentoIndividualDto.setPrimeiraVezOuRetornoDto(new StatusDTO("RETORNO"));
		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOftalmologia());
		atendimentoIndividualDto.setModuloDto(ContextoModulo.construirModuloAEE());
		atendimentoIndividualDto.setOpcaoIntegracaoDto(new OpcaoIntegracaoDTO(OpcaoIntegracao.INTEGRACAO.toString()));
		
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		EspecificacaoPesquisaEsperaDTO especificacao = new EspecificacaoPesquisaEsperaDTO();
		especificacao.setProntuario(atendimentoIndividualDto.getUsuarioDto().getId().toString());
		especificacao.setStatusEsperadoDto(new StatusEsperaDTO(StatusEspera.AGUARDANDO.toString()));
		especificacao.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoAvaliacaoFuncionalDTO());
		especificacao.setModuloDto(ContextoModulo.construirModuloAEE());
		especificacao.setInteresse(false);
		especificacao.setLmLigou(false);
		especificacao.setPendencias(false);

		ResultadoListagemEsperaDTO listagemEsperaAvaliacaoFuncional = servicoSisLaraServerRmi
				.obterListagemEspera(especificacao);

		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertEquals(listagemEsperaAvaliacaoFuncional.getObjetosDto().size(), 0);
	}
	
	@Test(groups = { TiposDeTeste.ESPERA })
	public void servico_inclui_atendimento_individual_com_sucesso_e_envia_lista_de_espera_por_excesso_de_faltas()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		Long prontuario = new Long(13333);

		servico_cria_tres_atendimentos_individuais_com_frequencia_fu_em_dias_diferentes(resultadoDto, prontuario);

		EspecificacaoPesquisaEsperaDTO especificacaoPesquisaEsperaDto = ContextoEspecificacaoPesquisaEspera
				.fabricarDtoPesquisaEsperaDescricaoServicoSocialModuloExcessoDeFaltas(prontuario);

		ResultadoListagemEsperaDTO resultado = servicoSisLaraServerRmi
				.obterListagemEspera(especificacaoPesquisaEsperaDto);

		Assert.assertEquals(resultado.getObjetosDto().size(), 1);
	}

	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_nao_inclui_nova_espera_por_existencia_de_espera_servico_social_por_excesso_de_faltas()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		UsuarioDTO usuarioDTO = ContextoUsuario.construirUsuarioDTOComIdentificacao();

		servico_cria_tres_atendimentos_individuais_com_frequencia_fu_em_dias_diferentes(resultadoDto,
				usuarioDTO.getId());

		EsperaDTO esperaDto = ContextoEspera.construirEsperaDTO();
		esperaDto.setPreCadastroDto(null);
		esperaDto.setUsuarioDto(usuarioDTO);

		ResultadoEdicaoEsperaDTO resultadoInclusaoEspera = servicoSisLaraServerRmi.editarEspera(esperaDto,
				resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoEspera.sucesso());
		Assert.assertEquals(resultadoInclusaoEspera.obterMensagens(),
				"O Usu�rio est� bloqueado por excesso de faltas n�o justificadas.\n");
	}

	@Test(groups = { TiposDeTeste.AGENDAMENTO })
	public void servico_nao_inclui_agendamento_por_existencia_de_espera_servico_social_por_excesso_de_faltas()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		UsuarioDTO usuarioDto = ContextoUsuario.construirUsuarioDTOComIdentificacao();

		servico_cria_tres_atendimentos_individuais_com_frequencia_fu_em_dias_diferentes(resultadoDto,
				usuarioDto.getId());

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(12222));
		agendamentoDto.setUsuarioDto(usuarioDto);

		ResultadoEdicaoAgendamentoDTO resultadoEdicaoAgendamentoDto = servicoSisLaraServerRmi
				.editarAgendamento(agendamentoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAgendamentoDto.sucesso());
		Assert.assertEquals(resultadoEdicaoAgendamentoDto.obterMensagens(),
				"O Usu�rio est� bloqueado por excesso de faltas n�o justificadas.\n");
	}

	@Test(groups = { TiposDeTeste.AGENDAMENTO })
	public void servico_associa_agendamento_servico_social_mesmo_com_existencia_de_espera_por_excesso_de_faltas()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		UsuarioDTO usuarioDto = ContextoUsuario.construirUsuarioDTOComIdentificacao();

		servico_cria_tres_atendimentos_individuais_com_frequencia_fu_em_dias_diferentes(resultadoDto,
				usuarioDto.getId());

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);
		// Ref. id 18888
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(18888));
		agendamentoDto.setUsuarioDto(usuarioDto);

		ResultadoEdicaoAgendamentoDTO resultadoEdicaoAgendamentoDto = servicoSisLaraServerRmi
				.editarAgendamento(agendamentoDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoEdicaoAgendamentoDto.sucesso());
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_reagenda_agendamento_com_sucesso() throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		DescricaoTipoAtendimentoDTO descricaoTipoAtendimentoDTO = ContextoDescricaoTipoAtendimento
				.construirDescricaoTipoAtendimentoDTO();
		descricaoTipoAtendimentoDTO.setId(new Long(37));

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(3000), "Josep", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);
		// Id 17777
		AgendamentoDTO agendamentoAntigoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(17777));
		// Id 19999
		AgendamentoDTO agendamentoNovoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(19999));

		ResultadoEdicaoAgendamentoDTO resultadoReagendamentoAgendamentoDto = servicoSisLaraServerRmi
				.reagendarAgendamento(agendamentoAntigoDto, agendamentoNovoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoReagendamentoAgendamentoDto.sucesso());
		Assert.assertEquals(resultadoReagendamentoAgendamentoDto.obterMensagens(),
				"N�o foi poss�vel efetuar o reagendamento.\n");
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_reagenda_agendamento_de_usuario_em_espera_por_excesso_de_faltas_com_sucesso()
			throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		DescricaoTipoAtendimentoDTO descricaoTipoAtendimentoDTO = ContextoDescricaoTipoAtendimento
				.construirDescricaoTipoAtendimentoDTO();
		descricaoTipoAtendimentoDTO.setId(new Long(37));

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setDataInicio("01/01/1000");
		especificacao.setDataTermino("01/01/2999");
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);
		// Id 13333
		AgendamentoDTO agendamentoAntigoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(13333));

		servico_cria_tres_atendimentos_individuais_com_frequencia_fu_em_dias_diferentes(resultadoDto,
				agendamentoAntigoDto.getUsuarioDto().getId());

		// Id 14444
		AgendamentoDTO agendamentoNovoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(14444));

		MaquinaTempo.mudarDataAtual("01/01/2012");
		ResultadoEdicaoAgendamentoDTO resultadoReagendamentoAgendamentoDto = servicoSisLaraServerRmi
				.reagendarAgendamento(agendamentoAntigoDto, agendamentoNovoDto, resultadoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertFalse(resultadoReagendamentoAgendamentoDto.sucesso());
		Assert.assertEquals(resultadoReagendamentoAgendamentoDto.obterMensagens().trim(),
				"O Usu�rio est� bloqueado por excesso de faltas n�o justificadas.");
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_reagenda_agendamento_de_usuario_devido_expiracao_do_prazo_de_24_horas()
			throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		DescricaoTipoAtendimentoDTO descricaoTipoAtendimentoDTO = ContextoDescricaoTipoAtendimento
				.construirDescricaoTipoAtendimentoDTO();
		descricaoTipoAtendimentoDTO.setId(new Long(37));

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setDataInicio("01/01/1000");
		especificacao.setDataTermino("01/01/2999");
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);
		// Id 13333
		AgendamentoDTO agendamentoAntigoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(13333));

		// Id 14444
		AgendamentoDTO agendamentoNovoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(14444));

		ResultadoEdicaoAgendamentoDTO resultadoReagendamentoAgendamentoDto = servicoSisLaraServerRmi
				.reagendarAgendamento(agendamentoAntigoDto, agendamentoNovoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoReagendamentoAgendamentoDto.sucesso());
		Assert.assertEquals(resultadoReagendamentoAgendamentoDto.obterMensagens().trim(),
				"Prazo m�ximo de 24 horas para efetuar o reagendamento est� expirado. O usu�rio dever� retornar para a lista de espera.");
	}
	
	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_nao_reagenda_agendamento_de_usuario_devido_setor_incompativel() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setDataInicio("01/01/1000");
		especificacao.setDataTermino("01/01/2999");
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);
	
		AgendamentoDTO agendamentoAntigoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(26666));
	
		AgendamentoDTO agendamentoNovoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(16666));

		MaquinaTempo.mudarDataAtual("01/01/2012");
		ResultadoEdicaoAgendamentoDTO resultadoReagendamentoAgendamentoDto = servicoSisLaraServerRmi
				.reagendarAgendamento(agendamentoAntigoDto, agendamentoNovoDto, resultadoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertFalse(resultadoReagendamentoAgendamentoDto.sucesso());
		Assert.assertTrue(resultadoReagendamentoAgendamentoDto.obterMensagens().contains(
				"N�o � poss�vel agendar um usu�rio de setor incompat�vel com o solicitado pelo agendamento."));
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_reagenda_agendamento_com_sucesso() throws RemoteException {

		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setDataInicio("01/01/1000");
		especificacao.setDataTermino("01/01/2999");
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);
		// Id 13333
		AgendamentoDTO agendamentoAntigoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(13333));
		// Id 15555
		AgendamentoDTO agendamentoNovoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(15555));

		MaquinaTempo.mudarDataAtual("01/01/2012");
		ResultadoEdicaoAgendamentoDTO resultadoReagendamentoAgendamentoDto = servicoSisLaraServerRmi
				.reagendarAgendamento(agendamentoAntigoDto, agendamentoNovoDto, resultadoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();

		AgendamentoDTO agendamentoDtoLiberado = (AgendamentoDTO) resultadoReagendamentoAgendamentoDto
				.obterObjetoDtoEditado();

		EspecificacaoPesquisaAgendamentoDTO especificacaoAposReagendamento = new EspecificacaoPesquisaAgendamentoDTO();
		especificacaoAposReagendamento.setProntuario("12222");
		ResultadoListagemAgendamentoDTO resultadoAposReagendamento = servicoSisLaraServerRmi
				.obterListagemAgendamento(especificacaoAposReagendamento);
		// id 13333
		AgendamentoDTO agendamentoDtoReagendado = (AgendamentoDTO) obterDaRelacaoPorId(
				resultadoAposReagendamento.getObjetosDto(), new Long(13333));
		// id 15555
		AgendamentoDTO agendamentoDtoAgendado = (AgendamentoDTO) obterDaRelacaoPorId(
				resultadoAposReagendamento.getObjetosDto(), new Long(15555));

		Assert.assertTrue(resultadoReagendamentoAgendamentoDto.sucesso());
		Assert.assertNull(agendamentoDtoLiberado.getUsuarioDto());
		Assert.assertTrue(agendamentoDtoLiberado.isEstaDisponivel());
		Assert.assertTrue(agendamentoDtoReagendado.isEstaReagendado());
		Assert.assertTrue(agendamentoDtoAgendado.isEstaAgendado());
	}

	@Test(groups = { TiposDeTeste.AGENDAMENTO })
	public void servico_inclui_agendamento_na_avaliacao_e_triagem_mesmo_com_existencia_de_espera_por_excesso_de_faltas()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		UsuarioDTO usuarioDto = ContextoUsuario.construirUsuarioDTOComIdentificacao();

		servico_cria_tres_atendimentos_individuais_com_frequencia_fu_em_dias_diferentes(resultadoDto,
				usuarioDto.getId());

		DescricaoTipoAtendimentoDTO descricaoTipoAtendimentoDTO = ContextoDescricaoTipoAtendimento
				.construirDescricaoTipoAtendimentoDTO();
		descricaoTipoAtendimentoDTO.setId(new Long(37));

		ModuloDTO moduloDTO = new ModuloDTO(new Long(37), "SS");

		EspecificacaoPesquisaAgendamentoDTO especificacao = new EspecificacaoPesquisaAgendamentoDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		ResultadoListagemAgendamentoDTO resultado = servicoSisLaraServerRmi.obterListagemAgendamento(especificacao);
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(resultado.getObjetosDto(),
				new Long(12222));
		agendamentoDto.setDescricaoTipoAtendimentoDto(descricaoTipoAtendimentoDTO);
		agendamentoDto.setModuloDto(moduloDTO);
		agendamentoDto.setUsuarioDto(usuarioDto);

		ResultadoEdicaoAgendamentoDTO resultadoEdicaoAgendamentoDto = servicoSisLaraServerRmi
				.editarAgendamento(agendamentoDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoEdicaoAgendamentoDto.sucesso());
	}

	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_inclui_atendimento_individual_em_conflito() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosPreCadastro();

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertEquals(resultadoEdicaoAtendimentoIndividualDto.obterMensagens(),
				"J� existe atendimento individual cadastrado com a data e hora especificado. Detalhes: PAULO AUGUSTO BANDEIRA DOS SANTOS, 31/12/2012, 09:00 �s 10:00.\n PAULO AUGUSTO BANDEIRA DOS SANTOS, 31/12/2012, 09:00 �s 10:00.\n");
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_inclui_atendimento_individual_com_erro_contendo_usuario_com_frequencia_AT_sem_participaca_detalhada() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosPreCadastro();
		atendimentoIndividualDto.getInformacaoAtendimentoDto().setParticipadaoDetalhadaDto(Arrays.asList());

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertTrue(
				resultadoEdicaoAtendimentoIndividualDto.obterMensagens().contains("Insira uma Participa��o no atendimento com frequencia AT"));
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_inclui_atendimento_individual_com_liberacao_atendimento_individual_simultaneo()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosPreCadastro();
		atendimentoIndividualDto.getDescricaoTipoAtendimentoDto().setId(new Long(52));
		atendimentoIndividualDto.setModuloDto(new ModuloDTO(new Long(4), "Modulo Liberrado"));

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.sucesso());
	}

	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_inclui_atendimento_individual_dia_posterior_ao_dia_atual() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosPreCadastro();
		atendimentoIndividualDto.setData("31/12/2090");

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertEquals(resultadoEdicaoAtendimentoIndividualDto.obterMensagens(),
				"Insira uma data igual ou anterior ao dia de hoje.\n\n");
	}

	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_altera_atendimento_individual_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaAtendimentoIndividualDTO especificacao = new EspecificacaoPesquisaAtendimentoIndividualDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		especificacao.setDataInicio("31/12/2014");
		ResultadoListagemAtendimentoIndividualDTO resultado = servicoSisLaraServerRmi
				.obterListagemAtendimentoIndividual(especificacao);
		// Ref. id 14444
		AtendimentoIndividualDTO atendimentoIndividualDto = (AtendimentoIndividualDTO) obterDaRelacaoPorId(
				resultado.getObjetosDto(), new Long(16666));
		atendimentoIndividualDto.setSetorDto(new SetorDTO("PROCEJA"));

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.sucesso());
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_obtem_atendimento_individual_com_resumo_integracao_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		UsuarioDTO usuarioDto = ContextoUsuario.construirUsuarioDTOComIdentificacao();
		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setUsuarioDto(usuarioDto);
		atendimentoIndividualDto.setData("01/01/2000");
		atendimentoIndividualDto.setPrimeiraVezOuRetornoDto(new StatusDTO("PRIMEIRA_VEZ"));
		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOftalmologia());
		atendimentoIndividualDto.setModuloDto(ContextoModulo.construirModuloAEE());
		atendimentoIndividualDto.setOpcaoIntegracaoDto(new OpcaoIntegracaoDTO(OpcaoIntegracao.INTEGRACAO.toString()));
		atendimentoIndividualDto.setMotivoNaoIntegracao("");

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualOftalmoDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());
		
		EspecificacaoPesquisaAtendimentoIndividualDTO especificacao = new EspecificacaoPesquisaAtendimentoIndividualDTO();
		especificacao.setProntuario(usuarioDto.getId().toString());
		ResultadoListagemAtendimentoIndividualDTO resultado = servicoSisLaraServerRmi
				.obterListagemAtendimentoIndividual(especificacao);
		
		AtendimentoIndividualDTO atendimentoIndividualComResumoDto = (AtendimentoIndividualDTO) obterDaRelacaoPorId(
				resultado.getObjetosDto(), usuarioDto.getId());
		
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualOftalmoDto.sucesso());
		Assert.assertEquals(atendimentoIndividualComResumoDto.getResumoIntegracao(),
				"Avalia��o de Servi�o de Aten��o Especializada em Oftalmologia - 01/01/2000 - INTEGRACAO - \nAtendimento de Teste - 29/11/2014 - NAO_INTEGRACAO - Texto de motivo");
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_altera_atendimento_individual_com_nao_integracao_sem_motivo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		UsuarioDTO usuarioDto = ContextoUsuario.construirUsuarioDTOComIdentificacao();
		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setUsuarioDto(usuarioDto);
		atendimentoIndividualDto.setData("01/01/2000");
		atendimentoIndividualDto.setPrimeiraVezOuRetornoDto(new StatusDTO("PRIMEIRA_VEZ"));
		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOftalmologia());
		atendimentoIndividualDto.setModuloDto(ContextoModulo.construirModuloAEE());
		atendimentoIndividualDto.setOpcaoIntegracaoDto(new OpcaoIntegracaoDTO(OpcaoIntegracao.NAO_INTEGRACAO.toString()));
		atendimentoIndividualDto.setMotivoNaoIntegracao("");

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());
		
		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualDto.obterMensagens().contains("Insira o motivo de n�o integra��o."));
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_insere_atendimento_individual_primeira_vez_sem_posicao_de_integracao_e_discussao_de_caso_obrigatoria() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		UsuarioDTO usuarioDto = ContextoUsuario.construirUsuarioDTOComIdentificacao();
		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setUsuarioDto(usuarioDto);
		atendimentoIndividualDto.setData("01/01/2000");
		atendimentoIndividualDto.setPrimeiraVezOuRetornoDto(new StatusDTO("PRIMEIRA_VEZ"));
		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOftalmologia());
		atendimentoIndividualDto.setModuloDto(ContextoModulo.construirModuloAEE());
		atendimentoIndividualDto.setOpcaoIntegracaoDto(null);
		atendimentoIndividualDto.setDiscussaoCasoSimNaoDto(null);
		
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualOftalmologiaDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualOftalmologiaDto.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualOftalmologiaDto.obterMensagens()
				.contains("Insira um posicionamento sobre a integra��o na triagem."));
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualOftalmologiaDto.obterMensagens()
				.contains("Insira um posicionamento sobre a discuss�o de caso na triagem."));
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_insere_atendimento_individual_retorno_de_usuario_com_status_diferente_de_integrado_do_setor_CTO_sem_posicao_de_integracao_e_discussao_de_caso_obrigatoria() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaUsuarioDTO especificacao = new EspecificacaoPesquisaUsuarioDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.PRONTUARIO, "82222");

		ResultadoListagemUsuarioDTO resultadoListagemUsuarioDto = servicoSisLaraServerRmi.pesquisarUsuarioPor(especificacao);
		
		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setUsuarioDto(resultadoListagemUsuarioDto.getObjetosDto().get(0));
		atendimentoIndividualDto.setData("01/01/2000");
		atendimentoIndividualDto.setPrimeiraVezOuRetornoDto(new StatusDTO("RETORNO"));
		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOftalmologia());
		atendimentoIndividualDto.setModuloDto(ContextoModulo.construirModuloAEE());
		atendimentoIndividualDto.setOpcaoIntegracaoDto(null);
		atendimentoIndividualDto.setDiscussaoCasoSimNaoDto(null);
		
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualOftalmologiaDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualOftalmologiaDto.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualOftalmologiaDto.obterMensagens()
				.contains("Insira um posicionamento sobre a integra��o na triagem."));
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualOftalmologiaDto.obterMensagens()
				.contains("Insira um posicionamento sobre a discuss�o de caso na triagem."));
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_insere_atendimento_individual_sem_integracao_e_discussao_de_caso_do_usuario_somente_proceja() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		UsuarioDTO usuarioDto = ContextoUsuario.construirUsuarioDTOComIdentificacao();
		usuarioDto.setAssociadoAoSetorCTO(false);
		usuarioDto.setAssociadoAoSetorProceja(true);
		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setUsuarioDto(usuarioDto);
		atendimentoIndividualDto.setData("01/01/2000");
		atendimentoIndividualDto.setPrimeiraVezOuRetornoDto(new StatusDTO("PRIMEIRA_VEZ"));
		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(
				ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOftalmologia());
		atendimentoIndividualDto.setModuloDto(ContextoModulo.construirModuloAEE());
		atendimentoIndividualDto.setOpcaoIntegracaoDto(null);
		atendimentoIndividualDto.setDiscussaoCasoSimNaoDto(null);
		
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualOftalmologiaDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualOftalmologiaDto.sucesso());
	}

	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_inclui_atendimento_individual_devido_obrigatoriedade_de_primeira_vez_ou_retorno()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosPreCadastro();
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("12:00", "13:00"));
		atendimentoIndividualDto
				.setDescricaoTipoAtendimentoDto(ContextoDescricaoTipoAtendimento.construirDescricaoServicoSocialDTO());
		atendimentoIndividualDto.setModuloDto(ContextoModulo.construirModuloAvaliacaoETriagemDTO());
		atendimentoIndividualDto.setPrimeiraVezOuRetornoDto(null);
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertEquals(resultadoEdicaoAtendimentoIndividualDto.obterMensagens().trim(),
				"Selecione o campo Primeira Vez ou Retorno.");
	}

	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_altera_atendimento_individual_em_conflito() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaAtendimentoIndividualDTO especificacao = new EspecificacaoPesquisaAtendimentoIndividualDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		especificacao.setDataInicio("31/12/2012");
		ResultadoListagemAtendimentoIndividualDTO resultado = servicoSisLaraServerRmi
				.obterListagemAtendimentoIndividual(especificacao);
		// Ref id 12222
		AtendimentoIndividualDTO atendimentoIndividualDto = (AtendimentoIndividualDTO) obterDaRelacaoPorId(
				resultado.getObjetosDto(), new Long(12222));
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("09:00", "10:00"));

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertEquals(resultadoEdicaoAtendimentoIndividualDto.obterMensagens(),
				"J� existe atendimento individual cadastrado com a data e hora especificado. Detalhes: PAULO AUGUSTO BANDEIRA DOS SANTOS, 31/12/2012, 09:00 �s 10:00.\n");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_tipo_vinculo_com_sucesso() throws RemoteException {
		ResultadoListagemTipoVinculoDTO resultadoListagemTipoVinculoDto = servicoSisLaraServerRmi
				.obterListagemTipoVinculo();

		Assert.assertTrue(resultadoListagemTipoVinculoDto.sucesso());
		Assert.assertEquals(resultadoListagemTipoVinculoDto.getObjetosDto().size(), 4);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_participacao_com_sucesso() throws RemoteException {
		ResultadoListagemParticipacaoDTO resultadoListagemParticipacaoDto = servicoSisLaraServerRmi
				.obterListagemParticipacao();

		Assert.assertTrue(resultadoListagemParticipacaoDto.sucesso());
		Assert.assertEquals(resultadoListagemParticipacaoDto.getObjetosDto().size(), 5);
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_opcao_integracao_com_sucesso() throws RemoteException {
		ResultadoListagemOpcaoIntegracaoDTO resultadoListagemOpcaoIntegracaoDto = servicoSisLaraServerRmi
				.obterListagemOpcaoIntegracao();

		Assert.assertTrue(resultadoListagemOpcaoIntegracaoDto.sucesso());
		Assert.assertEquals(resultadoListagemOpcaoIntegracaoDto.getObjetosDto().size(), 4);
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_tipo_acao_conduta_com_sucesso() throws RemoteException {
		ResultadoListagemTipoAcaoCondutaDTO resultadoListagemTipoAcaoCondutaDto = servicoSisLaraServerRmi
				.obterListagemTipoAcaoConduta();

		Assert.assertTrue(resultadoListagemTipoAcaoCondutaDto.sucesso());
		Assert.assertEquals(resultadoListagemTipoAcaoCondutaDto.getObjetosDto().size(), 3);
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_todos_grupo_ativo_com_sucesso() throws RemoteException {
		ResultadoListagemGrupoDTO resultadoListagemTodosGrupoAtivoDto = servicoSisLaraServerRmi
				.obterListagemTodosGruposAtivos();

		Assert.assertTrue(resultadoListagemTodosGrupoAtivoDto.sucesso());
		Assert.assertEquals(resultadoListagemTodosGrupoAtivoDto.getObjetosDto().size(), 5);
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validar_acao_conduta_com_sucesso() throws RemoteException {
		ResultadoValidacaoAcaoCondutaDTO resultadoValidacaoCondutaDto = servicoSisLaraServerRmi
				.validarAcaoConduta(ContextoAcaoConduta.fabricarAcoesCondutaDto());

		Assert.assertTrue(resultadoValidacaoCondutaDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_de_todos_recursos_com_sucesso() throws RemoteException {
		ResultadoListagemRecursoDTO resultadoListagemRecursosDto = servicoSisLaraServerRmi
				.obterListagemRecurso();

		Assert.assertTrue(resultadoListagemRecursosDto.sucesso());
		Assert.assertEquals(resultadoListagemRecursosDto.getObjetosDto().size(), 3);
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_de_recursos_disponiveis_para_demanda_com_sucesso() throws RemoteException {
		ResultadoListagemRecursoDTO resultadoListagemRecursosDto = servicoSisLaraServerRmi
				.obterListagemRecursosDisponiveisParaDemanda();

		Assert.assertTrue(resultadoListagemRecursosDto.sucesso());
		Assert.assertEquals(resultadoListagemRecursosDto.getObjetosDto().size(), 1);
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_projeto_com_especificacao() throws RemoteException {
		EspecificacaoPesquisaProjetoDTO especificacao = new EspecificacaoPesquisaProjetoDTO();
		especificacao.setProjeto("Projeto Alcoa 1");
		
		ResultadoListagemProjetoDTO resultadoListagemProjetosDto = servicoSisLaraServerRmi
				.pesquisarProjetoPor(especificacao);

		Assert.assertTrue(resultadoListagemProjetosDto.sucesso());
		Assert.assertEquals(resultadoListagemProjetosDto.getObjetosDto().size(), 1);
	}
		
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_inclui_atendimento_individual_sem_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosPreCadastro();

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualDto.sucesso());
		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualDto.obterMensagens().isEmpty());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_atendimento_individual_com_especificacao() throws RemoteException {
		EspecificacaoPesquisaAtendimentoIndividualDTO especificacao = new EspecificacaoPesquisaAtendimentoIndividualDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		ResultadoListagemAtendimentoIndividualDTO resultado = servicoSisLaraServerRmi
				.obterListagemAtendimentoIndividual(especificacao);

		Assert.assertTrue(resultado.sucesso());
		Assert.assertFalse(resultado.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_obtem_listagem_atendimento_individual_com_especificacao_invalida() throws RemoteException {
		EspecificacaoPesquisaAtendimentoIndividualDTO especificacao = new EspecificacaoPesquisaAtendimentoIndividualDTO();

		ResultadoListagemAtendimentoIndividualDTO resultado = servicoSisLaraServerRmi
				.obterListagemAtendimentoIndividual(especificacao);

		Assert.assertFalse(resultado.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_tipo_espera_disponives_para_inclusao() throws RemoteException {
		ResultadoListagemTipoEsperaDTO resultado = servicoSisLaraServerRmi
				.obterListagemTipoEsperaDisponiveisParaInclusao();

		Assert.assertTrue(resultado.sucesso());
		Assert.assertEquals(resultado.getObjetosDto().size(), 2);
	}

	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_efetua_copia_atendimento_individual_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoCopiaAtendimentoIndividualDTO especificacaoCopiaAtendimentoIndividualDTO = new EspecificacaoCopiaAtendimentoIndividualDTO();
		especificacaoCopiaAtendimentoIndividualDTO.setHorarioDto(new HorarioDTO("12:00", "13:00"));

		EspecificacaoPesquisaAtendimentoIndividualDTO especificacao = new EspecificacaoPesquisaAtendimentoIndividualDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		ResultadoListagemAtendimentoIndividualDTO resultado = servicoSisLaraServerRmi
				.obterListagemAtendimentoIndividual(especificacao);
		// Ref id 13333
		AtendimentoIndividualDTO atendimentoIndividualDto = (AtendimentoIndividualDTO) obterDaRelacaoPorId(
				resultado.getObjetosDto(), new Long(13333));

		ResultadoEdicaoAtendimentoIndividualDTO resultadoCopiaAtendimentoIndividual = servicoSisLaraServerRmi
				.copiarAtendimentoIndividual(especificacaoCopiaAtendimentoIndividualDTO, atendimentoIndividualDto,
						resultadoDto.getToken());
		AtendimentoIndividualDTO atendimentoIndividualDTOCopiado = (AtendimentoIndividualDTO) resultadoCopiaAtendimentoIndividual
				.obterObjetoDtoEditado();

		Assert.assertTrue(resultadoCopiaAtendimentoIndividual.sucesso());
		Assert.assertNotEquals(atendimentoIndividualDTOCopiado.getId(), atendimentoIndividualDto.getId());
	}

	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_efetua_copia_atendimento_individual_com_excesso_de_faltas_e_envia_para_lista_de_espera()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoCopiaAtendimentoIndividualDTO especificacaoCopiaAtendimentoIndividualDTO = new EspecificacaoCopiaAtendimentoIndividualDTO();

		EspecificacaoPesquisaAtendimentoIndividualDTO especificacao = new EspecificacaoPesquisaAtendimentoIndividualDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		especificacao.setDataInicio("29/11/2014");

		ResultadoListagemAtendimentoIndividualDTO resultado = servicoSisLaraServerRmi
				.obterListagemAtendimentoIndividual(especificacao);
		// Ref id 14444
		AtendimentoIndividualDTO atendimentoIndividualDto = (AtendimentoIndividualDTO) obterDaRelacaoPorId(
				resultado.getObjetosDto(), new Long(14444));

		for (int i = 1; i <= 6; i++) {
			especificacaoCopiaAtendimentoIndividualDTO
					.setHorarioDto(new HorarioDTO("0" + i + ":00", "0" + (i + 1) + ":00"));
			servicoSisLaraServerRmi.copiarAtendimentoIndividual(especificacaoCopiaAtendimentoIndividualDTO,
					atendimentoIndividualDto, resultadoDto.getToken());
		}

		EspecificacaoPesquisaEsperaDTO especificacaoPesquisaEspera = new EspecificacaoPesquisaEsperaDTO();
		especificacaoPesquisaEspera.setProntuario(atendimentoIndividualDto.getUsuarioDto().getId().toString());
		especificacaoPesquisaEspera.setInteresse(false);
		especificacaoPesquisaEspera.setLmLigou(false);
		especificacaoPesquisaEspera.setPendencias(false);

		ResultadoListagemEsperaDTO resultadoEspera = servicoSisLaraServerRmi
				.obterListagemEspera(especificacaoPesquisaEspera);

		Assert.assertEquals(resultadoEspera.getObjetosDto().size(), 4);
	}

	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_efetua_nao_copia_atendimento_individual_em_conflito() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoCopiaAtendimentoIndividualDTO especificacaoCopiaAtendimentoIndividualDTO = new EspecificacaoCopiaAtendimentoIndividualDTO();
		especificacaoCopiaAtendimentoIndividualDTO.setHorarioDto(new HorarioDTO("09:00", "10:00"));

		EspecificacaoPesquisaAtendimentoIndividualDTO especificacao = new EspecificacaoPesquisaAtendimentoIndividualDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		especificacao.setDataInicio("31/12/2012");
		ResultadoListagemAtendimentoIndividualDTO resultado = servicoSisLaraServerRmi
				.obterListagemAtendimentoIndividual(especificacao);
		// Ref id 12222
		AtendimentoIndividualDTO atendimentoIndividualDto = (AtendimentoIndividualDTO) obterDaRelacaoPorId(
				resultado.getObjetosDto(), new Long(12222));

		ResultadoEdicaoAtendimentoIndividualDTO resultadoCopiaAtendimentoIndividual = servicoSisLaraServerRmi
				.copiarAtendimentoIndividual(especificacaoCopiaAtendimentoIndividualDTO, atendimentoIndividualDto,
						resultadoDto.getToken());

		Assert.assertFalse(resultadoCopiaAtendimentoIndividual.sucesso());
		Assert.assertEquals(resultadoCopiaAtendimentoIndividual.obterMensagens(),
				"J� existe atendimento individual cadastrado com a data e hora especificado. Detalhes: PAULO AUGUSTO BANDEIRA DOS SANTOS, 31/12/2012, 09:00 �s 10:00.\n PAULO AUGUSTO BANDEIRA DOS SANTOS, 31/12/2012, 09:00 �s 10:00.\n");
	}

	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_efetua_nao_copia_atendimento_individual_invalido() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoCopiaAtendimentoIndividualDTO especificacaoCopiaAtendimentoIndividualDTO = new EspecificacaoCopiaAtendimentoIndividualDTO();
		especificacaoCopiaAtendimentoIndividualDTO.setHorarioDto(new HorarioDTO("09:00", "10:00"));

		EspecificacaoPesquisaAtendimentoIndividualDTO especificacao = new EspecificacaoPesquisaAtendimentoIndividualDTO();
		especificacao.setProfissionalDto(new ProfissionalDTO(new Long(1000), "Josep", "1234"));
		especificacao.setDataInicio("31/12/2012");
		ResultadoListagemAtendimentoIndividualDTO resultado = servicoSisLaraServerRmi
				.obterListagemAtendimentoIndividual(especificacao);
		// Ref id 12222
		AtendimentoIndividualDTO atendimentoIndividualDto = (AtendimentoIndividualDTO) obterDaRelacaoPorId(
				resultado.getObjetosDto(), new Long(12222));
		atendimentoIndividualDto.setUsuarioDto(null);
		atendimentoIndividualDto.setPreCadastroDto(null);

		ResultadoEdicaoAtendimentoIndividualDTO resultadoCopiaAtendimentoIndividual = servicoSisLaraServerRmi
				.copiarAtendimentoIndividual(especificacaoCopiaAtendimentoIndividualDTO, atendimentoIndividualDto,
						resultadoDto.getToken());

		Assert.assertFalse(resultadoCopiaAtendimentoIndividual.sucesso());
		Assert.assertEquals(resultadoCopiaAtendimentoIndividual.obterMensagens(),
				"Insira um Usu�rio ou Pr�-Cadastro.\n\n");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_demanda_com_especificacao() throws RemoteException {
		EspecificacaoPesquisaDemandaDTO especificacao = ContextoEspecificacaoPesquidaDemanda
				.fabricarDtoComTodosOsDados();
		especificacao.setPreCadastroDto(null);
		especificacao.setCpf(null);
		ResultadoListagemDemandaDTO resultado = servicoSisLaraServerRmi.obterListagemDemanda(especificacao);

		Assert.assertTrue(resultado.sucesso());
		Assert.assertFalse(resultado.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_demanda_com_especificacao_contendo_cpf() throws RemoteException {
		EspecificacaoPesquisaDemandaDTO especificacao = new EspecificacaoPesquisaDemandaDTO();
		especificacao.setCpf("90353388122");
		ResultadoListagemDemandaDTO resultado = servicoSisLaraServerRmi.obterListagemDemanda(especificacao);

		Assert.assertTrue(resultado.sucesso());
		Assert.assertFalse(resultado.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
		Assert.assertEquals(resultado.getObjetosDto().size(), 2);
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_demanda_com_especificacao_contendo_aguardando() throws RemoteException {
		EspecificacaoPesquisaDemandaDTO especificacao = new EspecificacaoPesquisaDemandaDTO();
		especificacao.setStatusDemandaDto(new StatusDemandaDTO(StatusDemanda.AGUARDANDO.toString()));
		ResultadoListagemDemandaDTO resultado = servicoSisLaraServerRmi.obterListagemDemanda(especificacao);

		Assert.assertTrue(resultado.sucesso());
		Assert.assertFalse(resultado.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
		Assert.assertEquals(resultado.getObjetosDto().size(), 8);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_obtem_listagem_demanda_com_especificacao_invalida() throws RemoteException {
		EspecificacaoPesquisaDemandaDTO especificacao = new EspecificacaoPesquisaDemandaDTO();
		ResultadoListagemDemandaDTO resultado = servicoSisLaraServerRmi.obterListagemDemanda(especificacao);

		Assert.assertFalse(resultado.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_projeto_ativos() throws RemoteException {
		ResultadoListagemProjetoDTO resultado = servicoSisLaraServerRmi.obterListagemProjetoAtivos();

		Assert.assertTrue(resultado.sucesso());
		Assert.assertFalse(resultado.getObjetosDto().isEmpty(), "A lista deveria conter os itens.");
		Assert.assertEquals(resultado.getObjetosDto().size(), 1);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_lote_recurso_com_erro() throws RemoteException {
		LoteRecursoDTO loteRecursoDto = new LoteRecursoDTO();
		ResultadoValidacaoLoteRecursoDTO resultadoValidacaoLoteRecurso = servicoSisLaraServerRmi
				.validarLoteRecurso(loteRecursoDto);

		Assert.assertFalse(resultadoValidacaoLoteRecurso.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_lote_recurso_sem_erro() throws RemoteException {
		LoteRecursoDTO loteRecursoDto = ContextoLoteRecurso.fabricarComTodosOsDadosDTO();
		ResultadoValidacaoLoteRecursoDTO resultadoValidacaoLoteRecurso = servicoSisLaraServerRmi
				.validarLoteRecurso(loteRecursoDto);

		Assert.assertTrue(resultadoValidacaoLoteRecurso.sucesso());
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_recurso_disponivel_com_erro() throws RemoteException {
		RecursoDisponivelDTO recursoDisponivelDto = new RecursoDisponivelDTO();
		ResultadoValidacaoRecursoDisponivelDTO resultadoValidacaoLoteRecurso = servicoSisLaraServerRmi
				.validarRecursoDisponivel(recursoDisponivelDto);

		Assert.assertFalse(resultadoValidacaoLoteRecurso.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_recurso_disponivel_sem_erro() throws RemoteException {
		RecursoDisponivelDTO recursoDisponivelDto = ContextoRecursoDisponivel.fabricarComTodosOsDadosDTO();
		ResultadoValidacaoRecursoDisponivelDTO resultadoValidacaoLoteRecurso = servicoSisLaraServerRmi
				.validarRecursoDisponivel(recursoDisponivelDto);

		Assert.assertTrue(resultadoValidacaoLoteRecurso.sucesso());
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_patrocinio_com_erro() throws RemoteException {
		PatrocinioDTO patrocinioDto = new PatrocinioDTO();
		ResultadoValidacaoPatrocinioDTO resultadoValidacaoPatrocinio = servicoSisLaraServerRmi
				.validarPatrocinio(patrocinioDto);

		Assert.assertFalse(resultadoValidacaoPatrocinio.sucesso());
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_validacao_patrocinio_sem_erro() throws RemoteException {
		PatrocinioDTO patrocinioDto = ContextoPatrocinio.criarPatrocinioDto();
		ResultadoValidacaoPatrocinioDTO resultadoValidacaoPatrocinio = servicoSisLaraServerRmi
				.validarPatrocinio(patrocinioDto);

		Assert.assertTrue(resultadoValidacaoPatrocinio.sucesso());
	}
	
	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_efetua_geracao_demanda_cartela_de_selos_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoDemandaDTO especificacaoGeracaoDemandaDTO = ContextoEspecificacaoGeracaoDemanda
				.fabricarDemandaComTodosOsDadosAlternativo();

		String conteudoArquivo = "Conte�do do arquivo.";

		PreCadastroDTO preCadastroDto = ContextoPreCadastro.construirPreCadastroDTO();
		preCadastroDto.getInformacaoEssencialDto().setDataNascimento("27/07/1982");
		especificacaoGeracaoDemandaDTO.setPreCadastrosDto(preCadastroDto);
		especificacaoGeracaoDemandaDTO.setUsuariosDto(null);
		especificacaoGeracaoDemandaDTO.setCartelaDeSelos(true);
		especificacaoGeracaoDemandaDTO.setDocumentosSolicitacaoDocacaoDto(obterTodosDocumentos(conteudoArquivo));

		ResultadoGeracaoDemandaDTO resultadoGeracaoDemanda = servicoSisLaraServerRmi
				.gerarDemanda(especificacaoGeracaoDemandaDTO, resultadoDto.getToken());

		DemandaDTO demandaDtoSalva = resultadoGeracaoDemanda.getObjetosDto().get(0);

		Assert.assertTrue(resultadoGeracaoDemanda.sucesso());
		Assert.assertTrue(demandaDtoSalva.isCartelaDeSelos());
		Assert.assertEquals(demandaDtoSalva.getValorCartela(), "2500,00");
		Assert.assertEquals(demandaDtoSalva.getStatusDemandaDto(), new StatusDemandaDTO(StatusDemanda.AGUARDANDO.toString()));
		for (DocumentoSolicitacaoDoacaoDTO documentoSolicitacaoDoacaoDTO : demandaDtoSalva
				.getDocumentosSolicitacaoDoacaoDto()) {
			ArquivoDTO arquivoDtoSalvo = servicoSisLaraServerRmi.obterArquivoDocumentoSolicitacaoDoacaoDTO(
					demandaDtoSalva, documentoSolicitacaoDoacaoDTO.getArquivoDTO());
			Assert.assertEquals(arquivoDtoSalvo.obterConteudo(), conteudoArquivo.getBytes());
		}
	}
	
	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_geracao_demanda_normal_por_profissional_nao_e_servico_social() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoDemandaDTO especificacaoGeracaoDemandaDTO = ContextoEspecificacaoGeracaoDemanda
				.fabricarDemandaComTodosOsDadosAlternativo();

		String conteudoArquivo = "Conte�do do arquivo.";

		PreCadastroDTO preCadastroDto = ContextoPreCadastro.construirPreCadastroDTO();
		preCadastroDto.getInformacaoEssencialDto().setDataNascimento("27/07/1982");
		especificacaoGeracaoDemandaDTO.setPreCadastrosDto(preCadastroDto);
		especificacaoGeracaoDemandaDTO.setUsuariosDto(null);
		especificacaoGeracaoDemandaDTO.setDocumentosSolicitacaoDocacaoDto(obterTodosDocumentos(conteudoArquivo));

		ResultadoGeracaoDemandaDTO resultadoGeracaoDemanda = servicoSisLaraServerRmi
				.gerarDemanda(especificacaoGeracaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoDemanda.sucesso());
		Assert.assertTrue(resultadoGeracaoDemanda.obterMensagens()
				.contains("Somente profissionais do Servi�o Social podem realizar essa opera��o."));
	}
	
	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_geracao_demanda_normal_de_usuario_interno_sem_dados_obrigatorios() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		Long prontuario = new Long(12345);
		EspecificacaoPesquisaUsuarioDTO especificacaoPesquisaUsuarioDTO = new EspecificacaoPesquisaUsuarioDTO();
		especificacaoPesquisaUsuarioDTO.adicionarParametro(ChavePesquisaDTO.PRONTUARIO, prontuario.toString());
		ResultadoListagemUsuarioDTO resultadoListagemUsuarioDTO = servicoSisLaraServerRmi
				.pesquisarUsuarioPor(especificacaoPesquisaUsuarioDTO);
		
		UsuarioDTO usuarioDTO = (UsuarioDTO) obterDaRelacaoPorId(resultadoListagemUsuarioDTO.getObjetosDto(), prontuario);
		
		EspecificacaoGeracaoDemandaDTO especificacaoGeracaoDemandaDTO = ContextoEspecificacaoGeracaoDemanda
				.fabricarDemandaComTodosOsDadosAlternativo();

		especificacaoGeracaoDemandaDTO.setUsuariosDto(usuarioDTO);

		ResultadoGeracaoDemandaDTO resultadoGeracaoDemanda = servicoSisLaraServerRmi
				.gerarDemanda(especificacaoGeracaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoDemanda.sucesso());
		Assert.assertTrue(resultadoGeracaoDemanda.obterMensagens().contains("Insira o CPF do usu�rio."));
		Assert.assertTrue(resultadoGeracaoDemanda.obterMensagens().contains("Insira o RG do usu�rio."));
		Assert.assertTrue(resultadoGeracaoDemanda.obterMensagens().contains("Insira o email do usu�rio."));
		Assert.assertTrue(resultadoGeracaoDemanda.obterMensagens().contains("Insira o endere�o do usu�rio."));
		Assert.assertTrue(resultadoGeracaoDemanda.obterMensagens()
				.contains("Insira um familiar que � principal respons�vel com CPF, RG e Email."));
	}

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_geracao_demanda_cartela_de_selos_pre_cadastro_duplicado() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoDemandaDTO especificacaoGeracaoDemandaDTO = ContextoEspecificacaoGeracaoDemanda
				.fabricarDemandaComTodosOsDadosAlternativo();

		String conteudoArquivo = "Conte�do do arquivo.";

		PreCadastroDTO preCadastroDto = ContextoPreCadastro.construirPreCadastroDTO();
		preCadastroDto.getInformacaoEssencialDto().setDataNascimento("27/07/1982");
		preCadastroDto.getInformacaoEssencialDto().setCpf("90353388122");
		especificacaoGeracaoDemandaDTO.setPreCadastrosDto(preCadastroDto);
		especificacaoGeracaoDemandaDTO.setUsuariosDto(null);
		especificacaoGeracaoDemandaDTO.setCartelaDeSelos(true);
		especificacaoGeracaoDemandaDTO.setDocumentosSolicitacaoDocacaoDto(obterTodosDocumentos(conteudoArquivo));

		ResultadoGeracaoDemandaDTO resultadoGeracaoDemanda = servicoSisLaraServerRmi
				.gerarDemanda(especificacaoGeracaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoDemanda.sucesso());
		Assert.assertTrue(resultadoGeracaoDemanda.obterMensagens()
				.contains("J� existe uma demanda cadastrada para o CPF selecionado."));
	}

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_geracao_demanda_cartela_de_selos_pre_cadastro_duplicado_legado()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoDemandaDTO especificacaoGeracaoDemandaDTO = ContextoEspecificacaoGeracaoDemanda
				.fabricarDemandaComTodosOsDadosAlternativo();

		String conteudoArquivo = "Conte�do do arquivo.";

		PreCadastroDTO preCadastroDto = ContextoPreCadastro.construirPreCadastroDTO();
		preCadastroDto.getInformacaoEssencialDto().setDataNascimento("27/07/1982");
		preCadastroDto.getInformacaoEssencialDto().setCpf("37925071000105");
		especificacaoGeracaoDemandaDTO.setPreCadastrosDto(preCadastroDto);
		especificacaoGeracaoDemandaDTO.setUsuariosDto(null);
		especificacaoGeracaoDemandaDTO.setCartelaDeSelos(true);
		especificacaoGeracaoDemandaDTO.setDocumentosSolicitacaoDocacaoDto(obterTodosDocumentos(conteudoArquivo));

		ResultadoGeracaoDemandaDTO resultadoGeracaoDemanda = servicoSisLaraServerRmi
				.gerarDemanda(especificacaoGeracaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoDemanda.sucesso());
		Assert.assertTrue(resultadoGeracaoDemanda.obterMensagens()
				.contains("J� existe uma cartela de selos no legado para o CPF selecionado."));
	}

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_geracao_demanda_cartela_de_selos_usuario_duplicado() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoDemandaDTO especificacaoGeracaoDemandaDTO = ContextoEspecificacaoGeracaoDemanda
				.fabricarDemandaComTodosOsDadosAlternativo();

		String conteudoArquivo = "Conte�do do arquivo.";

		especificacaoGeracaoDemandaDTO.setPreCadastrosDto(null);
		especificacaoGeracaoDemandaDTO.setUsuariosDto(ContextoUsuario.construirUsuarioDTO());
		especificacaoGeracaoDemandaDTO.getUsuariosDto().getInformacaoEssencialDto().setCpf("90353388122");
		especificacaoGeracaoDemandaDTO.setCartelaDeSelos(true);
		especificacaoGeracaoDemandaDTO.setDocumentosSolicitacaoDocacaoDto(obterTodosDocumentos(conteudoArquivo));

		ResultadoGeracaoDemandaDTO resultadoGeracaoDemanda = servicoSisLaraServerRmi
				.gerarDemanda(especificacaoGeracaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoDemanda.sucesso());
		Assert.assertTrue(resultadoGeracaoDemanda.obterMensagens()
				.contains("J� existe uma demanda cadastrada para o CPF selecionado."));
	}

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_geracao_demanda_a_partir_de_especificacao_invalida() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoDemandaDTO especificacaoGeracaoDemandaDto = new EspecificacaoGeracaoDemandaDTO();

		ResultadoGeracaoDemandaDTO resultadoGeracaoDemanda = servicoSisLaraServerRmi
				.gerarDemanda(especificacaoGeracaoDemandaDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoDemanda.sucesso());
		Assert.assertFalse(resultadoGeracaoDemanda.obterMensagens().isEmpty());
	}

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_geracao_demanda_sem_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		EspecificacaoGeracaoDemandaDTO especificacaoGeracaoDemandaDto = new EspecificacaoGeracaoDemandaDTO();

		ResultadoGeracaoDemandaDTO resultadoGeracaoDemanda = servicoSisLaraServerRmi
				.gerarDemanda(especificacaoGeracaoDemandaDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoDemanda.sucesso());
		Assert.assertFalse(resultadoGeracaoDemanda.obterMensagens().isEmpty());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_status_de_demanda() throws RemoteException {
		ResultadoListagemStatusDemandaDTO resultadoListagemStatusDemandaDto = servicoSisLaraServerRmi
				.obterListagemStatusDemandaLimitada();

		Assert.assertTrue(resultadoListagemStatusDemandaDto.sucesso());
		Assert.assertFalse(resultadoListagemStatusDemandaDto.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
		Assert.assertEquals(resultadoListagemStatusDemandaDto.getObjetosDto().size(), 3);
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_SEM_BD })
	public void servico_obtem_listagem_status_de_demanda_limitado() throws RemoteException {
		ResultadoListagemStatusDemandaDTO resultadoListagemStatusDemandaDto = servicoSisLaraServerRmi
				.obterListagemStatusDemanda();

		Assert.assertTrue(resultadoListagemStatusDemandaDto.sucesso());
		Assert.assertFalse(resultadoListagemStatusDemandaDto.getObjetosDto().isEmpty(),
				"A lista deveria conter os itens.");
		Assert.assertEquals(resultadoListagemStatusDemandaDto.getObjetosDto().size(), 6);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_consulta_endereco_por_cep_com_sucesso() throws RemoteException {
		ResultadoConsultaCEP resultado = servicoSisLaraServerRmi.consultarEndereco("01151000");

		EnderecoCEPDTO enderecoCEPDTO = (EnderecoCEPDTO) resultado.obterObjetoDtoEditado();
		Assert.assertTrue(resultado.sucesso());
		Assert.assertFalse(resultado.obterMensagens().isEmpty());
		Assert.assertNotNull(enderecoCEPDTO.getPaisDto());
		Assert.assertNotNull(enderecoCEPDTO.getMunicipioDto());
		Assert.assertNotNull(enderecoCEPDTO.getUfDto());
		Assert.assertNotNull(enderecoCEPDTO.getBairro());
		Assert.assertNotNull(enderecoCEPDTO.getEndereco());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_contatos_de_integrantes_do_grupo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		GrupoDTO grupoDto = new GrupoDTO();
		grupoDto.setId(new Long(12222));
		ModuloPeriodoDTO moduloPeriodoDto = new ModuloPeriodoDTO();
		moduloPeriodoDto.setId(new Long(11111));

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioContatosIntegrantesGrupo(grupoDto,
				moduloPeriodoDto, resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[33226]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_lista_frequencia_vertical_por_grupo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		GrupoDTO grupoDto = new GrupoDTO();
		grupoDto.setId(new Long(12222));
		ModuloPeriodoDTO moduloPeriodoDto = new ModuloPeriodoDTO();
		moduloPeriodoDto.setId(new Long(11111));

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioFrequenciaPorGrupo(grupoDto, moduloPeriodoDto,
				false, resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32821]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_lista_frequencia_paisagem_por_grupo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		GrupoDTO grupoDto = new GrupoDTO();
		grupoDto.setId(new Long(12222));
		ModuloPeriodoDTO moduloPeriodoDto = new ModuloPeriodoDTO();
		moduloPeriodoDto.setId(new Long(11111));

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioFrequenciaPorGrupo(grupoDto, moduloPeriodoDto,
				true, resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[34586]));
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_avaliacao_psicossocial() throws Exception {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());
		
		Long prontuario = new Long(12222);
		
		EspecificacaoPesquisaUsuarioDTO especificacao = new EspecificacaoPesquisaUsuarioDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.PRONTUARIO, prontuario.toString());
		ResultadoListagemUsuarioDTO resultadoListagemUsuario = servicoSisLaraServerRmi
				.pesquisarUsuarioPor(especificacao);
		UsuarioDTO usuarioDto = (UsuarioDTO) obterDaRelacaoPorId(
				resultadoListagemUsuario.getObjetosDto(), prontuario);
		usuarioDto.setFoto(FileUtils.readFileToByteArray(new File("src/test/resources/foto_teste_alternativa.jpg")));
		
		servicoSisLaraServerRmi.editarUsuario(usuarioDto, resultadoAutenticacaoPDFDto.getToken());
		
		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioDeAvaliacaoPsicossocial(prontuario,
				resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[28412]));
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_avaliacao_psicossocial_por_falta_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioDeAvaliacaoPsicossocial(new Long(12222),
				resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_porcentagens_frequencia_por_grupo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		GrupoDTO grupoDto = new GrupoDTO();
		grupoDto.setId(new Long(12222));
		ModuloPeriodoDTO moduloPeriodoDto = new ModuloPeriodoDTO();
		moduloPeriodoDto.setId(new Long(11111));

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioPorcentagensFrequenciaPorGrupo(grupoDto,
				moduloPeriodoDto, resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(relatorioPDF.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32649]));
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_porcentagens_frequencia_por_grupo_por_falta_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		GrupoDTO grupoDto = new GrupoDTO();
		grupoDto.setId(new Long(12222));
		ModuloPeriodoDTO moduloPeriodoDto = new ModuloPeriodoDTO();
		moduloPeriodoDto.setId(new Long(11111));

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioPorcentagensFrequenciaPorGrupo(grupoDto,
				moduloPeriodoDto, resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_lista_frequencia_vertical_por_grupo_por_falta_permissao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		GrupoDTO grupoDto = new GrupoDTO();
		grupoDto.setId(new Long(12222));
		ModuloPeriodoDTO moduloPeriodoDto = new ModuloPeriodoDTO();
		moduloPeriodoDto.setId(new Long(11111));

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioFrequenciaPorGrupo(grupoDto, moduloPeriodoDto,
				false, resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_lista_frequencia_paisagem_por_grupo_por_falta_permissao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		GrupoDTO grupoDto = new GrupoDTO();
		grupoDto.setId(new Long(12222));
		ModuloPeriodoDTO moduloPeriodoDto = new ModuloPeriodoDTO();
		moduloPeriodoDto.setId(new Long(11111));

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioFrequenciaPorGrupo(grupoDto, moduloPeriodoDto,
				true, resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_retirada_sem_erro() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		RetiradaDTO retiradaDto = new RetiradaDTO();
		retiradaDto.setProntuario(new Long(12345));
		retiradaDto.setProfissionalDto(ContextoProfissional.construirProfissionalDTO());
		retiradaDto.setVoluntarioDto(ContextoProfissional.construirProfissionalDTOAlternativo());

		ResultadoEdicaoRetiradaDTO resultadoEdicaoRetiradaDto = servicoSisLaraServerRmi.efetuarRetirada(retiradaDto,
				resultadoAutenticacaoDto.getToken());

		Assert.assertTrue(resultadoEdicaoRetiradaDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_retirada_sem_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		RetiradaDTO retiradaDto = new RetiradaDTO();

		ResultadoEdicaoRetiradaDTO resultadoEdicaoRetiradaDto = servicoSisLaraServerRmi.efetuarRetirada(retiradaDto,
				resultadoAutenticacaoDto.getToken());

		Assert.assertFalse(resultadoEdicaoRetiradaDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_retirada_com_erro_de_ja_existencia() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		RetiradaDTO retiradaDto = new RetiradaDTO();
		retiradaDto.setProntuario(new Long(12345));
		retiradaDto.setProfissionalDto(ContextoProfissional.construirProfissionalDTO());
		retiradaDto.setVoluntarioDto(ContextoProfissional.construirProfissionalDTOAlternativo());

		servicoSisLaraServerRmi.efetuarRetirada(retiradaDto, resultadoAutenticacaoDto.getToken());

		ResultadoEdicaoRetiradaDTO resultadoEdicaoRetiradaComErroDto = servicoSisLaraServerRmi
				.efetuarRetirada(retiradaDto, resultadoAutenticacaoDto.getToken());

		Assert.assertFalse(resultadoEdicaoRetiradaComErroDto.sucesso());
		Assert.assertFalse(resultadoEdicaoRetiradaComErroDto.obterMensagens().isEmpty());
		Assert.assertEquals(resultadoEdicaoRetiradaComErroDto.obterMensagens(), "O prontu�rio j� est� retirado. \n");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_retirada_com_erro_de_obritadoriedade() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		RetiradaDTO retiradaDto = new RetiradaDTO();

		ResultadoEdicaoRetiradaDTO resultadoEdicaoRetiradaComErroDto = servicoSisLaraServerRmi
				.efetuarRetirada(retiradaDto, resultadoAutenticacaoDto.getToken());

		Assert.assertFalse(resultadoEdicaoRetiradaComErroDto.sucesso());
		Assert.assertFalse(resultadoEdicaoRetiradaComErroDto.obterMensagens().isEmpty());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_baixa_de_retirada_sem_erro() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ResultadoAutenticacaoDTO resultadoAutenticacaoAlternativaDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoRLemeDtoValida());

		RetiradaDTO retiradaDto = new RetiradaDTO();
		retiradaDto.setProntuario(new Long(12345));
		retiradaDto.setProfissionalDto(ContextoProfissional.construirProfissionalDTO());

		servicoSisLaraServerRmi.efetuarRetirada(retiradaDto, resultadoAutenticacaoDto.getToken());

		ResultadoEdicaoRetiradaDTO resultadoEdicaoBaixaRetiradaDto = servicoSisLaraServerRmi.baixarRetirada(retiradaDto,
				resultadoAutenticacaoAlternativaDto.getToken());

		Assert.assertTrue(resultadoEdicaoBaixaRetiradaDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_baixa_de_retirada_sem_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		RetiradaDTO retiradaDto = new RetiradaDTO();
		retiradaDto.setProntuario(new Long(12345));
		retiradaDto.setProfissionalDto(ContextoProfissional.construirProfissionalDTO());

		ResultadoEdicaoRetiradaDTO resultadoEdicaoBaixaRetiradaDto = servicoSisLaraServerRmi.baixarRetirada(retiradaDto,
				resultadoAutenticacaoDto.getToken());

		Assert.assertFalse(resultadoEdicaoBaixaRetiradaDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_baixa_de_retirada_com_erro_de_ja_existente() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		RetiradaDTO retiradaDto = new RetiradaDTO();
		retiradaDto.setProntuario(new Long(12345));
		retiradaDto.setProfissionalDto(ContextoProfissional.construirProfissionalDTO());

		servicoSisLaraServerRmi.efetuarRetirada(retiradaDto, resultadoAutenticacaoDto.getToken());

		servicoSisLaraServerRmi.baixarRetirada(retiradaDto, resultadoAutenticacaoDto.getToken());

		ResultadoEdicaoRetiradaDTO resultadoEdicaoBaixaRetiradaComErroDto = servicoSisLaraServerRmi
				.baixarRetirada(retiradaDto, resultadoAutenticacaoDto.getToken());

		Assert.assertFalse(resultadoEdicaoBaixaRetiradaComErroDto.sucesso());
		Assert.assertFalse(resultadoEdicaoBaixaRetiradaComErroDto.obterMensagens().isEmpty());
		Assert.assertEquals(resultadoEdicaoBaixaRetiradaComErroDto.obterMensagens(),
				"O prontu�rio n�o est� retirado.\n");
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_cid_a_partir_de_codigo() throws RemoteException {
		String descricao = "A00.1 Colera dev Vibrio cholerae 01 biot El Tor";
		ResultadoConsultaCidDTO resultadoConsultaCidDto = servicoSisLaraServerRmi.consultarCid("A001");

		Assert.assertTrue(resultadoConsultaCidDto.sucesso());
		Assert.assertEquals(resultadoConsultaCidDto.obterObjetoDtoEditado().toString(), descricao);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_obtem_cid_a_partir_de_codigo() throws RemoteException {
		ResultadoConsultaCidDTO resultadoConsultaCidDto = servicoSisLaraServerRmi.consultarCid("A001AAAAA");

		Assert.assertFalse(resultadoConsultaCidDto.sucesso());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_aviso_atualizacao_ativado() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		servicoSisLaraServerRmi.ativarDesativarAvisoDeAtualizacao();

		Assert.assertTrue(servicoSisLaraServerRmi.exibirAvisoDeAtualizacao(resultadoAutenticacaoDto.getToken()));
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_aviso_token_inativo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoAntesDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ResultadoAutenticacaoDTO resultadoAutenticacaoAposDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		Assert.assertFalse(servicoSisLaraServerRmi.tokenAtivo(resultadoAutenticacaoAntesDto.getToken()));
		Assert.assertTrue(servicoSisLaraServerRmi.tokenAtivo(resultadoAutenticacaoAposDto.getToken()));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_aviso_atualizacao_desativado_apos_leitura_aviso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		servicoSisLaraServerRmi.ativarDesativarAvisoDeAtualizacao();

		servicoSisLaraServerRmi.confirmarLeituraDeAvisoDeAtualizacao(resultadoAutenticacaoDto.getToken());

		Assert.assertFalse(servicoSisLaraServerRmi.exibirAvisoDeAtualizacao(resultadoAutenticacaoDto.getToken()));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_aviso_atualizacao_ativado_e_desativado() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		servicoSisLaraServerRmi.ativarDesativarAvisoDeAtualizacao();

		Assert.assertFalse(servicoSisLaraServerRmi.exibirAvisoDeAtualizacao(resultadoAutenticacaoDto.getToken()));
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_efetua_desligamento_automatico_de_usuarios_nos_grupos_ativos() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");

		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222));
		ModuloPeriodoDTO moduloPeriodoDto = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(),
				new Long(11111));
		ModuloUsuarioDTO moduloUsuarioDTO = (ModuloUsuarioDTO) obterDaRelacaoPorId(
				moduloPeriodoDto.getModulosUsuariosDto(), new Long(11111));
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.DESLIGADO.toString()));
		moduloUsuarioDTO.setDataOcorrencia("01/01/2000");

		ResultadoEdicaoModuloPeriodoDTO resultadoEdicaoModuloPeriodoDTO = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoAutenticacaoDto.getToken());

		ResultadoListagemGrupoDTO resultadoListagemGrupoAposDesligamento = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("G06-1");
		GrupoDTO grupoDtoAposDesligamento = (GrupoDTO) obterDaRelacaoPorId(
				resultadoListagemGrupoAposDesligamento.getObjetosDto(), new Long(14444));
		ModuloPeriodoDTO moduloPeriodoDtoAposDesligamento = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoDtoAposDesligamento.getModulosPeriodosDto(), new Long(77777));
		ModuloUsuarioDTO moduloUsuarioDTOAposDesligamento = (ModuloUsuarioDTO) obterDaRelacaoPorId(
				moduloPeriodoDtoAposDesligamento.getModulosUsuariosDto(), new Long(44444));

		Assert.assertTrue(resultadoEdicaoModuloPeriodoDTO.sucesso());
		Assert.assertEquals(moduloUsuarioDTOAposDesligamento.getStatusDto().toString(),
				StatusRelacaoComModulo.DESLIGADO.toString());
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_efetua_integracao_comunidade_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");

		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222));
		ModuloPeriodoDTO moduloPeriodoDto = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(),
				new Long(11111));

		ModuloPreCadastroDTO moduloPreCadastroDTO = ContextoModuloPreCadastro.fabricarModuloPreCadastroDTO();
		moduloPreCadastroDTO.setPreCadastroDto(ContextoPreCadastro.construirPreCadastroDTOAlternativo());
		moduloPreCadastroDTO.setStatusDto(null);
		List<ModuloPreCadastroDTO> modulosPreCadastro = new ArrayList<ModuloPreCadastroDTO>();
		modulosPreCadastro.add(moduloPreCadastroDTO);

		moduloPeriodoDto.setModulosUsuariosDto(new ArrayList<>());
		moduloPeriodoDto.setModulosPreCadastroDto(modulosPreCadastro);

		ResultadoEdicaoModuloPeriodoDTO resultadoEdicaoModuloPeriodoDTO = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoAutenticacaoDto.getToken());

		ModuloPreCadastroDTO moduloPreCadastroDTOAposInclusao = obterAtendimentoDoUsuarioPeloPreCadastro(
				((ModuloPeriodoDTO) resultadoEdicaoModuloPeriodoDTO.obterObjetoDtoEditado()).getModulosPreCadastroDto(),
				ContextoPreCadastro.construirPreCadastroDTOAlternativo().getId());

		Assert.assertTrue(resultadoEdicaoModuloPeriodoDTO.sucesso());
		Assert.assertEquals(moduloPreCadastroDTOAposInclusao.getStatusDto().toString(),
				StatusRelacaoComModulo.INTEGRADO.toString());
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_efetua_integracao_em_grupo_de_reuniao_de_integracao_a_parir_de_usuario_integrado_com_opcao_ignorar_reuniao_de_integracao_selecionado()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaShivas());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G08-1");
		
		ModuloPeriodoDTO moduloPeriodoDtoSS1Antes = obterModuloPeriodoDto(
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("SS-1").getObjetosDto(), new Long(66666),
				new Long(99999));
		
		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(15555));
		ModuloPeriodoDTO moduloPeriodoDto = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(),
				new Long(12345));
		ModuloUsuarioDTO moduloUsuarioDTO = ContextoModuloUsuario.fabricarModuloUsuarioAlternativoBDTO();
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.INTEGRADO.toString()));
		moduloUsuarioDTO.setIgnorarRegraDeReuniaoDeIntegracao(true);
		moduloPeriodoDto.getModulosUsuariosDto().add(moduloUsuarioDTO);

		ResultadoEdicaoModuloPeriodoDTO resultadoEdicaoModuloPeriodoDTO = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoAutenticacaoDto.getToken());
		Registro.obterAutomatizadorPendencia().atualizarPendencias();

		ModuloPeriodoDTO moduloPeriodoDtoSS1Depois = obterModuloPeriodoDto(
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("SS-1").getObjetosDto(), new Long(66666),
				new Long(99999));

		Assert.assertTrue(resultadoEdicaoModuloPeriodoDTO.sucesso());
		// Aplicou uma integra��es automaticas em RI e ignorou uma.
		Assert.assertTrue(moduloPeriodoDtoSS1Antes.getModulosUsuariosDto().isEmpty());
		Assert.assertEquals(moduloPeriodoDtoSS1Depois.getModulosUsuariosDto().size(), 1);
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_efetua_integracao_em_grupo_de_reuniao_de_integracao_a_partir_de_grupo_excepcional()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("CL-1");

		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(888888));
		ModuloPeriodoDTO moduloPeriodoDto = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(),
				new Long(888888));
		ModuloUsuarioDTO moduloUsuarioDTO = ContextoModuloUsuario.fabricarModuloUsuarioAlternativoDTO();
		moduloUsuarioDTO.setId(null);
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.EVENTUAL.toString()));
		moduloUsuarioDTO.setIgnorarRegraDeReuniaoDeIntegracao(true);
		moduloPeriodoDto.setModulosUsuariosDto(Arrays.asList(moduloUsuarioDTO));

		ResultadoEdicaoModuloPeriodoDTO resultadoEdicaoModuloPeriodoDTO = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoAutenticacaoDto.getToken());
		Registro.obterAutomatizadorPendencia().atualizarPendencias();

		ModuloPeriodoDTO moduloPeriodoDtoSS1 = obterModuloPeriodoDto(
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("SS-1").getObjetosDto(), new Long(66666),
				new Long(99999));

		Assert.assertTrue(resultadoEdicaoModuloPeriodoDTO.sucesso());
		Assert.assertEquals(moduloPeriodoDtoSS1.getModulosUsuariosDto().size(), 0);
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_efetua_integracao_em_grupo_ose() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("OSE-1");

		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(821582));
		ModuloPeriodoDTO moduloPeriodoDto = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(),
				new Long(821582));
		ModuloUsuarioDTO moduloUsuarioDTO = ContextoModuloUsuario.fabricarModuloUsuarioDTO();
		moduloUsuarioDTO.setId(null);
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.INTEGRADO.toString()));
		moduloPeriodoDto.setModulosUsuariosDto(Arrays.asList(moduloUsuarioDTO));

		ResultadoEdicaoModuloPeriodoDTO resultadoEdicaoModuloPeriodoDTO = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoAutenticacaoDto.getToken());

		Assert.assertFalse(resultadoEdicaoModuloPeriodoDTO.sucesso());
		Assert.assertEquals(resultadoEdicaoModuloPeriodoDTO.obterMensagens().trim(),
				"N�o � poss�vel existir um usu�rio INTEGRADO em grupos OSE ou CL.");
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_atualiza_status_relacao_psicossocial_para_provisorio_devido_alteracao_para_status_no_aee_para_provisorio()
			throws RemoteException {
		ModuloUsuarioDTO moduloUsuarioDTOAposAtualizacao = servico_atualiza_status_de_relacao_do_aee_e_retorna_o_psicossocial_do_grupo(
				StatusRelacaoComModulo.PROVISORIO);

		Assert.assertTrue(moduloUsuarioDTOAposAtualizacao.getStatusDto().toString()
				.equals(StatusRelacaoComModulo.PROVISORIO.toString()));
		Assert.assertEquals(moduloUsuarioDTOAposAtualizacao.getObs(),
				"Status alterado automaticamente pelo sistema. \nObs do modulo original: \nTexto de OBS.");
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_atualiza_status_relacao_psicossocial_para_integrado_devido_alteracao_para_status_no_aee_para_acesso()
			throws RemoteException {
		ModuloUsuarioDTO moduloUsuarioDTOAposAtualizacao = servico_atualiza_status_de_relacao_do_aee_e_retorna_o_psicossocial_do_grupo(
				StatusRelacaoComModulo.ACESSO);

		Assert.assertTrue(moduloUsuarioDTOAposAtualizacao.getStatusDto().toString()
				.equals(StatusRelacaoComModulo.INTEGRADO.toString()));
		Assert.assertEquals(moduloUsuarioDTOAposAtualizacao.getObs(),
				"Status alterado automaticamente pelo sistema. \nObs do modulo original: \nTexto de OBS.");
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_atualiza_status_relacao_psicossocial_para_integrado_devido_alteracao_para_status_no_aee_para_integrado()
			throws RemoteException {
		ModuloUsuarioDTO moduloUsuarioDTOAposAtualizacao = servico_atualiza_status_de_relacao_do_aee_e_retorna_o_psicossocial_do_grupo(
				StatusRelacaoComModulo.INTEGRADO);

		Assert.assertTrue(moduloUsuarioDTOAposAtualizacao.getStatusDto().toString()
				.equals(StatusRelacaoComModulo.INTEGRADO.toString()));
		Assert.assertEquals(moduloUsuarioDTOAposAtualizacao.getObs(),
				"Status alterado automaticamente pelo sistema. \nObs do modulo original: \nTexto de OBS.");
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_incluir_status_provisorio_na_relacao_com_psicossocial_devido_inclusao_de_usuario_com_status_de_relacao_provisorio_no_aee()
			throws RemoteException {
		ModuloUsuarioDTO moduloUsuarioDTOAposAtualizacao = servico_inclui_usuario_com_status_de_relacao_no_aee_e_retorna_o_psicossocial_do_grupo(
				StatusRelacaoComModulo.PROVISORIO);

		Assert.assertTrue(moduloUsuarioDTOAposAtualizacao.getStatusDto().toString()
				.equals(StatusRelacaoComModulo.PROVISORIO.toString()));
		Assert.assertEquals(moduloUsuarioDTOAposAtualizacao.getObs(),
				"Status alterado automaticamente pelo sistema. \nObs do modulo original: \nA analisar.");
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_incluir_status_integrado_na_relacao_com_psicossocial_devido_inclusao_de_usuario_com_status_de_relacao_acesso_no_aee()
			throws RemoteException {
		ModuloUsuarioDTO moduloUsuarioDTOAposAtualizacao = servico_inclui_usuario_com_status_de_relacao_no_aee_e_retorna_o_psicossocial_do_grupo(
				StatusRelacaoComModulo.ACESSO);

		Assert.assertTrue(moduloUsuarioDTOAposAtualizacao.getStatusDto().toString()
				.equals(StatusRelacaoComModulo.INTEGRADO.toString()));
		Assert.assertEquals(moduloUsuarioDTOAposAtualizacao.getObs(),
				"Status alterado automaticamente pelo sistema. \nObs do modulo original: \nA analisar.");
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_incluir_status_integrado_na_relacao_com_psicossocial_devido_inclusao_de_usuario_com_status_de_relacao_integrado_no_aee()
			throws RemoteException {
		ModuloUsuarioDTO moduloUsuarioDTOAposAtualizacao = servico_inclui_usuario_com_status_de_relacao_no_aee_e_retorna_o_psicossocial_do_grupo(
				StatusRelacaoComModulo.INTEGRADO);

		Assert.assertTrue(moduloUsuarioDTOAposAtualizacao.getStatusDto().toString()
				.equals(StatusRelacaoComModulo.INTEGRADO.toString()));
		Assert.assertEquals(moduloUsuarioDTOAposAtualizacao.getObs(),
				"Status alterado automaticamente pelo sistema. \nObs do modulo original: \nA analisar.");
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_nao_inativa_grupo_por_causa_de_existencia_de_usuario_com_status_de_relacao_provisorio()
			throws RemoteException {
		ResultadoEdicaoGrupoDTO resultadoEdicaoGrupoDTO = servico_tenta_desativar_grupo_com_usuarios_no_status(
				StatusRelacaoComModulo.PROVISORIO);

		Assert.assertFalse(resultadoEdicaoGrupoDTO.sucesso());
		Assert.assertEquals(resultadoEdicaoGrupoDTO.obterMensagens(),
				"Existe pelo menos um usu�rio com status Provis�rio ou Acesso.\n\n");
	}

	@Test(groups = { TiposDeTeste.GRUPO })
	public void servico_nao_inativa_grupo_por_causa_de_existencia_de_usuario_com_status_de_relacao_acesso()
			throws RemoteException {
		ResultadoEdicaoGrupoDTO resultadoEdicaoGrupoDTO = servico_tenta_desativar_grupo_com_usuarios_no_status(
				StatusRelacaoComModulo.ACESSO);

		Assert.assertFalse(resultadoEdicaoGrupoDTO.sucesso());
		Assert.assertEquals(resultadoEdicaoGrupoDTO.obterMensagens(),
				"Existe pelo menos um usu�rio com status Provis�rio ou Acesso.\n\n");
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_gera_atendimento_retornando_nome_de_usuarios_com_status_de_relacao_provisorio_ou_acesso()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaShivas());

		ResultadoListagemGrupoDTO resultadoListagemGrupoAEEPisico = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("G08-1");

		GrupoDTO grupoAeePisicoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupoAEEPisico.getObjetosDto(),
				new Long(15555));

		ModuloPeriodoDTO moduloPeriodoAEEDto = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoAeePisicoDto.getModulosPeriodosDto(), new Long(12345));

		ModuloUsuarioDTO moduloUsuarioDTO = (ModuloUsuarioDTO) obterDaRelacaoPorId(
				moduloPeriodoAEEDto.getModulosUsuariosDto(), new Long(12345));
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.ACESSO.toString()));
		moduloUsuarioDTO.setDataOcorrencia("01/01/2000");

		servicoSisLaraServerRmi.editarModuloPeriodo(moduloPeriodoAEEDto, resultadoDto.getToken());

		EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentosDTO = new EspecificacaoGeracaoAtendimentoDTO(
				((ModuloPeriodoDTO) obterDaRelacaoPorId(grupoAeePisicoDto.getModulosPeriodosDto(), new Long(12345)))
						.getId(), "01/01/2000", new HorarioDTO("08:00", "10:00"));

		ResultadoGeracaoAtendimentoDTO resultadoGeracaoAtendimento = servicoSisLaraServerRmi
				.gerarAtendimentos(especificacaoGeracaoAtendimentosDTO, resultadoDto.getToken());
		
		AtendimentoGrupoDTO atendimentoGrupoDTO = (AtendimentoGrupoDTO)resultadoGeracaoAtendimento.obterObjetoDtoEditado();
		atendimentoGrupoDTO.setData("31/12/2012");
		atendimentoGrupoDTO.setHorarioDto(new HorarioDTO("09:00", "19:00"));

		ResultadoEdicaoAtendimentoGrupoDTO resultadoEdicaoAtendimentoGrupoDTO = servicoSisLaraServerRmi
				.editarAtendimentoGrupo(resultadoGeracaoAtendimento.getModuloPeriodoDTO(), atendimentoGrupoDTO,
						resultadoDto.getToken());
		
		Assert.assertTrue(resultadoGeracaoAtendimento.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoGrupoDTO.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoGrupoDTO.obterMensagens().contains(
				"Dados armazenados com sucesso."));
		Assert.assertTrue(resultadoEdicaoAtendimentoGrupoDTO.obterMensagens().contains(
				"<br>Usu�rio(s) com status PROVIS�RIO ou ACESSO no m�dulo:<br>16666 - Josep Meaza<br>"));
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_edita_atendimento_de_grupo_com_sucesso()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupoAEE = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("G02-1");

		GrupoDTO grupoAeeDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupoAEE.getObjetosDto(),
				new Long(12222));

		ModuloPeriodoDTO moduloPeriodoAEEDto = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoAeeDto.getModulosPeriodosDto(), new Long(11111));

		AtendimentoGrupoDTO atendimentoGrupoDTO = (AtendimentoGrupoDTO) obterDaRelacaoPorId(
				moduloPeriodoAEEDto.getAtendimentosGrupoDto(), new Long(11111));

		ResultadoEdicaoAtendimentoGrupoDTO resultadoEdicaoAtendimentoGrupoDTO = servicoSisLaraServerRmi
				.editarAtendimentoGrupo(moduloPeriodoAEEDto, atendimentoGrupoDTO, resultadoDto.getToken());

		Assert.assertTrue(resultadoEdicaoAtendimentoGrupoDTO.obterMensagens().contains(
				"Dados armazenados com sucesso."));
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_edita_atendimento_de_grupo_com_erro_horario_personalizado_de_profissional_incompativel()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupoAEE = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("G02-1");

		GrupoDTO grupoAeeDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupoAEE.getObjetosDto(),
				new Long(12222));

		ModuloPeriodoDTO moduloPeriodoAEEDto = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoAeeDto.getModulosPeriodosDto(), new Long(11111));

		AtendimentoGrupoDTO atendimentoGrupoDTO = (AtendimentoGrupoDTO) obterDaRelacaoPorId(
				moduloPeriodoAEEDto.getAtendimentosGrupoDto(), new Long(11111));
		
		AtendimentoProfissionalDTO atendimentoProfissionalDTO = (AtendimentoProfissionalDTO) obterDaRelacaoPorId(
				atendimentoGrupoDTO.getAtendimentosProfissionaisDto(), new Long(12222));
		atendimentoProfissionalDTO.setHorarioDto(new HorarioDTO("11:10", "22:23"));
		
		ResultadoEdicaoAtendimentoGrupoDTO resultadoEdicaoAtendimentoGrupoDTO = servicoSisLaraServerRmi
				.editarAtendimentoGrupo(moduloPeriodoAEEDto, atendimentoGrupoDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoGrupoDTO.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoGrupoDTO.obterMensagens().contains(
				"N�o � poss�vel incluir um hor�rio personalizado incompat�vel com o hor�rio de atendimento do grupo."));
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_edita_atendimento_de_grupo_com_erro_horario_personalizado_de_profissional_identico_ao_horario_do_grupo()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupoAEE = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("G02-1");

		GrupoDTO grupoAeeDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupoAEE.getObjetosDto(),
				new Long(12222));

		ModuloPeriodoDTO moduloPeriodoAEEDto = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoAeeDto.getModulosPeriodosDto(), new Long(11111));

		AtendimentoGrupoDTO atendimentoGrupoDTO = (AtendimentoGrupoDTO) obterDaRelacaoPorId(
				moduloPeriodoAEEDto.getAtendimentosGrupoDto(), new Long(11111));
		
		AtendimentoProfissionalDTO atendimentoProfissionalDTO = (AtendimentoProfissionalDTO) obterDaRelacaoPorId(
				atendimentoGrupoDTO.getAtendimentosProfissionaisDto(), new Long(12222));
		atendimentoProfissionalDTO.setHorarioDto(new HorarioDTO("11:11", "22:22"));
		
		ResultadoEdicaoAtendimentoGrupoDTO resultadoEdicaoAtendimentoGrupoDTO = servicoSisLaraServerRmi
				.editarAtendimentoGrupo(moduloPeriodoAEEDto, atendimentoGrupoDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoGrupoDTO.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoGrupoDTO.obterMensagens().contains(
				"N�o � poss�vel incluir um hor�rio personalizado id�ntico ao hor�rio de atendimento do grupo."));
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_edita_atendimento_de_grupo_com_erro_de_data_e_horario_invalidos()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupoAEE = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("G02-1");

		MaquinaTempo.mudarDataAtual("01/01/2016");
		
		GrupoDTO grupoAeeDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupoAEE.getObjetosDto(),
				new Long(12222));

		ModuloPeriodoDTO moduloPeriodoAEEDto = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoAeeDto.getModulosPeriodosDto(), new Long(11111));

		AtendimentoGrupoDTO atendimentoGrupoDTO = (AtendimentoGrupoDTO) obterDaRelacaoPorId(
				moduloPeriodoAEEDto.getAtendimentosGrupoDto(), new Long(11111));
		atendimentoGrupoDTO.setData("99/99/9999");
		atendimentoGrupoDTO.setHorarioDto(new HorarioDTO("99:99", "99:99"));

		ResultadoEdicaoAtendimentoGrupoDTO resultadoEdicaoAtendimentoGrupoDTO = servicoSisLaraServerRmi
				.editarAtendimentoGrupo(moduloPeriodoAEEDto, atendimentoGrupoDTO, resultadoDto.getToken());
		
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertFalse(resultadoEdicaoAtendimentoGrupoDTO.sucesso());
		Assert.assertTrue(
				resultadoEdicaoAtendimentoGrupoDTO.obterMensagens().contains("Insira uma Data de Atendimento v�lida."));
		Assert.assertTrue(
				resultadoEdicaoAtendimentoGrupoDTO.obterMensagens().contains("Insira uma Hora de In�cio v�lida."));
		Assert.assertTrue(
				resultadoEdicaoAtendimentoGrupoDTO.obterMensagens().contains("Insira uma Hora de T�rmino v�lida."));
		Assert.assertTrue(resultadoEdicaoAtendimentoGrupoDTO.obterMensagens()
				.contains("Insira uma data igual ou anterior ao dia de hoje."));
	}

	@Test(groups = {TiposDeTeste.ESPERA })
	public void servico_nao_inclui_espera_por_excesso_de_faltas_acarretada_mais_de_uma_vez_por_conjunto_de_faltas_nao_justificadas()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		Long prontuario = new Long(13333);
		servico_cria_tres_atendimentos_individuais_com_frequencia_fu_em_dias_diferentes(resultadoDto, prontuario);

		EspecificacaoPesquisaEsperaDTO especificacaoPesquisaEsperaDto = ContextoEspecificacaoPesquisaEspera
				.fabricarDtoPesquisaEsperaDescricaoServicoSocialModuloExcessoDeFaltas(prontuario);

		ResultadoListagemEsperaDTO resultadoListagemEsperaDto = servicoSisLaraServerRmi
				.obterListagemEspera(especificacaoPesquisaEsperaDto);

		EsperaDTO esperaDto = resultadoListagemEsperaDto.getObjetosDto().get(0);
		esperaDto.setStatusDto(new StatusEsperaDTO("CANCELADO"));
		esperaDto.setJustificativaCancelamento("Justificativa do cancelamento.");

		servicoSisLaraServerRmi.cancelarEspera(esperaDto, resultadoDto.getToken());

		EspecificacaoPesquisaAtendimentoIndividualDTO especificacaoPesquisaAtendimentoIndividualDto = new EspecificacaoPesquisaAtendimentoIndividualDTO();
		especificacaoPesquisaAtendimentoIndividualDto.setProntuario(prontuario.toString());
		especificacaoPesquisaAtendimentoIndividualDto.setDataInicio("03/03/2017");
		ResultadoListagemAtendimentoIndividualDTO listagemAtendimentoIndividual = servicoSisLaraServerRmi
				.obterListagemAtendimentoIndividual(especificacaoPesquisaAtendimentoIndividualDto);
		AtendimentoIndividualDTO atendimentoIndividualDTO = listagemAtendimentoIndividual.getObjetosDto().get(0);
		atendimentoIndividualDTO.getInformacaoAtendimentoDto().setDescricao("Texto de descricao do atendiemtno");
		ResultadoEdicaoAtendimentoIndividualDTO editarAtendimentoIndividual = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDTO, resultadoDto.getToken());

		ResultadoListagemEsperaDTO resultadoListagemEsperaAposTentativaDeReenvioDto = servicoSisLaraServerRmi
				.obterListagemEspera(especificacaoPesquisaEsperaDto);

		Assert.assertTrue(editarAtendimentoIndividual.sucesso());
		Assert.assertTrue(resultadoListagemEsperaAposTentativaDeReenvioDto.getObjetosDto().isEmpty());
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_quantidades_avaliacoes_funcionais() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioQuantidadesAvaliacoesFuncionais("01/01/2015",
				"31/12/2015", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertTrue(variacaoMaximaDeBytes(relatorioPDF.obterConteudo(), new byte[32800]));
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_de_quantidades_avaliacoes_funcionais() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoPDFDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioPDF = servicoSisLaraServerRmi.gerarRelatorioQuantidadesAvaliacoesFuncionais("01/01/2015",
				"31/12/2015", resultadoAutenticacaoPDFDto.getToken());

		Assert.assertFalse(relatorioPDF.sucesso());
		Assert.assertNotNull(relatorioPDF.obterMensagens());
	}

	@Test(groups = { TiposDeTeste.PENDENCIA })
	public void servico_associa_pendencias_aos_profissionais_vinculados_ao_usuario_apos_regra_de_envio_para_espera_por_excesso_de_faltas_no_atendimento_de_grupo()
			throws RemoteException {
		ResultadoAutenticacaoDTO contaAcessoPbandeiraDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());
		ResultadoAutenticacaoDTO contaAcessoAdailzaDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaAdailza());
		
		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222));
		Long prontuario = new Long(72222); 

		servico_gera_tres_atendimentos_de_grupo_com_datas_diferentes_e_altera_a_frenquencia_do_prontuario_para_fu(
				grupoDto, new Long(11111), contaAcessoPbandeiraDto, prontuario);

		ResultadoListagemPendenciaDTO resultadoListagemPendenciaPBandeiraDTO = servicoSisLaraServerRmi
				.obterListagemPendencia(contaAcessoPbandeiraDto.getToken());
		ResultadoListagemPendenciaDTO resultadoListagemPendenciaAdailzaDTO = servicoSisLaraServerRmi
				.obterListagemPendencia(contaAcessoAdailzaDto.getToken());
		
		Assert.assertTrue(contem(resultadoListagemPendenciaAdailzaDTO.getObjetosDto(),
				"(IMPORTANTE)Prontu�rio 72222 foi enviado para a lista de espera do SS por excesso de faltas."));
		Assert.assertTrue(contem(resultadoListagemPendenciaPBandeiraDTO.getObjetosDto(),
				"(IMPORTANTE)Prontu�rio 72222 foi enviado para a lista de espera do SS por excesso de faltas."));
	}

	@Test(groups = { TiposDeTeste.PENDENCIA })
	public void servico_associa_pendencias_aos_profissionais_vinculados_ao_usuario_apos_regra_de_envio_para_espera_por_excesso_de_faltas_no_atendimento_individual()
			throws RemoteException {
		ResultadoAutenticacaoDTO contaAcessoPBandeiraDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());
		ResultadoAutenticacaoDTO contaAcessoVPereiraDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaVeraPereira());
		ResultadoAutenticacaoDTO contaAcessoAdailzaDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaAdailza());

		Long prontuario = new Long(72222);

		AtendimentoProfissionalDTO atendimentoProfissionalDTO = ContextoAtendimentoProfissional
				.construirAtendimentoProfissionalDTO();
		atendimentoProfissionalDTO.setProfissionalDto(ContextoProfissional.construirProfissionalVPereiraDTO());

		servico_cria_tres_atendimentos_individuais_com_frequencia_fu_em_dias_diferentes_adicionando_profissional(
				contaAcessoVPereiraDto, prontuario, atendimentoProfissionalDTO);

		ResultadoListagemPendenciaDTO resultadoListagemPendenciaVPereiraDTO = servicoSisLaraServerRmi
				.obterListagemPendencia(contaAcessoVPereiraDto.getToken());
		ResultadoListagemPendenciaDTO resultadoListagemPendenciaPBandeiraDTO = servicoSisLaraServerRmi
				.obterListagemPendencia(contaAcessoPBandeiraDto.getToken());
		ResultadoListagemPendenciaDTO resultadoListagemPendenciaAdailzaDTO = servicoSisLaraServerRmi
				.obterListagemPendencia(contaAcessoAdailzaDto.getToken());
		Assert.assertTrue(contem(resultadoListagemPendenciaAdailzaDTO.getObjetosDto(),
				"(IMPORTANTE)Prontu�rio 72222 foi enviado para a lista de espera do SS por excesso de faltas."));
		Assert.assertTrue(contem(resultadoListagemPendenciaPBandeiraDTO.getObjetosDto(),
				"(IMPORTANTE)Prontu�rio 72222 foi enviado para a lista de espera do SS por excesso de faltas."));
		Assert.assertTrue(resultadoListagemPendenciaVPereiraDTO.getObjetosDto().isEmpty());
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_efetua_transferencias_de_usuarios_com_fu_e_fj_para_outros_grupos_de_reuniao_de_integracao_e_envia_para_lista_de_espera_por_excesso_de_faltas_quando_necessario()
			throws RemoteException {
		ResultadoAutenticacaoDTO contaAcessoVPereiraDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaVeraPereira());
		
		ResultadoAutenticacaoDTO resultadoPBandeiraDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());
		
		MaquinaTempo.mudarDataAtual("01/01/2016");

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		GrupoDTO grupoDTO = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222));
		ModuloPeriodoDTO moduloPeriodoDTO = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoDTO.getModulosPeriodosDto(),
				new Long(11111));
		ModuloUsuarioDTO moduloUsuarioDTO = (ModuloUsuarioDTO) obterDaRelacaoPorId(
				moduloPeriodoDTO.getModulosUsuariosDto(), new Long(11111));
		Long prontuario = new Long(72222);
		UsuarioDTO usuarioDto = moduloUsuarioDTO.getUsuarioDto();
		usuarioDto.setId(prontuario);
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO("ACESSO"));
		servicoSisLaraServerRmi.editarModuloPeriodo(moduloPeriodoDTO, resultadoPBandeiraDto.getToken());
		Registro.obterAutomatizadorPendencia().atualizarPendencias();

		String dataA = "01/01/2100";
		MaquinaTempo.mudarDataAtual(dataA);
		ResultadoEdicaoAtendimentoGrupoDTO resultadoEdicaoAtendimentoGrupo = gerar_atendimento_de_grupo_com_frequencia_fu(
				contaAcessoVPereiraDto, "SS-1", new Long(66666), new Long(99999), dataA, prontuario);
		ResultadoListagemPendenciaDTO resultadoListagemPendenciaAntesDaTranferenciaDTO = servicoSisLaraServerRmi
				.obterListagemPendencia(contaAcessoVPereiraDto.getToken());
		Registro.obterAutomatizadorPendencia().atualizarPendenciasDeTransferenciasDeReuniaoIntegracao();
		String dataB = "31/12/2100";
		MaquinaTempo.mudarDataAtual(dataB);
		gerar_atendimento_de_grupo_com_frequencia_fu(contaAcessoVPereiraDto, "SS-2", new Long(77777), new Long(44444),
				dataB, prontuario);
		Registro.obterAutomatizadorPendencia().atualizarPendenciasDeTransferenciasDeReuniaoIntegracao();
		String dataC = "01/01/2150";
		MaquinaTempo.mudarDataAtual(dataC);
		gerar_atendimento_de_grupo_com_frequencia_fu(contaAcessoVPereiraDto, "SS-5", new Long(54321), new Long(54321),
				dataC, prontuario);
		Registro.obterAutomatizadorPendencia().atualizarPendenciasDeTransferenciasDeReuniaoIntegracao();
		MaquinaTempo.restaurarDataOriginal();

		ModuloUsuarioDTO moduloUsuarioDtoSS1 = obterPeloIdUsuario(
				obterModuloPeriodoDto(servicoSisLaraServerRmi.obterListagemGrupoAtivo("SS-1").getObjetosDto(),
						new Long(66666), new Long(99999)),
				usuarioDto);

		ModuloUsuarioDTO moduloUsuarioDtoSS2 = obterPeloIdUsuario(
				obterModuloPeriodoDto(servicoSisLaraServerRmi.obterListagemGrupoAtivo("SS-2").getObjetosDto(),
						new Long(77777), new Long(44444)),
				usuarioDto);

		ModuloUsuarioDTO moduloUsuarioDtoSS5 = obterPeloIdUsuario(
				obterModuloPeriodoDto(servicoSisLaraServerRmi.obterListagemGrupoAtivo("SS-5").getObjetosDto(),
						new Long(54321), new Long(54321)),
				usuarioDto);

		ModuloPeriodoDTO moduloPeriodoDtoSS6 = obterModuloPeriodoDto(
				servicoSisLaraServerRmi.obterListagemGrupoAtivo("SS-6").getObjetosDto(), new Long(654321),
				new Long(654321));

		ResultadoListagemPendenciaDTO resultadoListagemPendenciaPBandeiraDTO = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoPBandeiraDto.getToken());

		Assert.assertTrue(contem(resultadoListagemPendenciaAntesDaTranferenciaDTO.getObjetosDto(),
				"Reuni�o de integra��o do Prontu�rio 72222 ser� transferida para outro grupo dispon�vel."));
		Assert.assertTrue(
				moduloUsuarioDtoSS1.getStatusDto().toString().equals(StatusRelacaoComModulo.REMOVIDO.toString()));
		Assert.assertTrue(moduloUsuarioDtoSS1.getObs().contains(
				"Removido automaticamente para outro grupo de Reuni�o de Integra��o por consequ�ncia de falta no grupo original. Data da remo��o: 01/01/2100"));
		Assert.assertTrue(
				moduloUsuarioDtoSS2.getStatusDto().toString().equals(StatusRelacaoComModulo.REMOVIDO.toString()));
		Assert.assertTrue(moduloUsuarioDtoSS2.getObs().contains(
				"Removido automaticamente para outro grupo de Reuni�o de Integra��o por consequ�ncia de falta no grupo original. Data da remo��o: 31/12/2100"));
		Assert.assertTrue(
				moduloUsuarioDtoSS5.getStatusDto().toString().equals(StatusRelacaoComModulo.REMOVIDO.toString()));
		Assert.assertTrue(moduloUsuarioDtoSS5.getObs()
				.contains("Removido automaticamente por Excesso de Faltas. Data da remo��o: 01/01/2150"));
		Assert.assertTrue(moduloPeriodoDtoSS6.getModulosUsuariosDto().isEmpty(), "Deveria conter rela��o vazia.");
		Assert.assertTrue(contem(resultadoListagemPendenciaPBandeiraDTO.getObjetosDto(),
				"(IMPORTANTE)Prontu�rio 72222 foi enviado para a lista de espera do SS por excesso de faltas."));
		Assert.assertTrue(resultadoEdicaoAtendimentoGrupo.sucesso());
	}

	@Test(groups = { TiposDeTeste.PENDENCIA })
	public void servico_gera_pendencia_por_excesso_de_faltas_somente_para_os_profissionais_do_grupo_ao_aqual_o_usuario_esta_integrado_apos_atendimento_individual_com_fu()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoVpereiraDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaVeraPereira());
		ResultadoAutenticacaoDTO resultadoPbandeiraDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());
		
		MaquinaTempo.mudarDataAtual("01/01/2117");
		Long prontuario = new Long(12222);

		ResultadoListagemPendenciaDTO resultadoListagemPendenciaPBandeiraDTOAntes = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoPbandeiraDto.getToken());

		AtendimentoProfissionalDTO atendimentoProfissionalDTO = ContextoAtendimentoProfissional
				.construirAtendimentoProfissionalDTO();
		atendimentoProfissionalDTO.setProfissionalDto(ContextoProfissional.construirProfissionalVPereiraDTO());

		servico_cria_tres_atendimentos_individuais_com_frequencia_fu_em_dias_diferentes_adicionando_profissional(
				resultadoVpereiraDto, prontuario, atendimentoProfissionalDTO);

		ResultadoListagemPendenciaDTO resultadoListagemPendenciaVPereiraDTO = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoVpereiraDto.getToken());
		
		ResultadoListagemPendenciaDTO resultadoListagemPendenciaPBandeiraDTOAPos = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoPbandeiraDto.getToken());
		
		EspecificacaoPesquisaEsperaDTO especificacao = new EspecificacaoPesquisaEsperaDTO();
		especificacao.setProntuario(prontuario.toString());
		especificacao.setInteresse(false);
		especificacao.setLmLigou(false);
		especificacao.setPendencias(false);
		especificacao
				.setDescricaoTipoAtendimentoDto(ContextoDescricaoTipoAtendimento.construirDescricaoServicoSocialDTO());
		especificacao.setModuloDto(ContextoModulo.construirModuloExcessoDeFaltasDTO());
		ResultadoListagemEsperaDTO resultadoListagemEsperaDTO = servicoSisLaraServerRmi
				.obterListagemEspera(especificacao);
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertEquals(resultadoListagemPendenciaPBandeiraDTOAntes.getObjetosDto().size(), 2);
		Assert.assertEquals(resultadoListagemPendenciaPBandeiraDTOAPos.getObjetosDto().size(), 3);
		Assert.assertTrue(contem(resultadoListagemPendenciaPBandeiraDTOAPos.getObjetosDto(),
				"(IMPORTANTE)Prontu�rio 12222 foi enviado para a lista de espera do SS por excesso de faltas."));
		Assert.assertTrue(resultadoListagemPendenciaVPereiraDTO.getObjetosDto().isEmpty());
		Assert.assertEquals(resultadoListagemEsperaDTO.getObjetosDto().size(), 1);
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_permite_desativacao_de_grupo_com_usuario_na_espera_por_excesso_de_faltas()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoVpereiraDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaVeraPereira());

		Long prontuario = new Long(12222);

		AtendimentoProfissionalDTO atendimentoProfissionalDTO = ContextoAtendimentoProfissional
				.construirAtendimentoProfissionalDTO();
		atendimentoProfissionalDTO.setProfissionalDto(ContextoProfissional.construirProfissionalVPereiraDTO());

		servico_cria_tres_atendimentos_individuais_com_frequencia_fu_em_dias_diferentes_adicionando_profissional(
				resultadoVpereiraDto, prontuario, atendimentoProfissionalDTO);

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");

		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222));
		grupoDto.setAtivo(false);

		ResultadoEdicaoGrupoDTO resultadoEdicaoGrupoDTO = servicoSisLaraServerRmi.editarGrupo(grupoDto,
				resultadoVpereiraDto.getToken());

		Assert.assertEquals(resultadoEdicaoGrupoDTO.obterMensagens().trim(),
				"Usu�rio(s) 12222 - Jose Augusto Siqueira est� aguardando na espera por excesso de faltas. Por favor, analise o(s) caso(s) antes de desativar o grupo.");
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_remove_pendencias_de_excesso_de_faltas_apos_desligamento_de_usuario_do_grupo()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutorizacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		Long prontuario = new Long(12222);

		MaquinaTempo.mudarDataAtual("01/01/2117");
		servico_cria_tres_atendimentos_individuais_com_frequencia_fu_em_dias_diferentes(resultadoAutorizacaoDto,
				prontuario);

		ResultadoListagemPendenciaDTO resultadoListagemPendenciaAntesDesligamentoDTO = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoAutorizacaoDto.getToken());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");

		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222));
		ModuloPeriodoDTO moduloPeriodoDTO = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(),
				new Long(11111));
		ModuloUsuarioDTO moduloUsuarioDTO = (ModuloUsuarioDTO) obterDaRelacaoPorId(
				moduloPeriodoDTO.getModulosUsuariosDto(), new Long(11111));
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.DESLIGADO.toString()));
		servicoSisLaraServerRmi.editarModuloPeriodo(moduloPeriodoDTO, resultadoAutorizacaoDto.getToken());

		ResultadoListagemPendenciaDTO resultadoListagemPendenciaAposDesligamentoDTO = servicoSisLaraServerRmi
				.obterListagemPendencia(resultadoAutorizacaoDto.getToken());
		MaquinaTempo.restaurarDataOriginal();

		Assert.assertEquals(resultadoListagemPendenciaAntesDesligamentoDTO.getObjetosDto().size(), 3);
		Assert.assertEquals(resultadoListagemPendenciaAposDesligamentoDTO.getObjetosDto().size(), 2);
	}

	@Test(groups = {TiposDeTeste.AGENDAMENTO })
	public void servico_retorna_bloqueio_por_excesso_de_faltas_apos_FU_ou_FJ_em_avaliacao_e_triagem_agendada_por_excesso_de_faltas()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutorizacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		Long prontuario = new Long(72222);

		servico_cria_tres_atendimentos_individuais_com_frequencia_fu_em_dias_diferentes(resultadoAutorizacaoDto,
				prontuario);

		EspecificacaoPesquisaEsperaDTO especificacaoPesquisaEsperaDTO = new EspecificacaoPesquisaEsperaDTO();
		especificacaoPesquisaEsperaDTO.setProntuario(prontuario.toString());
		especificacaoPesquisaEsperaDTO.setInteresse(false);
		especificacaoPesquisaEsperaDTO.setLmLigou(false);
		especificacaoPesquisaEsperaDTO.setPendencias(false);
		especificacaoPesquisaEsperaDTO
				.setDescricaoTipoAtendimentoDto(ContextoDescricaoTipoAtendimento.construirDescricaoServicoSocialDTO());
		especificacaoPesquisaEsperaDTO.setModuloDto(ContextoModulo.construirModuloExcessoDeFaltasDTO());
		especificacaoPesquisaEsperaDTO.setStatusEsperadoDto(new StatusEsperaDTO(StatusEspera.AGUARDANDO.toString()));
		ResultadoListagemEsperaDTO resultadoPrimeiraListagemEsperaDto = servicoSisLaraServerRmi
				.obterListagemEspera(especificacaoPesquisaEsperaDTO);
		EsperaDTO esperaDto = resultadoPrimeiraListagemEsperaDto.getObjetosDto().get(0);

		EspecificacaoPesquisaAgendamentoDTO especificacaoPesquisaAgendamentoDto = new EspecificacaoPesquisaAgendamentoDTO();
		especificacaoPesquisaAgendamentoDto.setDataInicio("28/02/2012");
		ResultadoListagemAgendamentoDTO resultadoListagemAgendamentoDTO = servicoSisLaraServerRmi
				.obterListagemAgendamento(especificacaoPesquisaAgendamentoDto);
		AgendamentoDTO agendamentoDto = (AgendamentoDTO) obterDaRelacaoPorId(
				resultadoListagemAgendamentoDTO.getObjetosDto(), new Long(22222));

		EspecificacaoAssociacaoAgendamentoDTO especificacaoAssociacaoAgendamentoDto = new EspecificacaoAssociacaoAgendamentoDTO();
		especificacaoAssociacaoAgendamentoDto.setEsperaDto(esperaDto);
		especificacaoAssociacaoAgendamentoDto.setAgendamentoDto(agendamentoDto);

		servicoSisLaraServerRmi.editarEsperaEAssociarAgendamento(especificacaoAssociacaoAgendamentoDto,
				resultadoAutorizacaoDto.getToken());
		Registro.obterAutomatizadorPendencia().atualizarPendencias();

		// Evita que regra de sequencia de faltas seja acionada.
		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto
				.setDescricaoTipoAtendimentoDto(ContextoDescricaoTipoAtendimento.construirDescricaoServicoSocialDTO());
		atendimentoIndividualDto.setModuloDto(ContextoModulo.construirModuloAvaliacaoETriagemDTO());
		atendimentoIndividualDto.getUsuarioDto().setId(prontuario);
		atendimentoIndividualDto.setData("01/04/2017");
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("09:00", "11:00"));
		atendimentoIndividualDto.setAtendimentosProfissionalDto(
				Arrays.asList(ContextoAtendimentoProfissional.construirAtendimentoProfissional1000DTOComAT()));
		atendimentoIndividualDto.getInformacaoAtendimentoDto().setFrequenciaDto(new FrequenciaDTO("AT"));
		servicoSisLaraServerRmi.editarAtendimentoIndividual(atendimentoIndividualDto,
				resultadoAutorizacaoDto.getToken());

		atendimentoIndividualDto.setData("28/02/2012");
		atendimentoIndividualDto.setHorarioDto(new HorarioDTO("09:00", "11:00"));
		atendimentoIndividualDto.setAtendimentosProfissionalDto(
				Arrays.asList(ContextoAtendimentoProfissional.construirAtendimentoProfissional1000DTOComAT()));
		atendimentoIndividualDto.getInformacaoAtendimentoDto().setFrequenciaDto(new FrequenciaDTO("FU"));
		atendimentoIndividualDto.getInformacaoAtendimentoDto().setParticipadaoDetalhadaDto(Arrays.asList());
		atendimentoIndividualDto.setOpcaoIntegracaoDto(null);
		atendimentoIndividualDto.setDiscussaoCasoSimNaoDto(null);
		atendimentoIndividualDto.setAcoesDeCondutasDto(Arrays.asList());
		servicoSisLaraServerRmi.editarAtendimentoIndividual(atendimentoIndividualDto,
				resultadoAutorizacaoDto.getToken());

		ResultadoListagemEsperaDTO resultadoSegundaListagemEsperaDto = servicoSisLaraServerRmi
				.obterListagemEspera(especificacaoPesquisaEsperaDTO);

		Assert.assertEquals(resultadoPrimeiraListagemEsperaDto.getObjetosDto().size(), 1);
		Assert.assertEquals(resultadoPrimeiraListagemEsperaDto.getObjetosDto().get(0).getObs(),
				"Inclu�do automaticamente por excesso de faltas n�o justificadas.");
		Assert.assertEquals(resultadoSegundaListagemEsperaDto.getObjetosDto().size(), 1);
		Assert.assertEquals(resultadoSegundaListagemEsperaDto.getObjetosDto().get(0).getObs(),
				"Inclu�do automaticamente em decorr�ncia de falta no atendimento individual de avalia��o e triagem agendado por causa de excesso de faltas.");
	}

	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_permite_edicao_de_atendimento_individual_de_conta_acesso_nao_vinculado_aos_profissionais_do_atendimento()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutorizacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaShivas());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();

		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualDTO = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoAutorizacaoDto.getToken());

		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualDTO.sucesso());
		Assert.assertEquals(resultadoEdicaoAtendimentoIndividualDTO.obterMensagens().trim(),
				"Somente os profissionais vinculados ao atendimento podem alterar o registro.");
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_permite_edicao_de_atendimento_grupo_de_conta_acesso_nao_vinculado_aos_profissionais_do_atendimento()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaVeraPereira());

		String descricao = "OPA";
		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");

		Long idModuloPeriodo = new Long(11111);
		ModuloPeriodoDTO moduloPeriodoDTO = new ModuloPeriodoDTO();
		moduloPeriodoDTO.setId(idModuloPeriodo);
		
		AtendimentoGrupoDTO atendimentoGrupoDto = obterAtendimentoGrupoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), idModuloPeriodo, new Long(11111));
		atendimentoGrupoDto.setDescricao(descricao);

		ResultadoEdicaoAtendimentoGrupoDTO resultadoAtualizacaoAtendimentoGrupo = servicoSisLaraServerRmi
				.editarAtendimentoGrupo(moduloPeriodoDTO, atendimentoGrupoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoAtualizacaoAtendimentoGrupo.sucesso());
		Assert.assertEquals(resultadoAtualizacaoAtendimentoGrupo.obterMensagens().trim(),
				"Somente os profissionais vinculados ao atendimento podem alterar o registro.");
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_permite_edicao_de_atendimento_grupo_de_conta_acesso_nao_vinculado_aos_profissionais_do_atendimento_porem_com_profissional_equivalente()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaVVitalino());

		String descricao = "OPA";
		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");

		Long idModuloPeriodo = new Long(11111);
		ModuloPeriodoDTO moduloPeriodoDTO = new ModuloPeriodoDTO();
		moduloPeriodoDTO.setId(idModuloPeriodo);
		
		AtendimentoGrupoDTO atendimentoGrupoDto = obterAtendimentoGrupoDto(resultadoListagemGrupo.getObjetosDto(),
				new Long(12222), idModuloPeriodo, new Long(11111));
		atendimentoGrupoDto.setDescricao(descricao);

		ResultadoEdicaoAtendimentoGrupoDTO resultadoAtualizacaoAtendimentoGrupo = servicoSisLaraServerRmi
				.editarAtendimentoGrupo(moduloPeriodoDTO, atendimentoGrupoDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoAtualizacaoAtendimentoGrupo.sucesso());
	}

	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_inclui_atendimento_individual_de_primeira_vez_duplicado() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();
		atendimentoIndividualDto.setData("01/01/2000");
		atendimentoIndividualDto.setPrimeiraVezOuRetornoDto(new StatusDTO(Status.PRIMEIRA_VEZ.toString()));
		atendimentoIndividualDto.getInformacaoAtendimentoDto().setFrequenciaDto(new FrequenciaDTO("FU"));

		servicoSisLaraServerRmi.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		atendimentoIndividualDto.setData("02/01/2000");
		atendimentoIndividualDto.getInformacaoAtendimentoDto().setFrequenciaDto(new FrequenciaDTO("AT"));
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualADto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		atendimentoIndividualDto.setData("03/01/2000");
		atendimentoIndividualDto.getInformacaoAtendimentoDto().setFrequenciaDto(new FrequenciaDTO("AT"));
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualBDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualADto.sucesso());
		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualBDto.sucesso());
		Assert.assertEquals(resultadoEdicaoAtendimentoIndividualBDto.obterMensagens().trim(),
				"Atendimento individual da primeira vez j� foi efetuado.");
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_inclui_atendimento_individual_de_primeira_vez_duplicado_em_avaliacao_de_oftalmologia_e_acompanhamento_de_oftalmologia() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();

		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOftalmologia());
		atendimentoIndividualDto.setData("02/01/2000");
		atendimentoIndividualDto.getInformacaoAtendimentoDto().setFrequenciaDto(new FrequenciaDTO("AT"));
		atendimentoIndividualDto.setPrimeiraVezOuRetornoDto(new StatusDTO(Status.PRIMEIRA_VEZ.toString()));
		atendimentoIndividualDto.setOpcaoIntegracaoDto(new OpcaoIntegracaoDTO(OpcaoIntegracao.INTEGRACAO.toString()));
		
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualADto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAcompanhamentoServicoOftalmologia());
		atendimentoIndividualDto.setData("03/01/2000");
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualBDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualADto.sucesso());
		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualBDto.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualBDto.obterMensagens().contains("Atendimento individual da primeira vez j� foi efetuado."));
	}
	
	@Test(groups = {TiposDeTeste.ATENDIMENTO_INDIVIDUAL })
	public void servico_nao_inclui_atendimento_individual_de_primeira_vez_duplicado_em_avaliacao_de_ortoptica_e_acompanhamento_de_ortoptica() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		AtendimentoIndividualDTO atendimentoIndividualDto = ContextoAtendimentoIndividual
				.fabricarDtoComTodosOsDadosUsuario();

		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAcompanhamentoServicoOrtoptica());
		atendimentoIndividualDto.setData("02/01/2000");
		atendimentoIndividualDto.getInformacaoAtendimentoDto().setFrequenciaDto(new FrequenciaDTO("AT"));
		atendimentoIndividualDto.setPrimeiraVezOuRetornoDto(new StatusDTO(Status.PRIMEIRA_VEZ.toString()));
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualADto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		atendimentoIndividualDto.setDescricaoTipoAtendimentoDto(ContextoDescricaoTipoAtendimento.construirDescricaoTipoAtendimentoDTOAvaliacaoServicoOrtoptica());
		atendimentoIndividualDto.setData("03/01/2000");
		ResultadoEdicaoAtendimentoIndividualDTO resultadoEdicaoAtendimentoIndividualBDto = servicoSisLaraServerRmi
				.editarAtendimentoIndividual(atendimentoIndividualDto, resultadoDto.getToken());

		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualADto.sucesso());
		Assert.assertFalse(resultadoEdicaoAtendimentoIndividualBDto.sucesso());
		Assert.assertTrue(resultadoEdicaoAtendimentoIndividualBDto.obterMensagens().contains("Atendimento individual da primeira vez j� foi efetuado."));
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_efetua_inclusao_de_status_invalido_em_grupo_cto_de_reuniao_de_integracao()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaVeraPereira());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("SS-1");

		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(66666));
		ModuloPeriodoDTO moduloPeriodoDto = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(),
				new Long(99999));
		ModuloUsuarioDTO moduloUsuarioDTO = ContextoModuloUsuario.fabricarModuloUsuarioDTO();
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.DESISTENTE.toString()));
		moduloPeriodoDto.setModulosUsuariosDto(Arrays.asList(moduloUsuarioDTO));

		ResultadoEdicaoModuloPeriodoDTO resultadoEdicaoModuloPeriodoDTO = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoAutenticacaoDto.getToken());

		Assert.assertFalse(resultadoEdicaoModuloPeriodoDTO.sucesso());
		Assert.assertEquals(resultadoEdicaoModuloPeriodoDTO.obterMensagens().trim(),
				"N�o � poss�vel existir um usu�rio com status diferente de INTEGRADO, REMOVIDO ou DESLIGADO na Reuni�o de Integra��o.");
	}

	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_nao_efetua_inclusao_de_usuario_e_alteracao_de_status_e_data_ocorrencia_em_grupo_grupo_cto_de_reuniao_de_integracao_apartir_de_conta_acesso_sem_autorizacao()
			throws RemoteException {
		
		ResultadoAutenticacaoDTO resultadoAutenticacaoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());

		servico_atualiza_status_de_usuario_e_inclui_em_grupo_com_modulo_de_reuniao_de_integracao_com_sucesso(resultadoAutenticacaoDto,
				StatusRelacaoComModulo.PROVISORIO, "G02-1", new Long(12222), new Long(11111), new Long(11111), "SS-1",
				new Long(66666), new Long(99999), new Long(12222));

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("SS-1");

		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(66666));
		ModuloPeriodoDTO moduloPeriodoDto = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(),
				new Long(99999));
		ModuloUsuarioDTO moduloUsuarioDTO = obterPeloIdUsuario(moduloPeriodoDto,
				ContextoModuloUsuario.fabricarModuloUsuarioDTO().getUsuarioDto());
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.REMOVIDO.toString()));
		moduloUsuarioDTO.setDataOcorrencia("31/12/2015");

		ModuloUsuarioDTO moduloUsuarioAAdicionarDTO = ContextoModuloUsuario.fabricarModuloUsuarioAlternativoDTO();
		moduloPeriodoDto.getModulosUsuariosDto().add(moduloUsuarioAAdicionarDTO);

		ResultadoEdicaoModuloPeriodoDTO resultadoEdicaoModuloPeriodoDTO = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoAutenticacaoDto.getToken());

		Assert.assertFalse(resultadoEdicaoModuloPeriodoDTO.sucesso());
		Assert.assertTrue(resultadoEdicaoModuloPeriodoDTO.obterMensagens()
				.contains("Somente profissionais do Servi�o Social podem alterar o status e a data de ocorrencia."));
		Assert.assertTrue(resultadoEdicaoModuloPeriodoDTO.obterMensagens()
				.contains("Somente profissionais do Servi�o Social podem incluir um usu�rio manualmente."));
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_efetua_inclusao_de_usuario_e_alteracao_de_status_e_data_ocorrencia_em_grupo_grupo_cto_de_reuniao_de_integracao_apartir_de_conta_acesso_com_autorizacao()
			throws RemoteException {
		
		ResultadoAutenticacaoDTO resultadoAutenticacaoDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaShivas());
		ResultadoAutenticacaoDTO resultadoAutenticacaoVeraPereiraDTO = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaVeraPereira());

		Long prontuario = new Long(16666);
		servico_atualiza_status_de_usuario_e_inclui_em_grupo_com_modulo_de_reuniao_de_integracao_com_sucesso(resultadoAutenticacaoDTO,
				StatusRelacaoComModulo.PROVISORIO, "G08-1", new Long(15555), new Long(12345), new Long(12345), "SS-1",
				new Long(66666), new Long(99999), prontuario);

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("SS-1");

		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(66666));
		ModuloPeriodoDTO moduloPeriodoDto = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(),
				new Long(99999));
		UsuarioDTO usuarioDto = ContextoModuloUsuario.fabricarModuloUsuarioDTO().getUsuarioDto();
		usuarioDto.setId(prontuario);
		ModuloUsuarioDTO moduloUsuarioDTO = obterPeloIdUsuario(moduloPeriodoDto, usuarioDto);
		moduloUsuarioDTO.setStatusDto(new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.REMOVIDO.toString()));
		moduloUsuarioDTO.setDataOcorrencia("31/12/2015");

		ModuloUsuarioDTO moduloUsuarioAAdicionarDTO = ContextoModuloUsuario.fabricarModuloUsuarioAlternativoDTO();
		moduloPeriodoDto.getModulosUsuariosDto().add(moduloUsuarioAAdicionarDTO);

		ResultadoEdicaoModuloPeriodoDTO resultadoEdicaoModuloPeriodoDTO = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoDto, resultadoAutenticacaoVeraPereiraDTO.getToken());

		Assert.assertTrue(resultadoEdicaoModuloPeriodoDTO.sucesso());
	}

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_geracao_de_demanda_cartela_se_selos_com_pre_cadastro_sem_cpf()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoDemandaDTO especificacaoGeracaoDemandaDTO = ContextoEspecificacaoGeracaoDemanda
				.fabricarDemandaComTodosOsDadosAlternativo();
		especificacaoGeracaoDemandaDTO.setUsuariosDto(null);
		especificacaoGeracaoDemandaDTO.getPreCadastrosDto().getInformacaoEssencialDto().setCpf(null);
		especificacaoGeracaoDemandaDTO.setCartelaDeSelos(true);

		ResultadoGeracaoDemandaDTO resultadoGeracaoDemanda = servicoSisLaraServerRmi
				.gerarDemanda(especificacaoGeracaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoDemanda.sucesso());
		Assert.assertTrue(
				resultadoGeracaoDemanda.obterMensagens().contains("O solicitante n�o possui o CPF cadastrado."));
	}

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_geracao_de_demanda_cartela_se_selos_com_usuario_sem_cpf() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoDemandaDTO especificacaoGeracaoDemandaDTO = ContextoEspecificacaoGeracaoDemanda
				.fabricarDemandaComTodosOsDadosAlternativo();
		especificacaoGeracaoDemandaDTO.setPreCadastrosDto(null);
		especificacaoGeracaoDemandaDTO.setUsuariosDto(ContextoUsuario.construirUsuarioDTO());
		especificacaoGeracaoDemandaDTO.getUsuariosDto().getInformacaoEssencialDto().setCpf(null);
		especificacaoGeracaoDemandaDTO.setCartelaDeSelos(true);

		ResultadoGeracaoDemandaDTO resultadoGeracaoDemanda = servicoSisLaraServerRmi
				.gerarDemanda(especificacaoGeracaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoDemanda.sucesso());
		Assert.assertTrue(
				resultadoGeracaoDemanda.obterMensagens().contains("O solicitante n�o possui o CPF cadastrado."));
	}

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_geracao_de_demanda_cartela_de_selos_com_usuario_com_data_nascimento_menor_5_anos()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoDemandaDTO especificacaoGeracaoDemandaDTO = ContextoEspecificacaoGeracaoDemanda
				.fabricarDemandaComTodosOsDadosAlternativo();
		especificacaoGeracaoDemandaDTO.getPreCadastrosDto().getInformacaoEssencialDto().setCpf("71894810287");
		especificacaoGeracaoDemandaDTO.getPreCadastrosDto().getInformacaoEssencialDto().setDataNascimento(null);
		especificacaoGeracaoDemandaDTO.setCartelaDeSelos(true);

		ResultadoGeracaoDemandaDTO resultadoGeracaoDemanda = servicoSisLaraServerRmi
				.gerarDemanda(especificacaoGeracaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoDemanda.sucesso());
		Assert.assertTrue(
				resultadoGeracaoDemanda.obterMensagens().contains("Solicitante n�o possui data de nascimento."));
	}

	@Test(groups = {TiposDeTeste.GRUPO})
	public void servico_nao_efetua_altera_status_para_acesso_em_modulo_de_psicossocial() throws RemoteException {
		
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupoAEEPisicoAposAtualizacao = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("G06-1");

		GrupoDTO grupoAeePisicoDtoAposAtualizacao = (GrupoDTO) obterDaRelacaoPorId(
				resultadoListagemGrupoAEEPisicoAposAtualizacao.getObjetosDto(), new Long(14444));

		ModuloPeriodoDTO moduloPeriodoPsicossocialDtoAposAtualizacao = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoAeePisicoDtoAposAtualizacao.getModulosPeriodosDto(), new Long(88888));
		
		ModuloUsuarioDTO moduloUsuarioDto = (ModuloUsuarioDTO) obterDaRelacaoPorId(
				moduloPeriodoPsicossocialDtoAposAtualizacao.getModulosUsuariosDto(), new Long(88888));
		moduloUsuarioDto.setStatusDto(new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.ACESSO.toString()));
		
		ResultadoEdicaoModuloPeriodoDTO resultadoEdicaoModuloPeriodoDTO = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoPsicossocialDtoAposAtualizacao, resultadoDto.getToken());
		
		Assert.assertFalse(resultadoEdicaoModuloPeriodoDTO.sucesso());
		Assert.assertTrue(resultadoEdicaoModuloPeriodoDTO.obterMensagens()
				.contains("N�o � poss�vel existir um usu�rio com status ACESSO no Psicossocial para as fam�lias."));
	}
	
	@Test(groups = {TiposDeTeste.GRUPO})
	public void servico_nao_efetua_alteracao_de_status_em_modulo_periodo_com_profissional_nao_autorizado() throws RemoteException {
		
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupoAEEPisicoAposAtualizacao = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo("G06-1");

		GrupoDTO grupoG06 = (GrupoDTO) obterDaRelacaoPorId(
				resultadoListagemGrupoAEEPisicoAposAtualizacao.getObjetosDto(), new Long(14444));

		ModuloPeriodoDTO moduloPeriodoAEE = (ModuloPeriodoDTO) obterDaRelacaoPorId(
				grupoG06.getModulosPeriodosDto(), new Long(77777));
		
		ModuloUsuarioDTO moduloUsuarioDto = (ModuloUsuarioDTO) obterDaRelacaoPorId(
				moduloPeriodoAEE.getModulosUsuariosDto(), new Long(44444));
		moduloUsuarioDto.setStatusDto(new StatusRelacaoComModuloDTO(StatusRelacaoComModulo.INTEGRADO.toString()));
		
		ResultadoEdicaoModuloPeriodoDTO resultadoEdicaoModuloPeriodoDTO = servicoSisLaraServerRmi
				.editarModuloPeriodo(moduloPeriodoAEE, resultadoDto.getToken());
		
		Assert.assertFalse(resultadoEdicaoModuloPeriodoDTO.sucesso());
		Assert.assertTrue(resultadoEdicaoModuloPeriodoDTO.obterMensagens()
				.contains("Somente o profissional vinculado ao m�dulo pode efetuar altera��es."));
	}

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_geracao_de_demanda_cartela_de_selos_com_mais_de_um_recurso()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoDemandaDTO especificacaoGeracaoDemandaDTO = ContextoEspecificacaoGeracaoDemanda
				.fabricarDemandaComTodosOsDadosAlternativo();
		especificacaoGeracaoDemandaDTO.setRecursosEDescrucaiRecursoDto(Arrays
				.asList(ContextoRecursoDescricaoRecurso.criarAlternativoDto(), ContextoRecursoDescricaoRecurso.criarDto()));
		especificacaoGeracaoDemandaDTO.setCartelaDeSelos(true);

		ResultadoGeracaoDemandaDTO resultadoGeracaoDemanda = servicoSisLaraServerRmi
				.gerarDemanda(especificacaoGeracaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoDemanda.sucesso());
		Assert.assertTrue(
				resultadoGeracaoDemanda.obterMensagens().contains("N�o � poss�vel incluir mais de um recurso na cartela de selos."));
	}

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_geracao_de_demanda_cartela_de_selos_sem_documentos_obrigatorios()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoDemandaDTO especificacaoGeracaoDemandaDTO = ContextoEspecificacaoGeracaoDemanda
				.fabricarDemandaComTodosOsDadosAlternativo();
		especificacaoGeracaoDemandaDTO.setRecursosEDescrucaiRecursoDto(Arrays.asList());
		PreCadastroDTO preCadastroDto = ContextoPreCadastro.construirPreCadastroDTO();
		preCadastroDto.getInformacaoEssencialDto()
				.setDataNascimento(DataHoraUtils.formatarData(MaquinaTempo.obterInstancia().obterCalendarioAtual()));
		especificacaoGeracaoDemandaDTO.setPreCadastrosDto(preCadastroDto);
		especificacaoGeracaoDemandaDTO.setUsuariosDto(null);
		especificacaoGeracaoDemandaDTO.setCartelaDeSelos(true);

		ResultadoGeracaoDemandaDTO resultadoGeracaoDemanda = servicoSisLaraServerRmi
				.gerarDemanda(especificacaoGeracaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoDemanda.sucesso());
		Assert.assertTrue(resultadoGeracaoDemanda.obterMensagens().contains("Insira um Recurso."));
		Assert.assertTrue(resultadoGeracaoDemanda.obterMensagens()
				.contains("Insira uma autodeclara��o ou indica��o de usu�rio de sistema braille."));
		Assert.assertTrue(
				resultadoGeracaoDemanda.obterMensagens().contains("Solicitante n�o possui idade m�nima de 5 anos."));
		Assert.assertTrue(
				resultadoGeracaoDemanda.obterMensagens().contains("Insira uma c�pia da declara��o de matr�cula."));
		Assert.assertTrue(resultadoGeracaoDemanda.obterMensagens().contains("Insira uma foto recente."));
		Assert.assertTrue(resultadoGeracaoDemanda.obterMensagens().contains("Insira uma c�pia do CPF e RG."));
		Assert.assertTrue(
				resultadoGeracaoDemanda.obterMensagens().contains("Insira uma c�pia do comprovante de endere�o."));
		Assert.assertTrue(
				resultadoGeracaoDemanda.obterMensagens().contains("Insira uma c�pia do hist�rico do solicitante."));
	}

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_geracao_de_demanda_cartela_de_selos_sem_usuario_ou_pre_cadastro()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoDemandaDTO especificacaoGeracaoDemandaDTO = ContextoEspecificacaoGeracaoDemanda
				.fabricarDemandaComTodosOsDados();
		especificacaoGeracaoDemandaDTO.setRecursosEDescrucaiRecursoDto(Arrays.asList());
		especificacaoGeracaoDemandaDTO.setPreCadastrosDto(null);
		especificacaoGeracaoDemandaDTO.setUsuariosDto(null);
		especificacaoGeracaoDemandaDTO.setCartelaDeSelos(true);

		ResultadoGeracaoDemandaDTO resultadoGeracaoDemanda = servicoSisLaraServerRmi
				.gerarDemanda(especificacaoGeracaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoDemanda.sucesso());
		Assert.assertTrue(resultadoGeracaoDemanda.obterMensagens().contains("Insira um Usu�rio ou Pr� Cadastro."));
	}

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_prorrogacao_demanda_cartela_de_selos_por_falta_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();
		especificacaoPesquisaDemandaDTO.setProntuario("12222");

		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);

		DemandaDTO demandaDto = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemanda.getObjetosDto(),
				new Long(12222));

		ResultadoProrrogacaoCartelaDeSelosDTO resultadoProrrogacaoCartelaDeSelosDto = servicoSisLaraServerRmi
				.prorrogar(demandaDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoProrrogacaoCartelaDeSelosDto.sucesso());
		Assert.assertTrue(resultadoProrrogacaoCartelaDeSelosDto.obterMensagens()
				.contains("Voc� n�o possui autoriza��o para realizar a opera��o."));
	}

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_prorrogacao_demanda_normal() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();
		especificacaoPesquisaDemandaDTO.setCpf("90353388122");

		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);

		DemandaDTO demandaDto = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemanda.getObjetosDto(),
				new Long(13333));

		ResultadoProrrogacaoCartelaDeSelosDTO resultadoProrrogacaoCartelaDeSelosDto = servicoSisLaraServerRmi
				.prorrogar(demandaDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoProrrogacaoCartelaDeSelosDto.sucesso());
		Assert.assertTrue(resultadoProrrogacaoCartelaDeSelosDto.obterMensagens()
				.contains("Somente projeto cartela de selos pode ser prorrogado."));
	}

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_efetua_prorrogacao_demanda_cartela_de_selos_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();
		especificacaoPesquisaDemandaDTO.setProntuario("12222");

		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);

		DemandaDTO demandaDto = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemanda.getObjetosDto(),
				new Long(12222));

		ResultadoProrrogacaoCartelaDeSelosDTO resultadoProrrogacaoCartelaDeSelosDto = servicoSisLaraServerRmi
				.prorrogar(demandaDto, resultadoDto.getToken());

		DemandaDTO demandaProrrogadaDto = (DemandaDTO) resultadoProrrogacaoCartelaDeSelosDto.obterObjetoDtoEditado();

		Assert.assertTrue(resultadoProrrogacaoCartelaDeSelosDto.sucesso());
		Assert.assertEquals(demandaProrrogadaDto.getDataPrazoCaptacao(), "30/04/2000");
		Assert.assertEquals(demandaProrrogadaDto.getStatusDemandaDto().toString(), StatusDemanda.PRORROGADA.toString());
	}
	//TODO: REMOVER
	/*
	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_efetua_disponibilizacao_e_entrega_demanda_nao_cartela_de_selos_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		Registro.obterAutomatizadorTarefas().executar();
		
		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();
		especificacaoPesquisaDemandaDTO.setProntuario("12222");

		StatusDemandaDTO statusDemandaDisponivelDTO = new StatusDemandaDTO(StatusDemanda.DISPONIVEL.toString());
		StatusDemandaDTO statusDemandaEntregaDTO = new StatusDemandaDTO(StatusDemanda.ENTREGUE.toString());
				
		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);

		DemandaDTO demandaDto = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemanda.getObjetosDto(),
				new Long(16666));

		ResultadoEdicaoDemandaDTO resultadoEdicaoDemandaDisponibilizadaDto = servicoSisLaraServerRmi.mudarStatusDemanda(demandaDto,
				statusDemandaDisponivelDTO, null, null, resultadoDto.getToken());

		DemandaDTO demandaAposDisponibilizacaoDto = (DemandaDTO) resultadoEdicaoDemandaDisponibilizadaDto.obterObjetoDtoEditado();
		
		ResultadoEdicaoDemandaDTO resultadoEdicaoDemandaEntregaDto = servicoSisLaraServerRmi.mudarStatusDemanda(demandaDto,
				statusDemandaEntregaDTO, null, null, resultadoDto.getToken());

		DemandaDTO demandaAposEntregaDto = (DemandaDTO) resultadoEdicaoDemandaEntregaDto.obterObjetoDtoEditado();

		Assert.assertTrue(resultadoEdicaoDemandaDisponibilizadaDto.sucesso());
		Assert.assertTrue(resultadoEdicaoDemandaEntregaDto.sucesso());
		Assert.assertTrue(demandaAposDisponibilizacaoDto.getStatusDemandaDto().equals(statusDemandaDisponivelDTO));
		Assert.assertTrue(demandaAposEntregaDto.getStatusDemandaDto().equals(statusDemandaEntregaDTO));
	}

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_entrega_demanda_nao_cartela_de_selos_devido_marcacao_indevida_de_motivo_de_cancelamento() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		Registro.obterAutomatizadorTarefas().executar();
		
		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();
		especificacaoPesquisaDemandaDTO.setProntuario("12222");

		StatusDemandaDTO statusDemandaDTO = new StatusDemandaDTO(StatusDemanda.DISPONIVEL.toString());
		
		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);

		DemandaDTO demandaDto = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemanda.getObjetosDto(),
				new Long(16666));

		ResultadoEdicaoDemandaDTO resultadoEdicaoDemandaDto = servicoSisLaraServerRmi.mudarStatusDemanda(demandaDto,
				statusDemandaDTO, ContextoMotivoCancelamento.construirMotivoCancelamentoDto(), null, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoDemandaDto.sucesso());
		Assert.assertTrue(resultadoEdicaoDemandaDto.obterMensagens().contains("O motivo de cancelamento s� � permitido em status CANCELADA."));
	}
	*/
	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_entrega_demanda_nao_cartela_de_selos_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoSemPermissao());

		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();
		especificacaoPesquisaDemandaDTO.setProntuario("12222");

		StatusDemandaDTO statusDemandaDTO = new StatusDemandaDTO(StatusDemanda.ENTREGUE.toString());
		
		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);

		DemandaDTO demandaDto = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemanda.getObjetosDto(),
				new Long(12222));

		ResultadoEdicaoDemandaDTO resultadoEdicaoDemandaDto = servicoSisLaraServerRmi.mudarStatusDemanda(demandaDto,
				statusDemandaDTO, null, null, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoDemandaDto.sucesso());
		Assert.assertTrue(resultadoEdicaoDemandaDto.obterMensagens().contains("N�o � poss�vel realizar a mudan�a de status."));
	}

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_cancelamento_demanda_nao_cartela_de_selos_devido_falta_de_autorizacao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoSemPermissao());

		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();
		especificacaoPesquisaDemandaDTO.setProntuario("12222");

		StatusDemandaDTO statusDemandaDTO = new StatusDemandaDTO(StatusDemanda.CANCELADA.toString());
		
		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);

		DemandaDTO demandaDto = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemanda.getObjetosDto(),
				new Long(12222));

		ResultadoEdicaoDemandaDTO resultadoEdicaoDemandaDto = servicoSisLaraServerRmi.mudarStatusDemanda(demandaDto,
				statusDemandaDTO, null, null, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoDemandaDto.sucesso());
		Assert.assertTrue(resultadoEdicaoDemandaDto.obterMensagens().contains("N�o � poss�vel realizar a mudan�a de status."));
	}
	

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_cancelamento_demanda_nao_cartela_de_selos_devido_falta_de_motivo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();
		especificacaoPesquisaDemandaDTO.setProntuario("12222");

		StatusDemandaDTO statusDemandaDTO = new StatusDemandaDTO(StatusDemanda.CANCELADA.toString());
		
		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);

		DemandaDTO demandaDto = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemanda.getObjetosDto(),
				new Long(12222));

		ResultadoEdicaoDemandaDTO resultadoEdicaoDemandaDto = servicoSisLaraServerRmi.mudarStatusDemanda(demandaDto,
				statusDemandaDTO, null, null, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoDemandaDto.sucesso());
		Assert.assertTrue(resultadoEdicaoDemandaDto.obterMensagens().contains("Insira um motivo de cancelamento."));
	}
	
	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_cancelamento_duplicado_demanda_nao_cartela_de_selos() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();
		especificacaoPesquisaDemandaDTO.setProntuario("12222");

		StatusDemandaDTO statusDemandaDTO = new StatusDemandaDTO(StatusDemanda.CANCELADA.toString());
		
		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);

		DemandaDTO demandaDto = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemanda.getObjetosDto(),
				new Long(12222));

		ResultadoEdicaoDemandaDTO resultadoEdicaoDemandaAposCancelamentoDto = servicoSisLaraServerRmi.mudarStatusDemanda(demandaDto,
				statusDemandaDTO, ContextoMotivoCancelamento.construirMotivoCancelamentoDto(), null, resultadoDto.getToken());

		ResultadoEdicaoDemandaDTO resultadoEdicaoDemandaAposCancalamentoDuplicadoDto = servicoSisLaraServerRmi.mudarStatusDemanda(demandaDto,
				statusDemandaDTO, ContextoMotivoCancelamento.construirMotivoCancelamentoDto(), null, resultadoDto.getToken());

		Assert.assertTrue(resultadoEdicaoDemandaAposCancelamentoDto.sucesso());
		Assert.assertFalse(resultadoEdicaoDemandaAposCancalamentoDuplicadoDto.sucesso());
		Assert.assertTrue(resultadoEdicaoDemandaAposCancalamentoDuplicadoDto.obterMensagens().contains("N�o � poss�vel realizar a mudan�a de status."));
	}
	
	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_geracao_de_demanda_cartela_de_selos_usando_recurso_inabilitado()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoGeracaoDemandaDTO especificacaoGeracaoDemandaDTO = ContextoEspecificacaoGeracaoDemanda
				.fabricarDemandaComTodosOsDadosAlternativo();
		especificacaoGeracaoDemandaDTO
				.setRecursosEDescrucaiRecursoDto(Arrays.asList(ContextoRecursoDescricaoRecurso.criarAlternativoDto()));

		String conteudoArquivo = "Conte�do do arquivo.";

		PreCadastroDTO preCadastroDto = ContextoPreCadastro.construirPreCadastroDTO();
		preCadastroDto.getInformacaoEssencialDto().setDataNascimento("27/07/1982");
		especificacaoGeracaoDemandaDTO.setPreCadastrosDto(preCadastroDto);
		especificacaoGeracaoDemandaDTO.setUsuariosDto(null);
		especificacaoGeracaoDemandaDTO.setCartelaDeSelos(true);
		especificacaoGeracaoDemandaDTO.setDocumentosSolicitacaoDocacaoDto(obterTodosDocumentos(conteudoArquivo));

		ResultadoGeracaoDemandaDTO resultadoGeracaoDemanda = servicoSisLaraServerRmi
				.gerarDemanda(especificacaoGeracaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoGeracaoDemanda.sucesso());
		Assert.assertTrue(resultadoGeracaoDemanda.obterMensagens()
				.contains("N�o � poss�vel usar um recurso n�o dispon�vel para cartela de selos."));
	}

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_efetua_captacao_de_demanda_cartela_de_selos_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();
		especificacaoPesquisaDemandaDTO.setProntuario("12222");

		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);

		DemandaDTO demandaDto = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemanda.getObjetosDto(),
				new Long(12222));

		EspecificacaoCaptacaoDemandaDTO especificacaoCaptacaoDemandaDTO = new EspecificacaoCaptacaoDemandaDTO();
		especificacaoCaptacaoDemandaDTO.setDemandaDto(demandaDto);
		especificacaoCaptacaoDemandaDTO.setValor("500,00");
		especificacaoCaptacaoDemandaDTO.setReciboDto(ContextoRecibo.fabricarReciboDto());

		servicoSisLaraServerRmi.captar(especificacaoCaptacaoDemandaDTO, resultadoDto.getToken());
		ResultadoCaptacaoCartelaDeSelosDTO resultadoCaptacaoCartelaDeSelosDto = servicoSisLaraServerRmi
				.captar(especificacaoCaptacaoDemandaDTO, resultadoDto.getToken());

		DemandaDTO demandaCaptadaDto = (DemandaDTO) resultadoCaptacaoCartelaDeSelosDto.obterObjetoDtoEditado();

		Assert.assertTrue(resultadoCaptacaoCartelaDeSelosDto.sucesso());
		Assert.assertEquals(demandaCaptadaDto.getValorCartela(), "2500,00");
		Assert.assertEquals(demandaCaptadaDto.getValorTotalCaptado(), "1000,00");
		Assert.assertEquals(demandaCaptadaDto.getValorSaldo(), "1500,00");
	}
	
	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_captacao_de_demanda_cartela_de_selos_com_valor_total_captado_maior_que_necessario_para_producao_do_recurso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();
		especificacaoPesquisaDemandaDTO.setProntuario("12222");

		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);

		DemandaDTO demandaDto = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemanda.getObjetosDto(),
				new Long(12222));

		EspecificacaoCaptacaoDemandaDTO especificacaoCaptacaoDemandaDTO = new EspecificacaoCaptacaoDemandaDTO();
		especificacaoCaptacaoDemandaDTO.setDemandaDto(demandaDto);
		especificacaoCaptacaoDemandaDTO.setValor("1251,00");
		especificacaoCaptacaoDemandaDTO.setReciboDto(ContextoRecibo.fabricarReciboAlternativoDto());

		servicoSisLaraServerRmi.captar(especificacaoCaptacaoDemandaDTO, resultadoDto.getToken());
		ResultadoCaptacaoCartelaDeSelosDTO resultadoCaptacaoCartelaDeSelosDto = servicoSisLaraServerRmi
				.captar(especificacaoCaptacaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoCaptacaoCartelaDeSelosDto.sucesso());
		Assert.assertTrue(resultadoCaptacaoCartelaDeSelosDto.obterMensagens().contains("O valor total captado n�o pode ser maior que o valor da cartela."));
	}
	
	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_captacao_de_demanda_cartela_de_selos_por_falta_de_saldo_no_recibo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();
		especificacaoPesquisaDemandaDTO.setProntuario("12222");

		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);

		DemandaDTO demandaDto = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemanda.getObjetosDto(),
				new Long(12222));

		EspecificacaoCaptacaoDemandaDTO especificacaoCaptacaoDemandaDTO = new EspecificacaoCaptacaoDemandaDTO();
		especificacaoCaptacaoDemandaDTO.setDemandaDto(demandaDto);
		especificacaoCaptacaoDemandaDTO.setValor("500,00");
		especificacaoCaptacaoDemandaDTO.setReciboDto(ContextoRecibo.fabricarReciboDto());

		servicoSisLaraServerRmi.captar(especificacaoCaptacaoDemandaDTO, resultadoDto.getToken());
		servicoSisLaraServerRmi.captar(especificacaoCaptacaoDemandaDTO, resultadoDto.getToken());
		ResultadoCaptacaoCartelaDeSelosDTO resultadoCaptacaoCartelaDeSelosDto = servicoSisLaraServerRmi
				.captar(especificacaoCaptacaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoCaptacaoCartelaDeSelosDto.sucesso());
		Assert.assertTrue(resultadoCaptacaoCartelaDeSelosDto.obterMensagens().contains("Valor total do recibo insuficiente para capta��o."));
	}
	
	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_captacao_de_demanda_cartela_sem_dados_recibo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();
		especificacaoPesquisaDemandaDTO.setProntuario("12222");

		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);

		DemandaDTO demandaDto = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemanda.getObjetosDto(),
				new Long(12222));

		EspecificacaoCaptacaoDemandaDTO especificacaoCaptacaoDemandaDTO = new EspecificacaoCaptacaoDemandaDTO();
		especificacaoCaptacaoDemandaDTO.setDemandaDto(demandaDto);
		especificacaoCaptacaoDemandaDTO.setValor("500,00");
		
		ResultadoCaptacaoCartelaDeSelosDTO resultadoCaptacaoCartelaDeSelosDto = servicoSisLaraServerRmi
				.captar(especificacaoCaptacaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoCaptacaoCartelaDeSelosDto.sucesso());
		Assert.assertTrue(resultadoCaptacaoCartelaDeSelosDto.obterMensagens().contains("Insira um recibo."));
	}
	
	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_captacao_de_demanda_cartela_com_dados_recibo_invalidos() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();
		especificacaoPesquisaDemandaDTO.setProntuario("12222");

		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);

		DemandaDTO demandaDto = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemanda.getObjetosDto(),
				new Long(12222));

		EspecificacaoCaptacaoDemandaDTO especificacaoCaptacaoDemandaDTO = new EspecificacaoCaptacaoDemandaDTO();
		especificacaoCaptacaoDemandaDTO.setDemandaDto(demandaDto);
		especificacaoCaptacaoDemandaDTO.setValor("500,00");
		ReciboDTO reciboDTO = ContextoRecibo.fabricarReciboDto();
		reciboDTO.setId(null);
		reciboDTO.setValorTotalRecibo(null);
		especificacaoCaptacaoDemandaDTO.setReciboDto(reciboDTO);
		
		ResultadoCaptacaoCartelaDeSelosDTO resultadoCaptacaoCartelaDeSelosDto = servicoSisLaraServerRmi
				.captar(especificacaoCaptacaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoCaptacaoCartelaDeSelosDto.sucesso());
		Assert.assertTrue(resultadoCaptacaoCartelaDeSelosDto.obterMensagens().contains("Insira um n�mero de recibo."));
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obter_valor_total_recibo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();
		especificacaoPesquisaDemandaDTO.setProntuario("12222");

		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);

		DemandaDTO demandaDto = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemanda.getObjetosDto(),
				new Long(12222));

		ReciboDTO reciboDto = ContextoRecibo.fabricarReciboDto();

		EspecificacaoCaptacaoDemandaDTO especificacaoCaptacaoDemandaDTO = new EspecificacaoCaptacaoDemandaDTO();
		especificacaoCaptacaoDemandaDTO.setDemandaDto(demandaDto);
		especificacaoCaptacaoDemandaDTO.setValor("500,00");
		especificacaoCaptacaoDemandaDTO.setReciboDto(reciboDto);

		servicoSisLaraServerRmi.captar(especificacaoCaptacaoDemandaDTO, resultadoDto.getToken());
		
		ReciboDTO reciboDtoObtido = servicoSisLaraServerRmi.obterReciboDto(reciboDto.getId().toString());

		Assert.assertEquals(reciboDtoObtido.getId(), reciboDto.getId());
		Assert.assertEquals(reciboDtoObtido.getValorTotalRecibo(), reciboDto.getValorTotalRecibo());
	}
	//TODO:REMOVER
	/*
	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_efetua_captacao_de_demanda_cartela_de_selos_e_possibilita_reserva_automatica() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();
		especificacaoPesquisaDemandaDTO.setProntuario("12222");

		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);

		DemandaDTO demandaAntesReservaDto = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemanda.getObjetosDto(),
				new Long(12222));

		EspecificacaoCaptacaoDemandaDTO especificacaoCaptacaoDemandaDTO = new EspecificacaoCaptacaoDemandaDTO();
		especificacaoCaptacaoDemandaDTO.setDemandaDto(demandaAntesReservaDto);
		especificacaoCaptacaoDemandaDTO.setValor("1250,00");
		especificacaoCaptacaoDemandaDTO.setReciboDto(ContextoRecibo.fabricarReciboAlternativoDto());

		servicoSisLaraServerRmi.captar(especificacaoCaptacaoDemandaDTO, resultadoDto.getToken());
		servicoSisLaraServerRmi.captar(especificacaoCaptacaoDemandaDTO, resultadoDto.getToken());

		Registro.obterAutomatizadorTarefas().executar();
		
		ResultadoListagemDemandaDTO resultadoListagemDemandaAposReserva = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);
		DemandaDTO demandaDtoAposReserva = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemandaAposReserva.getObjetosDto(),
				new Long(12222));
		
		Assert.assertEquals(demandaAntesReservaDto.getStatusDemandaDto(), new StatusDemandaDTO(StatusDemanda.AGUARDANDO.toString()));
		Assert.assertEquals(demandaDtoAposReserva.getStatusDemandaDto(), new StatusDemandaDTO(StatusDemanda.RESERVADO.toString()));
		Assert.assertEquals(demandaDtoAposReserva.getValorCartela(), "2500,00");
		Assert.assertEquals(demandaDtoAposReserva.getValorTotalCaptado(), "2500,00");
		Assert.assertEquals(demandaDtoAposReserva.getValorSaldo(), "0,00");
	}
	
	
	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_efetua_captacao_de_demanda_cartela_de_selos_prorrogada_e_possibilita_reserva_automatica() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();
		especificacaoPesquisaDemandaDTO.setProntuario("12222");

		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);
		
		DemandaDTO demandaDto = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemanda.getObjetosDto(),
				new Long(12222));
		
		servicoSisLaraServerRmi.prorrogar(demandaDto, resultadoDto.getToken());
		
		ResultadoListagemDemandaDTO resultadoListagemDemandaAntesReserva = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);
		
		DemandaDTO demandaDtoAntesReserva = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemandaAntesReserva.getObjetosDto(),
				new Long(12222));
		
		EspecificacaoCaptacaoDemandaDTO especificacaoCaptacaoDemandaDTO = new EspecificacaoCaptacaoDemandaDTO();
		especificacaoCaptacaoDemandaDTO.setDemandaDto(demandaDtoAntesReserva);
		especificacaoCaptacaoDemandaDTO.setValor("1250,00");
		especificacaoCaptacaoDemandaDTO.setReciboDto(ContextoRecibo.fabricarReciboAlternativoDto());

		servicoSisLaraServerRmi.captar(especificacaoCaptacaoDemandaDTO, resultadoDto.getToken());
		servicoSisLaraServerRmi.captar(especificacaoCaptacaoDemandaDTO, resultadoDto.getToken());

		Registro.obterAutomatizadorTarefas().executar();
		
		ResultadoListagemDemandaDTO resultadoListagemDemandaAposReserva = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);
		DemandaDTO demandaDtoAposReserva = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemandaAposReserva.getObjetosDto(),
				new Long(12222));
		
		Assert.assertEquals(demandaDtoAntesReserva.getStatusDemandaDto(), new StatusDemandaDTO(StatusDemanda.PRORROGADA.toString()));
		Assert.assertEquals(demandaDtoAposReserva.getStatusDemandaDto(), new StatusDemandaDTO(StatusDemanda.RESERVADO.toString()));
		Assert.assertEquals(demandaDtoAposReserva.getValorCartela(), "2500,00");
		Assert.assertEquals(demandaDtoAposReserva.getValorTotalCaptado(), "2500,00");
		Assert.assertEquals(demandaDtoAposReserva.getValorSaldo(), "0,00");
	}
	*/

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_pesquisa_de_demanda_sem_dados() throws RemoteException {
		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();

		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);

		Assert.assertFalse(resultadoListagemDemanda.sucesso());
		Assert.assertTrue(resultadoListagemDemanda.obterMensagens().contains("Insira um par�metro para pesquisa."));
	}

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_captacao_de_demanda_cartela_de_selos_sem_dados_obrigatorios()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoCaptacaoDemandaDTO especificacaoCaptacaoDemandaDTO = new EspecificacaoCaptacaoDemandaDTO();

		ResultadoCaptacaoCartelaDeSelosDTO resultadoCaptacaoCartelaDeSelosDto = servicoSisLaraServerRmi
				.captar(especificacaoCaptacaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoCaptacaoCartelaDeSelosDto.sucesso());
		Assert.assertTrue(resultadoCaptacaoCartelaDeSelosDto.obterMensagens().contains("Insira uma demanda."));
		Assert.assertTrue(resultadoCaptacaoCartelaDeSelosDto.obterMensagens().contains("Insira um valor da capta��o v�lido."));
		Assert.assertTrue(resultadoCaptacaoCartelaDeSelosDto.obterMensagens().contains("Insira um recibo."));
	}

	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_captacao_de_demanda_cartela_de_selos_sem_autorizacao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoSemPermissao());

		EspecificacaoCaptacaoDemandaDTO especificacaoCaptacaoDemandaDTO = new EspecificacaoCaptacaoDemandaDTO();

		ResultadoCaptacaoCartelaDeSelosDTO resultadoCaptacaoCartelaDeSelosDto = servicoSisLaraServerRmi
				.captar(especificacaoCaptacaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoCaptacaoCartelaDeSelosDto.sucesso());
		Assert.assertTrue(resultadoCaptacaoCartelaDeSelosDto.obterMensagens()
				.contains("Voc� n�o possui autoriza��o para realizar a opera��o."));
	}
	
	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_captacao_de_demanda_nao_cartela_de_selos() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());
		
		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();
		especificacaoPesquisaDemandaDTO.setCpf("90353388122");

		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);

		DemandaDTO demandaDto = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemanda.getObjetosDto(),
				new Long(13333));

		EspecificacaoCaptacaoDemandaDTO especificacaoCaptacaoDemandaDTO = new EspecificacaoCaptacaoDemandaDTO();
		especificacaoCaptacaoDemandaDTO.setDemandaDto(demandaDto);
		especificacaoCaptacaoDemandaDTO.setValor("500,00");
		especificacaoCaptacaoDemandaDTO.setReciboDto(ContextoRecibo.fabricarReciboAlternativoDto());
		ResultadoCaptacaoCartelaDeSelosDTO resultadoCaptacaoCartelaDeSelosDto = servicoSisLaraServerRmi
				.captar(especificacaoCaptacaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoCaptacaoCartelaDeSelosDto.sucesso());
		Assert.assertTrue(resultadoCaptacaoCartelaDeSelosDto.obterMensagens()
				.contains("Somente o projeto carteda de selos permite capta��o."));
	}
	
	@Test(groups = { TiposDeTeste.DEMANDA })
	public void servico_nao_efetua_captacao_de_demanda_cartela_de_selos_com_status_diferente_de_aguardando_ou_prorrogada() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());
		
		EspecificacaoPesquisaDemandaDTO especificacaoPesquisaDemandaDTO = new EspecificacaoPesquisaDemandaDTO();
		especificacaoPesquisaDemandaDTO.setCpf("72880474310");

		ResultadoListagemDemandaDTO resultadoListagemDemanda = servicoSisLaraServerRmi
				.obterListagemDemanda(especificacaoPesquisaDemandaDTO);

		DemandaDTO demandaDto = (DemandaDTO) obterDaRelacaoPorId(resultadoListagemDemanda.getObjetosDto(),
				new Long(18888));

		EspecificacaoCaptacaoDemandaDTO especificacaoCaptacaoDemandaDTO = new EspecificacaoCaptacaoDemandaDTO();
		especificacaoCaptacaoDemandaDTO.setDemandaDto(demandaDto);
		especificacaoCaptacaoDemandaDTO.setValor("500,00");
		especificacaoCaptacaoDemandaDTO.setReciboDto(ContextoRecibo.fabricarReciboAlternativoDto());
		ResultadoCaptacaoCartelaDeSelosDTO resultadoCaptacaoCartelaDeSelosDto = servicoSisLaraServerRmi
				.captar(especificacaoCaptacaoDemandaDTO, resultadoDto.getToken());

		Assert.assertFalse(resultadoCaptacaoCartelaDeSelosDto.sucesso());
		Assert.assertTrue(resultadoCaptacaoCartelaDeSelosDto.obterMensagens()
				.contains("N�o � poss�vel efetuar uma capta��o em demandas com status diferente de AGUARDANDO ou PRORROGADA."));
	}

	@Test(groups = { TiposDeTeste.RECIBO })
	public void servico_efetua_localizacao_recibo_mais_recente_por_cpf_ou_cnpj_com_sucesso()
			throws RemoteException {
		ResultadoReciboDTO resultadoRecibo = servicoSisLaraServerRmi
				.obterReciboMaisRecentePorCpfCnpj("71894810287");
		ReciboDTO reciboDTO = (ReciboDTO) resultadoRecibo.obterObjetoDtoEditado();

		Assert.assertTrue(resultadoRecibo.sucesso());
		Assert.assertEquals(reciboDTO.getNome(), "Paulo Augusto Bandeira dos Santos");
	}
	
	@Test(groups = { TiposDeTeste.RECIBO })
	public void servico_efetua_localizacao_todos_recibo_por_cpf_ou_cnpj_com_sucesso()
			throws RemoteException {
		EspecificacaoPesquisaReciboDTO especificacaoPesquisaReciboDTO = new EspecificacaoPesquisaReciboDTO();
		especificacaoPesquisaReciboDTO.adicionarParametro(ChavePesquisaDTO.CPF_CNPJ, "71894810287");
		ResultadoListagemReciboDTO resultadoListagemRecibo = servicoSisLaraServerRmi.pesquisarReciboPor(especificacaoPesquisaReciboDTO);
		
		Assert.assertTrue(resultadoListagemRecibo.sucesso());
		Assert.assertEquals(resultadoListagemRecibo.getObjetosDto().size(), 2);
	}
	
	@Test(groups = { TiposDeTeste.RECIBO })
	public void servico_efetua_localizacao_todos_recibo_por_filial_com_sucesso()
			throws RemoteException {
		EspecificacaoPesquisaReciboDTO especificacaoPesquisaReciboDTO = new EspecificacaoPesquisaReciboDTO();
		especificacaoPesquisaReciboDTO.adicionarParametro(ChavePesquisaDTO.FILIAL, "7");
		ResultadoListagemReciboDTO resultadoListagemRecibo = servicoSisLaraServerRmi.pesquisarReciboPor(especificacaoPesquisaReciboDTO);
		
		Assert.assertTrue(resultadoListagemRecibo.sucesso());
		Assert.assertEquals(resultadoListagemRecibo.getObjetosDto().size(), 2);
	}

	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_listagem_nome_documento() throws RemoteException {
		ResultadoListagemNomeDocumentoDTO resultadoNomeDocumento = servicoSisLaraServerRmi.obterListagemNomeDocumento();

		Assert.assertTrue(resultadoNomeDocumento.sucesso());
		Assert.assertEquals(resultadoNomeDocumento.getObjetosDto().size(), 9);
	}
	
	//TODO: REMOVER
	/*
	@Test(groups = { TiposDeTeste.PROJETO })
	public void servico_verifica_se_valor_total_recursos_reservados_e_maior_que_total_disponivel_para_produtos()
			throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		Registro.obterAutomatizadorTarefas().executar();
		
		ResultadoListagemProjetoDTO resultadoListagemProjetos = servicoSisLaraServerRmi
				.obterListagemProjetoAtivos();
		ProjetoDTO projetoDto = (ProjetoDTO) obterDaRelacaoPorId(
				resultadoListagemProjetos.getObjetosDto(), new Long(1222));
		projetoDto.setRecursoDisponivelDto(Arrays.asList());

		ResultadoEdicaoProjetoDTO resultadoEdicaoProjetoDTO = servicoSisLaraServerRmi
				.editarProjeto(projetoDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoProjetoDTO.sucesso());
		Assert.assertTrue(resultadoEdicaoProjetoDTO.obterMensagens()
				.contains("N�o � poss�vel haver um valor total de recursos Maquina Braille Laramara reservados maior que o total dispon�vel."));
		Assert.assertTrue(resultadoEdicaoProjetoDTO.obterMensagens()
				.contains("N�o � poss�vel haver um valor total de recursos Bengala reservados maior que o total dispon�vel."));
	}
	*/
	@Test(groups = { TiposDeTeste.PROJETO })
	public void servico_incluir_projeto_com_sucesso() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		String nomeArquivo = "teste.txt";
		String conteudoA = "Conteudo do arquivo de teste A.";
		ProjetoDTO projetoDto = ContextoProjeto.construirProjetoDTO();
		ArquivoDTO arquivoProjetoDTO = new ArquivoDTO(null, nomeArquivo, conteudoA.getBytes(), null);
		projetoDto.setArquivos(Arrays.asList(arquivoProjetoDTO));
			
		ResultadoEdicaoProjetoDTO resultadoEdicaoProjetoDTO = servicoSisLaraServerRmi
				.editarProjeto(projetoDto, resultadoDto.getToken());

		EspecificacaoPesquisaProjetoDTO especificacaoPesquisaProjetoDTO = new EspecificacaoPesquisaProjetoDTO();
		especificacaoPesquisaProjetoDTO.setProjeto(projetoDto.getNome());
		
		ResultadoListagemProjetoDTO resultadoListagemProjetoDTO = servicoSisLaraServerRmi.pesquisarProjetoPor(especificacaoPesquisaProjetoDTO);
		ProjetoDTO projetoDtoSalvo = (ProjetoDTO) obterDaRelacaoPorId(resultadoListagemProjetoDTO.getObjetosDto(), projetoDto.getId());
		
		ArquivoDTO arquivoProjetoDtoSalvo = servicoSisLaraServerRmi.obterArquivoProjetoDTO(
				projetoDtoSalvo, projetoDtoSalvo.getArquivos().get(0));
		
		Assert.assertTrue(resultadoEdicaoProjetoDTO.sucesso());
		Assert.assertEquals(arquivoProjetoDtoSalvo.obterConteudo(), arquivoProjetoDTO.obterConteudo());
	}
	
	@Test(groups = { TiposDeTeste.PROJETO })
	public void servico_nao_incluir_projeto_por_falta_de_permissao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoSemPermissao());

		ResultadoEdicaoProjetoDTO resultadoEdicaoProjetoDTO = servicoSisLaraServerRmi
				.editarProjeto(ContextoProjeto.construirProjetoDTO(), resultadoDto.getToken());

		Assert.assertFalse(resultadoEdicaoProjetoDTO.sucesso());
		Assert.assertTrue(resultadoEdicaoProjetoDTO.obterMensagens().contains("Voc� n�o possui autoriza��o para realizar a opera��o."));
	}
	
	@Test(groups = { TiposDeTeste.RECIBO })
	public void servico_inclui_recibo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ReciboDTO reciboDto = ContextoRecibo.fabricarReciboDto();
		reciboDto.setId(null);

		ResultadoEdicaoReciboDTO resultadoInclusaoRecibo = servicoSisLaraServerRmi
				.editarRecibo(reciboDto, resultadoDto.getToken());

		ReciboDTO reciboIncluidoDto = (ReciboDTO) resultadoInclusaoRecibo
				.obterObjetoDtoEditado();

		Assert.assertTrue(resultadoInclusaoRecibo.sucesso());
		Assert.assertNotNull(reciboIncluidoDto.getId());
	}
	
	@Test(groups = { TiposDeTeste.RECIBO })
	public void servico_nao_inclui_recibo_sem_autorizacao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoSemPermissao());

		ReciboDTO reciboDto = ContextoRecibo.fabricarReciboDto();
		reciboDto.setId(null);

		ResultadoEdicaoReciboDTO resultadoInclusaoRecibo = servicoSisLaraServerRmi
				.editarRecibo(reciboDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoRecibo.sucesso());
		Assert.assertTrue(resultadoInclusaoRecibo.obterMensagens()
				.contains("Voc� n�o possui autoriza��o para realizar a opera��o."));
	}
	
	@Test(groups = { TiposDeTeste.RECIBO })
	public void servico_nao_inclui_recibo_de_doacao_para_filial_diferente_de_1() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValidaAdailza());

		ReciboDTO reciboDto = ContextoRecibo.fabricarReciboDto();
		reciboDto.setId(null);

		ResultadoEdicaoReciboDTO resultadoInclusaoRecibo = servicoSisLaraServerRmi
				.editarRecibo(reciboDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoInclusaoRecibo.sucesso());
		Assert.assertTrue(resultadoInclusaoRecibo.obterMensagens()
				.contains("N�o � poss�vel gerar o recibo para a filial informada."));
	}
	
	@Test(groups = { TiposDeTeste.RECIBO })
	public void servico_nao_permite_edicao_recibo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaReciboDTO especificacao = new EspecificacaoPesquisaReciboDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.TODOS_RECIBOS, "");
		
		ResultadoListagemReciboDTO resultadoListagemRecibo = servicoSisLaraServerRmi
				.pesquisarReciboPor(especificacao);
		
		ReciboDTO reciboDto = (ReciboDTO) obterDaRelacaoPorId(resultadoListagemRecibo.getObjetosDto(), new Long(9999));
		
		ResultadoEdicaoReciboDTO resultadoAlteracaoRecibo = servicoSisLaraServerRmi
				.editarRecibo(reciboDto, resultadoDto.getToken());

		Assert.assertFalse(resultadoAlteracaoRecibo.sucesso());
		Assert.assertTrue(resultadoAlteracaoRecibo.obterMensagens().contains("N�o � poss�vel alterar o recibo."));
	}
	
	@Test(groups = { TiposDeTeste.RECIBO })
	public void servico_permite_cancelamento_recibo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaReciboDTO especificacao = new EspecificacaoPesquisaReciboDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.TODOS_RECIBOS, "");
		
		ResultadoListagemReciboDTO resultadoListagemRecibo = servicoSisLaraServerRmi
				.pesquisarReciboPor(especificacao);
		
		ReciboDTO reciboDto = (ReciboDTO) obterDaRelacaoPorId(resultadoListagemRecibo.getObjetosDto(), new Long(9999));
		
		ResultadoEdicaoReciboDTO resultadoCancelamentoRecibo = servicoSisLaraServerRmi
				.cancelarRecibo(reciboDto.getId(), "Motivo de cancelamento.", resultadoDto.getToken());

		Assert.assertTrue(resultadoCancelamentoRecibo.sucesso());
	}
	
	@Test(groups = { TiposDeTeste.RECIBO })
	public void servico_nao_permite_cancelamento_recibo_sem_autorizacao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoSemPermissao());

		EspecificacaoPesquisaReciboDTO especificacao = new EspecificacaoPesquisaReciboDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.TODOS_RECIBOS, "");
		
		ResultadoListagemReciboDTO resultadoListagemRecibo = servicoSisLaraServerRmi
				.pesquisarReciboPor(especificacao);
		
		ReciboDTO reciboDto = (ReciboDTO) obterDaRelacaoPorId(resultadoListagemRecibo.getObjetosDto(), new Long(9999));
		
		ResultadoEdicaoReciboDTO resultadoCancelamentoRecibo = servicoSisLaraServerRmi
				.cancelarRecibo(reciboDto.getId(), "Motivo de cancelamento.", resultadoDto.getToken());

		Assert.assertFalse(resultadoCancelamentoRecibo.sucesso());
		Assert.assertTrue(resultadoCancelamentoRecibo.obterMensagens().contains("Voc� n�o possui autoriza��o para realizar a opera��o."));
	}
	
	@Test(groups = { TiposDeTeste.RECIBO })
	public void servico_nao_permite_cancelamento_de_recibo_ja_cancelado() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaReciboDTO especificacao = new EspecificacaoPesquisaReciboDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.TODOS_RECIBOS, "");
		
		ResultadoListagemReciboDTO resultadoListagemRecibo = servicoSisLaraServerRmi
				.pesquisarReciboPor(especificacao);
		
		ReciboDTO reciboDto = (ReciboDTO) obterDaRelacaoPorId(resultadoListagemRecibo.getObjetosDto(), new Long(8888));
		
		ResultadoEdicaoReciboDTO resultadoCancelamentoRecibo = servicoSisLaraServerRmi
				.cancelarRecibo(reciboDto.getId(), "Motivo de cancelamento.", resultadoDto.getToken());

		Assert.assertFalse(resultadoCancelamentoRecibo.sucesso());
		Assert.assertTrue(resultadoCancelamentoRecibo.obterMensagens().contains("N�o � poss�vel cancelar o recibo novamente."));
	}
	
	@Test(groups = { TiposDeTeste.RECIBO })
	public void servico_nao_permite_cancelamento_recibo_sem_motivo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		EspecificacaoPesquisaReciboDTO especificacao = new EspecificacaoPesquisaReciboDTO();
		especificacao.adicionarParametro(ChavePesquisaDTO.TODOS_RECIBOS, "");
		
		ResultadoListagemReciboDTO resultadoListagemRecibo = servicoSisLaraServerRmi
				.pesquisarReciboPor(especificacao);
		
		ReciboDTO reciboDto = (ReciboDTO) obterDaRelacaoPorId(resultadoListagemRecibo.getObjetosDto(), new Long(9999));
		
		ResultadoEdicaoReciboDTO resultadoCancelamentoRecibo = servicoSisLaraServerRmi
				.cancelarRecibo(reciboDto.getId(), "", resultadoDto.getToken());
		
		Assert.assertFalse(resultadoCancelamentoRecibo.sucesso());
		Assert.assertTrue(resultadoCancelamentoRecibo.obterMensagens().contains("Insira um motivo de cancelamento."));
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_de_recibo() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioRecibo = servicoSisLaraServerRmi.obterRelatorioRecibo(new Long(9999), resultadoDto.getToken());
		
		Assert.assertTrue(relatorioRecibo.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioRecibo.obterConteudo(), new byte[33479]));
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_gera_relatorio_pdf_vazio_de_recibo_cancelado() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ArquivoDTO relatorioRecibo = servicoSisLaraServerRmi.obterRelatorioRecibo(new Long(8888), resultadoDto.getToken());
		
		Assert.assertTrue(relatorioRecibo.sucesso());
		Assert.assertTrue(variacaoMaximaDeBytes(relatorioRecibo.obterConteudo(), new byte[919]));
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_nao_gera_relatorio_pdf_sem_autorizacao() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoSemPermissao());

		ArquivoDTO relatorioRecibo = servicoSisLaraServerRmi.obterRelatorioRecibo(new Long(8888), resultadoDto.getToken());
		
		Assert.assertFalse(relatorioRecibo.sucesso());
		Assert.assertTrue(relatorioRecibo.obterMensagens().contains("Voc� n�o possui autoriza��o para realizar a opera��o."));
	}
	
	@Test(groups = { TiposDeTeste.INTEGRACAO_COM_DB })
	public void servico_obtem_resumo_de_integracoes_com_sucesso() throws RemoteException {
		String resumoIntegracao = servicoSisLaraServerRmi.obterResumoIntegracao("12222");

		Assert.assertTrue(resumoIntegracao.contains("Atendimento de Teste - 29/11/2014 - NAO_INTEGRACAO - Texto de motivo"));
	}
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_efetua_mudanca_de_status_em_grupos_AEE_de_provisorio_para_acesso_apos_frequencia_AT_em_reuni�o_de_integracao()
			throws RemoteException {
		
		ResultadoAutenticacaoDTO resultadoAutenticacaoAdailzaDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaAdailza());
		ResultadoAutenticacaoDTO resultadoAutenticacaoPBandeiraDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValida());
		ResultadoAutenticacaoDTO resultadoAutenticacaoVeraPereiraDto = servicoSisLaraServerRmi
				.autenticarLogin(construirCredencialDtoValidaVeraPereira());
		
		String nomeGrupoBR = "BR-2";
		Long idGrupoBR = new Long(112233);
		Long idModuloPeriodoBR = new Long(112233);
		Long idModuloUsuarioBR = new Long(112233);
		
		String nomeGrupoG = "G02-1";
		Long idGrupoG = new Long(12222);
		Long idModuloPeriodoG = new Long(11111);
		Long idModuloPeriodoGPssico = new Long(22222);
		Long idModuloUsuarioG = new Long(22222);

		Long idUsuario = new Long(72222);

		servico_altera_relacao_de_modulo_usuario_e_retornar_usuario_refenciado(resultadoAutenticacaoAdailzaDto,
				servicoSisLaraServerRmi.obterListagemGrupoAtivo(nomeGrupoBR), StatusRelacaoComModulo.PROVISORIO,
				idGrupoBR, idModuloPeriodoBR, idModuloUsuarioBR);
		
		servico_altera_relacao_de_modulo_usuario_e_retornar_usuario_refenciado(resultadoAutenticacaoPBandeiraDto,
				servicoSisLaraServerRmi.obterListagemGrupoAtivo(nomeGrupoG), StatusRelacaoComModulo.PROVISORIO,
				idGrupoG, idModuloPeriodoG, idModuloUsuarioG);
		
		Registro.obterAutomatizadorPendencia().atualizarPendencias();

		ResultadoListagemGrupoDTO resultadoListagemGrupoBRAntes = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo(nomeGrupoBR);
		GrupoDTO grupoBrDtoAntes = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupoBRAntes.getObjetosDto(), idGrupoBR);
		ModuloPeriodoDTO moduloPeriodoBrDTOAntes = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoBrDtoAntes.getModulosPeriodosDto(),
				idModuloPeriodoBR);
		ModuloUsuarioDTO moduloUsuarioBrDTOAntes = obterPeloIdUsuario(moduloPeriodoBrDTOAntes, new UsuarioDTO(idUsuario));
		
		ResultadoListagemGrupoDTO resultadoListagemGrupoGAntes = servicoSisLaraServerRmi.obterListagemGrupoAtivo(nomeGrupoG);
		GrupoDTO grupoGDtoAntes = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupoGAntes.getObjetosDto(), idGrupoG);
		ModuloPeriodoDTO moduloPeriodoGDTOAntes = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoGDtoAntes.getModulosPeriodosDto(),
				idModuloPeriodoG);
		ModuloUsuarioDTO moduloUsuarioGDTOAntes = obterPeloIdUsuario(moduloPeriodoGDTOAntes, new UsuarioDTO(idUsuario));

		EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentosDTO = new EspecificacaoGeracaoAtendimentoDTO(
				new Long(99999), "13/12/2017", new HorarioDTO("08:00", "09:00"));
		gerarEEditarAtendimento(especificacaoGeracaoAtendimentosDTO, resultadoAutenticacaoVeraPereiraDto.getToken());

		ResultadoListagemGrupoDTO resultadoListagemGrupoBRApos = servicoSisLaraServerRmi
				.obterListagemGrupoAtivo(nomeGrupoBR);
		GrupoDTO grupoBrDtoApos = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupoBRApos.getObjetosDto(), idGrupoBR);
		ModuloPeriodoDTO moduloPeriodoBrDTOApos = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoBrDtoApos.getModulosPeriodosDto(),
				idModuloPeriodoBR);
		ModuloUsuarioDTO moduloUsuarioBrDTOApos = obterPeloIdUsuario(moduloPeriodoBrDTOApos, new UsuarioDTO(idUsuario));
		
		ResultadoListagemGrupoDTO resultadoListagemGrupoGApos = servicoSisLaraServerRmi.obterListagemGrupoAtivo(nomeGrupoG);
		GrupoDTO grupoGDtoApos = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupoGApos.getObjetosDto(), idGrupoG);
		ModuloPeriodoDTO moduloPeriodoGDTOApos = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoGDtoApos.getModulosPeriodosDto(),
				idModuloPeriodoG);
		ModuloUsuarioDTO moduloUsuarioGDTOApos = obterPeloIdUsuario(moduloPeriodoGDTOApos, new UsuarioDTO(idUsuario));
		
		ModuloPeriodoDTO moduloPeriodoPssicoGDTOApos = (ModuloPeriodoDTO) obterDaRelacaoPorId(grupoGDtoApos.getModulosPeriodosDto(),
				idModuloPeriodoGPssico);
		ModuloUsuarioDTO moduloUsuarioPssicoGDTOApos = obterPeloIdUsuario(moduloPeriodoPssicoGDTOApos, new UsuarioDTO(idUsuario));
		
		Assert.assertEquals(moduloUsuarioBrDTOAntes.getStatusDto().toString(), StatusRelacaoComModulo.PROVISORIO.toString());
		Assert.assertEquals(moduloUsuarioGDTOAntes.getStatusDto().toString(), StatusRelacaoComModulo.PROVISORIO.toString());
		Assert.assertEquals(moduloUsuarioBrDTOApos.getStatusDto().toString(), StatusRelacaoComModulo.ACESSO.toString());
		Assert.assertTrue(moduloUsuarioBrDTOApos.getObs().contains(
				"Status atualizado de PROVISORIO para ACESSO devido frequencia AT em Reuni�o de Integra��o no SS-1, data 13/12/2017"));
		Assert.assertEquals(moduloUsuarioGDTOApos.getStatusDto().toString(), StatusRelacaoComModulo.ACESSO.toString());
		Assert.assertTrue(moduloUsuarioGDTOApos.getObs().contains(
				"Status atualizado de PROVISORIO para ACESSO devido frequencia AT em Reuni�o de Integra��o no SS-1, data 13/12/2017"));
		Assert.assertEquals(moduloUsuarioPssicoGDTOApos.getStatusDto().toString(), StatusRelacaoComModulo.INTEGRADO.toString());
		Assert.assertTrue(moduloUsuarioPssicoGDTOApos.getObs().contains(
				"Status atualizado de PROVISORIO para ACESSO devido frequencia AT em Reuni�o de Integra��o no SS-1, data 13/12/2017"));
	} 
	
	@Test(groups = {TiposDeTeste.GRUPO })
	public void servico_solicita_nao_salva_atendimentos_de_grupo_com_pendencia_anterior_nao_resolvida() throws RemoteException {
		ResultadoAutenticacaoDTO resultadoDto = servicoSisLaraServerRmi.autenticarLogin(construirCredencialDtoValida());

		ResultadoListagemGrupoDTO resultadoListagemGrupo = servicoSisLaraServerRmi.obterListagemGrupoAtivo("G02-1");
		GrupoDTO grupoDto = (GrupoDTO) obterDaRelacaoPorId(resultadoListagemGrupo.getObjetosDto(), new Long(12222));

		servicoSisLaraServerRmi.editarGrupo(grupoDto, resultadoDto.getToken());
		
		String dataInicial = "11/01/2016";
		EspecificacaoGeracaoAtendimentoDTO especificacaoGeracaoAtendimentosDTO = new EspecificacaoGeracaoAtendimentoDTO(
				obterDaRelacaoPorId(grupoDto.getModulosPeriodosDto(), new Long(11111)).getId(),
				dataInicial, new HorarioDTO("22:22", "23:00"));
		ResultadoEdicaoAtendimentoGrupoDTO resultadoGeracaoAtendimento = gerarEEditarAtendimento(
				especificacaoGeracaoAtendimentosDTO, resultadoDto.getToken());		

		Assert.assertFalse(resultadoGeracaoAtendimento.sucesso());
		Assert.assertTrue(resultadoGeracaoAtendimento.obterMensagens()
				.contains("Existe pend�ncia de atendimento de grupo anterior n�o resolvida."));
	}
}