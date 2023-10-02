package ar.edu.unlu.poo.agenciadevuelo.modeloalternativo;

public class PasajeroV2 extends Rol{
    private int numeroPasajero;


    public PasajeroV2(int numeroPasajero){
        this.numeroPasajero = numeroPasajero;
    }
    public int getNumeroPasajero() {
        return numeroPasajero;
    }

    public String toString(){
        String acumulador = "";
        acumulador += " | Rol de pasajero con el numero: " + getNumeroPasajero();
        return acumulador;
    }
}
