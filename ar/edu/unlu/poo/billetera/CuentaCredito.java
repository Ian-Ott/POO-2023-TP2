package ar.edu.unlu.poo.billetera;

import java.util.ArrayList;
import java.util.List;

public class CuentaCredito {
    private double limite;
    private List<Double> compras;
    private List<Double> pagado;


    public CuentaCredito(double limite) {
        this.limite = limite;
        this.compras = new ArrayList<Double>();
        this.pagado = new ArrayList<Double>();
    }

    /**
     * Registra una nueva compra en caso que todavía quede saldo disponible para compras.
     *
     * @param monto
     * @return boolean: true si la compra fue existosa, false en caso contrario.
     */
    public boolean comprar(double monto) {
        // TODO Implementar ... (Ya implementado)
        boolean resultado = false;
        if (getMontoDisponibleParaCompras() >= monto){
            resultado = true;
            Double nueva_compra = monto;
            compras.add(nueva_compra);
        }
        return resultado;
    }

    /**
     * Realiza un pago sobre una compra. Si el monto es menor o igual al saldo que queda por pagar de la compra, el pago se registra
     * y la operacion es exitosa devolviendo true.
     * Si el monto es mayor al saldo, entonces la operación no se realiza devolviendo false.
     *
     * @param monto: cantidad a pagar.
     * @param indiceCompra: el numero de indice de la compra sobre la cual se requiere realizar un pago.
     * @return
     */
    public boolean pagar(double monto, int indiceCompra) {
        // TODO implementar ... (Ya implementado)
        boolean resultado = false;
        if (monto <= getSaldoDeudorCompra(indiceCompra)){
            resultado = true;
            double nuevo_monto = compras.get(indiceCompra) - monto;
            compras.set(indiceCompra,nuevo_monto);
            pagado.add(monto);
            limite += monto;
        }
        return resultado;
    }

    /**
     * Retorna el saldo que queda por pagar de una compra, incluyendo el interes.
     *
     * @param indiceCompra
     * @return
     */
    public double getSaldoDeudorCompra(int indiceCompra) {
        // TODO falta implementar ... (Ya implementado)
        return compras.get(indiceCompra) + (compras.get(indiceCompra) * 0.5);
    }

    /**
     * Devuelve el saldo deudor total teniendo en cuenta todas las compras impagas.
     * @return double
     */
    public double getSaldoDeudor() {
        // TODO falta implementar... (Ya implementado)
        double total = 0.0d;
        for (int i = 0; i < compras.size(); i++){
            total += getSaldoDeudorCompra(i);
        }
        return total;
    }

    /**
     * Devuelve el monto disponible para compras de la cuenta teniendo en cuenta todas las compras
     * realizadas que quedan por pagar, sin tener en cuenta las que deben solo el interes.
     * @return double: el saldo disponible para realizar compras.
     */
    public double getMontoDisponibleParaCompras() {
        // TODO falta implementar ... (Ya implementado)
        double montoDisponible = limite;
        for (int i = 0; i < compras.size(); i++){
            montoDisponible -= getSaldoDeudorCompra(i);
        }
        return montoDisponible;
    }


}
