
package exception;

/**
 * @author Lucas
 */
public class ProjetoException extends RuntimeException {

    /**
     * Cria uma nova exceção com a mensagem especificada.
     * @param mensagem Mensagem de erro.
     */
    public ProjetoException(String mensagem) {
        super(mensagem);
    }

    /**
     * Cria uma nova exceção com a mensagem e a causa especificadas.
     * @param mensagem Mensagem de erro.
     * @param causa Causa da exceção.
     */
    public ProjetoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
