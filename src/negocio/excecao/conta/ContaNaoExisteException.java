package negocio.excecao.conta;

public class ContaNaoExisteException extends ContaException{

    public ContaNaoExisteException() {
        super("conta nao existe");
    }
        
}