package ar.edu.unlu.poo.libro;

import java.time.Year;
import java.util.ArrayList;

public class NuevaBiblioteca {
    private ArrayList<SocioBiblioteca> socios = new ArrayList<>();
    private ArrayList<Publicaciones> publicaciones= new ArrayList<>();


    public void agregar_libro(String titulo, ArrayList<String> autores, String editor, String telefono, String proveedor, int cant_ejemplares, String ISBN, Year anio, int cant_paginas){
        Publicaciones nuevaPublicacion = new Publicaciones();
        nuevaPublicacion.agregar_libro(titulo, autores, cant_paginas,editor, telefono, proveedor, cant_ejemplares, ISBN, anio);
    }

    public void agregar_revista(){

    }

    public void agregar_diario(){

    }

    public void agregarTesis(){

    }

    public void prestar_ejemplar(String titulo, String editor, SocioBiblioteca socio, int nroEjemplar){
        Publicaciones publicacionesAux;
        for (int i = 0; i < publicaciones.size();i++){
            publicacionesAux = publicaciones.get(i);
            if (publicacionesAux.getNombre().equals(titulo) && publicacionesAux.getEditor().equals(editor)){
                for (int j = 0; j < publicacionesAux.getEjemplares().size();j++){
                    if (publicacionesAux.getEjemplares().get(j).getNro() == nroEjemplar){
                        publicacionesAux.getEjemplares().get(j).setPrestado(true);
                        socio.setTiene_ejemplar(true);
                        socio.setEjemplarEnPosesion(publicacionesAux.getEjemplares().get(j));
                    }
                }
            }
        }
    }
    public void mostrar_ejemplaresPrestados(){
        Publicaciones publicacionAux;
        System.out.println("Ejemplares en prestamo: ");
        for (int i = 0; i < publicaciones.size(); i++){
            publicacionAux = publicaciones.get(i);
            for (int j = 0; j < socios.size(); j++){
                if (socios.get(j).getTiene_ejemplar() && publicacionAux.getEjemplares().contains(socios.get(j).getEjemplarEnPosesion())){
                    System.out.println("Nombre: " + publicacionAux.getNombre() + "Editor: " + publicacionAux.getEditor()
                            + "Nro de ejemplar: " + socios.get(j).getEjemplarEnPosesion().getNro() + "Prestado a: " + socios.get(j).getNombre_apellido());
                }
            }
        }
    }

    public void mostrar_cant_ejemplares(){
        System.out.println("Cantidad de ejemplares prestados por cada publicacion:");
        Publicaciones publicacionAux;
        int cant_prestados;
        for (int i = 0; i < publicaciones.size(); i++){
            publicacionAux = publicaciones.get(i);
            cant_prestados = 0;
            for (int j = 0; j < publicacionAux.getEjemplares().size(); j++){
                if (publicacionAux.getEjemplares().get(j).getPrestado()){
                    cant_prestados++;
                }
            }
            System.out.println("Nombre: " + publicacionAux.getNombre() + "Editor: " + publicacionAux.getEditor() + "Cantidad prestados: " + cant_prestados);
        }
    }
}
