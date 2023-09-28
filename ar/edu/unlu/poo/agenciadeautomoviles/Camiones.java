package ar.edu.unlu.poo.agenciadeautomoviles;

public class Camiones extends Vehiculos{
    private Double costoFijo = 100000.0;


    public Double getCostoFijo() {
        return costoFijo;
    }

    @Override
    public Double calcularCosto(int cantDias) {
        Double monto = getCostoFijo();
        if (cantDias > 30){
            monto = 0.0;
            for (int i = 0; i < cantDias; i++){
                monto += 75000.0;
            }
        }
        return monto;
    }
}
