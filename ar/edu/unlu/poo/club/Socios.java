package ar.edu.unlu.poo.club;

import java.time.LocalDate;

public class Socios {
    private String nombre;
    private String apellido;
    private String DNI;
    private int edad;
    private String contacto;
    private String direccion;
    private String email;
    private Subscripciones subscripcion;
    private LocalDate fecha_inscripcion;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDNI() {
        return DNI;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getContacto() {
        return contacto;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSubscripcion(Subscripciones subscripcion) {
        this.subscripcion = subscripcion;
    }

    public Subscripciones getSubscripcion() {
        return subscripcion;
    }

    public void setFecha_inscripcion(LocalDate fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public LocalDate getFecha_inscripcion() {
        return fecha_inscripcion;
    }
}
