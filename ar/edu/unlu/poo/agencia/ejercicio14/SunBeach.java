package ar.edu.unlu.poo.agencia.ejercicio14;

import ar.edu.unlu.poo.agencia.Clasificacion;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;

public class SunBeach {
    ArrayList<Clientes> listaClientes = new ArrayList<>();
    ArrayList<PaqueteTurismo> paquetesDeTurismo = new ArrayList<>();

    ArrayList<Proveedores> listaProveedores = new ArrayList<>();

    public void elegirPaquete(String nombre_apellidoCliente, String DNI, String destinoFav, String paqueteElegido, LocalDate fecha){
        if (!es_cliente(DNI)){
            crearCliente(nombre_apellidoCliente, DNI, destinoFav);
        }
        PaqueteTurismo paqueteAux;
        Proveedores proveedorPaqueteAux;
        for (int i = 0; i < paquetesDeTurismo.size(); i++){
            paqueteAux = paquetesDeTurismo.get(i);
            if (paqueteElegido.equals(paqueteAux.getNombre_paquete())){
                Compra nueva_compra = new Compra();
                nueva_compra.setNombre_paquete(paqueteElegido);
                nueva_compra.setFechaCompra(fecha);
                Double precioXPersona = 0.0;
                for (int j = 0; j < paqueteAux.getProveedoresDelPaquete().size();j++){
                    proveedorPaqueteAux = paqueteAux.getProveedoresDelPaquete().get(j);
                    precioXPersona += proveedorPaqueteAux.calcularPago(paqueteAux.getCantClientesMax()) / paqueteAux.getCantClientesMax();
                    //lo vuelvo a dividir por la cantidad maxima de personas asi consigo el precio por persona
                    //ya que el calcularPago calcula el total a pagar segun la cantidad maxima de clientes del paquete
                }
                nueva_compra.setPrecioFinal(precioXPersona);
                Clientes clienteAux;
                for (int j = 0; j < listaClientes.size(); j++){
                    clienteAux = listaClientes.get(i);
                    if (DNI.equals(clienteAux.getDNI())){
                        clienteAux.sumarCant_compras();
                        clienteAux.sumarComprasCliente(nueva_compra);
                        paqueteAux.agregarComprador(clienteAux);
                    }
                }
            }
        }
    }

