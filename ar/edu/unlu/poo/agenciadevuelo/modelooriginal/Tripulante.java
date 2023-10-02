package ar.edu.unlu.poo.agenciadevuelo.modelooriginal;

import java.util.ArrayList;

public class Tripulante extends Persona {
    private String cargo;
    private ArrayList<ReciboSueldo> reciboSueldos;

    public Tripulante(String nombre, String telefono, String direccion,String cargo){
        this.nombre = nombre;
        this.numeroDeTelefono = telefono;
        this.direccion = direccion;
        this.cargo = cargo;
        this.es_tripulante = true;
        this.reciboSueldos = new ArrayList<>();
    }

    public String getCargo() {
        return cargo;
    }

    public void sumarReciboSueldo(ReciboSueldo reciboSueldo) {
        this.reciboSueldos.add(reciboSueldo);
    }
}

