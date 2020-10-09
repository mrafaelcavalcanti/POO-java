package negocio.entidade;

public class Cliente {
    private String nome;
    private int idade;
    private String CPF;
    private Endereco endereco;

    public Cliente(){
        
    }
    
    public Cliente(String nome, int idade, String CPF, Endereco endereco){
        this.nome = nome;
        this.idade = idade;
        this.CPF = CPF;
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
    
    public String getCPF() {
        return CPF;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    @Override
    public boolean equals(Object obj){
        if(obj instanceof Cliente){
            Cliente cliente = (Cliente) obj;
            if(this.CPF.equals(cliente.getCPF())){
                return true;
            }            
        }
        return false;
    }

    @Override
    public String toString(){
        return  "nome do cliente: " +nome +"; idade: " +idade+"; CPF:" +CPF + "; endereco: "+endereco.toString();
    }
}