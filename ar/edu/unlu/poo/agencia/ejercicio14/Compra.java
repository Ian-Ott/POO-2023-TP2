package ar.edu.unlu.poo.agencia.ejercicio14;

import java.time.LocalDate;

public class Compra {
    private String nombre_paquete;
    private Double precioFinal;
    private LocalDate FechaCompra;

    public void setNombre_paquete(String nombre_paquete) {
        this.nombre_paquete = nombre_paquete;
    }

    public String getNombre_paquete() {
        return nombre_paquete;
    }

    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public Double getPrecioFinal() {
        return precioFinal;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        FechaCompra = fechaCompra;
    }

    public LocalDate getFechaCompra() {
        return FechaCompra;
    }
}
