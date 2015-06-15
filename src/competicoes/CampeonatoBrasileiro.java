package competicoes;

import equipes.Equipe;
import equipes.EquipeDeFutebol;
import partidas.JogoDeFutebol;
import partidas.Partida;
import pessoas.ComissaoTecnica;
import tabela.CelulaTabelaCompeticao;
import tabela.CelulaTabelaCompeticaoFutebol;

import java.lang.reflect.Array;
import java.util.*;

public class CampeonatoBrasileiro extends CompeticaoDeFutebol{

    private ArrayList<JogoDeFutebol> jogos1aFase;
    private ArrayList<JogoDeFutebol> jogos2aFase;

    public CampeonatoBrasileiro(String nome){
        super(nome);
        this.tabela = new ArrayList<CelulaTabelaCompeticaoFutebol>();
        //this.tabela = new HashMap<Equipe, CelulaTabelaCompeticaoFutebol>();
        this.jogos1aFase = new ArrayList<JogoDeFutebol>();
        this.jogos2aFase = new ArrayList<JogoDeFutebol>();
    }

    // TODO: transformar em private?
    protected void arranjaJogos(){
        CelulaTabelaCompeticaoFutebol equipe, adversario;

        /* Arranjo matricial permite dividir entre jogos de 1a e 2a fase
           O triangulo superior da matriz de adjacencia formada pelos times
           forma os jogos da primeira fase, e o triangulo inferior forma
           os da segunda fase
        */

        // TODO: arranjar pelo método do polígono, se der tempo
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

    /**
     * @brief   Atualiza a tabela de acordo com os resultados de jogos
     */
    protected void atualizaTabela(JogoDeFutebol jogo){
        switch(jogo.getResultado()){
            // TODO: AQUI é o lugar onde eu pego o ID da equipe
            /*case EQUIPE_1_VENCE:
                this.tabela.get(jogo.getEquipe1()).obteveVitoria();
                this.tabela.get(jogo.getEquipe2()).obteveDerrota();
                break;
            case EQUIPE_2_VENCE:
                this.tabela.get(jogo.getEquipe2()).obteveVitoria();
                this.tabela.get(jogo.getEquipe1()).obteveDerrota();
                break;
            default: // Apenas pode haver empate
                this.tabela.get(jogo.getEquipe1()).obteveEmpate();
                this.tabela.get(jogo.getEquipe2()).obteveEmpate();
                */
        }
    }

    public void processaCompeticao(){
        this.arranjaJogos();

        Scanner sc = new Scanner(System.in);

        // Processa jogos, gols
        System.out.println("1a fase:");
        for(JogoDeFutebol jogo : this.jogos1aFase){
            System.out.println(jogo);
            jogo.setGols(sc.nextInt(), sc.nextInt());
            this.atualizaTabela(jogo);
            this.imprimeEstadoTabela();
            sc.nextLine();
        }

        System.out.println("2a fase:");
        for(JogoDeFutebol jogo : this.jogos2aFase){
            System.out.println(jogo);
            jogo.setGols(sc.nextInt(), sc.nextInt());
            this.atualizaTabela(jogo);
            this.imprimeEstadoTabela();
            sc.nextLine();
        }

    }
}
