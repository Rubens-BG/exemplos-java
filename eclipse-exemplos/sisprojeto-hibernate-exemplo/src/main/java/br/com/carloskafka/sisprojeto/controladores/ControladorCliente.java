package br.com.carloskafka.sisprojeto.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.carloskafka.sisprojeto.dominio.Cliente;
import br.com.carloskafka.sisprojeto.repositorios.RepositorioCliente;
import br.com.carloskafka.sisprojeto.utilitarios.Mensagem;

public class ControladorCliente extends ControladorTelaPesquisaBase {

    private JTextField jtfId;
    private JTextField jtfNome;
    private JTextField jtfCpf;
    private JTextField jtfEndereco;
    private JTextField jtfEmail;
    private JTextField jtfTelefone;
    private Cliente cliente;

    private RepositorioCliente repositorioCliente;

    public ControladorCliente(JTextField jtfId, JTextField jtfNome,
            JTextField jtfCpf, JTextField jtfEndereco, JTextField jtfEmail,
            JTextField jtfTelefone, JTable jtaCliente, JDialog telaPai) {
        super(telaPai);
        this.jtfId = jtfId;
        this.jtfNome = jtfNome;
        this.jtfCpf = jtfCpf;
        this.jtfEndereco = jtfEndereco;
        this.jtfEmail = jtfEmail;
        this.jtfTelefone = jtfTelefone;
        this.jtaTabela = jtaCliente;
        repositorioCliente = new RepositorioCliente();
    }

    /* Inicializar o objeto cliente, passando os valores da tela */
    public Cliente inicializarObjeto(Cliente cliente) {
        cliente.setNome(jtfNome.getText());
        cliente.setCpf(jtfCpf.getText());
        cliente.setEndereco(jtfEndereco.getText());
        cliente.setEmail(jtfEmail.getText());
        cliente.setTelefone(jtfTelefone.getText());

        return cliente;
    }

    public void obterTodos() {
        List<Object[]> clientesObjetos = new ArrayList<Object[]>();
        List<Cliente> clientes = repositorioCliente.obterTodos();
        for (Cliente cliente : clientes) {
            Object[] clienteObjeto = obterCliente(cliente);
            clientesObjetos.add(clienteObjeto);
        }

        carregarTabela(clientesObjetos);

    }

    public void excluir() {
        if (repositorioCliente.obterPorId(new Long(jtfId.getText())) != null) {
            int resposta = Integer
                    .parseInt(Mensagem
                            .exibirPergunta("Deseja realmente excluir o cliente? 1 - Sim 2 - Nao"));
            if (resposta == 1) {
                if (repositorioCliente.excluir(new Long(jtfId.getText()))) {
                    Mensagem
                            .exibirMensagem("Cliente foi excluído com sucesso.");
                } else {
                    Mensagem.exibirMensagem("Falha ao excluir o cliente.");
                }
            }
        }

    }

    public void salvar() {
        cliente = new Cliente();

        cliente = inicializarObjeto(cliente);

        if (repositorioCliente.incluir(cliente)) {
            Mensagem.exibirMensagem("Cliente " + cliente.toString()
                    + " foi salvo com sucesso.");
        } else {
            Mensagem.exibirMensagem("Falha ao salvar o cliente "
                    + cliente.toString() + ".");
        }
    }

    public void obterPorId() {
        cliente = new Cliente();

        Cliente clienteObtido = null;
        if (possuiId()) {
            cliente.setId(new Long(jtfId.getText()));
            clienteObtido = repositorioCliente.obterPorId(cliente.getId());
        }

        if (clienteObtido != null) {
            jtfId.setText(clienteObtido.getId().toString());
            jtfNome.setText(clienteObtido.getNome());
            jtfCpf.setText(clienteObtido.getCpf());
            jtfEndereco.setText(clienteObtido.getEndereco());
            jtfEmail.setText(clienteObtido.getEmail());
            jtfTelefone.setText(clienteObtido.getTelefone());
        }
    }

    public void alterar() {
        cliente = new Cliente();
        cliente = inicializarObjeto(cliente);
        cliente.setId(new Long(jtfId.getText()));

        if (repositorioCliente.obterPorId(cliente.getId()) != null) {
            if (repositorioCliente.alterar(cliente)) {
                Mensagem.exibirMensagem("Cliente " + cliente.toString()
                        + " foi alterado com sucesso.");
            } else {
                Mensagem.exibirMensagem("Falha ao alterar o cliente "
                        + cliente.toString() + ".");
            }
        }
    }

    public void pesquisar() {
        cliente = new Cliente();
        cliente = inicializarObjeto(cliente);

        List<Cliente> clientesObtidos = new ArrayList<Cliente>();
        if (possuiId()) {
            cliente.setId(new Long(jtfId.getText()));
            clientesObtidos.add(repositorioCliente.obterPorId(cliente.getId()));
        } else {
            clientesObtidos = repositorioCliente.pesquisar(cliente);
        }

        List<Object[]> clientesObjetos = new ArrayList<Object[]>();

        for (Cliente cliente : clientesObtidos) {
            Object[] clienteObjeto = obterCliente(cliente);
            clientesObjetos.add(clienteObjeto);
        }

        carregarTabela(clientesObjetos);

        limparCampos();
    }

    public Object[] obterCliente(Cliente cliente) {
        Object[] clientes = new Object[]{cliente.getId(), cliente.getNome(),
            cliente.getCpf(), cliente.getEndereco(),
            cliente.getEmail(), cliente.getTelefone()};

        return clientes;
    }

    public void limparCampos() {
        // jtfId.setText("");
        jtfNome.setText("");
        jtfCpf.setText("");
        jtfEndereco.setText("");
        jtfEmail.setText("");
        jtfTelefone.setText("");
    }

    private boolean possuiId() {
        return jtfId.getText() != null && !jtfId.getText().isEmpty();
    }

}
