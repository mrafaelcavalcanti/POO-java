package userinterface;

import java.util.Scanner;

import fachada.Banco;
import negocio.excecao.cliente.ClienteNaoExisteException;
import negocio.excecao.conta.ContaAtivaException;
import negocio.excecao.conta.ContaNaoExisteException;

public class TelaRemoverCliente {

    public Scanner input;
    public Banco fachada;


    public TelaRemoverCliente(Banco fachada){
        this.fachada = fachada;
        input = new Scanner(System.in);
    }


    public void solicitarDados(){        
        boolean error = false;        
        do{
            System.out.println("CPF: ");
            String cpf = input.nextLine();
            try{
                fachada.removerCliente(cpf);
                System.out.println("#### REMOVIDO ####");
                error = false;
            }catch(ClienteNaoExisteException | ContaAtivaException | ContaNaoExisteException e){
                System.out.println(e.getMessage());
                System.out.println("REINICIANDO");
                error = true;
            }
            
        }while(error);
    }
    
}