package ar.edu.unlu.poo.libro;

import java.time.Year;
import java.util.ArrayList;

public class LibroTP2 extends Publicaciones{
    //puse que extienda de publicaciones porque si hago que herede lo del tp1
    // va a tener dos veces algunos datos mezclados con publicaciones y no sirve
    private String ISBN;
    private int cant_paginas;
    private ArrayList<String> autores;
    private Year anioPublicacion;

    public LibroTP2(String titulo, ArrayList<String> autores, int cant_paginas, String editor, String telefono, String proveedor, int cant_ejemplares, String ISBN, Year anio){
        this.nombre = titulo;
        this.autores = autores;
        this.cant_paginas = cant_paginas;
        this.editor = editor;
        this.telefono = telefono;
        this.proveedor = proveedor;
        this.ISBN = ISBN;
        this.anioPublicacion = anio;
        for (int i = 0;i < cant_ejemplares; i++){
            Ejemplar nuevo_ejemplar = new Ejemplar();
            nuevo_ejemplar.setNro(i + 1);
            this.ejemplares.add(nuevo_ejemplar);
        }
    }

    public String getISBN() {
        return ISBN;
    }

    public int getCant_paginas() {
        return cant_paginas;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public Year getAnioPublicacion() {
        return anioPublicacion;
    }
}
