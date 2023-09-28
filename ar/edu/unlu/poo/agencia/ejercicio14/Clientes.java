package ar.edu.unlu.poo.agencia.ejercicio14;

import java.util.ArrayList;

public class Clientes {
    private String nombre_apellido;
    private int cant_compras = 0;
    private String DNI;
    private String destino_fav;
    ArrayList<Compra> comprasCliente = new ArrayList<>();

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void sumarCant_compras() {
        this.cant_compras = cant_compras + 1;
    }

    public int getCant_compras() {
        return cant_compras;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDestino_fav(String destino_fav) {
        this.destino_fav = destino_fav;
    }

    public String getDestino_fav() {
        return destino_fav;
    }

    public void sumarComprasCliente(Compra nuevaCompra) {
        this.comprasCliente.add(nuevaCompra);
    }

    public ArrayList<Compra> getComprasCliente() {
        return comprasCliente;
    }
}
