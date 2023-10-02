package ar.edu.unlu.poo.agencia.ejercicio14;

import java.util.ArrayList;

public class Clientes {
    private String nombre_apellido;
    private int cant_compras;
    private String DNI;
    private String destino_fav;
    ArrayList<Compra> comprasCliente;

    public Clientes(String nombre_apellido, String DNI, String destinoFav){
        this.nombre_apellido = nombre_apellido;
        this.cant_compras = 0;
        this.DNI = DNI;
        this.destino_fav = destinoFav;
        this.comprasCliente = new ArrayList<>();
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

    public String getDNI() {
        return DNI;
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
