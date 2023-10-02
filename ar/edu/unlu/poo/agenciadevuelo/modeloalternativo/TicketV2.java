package ar.edu.unlu.poo.agenciadevuelo.modeloalternativo;

import ar.edu.unlu.poo.agenciadevuelo.modelooriginal.Pasajero;
import ar.edu.unlu.poo.agenciadevuelo.modelooriginal.Vuelo;

public class TicketV2 {
    private VueloV2 vuelo;
    private PasajeroV2 pasajero;

    public TicketV2(VueloV2 vuelo, PasajeroV2 pasajero){
        this.vuelo = vuelo;
        this.pasajero = pasajero;
    }

    public VueloV2 getVuelo() {
        return vuelo;
    }

    public PasajeroV2 getPasajero() {
        return pasajero;
    }
}
