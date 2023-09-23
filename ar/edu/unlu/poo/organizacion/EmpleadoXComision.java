package ar.edu.unlu.poo.organizacion;

public class EmpleadoXComision extends Empleado {
    private Float montoXVenta;
    private Double cant_ventas;
    private Float porcentajeFijo;

    private Float montoTotalVentas;

    public void setMontoXVenta(Float montoXVenta) {
        this.montoXVenta = montoXVenta;
    }

    public Float getMontoXVenta() {
        return montoXVenta;
    }

    public void setCant_ventas(Double cant_ventas) {
        this.cant_ventas = cant_ventas;
    }

    public Double getCant_ventas() {
        return cant_ventas;
    }

    public void setPorcentajeFijo(Float porcentajeFijo) {
        this.porcentajeFijo = porcentajeFijo;
    }

    public Float getPorcentajeFijo() {
        return porcentajeFijo;
    }

    public void setMontoTotalVentas(Float montoTotalVentas) {
        this.montoTotalVentas = montoTotalVentas;
    }

    public Float getMontoTotalVentas() {
        return montoTotalVentas;
    }

    @Override
    public Double CalcularSueldo() {
        Double sueldo = 0.0;
        if (es_cumpleanios()){
            sueldo += cumpleanios();
            sueldo += calcularmontoTotalVentas() * 0.5;
        }else {
            sueldo += calcularmontoTotalVentas() * getPorcentajeFijo();
        }
        return sueldo;
    }

    private Double calcularmontoTotalVentas() {
        Double sueldo = 0.0;
        sueldo += getMontoXVenta() * getCant_ventas();
        return sueldo;
    }
}
