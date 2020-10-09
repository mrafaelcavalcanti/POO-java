package negocio;

import dados.cliente.IRepositorioClientes;
import negocio.entidade.Cliente;
import negocio.excecao.cliente.ClienteJaExisteException;
import negocio.excecao.cliente.ClienteNaoExisteException;

public class NegocioCliente {
    private IRepositorioClientes repositorio;

    public NegocioCliente(IRepositorioClientes repositorio){
        this.repositorio = repositorio;
    }

    public void adicionar(Cliente cliente) throws ClienteJaExisteException{
        boolean existe = repositorio.existe(cliente.getCPF());
        if(existe){
            throw new ClienteJaExisteException();
        }else{
            repositorio.adicionar(cliente);
        }
    }

    public void remover(String cpf) throws ClienteNaoExisteException{
        Cliente cliente = repositorio.consultar(cpf);
        if(cliente == null){
            throw new ClienteNaoExisteException();
        }else{
            repositorio.remover(cliente);
        }
    }

    public void atualizar(Cliente cliente) throws ClienteNaoExisteException{
        Cliente clienteC = repositorio.consultar(cliente);
        if(clienteC == null){
            throw new ClienteNaoExisteException();
        }else{
            repositorio.atualizar(cliente);
        }
    }

    public Cliente consultar(String CPF) throws ClienteNaoExisteException{
        Cliente cliente = repositorio.consultar(CPF);
        if(cliente != null){
            return cliente;
        }else{
            throw new ClienteNaoExisteException();
        }
    }
}