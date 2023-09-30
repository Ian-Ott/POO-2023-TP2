package ar.edu.unlu.poo.billetera.ejercicio5;

import ar.edu.unlu.poo.billetera.ejercicio4.BilleteraVirtual;
import ar.edu.unlu.poo.billetera.ejercicio4.Cuenta;
import ar.edu.unlu.poo.billetera.ejercicio4.CuentaCredito;
import ar.edu.unlu.poo.billetera.ejercicio4.Usuario;

import java.util.ArrayList;

public class BilleteraVirtualV2{
    //podria haber heredado todos los metodos pero los copie
    // porque esta seccion del tp no trata sobre herencia
    ArrayList<UsuarioV2> usuarios = new ArrayList<>();

    public void crear_cuenta(String nombreUsuario, String contrasenia, Double saldo, Double limiteGiroEnDescubierto, Double limite, boolean conCuentaCredito){
        if (conCuentaCredito){
            CuentaV2 nuevaCuenta = new CuentaV2(saldo, limiteGiroEnDescubierto);
            CuentaCredito nuevaCuentaCredito = new CuentaCredito(limite);
            UsuarioV2 nuevo_usuario = new UsuarioV2(nombreUsuario, contrasenia,nuevaCuenta, nuevaCuentaCredito);
            usuarios.add(nuevo_usuario);
        } else{
            CuentaV2 nuevaCuenta = new CuentaV2(saldo, limiteGiroEnDescubierto);
            UsuarioV2 nuevo_usuario = new UsuarioV2(nombreUsuario,contrasenia,nuevaCuenta);
            usuarios.add(nuevo_usuario);
        }
    }

    private UsuarioV2 buscarUsuario(String nombreUsuario, String contrasenia){
        UsuarioV2 usuarioAux;
        for (int i = 0; i < usuarios.size();i++){
            usuarioAux = usuarios.get(i);
            if (usuarioAux.getNombreUsuario().equals(nombreUsuario) && usuarioAux.getContrasenia().equals(contrasenia)){
                return usuarioAux;
            }
        }
        return null;
    }
    public void mostrarEstadoCuenta(String nombreUsuario, String contrasenia){
        UsuarioV2 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            usuarioAux.mostrarEstado();
        }
    }
    public boolean realizarGastoCuenta(String nombreUsuario, String contrasenia, double monto){
        UsuarioV2 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            return usuarioAux.realizarGasto(monto);
        }
        return false;
    }

    public boolean realizarGastoYGirarCuenta(String nombreUsuario, String contrasenia, double monto){
        UsuarioV2 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            return usuarioAux.realizarGastoYGirar(monto);
        }
        return false;
    }

    public void depositarMontoCuenta(String nombreUsuario, String contrasenia, double monto){
        UsuarioV2 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            usuarioAux.depositarMonto(monto);
        }
    }

    public boolean invertirMontoCuenta(String nombreUsuario, String contrasenia, double monto){
        UsuarioV2 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            return usuarioAux.invertirMonto(monto);
        }
        return false;
    }

    public boolean cancelarInversionCuenta(String nombreUsuario, String contrasenia){
        UsuarioV2 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            return usuarioAux.cancelarInversion();
        }
        return false;
    }

    public boolean recuperarMontoInvertidoCuenta(String nombreUsuario, String contrasenia){
        UsuarioV2 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            return usuarioAux.recuperarMonto();
        }
        return false;
    }

    public boolean comprarUsandoCuentaCredito(String nombreUsuario, String contrasenia, double monto){
        UsuarioV2 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            return usuarioAux.comprarConCuentaCredito(monto);
        }
        return false;
    }

    public boolean pagarUsandoCuentaCredito(String nombreUsuario, String contrasenia, double monto, int indiceCompra){
        UsuarioV2 usuarioAux = buscarUsuario(nombreUsuario,contrasenia);
        if (usuarioAux != null){
            return usuarioAux.pagarConCuentaCredito(monto,indiceCompra);
        }
        return false;
    }


}
