package userinterface;

import java.util.Scanner;

import fachada.Banco;
import negocio.excecao.conta.ContaNaoExisteException;

public class TelaCreditar {
    
    public Scanner input;
    public Scanner entrada;
    public Banco fachada;

    public TelaCreditar(Banco fachada){
        this.fachada = fachada;
        input = new Scanner(System.in);
        entrada = new Scanner(System.in);
    }

    public String solicitarConta(){
        System.out.println("Numero da conta: ");
        String numero = input.nextLine();
        return numero;
    }

    public double solicitarValor(){
        System.out.println("Valor: ");
        double valor = entrada.nextDouble();
        return valor;
    }

    public void solicitarDados(){
        boolean error = false;
        do{
            System.out.println("#### DADOS ####");
            String numero = solicitarConta();
            double valor = solicitarValor();
            try{
                fachada.creditar(numero, valor);
                System.out.println("#### CREDITADO ####");
                error = false;
            }catch(ContaNaoExisteException | IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("REINICIANDO ");
                error = true;
            }

        }while(error);
    }
    
}