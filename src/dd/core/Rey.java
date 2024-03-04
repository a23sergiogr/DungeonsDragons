package dd.core;

public class Rey extends Personaje{
    private static final int VIDA = 2000;
    private static final int nAtaques = 3;

    public Rey(String nombre) {
        super(nombre, VIDA, nAtaques);
    }
}
