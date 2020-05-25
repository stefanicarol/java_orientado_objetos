package CadastroAutomovel;

public class Automovel {
    String marca, modelo;
    int ano;
    boolean ligado = false;    
    
    public void ligar() { 
        ligado = true;
    }
    public void desligar() { 
        ligado = false;
    }
    public String verEstado() { 
        if (ligado) return "ligado";
        return "desligado";
    }    
}

