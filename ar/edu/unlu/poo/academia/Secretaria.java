package ar.edu.unlu.poo.academia;

import java.util.ArrayList;

public class Secretaria {
    private ArrayList<CredencialAlumno> credenciales = new ArrayList<>();
    private ArrayList<Disciplinas> listaDisciplinas = new ArrayList<>();
    private ArrayList<Asistencia> asistenciasAlumno = new ArrayList<>();

    public void AgregarAsistenciasAlumno(Asistencia nueva_asistencia) {
        asistenciasAlumno.add(nueva_asistencia);
    }

    public ArrayList<Asistencia> getAsistenciasAlumno() {
        return asistenciasAlumno;
    }

    public void agregarCredenciales(CredencialAlumno nueva_credencial) {
        credenciales.add(nueva_credencial);
    }

    public ArrayList<CredencialAlumno> getCredenciales() {
        return credenciales;
    }

    public void agregarListaDisciplinas(Disciplinas nueva_disciplina) {
        listaDisciplinas.add(nueva_disciplina);
    }

    public ArrayList<Disciplinas> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public CredencialAlumno inscribirse_primera_vez(String nombre_apellido, String dni, String numero, String disciplina, Nivel nivel) {
        ArrayList<Diagramaciones> listaDiagramacionesAux;
        for (int i = 0; i < listaDisciplinas.size();i++) {
            listaDiagramacionesAux = listaDisciplinas.get(i).getComisiones();
            for (int j = 0; j < listaDiagramacionesAux.size(); j++){
                if (listaDisciplinas.get(i).getNombreDisciplina().equals(disciplina) && listaDiagramacionesAux.get(j).getNivelDisciplina().equals(nivel)) {
                    CredencialAlumno nueva_credencial = new CredencialAlumno();
                    nueva_credencial.setNombre_apellido(nombre_apellido);
                    nueva_credencial.setDNI(dni);
                    nueva_credencial.setNumero(numero);
                    credenciales.add(nueva_credencial);
                    Asistencia nuevaCarpeta = new Asistencia();
                    nuevaCarpeta.setAlumno(nueva_credencial);
                    nuevaCarpeta.setDisciplina(disciplina);
                    nuevaCarpeta.setComisionElegida(listaDiagramacionesAux.get(j));
                    asistenciasAlumno.add(nuevaCarpeta);
                    return nueva_credencial;
            }
            }
        }
        return null;
    }

    public CredencialAlumno inscribirse(CredencialAlumno credencial, String disciplina, Nivel nivel) {
        ArrayList<Diagramaciones> listaDiagramacionesAux;
        for (int i = 0; i < listaDisciplinas.size();i++){
            listaDiagramacionesAux = listaDisciplinas.get(i).getComisiones();
            for (int j = 0; j < listaDiagramacionesAux.size(); j++){
            if (listaDisciplinas.get(i).getNombreDisciplina().equals(disciplina) && listaDiagramacionesAux.get(j).getNivelDisciplina().equals(nivel)) {
                Asistencia nuevaCarpeta = new Asistencia();
                nuevaCarpeta.setAlumno(credencial);
                nuevaCarpeta.setDisciplina(disciplina);
                nuevaCarpeta.setComisionElegida(listaDiagramacionesAux.get(j));
                asistenciasAlumno.add(nuevaCarpeta);
            }
            }
        }
        return credencial;
    }

    public void registrar_asistencia(CredencialAlumno credencial, String disciplina, Nivel nivel) {
        for (int i = 0; i < asistenciasAlumno.size(); i++){
            if (asistenciasAlumno.get(i).alumno.getNombre_apellido().equals(credencial.getNombre_apellido())){
                if (asistenciasAlumno.get(i).disciplina.equals(disciplina)){
                    if (asistenciasAlumno.get(i).getComisionElegida().getNivelDisciplina().equals(nivel)){
                        asistenciasAlumno.get(i).sumarAsistencia();
                    }
                }
            }
        }
    }
}
