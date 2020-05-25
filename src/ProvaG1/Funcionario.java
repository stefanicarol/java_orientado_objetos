 package ProvaG1;
/**
 *
 * @author Stéfani Carol
 */
public abstract class Funcionario extends Pessoa {
  private double salario;
  private double horaExtra = 0;

    public double getHoraExtra() {
        return horaExtra;
    }

    public Funcionario(double salario) {
        this.salario = salario;
    }

    public void setHoraExtra(double horaExtra) {
        this.horaExtra = horaExtra;
    }
  
    public Funcionario() {
    }

    public Funcionario(double salario, int valorHoraAula) {
        this.salario = salario;       
    }

    public Funcionario(double salario, String nome, int idade, int matricula, int faltas) {
        super(nome, idade, matricula, faltas);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
 
    public abstract double SalarioLiquido(); 

    @Override
    public String toString() {
        return super.toString()+ "salario : R$ " + salario ;
    }
         
}
