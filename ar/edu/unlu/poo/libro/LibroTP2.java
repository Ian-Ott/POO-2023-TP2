package ar.edu.unlu.poo.libro;

import java.time.Year;
import java.util.ArrayList;

public class LibroTP2 extends Publicaciones{
    //puse que extienda de publicaciones porque si hago que herede lo del tp1
    // va a tener dos veces algunos datos mezclados con publicaciones y no sirve
    private String ISBN;
    private int cant_paginas;
    private ArrayList<String> autores = new ArrayList<>();
    private Year anioPublicacion;

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void agregarAutor(String autor) {
        autores.add(autor);
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAnioPublicacion(Year anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Year getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setCant_paginas(int cant_paginas) {
        this.cant_paginas = cant_paginas;
    }

    public int getCant_paginas() {
        return cant_paginas;
    }

    public void agregar_libro(String titulo, ArrayList<String> autor, int cant_paginas, String editor, String telefono, String proveedor, int cant_ejemplares, String ISBN, Year anio ) {
        LibroTP2 nuevo_libro = new LibroTP2();
        nuevo_libro.setNombre(titulo);
        nuevo_libro.setCant_paginas(cant_paginas);
        for (int i = 0; i<autor.size();i++){
            nuevo_libro.agregarAutor(autor.get(i));
        }
        nuevo_libro.setEditor(editor);
        nuevo_libro.setTelefono(telefono);
        nuevo_libro.setISBN(ISBN);
        nuevo_libro.setProveedor(proveedor);
        nuevo_libro.setAnioPublicacion(anio);
        for (int i = 0;i < cant_ejemplares; i++){
            Ejemplar nuevo_ejemplar = new Ejemplar();
            nuevo_libro.agregarEjemplares(nuevo_ejemplar);
        }
    }
}
