package br.laramara.ti.sislaraclient.controladores;

import br.laramara.ti.sislaracommons.dtos.ArquivoDTO;
import br.laramara.ti.sislaracommons.utilitarios.Sessao;
import java.rmi.RemoteException;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;

public class ControladorTelaRelatorioComasAtendidosEAtendimentosPorMunicipioSP extends ControladorTelaRelatorioApartirDeData {
        
    private JFormattedTextField jftDataInicial;
    private JFormattedTextField jftDataTermino;
        
    public ControladorTelaRelatorioComasAtendidosEAtendimentosPorMunicipioSP(JDialog telaPai, JFormattedTextField jftDataInicial, JFormattedTextField jftDataTermino){
        super(telaPai);
        this.jftDataInicial = jftDataInicial;
        this.jftDataTermino = jftDataTermino;
    }
    
    @Override
    protected ArquivoDTO obterRelatorio() throws RemoteException {
        return servicoSisLaraServer.gerarRelatorioComasAtendidosAtendimentosPorMunicipioSP(jftDataInicial.getText(), jftDataTermino.getText(), Sessao.obterInstancia().obterToken());
    }
    
}
