package ar.edu.unlu.poo.academia;

import java.util.ArrayList;

public class Disciplinas {
    private String NombreDisciplina;

    ArrayList<Diagramaciones> comisiones = new ArrayList<>();
    private double ingresosTotalesDisciplina = 0;

    public void setNombreDisciplina(String nombreDisciplina) {
        NombreDisciplina = nombreDisciplina;
    }

    public String getNombreDisciplina() {
        return NombreDisciplina;
    }


    public void sumarIngresosTotalesDisciplina(double ingresos) {
        this.ingresosTotalesDisciplina += ingresos;
    }

    public double getIngresosTotalesDisciplina() {
        return ingresosTotalesDisciplina;
    }

    public void agregarComisiones(Diagramaciones nueva_diagramacion) {
        this.comisiones.add(nueva_diagramacion);
    }

    public ArrayList<Diagramaciones> getComisiones() {
        return comisiones;
    }
}
