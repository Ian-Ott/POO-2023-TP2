package ar.edu.unlu.poo.estaciondeservicio;

public class Combustible {
    private String nombre;
    private Float precioVenta;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPrecioVenta(Float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Float getPrecioVenta() {
        return precioVenta;
    }
}
