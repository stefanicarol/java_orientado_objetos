
package VendasQuadros;
import java.util.ArrayList;

public class Venda {
 
    private int codVenda;
    private String data;
    Cliente cliente;
    ArrayList<Quadro> quadros;

    public Venda() {
        quadros = new ArrayList();
    }
     
    public Venda(int codVenda, String data, Cliente cliente) {
        this.codVenda = codVenda;
        this.data = data;
        this.cliente = cliente;
        quadros = new ArrayList();
    }
       
    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Quadro> getQuadros() {
        return quadros;
    }

    public void addQuadro(Quadro quadro){
        quadros.add(quadro);
    }
    
    
    @Override
    public String toString() {
        return "Venda{" + "codVenda=" + codVenda + ", data=" + data + ", cliente=" + cliente + ", quadros=" + quadros + '}';
    }

}
