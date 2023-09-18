package ar.edu.unlu.poo.estaciondeservicio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ModuloInformes {
    private ArrayList<Empleado> empleados = new ArrayList<>();
    private ArrayList<Expendedor> listaExpendedores = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Venta> listaVentas = new ArrayList<>();

    public void NuevoEmpleado(String nombre, String apellido, String direccion, String DNI, String telefono){
        Empleado nuevo_empleado = new Empleado();
        nuevo_empleado.setNombre(nombre);
        nuevo_empleado.setApellido(apellido);
        nuevo_empleado.setDireccion(direccion);
        nuevo_empleado.setDNI(DNI);
        nuevo_empleado.setTelefono(telefono);
        empleados.add(nuevo_empleado);
    }

    public void agregarExpendedor(int codigo, String combustible, Float PrecioVenta){
        Expendedor nuevo_expendedor = new Expendedor();
        nuevo_expendedor.setCodigo(codigo);
        Combustible tipo_combustible = new Combustible();
        tipo_combustible.setNombre(combustible);
        tipo_combustible.setPrecioVenta(PrecioVenta);
        nuevo_expendedor.setTipoCombustible(tipo_combustible);
        listaExpendedores.add(nuevo_expendedor);
    }
    public void nueva_compra(String nombre_apellido, String DNI, String patente, int expendedor, String nombrePlayero, Float cant_litros){
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
                nueva_venta.setImporteTotal(cant_litros * listaExpendedores.get(i).getTipoCombustible().getPrecioVenta());
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

   public void InformeTop10Clientes(){
       List<Cliente> listaClientes = new ArrayList<>();
       calcularTotalesClientes();
       Cliente mayorActual = null;
       Float importeMayorActual = 0F;
       for (int i = 0; i < 10; i++){
           for (int j = 0; j < clientes.size();j++){
               if (clientes.get(i).getTotalGastado() > importeMayorActual){
                   if (listaClientes.contains(clientes.get(i))){

                   }else {
                       mayorActual = clientes.get(i);
                       importeMayorActual = clientes.get(i).getTotalGastado();
                   }
               }
           }
           listaClientes.add(mayorActual);
       }
       mostrarTop10(listaClientes);
   }

    private void mostrarTop10(List<Cliente> listaClientes) {
        System.out.println("Top 10 clientes de la estacion de servicio: ");
        for (int i = 0; i < listaClientes.size(); i++){
            System.out.println(i + "- " + "nombre y apellido: " + listaClientes.get(i).getNombre_apellido() + " | DNI: " + listaClientes.get(i).getDNI() + " | Patente: " + listaClientes.get(i).getPatente() + " | Total gastado: " + listaClientes.get(i).getTotalGastado());
        }
    }

    private void calcularTotalesClientes() {
        Float totalCliente;
        for (int i = 0; i < clientes.size(); i++){
            totalCliente = 0F;
            for (int j = 0; j < listaVentas.size(); j++){
                if (listaVentas.get(j).getComprador().getDNI().equals(clientes.get(i).getDNI())){
                    totalCliente += listaVentas.get(j).getImporteTotal();
                }
            }
            clientes.get(i).setTotalGastado(totalCliente);
        }
    }

    public void InformeVentasXCombustible(){

   }

   public void InformeVentasXSurtidor(){

   }
   public void LitrosXSurtidor(){

   }

   public void InformeVentasXEmpleado(){

   }
}
