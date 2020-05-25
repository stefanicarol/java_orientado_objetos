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
public class Moto extends Veiculo{
    private int qtCilindrada;

    public Moto() {
        super();
    }

    public Moto(int cod, String placa, String marca, String modelo, int ano, double valorDoBem, int qtCilindrada) {
        super(cod, placa, marca, modelo, ano, valorDoBem);
        this.qtCilindrada = qtCilindrada;
    }

    public int getQtCilindrada() {
        return qtCilindrada;
    }

    public void setQtCilindrada(int qtCilindrada) {
        this.qtCilindrada = qtCilindrada;
    }

    @Override
    public String toString() {
        return " Moto{" + super.toString() + "qtCilindrada=" + qtCilindrada + '}';
    }

    
    @Override
    public double calculaValorVenda(){
        return getValorDoBem() + 100.00;
    }
}
