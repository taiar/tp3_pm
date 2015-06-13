package Gui.Windows;


import Gui.Screens.AbstractScreen;
import Gui.WindowMenu;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Classe responsável pela janela principal do programa.
 */
public class MainWindow extends JFrame {

    // Barra de menu da janela principal
    private WindowMenu menu;

    // Telas disponíveis para uso no sistema
    private ArrayList<AbstractScreen> telas = new ArrayList<AbstractScreen>();

    // Singleton
    private static MainWindow instance;
    private MainWindow() {}

    private MainWindow(String titulo, int sizeX, int sizeY) {
        // Dimensões e título
        setTitle(titulo);
        setSize(sizeX, sizeY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adiciona a barra de menu com seus itens
        this.addMenu();
        setJMenuBar(this.menu);
    }

    // Singleton get instance.
    public static MainWindow get() {
        if(MainWindow.instance == null) {
            MainWindow.instance = new MainWindow("TP3 PM | Gerenciador de Campeonatos esportivos", 800, 600);
        }
        return MainWindow.instance;
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
