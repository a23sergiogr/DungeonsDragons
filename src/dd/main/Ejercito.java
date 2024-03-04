package dd.main;

import dd.core.Personaje;

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

    public boolean ejercitoMuerto() {
        for (Personaje personaje : this.personajes) {
            if (personaje.getSalud() > 0) {
                return false;
            }
        }
        return true;
    }


    public String atacar(Ejercito ejercito) {
        StringBuilder resultados = new StringBuilder();
        int i = 0;
        Personaje[] ejercitoAtacado = ejercito.getPersonajes();
        while (i < this.nPersonajes) {
            int enemigoAtacado = (int) (Math.random() * ejercito.getNPersonajes());
            while (ejercitoAtacado[enemigoAtacado].getSalud() <= 0) {
                enemigoAtacado = (int) (Math.random() * ejercito.getNPersonajes());
            }
            int[] valoresAtaque = this.personajes[i].ataca(ejercitoAtacado[enemigoAtacado]);
            for (int valor : valoresAtaque) {
                if (valor > 0) resultados.append(this.personajes[i].getNombre())
                        .append(" ataca a ")
                        .append(ejercitoAtacado[enemigoAtacado].getNombre())
                        .append(" y el valor del ataque es: ")
                        .append(valor)
                        .append("\n");
                else resultados.append(this.personajes[i].getNombre())
                        .append(" ataca a ")
                        .append(ejercitoAtacado[enemigoAtacado].getNombre())
                        .append(" y el valor del ataque es: ")
                        .append("falla")
                        .append("\n");
            }
            resultados.append("comprobar salud actualizada de ")
                    .append(ejercitoAtacado[enemigoAtacado].getNombre())
                    .append("\n");
            if (ejercitoAtacado[enemigoAtacado].getSalud() <= 0) {
                resultados.append("MUERTO ")
                        .append(ejercitoAtacado[enemigoAtacado].getNombre())
                        .append("\n");
                ejercitoAtacado[enemigoAtacado].setSalud(0);
                ejercito.setNVictorias(ejercito.getNVictorias() + 1);
            } else {
                resultados.append(ejercitoAtacado[enemigoAtacado])
                        .append("\n");
            }
            i++;
        }
                     
        return resultados.toString();
    }
    
}
