package Gui.Windows;


import javax.swing.*;
import java.awt.*;

/**
 * Tela com dados sobre os desenvolvedores do sistema. Contém uma foto.
 */
public class AboutWindow extends JFrame {

    private FlowLayout layout;

    public AboutWindow() {
        setTitle("Sobre o trabalho");
        setResizable(false);
        setSize(680, 580);
        this.layout = new FlowLayout(FlowLayout.CENTER);
        this.setLayout(this.layout);
        this.add(new JLabel("Trabalho 3 de Programação Modular - Gerenciador de eventos esportivos"));
        ImageIcon imagem = new ImageIcon("./src/assets/feio.jpg");
        JLabel foto = new JLabel();
        foto.setIcon(imagem);
        this.add(foto);
        this.add(new JLabel("Desenvolvido por André Taiar (taiar@dcc) e Gustavo Pereira (ghapereira@dcc)"));
        setVisible(true);
    }
}
