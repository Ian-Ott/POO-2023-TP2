package ar.edu.unlu.poo.estaciondeservicio.ejercicio6;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ModuloInformes {
    private ArrayList<Empleado> empleados = new ArrayList<>();
    private ArrayList<Expendedor> listaExpendedores = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Venta> listaVentas = new ArrayList<>();

    public void nuevoEmpleado(String nombre, String apellido, String direccion, String DNI, String telefono){
        Empleado nuevo_empleado = new Empleado();
        nuevo_empleado.setNombre(nombre);
        nuevo_empleado.setApellido(apellido);
        nuevo_empleado.setDireccion(direccion);
        nuevo_empleado.setDNI(DNI);
        nuevo_empleado.setTelefono(telefono);
        empleados.add(nuevo_empleado);
    }

    public void agregarExpendedor(int codigo, String combustible, double PrecioVenta){
        Expendedor nuevo_expendedor = new Expendedor();
        nuevo_expendedor.setCodigo(codigo);
        Combustible tipo_combustible = new Combustible();
        tipo_combustible.setNombre(combustible);
        tipo_combustible.setPrecioVenta(PrecioVenta);
        nuevo_expendedor.setTipoCombustible(tipo_combustible);
        listaExpendedores.add(nuevo_expendedor);
    }
    public void nueva_compra(String nombre_apellido, String DNI, String patente, int expendedor, String nombrePlayero, double cant_litros){
        boolean es_cliente = false;
        Cliente clienteActual = null;
        for (int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).getNombre_apellido().equals(nombre_apellido) && clientes.get(i).getDNI().equals(DNI)){
                if (clientes.get(i).getPatente().equals(patente)){
                    es_cliente = true;
                    clienteActual = clientes.get(i);
                }
            }
        }
        if (!es_cliente){
            clienteActual = nuevoCliente(nombre_apellido, DNI, patente);
        }
        Venta nueva_venta = new Venta();
        nueva_venta.setComprador(clienteActual);
        nueva_venta.setLitrosExpendidos(cant_litros);
        nueva_venta.setFechaHora(LocalDateTime.now());
        for (int i = 0; i < listaExpendedores.size(); i++){
            if (listaExpendedores.get(i).getCodigo() == expendedor){
                double total_venta = cant_litros * listaExpendedores.get(i).getTipoCombustible().getPrecioVenta();
                nueva_venta.setImporteTotal(total_venta);
                nueva_venta.setExpendedorUsado(listaExpendedores.get(i));
            }
        }
        for (int i = 0; i < empleados.size(); i++){
            if (empleados.get(i).getNombre().equals(nombrePlayero)){
                nueva_venta.setPlayeroAfectado(empleados.get(i));
                empleados.get(i).agregarNuevaVenta(nueva_venta);
                listaVentas.add(nueva_venta);
            }
        }

    }
    private Cliente nuevoCliente(String nombre_apellido, String DNI, String patente){
        Cliente nuevo_cliente = new Cliente();
        nuevo_cliente.setNombre_apellido(nombre_apellido);
        nuevo_cliente.setDNI(DNI);
        nuevo_cliente.setPatente(patente);
        clientes.add(nuevo_cliente);
        return nuevo_cliente;
    }

   public void informeTop10Clientes(){
       List<Cliente> listaClientes = new ArrayList<>();
       calcularTotalesClientes();
           for (int i = 0; i < clientes.size();i++){
               if (!listaClientes.contains(clientes.get(i))){
                   insertarOrdenMayorVentaCliente(listaClientes, clientes.get(i));
               }
           }
       mostrarTop10(listaClientes);
   }

    private void insertarOrdenMayorVentaCliente(List<Cliente> listaClientes, Cliente cliente) {
        if (listaClientes.isEmpty()){
            listaClientes.add(cliente);
        }else {
        for (int i = 0; i < listaClientes.size(); i++){
            if (listaClientes.get(i).getTotalGastado() < cliente.getTotalGastado()){
                listaClientes.add(i,cliente);
                return;
            }
        }
        listaClientes.add(cliente);
        }
    }

    private void mostrarTop10(List<Cliente> listaClientes) {
        System.out.println("Top 10 clientes de la estacion de servicio: ");
        for (int i = 0; i < 10; i++){
            System.out.println((i + 1) + "- " + "nombre y apellido: " + listaClientes.get(i).getNombre_apellido() + " | DNI: " + listaClientes.get(i).getDNI() + " | Patente: " + listaClientes.get(i).getPatente() + " | Total gastado: " + listaClientes.get(i).getTotalGastado());
        }
    }

    private void calcularTotalesClientes() {
        double totalCliente;
        for (int i = 0; i < clientes.size(); i++){
            totalCliente = 0.0d;
            for (int j = 0; j < listaVentas.size(); j++){
                if (listaVentas.get(j).getComprador().getDNI().equals(clientes.get(i).getDNI())){
                    totalCliente += listaVentas.get(j).getImporteTotal();
                }
            }
            clientes.get(i).setTotalGastado(totalCliente);
        }
    }

    public void informeVentasXCombustible(){
        List<Combustible> listaCombustibles;
        calcularTotalesSurtidores();
        listaCombustibles = generarListaXCombustible();
        for (int i = 0; i < listaCombustibles.size(); i++){
            Combustible actual = listaCombustibles.get(i);
            System.out.println("Tipo de Combustible: " + actual.getNombre() + " | Precio de venta: " + actual.getPrecioVenta() +
                    "$ | Total recaudado: " + actual.getTotalVentasXcombustible());
        }
   }

    private List<Combustible> generarListaXCombustible() {
        List<Combustible> lista = new ArrayList<>();
        boolean estaEnLaLista;
        for (int i = 0; i < listaExpendedores.size(); i++){
            estaEnLaLista = false;
            if (lista.isEmpty()){
                agregarCombustible(lista, listaExpendedores.get(i));
            }else {
                for (int j = 0; j < lista.size(); j++){
                    if (lista.get(j).getNombre().contains(listaExpendedores.get(i).getTipoCombustible().getNombre())){
                        estaEnLaLista = true;
                        lista.get(j).sumarTotalVentasXcombustible(listaExpendedores.get(i).getTotalVentas());
                    }
                }
                if (!estaEnLaLista){
                    agregarCombustible(lista, listaExpendedores.get(i));
                }
            }
        }
        return lista;
    }

    private void agregarCombustible(List<Combustible> lista, Expendedor expendedor) {
        Combustible nuevo = new Combustible();
        nuevo.setNombre(expendedor.getTipoCombustible().getNombre());
        nuevo.setPrecioVenta(expendedor.getTipoCombustible().getPrecioVenta());
        nuevo.sumarTotalVentasXcombustible(expendedor.getTotalVentas());
        lista.add(nuevo);
    }

    private void mostrarListaSurtidor(List<Expendedor> listaSurtidores) {
        for (int i = 0; i < listaSurtidores.size(); i++){
            System.out.println("Surtidor: "+ listaSurtidores.get(i).getCodigo() + " | Tipo de combustible: " + listaSurtidores.get(i).getTipoCombustible().getNombre() +
                    " | Precio de venta: " + listaSurtidores.get(i).getTipoCombustible().getPrecioVenta() + "$ | Total recaudado: " + listaSurtidores.get(i).getTotalVentas() +
                    "$ | Total de litros: "  + listaSurtidores.get(i).getTipoCombustible().getTotalLitros());
        }
    }

    private void insertarOrdenMayorVentaSurtidor(List<Expendedor> listaSurtidores, Expendedor expendedor) {
        if (listaSurtidores.isEmpty()){
            listaSurtidores.add(expendedor);
        }else {
        for (int i = 0; i < listaSurtidores.size(); i++){
            if (expendedor.getTotalVentas() > listaSurtidores.get(i).getTotalVentas()){
                listaSurtidores.add(i,expendedor);
                return;
            }
        }
            listaSurtidores.add(expendedor);
        }
    }

    public void informeVentasXSurtidor(){
        List<Expendedor> listaSurtidores = new ArrayList<>();
        calcularTotalesSurtidores();
        for (int i = 0; i < listaExpendedores.size(); i++){
            if(!listaSurtidores.contains(listaExpendedores.get(i))){
                insertarOrdenMayorVentaSurtidor(listaSurtidores, listaExpendedores.get(i));
            }
        }
        System.out.println("Lista de surtidores ordenados por su total de ventas: ");
        mostrarListaSurtidor(listaSurtidores);
   }

    private void calcularTotalesSurtidores() {
        double totalSurtidorVenta;
        double totalLitros;
        for (int i = 0; i < listaExpendedores.size(); i++){
            totalSurtidorVenta = 0.0d;
            totalLitros = 0.0d;
            for (int j = 0; j < listaVentas.size(); j++){
                if (listaVentas.get(j).getExpendedorUsado().getCodigo() == listaExpendedores.get(i).getCodigo()){
                    totalSurtidorVenta += listaVentas.get(j).getImporteTotal();
                    totalLitros += listaVentas.get(j).getLitrosExpendidos();
                }
            }
            listaExpendedores.get(i).setTotalVentas(totalSurtidorVenta);
            listaExpendedores.get(i).getTipoCombustible().setTotalLitros(totalLitros);
        }
    }

    public void litrosXSurtidor(){
        calcularTotalesSurtidores();
       List<Expendedor> listaSurtidores = new ArrayList<>();
       for (int i = 0; i < listaExpendedores.size(); i++){
           if(!listaSurtidores.contains(listaExpendedores.get(i))){
               insertarOrdenMayorLitrosSurtidor(listaSurtidores, listaExpendedores.get(i));
           }
       }
       System.out.println("Lista de surtidores ordenados por su cantidad de litros expendidos: ");
       mostrarListaSurtidor(listaSurtidores);

   }

    private void insertarOrdenMayorLitrosSurtidor(List<Expendedor> listaSurtidores, Expendedor expendedor) {
        boolean agregado = false;
        if (listaSurtidores.isEmpty()){
            listaSurtidores.add(expendedor);
        }else{
        for (int i = 0; i < listaSurtidores.size(); i++){
            if (expendedor.getTipoCombustible().getTotalLitros() > listaSurtidores.get(i).getTipoCombustible().getTotalLitros()){
                listaSurtidores.add(i,expendedor);
                agregado = true;
                return;
            }
        }
        listaSurtidores.add(expendedor);
        }
    }

    public void informeVentasXEmpleado(){
        calcularTotalesEmpleado();
        List<Empleado> listaEmpleados = new ArrayList<>();
        for (int i = 0; i < empleados.size(); i++){
            if(!listaEmpleados.contains(empleados.get(i))){
                insertarOrdenMayorVentaEmpleados(listaEmpleados, empleados.get(i));
            }
        }
        System.out.println("Lista de empleados ordenados por su total de ventas: ");
        mostrarListaEmpleados(listaEmpleados);
   }

    private void mostrarListaEmpleados(List<Empleado> listaEmpleados) {
        Empleado empleadoAux;
        for (int i = 0; i < listaEmpleados.size();i++){
            empleadoAux = listaEmpleados.get(i);
            System.out.println((i+1) + "- nombre-apellido: " + empleadoAux.getNombre() + " " + empleadoAux.getApellido() +
                    " | DNI: " + empleadoAux.getDNI() + " | Total de ventas: " + empleadoAux.getTotalVentasEmpleado());
        }
    }

    private void insertarOrdenMayorVentaEmpleados(List<Empleado> listaEmpleados, Empleado empleado) {
        if (listaEmpleados.isEmpty()){
            listaEmpleados.add(empleado);
        }else {
        for (int i = 0; i < listaEmpleados.size(); i++){
            if (empleado.getTotalVentasEmpleado() > listaEmpleados.get(i).getTotalVentasEmpleado()){
                listaEmpleados.add(i,empleado);
                return;
            }
        }
        listaEmpleados.add(empleado);
        }
    }

    private void calcularTotalesEmpleado() {
        double totalVentasEmpleado;
        for (int i = 0; i < empleados.size(); i++){
            totalVentasEmpleado = 0F;
            for (int j = 0; j < listaVentas.size(); j++){
                if (listaVentas.get(j).getPlayeroAfectado().getDNI().equals(empleados.get(i).getDNI())){
                    totalVentasEmpleado += listaVentas.get(j).getImporteTotal();
                }
            }
            empleados.get(i).setTotalVentasEmpleado(totalVentasEmpleado);
        }
    }
}
