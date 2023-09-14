package ar.edu.unlu.poo.agencia;

import java.time.LocalDate;
import java.util.ArrayList;

public class PaqueteTurismo {
    private String nombrePaquete;
    private String destino;
    private String medioTransporte;
    private String hospedaje;
    private ArrayList<String> excursiones;
    private LocalDate FechaAdquirido = null;
    //esto se establece para el cliente nomas


    public void setNombrePaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
    }

    public String getNombrePaquete() {
        return nombrePaquete;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    public void setMedioTransporte(String medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    public String getMedioTransporte() {
        return medioTransporte;
    }

    public void setHospedaje(String hospedaje) {
        this.hospedaje = hospedaje;
    }

    public String getHospedaje() {
        return hospedaje;
    }

    public void agregarExcursiones(String excursiones) {
        this.excursiones.add(excursiones);
    }

    public void setExcursiones(ArrayList<String> excursiones) {
        this.excursiones = excursiones;
    }

    public ArrayList<String> getExcursiones() {
        return excursiones;
    }

    public void setFechaAdquirido(LocalDate fechaAdquirido) {
        FechaAdquirido = fechaAdquirido;
    }

    public LocalDate getFechaAdquirido() {
        return FechaAdquirido;
    }
}
