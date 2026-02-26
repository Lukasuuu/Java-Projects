
package exception;

/**
 * Exceção lançada quando os dados fornecidos são inválidos.
 * Exemplo: nome vazio, peso negativo, idade inválida, etc.
 * 
 * Esta exceção herda de {@link ProjetoException}.
 * 
 * @author Lucas
 */
public class DadosInvalidosException extends ProjetoException {

    /**
     * Cria uma nova exceção com a mensagem especificada.
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
