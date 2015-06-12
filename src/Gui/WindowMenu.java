package Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class WindowMenu extends JMenuBar {

    ArrayList<JMenu> menus = new ArrayList<JMenu>();

    public WindowMenu() {
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
    }

    public void showMenu() {
        for(JMenu menu : this.menus) {
            add(menu);
        }
    }
}
