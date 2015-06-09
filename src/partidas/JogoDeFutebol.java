package partidas;

import pessoas.Pessoa;
import tabela.CelulaTabelaCompeticao;
import tabela.CelulaTabelaCompeticaoFutebol;

public class JogoDeFutebol extends Partida {
    protected int golsEquipe1;
    protected int golsEquipe2;

    protected int cartoesAmarelosEquipe1;
    protected int getCartoesAmarelosEquipe2;

    protected int cartoesVermelhosEquipe1;
    protected int getCartoesVermelhosEquipe2;

    protected Pessoa arbitro;

    // TODO: estadio?

    public JogoDeFutebol(CelulaTabelaCompeticaoFutebol equipe1, CelulaTabelaCompeticaoFutebol equipe2,
                         Pessoa arbitro){
        super(equipe1, equipe2);
        this.arbitro = arbitro;
    }

    // Assumindo que resultados do tipo penaltis sao contabilizados como gols normais
    public void setGols(int golsEquipe1, int golsEquipe2){
        this.golsEquipe1 = golsEquipe1;
        this.golsEquipe2 = golsEquipe2;
    }

    public ResultadosPartida getResultado(){
        if(golsEquipe1 > golsEquipe2){
            return ResultadosPartida.EQUIPE_1_VENCE;
        }
        if(golsEquipe2 < golsEquipe1){
            return ResultadosPartida.EQUIPE_2_VENCE;
        }

        return ResultadosPartida.EMPATE;
    }

    public String toString(){
        return this.equipe1 + " X " + this.equipe2;
    }
}
