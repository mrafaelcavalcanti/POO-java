package negocio.excecao.conta;

public class ContaAtivaException extends ContaException{
    
    public ContaAtivaException(){
        super("Conta ativa, nao pode ser removida");
    }
}