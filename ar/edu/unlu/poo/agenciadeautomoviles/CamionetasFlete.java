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
    public Double calcularCosto() {
        super.calcularCosto();
        return null;
    }
}
