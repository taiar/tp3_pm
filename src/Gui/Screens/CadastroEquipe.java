package Gui.Screens;

import Database.Database;
import Gui.Windows.MainWindow;
import equipes.Equipe;
import esportes.Esporte;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CadastroEquipe extends AbstractScreen {

    private JPanel cadastroEquipe;
    private JTextField nomeEquipe;
    private JComboBox<Esporte.TipoDeEsporte> esporte;
    private JButton cadastrarEquipeButton;
    private JTable tabelaResultados;
    private DefaultTableModel tabelaResultadosModel;

    public CadastroEquipe() {
        this.esporte.setModel(new DefaultComboBoxModel<Esporte.TipoDeEsporte>(Esporte.TipoDeEsporte.values()));
        cadastrarEquipeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipe novaEquipe = new Equipe();
                novaEquipe.setEsporte(esporte.getItemAt(esporte.getSelectedIndex()));
                novaEquipe.setNome(nomeEquipe.getText());
                Database.get().Equipe.adicionaRegistro(novaEquipe);
                Database.get().Equipe.persiste();
                JOptionPane.showMessageDialog(null, "Equipe cadastrada com sucesso!");
                MainWindow.get().getTela().limpaCampos();
                MainWindow.get().getTela().atualizaModel();
            }
        });
        String[] colunas = new String[] { "Nome", "Esporte" };
        this.tabelaResultadosModel = new DefaultTableModel(this.dadosParaListagem(), colunas);
        this.tabelaResultados.setModel(this.tabelaResultadosModel);
        this.main.add(cadastroEquipe);
    }

    private String[][] dadosParaListagem() {
        ArrayList<String[]> dados = new ArrayList<String[]>();
        for (Equipe e : Database.get().Equipe.getRegistros()) {
            dados.add(new String[] { e.getNome(), e.getEsporte().toString() });
        }
        String[][] dadosString = new String[dados.size()][2];
        dadosString = dados.toArray(dadosString);
        return dadosString;
    }

    @Override
    public void limpaCampos() {
        this.nomeEquipe.setText("");
        this.esporte.setSelectedIndex(Esporte.TipoDeEsporte.Futebol.ordinal());
    }

    @Override
    public void atualizaModel() {
        MainWindow.get().atualizarTela();
    }

}
