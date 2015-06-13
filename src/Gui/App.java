package Gui;

import Gui.Windows.MainWindow;

public class App {

    private MainWindow appWindow;

    public App() {
        this.appWindow = MainWindow.get();
    }

    public void exec() {
        this.appWindow.showApp();
    }

}
