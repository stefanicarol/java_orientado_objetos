package ProvaG1;
/**
 *
 * @author Stéfani Carol
 */
public class Diretor extends Funcionario {

    public Diretor() {
    }

    public Diretor(double salario, int valorHoraAula) {
        super(salario, valorHoraAula);
    }

    public Diretor(double salario, int idade, String nome,  int matricula, int faltas) {
        super(salario, nome, idade, matricula, faltas);
    }
   
   @Override
   public double SalarioLiquido(){ 
      double desconto = (super.getSalario()/30)*super.getFaltas();
      double salario = super.getSalario() - desconto;
      return salario*1.5;
   }
    @Override
    public String toString() {
        return super.toString() + " Salário com Bonificação R$" + SalarioLiquido();
    }
    
    
}
