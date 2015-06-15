package Database;

import equipes.Equipe;
import pessoas.Pessoa;

public class Database {

    public Tabela<Equipe> Equipe;
    public Tabela<pessoas.Pessoa> Pessoa;

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
        this.Pessoa = new Tabela<Pessoa>("Pessoa");
    }

}
