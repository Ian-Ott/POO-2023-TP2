package ar.edu.unlu.poo.academia;

public class Diagramaciones {
    private Nivel nivelDisciplina;
    private String diasClase;
    private String horarios;
    private String profesor;
    private int comision;
    private double ingresos = 0;

    public void setNivelDisciplina(Nivel nivelDisciplina) {
        this.nivelDisciplina = nivelDisciplina;
    }

    public Nivel getNivelDisciplina() {
        return nivelDisciplina;
    }

    public void setDiasClase(String diasClase) {
        this.diasClase = diasClase;
    }

    public String getDiasClase() {
        return diasClase;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public int getComision() {
        return comision;
    }

    public void sumarIngresos(double ingresos) {
        this.ingresos += ingresos;
    }

    public double getIngresos() {
        return ingresos;
    }

}
