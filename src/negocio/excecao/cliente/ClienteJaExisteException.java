package negocio.excecao.cliente;

public class ClienteJaExisteException extends ClienteException {
    
    public ClienteJaExisteException(){
        super("cliente ja existe");
    }
}