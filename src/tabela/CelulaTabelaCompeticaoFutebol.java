package tabela;

import equipes.Equipe;

public class CelulaTabelaCompeticaoFutebol extends CelulaTabelaCompeticao{
    // pontos será função de vitorias, derrotas e empates, menos penalidades
    // private int pontos;
    protected int vitorias;
    protected int derrotas;
    protected int empates;

    public CelulaTabelaCompeticaoFutebol(Equipe equipe){
        super(equipe);
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }
}
