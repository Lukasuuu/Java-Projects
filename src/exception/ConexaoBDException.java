
package exception;

/**
 * Exceção lançada quando ocorre um erro de conexão com o banco de dados.
 * Exemplo: banco offline, falha de autenticação, erro de driver, etc.
 * Esta exceção herdara de ProjetoException.
 * 
 * @author Lucas
 */
public class ConexaoBDException extends ProjetoException {

    /**
     * Cria uma nova exceção com a mensagem especificada.
     * 
     * @param mensagem Mensagem de erro.
     */
    public ConexaoBDException(String mensagem) {
        super(mensagem);
    }

    /**
     * Cria uma nova exceção com a mensagem e a causa especificadas.
     * 
     * @param mensagem Mensagem de erro.
     * @param causa Causa da exceção.
     */
    public ConexaoBDException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

