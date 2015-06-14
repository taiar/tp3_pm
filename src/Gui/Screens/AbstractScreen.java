package Gui.Screens;


import Gui.Windows.MainWindow;

import javax.swing.*;
import java.awt.*;

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
