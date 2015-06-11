package Gui;


import javax.swing.*;

public class MainWindow extends JFrame {

    private WindowMenu menu;

    public MainWindow(String titulo, int sizeX, int sizeY) {
        setTitle(titulo);
        setSize(sizeX, sizeY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addMenu();
        setJMenuBar(this.menu);
    }

    private void addMenu() {
        this.menu = new WindowMenu();
        this.menu.showMenu();
    }

    public void showApp() {
        setVisible(true);
    }

    public void hideApp() {
        setVisible(false);
    }

}
