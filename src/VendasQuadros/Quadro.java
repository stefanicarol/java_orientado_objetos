package VendasQuadros;

public class Quadro {
    private int cod;
    private String titulo;
    private boolean vendido;
    private double valor;

    public Quadro() {}
       
    public Quadro(int cod, String titulo, boolean vendido, double valor) {
        this.cod = cod;
        this.titulo = titulo;
        this.vendido = vendido;
        this.valor = valor;
    }
        
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Quadros{" + "cod=" + cod + ", titulo=" + titulo + ", vendido=" + vendido + ", valor=" + valor + '}';
    }
    
}
