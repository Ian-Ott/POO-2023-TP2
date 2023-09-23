package ar.edu.unlu.poo.libro;

import java.time.LocalDate;

public class Diarios extends Publicaciones{
    private LocalDate fechaPublicacion;

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }
}
