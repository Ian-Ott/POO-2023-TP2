package ar.edu.unlu.poo.agencia;

import java.util.ArrayList;

public class Clientes {
    private String nombre_apellido;
    private String DNI;
    private int cant_totalCompras = 0;
    private String destinoFavorito;
    private ArrayList<PaqueteTurismo> paquetesAdquiridos = new ArrayList<>();

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void sumarCompra(){
        cant_totalCompras = cant_totalCompras + 1;
    }

    public int getCant_totalCompras() {
        return cant_totalCompras;
    }

    public void setDestinoFavorito(String destinoFavorito) {
        this.destinoFavorito = destinoFavorito;
    }

    public String getDestinoFavorito() {
        return destinoFavorito;
    }

    public void agregarPaqueteAdquirido(PaqueteTurismo paqueteAdquirido) {
        paquetesAdquiridos.add(paqueteAdquirido);
    }

    public ArrayList<PaqueteTurismo> getPaquetesAdquiridos() {
        return paquetesAdquiridos;
    }
}
