package ar.edu.unlu.poo.agenciadeautomoviles;

public class AutosVIP extends AutoDePasajero{
    @Override
    public Double calcularCosto(int cantDias) {
        Double monto = 0.0;
        for (int i = 0 ; i < cantDias; i++){
            monto += getPrecioBase();
            monto += 500.0;
        }
        return monto;
    }
}
