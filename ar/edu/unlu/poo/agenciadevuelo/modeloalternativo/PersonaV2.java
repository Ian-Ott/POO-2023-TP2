package ar.edu.unlu.poo.agenciadevuelo.modeloalternativo;

import java.util.ArrayList;

public class PersonaV2 {
    protected String nombre;
    protected String numeroDeTelefono;
    protected String direccion;
    private ArrayList<Rol> rolesPersona = new ArrayList<>();

    public PersonaV2(String nombre, String numeroDeTelefono, String direccion, Rol rolPersona){
        this.nombre = nombre;
        this.numeroDeTelefono = numeroDeTelefono;
        this.direccion = direccion;
        this.rolesPersona.add(rolPersona);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void agregarRolPersona(Rol nuevoRol) {
        this.rolesPersona.add(nuevoRol);
    }

    public ArrayList<Rol> getRolesPersona() {
        return rolesPersona;
    }
}
