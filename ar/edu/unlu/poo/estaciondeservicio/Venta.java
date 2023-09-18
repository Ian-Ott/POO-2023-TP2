package ar.edu.unlu.poo.estaciondeservicio;

import java.time.LocalDateTime;

public class Venta {
    private LocalDateTime FechaHora;
    private Float ImporteTotal;
    private Float LitrosExpendidos;
    private Cliente Comprador;
    private Empleado playeroAfectado;
    private Expendedor expendedorUsado;

    public void setFechaHora(LocalDateTime fechaHora) {
        FechaHora = fechaHora;
    }

    public LocalDateTime getFechaHora() {
        return FechaHora;
    }

    public void setImporteTotal(Float importeTotal) {
        ImporteTotal = importeTotal;
    }

    public Float getImporteTotal() {
        return ImporteTotal;
    }

    public void setLitrosExpendidos(Float litrosExpendidos) {
        LitrosExpendidos = litrosExpendidos;
    }

    public Float getLitrosExpendidos() {
        return LitrosExpendidos;
    }

    public void setComprador(Cliente comprador) {
        Comprador = comprador;
    }

    public Cliente getComprador() {
        return Comprador;
    }

    public void setPlayeroAfectado(Empleado playeroAfectado) {
        this.playeroAfectado = playeroAfectado;
    }

    public Empleado getPlayeroAfectado() {
        return playeroAfectado;
    }

    public void setExpendedorUsado(Expendedor expendedorUsado) {
        this.expendedorUsado = expendedorUsado;
    }

    public Expendedor getExpendedorUsado() {
        return expendedorUsado;
    }
}
