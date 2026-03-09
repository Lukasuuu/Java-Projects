
package service;

import exception.ConexaoBDException;
import exception.DadosInvalidosException;
import java.util.ArrayList;
import model.Ambiente;
import model.Avaliacao;
import model.Bovino;
import persistence.AvaliacaoDB;

/**
 * Classe AvaliacaoService - contém as regras de negócio para gerar avaliações
 * de conforto térmico para bovinos.
 *
 * Esta classe é responsável por:
 *
 * Calcular o ITU (Índice de Temperatura e Umidade) Classificar o resultado em
 * CONFORTO, ALERTA ou ESTRESSE Gerar automaticamente avaliações para todos os
 * bovinos num dado ambiente
 *
 * Fórmula do ITU:
 *
 * ITU = (0.8 × T) + ((UR / 100) × (T - 14.4)) + 46.4 Onde: T = temperatura em
 * °C UR = umidade relativa em %
 *
 * Classificação:
 *
 * ITU menor que 72 CONFORTO (animal sem stress);
 * 72 menor ou igual ITU e menor que 79 ALERTA (atencao);
 * ITU maior ou igual a 79 PERIGO.
 *
 * @author Lucas Gonçalves
 * @version 1.0
 * @since 2026-03-06
 */
public class AvaliacaoService {

    /**
     * Objeto responsável por executar SQL na tabela avaliacao.
     */
    private final AvaliacaoDB avaliacaoDB;

    /**
     * Construtor padrão — inicializa a camada de persistência.
     */
    public AvaliacaoService() {
        this.avaliacaoDB = new AvaliacaoDB();
    }

    // ── Fórmula e classificação ───────────────────────────────────────────────
    /**
     * Calcula o ITU com base na temperatura e umidade do ambiente.
     *
     * Fórmula: ITU = (0.8 × T) + ((UR / 100) × (T - 14.4)) + 46.4
     *
     * @param temperatura Temperatura em graus Celsius.
     * @param umidade Umidade relativa do ar em percentagem (0–100).
     * @return Valor do ITU arredondado a 2 casas decimais.
     */
    public double calcularITU(double temperatura, double umidade) {
        double itu = (0.8 * temperatura)
                + ((umidade / 100.0) * (temperatura - 14.4))
                + 46.4;

        // Arredondar a 2 casas decimais para manter consistência
        return Math.round(itu * 100.0) / 100.0;
    }

    /**
     * Classifica o resultado do ITU numa categoria de conforto térmico.
     *
     * @param itu Valor do ITU calculado.
     * @return "CONFORTO", "ALERTA" ou "ESTRESSE".
     */
    public String classificarITU(double itu) {
        if (itu < 72.0) {
            return "CONFORTO";
        } else if (itu >= 72.0 && itu < 79.0) {
            return "ALERTA";
        } else {
            return "ESTRESSE";
        }
    }

    // ── Ação principal ────────────────────────────────────────────────────────
    /**
     * Gera automaticamente uma avaliação para CADA bovino da lista, usando as
     * condições do ambiente fornecido.
     *
     * Para cada bovino:
     *
     * Calcula o ITU com a temperatura e umidade do ambiente Classifica o
     * resultado Insere a avaliação na base de dados
     *
     *
     * @param listaBovinos Lista de bovinos a avaliar.
     * @param ambiente Ambiente com temperatura e umidade para o cálculo.
     * @return Número de avaliações geradas com sucesso.
     * @throws DadosInvalidosException se a lista ou ambiente forem inválidos.
     * @throws ConexaoBDException se ocorrer erro na base de dados.
     */
    public int gerarAvaliacoes(ArrayList<Bovino> listaBovinos, Ambiente ambiente)
            throws DadosInvalidosException {

        // Validar entradas
        if (listaBovinos == null || listaBovinos.isEmpty()) {
            throw new DadosInvalidosException("Nenhum bovino disponível para avaliação.");
        }
        if (ambiente == null) {
            throw new DadosInvalidosException("Ambiente inválido para avaliação.");
        }

        int totalGeradas = 0;

        // Para cada bovino, calcular e registar a avaliação
        for (Bovino bovino : listaBovinos) {

            // 1. Calcular o ITU usando a fórmula
            double itu = calcularITU(ambiente.getTemperatura(), ambiente.getUmidade());

            // 2. Classificar o resultado
            String resultado = classificarITU(itu);

            // 3. Criar o objeto Avaliacao
            Avaliacao avaliacao = new Avaliacao(
                    bovino.getId(), // ID do bovino
                    ambiente.getId(), // ID do ambiente
                    itu, // valor calculado
                    resultado // CONFORTO / ALERTA / ESTRESSE
            );

            // 4. Guardar na base de dados
            avaliacaoDB.inserir(avaliacao);
            totalGeradas++;
        }

        return totalGeradas;
    }

    /**
     * Lista todas as avaliações registadas, com nome do animal e local.
     *
     * @return Lista de avaliações ordenadas da mais recente para a mais antiga.
     * @throws ConexaoBDException se ocorrer erro na base de dados.
     */
    public ArrayList<Avaliacao> listarTodos() throws ConexaoBDException {
        return avaliacaoDB.listarTodos();
    }
}
