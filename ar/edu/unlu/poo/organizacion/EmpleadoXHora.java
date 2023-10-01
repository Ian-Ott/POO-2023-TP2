package ar.edu.unlu.poo.organizacion;

import java.time.LocalDate;
import java.time.Month;

public class EmpleadoXHora extends Empleado{
    //private double sumaXhoraTotal;
    private int cantHoras;
    private double sumaEstipulada;
    private Month informacionMes;
    //capaz eliminar

    /*public void setSumaXhoraTotal(double sumaXhoraTotal) {
        this.sumaXhoraTotal = sumaXhoraTotal;
    }

    public double getSumaXhoraTotal() {
        return sumaXhoraTotal;
    }*/

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }

    public int getCantHoras() {
        return cantHoras;
    }

    public void setSumaEstipulada(double sumaEstipulada) {
        this.sumaEstipulada = sumaEstipulada;
    }

    public double getSumaEstipulada() {
        return sumaEstipulada;
    }

    public void setInformacionMes(Month informacionMes) {
        this.informacionMes = informacionMes;
    }

    public Month getInformacionMes() {
        return informacionMes;
    }

    @Override
    public Double CalcularSueldo() {
        Double sueldo = 0.0;
        if (es_cumpleanios()){
            sueldo += cumpleanios();
        }
        sueldo += getCantHoras() * getSumaEstipulada();
        if (getInformacionMes().equals(LocalDate.now().getMonth())){
            if (getCantHoras() > 40){
                sueldo += sueldo * 0.20;
            }
        }
        return sueldo;
    }

}
