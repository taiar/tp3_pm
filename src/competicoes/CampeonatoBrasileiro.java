package competicoes;

import equipes.EquipeDeFutebol;
import partidas.JogoDeFutebol;
import pessoas.ComissaoTecnica;
import tabela.CelulaTabelaCompeticao;
import tabela.CelulaTabelaCompeticaoFutebol;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CampeonatoBrasileiro extends CompeticaoDeFutebol{

    private ArrayList<JogoDeFutebol> jogos1aFase;
    private ArrayList<JogoDeFutebol> jogos2aFase;

    public CampeonatoBrasileiro(String nome){
        super(nome);
        this.tabela = new ArrayList<CelulaTabelaCompeticaoFutebol>();
        this.jogos1aFase = new ArrayList<JogoDeFutebol>();
        this.jogos2aFase = new ArrayList<JogoDeFutebol>();
    }

    // TODO: transformar em private?
    protected void arranjaJogos(){
        CelulaTabelaCompeticaoFutebol equipe, adversario;

        // Arranjo matricial permite dividir entre jogos de 1a e 2a fase
        int numeroDeEquipes = this.tabela.size();
        for(int i = 0; i < numeroDeEquipes; i++){
            for(int j = 0; j < numeroDeEquipes; j++){
                // Não existe o caso "Equipe A X Equipe A"
                if(i == j){
                    continue;
                }

                equipe = this.tabela.get(i);
                adversario = this.tabela.get(j);

                if(i > j){
                    jogos1aFase.add(new JogoDeFutebol(equipe, adversario, new ComissaoTecnica()));
                }else{
                    jogos2aFase.add(new JogoDeFutebol(equipe, adversario, new ComissaoTecnica()));
                }
            }
        }
        
        Collections.shuffle(jogos1aFase);
        Collections.shuffle(jogos2aFase);
    }

    protected void processaJogo(int g){

    }

    public void processaCompeticao(){
        this.arranjaJogos();

        Scanner sc = new Scanner(System.in);

        System.out.println("1a fase:");
        for(JogoDeFutebol jogo : this.jogos1aFase){
            System.out.println(jogo);
            //jogo.setGols();
        }

        System.out.println("2a fase:");
        for(JogoDeFutebol jogo : this.jogos2aFase){
            System.out.println(jogo);
            //jogo.setGols();
        }
    }
}
