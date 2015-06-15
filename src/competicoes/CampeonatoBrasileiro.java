package competicoes;

import equipes.Equipe;
import equipes.EquipeDeFutebol;
import partidas.JogoDeFutebol;
import partidas.Partida;
import pessoas.ComissaoTecnica;
import tabela.CelulaTabelaCompeticao;
import tabela.CelulaTabelaCompeticaoFutebol;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;

public class CampeonatoBrasileiro extends CompeticaoDeFutebol implements Serializable {

    private ArrayList<JogoDeFutebol> jogos1aFase;
    private ArrayList<JogoDeFutebol> jogos2aFase;

    public CampeonatoBrasileiro(String nome){
        super(nome);
        this.tabela = new ArrayList<CelulaTabelaCompeticaoFutebol>();
        //this.tabela = new HashMap<Equipe, CelulaTabelaCompeticaoFutebol>();
        this.jogos1aFase = new ArrayList<JogoDeFutebol>();
        this.jogos2aFase = new ArrayList<JogoDeFutebol>();
    }

    protected CelulaTabelaCompeticaoFutebol encontraEquipeEmTabela(Equipe e){
        for(CelulaTabelaCompeticaoFutebol c : this.tabela){
            if(e.getNome().equals(c.getEquipe().getNome())){
                return c;
            }
        }

        // TODO: especificar excecao
        // Deveria ter encontrado a equipe neste ponto
        // throw new Exception("Equipe inexistente!");
        return new CelulaTabelaCompeticaoFutebol(new EquipeDeFutebol("Inexistente"));
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

    /**
     * @brief   Atualiza a tabela de acordo com os resultados de jogos
     */
    protected void atualizaTabela(JogoDeFutebol jogo){
        CelulaTabelaCompeticaoFutebol equipe1, equipe2;
        equipe1 = this.encontraEquipeEmTabela(jogo.getEquipe1());
        equipe2 = this.encontraEquipeEmTabela(jogo.getEquipe2());
        // Gols contra/a favor
        equipe1.incrementaGolsAFavor(jogo.getGolsEquipe1());
        equipe1.incrementaGolsContra(jogo.getGolsEquipe2());

        equipe2.incrementaGolsAFavor(jogo.getGolsEquipe2());
        equipe2.incrementaGolsContra(jogo.getGolsEquipe1());

        // Resultado do jogo
        switch(jogo.getResultado()){
            case EQUIPE_1_VENCE:
                equipe1.obteveVitoria();
                equipe2.obteveDerrota();
                break;
            case EQUIPE_2_VENCE:
                equipe1.obteveDerrota();
                equipe2.obteveVitoria();
            default: // Apenas pode haver empate
                equipe1.obteveEmpate();
                equipe2.obteveEmpate();
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
            sc.nextLine();
        }

        System.out.println("2a fase:");
        for(JogoDeFutebol jogo : this.jogos2aFase){
            System.out.println(jogo);
            jogo.setGols(sc.nextInt(), sc.nextInt());
            this.atualizaTabela(jogo);
            sc.nextLine();
        }

        System.out.println("Imprimindo tabela ao final do campeonato");
        // Ordena em ordem crescente. Como o oposto é desejado, inverter
        Collections.sort(this.tabela);
        Collections.reverse(this.tabela);

        for(CelulaTabelaCompeticaoFutebol c : this.tabela){
            System.out.println(c);
            System.out.println("P V D E GF GC SG");
            System.out.println(c.getPontos() + " " + c.getVitorias() + " " + c.getDerrotas() + " " +
                    c.getEmpates() + " " + c.getGolsAFavor() + " " + c.getGolsContra() +
                    " " + c.getSaldoDeGols());
        }

    }
}
