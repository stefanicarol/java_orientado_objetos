package ControleLivros;
/**
 *
 * @author stefa
 */
public class Livro {
    private String titulo, categoria, codigo; // atributos
    private float valorCompra; // atributos
    
    
    public Livro(){}

    public Livro(String titulo, String categoria, String codigo,  float valorCompra) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.codigo = codigo;
        this.valorCompra = valorCompra;
    }

  
 
    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public float getvalorCompra() {
        return valorCompra;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setValorVenda(float valorCompra) {
        this.valorCompra = valorCompra;
    }
    
     public double valorVenda(){
        float valorVenda = (valorCompra/100)*50;
         return valorVenda+valorCompra;
    }   
    
        public String toString(){
        return "{Livro} Código: " + codigo + " Título: " + titulo
                + " Categoria: " + categoria + " Valor de Compra: " + valorCompra + " Valor de Venda: " + valorVenda();
    }
}
