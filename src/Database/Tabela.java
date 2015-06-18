package Database;

import java.io.*;
import java.util.ArrayList;

/**
 * Implementa a simulação de uma tabela de banco de dados. Os registros da tabela são itens
 * de um ArrayList que, ao ser persistidos, são serializados e gravados em disco, em arquivo.
 * Contém métodos para inserir itens, retornar registros, carregar os dados e persistí-los.
 */
public class Tabela<T> implements Serializable {

    // Nome da tabela
    private String nome;

    // Diretório da tabela
    private final String diretorioDasTabelas = "./src/data/";
    
    // Extensão do arquivo de tabela
    private final String extensaoDasTabelas = ".tabela";
    
    // Último índice da tabela (para saber o tamanho dela)
    private int ultimoIndice;

    // Os registros da tabela, efetivamente
    private ArrayList<T> registros = new ArrayList<T>();

    /**
     *  Construtor os dados da tabela em sua inicialização
     * @param  nome Nome da tabela.
     */
    public Tabela(String nome) {
        this.setNome(nome);
        this.carrega();
    }

    /**
     * @return String com o caminha completo pro arquivo de tabela.
     */
    public String getPath() {
        return this.diretorioDasTabelas + this.nome + this.extensaoDasTabelas;
    }

    /**
     * Persiste os dados da tabela em disco serializando os dados contidos na lista registros.
     * Caso a tabela não exista em disco, o arquivo é criado e então persistido.
     */
    public void persiste() {
        try {
            FileOutputStream fos = new FileOutputStream(this.getPath());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.registros);
            oos.close();
        }
        catch (FileNotFoundException e) {
            this.criaTabelaVazia();
            this.persiste();
        } catch (IOException e) {
            System.out.println("Por algum motivo, não conseguiu persistir a tabela...");
        }
    }

    /**
     * Carrega os dados da tabela do disco em memória.
     */
    public void carrega() {
        this.carregaDadosDoDisco();
        this.ultimoIndice = this.registros.lastIndexOf(this.registros);
    }

    public void adicionaRegistro(T registro) {
        this.registros.add(registro);
    }

    public T recuperaRegistro(int indice) {
        try {
            return this.registros.get(indice);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("[ERRO]: Índice não encontrado na tabela.");
            return null;
        }
    }

    public void criaTabelaVazia() {
        try {
            File tabela = new File(this.getPath());
            if(tabela.exists())
                return;
            tabela.getParentFile().mkdirs();
            tabela.createNewFile();
        }
        catch (IOException e) {
            System.out.println("Por algum motivo, não conseguiu criar a tabela...");
        }
    }

    private void carregaDadosDoDisco() {
        try {
            FileInputStream fis = new FileInputStream(this.getPath());
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.registros = (ArrayList<T>) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Classe não encontrada.");
        } catch (IOException e) {
            this.criaTabelaVazia();
            this.persiste();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<T> getRegistros() {
        return this.registros;
    }
}
