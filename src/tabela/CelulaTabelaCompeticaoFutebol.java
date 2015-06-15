package tabela;

import equipes.EquipeDeFutebol;

public class CelulaTabelaCompeticaoFutebol extends CelulaTabelaCompeticao{
    protected static final Integer PONTOS_VITORIA = 3;
    protected static final Integer PONTOS_EMPATE = 1;
    protected static final Integer PONTOS_DERROTA = 0;

    // pontos será função de vitorias, derrotas e empates, menos penalidades
    // private int pontos;
    protected int vitorias;
    protected int derrotas;
    protected int empates;

    protected int golsAFavor;
    protected int golsContra;

    public CelulaTabelaCompeticaoFutebol(EquipeDeFutebol equipe){
        super(equipe);
    }

    public Integer getVitorias() {
        return vitorias;
    }

    /*public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }*/
    public void obteveVitoria(){
        this.vitorias++;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void obteveDerrota(){
        this.derrotas++;
    }
    /*public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }*/

    public int getEmpates() {
        return empates;
    }

    public void obteveEmpate(){
        this.empates++;
    }
    /*public void setEmpates(int empates) {
        this.empates = empates;
    }*/
    public String toString(){
        return this.equipe.toString();
    }

    public Integer getPontos(){
        Integer pontos = this.vitorias * PONTOS_VITORIA +
                     this.empates * PONTOS_EMPATE +
                     this.empates * PONTOS_DERROTA;

        return pontos;
    }

    // A.compareTo(B) = -1, A<B; 0, A==B; 1, A>B
    public int compareTo(Object celula){
        CelulaTabelaCompeticaoFutebol c = (CelulaTabelaCompeticaoFutebol)celula;
        // 1a regra de desempate: pontos
        int pontos = this.getPontos().compareTo(c.getPontos());
        if(pontos != 0){
            return pontos;
        }

        // 2a regra de desempate: número de vitórias
        int vitorias = this.getVitorias().compareTo(c.getVitorias());
        if(vitorias != 0){
            return vitorias;
        }

        // 3a regra de desempate: saldo de gols
        int sdg = this.getSaldoDeGols().compareTo(c.getSaldoDeGols());
        return sdg;

        //3a regra de desempate: cartões
    }

    public void incrementaGolsAFavor(int gols){
        this.golsAFavor += gols;
    }

    public int getGolsAFavor(){
        return this.golsAFavor;
    }

    public void incrementaGolsContra(int gols){
        this.golsContra += gols;
    }

    public int getGolsContra(){
        return this.golsContra;
    }

    public Integer getSaldoDeGols(){
        return this.golsAFavor - this.golsContra;
    }
}
