package fachada;

import dados.conta.RepositorioContasArrayList;
import dados.cliente.RepositorioClientesArrayList;
import negocio.NegocioCliente;
import negocio.NegocioConta;
import negocio.entidade.Cliente;
import negocio.entidade.Conta;
import negocio.entidade.ContaAbstrata;
import negocio.entidade.Endereco;
import negocio.excecao.cliente.ClienteJaExisteException;
import negocio.excecao.cliente.ClienteNaoExisteException;
import negocio.excecao.conta.ContaAtivaException;
import negocio.excecao.conta.ContaJaExisteException;
import negocio.excecao.conta.ContaNaoExisteException;
import negocio.excecao.conta.SaldoInsuficienteException;

import java.util.ArrayList;

public class Banco {
    private NegocioCliente cadastroCliente;
    private NegocioConta cadastroConta;

    public Banco() {
        cadastroCliente = new NegocioCliente(new RepositorioClientesArrayList());
        cadastroConta = new NegocioConta(new RepositorioContasArrayList());
    }

    public void adicionarCliente(String CPF, String nome, int idade, String cep, String numero, String complemento)
            throws ClienteJaExisteException {
        Endereco endereco = new Endereco(cep, numero, complemento);
        Cliente cliente = new Cliente(nome, idade, CPF, endereco);
        cadastroCliente.adicionar(cliente);
    }

    public void adicionarConta(String numero, String CPF, double saldo)
            throws ClienteNaoExisteException, ContaJaExisteException {
        ContaAbstrata conta = null;
        Cliente cliente = cadastroCliente.consultar(CPF);
        conta = new Conta(cliente, numero, saldo);
        cadastroConta.adicionar(conta);
    }

    public void removerCliente(String CPF)
            throws ClienteNaoExisteException, ContaNaoExisteException, ContaAtivaException {
        Cliente cliente = cadastroCliente.consultar(CPF);
        ArrayList<ContaAbstrata> contas = cadastroConta.consultarPorCliente(cliente);

        for (ContaAbstrata conta : contas) {
            cadastroConta.remover(conta.getNumero());
        }
        cadastroCliente.remover(CPF);
    }

    public void atualizarCliente(String CPF, String nome, int idade, String cep, String numero, String complemento) throws ClienteNaoExisteException {
        Cliente cliente = cadastroCliente.consultar(CPF);
        Endereco endereco = cliente.getEndereco();

        endereco.setCep(cep);
        endereco.setNumero(numero);
        endereco.setComplemento(complemento);

        cliente.setNome(nome);
        cliente.setIdade(idade);
        cliente.setEndereco(endereco);
    }

    public void removerConta(String numero) throws ContaNaoExisteException, ContaAtivaException {
        cadastroConta.remover(numero);
    }

    public void transferir(String numeroOrigem, String numeroDestino, double valor) throws ContaNaoExisteException, SaldoInsuficienteException {
        cadastroConta.transferir(numeroOrigem, numeroDestino, valor);
    }

    public void debitar(String numero, double valor) throws ContaNaoExisteException, SaldoInsuficienteException {
        cadastroConta.debitar(numero, valor);
    }

    public void creditar(String numero, double valor) throws ContaNaoExisteException {
        cadastroConta.creditar(numero, valor);
    }

    public String consultarClienteString(String CPF) throws ClienteNaoExisteException {
        Cliente cliente = cadastroCliente.consultar(CPF);
        Endereco endereco = cliente.getEndereco();
        
        String saida = "NOME: "+cliente.getNome()+"\n" +"ENDERECO: "+endereco.getCep()+", "+endereco.getNumero()+", "+endereco.getComplemento()+"\n";
        return saida;
    }

    public Cliente consultarClienteObjeto(String CPF) throws ClienteNaoExisteException {
        Cliente cliente = cadastroCliente.consultar(CPF);
        //Endereco endereco = cliente.getEndereco();
        
        //String saida = "NOME: "+cliente.getNome()+"\n" +"ENDERECO: "+endereco.getCep()+", "+endereco.getNumero()+", "+endereco.getComplemento()+"\n";
        return cliente;
    }

    public String consultarConta(String numero) throws ContaNaoExisteException, ClienteNaoExisteException {
        ContaAbstrata conta = cadastroConta.consultar(numero);
        Cliente cliente = cadastroCliente.consultar(conta.getCliente().getCPF());
        
        String saida = "CLIENTE: "+cliente.getNome()+"\n"+"CONTA: "+numero+"SALDO: "+conta.getSaldo()+"\n";
        return saida;
    }
    
}