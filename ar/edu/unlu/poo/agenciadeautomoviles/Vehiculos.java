package ar.edu.unlu.poo.agenciadeautomoviles;

public class Vehiculos {
    private Double precioBase = 3000.0;

    private String patente;


    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }

    public Double calcularCosto(int cantDias){
        return null;
    }
}
