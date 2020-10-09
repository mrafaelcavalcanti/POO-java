package negocio.excecao.cliente;

public class ClienteNaoExisteException extends ClienteException{
    
    public ClienteNaoExisteException(){
        super("Cliente nao existe");
    }
}