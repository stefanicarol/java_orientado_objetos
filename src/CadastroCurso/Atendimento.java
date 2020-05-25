package cadastrocurso;
public class Atendimento extends Curso{
    private int aulaExternas;

    public Atendimento() {}

    public Atendimento(int codCurso, int vagas, String titulo, String ministrante, int aulaExternas) {
        super(codCurso, vagas, titulo, ministrante);
        this.aulaExternas = aulaExternas;
    }
 
    
    public int getAulaExternas() {
        return aulaExternas;
    }

    public void setAulaExternas(int aulaExternas) {
        this.aulaExternas = aulaExternas;
    }
    
  @Override
    public double calculaInscricao(){ 
        return super.calculaInscricao()+ getAulaExternas()*30;
    } 
    
   @Override
    public String toString() {
        return super.toString() + ", Aulas Externas:" + aulaExternas;
    }
    
}
