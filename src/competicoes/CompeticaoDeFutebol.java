package competicoes;

import equipes.*;
import esportes.Esporte;
import partidas.JogoDeFutebol;
import tabela.CelulaTabelaCompeticao;
import tabela.CelulaTabelaCompeticaoFutebol;

import java.util.ArrayList;

public abstract class CompeticaoDeFutebol extends Competicao{

    protected ArrayList<CelulaTabelaCompeticaoFutebol> tabela;

    public CompeticaoDeFutebol(String nome){
        super(nome, Esporte.TipoDeEsporte.Futebol);
    }

    public void adicionaEquipesATabela(ArrayList<CelulaTabelaCompeticaoFutebol> equipes){
        this.tabela = equipes;
    }

    protected Equipe removeEquipe(){
        // @TODO
        return new EquipeDeFutebol("");
    }

}
