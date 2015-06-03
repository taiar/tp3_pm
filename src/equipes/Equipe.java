package equipes;
import esportes.*;

public abstract class Equipe {
    protected String nome;
    protected Esporte.TipoDeEsporte esporte;

    public Equipe(String nome, Esporte.TipoDeEsporte esporte){
        this.nome = nome;
        this.esporte = esporte;
    }

    public String toString(){
        return this.nome;
    }
}
