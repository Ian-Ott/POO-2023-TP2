package ar.edu.unlu.poo.agenciadeautomoviles;

public class Combis extends Vehiculos{
    private Double precioBase = 4500.0;

    public Double getPrecioBase() {
        return precioBase;
    }

    @Override
    public Double calcularCosto(int cantDias) {
        Double monto = 0.0;
        for (int i = 0; i < cantDias; i++){
            monto += getPrecioBase();
        }
        return monto;
    }
}
