package ar.edu.unlu.poo.agenciadeautomoviles;

public class AutoDePasajero extends Vehiculos{
    private int asientos;

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public int getAsientos() {
        return asientos;
    }

    @Override
    public Double calcularCosto(int cantDias) {
        Double monto = 0.0;
        for (int j = 0; j < cantDias; j++){
            monto += 3000.0;
            for (int i = 0; i < getAsientos(); i++){
                monto += 300.0;
            }
        }
        return monto;
    }
}
