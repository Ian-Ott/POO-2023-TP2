package ar.edu.unlu.poo.agenciadeautomoviles;

import java.time.LocalDate;
import java.util.ArrayList;

public class SistemaDeAgencia {
    ArrayList<Vehiculos> listaDeVehiculos = new ArrayList<>();
    ArrayList<Clientes> listaClientes = new ArrayList<>();
    ArrayList<Alquiler> alquileres = new ArrayList<>();

    public void registrarCamion(String patente){
        if (esta_patente(patente)){
            return;
        }
        Camiones nuevoCamion = new Camiones();
        nuevoCamion.setPatente(patente);
        listaDeVehiculos.add(nuevoCamion);
    }

    private boolean esta_patente(String patente) {
        boolean resultado = false;
        for (int i = 0; i < listaDeVehiculos.size(); i++){
            if (patente.equals(listaDeVehiculos.get(i).getPatente())){
                System.out.println("EROR PATENTE YA REGISTRADA. No se puede registrar dos vehiculos con la misma patente");
                resultado = true;
            }
        }
        return resultado;
    }

    public void registrarCamionetasFlete(String patente, Double pat){
        if (esta_patente(patente)){
            return;
        }
        CamionetasFlete nuevaCamioneta = new CamionetasFlete();
        nuevaCamioneta.setPatente(patente);
        nuevaCamioneta.setPAT(pat);
        listaDeVehiculos.add(nuevaCamioneta);
    }

    public void registrarCombi(String patente){
        if (esta_patente(patente)){
            return;
        }
        Combis nuevaCombi = new Combis();
        nuevaCombi.setPatente(patente);
        listaDeVehiculos.add(nuevaCombi);
    }

    public void registrarAutoDePasajeros(String patente, int cant_asientos){
        if (esta_patente(patente)){
            return;
        }
        AutoDePasajero nuevoAuto = new AutoDePasajero();
        nuevoAuto.setPatente(patente);
        nuevoAuto.setAsientos(cant_asientos);
        listaDeVehiculos.add(nuevoAuto);
    }

    public void registrarAutoVIP(String patente, int cant_asientos){
        if (esta_patente(patente)){
            return;
        }
        AutosVIP nuevoAuto = new AutosVIP();
        nuevoAuto.setPatente(patente);
        nuevoAuto.setAsientos(cant_asientos);
        listaDeVehiculos.add(nuevoAuto);
    }


    private void crearCliente(String nombre_apellido, String DNI,String telefono){
        Clientes nuevoCliente = new Clientes();
        nuevoCliente.setNombre_apellido(nombre_apellido);
        nuevoCliente.setDNI(DNI);
        nuevoCliente.setTelefono(telefono);
        listaClientes.add(nuevoCliente);
    }

    public void prestarVehiculo(String nombreApellidoCliente, String DNI, String telefono, String patenteVehiculo, int cantDias){
        if (!es_cliente(DNI)){
            crearCliente(nombreApellidoCliente, DNI, telefono);
        }
        Clientes clienteAux;
        for (int i = 0; i < listaDeVehiculos.size();i++){
            if (patenteVehiculo.equals(listaDeVehiculos.get(i).getPatente())){
                Presupuesto nuevoPresupuesto = new Presupuesto();
                nuevoPresupuesto.emitirPresupuesto(listaDeVehiculos.get(i), cantDias);
                for (int j = 0; j < listaClientes.size(); j++){
                    clienteAux = listaClientes.get(j);
                    if (DNI.equals(clienteAux.getDNI())){
                        clienteAux.sumarAlquilerCliente(nuevoPresupuesto.getAlquilerArmado());
                    }
                    System.out.println("Se presto el vehiculo con patente: " + listaDeVehiculos.get(i).getPatente());
                }
            }
        }
    }


    private boolean es_cliente(String dni) {
        boolean resultado = false;
        for (int i = 0; i < listaClientes.size(); i++){
            if (dni.equals(listaClientes.get(i).getDNI())){
                resultado = true;
            }
        }
        return resultado;
    }

    public void mostrarMontoTotalCliente(String DNI){
        Clientes clienteAux;
        Alquiler alquilerAux;
        Double montoTotal = 0.0;
        for (int i = 0; i < listaClientes.size(); i++){
            clienteAux = listaClientes.get(i);
            if (listaClientes.get(i).getDNI().equals(DNI)){
                System.out.println("Cliente: " + clienteAux.getNombre_apellido() + "DNI: " + clienteAux.getDNI() + "Telefono: " + clienteAux.getTelefono());
                for (int j = 0; j < clienteAux.getAlquileresCliente().size(); j++){
                    alquilerAux = clienteAux.getAlquileresCliente().get(j);
                    montoTotal += alquilerAux.getSaldoAPagar();

                }
                System.out.println("Total de los alquileres: " + montoTotal);
            }
        }
    }

    public void mostrarMontoTodosLosAlquileres(){
        Double montoTotal = 0.0;
        for (int i = 0; i < alquileres.size(); i++){
            montoTotal += alquileres.get(i).getSaldoAPagar();
        }
        System.out.println("El monto total de todos los alquileres generados en el sistema es de " + montoTotal);
    }

}
