package Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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

        // Ajuda
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
