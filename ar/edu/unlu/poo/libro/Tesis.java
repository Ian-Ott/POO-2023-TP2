package ar.edu.unlu.poo.libro;

import java.time.Month;
import java.time.Year;

public class Tesis extends Publicaciones {
    private String autor;
    private Month mesPublicacion;
    private Year anioPublicacion;

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setMesPublicacion(Month mesPublicacion) {
        this.mesPublicacion = mesPublicacion;
    }

    public Month getMesPublicacion() {
        return mesPublicacion;
    }

    public void setAnioPublicacion(Year anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Year getAnioPublicacion() {
        return anioPublicacion;
    }
}
