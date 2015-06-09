package tabela;
import equipes.Equipe;

/**
 * @brief   Esta classe representa uma célula de tabela de competição
 */
public abstract class CelulaTabelaCompeticao {
    protected Equipe equipe;

    public CelulaTabelaCompeticao(Equipe equipe){
        this.equipe = equipe;
    }

    public Equipe getEquipe(){
        return this.equipe;
    }

    @Override
    public String toString(){
        return this.equipe.toString();
    }

}
