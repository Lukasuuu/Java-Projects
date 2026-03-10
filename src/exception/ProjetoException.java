
package exception;

/**
 * @author Lucas Gonçalves
 * @version 1.0
 * @since 2026-03-06
 * @see RuntimeException
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
