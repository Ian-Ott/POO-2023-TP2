package ar.edu.unlu.poo.agenciadeautomoviles;

import java.time.LocalDate;

public class Presupuesto {
    private Vehiculos vehiculoAlquilado;
    private int cant_dias;
    private Double montoFinal;
    private Alquiler alquilerArmado;

    public void setVehiculoAlquilado(Vehiculos vehiculoAlquilado) {
        this.vehiculoAlquilado = vehiculoAlquilado;
    }

    public Vehiculos getVehiculoAlquilado() {
        return vehiculoAlquilado;
    }

    public void setCant_dias(int cant_dias) {
        this.cant_dias = cant_dias;
    }

    public int getCant_dias() {
        return cant_dias;
    }

    public void setMontoFinal(Double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public Double getMontoFinal() {
        return montoFinal;
    }

    public void setAlquilerArmado(Alquiler alquilerArmado) {
        this.alquilerArmado = alquilerArmado;
    }

    public Alquiler getAlquilerArmado() {
        return alquilerArmado;
    }

    public void emitirPresupuesto(Vehiculos vehiculo, int cantDias) {
        Alquiler nuevoAlquiler = new Alquiler();
        setVehiculoAlquilado(vehiculo);
        setCant_dias(cantDias);
        Double monto = vehiculo.calcularCosto();
        setMontoFinal(monto);
        nuevoAlquiler.setFechaInicio(LocalDate.now());
        nuevoAlquiler.setFechaFin(LocalDate.now().plusDays(cantDias));
        nuevoAlquiler.setSaldoAPagar(monto);
    }
}
