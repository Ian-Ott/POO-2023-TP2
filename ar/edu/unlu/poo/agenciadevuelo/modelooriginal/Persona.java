package ar.edu.unlu.poo.agenciadevuelo.modelooriginal;

public class Persona {
    protected String nombre;
    protected String numeroDeTelefono;
    protected String direccion;
    protected boolean es_pasajero = false;
    protected boolean es_tripulante = false;

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }
}
