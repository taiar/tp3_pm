package Gui.Screens;

import Database.Database;
import equipes.*;

import javax.swing.*;
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

    public CadastroCampeonatoBrasileiro() {
        this.selecaoEquipes.setModel(new DefaultComboBoxModel<EquipeDeFutebol>(
                this.vectorFromArrayList(Database.get().EquipeDeFutebol.getRegistros())
        ));
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
