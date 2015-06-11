package Gui;


import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow(String titulo, int sizeX, int sizeY) {
        setTitle(titulo);
        setSize(sizeX, sizeY);
    }

    public void showApp() {
        setVisible(true);
    }

    public void hideApp() {
        setVisible(false);
    }

}
