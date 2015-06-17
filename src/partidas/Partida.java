package partidas;

import equipes.Equipe;
import tabela.CelulaTabelaCompeticao;

public abstract class Partida {
    protected CelulaTabelaCompeticao equipe1;
    protected CelulaTabelaCompeticao equipe2;
    protected boolean ocorreu;

    public Partida(CelulaTabelaCompeticao equipe1, CelulaTabelaCompeticao equipe2){
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        ocorreu = false;
    }

    public Equipe getEquipe1(){
        return this.equipe1.getEquipe();
    }

    public Equipe getEquipe2(){
        return this.equipe2.getEquipe();
    }

    public enum ResultadosPartida{
        EQUIPE_1_VENCE,
        EMPATE,
        EQUIPE_2_VENCE
    }

}
