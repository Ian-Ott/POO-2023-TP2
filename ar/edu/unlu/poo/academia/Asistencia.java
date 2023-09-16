package ar.edu.unlu.poo.academia;

public class Asistencia {
    //La asistencia contiene la informacion sobre las asistencias del alumno en la comision de su displina
    String disciplina;
    Diagramaciones comisionElegida;
    int cant_asistencias = 0;
    CredencialAlumno alumno;

    public void setAlumno(CredencialAlumno alumno) {
        this.alumno = alumno;
    }

    public CredencialAlumno getAlumno() {
        return alumno;
    }

    public void sumarAsistencia() {
        this.cant_asistencias = this.cant_asistencias + 1;
    }

    public int getCant_asistencias() {
        return cant_asistencias;
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
