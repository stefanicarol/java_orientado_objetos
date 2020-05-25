 
package cadastrocurso;
 
public class Curso { 
   
    private int codCurso, vagas;
    private String titulo, ministrante;

    public Curso() {}

    public Curso(int codCurso, int vagas, String titulo, String ministrante) {
        this.codCurso = codCurso;
        this.vagas = vagas;
        this.titulo = titulo;
        this.ministrante = ministrante;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMinistrante() {
        return ministrante;
    }

    public void setMinistrante(String ministrante) {
        this.ministrante = ministrante;
    }
    
    public double calculaInscricao(){
        return 10000.00/this.getVagas();        
    }
    
    @Override
    public String toString() {
        return  "Código do Curso:" + codCurso + ", Quantidade de Vagas:" + vagas + ", Título:" + titulo + ", Ministrante:" + ministrante +", Valor da inscrição: R$ "+ calculaInscricao();
    }
}
