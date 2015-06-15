package Database;

import equipes.Equipe;
import equipes.EquipeDeFutebol;
import pessoas.Pessoa;

public class Database {

    public Tabela<Equipe> Equipe;
    public Tabela<pessoas.Pessoa> Pessoa;
    public Tabela<EquipeDeFutebol> EquipeDeFutebol;

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
    }

}
