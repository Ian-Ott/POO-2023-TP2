package ar.edu.unlu.poo.billetera.ejercicio12;

public abstract class CuentaV3 {
    public boolean gastar(double monto) {
        return false;
    }
    public void depositar(double monto) {

    }

    public boolean invertir(double monto) {
        return false;
    }
    public boolean recuperarInversion() {
        return false;
    }
    public boolean cancelarInversion(){
        return false;
    }

    public double getSaldo(){
        return 0.0d;
    }

    public double getGiroDescubierto(){
        return 0.0d;
    }
    public double getLimiteGiroDescubierto(){
        return 0.0d;
    }

    public double getMontoInvertido() {
        return 0.0d;
    }
    public double getInteresAGanar() {
        return 0.0d;
    }

    //lo siguiente son metodos exclusivos de la cuenta credito
    public boolean comprar(double monto) {
        return false;
    }

    public boolean pagar(double monto, int indiceCompra) {
        return false;
    }

    public double getSaldoDeudor() {
        return 0.0d;
    }
    public double getMontoDisponibleParaCompras() {
        return 0.0d;
    }
}
