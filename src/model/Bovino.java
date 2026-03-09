package model;

import exception.DadosInvalidosException;

/**
 * Representa um bovino no sistema.
 * 
 * <p>Herda todas as propriedades de {@link Animal} e adiciona
 * características específicas de bovinos como raça, linhagem
 * e produção de leite.</p>
 * 
 * <p>Linhagens suportadas:
 * <ul>
 *   <li>LEITE - bovinos leiteiros</li>
 *   <li>CARNE - bovinos de corte</li>
 *   <li>DUPLA_APTIDAO - bovinos mistos</li>
 * </ul>
 * </p>
 * 
 * <p>Exemplo de uso:
 * <pre>
 * Bovino bovino = new Bovino();
 * bovino.setNome("Mimosa");
 * bovino.setRaca("Holstein");
 * bovino.setLinhagem("LEITE");
 * bovino.setProducaoLeite(25.5);
 * bovino.validar(); // Valida todos os campos
 * </pre>
 * </p>
 * 
 * @author Lucas Gonçalves
 * @version 1.0
 * @since 2026-03-06
 * @see Animal
 */
public class Bovino extends Animal {
    /**
     * Valida todos os campos do bovino.
     * 
     * <p>Verifica:
     * <ul>
     *   <li>Nome não pode ser vazio</li>
     *   <li>Peso deve ser maior que zero</li>
     *   <li>Idade não pode ser negativa</li>
     *   <li>Raça não pode ser vazia</li>
     *   <li>Linhagem não pode ser vazia</li>
     *   <li>Produção de leite não pode ser negativa</li>
     * </ul>
     * </p>
     * 
     * @throws DadosInvalidosException se algum campo for inválido
     */
    
    /** ID do animal na tabela "animal" (chave estrangeira em bovino.animal_id). */
    private int animalId;

    /** Raça do bovino (ex: Holstein, Charolês) */
    private String raca;

    /** Linhagem do bovino (ex: LEITE, CARNE, DUPLA_APTIDAO) */
    private String linhagem;

    /** Produção diária de leite em litros */
    private double producaoLeite;

    /**
     * Construtor vazio.
     * Utilizado para criar um objeto Bovino sem inicializar os atributos.
     */
    public Bovino() {
        super(); // Chama o construtor da superclasse Animal
    }

    /**
     * Construtor completo (usado principalmente quando você já tem dados completos).
     * Inicializa todos os atributos herdados e específicos.
     *
     * @param id ID do bovino/animal (dependendo de como você está a usar na app).
     * @param nome Nome do bovino.
     * @param peso Peso em kg.
     * @param idade Idade em meses.
     * @param raca Raça do bovino.
     * @param linhagem Linhagem genética.
     * @param producaoLeite Produção de leite em litros por dia.
     */
    public Bovino(int id, String nome, double peso, int idade,
                  String raca, String linhagem, double producaoLeite) {
        super(id, nome, peso, idade);
        this.raca = raca;
        this.linhagem = linhagem;
        this.setProducaoLeite(producaoLeite);

        // quando usamos este construtor, normalmente o id do Animal já é conhecido
        this.animalId = id;
    }

    /**
     * Construtor usado no registo de bovino (schema com tabelas separadas).
     * Aqui você já inseriu o Animal e recebeu o animalId gerado.
     *
     * @param animalId ID gerado na tabela animal.
     * @param raca Raça do bovino.
     * @param linhagem Linhagem (LEITE, CARNE, DUPLA_APTIDAO).
     * @param producaoLeite Produção de leite em litros por dia.
     */
    public Bovino(int animalId, String raca, String linhagem, double producaoLeite) {
        super(); // não temos ainda dados completos de Animal aqui
        this.animalId = animalId;
        this.raca = raca;
        this.linhagem = linhagem;
        this.setProducaoLeite(producaoLeite);
    }

    /**
     * Retorna o ID do animal associado (FK para a tabela animal).
     * @return animalId
     */
    public int getAnimalId() {
        return animalId;
    }

    /**
     * Define o ID do animal associado (FK para a tabela animal).
     * @param animalId id do animal
     */
    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    /**
     * Retorna a raça do bovino.
     * @return Raça como texto.
     */
    public String getRaca() {
        return raca;
    }

    /**
     * Define a raça do bovino.
     * @param raca Nome da raça.
     */
    public void setRaca(String raca) {
        this.raca = raca;
    }

    /**
     * Retorna a linhagem do bovino.
     * @return Linhagem como texto.
     */
    public String getLinhagem() {
        return linhagem;
    }

    /**
     * Define a linhagem do bovino.
     * @param linhagem Tipo de linhagem (ex: LEITE, CARNE).
     */
    public void setLinhagem(String linhagem) {
        this.linhagem = linhagem;
    }

    /**
     * Retorna a produção de leite do bovino.
     * @return Produção em litros por dia.
     */
    public double getProducaoLeite() {
        return producaoLeite;
    }

    /**
     * Define a produção de leite do bovino.
     * @param producaoLeite Valor em litros por dia.
     * @throws DadosInvalidosException se o valor for negativo.
     */
    public final void setProducaoLeite(double producaoLeite) {
        if (producaoLeite < 0) {
            throw new DadosInvalidosException("A produção de leite não pode ser negativa.");
        }
        this.producaoLeite = producaoLeite;
    }

    /**
     * Define o peso do bovino.
     * Este método existe porque sua IDE criou um "stub" e isso causa erro.
     * Aqui, nós validamos e guardamos o peso no atributo herdado de Animal.
     *
     * @param peso Peso em kg (deve ser > 0).
     * @throws DadosInvalidosException se o peso for inválido.
     */
    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new DadosInvalidosException("O peso deve ser maior que 0.");
        }
        this.peso = peso;
    }

    /**
     * Define a idade do bovino.
     * Aqui guardamos no atributo herdado de Animal.
     *
     * @param idade Idade em meses (não pode ser negativa).
     * @throws DadosInvalidosException se a idade for inválida.
     */
    public void setIdade(int idade) {
        if (idade < 0) {
            throw new DadosInvalidosException("A idade não pode ser negativa.");
        }
        this.idade = idade;
    }

    /**
     * Retorna uma representação textual do bovino.
     * @return String com os dados do bovino.
     */
    @Override
    public String toString() {
        return "Bovino{" +
                "animalId=" + animalId +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", peso=" + peso +
                ", idade=" + idade +
                ", raca='" + raca + '\'' +
                ", linhagem='" + linhagem + '\'' +
                ", producaoLeite=" + producaoLeite +
                '}';
    }

    /**
     * Retorna uma descrição completa do bovino.
     * @return Texto descritivo com todos os dados.
     */
    public String getDescricaoCompleta() {
        return String.format("Bovino %s da raça %s, pesando %.1f kg, com %d meses de idade e produção de %.1f litros/dia",
                nome, raca, peso, idade, producaoLeite);
    }
}