package competicoes;

import equipes.*;
import esportes.Esporte;
import partidas.Partida;

import java.util.ArrayList;

public class CompeticaoDeFutebol extends Competicao{

    public CompeticaoDeFutebol(String nome){
        super(nome, Esporte.TipoDeEsporte.Futebol);
    }

    protected void adicionaEquipe(){

    }

    protected Equipe removeEquipe(){
        // @TODO
        return new EquipeDeFutebol("");
    }

    protected void arranjaEquipes(){

    }

    /* Este método é responsável por processar um jogo dentro do
     * fluxo de controle do campeonato */
    protected void processaPartida(Partida p){

    }

    /* Este método público é responsável pelo processamento da competição.
     * A ideia é que a entidade que executa a competição deve apenas
     * instanciar a competição e chamar este método */
    public void processaCompeticao(){
        
    }
}
