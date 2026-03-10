
package exception;

/**
 * Exceção lançada quando ocorre um erro de conexão com o banco de dados.
 * Exemplo: banco offline, falha de autenticação, erro de driver, etc.
 * Esta exceção herdara de ProjetoException.
 * 
 * <p>Encapsula exceções SQL ({@link java.sql.SQLException})
 * fornecendo mensagens mais claras ao utilizador.</p>
 * 
 * <p>Exemplo de uso:
 * <pre>
 * try {
 *     conexao = Conexao.getConexao();
 * } catch (SQLException e) {
 *     throw new ConexaoBDException("Falha na conexão", e);
 * }
 * </pre>
 * </p>
 * 
 * @author Lucas Gonçalves
 * @version 1.0
 * @since 2026-03-06
 * @see ProjetoException
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

