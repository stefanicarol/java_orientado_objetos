 
package CadastroAulaExtra;  

public class Aula {
    private int cod;
    private String disciplinas;
    private Pessoa nomeProfessor;
    private Aluno nomeAluno;
    private int horaAula;

    public Aula() {}

    public Aula(int cod, String disciplinas, Pessoa nomeProfessor, Aluno nomeAluno, int horaAula) {
        this.cod = cod;
        this.disciplinas = disciplinas;
        this.nomeProfessor = nomeProfessor;
        this.nomeAluno = nomeAluno;
        this.horaAula = horaAula;
    }

    public int getHoraAula() {
        return horaAula;
    }

    public void setHoraAula(int horaAula) {
        this.horaAula = horaAula;
    }
 
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(String disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Pessoa getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(Pessoa nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public Aluno getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(Aluno nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    @Override
    public String toString() {
        return "Aula " + cod + ", " + disciplinas + ", Professor: " + nomeProfessor.getNome() + ", Aluno: " + nomeAluno.getNome() + ", " +   horaAula +" horas aula";
    }
     
    
}
