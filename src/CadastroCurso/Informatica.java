package cadastrocurso;
public class Informatica extends Curso{ 

    public Informatica() {
    }

    public Informatica(int codCurso, int vagas, String titulo, String ministrante) {
        super(codCurso, vagas, titulo, ministrante);
    }
           
    @Override
    public double calculaInscricao(){
         return super.calculaInscricao()+50;
    } 

    @Override
    public String toString() {
        return super.toString();
    }
}
