package ar.edu.unlu.poo.billetera.ejercicio5;

import ar.edu.unlu.poo.billetera.ejercicio4.CuentaCredito;

public class UsuarioV2 {
    private String nombreUsuario;
    private String contrasenia;
    //puse como atributos al nombre de usuario y contrasenia para no devolverle el tipo Usuario completo al sistema
    // y ademas para diferenciar las cuentas de los usuarios
    private CuentaV2 cuenta;
    private CuentaCredito cuentaCredito;

    public UsuarioV2(String nombreUsuario, String contrasenia,CuentaV2 cuenta, CuentaCredito cuentaCredito) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.cuenta = cuenta;
        this.cuentaCredito = cuentaCredito;
    }

    public UsuarioV2(String nombreUsuario, String contrasenia, CuentaV2 cuenta) {
        this(nombreUsuario, contrasenia, cuenta, null);
    }

    /**
     * Muestra por consola el estado de su cuenta, imprime:
     * 	a. El saldo
     *  b. El limite de giro en descubierto y en parentesis el monto girado en descubierto.
     *  c. El monto total invertido y entre parentesis el interes a ganar.
     *  d. El monto disponible para compras a credito y la deuda total a pagar segun las compras.
     */
    public void mostrarEstado() {
        System.out.println("-----------------------");
        System.out.println("");
        System.out.println("Saldo: "+this.cuenta.getSaldo());
        System.out.println("Giro en descubierto: "+this.cuenta.getLimiteGiroDescubierto()+"("+this.cuenta.getGiroDescubierto()+")");
        System.out.println("Inversiones: "+this.cuenta.getMontoInvertido()+"("+this.cuenta.getInteresAGanar()+")");
        System.out.println("");
        System.out.println("--- Cuenta crédito ----");
        System.out.println("");
        if (cuentaCredito != null) {
            System.out.println("Disponible para compras: " + this.cuentaCredito.getMontoDisponibleParaCompras());
            System.out.println("Saldo deudor: " + this.cuentaCredito.getSaldoDeudor());
        }else {
            System.out.println("El usuario no tiene cuenta credito");
        }
    }

    /**
     * Intenta realizar un gasto sobre la cuenta. En caso de que el monto sea mayor al saldo, emite un mensaje que no se puede
     * realizar el gasto porque se va a girar en descubierto.
     * @param monto
     * @return
     */

    //nuevos cambios en este metodo
    public boolean realizarGasto(double monto) {
        if(monto > this.cuenta.getSaldo()) {
            System.out.println("No se puede realizar el gasto, se va a girar en descubierto..");
            if (cuenta.getMontoInvertido() != 0){
                System.out.println("AVISO: si quiere gastar igual tiene una inversion que el sistema puede cancelar automaticamente para reducir el giro en descubierto");
            }
            return false;
        }else {
            return this.cuenta.gastar(monto);
        }

    }

    /**
     * Intenta realizar un gasto sobre la cuenta por mas que se vaya a girar en descubierto
     * @param monto
     * @return
     */
    public boolean realizarGastoYGirar(double monto) {
        if (cuenta.getMontoInvertido() != 0){
            this.cuenta.cancelarInversion();
        }
        return this.cuenta.gastar(monto);
    }

    public void depositarMonto(double monto){this.cuenta.depositar(monto);}

    public boolean invertirMonto(double monto){return this.cuenta.invertir(monto);}
    public boolean recuperarMonto(){return this.cuenta.recuperarInversion();}

    //nueva...
    public boolean cancelarInversion(){return this.cuenta.cancelarInversion();}

    // TODO de aca para abajo falta implementar todas las operaciones posibles sobre la cuenta credito.

    public boolean comprarConCuentaCredito(double monto){
        return this.cuentaCredito.comprar(monto);
    }
    public boolean pagarConCuentaCredito(double monto, int indiceCompra){return this.cuentaCredito.pagar(monto,indiceCompra);}

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }
}
