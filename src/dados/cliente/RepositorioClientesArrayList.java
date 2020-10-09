package dados.cliente;

import negocio.entidade.Cliente;

import java.util.ArrayList;

public class RepositorioClientesArrayList implements IRepositorioClientes {
    
    private ArrayList<Cliente> array;
    
    public RepositorioClientesArrayList(){
        array = new ArrayList();
    }

    @Override
    public void adicionar(Cliente cliente){
        array.add(cliente);
    }

    @Override
    public void remover(Cliente cliente) {
        int indice = array.indexOf(cliente);
        if(indice != -1){
            array.remove(cliente);
        }
    }

    @Override
    public void atualizar(Cliente cliente) {
        int indice = array.indexOf(cliente);
        if(indice != -1){
            array.set(indice, cliente);
        }
    }

    @Override
    public Cliente consultar(String CPF) {
        Cliente clienteProcurado = null;
        for(Cliente cliente : array){
            if(cliente.getCPF().equals(CPF)){
                clienteProcurado = cliente;
                break;
            }
        }
        return clienteProcurado;
    }

    @Override
    public Cliente consultar(Cliente cliente) {
        Cliente clienteProcurado = null;
        for(Cliente cliente2 : array){
            if(cliente2.equals(cliente)){
                clienteProcurado = cliente2;
                break;
            }
        }
        return clienteProcurado;
    }

    @Override
    public void listar() {
        for(Cliente cliente : array){
            System.out.println(cliente);
        }
    }

    @Override
    public boolean existe(String CPF) {
        boolean existe = false;
        for(Cliente cliente : array){
            if(cliente.getCPF().equals(CPF)){
                existe = true;
                break;
            }
        }
        return existe;
    }
    
}