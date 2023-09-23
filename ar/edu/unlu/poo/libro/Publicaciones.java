package ar.edu.unlu.poo.libro;

import java.time.Year;
import java.util.ArrayList;

public class Publicaciones extends BibliotecaTP1{
    //hago que extienda a la biblioteca anterior asi puede cambiar el agregar nuevos libros
    //  y asi tambien tiene acceso a ellos
    private String nombre;
    private String editor;
    private String telefono;
    private String proveedor;
    private ArrayList<Ejemplar> ejemplares = new ArrayList<>();

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getEditor() {
        return editor;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void agregarEjemplares(Ejemplar nuevoEjemplar) {
        ejemplares.add(nuevoEjemplar);
    }

    public ArrayList<Ejemplar> getEjemplares() {
        return ejemplares;
    }


    public void agregar_libro(String titulo, ArrayList<String> autor, int cant_paginas, String editor, String telefono, String proveedor, int cant_ejemplares, String ISBN, Year anio ) {

    }

    public void agregar_revista(){

    }

    public void agregar_diario(){

    }

    public void agregarTesis(){

    }


}
