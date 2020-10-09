package userinterface;

import java.util.Scanner;

import fachada.Banco;
import negocio.entidade.Cliente;
import negocio.excecao.cliente.ClienteNaoExisteException;

public class TelaAtualizarCliente {

    public Scanner input;
    public Scanner opcao;
    public Banco fachada;

    public TelaAtualizarCliente(Banco fachada) {
        this.fachada = fachada;
        input = new Scanner(System.in);
        opcao = new Scanner(System.in);
    }

    public Cliente solicitarCpf() {
        System.out.println("CPF");
        String cpf = input.nextLine();
        Cliente cliente = null;
        try{
            cliente = fachada.consultarClienteObjeto(cpf);
        }catch(ClienteNaoExisteException e){
            System.out.println(e.getMessage());
        }
        return cliente;        
    } 
    

    public void atualizarDados() {
        boolean error = false;
        
        do{
        Cliente cliente = solicitarCpf();
        cliente.toString();
        System.out.println("#### DADO A SER ALTERADO:\n1 - idade\n2 - nome\n3 - endereco");
        int entrada = opcao.nextInt();        
            try{
                switch(entrada){
                    case 1:
                        int idade = opcao.nextInt();
                        fachada.atualizarCliente(cliente.getCPF(), cliente.getNome(), idade, cliente.getEndereco().getCep(), cliente.getEndereco().getNumero(), cliente.getEndereco().getComplemento());
                        error = false;
                        break;
                    case 2:
                        String nome = input.nextLine();
                        fachada.atualizarCliente(cliente.getCPF(), nome, cliente.getIdade(), cliente.getEndereco().getCep(), cliente.getEndereco().getNumero(), cliente.getEndereco().getComplemento());
                        error = false;
                        break;
                    case 3:
                        System.out.println("CEP: ");
                        String cep = input.nextLine();
                        System.out.println("NUMERO: ");
                        String numero = input.nextLine();
                        System.out.println("RUA: ");
                        String rua = input.nextLine();
                        System.out.println("BAIRRO");
                        String bairro = input.nextLine();
                        String complemento = bairro +", "+rua;
                        fachada.atualizarCliente(cliente.getCPF(), cliente.getNome(), cliente.getIdade(), cep, numero, complemento);
                        error = false;
                        break;
                    default:
                        System.out.println("OPCAO INVALIDA");
                }
                System.out.println("#### ATUALIZADO ####");
            }catch(ClienteNaoExisteException e){
                System.out.println(e.getMessage());
                error = true;
            }

        }while(error);


    }


    
}