/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velocidade;

/**
 *
 * @author Madianita
 */
public class Carro {
    String placa;
    double velCarro;
    static double velMax; //atributo de classe - mesmo valor para todos os objetos dela
    
    public double verificar(){
        if (velCarro <= velMax){
            return 0;
        }
        
        return (velCarro - velMax) * 10.0;
    }
}
