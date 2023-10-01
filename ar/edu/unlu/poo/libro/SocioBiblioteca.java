package ar.edu.unlu.poo.libro;

public class SocioBiblioteca {
    private String nombre_apellido;
    private String DNI;
    private boolean tiene_ejemplar;
    private Ejemplar ejemplarEnPosesion;

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDNI() {
        return DNI;
    }

    public void setTiene_ejemplar(boolean tiene_ejemplar) {
        this.tiene_ejemplar = tiene_ejemplar;
    }
    public boolean getTiene_ejemplar(){
        return tiene_ejemplar;
    }

    public void setEjemplarEnPosesion(Ejemplar ejemplarEnPosesion) {
        this.ejemplarEnPosesion = ejemplarEnPosesion;
    }

    public Ejemplar getEjemplarEnPosesion() {
        return ejemplarEnPosesion;
    }

    public Ejemplar devolver_ejemplar(){
        Ejemplar ejemplarAux = getEjemplarEnPosesion();
        setEjemplarEnPosesion(null);
        setTiene_ejemplar(false);
        return ejemplarAux;
    }
}
