package dd.main;

import dd.core.AtaqueDaga;
import dd.core.AtaqueEspada;
import dd.core.AtaqueArco;  
import dd.core.Personaje;
import dd.core.Rey;
import dd.core.Caballero;
import dd.core.Troll;

public class ControlLucha {
    Ejercito ejercito1;
    Ejercito ejercito2;

    public ControlLucha() {
        crearEjercitoHumano();
        crearEjercitoTrol();
        lucha();
        resultados();

    }

    private void crearEjercitoHumano() {
        Personaje[] ejercitoHumanos = new Personaje[3];
        ejercitoHumanos[0] = new Rey("Rey");
        ejercitoHumanos[0].setAtaque(new AtaqueEspada());
        ejercitoHumanos[1] = new Caballero("Caballero1");
        ejercitoHumanos[1].setAtaque(new AtaqueEspada());
        ejercitoHumanos[2] = new Caballero("Caballero2");
        ejercitoHumanos[2].setAtaque(new AtaqueArco());
        ejercito1 = new Ejercito(ejercitoHumanos.length, "Ejercito Humano");
        ejercito1.setPersonajes(ejercitoHumanos);
    }

    private void crearEjercitoTrol() {
        int numeroTrolls = (int)(Math.random()*10+1);
        System.out.println("Numero de trolls: " + numeroTrolls);
        Personaje[] ejercitoTrolls = new Personaje[numeroTrolls];
        ejercitoTrolls[0] = new Troll("Troll1");
        if (ejercitoTrolls.length > 1)
            ejercitoTrolls[1] = new Troll("Troll2");
        if (ejercitoTrolls.length > 2)
            ejercitoTrolls[2] = new Troll("Troll3");
        if (ejercitoTrolls.length > 3)
            ejercitoTrolls[3] = new Troll("Troll4");
        if (ejercitoTrolls.length > 4)
            ejercitoTrolls[4] = new Troll("Troll5");
        if (ejercitoTrolls.length > 5)
            ejercitoTrolls[5] = new Troll("Troll6");
        if (ejercitoTrolls.length > 6) 
            ejercitoTrolls[6] = new Troll("Troll7");
        if (ejercitoTrolls.length > 7)
            ejercitoTrolls[7] = new Troll("Troll8");
        if (ejercitoTrolls.length > 8)
            ejercitoTrolls[8] = new Troll("Troll9");
        if (ejercitoTrolls.length > 9)
            ejercitoTrolls[9] = new Troll("Troll10");
        ejercito2 = new Ejercito(ejercitoTrolls.length, "Ejercito Troll");
        ejercito2.setPersonajes(ejercitoTrolls);
    }

    private void lucha() {
        while (!ejercito1.ejercitoMuerto() && !ejercito2.ejercitoMuerto()){
            System.out.println(ejercito1.atacar(ejercito2));
            if (!ejercito2.ejercitoMuerto()) 
                System.out.println(ejercito2.atacar(ejercito1));   
        }
    }

    private void resultados() {
        System.out.println("Ejercito 1: " + ejercito1.getNCaidos());
        System.out.println("Ejercito 2: " + ejercito2.getNCaidos());

        if (ejercito2.ejercitoMuerto()) {
            System.out.println(ejercito1);

        } else if (ejercito1.ejercitoMuerto()) {
            System.out.println(ejercito2);
        } else {
            System.out.println("Empate");
        }
    }
    
}
