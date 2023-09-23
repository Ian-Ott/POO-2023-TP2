package ar.edu.unlu.poo.organizacion;

import java.time.LocalDate;

public class Empleado {
    private String nombre_apellido;
    private String telefono;
    private String CUIT;
    private LocalDate fechaCumpleanios;

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setFechaCumpleanios(LocalDate fechaCumpleanios) {
        this.fechaCumpleanios = fechaCumpleanios;
    }

    public LocalDate getFechaCumpleanios() {
        return fechaCumpleanios;
    }

    public Double CalcularSueldo(){

        return null;
    }

    public boolean es_cumpleanios(){
        boolean cumpleanios = false;
        if (getFechaCumpleanios().isEqual(LocalDate.now())){
            cumpleanios = true;
        }
        return cumpleanios;
    }
    public double cumpleanios(){
        Double suma_total = 0.0;
        if (getFechaCumpleanios().isEqual(LocalDate.now())){
            suma_total = 2000.0;
        }
        return suma_total;
    }
}
