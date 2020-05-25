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
public class Carro extends Veiculo{
    private int qtPortas;

    public Carro() {
        super();
    }

    public Carro(int cod, String placa, String marca, String modelo, int ano, double valorDoBem, int qtPortas) {
        super(cod, placa, marca, modelo, ano, valorDoBem);
        this.qtPortas = qtPortas;
    }

    @Override
    public String toString() {
        return "Carro{ " + super.toString() + " qtPortas=" + qtPortas + '}';
    }
    
    
    
    
    @Override
    public double calculaValorVenda(){
        return getValorDoBem() * 1.03;
    }    
}
