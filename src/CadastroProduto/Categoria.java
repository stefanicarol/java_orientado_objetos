package CadastroProduto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Madianita
 */
public class Categoria {
    private int cod;
    private String nomeCat;
    private double percImposto;

    public Categoria() {
    }

    public Categoria(int cod, String nomeCat, double percImposto) {
        this.cod = cod;
        this.nomeCat = nomeCat;
        this.percImposto = percImposto;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNomeCat() {
        return nomeCat;
    }

    public void setNomeCat(String nomeCat) {
        this.nomeCat = nomeCat;
    }

    public double getPercImposto() {
        return percImposto;
    }

    public void setPercImposto(double percImposto) {
        this.percImposto = percImposto;
    }

    @Override
    public String toString() {
        return "Categoria{" + "cod=" + cod + ", nomeCat=" + nomeCat + ", percImposto=" + percImposto + '}';
    }
    
    
}
