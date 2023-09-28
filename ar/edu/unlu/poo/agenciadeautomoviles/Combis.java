package ar.edu.unlu.poo.agenciadeautomoviles;

public class Combis extends Vehiculos{
    private Double precioBase = 4500.0;

    public Double getPrecioBase() {
        return precioBase;
    }

    @Override
    public Double calcularCosto() {
        super.calcularCosto();
        return null;
    }
}
