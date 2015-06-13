package Gui.Screens;

import Database.Database;
import Gui.Windows.MainWindow;
import equipes.Equipe;
import equipes.EquipeDeFutebol;
import esportes.Esporte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

public class CadastroEquipe extends AbstractScreen {

    private JTextField nomeEquipe;
    private JComboBox<Esporte.TipoDeEsporte> esporte;
    private JButton cadastrar;

    public CadastroEquipe() {
        setLayout(new GridLayout(3, 1));

        add(new JLabel("Criar uma nova equipe"));

        JPanel formulario = new JPanel();
        formulario.setSize(200, 250);
        GridLayout layout = new GridLayout(3, 2);
        formulario.setLayout(layout);

        formulario.add(new JLabel("Nome da equipe: "));
        nomeEquipe = new JTextField();
        formulario.add(nomeEquipe);

        formulario.add(new JLabel("Esporte: "));
        esporte = new JComboBox<Esporte.TipoDeEsporte>(Esporte.TipoDeEsporte.values());
        formulario.add(esporte);

        cadastrar = new JButton("Cadastrar equipe");
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipe novaEquipe = new Equipe();
                novaEquipe.setEsporte(esporte.getItemAt(esporte.getSelectedIndex()));
                novaEquipe.setNome(nomeEquipe.getText());
                Database.get().Equipe.adicionaRegistro(novaEquipe);
                Database.get().Equipe.persiste();
                JOptionPane.showMessageDialog(null, "Equipe cadastrada com sucesso!");
                MainWindow.get().getTela().limpaCampos();
            }
        });
        formulario.add(cadastrar);

        add(formulario);
    }

    @Override
    public void limpaCampos() {
        System.out.println("Limpa campos do jogador");
        this.nomeEquipe.setText("");
        this.esporte.setSelectedIndex(Esporte.TipoDeEsporte.Futebol.ordinal());
    }


}
