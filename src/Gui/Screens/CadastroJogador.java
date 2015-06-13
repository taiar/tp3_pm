package Gui.Screens;

import javax.swing.*;

public class CadastroJogador extends AbstractScreen {

    public CadastroJogador() {
        add(new JLabel("Aqui vai um jogador"));
    }

    @Override
    public void limpaCampos() {
        System.out.println("Limpa campos do jogador");
    }


}
