package EventoBeneficente.Classes;  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Madianita
 */
public class Cliente {
    private String cpf, nome, telefone;
    private boolean comprou;

    public Cliente() {
         comprou = false;
    }
 
     
    public Cliente(String cpf, String nome, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        comprou = false;
        
    }

    public boolean isComprou() {
        return comprou;
    }

    public void setComprou(boolean comprou) {
        this.comprou = comprou;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", comprou =" + comprou +'}';
    }
    
    
    
}
