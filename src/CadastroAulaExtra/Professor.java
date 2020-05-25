package CadastroAulaExtra;
/**
 *
 * @author Stéfani Carol
 */
public class Professor extends Funcionario {
    private String disciplinas;
    private int valorHoraAula;
    
    public Professor() {}

    public Professor(String disciplinas, int valorHoraAula) {
        this.disciplinas = disciplinas;
        this.valorHoraAula = valorHoraAula;
         
    }
   
   public Professor(String disciplinas, double salario,int valorHoraAula,  String nome, int idade, int matricula, int faltas) {
        super(salario, nome, idade, matricula, faltas);
        this.disciplinas = disciplinas;
        this.valorHoraAula = valorHoraAula;
     
    }

  
    public int getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(int valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }
    
    public String getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(String disciplinas) {
        this.disciplinas = disciplinas;
    } 
    
   @Override
   public double SalarioLiquido(){ 
      double desconto = (super.getSalario()/30)*super.getFaltas();
      double salario = super.getSalario() - desconto; 
      return salario*1.0;
   }
   
   public void SalarioExtra(double horas){  
       super.setHoraExtra(super.getHoraExtra()+(this.valorHoraAula * horas)); 
   }
    
    @Override
    public String toString() {
        return super.toString() + ", disciplina: " + disciplinas;
    }
   
    
}
