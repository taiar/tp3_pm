package Gui.Screens;


import Database.Database;
import Gui.Windows.MainWindow;
import equipes.Equipe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Tela pai de todas as telas do sistema que funcionam sobre a MainWindow.
 */
public abstract class AbstractScreen extends JPanel {

    // Painel principal da tela aonde devem ser inseridos os próximos painéis em telas filhas.
    protected JPanel main = new JPanel();

    public AbstractScreen() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(this.main);
    }

    public void limpaCampos() {
    }

    public void atualizaModel() {
    }

}
