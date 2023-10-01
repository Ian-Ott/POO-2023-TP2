package ar.edu.unlu.poo.libro;

import java.time.Month;
import java.time.Year;

public class Tesis extends Publicaciones {
    private String autor;
    private Month mesPublicacion;
    private Year anioPublicacion;

    public Tesis(String titulo, String editor, String telefono, String proveedor, int cantEjemplares, String autor, Month mesPublicacion, Year anioPublicacion) {
        this.nombre = titulo;
        this.editor = editor;
        this.telefono = telefono;
        this.proveedor = proveedor;
        for (int i = 0;i < cantEjemplares; i++){
            Ejemplar nuevo_ejemplar = new Ejemplar();
            nuevo_ejemplar.setNro(i + 1);
            this.ejemplares.add(nuevo_ejemplar);
        }
        this.autor = autor;
        this.mesPublicacion = mesPublicacion;
        this.anioPublicacion = anioPublicacion;
    }

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
