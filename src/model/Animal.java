package model;

/**
 * Classe Animal - Superclasse que representa um animal genérico.
 * Contém propriedades comuns a todos os tipos de animais.
 * Pode ser estendida por outras classes como Bovino.
 * 
 * @author Lucas
 */
public class Animal {

    // ========== PROPRIEDADES COMUNS ==========

    /** ID único do animal */
    protected int id;

    /** Nome do animal */
    protected String nome;

    /** Peso do animal em quilogramas */
    protected double peso;

    /** Idade do animal em meses */
    protected int idade;

    /**
     * Construtor vazio.
     * Usado para criar um objeto Animal sem definir os atributos inicialmente.
     */
    public Animal() {}

    /**
     * Construtor com parâmetros.
     * 
     * @param id ID do animal.
     * @param nome Nome do animal.
     * @param peso Peso do animal em kg.
     * @param idade Idade do animal em meses.
     */
    public Animal(int id, String nome, double peso, int idade) {
        this.id = id;
        this.nome = nome;
        this.setPeso(peso);
        this.setIdade(idade);
    }

    /**
     * Retorna o ID do animal.
     * @return ID numérico.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do animal.
     * @param id Valor numérico do ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o nome do animal.
     * @return Nome do animal.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do animal.
     * @param nome Nome a ser atribuído.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o peso do animal.
     * @return Peso em kg.
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Define o peso do animal.
     * @param peso Peso em kg.
     * @throws IllegalArgumentException se o peso for negativo.
     */
    private void setPeso(double peso) {
        if (peso < 0) {
            throw new IllegalArgumentException("O peso não pode ser negativo.");
        }
        this.peso = peso;
    }

    /**
     * Retorna a idade do animal.
     * @return Idade em meses.
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Define a idade do animal.
     * @param idade Idade em meses.
     * @throws IllegalArgumentException se a idade for negativa.
     */
    private void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("A idade não pode ser negativa.");
        }
        this.idade = idade;
    }

    /**
     * Retorna uma representação textual do animal.
     * @return String com os dados do animal.
     */
    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", peso=" + peso +
                ", idade=" + idade +
                '}';
    }
}