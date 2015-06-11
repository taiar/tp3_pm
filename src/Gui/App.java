package Gui;

public class App {

    private MainWindow appWindow;

    public App() {
        this.appWindow = new MainWindow("TP3 PM | Gerenciador de Campeonatos esportivos", 800, 600);
    }

    public void exec() {
        this.appWindow.showApp();
    }

}
