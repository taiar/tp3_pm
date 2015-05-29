package competicoes;

import esportes.Esporte;
import partidas.Partida;
import equipes.Equipe;
import java.util.ArrayList;

public abstract class Competicao {
    protected String nome;
    protected ArrayList<Equipe> equipes;
    protected Esporte esporte;

    public Competicao(String nome, Esporte esporte){
        this.nome = nome;
        this.esporte = esporte;
        this.equipes = new ArrayList<Equipe>();
    }

    protected abstract void adicionaEquipe();

    protected abstract Equipe removeEquipe();

    /*  Este método é responsável por arranjar as equipes
     *  no formato requerido pela competição */
    protected abstract void arranjaEquipes();

    /* Este método é responsável por processar um jogo dentro do
     * fluxo de controle do campeonato */
    protected abstract void processaPartida(Partida p);

    /* Este método público é responsável pelo processamento da competição.
     * A ideia é que a entidade que executa a competição deve apenas
     * instanciar a competição e chamar este método */
    public abstract void processaCompeticao();
}
