package tabela;
import equipes.Equipe;

/**
 * @brief   Esta classe representa uma célula de tabela de competição
 *          genérica. Subclasses implementam (Factory)
 */
public abstract class CelulaTabelaCompeticao implements Comparable{
    // A célula é comparável para permitir ordenação da tabela. Quem
    // vai implementar o método compareTo são as subclasses
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
