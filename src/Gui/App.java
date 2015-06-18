package Gui;

import Gui.Windows.MainWindow;

/**
 * Classe que encapsula a criação da aplicação visual e instancia o seu principal
 * elemento, a MainWindow, janela principal do sistema.
 */
public class App {

    private MainWindow appWindow;

    public App() {
        this.appWindow = MainWindow.get();
    }

    public void exec() {
        this.appWindow.showApp();
    }

}
