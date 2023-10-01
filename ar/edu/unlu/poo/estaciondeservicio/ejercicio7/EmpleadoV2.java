package ar.edu.unlu.poo.estaciondeservicio.ejercicio7;

import ar.edu.unlu.poo.estaciondeservicio.ejercicio6.Venta;

import java.util.ArrayList;

public class EmpleadoV2 {
    private String apellido;
    private String nombre;
    private String direccion;
    private String DNI;
    private String telefono;
    private ArrayList<VentaV2> ventasEmpleado = new ArrayList<>();
    //posiblemente eliminar esto
    private double totalVentasEmpleado = 0F;
    boolean puedeDarDescuentos = false;

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

    public void agregarNuevaVenta(VentaV2 nueva_venta) {
        ventasEmpleado.add(nueva_venta);
    }

    public ArrayList<VentaV2> getVentasEmpleado() {
        return ventasEmpleado;
    }

    public void setTotalVentasEmpleado(double totalVentasEmpleado) {
        this.totalVentasEmpleado = totalVentasEmpleado;
    }

    public double getTotalVentasEmpleado() {
        return totalVentasEmpleado;
    }

    public void setPuedeDarDescuentos(boolean puedeDarDescuentos) {
        this.puedeDarDescuentos = puedeDarDescuentos;
    }

    public boolean getPuedeDarDescuentos(){return puedeDarDescuentos;}
}
