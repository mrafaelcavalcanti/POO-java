package userinterface;

import java.util.Scanner;

import fachada.Banco;
import negocio.excecao.cliente.ClienteJaExisteException;

public class TelaCadastroCliente {
    
    private Scanner input;
    private Scanner inteiro;
    private Banco fachada;

    public TelaCadastroCliente(Banco fachada){
        this.fachada = fachada;
        input = new Scanner(System.in);
        inteiro = new Scanner(System.in);
    }

    public void solicitaDados(){
        System.out.println("#### ENDERECO ####");
        System.out.println("CEP: ");
        String cep = input.nextLine();
        System.out.println("NUMERO: ");
        String numero = input.nextLine();
        System.out.println("RUA: ");
        String rua = input.nextLine();
        System.out.println("BAIRRO");
        String bairro = input.nextLine();
        String complemento = bairro +", "+rua;
        
        System.out.println("#### DADOS PESSOAIS ####");
        System.out.println("NOME: ");
        String nome = input.nextLine();
        System.out.println("CPF: ");
        String CPF = input.nextLine();
        System.out.println("IDADE: ");
        int idade = inteiro.nextInt();

        try{
            fachada.adicionarCliente(CPF, nome, idade, cep, numero, complemento);
        }catch(ClienteJaExisteException e){
            System.out.println(e.getMessage());
            System.out.println("#### CADASTRO REINICIADO ####");
            solicitaDados();
        }
        System.out.println("#### CADASTRO REALIZADO ####");
    }
}