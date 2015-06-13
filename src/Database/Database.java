package Database;

import equipes.Equipe;

public class Database {

    public Tabela<Equipe> Equipe;

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
        this.Equipe.carrega();
    }

}
