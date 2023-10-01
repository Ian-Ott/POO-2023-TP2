package ar.edu.unlu.poo.libro;

import java.time.LocalDate;

public class Diarios extends Publicaciones{
    private LocalDate fechaPublicacion;

    public Diarios(String titulo, String editor, String telefono, String proveedor, int cantEjemplares, LocalDate fechaPublicacion) {
        this.nombre = titulo;
        this.editor = editor;
        this.telefono = telefono;
        this.proveedor = proveedor;
        for (int i = 0;i < cantEjemplares; i++){
            Ejemplar nuevo_ejemplar = new Ejemplar();
            nuevo_ejemplar.setNro(i + 1);
            this.ejemplares.add(nuevo_ejemplar);
        }
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }
}
