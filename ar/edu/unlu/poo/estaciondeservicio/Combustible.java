package ar.edu.unlu.poo.estaciondeservicio;

public class Combustible {
    private String nombre;
    private double precioVenta;
    private double totalVentasXcombustible = 0F;
    private double totalLitros = 0F;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }



    public void sumarTotalVentasXcombustible(double ventaCombustible) {
        this.totalVentasXcombustible += ventaCombustible;
    }

    public double getTotalVentasXcombustible() {
        return totalVentasXcombustible;
    }

    public void setTotalLitros(double totalLitros) {
        this.totalLitros = totalLitros;
    }

    public double getTotalLitros() {
        return totalLitros;
    }
}
