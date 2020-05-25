package VendasQuadros;

public class Cliente {
    private int codCliente;
    private String nome;
    private Telefone telefone; 

    public Cliente() {
     telefone = new Telefone();   
    }
    
    public Cliente(int codCliente, String nome, int cod, int ddd, int numero ) {
        this.codCliente = codCliente;
        this.nome = nome;
        telefone = new Telefone(cod, ddd, numero);
    }
    
    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNum(int num){
        telefone.setNumero(num);
    }
     public void setDDD(int ddd){
        telefone.setDdd(ddd);
    }
    public void setCod(int cod){
        telefone.setCod(cod);
    }
    
    public int getDDD(){
        return telefone.getDdd();
    }
     public int getcod(){
        return telefone.getCod();
    }
      public int getNumero(){
        return telefone.getNumero();
    }
    
    @Override
    public String toString() {
        return "Clientes{" + "codCliente=" + codCliente + ", nome=" + nome + ", telefone=" + telefone + '}';
    }
    
    
}
