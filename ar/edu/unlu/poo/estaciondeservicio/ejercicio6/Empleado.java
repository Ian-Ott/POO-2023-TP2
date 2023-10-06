package ar.edu.unlu.poo.estaciondeservicio.ejercicio6;

import ar.edu.unlu.poo.estaciondeservicio.ejercicio6.Venta;

import java.util.ArrayList;

public class Empleado {
    private String apellido;
    private String nombre;
    private String direccion;
    private String DNI;
    private String telefono;
    //private ArrayList<Venta> ventasEmpleado = new ArrayList<>();
    //posiblemente eliminar esto
    private double totalVentasEmpleado = 0F;

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

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
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


    public void setTotalVentasEmpleado(double totalVentasEmpleado) {
        this.totalVentasEmpleado = totalVentasEmpleado;
    }

    public double getTotalVentasEmpleado() {
        return totalVentasEmpleado;
    }
}
