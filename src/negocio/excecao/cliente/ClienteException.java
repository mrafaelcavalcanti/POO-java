package negocio.excecao.cliente;

public class ClienteException extends Exception {
    
    private String mensagem;

    public ClienteException(String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage(){
        return mensagem;
    }
}