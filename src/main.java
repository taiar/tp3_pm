import Gui.App;
        import competicoes.*;
        import equipes.*;
        import tabela.CelulaTabelaCompeticaoFutebol;
        import Database.Database;

        import java.util.ArrayList;

public class main {
    public static void main(String args[]){
        CampeonatoBrasileiro MiniCampeonatoBrasileiro = new CampeonatoBrasileiro("MiniCampeonato Brasileiro");

        String[] nomesDeEquipes = {"Clube Atlético Mineiro", "Cruzeiro Esporte Clube",
                "Clube América Mineiro", "Clube de Regatas do Flamengo",
                "Sport Club Corinthians Paulista"};

        ArrayList<CelulaTabelaCompeticaoFutebol> equipesDoCampeonato = new ArrayList<CelulaTabelaCompeticaoFutebol>();

        for(String nomeEquipe : nomesDeEquipes){
            equipesDoCampeonato.add(new CelulaTabelaCompeticaoFutebol(new EquipeDeFutebol(nomeEquipe)));
        }

        MiniCampeonatoBrasileiro.adicionaEquipesATabela(equipesDoCampeonato);

        // Após arranjar os jogos devemos exibi-los
        // MiniCampeonatoBrasileiro.exibeJogos();

        // Sabendo quais jogos teremos podemos trabalhar com os resultados
        MiniCampeonatoBrasileiro.processaCompeticao();

        // Para que se acesse jogo a jogo (especialmente na interface gráfica) deve-se
        // ter um método acessório para os jogos
        // MiniCampeonatoBrasileiro.exibeJogoEspecifico();

        // Com a competição processada, podemos salvá-la para acesso futuro
        // Após realizada a competição é imutável!
        // MiniCampeonatoBrasileiro.salva();*/

        Database.get();
        App app = new App();
        app.exec();
    }
}
