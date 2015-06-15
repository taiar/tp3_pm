package Database;

import competicoes.CampeonatoBrasileiro;
import equipes.Equipe;
import equipes.EquipeDeFutebol;
import pessoas.Pessoa;
import tabela.CelulaTabelaCompeticaoFutebol;

public class Database {

    public Tabela<Equipe> Equipe;
    public Tabela<pessoas.Pessoa> Pessoa;
    public Tabela<EquipeDeFutebol> EquipeDeFutebol;
    public Tabela<CampeonatoBrasileiro> CampeonatoBrasileiro;
    public Tabela<CelulaTabelaCompeticaoFutebol> CelulaTabelaCompeticaoFutebol;

    // Singleton
    private static Database instance;
    private Database() {}
    public static Database get() {
        if(Database.instance == null) {
            Database.instance = new Database();
            Database.instance.init();
        }
        return Database.instance;
    }

    private void init() {
        this.Equipe = new Tabela<Equipe>("Equipe");
        this.EquipeDeFutebol = new Tabela<EquipeDeFutebol>("EquipeDeFutebol");
        this.Pessoa = new Tabela<Pessoa>("Pessoa");
        this.CelulaTabelaCompeticaoFutebol = new Tabela<tabela.CelulaTabelaCompeticaoFutebol>("CelulaTabelaCompeticaoFutebol");
        this.CampeonatoBrasileiro = new Tabela<competicoes.CampeonatoBrasileiro>("CampeonatoBrasileiro");
    }

}
