package dados.conta;

import java.util.ArrayList;

import negocio.entidade.Cliente;
import negocio.entidade.ContaAbstrata;

public class RepositorioContasArrayList implements IRepositorioContas {

    private ArrayList<ContaAbstrata> array;

    public RepositorioContasArrayList(){
        array = new ArrayList();
    }

    @Override
    public void adicionar(ContaAbstrata conta){
        array.add(conta);
    }

    @Override
    public void remover(ContaAbstrata conta) {
        int indice = array.indexOf(conta);
        if(indice != -1){
            array.remove(conta);
        }
    }

    @Override
    public void atualizar(ContaAbstrata conta) {
        int indice = array.indexOf(conta);
        if(indice != -1){
            array.set(indice, conta);
        }
    }

    @Override
    public boolean existe(String numero) {
        boolean existe = false;
        for(ContaAbstrata conta : array){
            if(conta.getNumero().equals(numero)){
                existe = true;
                break;
            }
        }
        return existe;
    }

    @Override
    public ContaAbstrata consultar(ContaAbstrata conta) {
        ContaAbstrata contaProcurada = null;
        int indice = array.indexOf(conta);
        if(indice != -1){
            contaProcurada = array.get(indice);
        }
        return contaProcurada;
    }

    @Override
    public ContaAbstrata consultar(String numero) {
        ContaAbstrata contaProcurada = null;
        for(ContaAbstrata conta : array){
            if(conta.getNumero().equals(numero)){
                contaProcurada = conta;
                break;
            }
        }
        return contaProcurada;
    }

    public ArrayList<ContaAbstrata> consultarPorCliente(Cliente cliente) {
        ArrayList<ContaAbstrata> contas = new ArrayList();
        for (ContaAbstrata conta : array) {
            if (conta.getCliente().getCPF().equals(cliente.getCPF())) {
                contas.add(conta);
            }
        }
        return contas;
    }

    @Override
    public ArrayList<ContaAbstrata> consultar(Cliente cliente) {
        ArrayList<ContaAbstrata> contas = new ArrayList();
        for(ContaAbstrata conta : array){
            if(conta.getCliente().equals(cliente));
            contas.add(conta);
        }
        return contas;
    }

    @Override
    public void lista() {
        for(ContaAbstrata conta : array){
            System.out.println(conta);
        }
    }
    
}