package ProvaG1;
/**
 *
 * @author Stéfani Carol
 */
public class Aluno extends Pessoa {
     
   private double nota1, nota2;    

    public Aluno() {
    }

    public Aluno(double nota1, double nota2) {
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public Aluno(double nota1, double nota2, String nome, int idade, int matricula, int faltas) {
        super(nome, idade, matricula, faltas);
        this.nota1 = nota1;
        this.nota2 = nota2;
    }
    
    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }
    
    public boolean Aprovado(){ 
        if(Media() < 7 || super.getFaltas() > 10){
            return true;
        }
            return false;
    }
    public double Media(){ 
        return (this.nota1 + this.nota2)/2; 
    }
     @Override
    public String toString() {
        return super.toString() + ", Nota 1: " + nota1 + ", Nota 2: " + nota2 +", Reprovado: " + Aprovado() +", Média Final: " + Media();
    }
}
