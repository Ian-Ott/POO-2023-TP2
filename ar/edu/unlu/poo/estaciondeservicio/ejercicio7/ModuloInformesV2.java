package ar.edu.unlu.poo.estaciondeservicio.ejercicio7;

import ar.edu.unlu.poo.estaciondeservicio.ejercicio6.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ModuloInformesV2 {
    private ArrayList<EmpleadoV2> empleados = new ArrayList<>();
    private ArrayList<Expendedor> listaExpendedores = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<VentaV2> listaVentas = new ArrayList<>();

    public void nuevoEmpleado(String nombre, String apellido, String direccion, String DNI, String telefono){
        EmpleadoV2 nuevo_empleado = new EmpleadoV2();
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

    //cambios en nueva_compra
    public void nueva_compra(String nombre_apellido, String DNI, String patente, int expendedor, String nombrePlayero, double cant_litros, LocalDateTime fechahora, boolean descuentoPlayero){
        boolean es_cliente = false;
        Cliente clienteActual = null;
        calcularTotalesMesClientes(LocalDate.now().minusMonths(1).getMonth());
        List<Cliente> listaTop10 = new ArrayList<>();
        ordenarTop10MesCliente(listaTop10);

        clienteActual = buscarOcrearCliente(nombre_apellido,DNI,patente,es_cliente);
        VentaV2 nueva_venta = new VentaV2();
        nueva_venta.setComprador(clienteActual);
        nueva_venta.setLitrosExpendidos(cant_litros);
        nueva_venta.setFechaHora(fechahora);
        for (int i = 0; i < listaExpendedores.size(); i++){
            if (listaExpendedores.get(i).getCodigo() == expendedor){
                double total_venta = 0.0;
                if (es_top10Cliente(listaTop10, clienteActual)){
                    total_venta = cant_litros * listaExpendedores.get(i).getTipoCombustible().getPrecioVenta();
                    total_venta -= total_venta * 0.05;
                    //por ser uno de los clientes top 10 del mes anterior se le da un descuento del 5%
                }else {
                    total_venta = cant_litros * listaExpendedores.get(i).getTipoCombustible().getPrecioVenta();
                }
                if (descuentoPlayero) {
                    if (tiene_descuento(nombrePlayero)){
                        //si el playero quiere dar descuento se verifica que sea top10 y se lo da en caso que lo sea
                        total_venta -= total_venta * 0.10;
                        sacar_descuento(nombrePlayero);
                    }
                }
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

    private Cliente buscarOcrearCliente(String nombre_apellido, String DNI, String patente, boolean es_cliente) {
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
        return clienteActual;
    }

    //nuevo
    private boolean tiene_descuento(String nombrePlayero) {
        List<EmpleadoV2> listaTop10 = new ArrayList<>();
        ordenarTop10MesEmpleado(listaTop10);
        boolean resultado = false;
        for (int i = 0;i < empleados.size();i++){
            if (nombrePlayero.equals(empleados.get(i).getNombre())){
                if (empleados.get(i).getPuedeDarDescuentos() && es_top10Empleado(listaTop10,nombrePlayero)){
                    resultado = true;
                }
            }
        }
        return resultado;
    }

    //nuevo
    private boolean es_top10Empleado(List<EmpleadoV2> listaTop10, String nombrePlayero) {
        boolean resultado = false;
        for (int i = 0; i < 10;i++){
            if (listaTop10.size() > i){
                if (listaTop10.get(i).getNombre().equals(nombrePlayero)){
                    resultado = true;
                }
            }
        }
        return resultado;
    }

    //nuevo
    private void sacar_descuento(String nombrePlayero) {
        for (int i = 0;i < empleados.size();i++){
            if (nombrePlayero.equals(empleados.get(i).getNombre())){
                empleados.get(i).setPuedeDarDescuentos(false);
                //como solo puede dar descuento una unica vez se lo saco
            }
        }
    }

    //nuevo
    private void ordenarTop10MesCliente(List<Cliente> listaClientes) {
        for (int i = 0; i < clientes.size();i++){
            if (!listaClientes.contains(clientes.get(i))){
                insertarOrdenMayorVentaCliente(listaClientes, clientes.get(i));
            }
        }
    }

    //nuevo
    private boolean es_top10Cliente(List<Cliente> listaTop10, Cliente clienteActual) {
        boolean resultado = false;
        Cliente clienteAux;
        if (!listaTop10.isEmpty()) {
            for (int i = 0; i < 10;i++){
                if (listaTop10.size() > i){
                    clienteAux = listaTop10.get(i);
                    if (clienteAux.equals(clienteActual)){
                        resultado = true;
                    }
                }
            }
        }
        return resultado;
    }

    private Cliente nuevoCliente(String nombre_apellido, String DNI, String patente){
        Cliente nuevo_cliente = new Cliente();
        nuevo_cliente.setNombre_apellido(nombre_apellido);
        nuevo_cliente.setDNI(DNI);
        nuevo_cliente.setPatente(patente);
        clientes.add(nuevo_cliente);
        return nuevo_cliente;
    }

    //cambios
    public void informeTop10Clientes(Month mes){
        List<Cliente> listaClientes = new ArrayList<>();
        calcularTotalesMesClientes(mes);
        ordenarTop10MesCliente(listaClientes);
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

    //nuevo
    private void mostrarTop10(List<Cliente> listaClientes) {
        System.out.println("Top 10 clientes de la estacion de servicio: ");
        for (int i = 0; i < 10; i++){
            if (listaClientes.get(i).getTotalGastado() != 0){
                System.out.println((i + 1) + "- " + "nombre y apellido: " + listaClientes.get(i).getNombre_apellido() + " | DNI: " + listaClientes.get(i).getDNI() + " | Patente: " + listaClientes.get(i).getPatente() + " | Total gastado: " + listaClientes.get(i).getTotalGastado());
            }else {
                System.out.println("______________No hay mas clientes que hayan comprado este mes..._______________");
                return;
            }
        }
    }

    //cambios aca
    private void calcularTotalesMesClientes(Month mes) {
        double totalCliente;
        for (int i = 0; i < clientes.size(); i++){
            totalCliente = 0.0d;
            for (int j = 0; j < listaVentas.size(); j++){
                if (listaVentas.get(j).getComprador().getDNI().equals(clientes.get(i).getDNI())){
                    if (listaVentas.get(j).getFechaHora().getMonth().equals(mes)){
                        totalCliente += listaVentas.get(j).getImporteTotal();
                    }
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
        if (listaSurtidores.isEmpty()){
            listaSurtidores.add(expendedor);
        }else{
            for (int i = 0; i < listaSurtidores.size(); i++){
                if (expendedor.getTipoCombustible().getTotalLitros() > listaSurtidores.get(i).getTipoCombustible().getTotalLitros()){
                    listaSurtidores.add(i,expendedor);
                    return;
                }
            }
            listaSurtidores.add(expendedor);
        }
    }

    //cambios
    public void informeVentasXEmpleado(Month mes, boolean permitir_descuento){
        calcularTotalesMesEmpleado(mes);
        List<EmpleadoV2> listaEmpleados = new ArrayList<>();
        ordenarTop10MesEmpleado(listaEmpleados);
        if (permitir_descuento){
            dar_Descuento(listaEmpleados);
        }
        System.out.println("Lista de empleados ordenados por su total de ventas: ");
        mostrarListaEmpleados(listaEmpleados);
    }

    private void dar_Descuento(List<EmpleadoV2> listaEmpleados) {
        for (int i = 0; i < 10; i++){
            if (listaEmpleados.size() > i) {
                listaEmpleados.get(i).setPuedeDarDescuentos(true);
            }
        }
    }

    private void ordenarTop10MesEmpleado(List<EmpleadoV2> listaEmpleados) {
        for (int i = 0; i < empleados.size(); i++){
            if(!listaEmpleados.contains(empleados.get(i))){
                insertarOrdenMayorVentaEmpleados(listaEmpleados, empleados.get(i));
            }
        }
    }

    private void mostrarListaEmpleados(List<EmpleadoV2> listaEmpleados) {
        EmpleadoV2 empleadoAux;
        for (int i = 0; i < listaEmpleados.size();i++){
            empleadoAux = listaEmpleados.get(i);
            System.out.println((i+1) + "- nombre-apellido: " + empleadoAux.getNombre() + " " + empleadoAux.getApellido() +
                    " | DNI: " + empleadoAux.getDNI() + " | Total de ventas: " + empleadoAux.getTotalVentasEmpleado() + " | Tiene descuento: " + empleadoAux.getPuedeDarDescuentos());
        }
    }

    private void insertarOrdenMayorVentaEmpleados(List<EmpleadoV2> listaEmpleados, EmpleadoV2 empleado) {
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

    private void calcularTotalesMesEmpleado(Month mes) {
        double totalVentasEmpleado;
        for (int i = 0; i < empleados.size(); i++){
            totalVentasEmpleado = 0.0d;
            for (int j = 0; j < listaVentas.size(); j++){
                if (listaVentas.get(j).getPlayeroAfectado().getDNI().equals(empleados.get(i).getDNI())){
                    totalVentasEmpleado += listaVentas.get(j).getImporteTotal();
                }
            }
            empleados.get(i).setTotalVentasEmpleado(totalVentasEmpleado);
        }
    }
    public void cambiar_precioCombustible(String nombreCombustible, double nuevoPrecioUnitario){
        Combustible combustibleAux;
        for (int i = 0; i < listaExpendedores.size();i++){
            combustibleAux = listaExpendedores.get(i).getTipoCombustible();
            if (combustibleAux.getNombre().equals(nombreCombustible)){
                combustibleAux.setPrecioVenta(nuevoPrecioUnitario);
            }
        }
    }
}
