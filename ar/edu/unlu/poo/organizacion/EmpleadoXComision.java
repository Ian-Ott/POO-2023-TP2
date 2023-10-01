package ar.edu.unlu.poo.organizacion;

public class EmpleadoXComision extends Empleado {
    private double montoXVenta;
    private Double cant_ventas;
    private double porcentajeFijo;

    private double montoTotalVentas;

    public void setMontoXVenta(double montoXVenta) {
        this.montoXVenta = montoXVenta;
    }

    public double getMontoXVenta() {
        return montoXVenta;
    }

    public void setCant_ventas(Double cant_ventas) {
        this.cant_ventas = cant_ventas;
    }

    public Double getCant_ventas() {
        return cant_ventas;
    }

    public void setPorcentajeFijo(double porcentajeFijo) {
        this.porcentajeFijo = porcentajeFijo;
    }

    public double getPorcentajeFijo() {
        return porcentajeFijo;
    }

    public void setMontoTotalVentas(double montoTotalVentas) {
        this.montoTotalVentas = montoTotalVentas;
    }

    public double getMontoTotalVentas() {
        return montoTotalVentas;
    }

    @Override
    public Double CalcularSueldo() {
        Double sueldo = 0.0;
        if (es_cumpleanios()){
            sueldo += cumpleanios();
            sueldo += calcularmontoTotalVentas();
            sueldo += sueldo + 0.5;
        }else {
            sueldo += calcularmontoTotalVentas();
            sueldo += sueldo * getPorcentajeFijo();
        }
        return sueldo;
    }

    private Double calcularmontoTotalVentas() {
        Double sueldo = 0.0;
        sueldo += getMontoXVenta() * getCant_ventas();
        return sueldo;
    }
}
