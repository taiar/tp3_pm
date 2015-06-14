package Gui.Screens;

import esportes.Esporte;

import javax.swing.*;

public class CadastroEquipe extends AbstractScreen {

    private JPanel cadastroEquipe;
    private JTextField nomeEquipe;
    private JComboBox<Esporte.TipoDeEsporte> esporte;
    private JButton cadastrarEquipeButton;
    private JTable tabelaResultados;

    public CadastroEquipe() {
        this.esporte.setModel(new DefaultComboBoxModel<Esporte.TipoDeEsporte>(Esporte.TipoDeEsporte.values()));
        this.main.add(cadastroEquipe);
    }

}
