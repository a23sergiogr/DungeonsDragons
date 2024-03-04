package dd.core;

public class AtaqueDaga implements Ataque{
    private final int ATAQUE = 25;
    
    // Implementacion del metodo de la interfaz Ataque
    // Ataque * (0 o 1) * un numero aleatorio entre 0 y 1
    public int ejecutarAtaque(){
        return (int) (ATAQUE * (int)(Math.random()*2) * Math.random());
    }    

    public String getNombre() {
        return "Ataque con Daga";
    }
}
