package ar.edu.unlu.poo.estaciondeservicio.ejercicio7;

import ar.edu.unlu.poo.estaciondeservicio.ejercicio6.Cliente;
import ar.edu.unlu.poo.estaciondeservicio.ejercicio6.Expendedor;

import java.time.LocalDateTime;

public class VentaV2 {
    private LocalDateTime FechaHora;
    private double ImporteTotal;
    private double LitrosExpendidos;
    //podria sacar el de litros
    private Cliente Comprador;
    private EmpleadoV2 playeroAfectado;
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

    public void setPlayeroAfectado(EmpleadoV2 playeroAfectado) {
        this.playeroAfectado = playeroAfectado;
    }

    public EmpleadoV2 getPlayeroAfectado() {
        return playeroAfectado;
    }

    public void setExpendedorUsado(Expendedor expendedorUsado) {
        this.expendedorUsado = expendedorUsado;
    }

    public Expendedor getExpendedorUsado() {
        return expendedorUsado;
    }

}
