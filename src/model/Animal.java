package model;

import exception.DadosInvalidosException;

/**
 * Representa um animal no sistema.
 * 
 * <p>Classe base que contém propriedades comuns a todos os tipos
 * de animais. Utiliza modificador {@code protected} para permitir
 * acesso nas classes filhas.</p>
 * 
 * <p>Esta classe é parte da hierarquia de herança:
 * <pre>
 * Animal (PAI)
 *   └── Bovino (FILHO)
 * </pre>
 * </p>
 * 
 * <p>Na base de dados, utiliza estratégia "Class Table Inheritance"
 * com duas tabelas: {@code animal} (PAI) e {@code bovino} (FILHO).</p>
 * 
 * @author Lucas Gonçalves
 * @version 1.0
 * @since 2026-03-06
 * @see Bovino
 */
public class Animal {

     
    /**
     * ID único do animal.
     * Chave primária na tabela animal.
     */
    protected int id;

    /**
     * Nome do animal. 
     * Não pode ser vazio.
     */
    protected String nome;

    /**
     * Peso do animal em quilogramas. 
     * Deve ser maior que zero.
     */
    protected double peso;

    /**
     * Idade do animal em meses. 
     * Deve ser maior ou igual a zero.
     */
    protected int idade;

    /**
     * Cria uma nova instância de Animal. 
     * Todos os campos são inicializados com valores padrão.
     */
    public Animal() {}

    /**
     * Cria uma nova instância de Animal com valores especificados.
     *
     * @param id ID único do animal
     * @param nome nome do animal
     * @param peso peso em quilogramas
     * @param idade idade em meses
     */
    public Animal(int id, String nome, double peso, int idade) {
        this.id = id;
        this.nome = nome;
        this.setPeso(peso);
        this.setIdade(idade);
    }

    /**
     * Retorna o ID do animal.
     * @return ID numérico do animal.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do animal.
     * @param id a ser atribuído ao ID.
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
     * @param nome Nome a ser atribuído no nome do animal.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o peso do animal.
     * @return Peso em kg 
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Define o peso do animal.
     * @param peso Peso em kg a ser atribuído no peso do animal.
     * @throws DadosInvalidosException se o peso for negativo.
     */
    private void setPeso(double peso) {
        if (peso < 0) {
            throw new DadosInvalidosException("O peso não pode ser negativo.");
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
     * @param idade Idade em meses a ser atribuído na idade do animal.
     * @throws DadosInvalidosException se a idade for negativa.
     */
    private void setIdade(int idade) {
        if (idade < 0) {
            throw new DadosInvalidosException("A idade não pode ser negativa.");
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