package ar.edu.unlu.poo.agencia.ejercicio14;

public class Hospedaje extends Proveedores {
    private int cant_minClientes;

    public void setCant_minClientes(int cant_minClientes) {
        this.cant_minClientes = cant_minClientes;
    }

    public int getCant_minClientes() {
        return cant_minClientes;
    }

    @Override
    public Double calcularPago(int cant_maxima) {
        Double monto = 0.0;
        for (int i = 0; i < cant_maxima; i++){
            if (i > getCant_minClientes()){
                monto += getImporteBase() * 0.5;
            }else {
                monto += getImporteBase();
            }
        }
        return monto;
    }
}
