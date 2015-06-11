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

    protected HashMap<Equipe, CelulaTabelaCompeticaoFutebol> tabela;

    public CompeticaoDeFutebol(String nome){
        super(nome, Esporte.TipoDeEsporte.Futebol);
    }

    public void adicionaEquipesATabela(ArrayList<CelulaTabelaCompeticaoFutebol> equipes){
        for(CelulaTabelaCompeticaoFutebol ct : equipes){
            this.tabela.put(ct.getEquipe(), ct);
        }
    }

    public void imprimeEstadoTabela(){
        Set<Equipe> equipes = this.tabela.keySet();
        for(Equipe e : equipes){
            System.out.println(this.tabela.get(e));
        }
    }

    protected Equipe removeEquipe(){
        // @TODO
        return new EquipeDeFutebol("");
    }

}
