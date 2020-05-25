package CadastroAulaExtra;
/**
 *
 * @author Stéfani Carol
 */
public abstract class Pessoa { 
    
    private String nome;
    private int idade, matricula, faltas;

    public Pessoa() {
    }
    public Pessoa(String nome, int idade, int matricula, int faltas) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.faltas = faltas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    @Override
    public String toString() {
        return  nome + ", " + idade + " anos, matrícula: " + matricula + ", " + faltas + " faltas, " ;
    }  
}
