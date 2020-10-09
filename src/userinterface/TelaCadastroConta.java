package userinterface;

import java.util.Scanner;

import fachada.Banco;
import negocio.excecao.cliente.ClienteNaoExisteException;
import negocio.excecao.conta.ContaJaExisteException;

public class TelaCadastroConta {

    public Scanner input;
    public Banco fachada;

    public TelaCadastroConta(Banco fachada){
        this.fachada = fachada;
        input = new Scanner(System.in);
    }

    private String solicitarCliente() {
        System.out.println("CPF do cliente: ");
        String cpf = input.nextLine();
        return cpf;
    }

    private String solicitarNumero() {
        System.out.println("Numero da conta: ");
        String numero = input.nextLine();
        return numero;
    }


    public void solicitaDados(){
        boolean error = false;
        do{
            System.out.println("#### DADOS DA CONTA ####");
            String CPF = solicitarCliente();
            String numero = solicitarNumero();

            try{
                fachada.adicionarConta(numero, CPF, 0);
                System.out.println("#### CADASTRO REALIZADO ####");
                error = false;
            }catch(ContaJaExisteException | ClienteNaoExisteException e){
                System.out.println(e.getMessage());
                System.out.println("#### CADASTRO REINICIADO ####");
                error = true;
            }            
        }while(error);
    }
    
    
}