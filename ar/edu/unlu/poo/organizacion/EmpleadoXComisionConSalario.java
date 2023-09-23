package ar.edu.unlu.poo.organizacion;

public class EmpleadoXComisionConSalario extends EmpleadoXComision{
    private Double montoFijo;

    public void setMontoFijo(Double montoFijo) {
        this.montoFijo = montoFijo;
    }

    public Double getMontoFijo() {
        return montoFijo;
    }

    @Override
    public Double CalcularSueldo() {
        Double sueldo = getMontoFijo();
        sueldo += super.CalcularSueldo();
        if (es_cumpleanios()){
            sueldo += 1000.0;
        }
        return sueldo;
    }
}
