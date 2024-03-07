package dd.main;

import dd.core.Personaje;

public class Ejercito {
    private Personaje[] personajes;
    private String nombre;
    private int nPersonajes;
    private int nCaidos;

    public Ejercito(int nPersonajes, String nombre) {
        this.nombre = nombre;
        this.nPersonajes = nPersonajes;
        this.personajes = new Personaje[nPersonajes];
        this.nCaidos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPersonaje(Personaje personaje, int index) {
        this.personajes[index] = personaje;
    }

    public int getNCaidos() {
        return nCaidos;
    }

    public void setNCaidos(int nCaidos) {
        this.nCaidos = nCaidos;
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
                if (enemigoAtacado == ejercito.getNPersonajes() - 1) {
                    enemigoAtacado = 0;
                } else {
                    enemigoAtacado++;
                }
                
                if (ejercito.ejercitoMuerto()) {
                    break;
                }
            }
            if (this.personajes[i].getSalud() > 0 && ejercitoAtacado[enemigoAtacado].getSalud() > 0){
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
                    ejercito.setNCaidos(ejercito.getNCaidos() + 1);
                } else {
                    resultados.append(ejercitoAtacado[enemigoAtacado])
                            .append("\n");
                }
            }
            i++;
        }
        resultados.append("Fin de ataque\n")
                .append("Salud de ejercito atacado: ")
                .append(ejercitoAtacado[0].getSalud())
                .append(" ")
                .append(ejercitoAtacado[1].getSalud())
                .append(" ")
                .append(ejercitoAtacado[2].getSalud())
                .append("\n");
        return resultados.toString();
    }

    public String toString() {
        StringBuilder resultado = new StringBuilder();
        resultado.append(nombre)
                 .append(": { ");
        for (Personaje personaje : this.personajes) {
            resultado.append(personaje)
                    .append(" ");

        }
        resultado.append("}");
        return resultado.toString();
    }
    
}
