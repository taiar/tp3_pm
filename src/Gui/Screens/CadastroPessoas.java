package Gui.Screens;

import Database.Database;
import Gui.Windows.MainWindow;
import equipes.Equipe;
import pessoas.Pessoa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CadastroPessoas extends AbstractScreen {

    private JPanel cadastroPessoas;
    private JTextField nomePessoa;
    private JTextField idadePessoa;
    private JButton cadastrarPessoaButton;
    private JComboBox<Pessoa.TipoDePessoa> funcaoPessoa;
    private JTable listagemPessoas;
    private DefaultTableModel listagemPessoasModel;

    public CadastroPessoas() {
        this.funcaoPessoa.setModel(new DefaultComboBoxModel<Pessoa.TipoDePessoa>(Pessoa.TipoDePessoa.values()));

        this.cadastrarPessoaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(nomePessoa.getText());
                pessoa.setFuncao(funcaoPessoa.getItemAt(funcaoPessoa.getSelectedIndex()));
                pessoa.setIdade(Integer.valueOf(idadePessoa.getText()));

                JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");

                Database.get().Pessoa.adicionaRegistro(pessoa);
                Database.get().Pessoa.persiste();

                MainWindow.get().getTela().atualizaModel();
            }
        });

        String[] colunas = new String[] { "Nome", "Idade", "Função" };
        this.listagemPessoasModel = new DefaultTableModel(this.dadosParaListagem(), colunas);
        this.listagemPessoas.setModel(this.listagemPessoasModel);
        this.main.add(cadastroPessoas);
    }

    private String[][] dadosParaListagem() {
        ArrayList<String[]> dados = new ArrayList<String[]>();
        for (Pessoa e : Database.get().Pessoa.getRegistros()) {
            dados.add(new String[] { e.getNome(), String.valueOf(e.getIdade()), e.getFuncao().toString() });
        }
        String[][] dadosString = new String[dados.size()][3];
        dadosString = dados.toArray(dadosString);
        return dadosString;
    }

    @Override
    public void atualizaModel() {
        MainWindow.get().atualizarTela();
    }
}
