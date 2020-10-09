package userinterface;

import java.util.Scanner;

import fachada.Banco;
import negocio.excecao.cliente.ClienteNaoExisteException;
import negocio.excecao.conta.ContaNaoExisteException;

public class TelaConsultarConta {
    
    public Scanner input;
    public Banco fachada;

    public TelaConsultarConta(Banco fachada){
        this.fachada = fachada;
        input = new Scanner(System.in);
    }

    public void solicitarDados() {
        boolean error = false;
        do{
            System.out.println("NUMERO: ");
            String numero = input.nextLine();
            try{
                String dados = fachada.consultarConta(numero);
                System.out.println("DADOS DA CONTA:\n"+dados);
                error = false;
            }catch(ClienteNaoExisteException | ContaNaoExisteException e){
                System.out.println(e.getMessage());
                error = true;
            }
        }while(error);
    }
    
}