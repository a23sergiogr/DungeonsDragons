package dd.core;

public class Ejercito {
    private Personaje[] personajes;
    private int nPersonajes;
    private int nVictorias;

    public Ejercito(int nPersonajes) {
        this.nPersonajes = nPersonajes;
        this.personajes = new Personaje[nPersonajes];
        this.nVictorias = 0;
    }

    public void setPersonaje(Personaje personaje, int index) {
        this.personajes[index] = personaje;
    }

    public int getNVictorias() {
        return nVictorias;
    }

    public void setNVictorias(int nVictorias) {
        this.nVictorias = nVictorias;
    }

    public Personaje[] getPersonajes() {
        return personajes;
    }

    public void setPersonajes(Personaje[] personajes) {
        this.personajes = personajes;
    }

    public int getNPersonajes() {
        return nPersonajes;
    }

    public void setNPersonajes(int nPersonajes) {
        this.nPersonajes = nPersonajes;
    }

    public void atacar(Ejercito ejercito) {
        int i = 0;
        int j = 0;
        while (i < this.nPersonajes && j < ejercito.getNPersonajes()) {
            int[] valoresAtaque = this.personajes[i].ataca(ejercito.getPersonajes()[j]);
            for (int valor : valoresAtaque) {
                System.out.println(this.personajes[i].getNombre() + " ataca a " + ejercito.getPersonajes()[j].getNombre() + " y el valor del ataque es: " + (valor > 0 ? valor : "falla"));
            }
            System.out.println("comprobar salud actualizada de " + ejercito.getPersonajes()[j].getNombre());
            if (ejercito.getPersonajes()[j].getSalud() <= 0) {
                System.out.println("MUERTO " + ejercito.getPersonajes()[j].getNombre());
                ejercito.setNVictorias(ejercito.getNVictorias() + 1);
                j++;
            } else {
                System.out.println(ejercito.getPersonajes()[j]);
            }
            i++;
        }
    }
    
}
