package ar.edu.unlu.poo.agenciadeautomoviles;

import java.time.LocalDate;

public class Alquiler {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double saldoAPagar;

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setSaldoAPagar(Double saldoAPagar) {
        this.saldoAPagar = saldoAPagar;
    }

    public Double getSaldoAPagar() {
        return saldoAPagar;
    }


}
