package competicoes;

import equipes.*;
import esportes.Esporte;
import partidas.JogoDeFutebol;
import tabela.CelulaTabelaCompeticao;
import tabela.CelulaTabelaCompeticaoFutebol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public abstract class CompeticaoDeFutebol extends Competicao{

    protected ArrayList<CelulaTabelaCompeticaoFutebol> tabela;

    public CompeticaoDeFutebol(String nome){
        super(nome, Esporte.TipoDeEsporte.Futebol);
    }

    public void adicionaEquipesATabela(ArrayList<CelulaTabelaCompeticaoFutebol> equipes){
        this.tabela = equipes;
    }

    public void imprimeEstadoTabela(){
        for(CelulaTabelaCompeticaoFutebol c : this.tabela){
            System.out.println(c.getEquipe());
        }
    }

    protected Equipe removeEquipe(){
        // @TODO
        return new EquipeDeFutebol("");
    }

}
