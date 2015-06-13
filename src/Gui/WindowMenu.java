package Gui;

import Gui.Windows.AboutWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Classe responsável por gerar o menu superior.
 */
public class WindowMenu extends JMenuBar {

    // Itens da barra de menu
    ArrayList<JMenu> menus = new ArrayList<JMenu>();

    /**
     * Faz a criação de todos os itens do menu e adiciona na lista de itens da barra de menu.
     */
    public WindowMenu() {
        // Aquivo
        // Sair
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem sair = new JMenuItem("Sair");
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuArquivo.add(sair);
        this.menus.add(menuArquivo);

        // Cadastro
        // Cadastro Time
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem time = new JMenuItem("Cadastrar novo time");
        time.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuCadastro.add(time);
        // Cadastro Campeonato
        JMenuItem campeonato = new JMenuItem("Cadastrar novo campeonato");
        campeonato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuCadastro.add(campeonato);
        this.menus.add(menuCadastro);

        // Ajuda
        // Sobre
        JMenu menuAjuda = new JMenu("Ajuda");
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
