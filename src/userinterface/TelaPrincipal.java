package userinterface;

import java.util.Scanner;

import fachada.Banco;

public class TelaPrincipal {
    
    private Scanner input;
    private TelaCadastroCliente telaCadastroCliente;
    private TelaCadastroConta telaCadastroConta;
    private TelaCreditar telaCreditar;
    private TelaDebitar telaDebitar;
    private TelaTransferir telaTransferir;
    private TelaConsultarCliente telaConsultarCliente;
    private TelaConsultarConta telaConsultarConta;
    private TelaAtualizarCliente telaAtualizarCliente;
    private TelaRemoverCliente telaRemoverCliente;
    private TelaRemoverConta telaRemoverConta;
    
    
    public TelaPrincipal(Banco fachada){
        input = new Scanner(System.in);
        this.telaCadastroCliente = new TelaCadastroCliente(fachada);
        this.telaCadastroConta = new TelaCadastroConta(fachada);
        this.telaCreditar = new TelaCreditar(fachada);
        this.telaDebitar = new TelaDebitar(fachada);
        this.telaTransferir = new TelaTransferir(fachada);
        this.telaConsultarCliente = new TelaConsultarCliente(fachada);
        this.telaConsultarConta = new TelaConsultarConta(fachada);
        this.telaAtualizarCliente = new TelaAtualizarCliente(fachada);
        this.telaRemoverCliente = new TelaRemoverCliente(fachada);
        this.telaRemoverConta = new TelaRemoverConta(fachada);
    }

    public void iniciar(){
        while(true){
            
            System.out.println("#### MENU ####");
            System.out.println("1 - CADASTRAR CLIENTE");
            System.out.println("2 - CADATRA CONTA");
            System.out.println("3 - CREDITAR");
            System.out.println("4 - DEBITAR");
            System.out.println("5 - TRANSFERIR");
            System.out.println("6 - CONSULTAR CLIENTE");
            System.out.println("7 - CONSULTAR CONTA");
            System.out.println("8 - ATUALIZAR CLIENTE");
            System.out.println("9 - REMOVER CLIENTE");
            System.out.println("10 - REMOVER CONTA");
            System.out.println("99 - SAIR");
            
            int opcao =  input.nextInt();

            switch(opcao){
                case 1:
                    telaCadastroCliente.solicitaDados();
                    break;
                case 2:
                    telaCadastroConta.solicitaDados();
                    break;
                case 3:
                    telaCreditar.solicitarDados();
                    break;
                case 4:
                    telaDebitar.solicitarDados();
                    break;
                case 5:
                    telaTransferir.solicitarDados();
                    break;
                case 6:
                    telaConsultarCliente.solicitarDados();
                    break;
                case 7:
                    telaConsultarConta.solicitarDados();                    
                    break;
                case 8:
                    telaAtualizarCliente.atualizarDados();
                    break;
                case 9:
                    telaRemoverCliente.solicitarDados();
                    break;
                case 10:
                    telaRemoverConta.solicitarDados();
                    break;
                case 99:
                    System.exit(0);
                default:
                    System.out.println("#### OPCAO INVALIDA");
            }
        }
    }
}