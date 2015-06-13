package Gui.Screens;


import Gui.Windows.MainWindow;

import javax.swing.*;

public abstract class AbstractScreen extends JPanel {

    @Override
    public void show() {
        this.setVisible(true);
    }

    @Override
    public void hide() {
        this.setVisible(false);
    }

    public void limpaCampos() {

    }

}
