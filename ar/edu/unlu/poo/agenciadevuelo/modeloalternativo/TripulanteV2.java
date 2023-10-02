package ar.edu.unlu.poo.agenciadevuelo.modeloalternativo;

import ar.edu.unlu.poo.agenciadevuelo.modelooriginal.ReciboSueldo;

import java.util.ArrayList;

public class TripulanteV2 extends Rol{
    private String cargo;
    private ArrayList<ReciboSueldo> reciboSueldos;


    public TripulanteV2(String cargo){
        this.cargo = cargo;
        reciboSueldos = new ArrayList<>();
    }

    public String getCargo() {
        return cargo;
    }
    public void sumarReciboSueldo(ReciboSueldo reciboSueldo) {
        this.reciboSueldos.add(reciboSueldo);
    }
    public String toString(){
        String acumulador = "";
        acumulador += " | Rol de tripulante con el cargo de: " + getCargo();
        return acumulador;
    }
}
