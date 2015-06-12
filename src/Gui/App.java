package Gui;

public class App {

    private MainWindow appWindow;

    public App() {
        this.appWindow = new MainWindow("TP3 PM | Gerenciador de Campeonatos esportivos", 800, 600);
    }

    public App(String titulo, int largura, int altura) {
        this.appWindow = new MainWindow(titulo, largura, altura);
    }

    public void exec() {
        this.appWindow.showApp();
    }

}
