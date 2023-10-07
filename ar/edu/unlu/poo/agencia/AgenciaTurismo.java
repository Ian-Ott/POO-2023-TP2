package ar.edu.unlu.poo.agencia;

import java.time.LocalDate;
import java.util.ArrayList;

public class AgenciaTurismo {
    private ArrayList<Proveedores> listaProveedores = new ArrayList<>();
    private ArrayList<PaqueteTurismo> paquetesDisponibles = new ArrayList<>();
    private ArrayList<Clientes> clientesAgencia = new ArrayList<>();

    public void nuevoProveedor(String nombre, String tipoCompania, Clasificacion clasificacion){
        Proveedores nuevo_proveedor= new Proveedores();
        nuevo_proveedor.setNombre_proveedor(nombre);
        nuevo_proveedor.setTipoCompania(tipoCompania);
        nuevo_proveedor.setClasificacionProveedor(clasificacion);
        listaProveedores.add(nuevo_proveedor);
    }

    public void nuevoPaqueteTurismo(String nombre, String destino, String medioTransporte, String hospedaje, ArrayList<String> excursiones){
        PaqueteTurismo nuevo_paquete = new PaqueteTurismo();
        nuevo_paquete.setNombrePaquete(nombre);
        nuevo_paquete.setDestino(destino);
        nuevo_paquete.setMedioTransporte(medioTransporte);
        nuevo_paquete.setHospedaje(hospedaje);
        for (int i = 0; i < excursiones.size(); i++){
            nuevo_paquete.agregarExcursiones(excursiones.get(i));
        }
        paquetesDisponibles.add(nuevo_paquete);
    }

    public void nueva_compra(boolean es_cliente, String nombre_apellido, String DNI, String destinoFavorito, String nombrePaquete){
        if (!es_cliente){
            nuevocliente(nombre_apellido,DNI,destinoFavorito);
        }
        Clientes clienteAux;
        for (int i = 0; i < clientesAgencia.size(); i++){
            clienteAux = clientesAgencia.get(i);
           if (clienteAux.getNombre_apellido().equals(nombre_apellido) && clienteAux.getDNI().equals(DNI)){
               for (int j = 0; j < paquetesDisponibles.size(); j++){
                   if (paquetesDisponibles.get(j).getNombrePaquete().equals(nombrePaquete)){
                       clienteAux.sumarCompra();
                       PaqueteTurismo paqueteAdquirido = new PaqueteTurismo();
                       paqueteAdquirido.setNombrePaquete(paquetesDisponibles.get(j).getNombrePaquete());
                       paqueteAdquirido.setDestino(paquetesDisponibles.get(j).getDestino());
                       paqueteAdquirido.setExcursiones(paquetesDisponibles.get(j).getExcursiones());
                       paqueteAdquirido.setHospedaje(paquetesDisponibles.get(j).getHospedaje());
                       paqueteAdquirido.setMedioTransporte(paquetesDisponibles.get(j).getMedioTransporte());
                       //NOTA: creo un nuevo paquete por cada uno que se compra asi guardo la informacion de cuando compro el paquete
                       //y asi no se modifica nada de lo que hay en paquetes disponibles
                       paqueteAdquirido.setFechaAdquirido(LocalDate.now());
                       clienteAux.agregarPaqueteAdquirido(paqueteAdquirido);
                   }
               }
           }
        }
    }

    private void nuevocliente(String nombreApellido, String dni, String destinoFavorito){
        Clientes nuevo_cliente = new Clientes();
        nuevo_cliente.setNombre_apellido(nombreApellido);
        nuevo_cliente.setDNI(dni);
        nuevo_cliente.setDestinoFavorito(destinoFavorito);
        clientesAgencia.add(nuevo_cliente);
    }

    public void informe_mensual(){
        System.out.println("VENTAS DEL MES:");
        for (int k = 0; k < paquetesDisponibles.size(); k++){
            System.out.println("Ventas del paquete "+ paquetesDisponibles.get(k).getNombrePaquete());
        for (int i = 0; i < clientesAgencia.size(); i++){
            ArrayList<PaqueteTurismo> paquetesCliente = clientesAgencia.get(i).getPaquetesAdquiridos();
            for (int j = 0; j < paquetesCliente.size(); j++){
                if (paquetesDisponibles.get(k).getNombrePaquete().equals(paquetesCliente.get(j).getNombrePaquete())){
                    if (LocalDate.now().getMonth().equals(paquetesCliente.get(j).getFechaAdquirido().getMonth())){
                        System.out.println("____________________________________________________________________________");
                        System.out.println("Cliente: " + i + "- Nombre y apellido: " + clientesAgencia.get(i).getNombre_apellido() + " | DNI: " + clientesAgencia.get(i).getDNI());
                        System.out.println("Paquete comprado: " + paquetesCliente.get(j).getNombrePaquete() + " | Adquirido el dia: " + paquetesCliente.get(j).getFechaAdquirido());
                    }
                }
            }
        }
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    }
    }

    //este muestra los datos de cada cliente incluido su destino favorito
    public void registroCliente(){
        System.out.println("Registro de clientes: ");
        for (int i = 0; i < clientesAgencia.size(); i++){
            System.out.println("____________________________________________________________________________");
            System.out.println("Cliente: " + i + "- Nombre y apellido: " + clientesAgencia.get(i).getNombre_apellido() + " | DNI: " + clientesAgencia.get(i).getDNI() + " | Destino favorito: " + clientesAgencia.get(i).getDestinoFavorito());
            ArrayList<PaqueteTurismo> paquetesCliente = clientesAgencia.get(i).getPaquetesAdquiridos();
            System.out.println("Paquetes comprados: ");
            for (int j = 0; j < paquetesCliente.size(); j++){
                        System.out.println(paquetesCliente.get(j).getNombrePaquete() + " | Adquirido el dia: " + paquetesCliente.get(j).getFechaAdquirido());
            }
        }
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    }
    public void registrosProveedores(){
        System.out.println("Registro de proveedores: ");
        for (int i = 0; i < listaProveedores.size();i++){
            System.out.println("____________________________________________________________________________");
            System.out.println((i + 1) +"-Proveedor: " + listaProveedores.get(i).getNombre_proveedor() + " | Tipo de compania: " + listaProveedores.get(i).getTipoCompania() + " | Clasificacion: " + listaProveedores.get(i).getClasificacionProveedor());
        }
    }

    public void mostrarPaquetesTurismo(){
        System.out.println("Paquetes disponibles: ");
        for (int i = 0; i < paquetesDisponibles.size(); i++){
            System.out.println("\n____________________________________________________________________________");
            System.out.println((i + 1) + "-Paquete: " + paquetesDisponibles.get(i).getNombrePaquete() + " | Destino: " + paquetesDisponibles.get(i).getDestino() + " | Medio de Transporte: " + paquetesDisponibles.get(i).getMedioTransporte() + " | Hospedaje: " + paquetesDisponibles.get(i).getHospedaje());
            System.out.print("\nExcursiones: ");
            for (int j = 0; j < paquetesDisponibles.get(i).getExcursiones().size(); j++){
                System.out.print("\n " + paquetesDisponibles.get(i).getExcursiones().get(j));
            }
        }
    }

}
