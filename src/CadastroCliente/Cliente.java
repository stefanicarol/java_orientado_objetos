package CadastroCliente;  

public class Cliente {
   private int codigo;
   private String cpf;
   private String nome;
   private int anoCompra;
   private Contato contato;

    public Cliente(){
        contato = new Contato();
    }
   
    public Cliente(int codigo, String cpf, String nome, int anoCompra,String eMail, String telefone) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
        this.anoCompra = anoCompra;
        this.contato = new Contato(eMail, telefone);
    }
    public String getTelefone(){
        return contato.getFone();
    }
    
    public void setTelefone(String telefone){ 
        this.contato.setFone(telefone); 
    }
     public void setEmail(String email){
         contato.seteMail(email); 
    }
      
     public String getEmail(){
        return contato.geteMail();
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoCompra() {
        return anoCompra;
    }

    public void setAnoCompra(int anoCompra) {
        this.anoCompra = anoCompra;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
   
      @Override
    public String toString() {
        return "Cliente{" + "Código: " + codigo + ", CPF: " + cpf + ", Nome: " + nome + ", Ano compra: " 
                + anoCompra + ", E-mail: " + this.getEmail() + ", Telefone: " + this.getTelefone() +'}';
    }
   
   
}
