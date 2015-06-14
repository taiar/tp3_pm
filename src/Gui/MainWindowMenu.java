package Gui;

import Gui.Screens.CadastroEquipe;
import Gui.Screens.Home;
import Gui.Windows.AboutWindow;
import Gui.Windows.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Classe responsável por gerar o menu superior.
 */
public class MainWindowMenu extends JMenuBar {

    // Itens da barra de menu
    ArrayList<JMenu> menus = new ArrayList<JMenu>();

    /**
     * Faz a criação de todos os itens do menu e adiciona na lista de itens da barra de menu.
     */
    public MainWindowMenu() {
        /**
         * Aquivo
         */
        JMenu menuArquivo = new JMenu("Arquivo");

        // Início
        JMenuItem inicio = new JMenuItem("Início");
        inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainWindow.get().setTela(new Home());
            }
        });
        menuArquivo.add(inicio);
        this.menus.add(menuArquivo);

        // Sair
        JMenuItem sair = new JMenuItem("Sair");
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuArquivo.add(sair);
        this.menus.add(menuArquivo);


        /**
         * Cadastro
         */
        JMenu menuCadastro = new JMenu("Cadastro");

        // Cadastro Time
        JMenuItem time = new JMenuItem("Criar nova equipe");
        time.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainWindow.get().setTela(new CadastroEquipe());
            }
        });
        menuCadastro.add(time);
        // Cadastro Campeonato
        JMenuItem campeonato = new JMenuItem("Criar novo campeonato");
        campeonato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuCadastro.add(campeonato);
        this.menus.add(menuCadastro);

        /**
         * Ajuda
         */
        JMenu menuAjuda = new JMenu("Ajuda");
        // Sobre
        JMenuItem sobre = new JMenuItem("Sobre");
        sobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutWindow about = new AboutWindow();
            }
        });
        menuAjuda.add(sobre);
        this.menus.add(menuAjuda);
    }

    /**
     * Adiciona menu à barra de menus.
     */
    public void showMenu() {
        for(JMenu menu : this.menus) {
            add(menu);
        }
    }
}
