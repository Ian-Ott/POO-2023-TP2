package ar.edu.unlu.poo.estaciondeservicio;

public class Combustible {
    private String nombre;
    private Float precioVenta;
    private Float totalVentasXcombustible = 0F;
    private Float totalLitros = 0F;

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



    public void sumarTotalVentasXcombustible(Float ventaCombustible) {
        this.totalVentasXcombustible += ventaCombustible;
    }

    public Float getTotalVentasXcombustible() {
        return totalVentasXcombustible;
    }

    public void setTotalLitros(Float totalLitros) {
        this.totalLitros = totalLitros;
    }

    public Float getTotalLitros() {
        return totalLitros;
    }
}
