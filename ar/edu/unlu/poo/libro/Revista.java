package ar.edu.unlu.poo.libro;

import java.time.Year;

public class Revista extends Publicaciones{ //tienen la misma logica que los libros
    private String ISSN;
    private int numero;
    private Year anioPublicacion;

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setAnioPublicacion(Year anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Year getAnioPublicacion() {
        return anioPublicacion;
    }
}
