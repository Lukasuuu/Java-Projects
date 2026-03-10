
package exception;

/**
 * Exceção lançada quando os dados fornecidos são inválidos.
 * Exemplo: nome vazio, peso negativo, idade inválida, etc.
 * Esta exceção herda de {@link ProjetoException}.
 * 
 * <p>Utilizada na validação de campos antes de persistir
 * na base de dados.</p>
 * 
 * <p>Exemplos de uso:
 * <ul>
 *   <li>Peso menor ou igual a zero</li>
 *   <li>Idade negativa</li>
 *   <li>Nome vazio</li>
 *   <li>Produção de leite negativa</li>
 * </ul>
 * </p>
 * 
 * @author Lucas Gonçalves
 * @version 1.0
 * @since 2026-03-06
 * @see ProjetoException
 */
public class DadosInvalidosException extends ProjetoException {

    /**
     * Cria uma nova exceção com a mensagem especificada.
     * Exemplo: base de dados vazia, dados com caracteres invalidos, etc.
     * 
     * @param mensagem Mensagem de erro.
     */
    public DadosInvalidosException(String mensagem) {
        super(mensagem);
    }

    /**
     * Cria uma nova exceção com a mensagem e a causa especificadas.
     * 
     * @param mensagem Mensagem de erro.
     * @param causa Causa da exceção.
     */
    public DadosInvalidosException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
