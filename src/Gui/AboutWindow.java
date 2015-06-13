package Gui;


import javax.swing.*;
import java.awt.*;

public class AboutWindow extends JFrame {

    private FlowLayout layout;

    public AboutWindow() {
        setTitle("Sobre o trabalho");
        setResizable(false);
        setSize(680, 600);
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
