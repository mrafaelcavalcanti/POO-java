package userinterface;

import java.util.Scanner;

import fachada.Banco;
import negocio.excecao.conta.ContaNaoExisteException;
import negocio.excecao.conta.SaldoInsuficienteException;

public class TelaTransferir {

    public Scanner input;
    public Scanner entrada;
    public Banco fachada;

    public TelaTransferir(Banco fachada) {
        this.fachada = fachada;
        input = new Scanner(System.in);
        entrada = new Scanner(System.in);
    }

    public String solicitarConta() {
        System.out.println("Numero da conta: ");
        String numero = input.nextLine();
        return numero;
    }

    public double solicitarValor() {
        System.out.println("Valor: ");
        double valor = entrada.nextDouble();
        return valor;
    }

    public void solicitarDados() {
        boolean error = false;
        do{
            System.out.println("#### DADOS ####");
            System.out.println("CONTA ORIGEM");
            String numeroOrigem = solicitarConta();
            System.out.println("CONTA DESTINO");
            String numeroDestino = solicitarConta();
            double valor = solicitarValor();
            try{
                fachada.transferir(numeroOrigem, numeroDestino, valor);
                System.out.println("#### TRANSFERIDO ####");
                error = false;
            }catch(ContaNaoExisteException | IllegalArgumentException | SaldoInsuficienteException e){
                System.out.println(e.getMessage());
                System.out.println("REINICIANDO ");
                error = true;
            }

        }while(error);
    }
}

