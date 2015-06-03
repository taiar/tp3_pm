import competicoes.*;
import equipes.*;
import java.util.ArrayList;

public class main {
    public static void main(String args[]){
        System.out.println("Vamos acompanhar o MiniCampeonato Brasileiro");

        Competicao MiniCampeonatoBrasileiro = new CompeticaoDeFutebol("MiniCampeonato Brasileiro");

        String[] nomesDeEquipes = {"Clube Atlético Mineiro", "Cruzeiro Esporte Clube",
                                   "Clube América Mineiro", "Clube de Regatas do Flamengo",
                                   "Sport Club Corinthians Paulista"};

        ArrayList<Equipe> equipesDoCampeonato = new ArrayList<>();

        for(String nomeEquipe : nomesDeEquipes){
            equipesDoCampeonato.add(new EquipeDeFutebol(nomeEquipe));
        }

        //MiniCampeonatoBrasileiro.adicionaEquipesATabela(equipesDoCampeonato);
        MiniCampeonatoBrasileiro.imprimeEquipesNaTela();
    }
}
