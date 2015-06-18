import Gui.App;
import competicoes.*;
import equipes.*;
import tabela.CelulaTabelaCompeticaoFutebol;
import Database.Database;
import java.util.ArrayList;

public class main {

    private static void executaCampeonatoModoTerminal(){
        CampeonatoBrasileiro MiniCampeonatoBrasileiro = new CampeonatoBrasileiro("MiniCampeonato Brasileiro");

        /* A abstração previa que esta fase fosse concretizada recebendo as equipes cadastradas na
           interface gráfica */
        String[] nomesDeEquipes = {"Clube Atlético Mineiro", "Cruzeiro Esporte Clube",
                "Clube América Mineiro", "Clube de Regatas do Flamengo",
                "Sport Club Corinthians Paulista"};

        ArrayList<CelulaTabelaCompeticaoFutebol> equipesDoCampeonato = new ArrayList<CelulaTabelaCompeticaoFutebol>();

        for(String nomeEquipe : nomesDeEquipes){
            equipesDoCampeonato.add(new CelulaTabelaCompeticaoFutebol(new EquipeDeFutebol(nomeEquipe)));
        }

        MiniCampeonatoBrasileiro.adicionaEquipesATabela(equipesDoCampeonato);

        // Sabendo quais jogos teremos podemos trabalhar com os resultados
        MiniCampeonatoBrasileiro.processaCompeticao();
    }

    public static void main(String args[]){
        // Executa o campeonato em modo terminal. Comentar para ver apenas a GUI
        executaCampeonatoModoTerminal();

        // Carrega instância única do banco de dados.
        Database.get();

        // Instância da aplicação visual
        App app = new App();
        app.exec();
    }
}
