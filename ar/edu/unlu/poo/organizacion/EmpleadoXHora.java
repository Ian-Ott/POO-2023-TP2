package ar.edu.unlu.poo.organizacion;

import java.time.LocalDate;
import java.time.Month;

public class EmpleadoXHora extends Empleado{
    private Float sumaXhoraTotal; //eliminar
    private int cantHoras;
    private Float sumaEstipulada;
    private Month informacionMes;
    //capaz eliminar

    public void setSumaXhoraTotal(Float sumaXhoraTotal) {
        this.sumaXhoraTotal = sumaXhoraTotal;
    }

    public Float getSumaXhoraTotal() {
        return sumaXhoraTotal;
    }

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }

    public int getCantHoras() {
        return cantHoras;
    }

    public void setSumaEstipulada(Float sumaEstipulada) {
        this.sumaEstipulada = sumaEstipulada;
    }

    public Float getSumaEstipulada() {
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
            sueldo += sueldo * 0.20;
        }
        return sueldo;
    }

}
