package ar.edu.unlu.poo.agencia.ejercicio14;

public class GuiasTuristicos extends Proveedores {
    @Override
    public Double calcularPago(int cant_maxima) {
        Double monto = 0.0;
        for (int i = 0; i < cant_maxima; i++){
            if (cant_maxima > 200){
                monto += getImporteBase() + 90;
            }else {
                monto += getImporteBase();
            }
        }
        return monto;
    }
}
