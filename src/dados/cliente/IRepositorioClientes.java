package dados.cliente;

import negocio.entidade.Cliente;

public interface IRepositorioClientes {
    void adicionar(Cliente cliente);

    void remover(Cliente cliente);

    void atualizar(Cliente cliente);

    Cliente consultar(String CPF);

    Cliente consultar(Cliente cliente);

    void listar();

    boolean existe(String CPF);
    
}