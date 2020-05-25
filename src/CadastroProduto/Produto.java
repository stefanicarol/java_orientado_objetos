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
public class Produto {
    private int codigo;
    private String descricao;
    private Categoria categoria;
    private double precoFornecedor;

    public Produto() {
    }

    public Produto(int codigo, String descricao, Categoria categoria, double precoFornecedor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.precoFornecedor = precoFornecedor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPrecoFornecedor() {
        return precoFornecedor;
    }

    public void setPrecoFornecedor(double precoFornecedor) {
        this.precoFornecedor = precoFornecedor;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", descricao=" + descricao + ", categoria=" + categoria + ", precoFornecedor=" + precoFornecedor + '}';
    }
    
    public double calculaValorImp(){
        return precoFornecedor * categoria.getPercImposto()/100;
    }
    
    public double calculaPrecoVenda(){
        double custo = precoFornecedor + calculaValorImp();
        return custo * 1.3;
    }
}
