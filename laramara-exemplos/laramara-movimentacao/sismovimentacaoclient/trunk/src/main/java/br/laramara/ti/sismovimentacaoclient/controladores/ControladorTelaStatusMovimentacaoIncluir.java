
package br.laramara.ti.sismovimentacaoclient.controladores;

import br.laramara.ti.sismovimentacaocommons.dtos.ResultadoDTO;
import br.laramara.ti.sismovimentacaocommons.dtos.movimentacao.MovimentacaoDTO;
import br.laramara.ti.sismovimentacaocommons.utilitarios.Sessao;
import java.rmi.RemoteException;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;

public class ControladorTelaStatusMovimentacaoIncluir extends ControladorTelaEditarStatus {

    private JFormattedTextField jftData;
    private JFormattedTextField jftHora;
    
    public ControladorTelaStatusMovimentacaoIncluir(JDialog telaPai, JComboBox jcbStatus, JFormattedTextField jftData, JFormattedTextField jftHora){
        super(telaPai, null, jcbStatus);
        this.jftData = jftData;
        this.jftHora = jftHora;
    }
    
    @Override
    protected void prepararDtoParaEditar() {
    }
        
    @Override
    protected ResultadoDTO solicitarEdicaoDto() throws RemoteException {
        return servicoSisMovimentacaoServer.incluirMovimentacao(jftData.getText()+" "+jftHora.getText(), Sessao.obterInstancia().obterToken());
    }
    
    @Override
    public void carregarCampos() {
    }
    
    @Override
    protected boolean verificarSeDtoEstaPreenchido() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void atualizarCamposTelaAposInclusao() {
    }

    private MovimentacaoDTO obterObjetoDTO() {
        return null;
    }
}
