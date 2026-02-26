package model;

/**
 * Classe Bovino - representa um animal do tipo bovino.
 * Esta classe herda da superclasse {@link Animal} e adiciona propriedades específicas
 * como raça, linhagem e produção de leite.
 * 
 * HERANÇA: Bovino possui todos os atributos de Animal + os seus próprios.
 * 
 * @author Lucas
 */
public class Bovino extends Animal {

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
     * Construtor completo.
     * Inicializa todos os atributos herdados e específicos.
     * 
     * @param id ID do animal.
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
     * @throws IllegalArgumentException se o valor for negativo.
     */
    public void setProducaoLeite(double producaoLeite) {
        if (producaoLeite < 0) {
            throw new IllegalArgumentException("A produção de leite não pode ser negativa.");
        }
        this.producaoLeite = producaoLeite;
    }

    /**
     * Retorna uma representação textual do bovino.
     * @return String com os dados do bovino.
     */
    @Override
    public String toString() {
        return "Bovino{" +
                "id=" + id +
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

    public void setPeso(double parseDouble) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setIdade(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}