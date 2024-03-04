package dd.core;

public class Troll extends Personaje{
    private static final int VIDA = 1000;
    private static final int nAtaques = 1;

    public Troll(String nombre) {
        super(nombre, VIDA, nAtaques);
        int tipoAtaque = ((int) (Math.random() * 3) + 1);
        switch (tipoAtaque) {
            case 1:
                setAtaque(new AtaqueDaga());
                break;
            case 2:
                setAtaque(new AtaqueEspada());
                break;
            case 3:
                setAtaque(new AtaqueArco());
                break;
            default:
                break;
        }
    } 
}
