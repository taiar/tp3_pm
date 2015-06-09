package competicoes;

import partidas.JogoDeFutebol;
import pessoas.ComissaoTecnica;
import tabela.CelulaTabelaCompeticao;
import tabela.CelulaTabelaCompeticaoFutebol;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CampeonatoBrasileiro extends CompeticaoDeFutebol{

    ArrayList<JogoDeFutebol> jogos;

    public CampeonatoBrasileiro(String nome){
        super(nome);
        this.tabela = new ArrayList<CelulaTabelaCompeticaoFutebol>();
        this.jogos = new ArrayList<JogoDeFutebol>();
    }

    // TODO: transformar em private?
    protected void arranjaJogos(){
        for(CelulaTabelaCompeticaoFutebol equipe : this.tabela){
            for(CelulaTabelaCompeticaoFutebol adversario : this.tabela){
                if(! equipe.equals(adversario)){
                    // System.out.println(equipe + " X " + adversario);
                    jogos.add(new JogoDeFutebol(equipe, adversario, new ComissaoTecnica()));
                }
            }
        }

    }

    protected void processaJogo(int g){

    }

    public void processaCompeticao(){
        this.arranjaJogos();

        for(JogoDeFutebol jogo : this.jogos){
            System.out.println(jogo);
        }
    }
}
