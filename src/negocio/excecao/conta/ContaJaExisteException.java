package negocio.excecao.conta;

public class ContaJaExisteException extends ContaException{
    
    public ContaJaExisteException(){
        super("Conta ja existe");
    }
}