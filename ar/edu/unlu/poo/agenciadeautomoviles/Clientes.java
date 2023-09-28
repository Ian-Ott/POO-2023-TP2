package ar.edu.unlu.poo.agenciadeautomoviles;

import java.util.ArrayList;

public class Clientes {
    private String nombre_apellido;
    private String DNI;
    private String telefono;
    private ArrayList<Alquiler> alquileresCliente = new ArrayList<>();

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

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void sumarAlquilerCliente(Alquiler nuevoAlquiler) {
        this.alquileresCliente.add(nuevoAlquiler);
    }

    public ArrayList<Alquiler> getAlquileresCliente() {
        return alquileresCliente;
    }

    public Alquiler solicitarPresupuesto(){
        return null;
    }
}
