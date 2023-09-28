package ar.edu.unlu.poo.agencia.ejercicio14;

public class Transporte extends Proveedores {
    @Override
    public Double calcularPago(int cant_maxima) {
        Double monto = 0.0;
        for (int i = 0; i < cant_maxima; i++){
            monto += getImporteBase();
            monto += getImporteBase() * 0.3;
        }
        return monto;
    }
}
