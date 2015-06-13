package Gui;


import javax.swing.*;

/**
 * Classe responsável pela janela principal do programa.
 */
public class MainWindow extends JFrame {

    // Barra de menu da janela principal
    private WindowMenu menu;

    public MainWindow(String titulo, int sizeX, int sizeY) {
        // Dimensões e título
        setTitle(titulo);
        setSize(sizeX, sizeY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adiciona a barra de menu com seus itens
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
