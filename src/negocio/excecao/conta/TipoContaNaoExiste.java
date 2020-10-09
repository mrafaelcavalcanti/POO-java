package negocio.excecao.conta;

public class TipoContaNaoExiste extends ContaException {

    public TipoContaNaoExiste() {
        super("tipo de conta invalida");
    }
    
}