package ar.edu.unlu.poo.billetera.ejercicio12;


import java.time.LocalDate;

public class CuentaNormal extends CuentaV3{
    private double saldo;
    private double limiteGiroDescubierto;
    private double giroDescubierto;
    private double saldoInvertido;
    public static final double INTERES_POR_INVERSION = 0.4;
    public static final double PLAZO_DIAS_INVERSION = 30;
    private LocalDate fechaInversion;

    public CuentaNormal(double saldo, double limiteGiroDescubierto) {
        this.saldo = saldo;
        this.limiteGiroDescubierto = limiteGiroDescubierto;
        this.giroDescubierto = 0;
        this.saldoInvertido = 0;
        this.fechaInversion = null;
    }

    /**
     * Dado un monto genera un gasto en la cuenta: quita del saldo el monto a gastar, si el monto es mayor
     * al saldo entonces gira en descubierto (siempre y cuando todavía quede límite).
     * Si (saldo + limite descubierto disponible) < monto, entonces la operacion no se realiza y devuelve false.
     * @param monto: el monto a gastar
     * @return boolean: indica si la operación fué exitosa.
     */

    public boolean gastar(double monto) {
        boolean res = false;

        if ((this.saldo + (this.limiteGiroDescubierto-this.giroDescubierto)) >= monto) {
            if (this.saldo < monto) {
                //Giro en descubierto
                this.giroDescubierto += monto - this.saldo;
                this.saldo = 0;
            }else {
                // El saldo me alzanza para el gasto
                this.saldo -= monto;
            }
            res = true;
        }

        return res;
    }

    /**
     * Deposita el monto en la cuenta. Si existe giro en descubierto, primero intenta cubrirlo y si queda
     * dinero disponible aumenta el saldo.
     * @param monto
     */
    public void depositar(double monto) {
        // TODO Implementar.... (Ya implementado)
        Double montoActual = monto;
        if (giroDescubierto != 0){
            montoActual -= giroDescubierto;
            giroDescubierto -= monto;
            if (giroDescubierto < 0){
                giroDescubierto = 0;
                //si es menor a 0 lo pongo en 0 asi no queda en negativo el giro descubierto
            }
        }
        saldo += montoActual;
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

    //nueva feature
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

    public double getGiroDescubierto() {
        return this.giroDescubierto;
    }

    public double getLimiteGiroDescubierto() {
        return this.limiteGiroDescubierto;
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
