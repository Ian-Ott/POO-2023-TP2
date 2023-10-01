package ar.edu.unlu.poo.libro;

import java.time.Year;

public class Revista extends Publicaciones{ //tienen la misma logica que los libros
    private String ISSN;
    private int numero;
    private Year anioPublicacion;

    public Revista(String titulo, String editor, String telefono, String proveedor, int cantEjemplares, String issn, int numeroRevista, Year anioPublicacion) {
        this.nombre = titulo;
        this.editor = editor;
        this.telefono = telefono;
        this.proveedor = proveedor;
        for (int i = 0;i < cantEjemplares; i++){
            Ejemplar nuevo_ejemplar = new Ejemplar();
            nuevo_ejemplar.setNro(i + 1);
            this.ejemplares.add(nuevo_ejemplar);
        }
        this.ISSN = issn;
        this.numero = numeroRevista;
        this.anioPublicacion = anioPublicacion;
    }

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
