package pessoas;

import java.io.Serializable;

public class Pessoa implements Serializable {

    private String nome;
    private int idade;
    private TipoDePessoa funcao;

    public enum TipoDePessoa {
        Jogador,
        ComissaoTecnica,
        Arbitro
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public TipoDePessoa getFuncao() {
        return funcao;
    }

    public void setFuncao(TipoDePessoa funcao) {
        this.funcao = funcao;
    }
}
