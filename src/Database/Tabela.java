package Database;

import java.io.*;
import java.util.ArrayList;

public class Tabela<T> implements Serializable {

    private String nome;
    private final String diretorioDasTabelas = "./src/data/";
    private final String extensaoDasTabelas = ".tabela";
    private int ultimoIndice;
    private ArrayList<T> registros = new ArrayList<T>();

    public Tabela(String nome) {
        this.setNome(nome);
    }

    public String getPath() {
        return this.diretorioDasTabelas + this.nome + this.extensaoDasTabelas;
    }

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
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
