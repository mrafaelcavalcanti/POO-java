package negocio.excecao.conta;

public class ContaException extends Exception {
    private String mensagem;

    public ContaException(String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage(){
        return mensagem;
    }
}