package negocio;

import java.util.ArrayList;

import dados.conta.IRepositorioContas;
import negocio.entidade.Cliente;
import negocio.entidade.ContaAbstrata;
import negocio.excecao.conta.ContaAtivaException;
import negocio.excecao.conta.ContaJaExisteException;
import negocio.excecao.conta.ContaNaoExisteException;
import negocio.excecao.conta.SaldoInsuficienteException;

public class NegocioConta {
    
    private IRepositorioContas repositorio;

    public NegocioConta(IRepositorioContas repositorio){
        this.repositorio = repositorio;
    }

    public void adicionar(ContaAbstrata conta) throws ContaJaExisteException{
        boolean existe = repositorio.existe(conta.getNumero());
        if(existe){
            throw new ContaJaExisteException();
        }else{
            repositorio.adicionar(conta);
        }        
    }

    public void remover(String numero) throws ContaNaoExisteException, ContaAtivaException{
        ContaAbstrata conta = repositorio.consultar(numero);
        if(conta != null){
            if(conta.getSaldo()==0){
                repositorio.remover(conta);
            }else{
                throw new ContaAtivaException();
            }
        }else{
            throw new ContaNaoExisteException();            
        }
    }

    public ContaAbstrata consultar(String numero) throws ContaNaoExisteException{
        ContaAbstrata conta = repositorio.consultar(numero);
        if(conta != null){
            return conta;
        }else{
            throw new ContaNaoExisteException();
        }
    }

    public ArrayList<ContaAbstrata> consultarPorCliente(Cliente cliente) throws ContaNaoExisteException{
        ArrayList<ContaAbstrata> contas = repositorio.consultar(cliente);
        if(contas == null  || contas.isEmpty()){
            throw new ContaNaoExisteException();
        }else{
            return contas;
        }
    }

    public void creditar(String numero, double valor) throws ContaNaoExisteException{
        ContaAbstrata conta = repositorio.consultar(numero);
        if(conta == null){
            throw new ContaNaoExisteException();
        }else{
            conta.creditar(valor);
        }
    }

    public void debitar(String numero, double valor) throws ContaNaoExisteException, SaldoInsuficienteException{
        ContaAbstrata conta = repositorio.consultar(numero);
        if(conta == null){
            throw new ContaNaoExisteException();
        }else{
            conta.debitar(valor);
        }
    }

    public void transferir(String contaOrigem, String contaDestino, double valor)throws ContaNaoExisteException, SaldoInsuficienteException{
        ContaAbstrata origem = repositorio.consultar(contaOrigem);
        ContaAbstrata destino = repositorio.consultar(contaDestino);
        if(origem != null && destino != null){
            origem.transferir(destino, valor);
        }else{
            throw new ContaNaoExisteException();
        }
    }

    public void atrualizar(ContaAbstrata conta) throws ContaNaoExisteException{
        ContaAbstrata contaC = repositorio.consultar(conta);
        if(contaC == null){
            throw new ContaNaoExisteException();
        }else{
            repositorio.atualizar(conta);
        }
    }


}