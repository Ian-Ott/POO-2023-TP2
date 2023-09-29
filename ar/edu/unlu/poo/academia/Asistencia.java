package ar.edu.unlu.poo.academia;

import java.time.LocalDate;
import java.util.ArrayList;

public class Asistencia {
    //La asistencia contiene la informacion sobre las asistencias del alumno en la comision de su displina
    private String disciplina;
    private Diagramaciones comisionElegida;
    private ArrayList<LocalDate> fechasAsistidas = new ArrayList<>();
    private CredencialAlumno alumno;

    public void setAlumno(CredencialAlumno alumno) {
        this.alumno = alumno;
    }

    public CredencialAlumno getAlumno() {
        return alumno;
    }

    public void agregarFechasAsistida(LocalDate fechasAsistida) {
        this.fechasAsistidas.add(fechasAsistida);
    }

    public ArrayList<LocalDate> getFechasAsistidas() {
        return fechasAsistidas;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setComisionElegida(Diagramaciones comisionElegida) {
        this.comisionElegida = comisionElegida;
    }

    public Diagramaciones getComisionElegida() {
        return comisionElegida;
    }
}
