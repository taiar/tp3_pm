package equipes;
import esportes.*;

import java.io.Serializable;

public class Equipe implements Serializable{
    protected String nome;
    protected Esporte.TipoDeEsporte esporte;

    public Equipe(String nome, Esporte.TipoDeEsporte esporte){
        this.nome = nome;
        this.esporte = esporte;
    }

    public Equipe() {}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEsporte(Esporte.TipoDeEsporte esporte) {
        this.esporte = esporte;
    }

    public String getNome() {
        return nome;
    }

    public Esporte.TipoDeEsporte getEsporte() {
        return esporte;
    }

    public String toString(){
        return this.nome;
    }
}
