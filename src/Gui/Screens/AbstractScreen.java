package Gui.Screens;


import Database.Database;
import Gui.Windows.MainWindow;
import equipes.Equipe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class AbstractScreen extends JPanel {

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
