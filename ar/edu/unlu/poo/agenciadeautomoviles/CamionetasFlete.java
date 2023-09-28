package ar.edu.unlu.poo.agenciadeautomoviles;

public class CamionetasFlete extends Vehiculos{
    private Double PAT;

    public void setPAT(Double PAT) {
        this.PAT = PAT;
    }

    public Double getPAT() {
        return PAT;
    }

    @Override
    public Double calcularCosto(int cantDias) {
        Double monto = 0.0;
        for (int i = 0; i < cantDias; i++){
            monto += getPrecioBase();
        }
        monto += 600.0 * getPAT();
        return monto;
    }
}
