package negocio.entidade;

public class Poupanca extends Conta{
    private double juros;

    public Poupanca(){
        super();
        this.juros = 1.1;
    }
    
    public Poupanca(Cliente cliente, String numero, double saldo){
        super(cliente, numero, saldo);
        this.juros = 1.1;
    }

    public void renderJuros(){
        this.creditar(juros * saldo);
    }
}