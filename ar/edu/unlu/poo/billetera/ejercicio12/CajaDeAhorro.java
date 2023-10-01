package ar.edu.unlu.poo.billetera.ejercicio12;

import java.time.LocalDate;

public class CajaDeAhorro extends CuentaV3{
    private double saldo;
    private double saldoInvertido;
    public static final double INTERES_POR_INVERSION = 0.4;
    public static final double PLAZO_DIAS_INVERSION = 30;
    private LocalDate fechaInversion;

    public CajaDeAhorro(double saldo) {
        this.saldo = saldo;
        this.saldoInvertido = 0;
        this.fechaInversion = null;
    }

    public boolean gastar(double monto) {
        boolean res = false;

        if ((this.saldo  >= monto)){
            if (this.saldo < monto) {
                //como no tiene giro descubierto directamente no hace el gasto
            }else {
                // El saldo me alzanza para el gasto
                this.saldo -= monto;
                res = true;
            }
        }
        return res;
    }

    public void depositar(double monto) {
        // TODO Implementar.... (Ya implementado)
        //como no tiene giro descubierto directamente se deposita el monto
        saldo += monto;
    }

    /**
     * Realiza la inversion del monto indicado. Condiciones para que la operación sea exitosa:
     * 	a. Que el saldo sea >= monto
     *  b. Que no exista una inversión activa.
     *
     * Tambien establece la fecha de inversión.
     *
     * @param monto
     * @return
     */
    public boolean invertir(double monto) {
        // TODO Implementar ... (Ya implementado)
        boolean resultado = false;
        if (saldo >= monto && saldoInvertido == 0){
            resultado = true;
            saldoInvertido += monto;
            fechaInversion = LocalDate.now();
            saldo -= monto;
        }
        return resultado;
    }

    /**
     * Devuelve el monto invertido al saldo con el interes establecido. Se puede realizar siempre y cuando
     * hayan pasado los N días que dura la inversión.
     * @return
     */
    public boolean recuperarInversion() {
        // TODO Implementar ... (Ya implementado)
        boolean resultado = false;
        if (fechaInversion != null){
            if (fechaInversion.plusDays((long) PLAZO_DIAS_INVERSION).isBefore(LocalDate.now())){
                resultado = true;
                saldo += saldoInvertido * INTERES_POR_INVERSION;
                saldoInvertido = 0.0d;
            }
        }
        return resultado;

    }

    public boolean cancelarInversion(){
        boolean resultado = false;
        if (saldoInvertido != 0){
            resultado = true;
            if (fechaInversion.plusDays(30).isBefore(LocalDate.now())){
                saldo += saldoInvertido + (saldoInvertido * 0.05);
            } else if (fechaInversion.plusDays((long) PLAZO_DIAS_INVERSION).isBefore(LocalDate.now())) {
                return recuperarInversion();
                //agregue esta aunque no lo pida para qe al cancelar si ya tiene mas de 40 dias se le aplique el interes original
            } else {
                saldo += saldoInvertido;
            }
            saldoInvertido = 0.0d;
            fechaInversion = null;
        }
        return resultado;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public double getMontoInvertido() {
        return this.saldoInvertido;
    }

    public double getInteresAGanar() {
        if (this.fechaInversion != null)
            return this.saldoInvertido * CuentaNormal.INTERES_POR_INVERSION;
        return 0.0d;
    }

}
