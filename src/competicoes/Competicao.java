package competicoes;

import esportes.Esporte;
import equipes.Equipe;
import tabela.CelulaTabelaCompeticao;

import java.util.ArrayList;

public abstract class Competicao {
    protected String nome;
    protected ArrayList<CelulaTabelaCompeticao> tabela;
    protected Esporte.TipoDeEsporte esporte;

    public Competicao(String nome, Esporte.TipoDeEsporte esporte){
        this.nome = nome;
        this.esporte = esporte;
        this.tabela = new ArrayList<CelulaTabelaCompeticao>();
    }

    /*  Este método é responsável por arranjar os jogos
     *  das equipes no formato requerido pela competição */
    protected abstract void arranjaJogos();

    /* Este método público é responsável pelo processamento da competição.
     * A ideia é que a entidade que executa a competição deve apenas
     * instanciar a competição e chamar este método */
    public abstract void processaCompeticao();
}
