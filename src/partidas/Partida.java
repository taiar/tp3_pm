package partidas;

import tabela.CelulaTabelaCompeticao;

public abstract class Partida {
    protected CelulaTabelaCompeticao equipe1;
    protected CelulaTabelaCompeticao equipe2;

    public Partida(CelulaTabelaCompeticao equipe1, CelulaTabelaCompeticao equipe2){
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
    }

    public static enum ResultadosPartida{
        EQUIPE_1_VENCE,
        EMPATE,
        EQUIPE_2_VENCE
    }

}
