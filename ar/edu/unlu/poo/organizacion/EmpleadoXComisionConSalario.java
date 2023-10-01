package ar.edu.unlu.poo.organizacion;

public class EmpleadoXComisionConSalario extends EmpleadoXComision{
    private double montoFijo;

    public void setMontoFijo(double montoFijo) {
        this.montoFijo = montoFijo;
    }

    public double getMontoFijo() {
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
