package CadastroCliente;

 public class Contato {
    private String eMail, fone;

    public Contato() {}

    public Contato(String eMail, String fone) {
        this.eMail = eMail;
        this.fone = fone;
    }

    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    public String getFone() {
        return fone;
    }
    public void setFone(String fone) {
        this.fone = fone;
    }
    @Override
        public String toString() {
        return "eMail: " + eMail + " Telefone=" + fone;
    }
}
