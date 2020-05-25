 
package VendasQuadros;
 
public class Telefone {
    private int cod;
    private int ddd;
    private int numero;

    public Telefone() {
    } 
    
    public Telefone(int cod, int ddd, int numero) {
        this.cod = cod;
        this.ddd = ddd;
        this.numero = numero;
    } 
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Telefone{" + "cod=" + cod + ", ddd=" + ddd + ", numero=" + numero + '}';
    }
     
}
