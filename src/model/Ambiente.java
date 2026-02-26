package model;

/**
 * Classe Ambiente - representa as condições climáticas de um local em uma data específica.
 * Contém informações como temperatura, umidade, local e data de registo.
 * 
 * @author Lucas
 */
public class Ambiente {

    private int id;
    private double temperatura;
    private double umidade;
    private String local;
    private String dataRegisto;

    /**
     * Construtor vazio.
     */
    public Ambiente() {}

    /**
     * Construtor com parâmetros.
     * 
     * @param id Identificador do ambiente.
     * @param temperatura Temperatura em graus Celsius.
     * @param umidade Umidade relativa em porcentagem.
     * @param local Local de medição.
     * @param dataRegisto Data do registo (formato: dd/MM/yyyy).
     */
    public Ambiente(int id, double temperatura, double umidade, String local, String dataRegisto) {
        this.id = id;
        this.setTemperatura(temperatura);
        this.setUmidade(umidade);
        this.local = local;
        this.dataRegisto = dataRegisto;
    }

    /**
     * Retorna o ID do ambiente.
     * @return ID numérico.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do ambiente.
     * @param id Identificador numérico.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna a temperatura registrada.
     * @return Temperatura em graus Celsius.
     */
    public double getTemperatura() {
        return temperatura;
    }

    /**
     * Define a temperatura do ambiente.
     * @param temperatura Valor da temperatura.
     */
    public void setTemperatura(double temperatura) {
        if (temperatura < -50 || temperatura > 60) {
            throw new IllegalArgumentException("Temperatura fora do intervalo aceitável.");
        }
        this.temperatura = temperatura;
    }

    /**
     * Retorna a umidade registrada.
     * @return Umidade relativa em porcentagem.
     */
    public double getUmidade() {
        return umidade;
    }

    /**
     * Define a umidade do ambiente.
     * @param umidade Valor da umidade.
     */
    public void setUmidade(double umidade) {
        if (umidade < 0 || umidade > 100) {
            throw new IllegalArgumentException("Umidade deve estar entre 0% e 100%.");
        }
        this.umidade = umidade;
    }

    /**
     * Retorna o local do registo.
     * @return Nome do local.
     */
    public String getLocal() {
        return local;
    }

    /**
     * Define o local do registo.
     * @param local Nome do local.
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * Retorna a data do registo.
     * @return Data no formato texto.
     */
    public String getDataRegisto() {
        return dataRegisto;
    }

    /**
     * Define a data do registo.
     * @param dataRegisto Data no formato texto.
     */
    public void setDataRegisto(String dataRegisto) {
        this.dataRegisto = dataRegisto;
    }

    @Override
    public String toString() {
        return "Ambiente em " + local + " (" + dataRegisto + ") - " +
               "Temperatura: " + temperatura + "°C, Umidade: " + umidade + "%";
    }
}