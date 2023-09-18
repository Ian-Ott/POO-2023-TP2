package ar.edu.unlu.poo.estaciondeservicio;

public class Cliente {
    private String nombre_apellido;
    private String DNI;
    private String patente;
    private Float totalGastado;

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDNI() {
        return DNI;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }

    public void setTotalGastado(Float totalGastado) {
        this.totalGastado = totalGastado;
    }

    public Float getTotalGastado() {
        return totalGastado;
    }
}
