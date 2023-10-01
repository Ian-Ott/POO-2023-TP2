package ar.edu.unlu.poo.billetera.ejercicio12;


import java.util.ArrayList;

public class BilleteraVirtualV3 {
    ArrayList<UsuarioV3> usuarios = new ArrayList<>();

    public void crear_cuenta(String nombreUsuario, String contrasenia, Double saldo, Double limiteGiroEnDescubierto, Double limite, boolean conCuentaCredito,boolean conCajaAhorro, Double saldoCajaAhorro){
        if (conCuentaCredito && conCajaAhorro){
            CuentaNormal nuevaCuenta = new CuentaNormal(saldo, limiteGiroEnDescubierto);
            CuentaCredito nuevaCuentaCredito = new CuentaCredito(limite);
            CajaDeAhorro nuevaCajaAhorro = new CajaDeAhorro(saldoCajaAhorro);
            UsuarioV3 nuevo_usuario = new UsuarioV3(nombreUsuario, contrasenia,nuevaCuenta, nuevaCuentaCredito, nuevaCajaAhorro);
            usuarios.add(nuevo_usuario);
        } else if (conCuentaCredito) {
            CuentaNormal nuevaCuenta = new CuentaNormal(saldo, limiteGiroEnDescubierto);
            CuentaCredito nuevaCuentaCredito = new CuentaCredito(limite);
            UsuarioV3 nuevo_usuario = new UsuarioV3(nombreUsuario, contrasenia,nuevaCuenta, nuevaCuentaCredito, null);
            usuarios.add(nuevo_usuario);
        } else if (conCajaAhorro) {
            CuentaNormal nuevaCuenta = new CuentaNormal(saldo, limiteGiroEnDescubierto);
            CajaDeAhorro nuevaCajaAhorro = new CajaDeAhorro(saldoCajaAhorro);
            UsuarioV3 nuevo_usuario = new UsuarioV3(nombreUsuario, contrasenia,nuevaCuenta, null, nuevaCajaAhorro);
            usuarios.add(nuevo_usuario);
        }else {
            CuentaNormal nuevaCuenta = new CuentaNormal(saldo, limiteGiroEnDescubierto);
            UsuarioV3 nuevo_usuario = new UsuarioV3(nombreUsuario, contrasenia,nuevaCuenta);
            usuarios.add(nuevo_usuario);
        }
    }

    private UsuarioV3 buscarUsuario(String nombreUsuario, String contrasenia){
        UsuarioV3 usuarioAux;
        for (int i = 0; i < usuarios.size();i++){
            usuarioAux = usuarios.get(i);
            if (usuarioAux.getNombreUsuario().equals(nombreUsuario) && usuarioAux.getContrasenia().equals(contrasenia)){
                return usuarioAux;
            }
        }
        return null;
    }
    public void mostrarEstadoCuenta(String nombreUsuario, String contrasenia){
        UsuarioV3 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            usuarioAux.mostrarEstado();
        }
    }
    public boolean realizarGastoCuenta(String nombreUsuario, String contrasenia, double monto){
        UsuarioV3 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            return usuarioAux.realizarGasto(monto);
        }
        return false;
    }

    public boolean realizarGastoYGirarCuenta(String nombreUsuario, String contrasenia, double monto){
        UsuarioV3 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            return usuarioAux.realizarGastoYGirar(monto);
        }
        return false;
    }

    public void depositarMontoCuenta(String nombreUsuario, String contrasenia, double monto){
        UsuarioV3 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            usuarioAux.depositarMonto(monto);
        }
    }

    public boolean invertirMontoCuenta(String nombreUsuario, String contrasenia, double monto){
        UsuarioV3 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            return usuarioAux.invertirMonto(monto);
        }
        return false;
    }

    public boolean cancelarInversionCuenta(String nombreUsuario, String contrasenia){
        UsuarioV3 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            return usuarioAux.cancelarInversion();
        }
        return false;
    }

    public boolean recuperarMontoInvertidoCuenta(String nombreUsuario, String contrasenia){
        UsuarioV3 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            return usuarioAux.recuperarMonto();
        }
        return false;
    }

    public boolean comprarUsandoCuentaCredito(String nombreUsuario, String contrasenia, double monto){
        UsuarioV3 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            return usuarioAux.comprarConCuentaCredito(monto);
        }
        return false;
    }

    public boolean pagarUsandoCuentaCredito(String nombreUsuario, String contrasenia, double monto, int indiceCompra){
        UsuarioV3 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            return usuarioAux.pagarConCuentaCredito(monto,indiceCompra);
        }
        return false;
    }

    public boolean realizarGastoCajaAhorro(String nombreUsuario, String contrasenia, double monto){
        UsuarioV3 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            return usuarioAux.realizarGastoCajaAhorro(monto);
        }
        return false;
    }

    public void depositarMontoCajaAhorro(String nombreUsuario, String contrasenia, double monto){
        UsuarioV3 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            usuarioAux.depositarMontoCajaAhorro(monto);
        }
    }

    public boolean invertirMontoCajaAhorro(String nombreUsuario, String contrasenia, double monto){
        UsuarioV3 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            return usuarioAux.invertirMontoCajaAhorro(monto);
        }
        return false;
    }

    public boolean cancelarInversionCajaAhorro(String nombreUsuario, String contrasenia){
        UsuarioV3 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            return usuarioAux.cancelarInversionCajaAhorro();
        }
        return false;
    }

    public boolean recuperarMontoInvertidoCajaAhorro(String nombreUsuario, String contrasenia){
        UsuarioV3 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            return usuarioAux.recuperarMontoCajaAhorro();
        }
        return false;
    }

}
