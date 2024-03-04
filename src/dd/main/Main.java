package dd.main;

import dd.core.AtaqueDaga;
import dd.core.AtaqueEspada;
import dd.core.AtaqueArco;  
import dd.core.Personaje;
import dd.core.Rey;
import dd.core.Caballero;
import dd.core.Troll;

public class Main {
    public static void main(String[] args) {
        Personaje[] ejercitoHumanos = new Personaje[3];
        ejercitoHumanos[0] = new Rey("Rey");
        ejercitoHumanos[0].setAtaque(new AtaqueEspada());
        ejercitoHumanos[1] = new Caballero("Caballero1");
        ejercitoHumanos[1].setAtaque(new AtaqueEspada());
        ejercitoHumanos[2] = new Caballero("Caballero2");
        ejercitoHumanos[2].setAtaque(new AtaqueArco());
        Ejercito ejercito1 = new Ejercito(ejercitoHumanos.length);
        ejercito1.setPersonajes(ejercitoHumanos);
        
        Personaje[] ejercitoTrolls = new Personaje[3];
        ejercitoTrolls[0] = new Troll("Troll1");
        ejercitoTrolls[1] = new Troll("Troll2");
        ejercitoTrolls[2] = new Troll("Troll3");
        Ejercito ejercito2 = new Ejercito(ejercitoTrolls.length);
        ejercito2.setPersonajes(ejercitoTrolls);

        while (!ejercito1.ejercitoMuerto() && !ejercito2.ejercitoMuerto()){
            System.out.println(ejercito1.atacar(ejercito2));
            System.out.println(ejercito2.atacar(ejercito1));
        }
        
        System.out.println("Ejercito 1: " + ejercito1.getNVictorias());
        System.out.println("Ejercito 2: " + ejercito2.getNVictorias());

    }
    
}