    private void crearCliente(String nombre_apellido, String DNI,String destinoFav){
        Clientes nuevoCliente = new Clientes();
        nuevoCliente.setNombre_apellido(nombre_apellido);
        nuevoCliente.setDNI(DNI);
        nuevoCliente.setDestino_fav(destinoFav);
        listaClientes.add(nuevoCliente);
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

    public void registroProveedores(String nombre, Clasificacion clasificacion, Double importeBase, int cant_minima){
        if (clasificacion.equals(Clasificacion.MEDIO_DE_TRANSPORTE)){
            Transporte nuevoTransporte = new Transporte();
            nuevoTransporte.setNombre(nombre);
            nuevoTransporte.setClasificacionProveedor(clasificacion);
            nuevoTransporte.setImporteBase(importeBase);
            listaProveedores.add(nuevoTransporte);
        } else if (clasificacion.equals(Clasificacion.HOSPEDAJE)) {
            Hospedaje nuevoHospedaje = new Hospedaje();
            nuevoHospedaje.setNombre(nombre);
            nuevoHospedaje.setClasificacionProveedor(clasificacion);
            nuevoHospedaje.setImporteBase(importeBase);
            nuevoHospedaje.setCant_minClientes(cant_minima);
            listaProveedores.add(nuevoHospedaje);
        } else if (clasificacion.equals(Clasificacion.EXCURSION)) {
            GuiasTuristicos nuevoGuiaTuristico = new GuiasTuristicos();
            nuevoGuiaTuristico.setNombre(nombre);
            nuevoGuiaTuristico.setClasificacionProveedor(clasificacion);
            nuevoGuiaTuristico.setImporteBase(importeBase);
            listaProveedores.add(nuevoGuiaTuristico);
        }
    }



    public void registroPaqueteTurismo(String nombre_paquete, String destino, String proveedor1, Clasificacion clasificacionProv1, String proveedor2,Clasificacion clasificacionProv2, String proveedor3, Clasificacion clasificacionProv3 , int cantMaximaClientes){
        PaqueteTurismo nuevoPaquete = new PaqueteTurismo();
        nuevoPaquete.setNombre_paquete(nombre_paquete);
        nuevoPaquete.setDestino(destino);
        nuevoPaquete.setCantClientesMax(cantMaximaClientes);
        Proveedores proveedorAux;
        for (int i = 0; i < listaProveedores.size(); i++){
            proveedorAux = listaProveedores.get(i);
            if (proveedor1.equals(proveedorAux.getNombre()) && clasificacionProv1.equals(proveedorAux.getClasificacionProveedor())){
                nuevoPaquete.agregarProveedorDelPaquete(proveedorAux);
            } else if (proveedor2.equals(proveedorAux.getNombre()) && clasificacionProv2.equals(proveedorAux.getClasificacionProveedor())) {
                nuevoPaquete.agregarProveedorDelPaquete(proveedorAux);
            } else if (proveedor3.equals(proveedorAux.getNombre()) && clasificacionProv3.equals(proveedorAux.getClasificacionProveedor())) {
                nuevoPaquete.agregarProveedorDelPaquete(proveedorAux);
            }
        }
    }

    public void mostrarPaquetesTurismo(){
        PaqueteTurismo paqueteAux;
        System.out.println("_________________________________PAQUETES_DE_TURISMO______________________________");
        for (int i = 0; i < paquetesDeTurismo.size(); i++){
            paqueteAux = paquetesDeTurismo.get(i);
            System.out.println("Nombre del paquete: " + paqueteAux.getNombre_paquete() + " | Destino: " + paqueteAux.getDestino() + " | Cantidad maxima de clientes: " + paqueteAux.getCantClientesMax());
            System.out.println("Proveedores: ");
            Proveedores proveedorAux;
            for (int j = 0; j < paqueteAux.getProveedoresDelPaquete().size(); j++){
                proveedorAux = paqueteAux.getProveedoresDelPaquete().get(j);
                System.out.print((j + 1) + "- " + proveedorAux.getNombre() + " | ");
            }
            System.out.println("Clientes: ");
            if (paqueteAux.getCompradores().isEmpty()){
                System.out.println("Aun no hay clientes");
            }else {
                Clientes clienteAux;
                for (int j = 0; j < paqueteAux.getCompradores().size(); j++){
                    clienteAux = paqueteAux.getCompradores().get(j);
                    System.out.println((j + 1) + "-Nombre Completo: " + clienteAux.getNombre_apellido() + "DNI: " + clienteAux.getDNI() + " | ");
                }
            }
            System.out.println("___________________________________________________________________________");
        }

    }

    public void mostrarComprasClientes(){
        Clientes clienteAux;
        Compra compraAux;
        System.out.println("____________________________CLIENTES___________________________________");
        for (int i = 0; i < listaClientes.size(); i++){
            clienteAux = listaClientes.get(i);
            System.out.println("Nombre completo: " + clienteAux.getNombre_apellido() + " | DNI: " + clienteAux.getDNI() + " | Cantidad de compras: " + clienteAux.getCant_compras() + " | Destino Favorito: " + clienteAux.getDestino_fav());
            System.out.println("Compras: ");
            for (int j = 0; j < clienteAux.getComprasCliente().size(); j++){
                compraAux = clienteAux.getComprasCliente().get(j);
                System.out.println((j + 1) + "- Paquete Comprado: " + compraAux.getNombre_paquete() + " | Precio: " + compraAux.getPrecioFinal() + " | Fecha: " + compraAux.getFechaCompra());
            }
            System.out.println("___________________________________________________________________________");
        }
    }

    public void informeVentasXDestino(){
        System.out.println("Informe del mes: ");
        PaqueteTurismo paqueteAux;
        Clientes clienteAux;
        Compra compraAux;
        System.out.println("_____________________________________VENTAS___________________________________");
        for (int i = 0; i < paquetesDeTurismo.size(); i++){
            paqueteAux = paquetesDeTurismo.get(i);
            System.out.println("Paquete: " + paqueteAux.getNombre_paquete());
            System.out.println("___________________________________________________________________________");
            for (int j = 0; j < listaClientes.size(); j++){
                clienteAux = paqueteAux.getCompradores().get(j);
                for (int k = 0; k < clienteAux.getComprasCliente().size(); k++){
                    compraAux = clienteAux.getComprasCliente().get(k);
                    if (compraAux.getNombre_paquete().equals(paqueteAux.getNombre_paquete()) && compraAux.getFechaCompra().getMonth().equals(LocalDate.now().getMonth())){
                        System.out.println("Comprador: " + clienteAux.getNombre_apellido() + " | DNI: " + clienteAux.getDNI() +
                                " | Precio Final: " + compraAux.getPrecioFinal() + " | Fecha: " + compraAux.getFechaCompra());
                        System.out.println("___________________________________________________________________________");
                    }
                }
            }
        }
    }

    public void informeProveedores(){
        Proveedores proveedorAux;
        System.out.println("_____________________________PROVEEDORES____________________________");
        for (int i = 0; i < listaProveedores.size(); i++){
            proveedorAux = listaProveedores.get(i);
            System.out.println("Nombre: " + proveedorAux.getNombre() + " | Clasificacion: " + proveedorAux.getClasificacionProveedor() + " | Importe Base: " + proveedorAux.getImporteBase());
            System.out.println("___________________________________________________________________________");
        }
    }

}
