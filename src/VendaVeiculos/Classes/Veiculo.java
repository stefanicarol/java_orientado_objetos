package VendaVeiculos.Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Madianita
 */
public abstract class Veiculo {
    private int cod;
    private String placa, marca, modelo;
    private int ano;
    private double valorDoBem;
    private boolean vendido;

    public Veiculo() {
        vendido = false;
    }

    public Veiculo(int cod, String placa, String marca, String modelo, int ano, double valorDoBem) {
        this.cod = cod;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valorDoBem = valorDoBem;
        vendido = false;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValorDoBem() {
        return valorDoBem;
    }

    public void setValorDoBem(double valorDoBem) {
        this.valorDoBem = valorDoBem;
    }

    public boolean isVendido() {
        return vendido;
    }   

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "cod=" + cod + ", placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", valorDoBem=" + valorDoBem + ", vendido=" + vendido + '}';
    }
    
    public abstract double calculaValorVenda();

}
