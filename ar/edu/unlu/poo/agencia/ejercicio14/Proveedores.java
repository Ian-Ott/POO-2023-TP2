package ar.edu.unlu.poo.agencia.ejercicio14;

import ar.edu.unlu.poo.agencia.Clasificacion;

public class Proveedores {
    private String nombre;
    private Clasificacion clasificacionProveedor;
    private Double importeBase;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setClasificacionProveedor(Clasificacion clasificacionProveedor) {
        this.clasificacionProveedor = clasificacionProveedor;
    }

    public Clasificacion getClasificacionProveedor() {
        return clasificacionProveedor;
    }

    public void setImporteBase(Double importeBase) {
        this.importeBase = importeBase;
    }

    public Double getImporteBase() {
        return importeBase;
    }

    public Double calcularPago(int cant_maxima){
        return null;
    }
}
