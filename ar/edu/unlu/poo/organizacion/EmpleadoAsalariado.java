package ar.edu.unlu.poo.organizacion;

public class EmpleadoAsalariado extends Empleado{
    private double sumaFijaMensual;

    public void setSumaFijaMensual(double sumaFijaMensual) {
        this.sumaFijaMensual = sumaFijaMensual;
    }
    public double getSumaFijaMensual() {
        return sumaFijaMensual;
    }

    @Override
    public Double CalcularSueldo() {
        Double sueldo = 0.0;
        if (es_cumpleanios()){
            sueldo += cumpleanios();
            sueldo += 1000.0;
        }
        sueldo += getSumaFijaMensual();
        return sueldo;
    }
}
