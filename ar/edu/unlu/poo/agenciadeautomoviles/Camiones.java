package ar.edu.unlu.poo.agenciadeautomoviles;

public class Camiones extends Vehiculos{
    private Double costoFijo = 100000.0;


    public Double getCostoFijo() {
        return costoFijo;
    }

    @Override
    public Double calcularCosto() {
        super.calcularCosto();
        return null;
    }
}
