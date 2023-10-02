package ar.edu.unlu.poo.agenciadevuelo.modelooriginal;

import ar.edu.unlu.poo.agenciadevuelo.modeloalternativo.VueloV2;

public class Pasajero extends Persona{
    private int numeroPasajero;


    public Pasajero(String nombre, String telefono, String direccion, int numeroPasajero){
        this.nombre = nombre;
        this.numeroDeTelefono = telefono;
        this.direccion = direccion;
        this.numeroPasajero = numeroPasajero;
        this.es_pasajero = true;
    }
    public int getNumeroPasajero() {
        return numeroPasajero;
    }
}
