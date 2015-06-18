package Gui.Windows;


import Gui.Screens.AbstractScreen;
import Gui.Screens.CadastroEquipe;
import Gui.Screens.Home;
import Gui.MainWindowMenu;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Classe responsável pela janela principal do sistema.
 */
public class MainWindow extends JFrame {

    // Barra de menu da janela principal
    private MainWindowMenu menu;

    // Telas disponíveis para uso no sistema
    private ArrayList<AbstractScreen> telas = new ArrayList<AbstractScreen>();

    // Tela atual
    private AbstractScreen telaAtual;

    // Singleton
    private static MainWindow instance;

    private MainWindow(String titulo, int sizeX, int sizeY) {
        // Dimensões e título
        setTitle(titulo);
        setSize(sizeX, sizeY);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Adiciona a barra de menu com seus itens
        this.addMenu();
        setJMenuBar(this.menu);

        // Tela inicial do sistema
        this.setTela(new Home());
    }

    // Singleton get instance.
    public static MainWindow get() {
        if(MainWindow.instance == null) {
            MainWindow.instance = new MainWindow("TP3 PM | Gerenciador de Campeonatos esportivos", 800, 600);
        }
        return MainWindow.instance;
    }

    /**
     * Muda a tela que está sendo exibida atualmente dentro da janela principal. 
     * Utilizado para navegação no sistema.
     * @param tela Tela que deve aparecer.
     */
    public void setTela(AbstractScreen tela) {
        if(this.telaAtual != null)
            remove(this.telaAtual);
        this.telaAtual = tela;
        this.add(this.telaAtual);
        this.revalidate();
        this.repaint();
    }

    public AbstractScreen getTela() {
        return this.telaAtual;
    }

    /**
     * Utilizando reflexão, identifica qual é a tela que está sendo exibida e 
     * seta uma nova instância dela, fazendo com que tenha o efeito de atualizar
     * a tela.
     */
    public void atualizarTela() {
        try {
            this.setTela((AbstractScreen) Class.forName(this.telaAtual.getClass().getName()).getConstructor().newInstance());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adiciona o menu do sistema na tela principal.
     */
    private void addMenu() {
        this.menu = new MainWindowMenu();
        this.menu.showMenu();
    }

    public void limpaTela() {
        remove(this.telaAtual);
        this.revalidate();
        this.repaint();
    }

    public void showApp() {
        setVisible(true);
    }

    public void hideApp() {
        setVisible(false);
    }

}
