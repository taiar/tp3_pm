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
        sair.addActionListener(new ExitListener());
        menuArquivo.add(new JMenuItem("Sair"));
        this.menus.add(menuArquivo);
    }

    public void showMenu() {
        for(JMenu menu : this.menus) {
            add(menu);
        }
    }

    private class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//            int confirm = JOptionPane.showOptionDialog(frame,
//                    "Are You Sure to Close this Application?",
//                    "Exit Confirmation", JOptionPane.YES_NO_OPTION,
//                    JOptionPane.QUESTION_MESSAGE, null, null, null);
//            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
//            }
        }
    }
}

