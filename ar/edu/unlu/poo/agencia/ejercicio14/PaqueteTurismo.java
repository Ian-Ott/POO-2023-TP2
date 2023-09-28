package ar.edu.unlu.poo.agencia.ejercicio14;

import java.util.ArrayList;

public class PaqueteTurismo {
    private String nombre_paquete;
    private String destino;
    //private String medio_transporte;
    //private String hospedaje;
    //private int cant_excursiones;
    //private ArrayList<String> excursiones;
    //estas son las anteriores que tenia SunBeach pero no las voy a usar
    // porque no son necesarias para el ejercicio
    private ArrayList<Proveedores> proveedoresDelPaquete = new ArrayList<>();
    private ArrayList<Clientes> compradores = new ArrayList<>();
    private int cantClientesMax;

    public void setNombre_paquete(String nombre_paquete) {
        this.nombre_paquete = nombre_paquete;
    }

    public String getNombre_paquete() {
        return nombre_paquete;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    /*public void setMedio_transporte(String medio_transporte) {
        this.medio_transporte = medio_transporte;
    }

    public String getMedio_transporte() {
        return medio_transporte;
    }

    public void setHospedaje(String hospedaje) {
        this.hospedaje = hospedaje;
    }

    public String getHospedaje() {
        return hospedaje;
    }

    public void setCant_excursiones(int cant_excursiones) {
        this.cant_excursiones = cant_excursiones;
    }

    public int getCant_excursiones() {
        return cant_excursiones;
    }

    public void agregarExcursion(String excursion) {
        this.excursiones.add(excursion);
    }

    public ArrayList<String> getExcursiones() {
        return excursiones;
    }*/

    public void agregarProveedorDelPaquete(Proveedores proveedor) {
        this.proveedoresDelPaquete.add(proveedor);
    }

    public ArrayList<Proveedores> getProveedoresDelPaquete() {
        return proveedoresDelPaquete;
    }

    public void agregarComprador(Clientes comprador) {
        this.compradores.add(comprador);
    }

    public ArrayList<Clientes> getCompradores() {
        return compradores;
    }

    public void setCantClientesMax(int cantClientesMax) {
        this.cantClientesMax = cantClientesMax;
    }

    public int getCantClientesMax() {
        return cantClientesMax;
    }
}
