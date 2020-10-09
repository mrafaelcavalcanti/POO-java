package userinterface;

import java.util.Scanner;

import fachada.Banco;
import negocio.excecao.cliente.ClienteNaoExisteException;

public class TelaConsultarCliente {
    
    public Scanner input;
    public Banco fachada;

    public TelaConsultarCliente(Banco fachada){
        this.fachada = fachada;
        input = new Scanner(System.in);
    }

    public void solicitarDados(){
        boolean error = false;
        do{
            System.out.println("CPF ");
            String cpf = input.nextLine();
            try{
                System.out.println("DADOS DO CLIENTE");
                System.out.println(fachada.consultarClienteString(cpf));
                error = false;
            }catch(ClienteNaoExisteException e){
                System.out.println(e.getMessage());
                error = true;
            }
        }while(error);
    }
}