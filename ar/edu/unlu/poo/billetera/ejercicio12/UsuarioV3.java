package ar.edu.unlu.poo.billetera.ejercicio12;


public class UsuarioV3 {
    private String nombreUsuario;
    private String contrasenia;
    //puse como atributos al nombre de usuario y contrasenia para no devolverle el tipo Usuario completo al sistema
    // y ademas para diferenciar las cuentas de los usuarios
    private CuentaV3 cuentaNormal;
    private CuentaV3 cuentaCredito;
    private CuentaV3 cajaDeAhorro;


    public UsuarioV3(String nombreUsuario, String contrasenia,CuentaNormal cuentaNormal, CuentaCredito cuentaCredito, CajaDeAhorro cajaDeAhorro) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.cuentaNormal = cuentaNormal;
        this.cuentaCredito = cuentaCredito;
        this.cajaDeAhorro = cajaDeAhorro;
    }

    public UsuarioV3(String nombreUsuario, String contrasenia, CuentaNormal cuentaNormal) {
        this(nombreUsuario, contrasenia, cuentaNormal, null, null);
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
        System.out.println("Saldo: "+this.cuentaNormal.getSaldo());
        System.out.println("Giro en descubierto: "+this.cuentaNormal.getLimiteGiroDescubierto()+"("+this.cuentaNormal.getGiroDescubierto()+")");
        System.out.println("Inversiones: "+this.cuentaNormal.getMontoInvertido()+"("+this.cuentaNormal.getInteresAGanar()+")");
        System.out.println("");
        System.out.println("--- Cuenta crédito ----");
        System.out.println("");
        if (cuentaCredito != null) {
            System.out.println("Disponible para compras: " + this.cuentaCredito.getMontoDisponibleParaCompras());
            System.out.println("Saldo deudor: " + this.cuentaCredito.getSaldoDeudor());
        }else {
            System.out.println("El usuario no tiene cuenta credito");
        }
        if (cajaDeAhorro != null){
            System.out.println("--- Caja De Ahorro ----");
            System.out.println("");
            System.out.println("Saldo: "+this.cajaDeAhorro.getSaldo());
            System.out.println("Inversiones: "+this.cajaDeAhorro.getMontoInvertido()+"("+this.cajaDeAhorro.getInteresAGanar()+")");
            System.out.println("");
        }else {
            System.out.println("El usuario no tiene caja de ahorro");
        }
    }

    /**
     * Intenta realizar un gasto sobre la cuenta. En caso de que el monto sea mayor al saldo, emite un mensaje que no se puede
     * realizar el gasto porque se va a girar en descubierto.
     * @param monto
     * @return
     */

    public boolean realizarGasto(double monto) {
        if(monto > this.cuentaNormal.getSaldo()) {
            System.out.println("No se puede realizar el gasto, se va a girar en descubierto..");
            if (cuentaNormal.getMontoInvertido() != 0){
                System.out.println("AVISO: si quiere gastar igual tiene una inversion que el sistema puede cancelar automaticamente para reducir el giro en descubierto");
            }
            return false;
        }else {
            return this.cuentaNormal.gastar(monto);
        }

    }

    /**
     * Intenta realizar un gasto sobre la cuenta por mas que se vaya a girar en descubierto
     * @param monto
     * @return
     */
    public boolean realizarGastoYGirar(double monto) {
        if (cuentaNormal.getMontoInvertido() != 0){
            this.cuentaNormal.cancelarInversion();
        }
        return this.cuentaNormal.gastar(monto);
    }

    public void depositarMonto(double monto){this.cuentaNormal.depositar(monto);}

    public boolean invertirMonto(double monto){return this.cuentaNormal.invertir(monto);}
    public boolean recuperarMonto(){return this.cuentaNormal.recuperarInversion();}

    public boolean cancelarInversion(){return this.cuentaNormal.cancelarInversion();}

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

    //operaciones sobre la caja de ahorro:
    public boolean realizarGastoCajaAhorro(double monto) {
        if(monto > this.cajaDeAhorro.getSaldo()) {
            System.out.println("No se puede realizar el gasto porque el monto es menor a su saldo");
            if (cajaDeAhorro.getMontoInvertido() != 0){
                System.out.println("AVISO: tiene una inversion activa si realmente quiere realizar el gasto primero cancele la inversion para ver si alcanza para gastar");
            }
            return false;
        }else {
            return this.cajaDeAhorro.gastar(monto);
        }
    }

    public void depositarMontoCajaAhorro(double monto){this.cajaDeAhorro.depositar(monto);}

    public boolean invertirMontoCajaAhorro(double monto){return this.cajaDeAhorro.invertir(monto);}
    public boolean recuperarMontoCajaAhorro(){return this.cajaDeAhorro.recuperarInversion();}

    public boolean cancelarInversionCajaAhorro(){return this.cajaDeAhorro.cancelarInversion();}

}
