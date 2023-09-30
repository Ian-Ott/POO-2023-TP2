package ar.edu.unlu.poo.estaciondeservicio;

import java.time.LocalDateTime;

public class Venta {
    private LocalDateTime FechaHora;
    private double ImporteTotal;
    private double LitrosExpendidos;
    //podria sacar el de litros
    private Cliente Comprador;
    private Empleado playeroAfectado;
    private Expendedor expendedorUsado;

    public void setFechaHora(LocalDateTime fechaHora) {
        FechaHora = fechaHora;
    }

    public LocalDateTime getFechaHora() {
        return FechaHora;
    }

    public void setImporteTotal(double importeTotal) {
        ImporteTotal = importeTotal;
    }

    public double getImporteTotal() {
        return ImporteTotal;
    }

    public void setLitrosExpendidos(double litrosExpendidos) {
        LitrosExpendidos = litrosExpendidos;
    }

    public double getLitrosExpendidos() {
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
