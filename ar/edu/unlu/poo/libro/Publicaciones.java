package ar.edu.unlu.poo.libro;

import java.time.Year;
import java.util.ArrayList;

public class Publicaciones extends BibliotecaTP1{
    //hago que extienda a la biblioteca anterior asi tiene acceso a todos los metodos del tp1
    protected String nombre;
    protected String editor;
    protected String telefono;
    protected String proveedor;
    protected ArrayList<Ejemplar> ejemplares = new ArrayList<>();


    public String getNombre() {
        return nombre;
    }


    public String getEditor() {
        return editor;
    }


    public String getTelefono() {
        return telefono;
    }


    public String getProveedor() {
        return proveedor;
    }



    public ArrayList<Ejemplar> getEjemplares() {
        return ejemplares;
    }
}
