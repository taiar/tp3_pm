package Gui.Screens;

import Database.Database;
import Gui.Windows.MainWindow;
import competicoes.CampeonatoBrasileiro;
import equipes.*;
import tabela.CelulaTabelaCompeticao;
import tabela.CelulaTabelaCompeticaoFutebol;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class CadastroCampeonatoBrasileiro extends AbstractScreen {
    private JTextField nomeCampeonato;
    private JPanel cadastroCampeonato;
    private JComboBox<EquipeDeFutebol> selecaoEquipes;
    private JTable equipesSelecionadas;
    private JButton inserirEquipeNoCampeonatoButton;
    private JButton cadastrarCampeonatoButton;
    private DefaultTableModel dadosTabelaEquipes;

    public CadastroCampeonatoBrasileiro() {
        this.selecaoEquipes.setModel(new DefaultComboBoxModel<EquipeDeFutebol>(
                this.vectorFromArrayList(Database.get().EquipeDeFutebol.getRegistros())
        ));

        String[] colunas = new String[] { "Nome da equipe" };
        this.dadosTabelaEquipes = new DefaultTableModel(null, colunas);
        this.equipesSelecionadas.setModel(this.dadosTabelaEquipes);
        this.inserirEquipeNoCampeonatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dadosTabelaEquipes.addRow(new String[]{selecaoEquipes.getItemAt(selecaoEquipes.getSelectedIndex()).getNome()});
            }
        });

        this.cadastrarCampeonatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CampeonatoBrasileiro campeonato = new CampeonatoBrasileiro(nomeCampeonato.getText());
                ArrayList<CelulaTabelaCompeticaoFutebol> times = new ArrayList<CelulaTabelaCompeticaoFutebol>();
                for(EquipeDeFutebol equipe : Database.get().EquipeDeFutebol.getRegistros()) {
                    Vector<String> camposDaTabela = new Vector<String>();
                    for(int i = 0; i < camposDaTabela.size(); i += 1) {
                        if(camposDaTabela.elementAt(i) == equipe.getNome()) {
                            CelulaTabelaCompeticaoFutebol adicionaNaTabela = new CelulaTabelaCompeticaoFutebol(equipe);
                            times.add(adicionaNaTabela);
                        }
                    }
                }
                campeonato.adicionaEquipesATabela(times);
                Database.get().CampeonatoBrasileiro.adicionaRegistro(campeonato);
                Database.get().CampeonatoBrasileiro.persiste();
                JOptionPane.showMessageDialog(null, "Novo campeonato cadastrado com sucesso!");
                MainWindow.get().atualizarTela();
            }
        });
        this.main.add(this.cadastroCampeonato);
    }

    private Vector<EquipeDeFutebol> vectorFromArrayList(ArrayList<EquipeDeFutebol> list) {
        Vector<EquipeDeFutebol> v = new Vector<EquipeDeFutebol>();
        for (EquipeDeFutebol e : list) {
            v.add(e);
        }
        return v;
    }
}
