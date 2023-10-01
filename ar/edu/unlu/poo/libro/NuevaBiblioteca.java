package ar.edu.unlu.poo.libro;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;

public class NuevaBiblioteca {
    private ArrayList<SocioBiblioteca> socios = new ArrayList<>();
    private ArrayList<Publicaciones> publicaciones= new ArrayList<>();


    public void agregar_libro(String titulo, ArrayList<String> autores, String editor, String telefono, String proveedor, int cant_ejemplares, String ISBN, String anio, int cant_paginas){
        LibroTP2 nuevoLibro = new LibroTP2(titulo, autores, cant_paginas,editor, telefono, proveedor, cant_ejemplares, ISBN, Year.of(Integer.parseInt(anio)));
        publicaciones.add(nuevoLibro);
    }

    public void agregar_revista(String titulo, String editor, String telefono, String proveedor, int cant_ejemplares, String ISSN, int numeroRevista, String anioPublicacion){
        Revista nuevaRevista = new Revista(titulo, editor,telefono,proveedor,cant_ejemplares,ISSN,numeroRevista,Year.of(Integer.parseInt(anioPublicacion)));
        publicaciones.add(nuevaRevista);
    }

    public void agregar_diario(String titulo, String editor, String telefono, String proveedor, int cant_ejemplares, LocalDate fechaPublicacion){
        Diarios nuevoDiario = new Diarios(titulo,editor, telefono,proveedor,cant_ejemplares,fechaPublicacion);
        publicaciones.add(nuevoDiario);
    }

    public void agregarTesis(String titulo,String editor, String telefono, String proveedor, int cant_ejemplares, String autor, LocalDate fechaPublicacion){
        Tesis nuevaTesis = new Tesis(titulo, editor, telefono, proveedor, cant_ejemplares, autor, fechaPublicacion.getMonth(), Year.of(fechaPublicacion.getYear()));
        publicaciones.add(nuevaTesis);
    }

    public void prestar_ejemplar(String titulo, String editor, SocioBiblioteca socio, int nroEjemplar){
        if (socio.getTiene_ejemplar()){
            System.out.println("El socio ya tiene un ejemplar en su posesion y debe devolverlo primero!!!!");
        } else if (calcularCant_ejemplaresRestantes(titulo, editor ) == 1) {
            System.out.println("No se puede prestar el libro porque solo queda un ejemplar disponible!!!");
        }else {
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
    }

    public void devolverEjemplar(SocioBiblioteca socio){
        Ejemplar ejemplarDevuelto = socio.devolver_ejemplar();
        Publicaciones publicacionesAux;
        for (int i = 0; i < publicaciones.size();i++){
            publicacionesAux = publicaciones.get(i);
            for (int j = 0; j < publicacionesAux.getEjemplares().size();j++){
                if (publicacionesAux.getEjemplares().get(j).equals(ejemplarDevuelto)){
                    publicacionesAux.getEjemplares().get(j).setPrestado(false);
                }
            }
        }

    }

    private int calcularCant_ejemplaresRestantes(String titulo, String editor) {
        int cant_Restantes = 0;
        for (int i = 0; i < publicaciones.size(); i++){
            Publicaciones publicacionAux = publicaciones.get(i);
            if (titulo.equals(publicacionAux.getNombre()) && editor.equals(publicacionAux.getEditor())){
                for (int j = 0; j < publicacionAux.getEjemplares().size(); j++){
                    if (!publicacionAux.getEjemplares().get(j).getPrestado()){
                        cant_Restantes++;
                    }
                }
            }
        }
        return cant_Restantes;
    }

    private int calcularCant_ejemplaresPrestados(String titulo, String editor){
        int cant_prestados = 0;
        for (int i = 0; i < publicaciones.size(); i++){
            Publicaciones publicacionAux = publicaciones.get(i);
            if (titulo.equals(publicacionAux.getNombre()) && editor.equals(publicacionAux.getEditor())){
                for (int j = 0; j < publicacionAux.getEjemplares().size(); j++){
                    if (publicacionAux.getEjemplares().get(j).getPrestado()){
                            cant_prestados++;
                    }
                }
            }
        }
        return cant_prestados;
    }

    public SocioBiblioteca agregarSocioBiblioteca(String nombre_apellido, String dni){
        SocioBiblioteca nuevo_socio = new SocioBiblioteca();
        nuevo_socio.setNombre_apellido(nombre_apellido);
        nuevo_socio.setDNI(dni);
        nuevo_socio.setTiene_ejemplar(false);
        nuevo_socio.setEjemplarEnPosesion(null);
        socios.add(nuevo_socio);
        return nuevo_socio;
    }
    public void mostrar_ejemplaresPrestados(){
        Publicaciones publicacionAux;
        System.out.println("Ejemplares en prestamo: ");
        for (int i = 0; i < publicaciones.size(); i++){
            publicacionAux = publicaciones.get(i);
            for (int j = 0; j < socios.size(); j++){
                if (socios.get(j).getTiene_ejemplar() && publicacionAux.getEjemplares().contains(socios.get(j).getEjemplarEnPosesion())){
                    System.out.println("Nombre: " + publicacionAux.getNombre() + " | Editor: " + publicacionAux.getEditor()
                            + " | Nro de ejemplar: " + socios.get(j).getEjemplarEnPosesion().getNro() + " | Prestado a: " + socios.get(j).getNombre_apellido());
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
            cant_prestados = calcularCant_ejemplaresPrestados(publicacionAux.getNombre(), publicacionAux.getEditor());
            System.out.println("Nombre: " + publicacionAux.getNombre() + " | Editor: " + publicacionAux.getEditor() + " | Cantidad prestados: " + cant_prestados);
        }
    }
}
