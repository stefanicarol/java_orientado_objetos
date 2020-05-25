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
public class Venda {
    private int cod;
    private Cliente cliente;
    private Veiculo veiculo;

    public Venda() {
    }

    public Venda(int cod, Cliente cliente, Veiculo veiculo) {
        this.cod = cod;
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public String toString() {
        return "Venda{" + "cod=" + cod + ", cliente=" + cliente + ", veiculo=" + veiculo + '}';
    }
    
    
}
