package userinterface;

import java.util.Scanner;

import fachada.Banco;
import negocio.excecao.conta.ContaAtivaException;
import negocio.excecao.conta.ContaNaoExisteException;

public class TelaRemoverConta {

    public Scanner input;
    public Banco fachada;

    public TelaRemoverConta(Banco fachada) {
        this.fachada = fachada;
        input = new Scanner(System.in);
    }

    public void solicitarDados() {
        boolean error = false;

        do{
            System.out.println("NUMERO: ");
            String numero = input.nextLine();

            try{
                fachada.removerConta(numero);
                error = false;
                System.out.println("REMOVIDO");
            }catch(ContaAtivaException | ContaNaoExisteException e){
                System.out.println(e.getMessage());
                error = true;
            }

        }while(error);
    }
    
    
}