package ar.edu.unlu.poo.organizacion;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class App {
    private ArrayList<Empleado> listaEmpleados = new ArrayList<>();

    public void agregarEmpleadoAsalariado(String nombre_apellido, String telefono, String CUIT, LocalDate fechaCumpleanios, Float sumaFijaMensual){
        EmpleadoAsalariado nuevo_empleado = new EmpleadoAsalariado();
        nuevo_empleado.setNombre_apellido(nombre_apellido);
        nuevo_empleado.setTelefono(telefono);
        nuevo_empleado.setCUIT(CUIT);
        nuevo_empleado.setFechaCumpleanios(fechaCumpleanios);
        nuevo_empleado.setSumaFijaMensual(sumaFijaMensual);
        listaEmpleados.add(nuevo_empleado);
    }

    public void agregarEmpleadoXComision(String nombre_apellido, String telefono, String CUIT, LocalDate fechaCumpleanios, Double cant_ventas,Float porcentajeFijo){
        EmpleadoXComision nuevo_empleado = new EmpleadoXComision();
        nuevo_empleado.setNombre_apellido(nombre_apellido);
        nuevo_empleado.setTelefono(telefono);
        nuevo_empleado.setCUIT(CUIT);
        nuevo_empleado.setFechaCumpleanios(fechaCumpleanios);
        nuevo_empleado.setCant_ventas(cant_ventas);
        nuevo_empleado.setPorcentajeFijo(porcentajeFijo);
        listaEmpleados.add(nuevo_empleado);
    }

    public void agregarEmpleadoXComisionConSalario(String nombre_apellido, String telefono, String CUIT, LocalDate fechaCumpleanios, Double cant_ventas,Float porcentajeFijo, Double montoFijo){
        EmpleadoXComisionConSalario nuevo_empleado = new EmpleadoXComisionConSalario();
        nuevo_empleado.setNombre_apellido(nombre_apellido);
        nuevo_empleado.setTelefono(telefono);
        nuevo_empleado.setCUIT(CUIT);
        nuevo_empleado.setFechaCumpleanios(fechaCumpleanios);
        nuevo_empleado.setCant_ventas(cant_ventas);
        nuevo_empleado.setPorcentajeFijo(porcentajeFijo);
        nuevo_empleado.setMontoFijo(montoFijo);
        listaEmpleados.add(nuevo_empleado);
    }

    public void agregarEmpleadoXHora(String nombre_apellido, String telefono, String CUIT, LocalDate fechaCumpleanios, Float sumaXhoraTotal, int cantHoras, Float sumaEstipulada, Month informacionMes){
        EmpleadoXHora nuevo_empleado = new EmpleadoXHora();
        nuevo_empleado.setNombre_apellido(nombre_apellido);
        nuevo_empleado.setTelefono(telefono);
        nuevo_empleado.setCUIT(CUIT);
        nuevo_empleado.setFechaCumpleanios(fechaCumpleanios);
        nuevo_empleado.setCantHoras(cantHoras);
        nuevo_empleado.setInformacionMes(informacionMes);
        nuevo_empleado.setSumaEstipulada(sumaEstipulada);
        nuevo_empleado.setSumaXhoraTotal(sumaXhoraTotal);
        listaEmpleados.add(nuevo_empleado);
    }

    public void agregarEmpleadoPasante(String nombre_apellido, String telefono, String CUIT, LocalDate fechaCumpleanios){
        Pasante nuevo_empleado = new Pasante();
        nuevo_empleado.setNombre_apellido(nombre_apellido);
        nuevo_empleado.setTelefono(telefono);
        nuevo_empleado.setCUIT(CUIT);
        nuevo_empleado.setFechaCumpleanios(fechaCumpleanios);
        listaEmpleados.add(nuevo_empleado);
    }
}
