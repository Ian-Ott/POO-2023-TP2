package ar.edu.unlu.poo.agenciadevuelo.modelooriginal;

public class Ticket {
    private Vuelo vuelo;
    private Pasajero pasajero;

    public Ticket(Vuelo vuelo, Pasajero pasajero){
        this.vuelo = vuelo;
        this.pasajero = pasajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }
}
