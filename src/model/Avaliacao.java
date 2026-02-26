package model;

/**
 * Classe Avaliacao - representa o resultado da avaliação de conforto térmico de um animal
 * com base nas condições ambientais.
 * Contém os dados do animal, ambiente, valor do ITU, resultado e data da avaliação.
 * 
 * ITU = Índice de Temperatura e Umidade.
 * 
 * @author Lucas
 */
public class Avaliacao {

    /** ID único da avaliação */
    private int id;

    /** ID do animal avaliado */
    private int idAnimal;

    /** ID do ambiente no momento da avaliação */
    private int idAmbiente;

    /** Valor calculado do ITU (Índice de Temperatura e Umidade) */
    private double valorITU;

    /** Resultado da avaliação (ex: "Conforto", "Alerta", "Estresse") */
    private String resultado;

    /** Data em que a avaliação foi realizada */
    private String dataAvaliacao;

    /**
     * Construtor vazio.
     */
    public Avaliacao() {}

    /**
     * Construtor com parâmetros.
     * 
     * @param id ID da avaliação.
     * @param idAnimal ID do animal avaliado.
     * @param idAmbiente ID do ambiente utilizado.
     * @param valorITU Valor do índice ITU.
     * @param resultado Resultado da avaliação.
     * @param dataAvaliacao Data da avaliação.
     */
    public Avaliacao(int id, int idAnimal, int idAmbiente, double valorITU, String resultado, String dataAvaliacao) {
        this.id = id;
        this.idAnimal = idAnimal;
        this.idAmbiente = idAmbiente;
        this.setValorITU(valorITU);
        this.resultado = resultado;
        this.dataAvaliacao = dataAvaliacao;
    }

    /**
     * Retorna o ID da avaliação.
     * @return ID numérico.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID da avaliação.
     * @param id Valor numérico.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o ID do animal avaliado.
     * @return ID do animal.
     */
    public int getIdAnimal() {
        return idAnimal;
    }

    /**
     * Define o ID do animal avaliado.
     * @param idAnimal ID do animal.
     */
    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    /**
     * Retorna o ID do ambiente utilizado na avaliação.
     * @return ID do ambiente.
     */
    public int getIdAmbiente() {
        return idAmbiente;
    }

    /**
     * Define o ID do ambiente utilizado.
     * @param idAmbiente ID do ambiente.
     */
    public void setIdAmbiente(int idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    /**
     * Retorna o valor do ITU.
     * @return Valor do índice ITU.
     */
    public double getValorITU() {
        return valorITU;
    }

    /**
     * Define o valor do ITU.
     * @param valorITU Valor calculado.
     * @throws IllegalArgumentException se o valor for negativo.
     */
    public void setValorITU(double valorITU) {
        if (valorITU < 0) {
            throw new IllegalArgumentException("O valor do ITU não pode ser negativo.");
        }
        this.valorITU = valorITU;
    }

    /**
     * Retorna o resultado da avaliação.
     * @return Texto com o resultado (ex: "Conforto").
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Define o resultado da avaliação.
     * @param resultado Texto com o resultado.
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * Retorna a data da avaliação.
     * @return Data no formato texto.
     */
    public String getDataAvaliacao() {
        return dataAvaliacao;
    }

    /**
     * Define a data da avaliação.
     * @param dataAvaliacao Data no formato texto.
     */
    public void setDataAvaliacao(String dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "id=" + id +
                ", idAnimal=" + idAnimal +
                ", idAmbiente=" + idAmbiente +
                ", valorITU=" + valorITU +
                ", resultado='" + resultado + '\'' +
                ", dataAvaliacao='" + dataAvaliacao + '\'' +
                '}';
    }
}