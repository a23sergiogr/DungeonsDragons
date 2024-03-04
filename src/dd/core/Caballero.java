package dd.core;

public class Caballero extends Personaje{
    private static final int VIDA = 1500;
    private static final int nAtaques = 2;

    public Caballero(String nombre) {
        super(nombre, VIDA, nAtaques);
    }
}
