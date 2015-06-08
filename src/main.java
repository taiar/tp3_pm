import competicoes.*;
import equipes.*;
import java.util.ArrayList;

public class main {
    public static void main(String args[]){
        System.out.println("Vamos acompanhar o MiniCampeonato Brasileiro");

        Competicao MiniCampeonatoBrasileiro = new CampeonatoBrasileiro("MiniCampeonato Brasileiro");

        String[] nomesDeEquipes = {"Clube Atlético Mineiro", "Cruzeiro Esporte Clube",
                                   "Clube América Mineiro", "Clube de Regatas do Flamengo",
                                   "Sport Club Corinthians Paulista"};

        ArrayList<Equipe> equipesDoCampeonato = new ArrayList<>();

        for(String nomeEquipe : nomesDeEquipes){
            equipesDoCampeonato.add(new EquipeDeFutebol(nomeEquipe));
        }

        //MiniCampeonatoBrasileiro.adicionaEquipesATabela(equipesDoCampeonato);
        MiniCampeonatoBrasileiro.imprimeEquipesNaTela();

        // Devemos arranjar os jogos de acordo com o campeonato
        // arranjaJogos está como privado, e acredito que deve ser mantido assim.
        // Coloco sendo executado aqui apenas para ilustrar o fluxo
        MiniCampeonatoBrasileiro.arranjaJogos();

        // Após arranjar os jogos devemos exibi-los
        MiniCampeonatoBrasileiro.exibeJogos();

        // Sabendo quais jogos teremos podemos trabalhar com os resultados
        MiniCampeonatoBrasileiro.processaCompeticao();

        // Para que se acesse jogo a jogo (especialmente na interface gráfica) deve-se
        // ter um método acessório para os jogos
        MiniCampeonatoBrasileiro.exibeJogoEspecifico();

        // Com a competição processada, podemos salvá-la para acesso futuro
        // Após realizada a competição é imutável!
        MiniCampeonatoBrasileiro.salva();
    }
}
