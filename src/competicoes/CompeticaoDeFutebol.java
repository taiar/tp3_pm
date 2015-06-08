package competicoes;

import equipes.*;
import esportes.Esporte;
import partidas.Partida;

import java.util.ArrayList;

public abstract class CompeticaoDeFutebol extends Competicao{

    public CompeticaoDeFutebol(String nome){
        super(nome, Esporte.TipoDeEsporte.Futebol);
    }

    protected Equipe removeEquipe(){
        // @TODO
        return new EquipeDeFutebol("");
    }

}
