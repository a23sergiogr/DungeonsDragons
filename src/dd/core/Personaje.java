package dd.core;

public class Personaje {
    private Ataque ataque;

    private String nombre;
    private int nAtaques;
    private int salud;

    public Personaje(String nombre, int salud, int nAtaques) {
        this.nombre = nombre;
        this.salud = salud;
        this.nAtaques = nAtaques;
        this.ataque = new AtaqueDaga();
    }

    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }
    
    public String getAtaque() {
        return ataque.getNombre();
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] ataca(Personaje atacado) {
        int[] ataques = new int[nAtaques];
        int i = 0;
        while (i < nAtaques && atacado.getSalud() > 0) {
            ataques[i] = ataque.ejecutarAtaque();
            atacado.setSalud(atacado.getSalud() - ataques[i]);
            i++;            
        }
        return ataques;
    }

    public String toString() {
        return "[" + nombre + ", " + salud + "]";
    }
}
