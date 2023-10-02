import ar.edu.unlu.poo.academia.Academia;
import ar.edu.unlu.poo.academia.CredencialAlumno;
import ar.edu.unlu.poo.academia.Nivel;
import ar.edu.unlu.poo.agencia.AgenciaTurismo;
import ar.edu.unlu.poo.agencia.Clasificacion;
import ar.edu.unlu.poo.agenciadeautomoviles.SistemaDeAgencia;
import ar.edu.unlu.poo.agenciadevuelo.modeloalternativo.SistemaDeGestionModificado;
import ar.edu.unlu.poo.agenciadevuelo.modelooriginal.*;
import ar.edu.unlu.poo.billetera.ejercicio12.BilleteraVirtualV3;
import ar.edu.unlu.poo.billetera.ejercicio4.BilleteraVirtual;
import ar.edu.unlu.poo.billetera.ejercicio5.BilleteraVirtualV2;
import ar.edu.unlu.poo.club.ClubFutbol;
import ar.edu.unlu.poo.club.Subscripciones;
import ar.edu.unlu.poo.estaciondeservicio.ejercicio6.ModuloInformes;
import ar.edu.unlu.poo.estaciondeservicio.ejercicio7.ModuloInformesV2;
import ar.edu.unlu.poo.figuras.Formas;
import ar.edu.unlu.poo.libro.NuevaBiblioteca;
import ar.edu.unlu.poo.libro.SocioBiblioteca;
import ar.edu.unlu.poo.organizacion.App;

import java.time.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ejemplos_ejerciciosMainTP2 {
    public static void main(String[] args){
        menuTP2();
        int opcion = seleccionar_opcion();
        switch (opcion){
            case 1:
                ejemplo_1();
                break;
            case 2:
                ejemplo_2();
                break;
            case 3:
                ejemplo_3();
                break;
            case 4:
                ejemplo_4();
                break;
            case 5:
                ejemplo_5();
                break;
            case 6:
                ejemplo_6();
                break;
            case 7:
                ejemplo_7();
                break;
            case 8:
                ejemplo_8();
                break;
            case 9:
                ejemplo_9();
                break;
            case 10:
                ejemplo_10();
                break;
            case 11:
                ejemplo_11();
                break;
            case 12:
                ejemplo_12();
                break;
            case 13:
                ejemplo_13();
                break;
            case 14:
                //ejemplo_14();
                break;
        }

    }

    private static void menuTP2(){
        System.out.println("POO 2023-Ejemplos de los ejercicios del TP 2: ");
        System.out.println("-Parte uno: Referencias e Instancias: ");
        System.out.println("1-Ejercicio 1 - Club de Futbol");
        System.out.println("2-Ejercicio 2 - Agencia de Turismo");
        System.out.println("3-Ejercicio 3 - Academia de Danzas");
        System.out.println("4-Ejercicio 4 - Billetera Virtual");
        System.out.println("5-Ejercicio 5 - Billetera Virtual V2");
        System.out.println("6-Ejercicio 6 - Estacion de Servicio");
        System.out.println("7-Ejercicio 7 - Estacion de Servicio V2");
        System.out.println("-Parte dos: Herencia y polimorfismo:");
        System.out.println("8-Ejercicio 8 - Biblioteca V2");
        System.out.println("9-Ejercicio 9 - Figuras Geometricas");
        System.out.println("10-Ejercicio 10 - App Empleados");
        System.out.println("11-Ejercicio 11 - Agencia de Vehiculos");
        System.out.println("12-Ejercicio 12 - Billetera Virtual V3");
        System.out.println("13-Ejercicio 13 - Empresa de Vuelos Comerciales");
        System.out.println("14-Ejercicio 14 - Agencia de Turismo V2");
        System.out.println("AVISO: VUELVA A EJECUTAR EL MAIN SI LUEGO QUIERE VER OTRO EJERCICIO");
    }

    private static int seleccionar_opcion() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        while(opcion <= 0 || opcion > 14){
            System.out.println("Seleccione una opcion:");
            opcion = sc.nextInt();
            if (opcion <= 0 || opcion > 14){
                menuTP2();
                System.out.println("OPCION INCORRECTA: Seleccione un numero entre 1-14");
            }
        }
        return opcion;
    }

    public static void ejemplo_1(){
        System.out.println("\nEjemplos del ejercicio 1:");
        System.out.println("Creo al objeto Club de futbol...");
        ClubFutbol nuevo_club = new ClubFutbol();
        System.out.println("inscribo a 10 nuevos socios...");
        nuevo_club.inscripcion("Pepe", "Planes", "45.225.211", 19, "11-1234-3421", "Micasa123", "soyPepito@gmail.com", Subscripciones.INTERMEDIA );
        nuevo_club.inscripcion("Jazmin", "Morales", "34.425.266", 34, "11-6664-5943", "Micasa231", "nosoyyo@gmail.com", Subscripciones.BASICA );
        nuevo_club.inscripcion("Juan", "Caballa", "30.675.232", 39, "11-164-4359", "Micasa223", "soyalguien@gmail.com", Subscripciones.INTERMEDIA );
        nuevo_club.inscripcion("Pedro", "Sosa", "40.212.142", 25, "11-3879-2754", "Micasa665", "pedrito123@gmail.com", Subscripciones.DESTACADA );
        nuevo_club.inscripcion("Axel", "Rodriguez", "39.367.431", 27, "11-6874-5732", "Micasa778", "este_esun_mail@gmail.com", Subscripciones.BASICA );
        nuevo_club.inscripcion("Lucas", "Garcia", "39.134.124", 28, "11-2798-6858", "Micasa543", "Lu_garcia@gmail.com", Subscripciones.INTERMEDIA );
        nuevo_club.inscripcion("Gonzalo", "Planes", "32.121.212", 37, "11-2858-7921", "Micasa986", "Gonza543@gmail.com", Subscripciones.DESTACADA );
        nuevo_club.inscripcion("Pablo", "Dominguez", "34.543.321", 35, "11-1278-9019", "Micasa194", "mellamopablo@gmail.com", Subscripciones.INTERMEDIA );
        nuevo_club.inscripcion("Florencia", "Planes", "35.279.299", 33, "11-1234-3769", "Micasa475", "Flor555@gmail.com", Subscripciones.BASICA );
        nuevo_club.inscripcion("Santiago", "Diaz", "43.925.911", 20, "11-1456-4457", "Micasa997", "Santi72@gmail.com", Subscripciones.INTERMEDIA );

        System.out.println("\n muestro el reporte mensual de usuarios inscriptos en septiembre... \n(en este caso deberia de mostrar todos porque se inscribieron hoy esos nuevos socios)");
        System.out.println("AVISO: si no muestra nada es porque esta probando el ejemplo en un mes que no es septiembre por lo que los alumnos seran creados con el mes actual que sea");
        nuevo_club.reporte_mensual(Month.SEPTEMBER);

        System.out.println("\nMuestro las actividades disponibles segun la subscripcion...");
        nuevo_club.actividades_sub(Subscripciones.BASICA);
        nuevo_club.actividades_sub(Subscripciones.INTERMEDIA);
        nuevo_club.actividades_sub(Subscripciones.DESTACADA);

        System.out.println("\n Muestro un listado de socios clasificados segun su subscripcion...");
        nuevo_club.mostrarPorOrdenSub();
    }
    public static void ejemplo_2(){
        System.out.println("\nEjemplos del ejercicio 2: ");
        System.out.println("Creo a la agencia de turismo...");
        AgenciaTurismo sunBeach = new AgenciaTurismo();
        System.out.println("agrego algunos proveedores...");
        sunBeach.nuevoProveedor("FlechaBus", "Compania Terrestre", Clasificacion.MEDIO_DE_TRANSPORTE);
        sunBeach.nuevoProveedor("Elitas travel", "Compania aerea", Clasificacion.MEDIO_DE_TRANSPORTE);
        sunBeach.nuevoProveedor("Paraiso Hotel", "Cadenas de hoteles", Clasificacion.HOSPEDAJE);
        sunBeach.nuevoProveedor("Hotel Kia Ora", "Compania de bungalos", Clasificacion.HOSPEDAJE);
        sunBeach.nuevoProveedor("GeoTour", "Compania de guias de turismo", Clasificacion.EXCURSION);
        sunBeach.nuevoProveedor("SafeTravel", "Compania de guias de turismo", Clasificacion.EXCURSION);

        System.out.println("Solicito el registro que contiene a los proveedores...");
        sunBeach.registrosProveedores();

        System.out.println("Creo los paquetes de turismo...");
        ArrayList<String> excursiones = new ArrayList<>();
        excursiones.add("Excursion en la montania (SafeTravel)");
        excursiones.add("Excursion por el lago (SafeTravel)");
        sunBeach.nuevoPaqueteTurismo("Paquete Deluxe", "Bariloche", "Colectivo (FlechaBus)", "Hotel (Paraiso Hotel)", excursiones);
        excursiones.clear();
        excursiones.add("Excursion por el mar (GeoTravel)");
        excursiones.add("Excursion por el lago (GeoTravel)");
        sunBeach.nuevoPaqueteTurismo("Paquete Premium", "Polinesia Francesa", "Avion (Elitas Travel)", "Hotel (hotel kia Ora)", excursiones);

        System.out.println("Solicito mostrar los paquetes de turismo...");
        sunBeach.mostrarPaquetesTurismo();

        System.out.println("Agrego nuevo clientes y realizo compras...");
        sunBeach.nueva_compra(false, "Pepito Morales", "34.783.436", "Polinesia Francesa", "Paquete Premium");
    }

    public static void ejemplo_3(){
        System.out.println("\nEjemplos del ejercicio 3: ");
        System.out.println("Creo la academia...");
        Academia academiaDanzas = new Academia();
        System.out.println("Creo algunas displinas con sus diagramacones y algunos profesores...");
        academiaDanzas.crearDisciplina("Tango", Nivel.INICIAL, "Lunes y viernes", "9:00 a 12:00", "Lorena", 3);
        academiaDanzas.crearDisciplina("Bachata", Nivel.INTERMEDIO,"Martes y Jueves", "17:00 a 20:00", "Diego", 7);
        academiaDanzas.crearDisciplina("Tango", Nivel.INTERMEDIO, "Martes y Jueves", "18:00 a 21:00", "Lorena",2);
        academiaDanzas.crearDisciplina("Tango", Nivel.AVANZADO, "Viernes y Sabado", "8:00 a 11:00", "Diego", 5);


        System.out.println("\nAhora inscribo a 10 alumnos a las distintas diagramaciones...");
        CredencialAlumno credencialJazmin = academiaDanzas.inscripcion(false, "Jazmin Morales", "34.656.785","11 2654-8879", "Tango", null,Nivel.INICIAL);
        CredencialAlumno credencialPablo = academiaDanzas.inscripcion(false, "Pablo Martinez", "45.353.275","11 5633-7961", "Tango", null,Nivel.INICIAL);
        CredencialAlumno credencialAlberto = academiaDanzas.inscripcion(false, "Alberto Dominguez", "22.566.454","11 1121-3419", "Bachata", null,Nivel.INTERMEDIO);
        CredencialAlumno credencialVioleta = academiaDanzas.inscripcion(false, "Violeta Guerra", "33.596.950","11 9564-1274", "Tango", null,Nivel.INTERMEDIO);
        CredencialAlumno credencialJonatan = academiaDanzas.inscripcion(false, "Jonatan Prada", "37.317.299","11 9044-2667", "Tango", null,Nivel.AVANZADO);
        CredencialAlumno credencialMirian = academiaDanzas.inscripcion(false, "Mirian Cabrera", "40.840.979","11 8506-7702", "Tango", null,Nivel.INTERMEDIO);
        CredencialAlumno credencialMaximo = academiaDanzas.inscripcion(false, "Maximo Nogales", "39.670.455","11 8784-2595", "Tango", null,Nivel.AVANZADO);
        CredencialAlumno credencialCamila = academiaDanzas.inscripcion(false, "Camila Perez", "36.719.459","11 7521-6401", "Tango", null,Nivel.INICIAL);
        CredencialAlumno credencialCamilo = academiaDanzas.inscripcion(false, "Camilo Caballa", "29.731.540","11 2012-7823", "Tango", null,Nivel.INICIAL);
        CredencialAlumno credencialMicaela = academiaDanzas.inscripcion(false, "Micaela Paez", "40.150.672","11 4141-6942", "Bachata", null,Nivel.INTERMEDIO);
        credencialJonatan = academiaDanzas.inscripcion(true, "Jonatan Prada", "37.317.299","11 9044-2667", "Bachata", credencialJonatan,Nivel.INTERMEDIO);
        credencialPablo = academiaDanzas.inscripcion(true, "Pablo Martinez", "45.353.275","11 5633-7961", "Bachata", credencialPablo,Nivel.INTERMEDIO);

        System.out.println("\nhago que algunos alumnos se registren para sus clases...");
        academiaDanzas.registrarse(credencialJazmin, "Tango", Nivel.INICIAL, LocalDate.of(2023,9,4));
        academiaDanzas.registrarse(credencialAlberto, "Bachata", Nivel.INTERMEDIO, LocalDate.of(2023,9,5));
        academiaDanzas.registrarse(credencialVioleta, "Tango", Nivel.INTERMEDIO, LocalDate.of(2023,9,12));
        academiaDanzas.registrarse(credencialJazmin, "Tango", Nivel.INICIAL, LocalDate.of(2023,9,4));
        academiaDanzas.registrarse(credencialPablo, "Bachata", Nivel.INTERMEDIO, LocalDate.of(2023,9,5));
        academiaDanzas.registrarse(credencialMirian, "Tango", Nivel.INTERMEDIO, LocalDate.of(2023,9,12));
        academiaDanzas.registrarse(credencialMaximo, "Tango", Nivel.AVANZADO, LocalDate.of(2023,9,29));
        academiaDanzas.registrarse(credencialCamila, "Tango", Nivel.INICIAL, LocalDate.of(2023,9,4));
        academiaDanzas.registrarse(credencialCamilo, "Tango", Nivel.INICIAL, LocalDate.of(2023,9,4));
        academiaDanzas.registrarse(credencialMicaela, "Bachata", Nivel.INTERMEDIO, LocalDate.of(2023,9,5));
        academiaDanzas.registrarse(credencialJonatan, "Tango", Nivel.AVANZADO, LocalDate.of(2023,9,29));
        academiaDanzas.registrarse(credencialMaximo, "Tango", Nivel.AVANZADO, LocalDate.of(2023,9,30));
        academiaDanzas.registrarse(credencialAlberto, "Bachata", Nivel.INTERMEDIO, LocalDate.of(2023,9,5));
        academiaDanzas.registrarse(credencialPablo, "Bachata", Nivel.INTERMEDIO, LocalDate.of(2023,10,10));
        academiaDanzas.registrarse(credencialMirian, "Tango", Nivel.INTERMEDIO, LocalDate.of(2023,9,14));
        academiaDanzas.registrarse(credencialAlberto, "Bachata", Nivel.INTERMEDIO, LocalDate.of(2023,9,7));
        academiaDanzas.registrarse(credencialMaximo, "Tango", Nivel.AVANZADO, LocalDate.of(2023,10,6));
        academiaDanzas.registrarse(credencialCamila, "Tango", Nivel.INICIAL, LocalDate.of(2023,9,3));
        academiaDanzas.registrarse(credencialJazmin, "Tango", Nivel.INICIAL, LocalDate.of(2023,9,3));
        academiaDanzas.registrarse(credencialPablo, "Bachata", Nivel.INTERMEDIO, LocalDate.of(2023,9,7));

        System.out.println("Muestro el listado del mes de septiembre para cada profesor...");
        academiaDanzas.listadoAlumnosAsistidos("Diego", Month.SEPTEMBER);
        academiaDanzas.listadoAlumnosAsistidos("Lorena", Month.SEPTEMBER);

        System.out.println("Muestro el reporte de la disciplina con mayor ingreso...");
        academiaDanzas.reporteMayorIngreso();
    }

    public static void ejemplo_4(){
        System.out.println("\nEjemplos del ejercicio 4:");
        System.out.println("\nCreo primero la billetera virtual...");
        BilleteraVirtual billeteraEjemplo = new BilleteraVirtual();
        System.out.println("Creo la cuenta de dos usuarios diferentes uno con cuenta credito y otro sin...");
        billeteraEjemplo.crear_cuenta("Jazmin", "12345678", 3000.0d, 1000.0d, 1000.0d, true );
        billeteraEjemplo.crear_cuenta("Pepe", "ContraseniaSegura", 1500.0d, 500.0d, null,false);
        System.out.println("\nMuestro el estado de la cuenta del usuario Jazmin...");
        billeteraEjemplo.mostrarEstadoCuenta("Jazmin", "12345678");
        System.out.println("\nMuestro el estado de la cuenta del usuario Pepe...");
        billeteraEjemplo.mostrarEstadoCuenta("Pepe", "ContraseniaSegura");
        System.out.println("\nLa usuario Jazmin ahora va a comprar con su cuenta credito ($1000)...");
        if (billeteraEjemplo.comprarUsandoCuentaCredito("Jazmin", "12345678", 1000.0d)){
            System.out.println("Compra Exitosa!!!");
        }
        System.out.println("\nMuestro el estado de Jazmin...");
        billeteraEjemplo.mostrarEstadoCuenta("Jazmin", "12345678");
        System.out.println("\nAhora realizo un pago de la compra realizada(paga $900)...");
        if (billeteraEjemplo.pagarUsandoCuentaCredito("Jazmin","12345678", 900.0d, 0)){
            System.out.println("Pago realizado!!");
        }
        System.out.println("\nMuestro el estado para ver como quedo el saldo deudor...");
        billeteraEjemplo.mostrarEstadoCuenta("Jazmin", "12345678");
        System.out.println("\nAhora el usuario Pepe va a hacer un gasto ($2000)...");
        billeteraEjemplo.realizarGastoCuenta("Pepe", "ContraseniaSegura", 2000.0d);
        System.out.println("\nComo ya sabe que va a girar en descubierto vuelve a intentar hacer el gasto igual...");
        if (billeteraEjemplo.realizarGastoYGirarCuenta("Pepe", "ContraseniaSegura", 2000.0d)){
            System.out.println("Se realizo el gasto correctamente!");
        }
        System.out.println("\nMuestro el estado de Pepe...");
        billeteraEjemplo.mostrarEstadoCuenta("Pepe", "ContraseniaSegura");
        System.out.println("\nAhora pruebo que deposite un monto de $1500...");
        billeteraEjemplo.depositarMontoCuenta("Pepe", "ContraseniaSegura",1500.0d);
        System.out.println("\nMuestro su estado...");
        billeteraEjemplo.mostrarEstadoCuenta("Pepe", "ContraseniaSegura");
        System.out.println("\nAhora pruebo a invertir un poco del saldo ($900)...");
        if (billeteraEjemplo.invertirMontoCuenta("Pepe", "ContraseniaSegura",900.0d)){
            System.out.println("Se invertio el monto correctamente!!!");
        }
        System.out.println("Muestro su estado...");
        billeteraEjemplo.mostrarEstadoCuenta("Pepe", "ContraseniaSegura");
        System.out.println("\nPor ultimo pruebo a recuperar el monto de la inversion");
        if (!billeteraEjemplo.recuperarMontoInvertidoCuenta("Pepe", "ContraseniaSegura")){
            System.out.println("No se puede recuperar el monto porque no han pasado la cantidad de dias necesarios");
        }
    }

    public static void ejemplo_5(){
        System.out.println("\nEjemplos del ejercicio 5:");
        System.out.println("Creo la billetera virtual con las nuevas implementaciones...");
        BilleteraVirtualV2 billeteraEjemploV2 = new BilleteraVirtualV2();
        System.out.println("\nCreo un unico usuario para probar lo nuevo sin cuenta credito ya que no hay nuevos metodos en cuenta credito aparte de los que tiene en el anterior ejercicio");
        billeteraEjemploV2.crear_cuenta("Jazmin", "12345678", 2000.0d,1000.0d,null,false);
        System.out.println("\nMuestro su estado...");
        billeteraEjemploV2.mostrarEstadoCuenta("Jazmin", "12345678");
        System.out.println("\nHago que invierta una parte de su saldo ($1500)...");
        if (billeteraEjemploV2.invertirMontoCuenta("Jazmin", "12345678", 1500)){
            System.out.println("Se invirtio correctamente!!!");
        }
        System.out.println("\nMuestro su estado...");
        billeteraEjemploV2.mostrarEstadoCuenta("Jazmin", "12345678");
        System.out.println("\nIntento realizar un gasto mayor al sueldo ($3000)...");
        billeteraEjemploV2.realizarGastoCuenta("Jazmin", "12345678",2500.0d);
        System.out.println("\nComo tiene una inversion se puede reducir el giro descubierto por lo que hago que gaste igual...");
        if (billeteraEjemploV2.realizarGastoYGirarCuenta("Jazmin", "12345678",2500.0d)){
            System.out.println("Se realizo el gasto correctamente!!!");
        }
        System.out.println("\nMuestro su estado...");
        billeteraEjemploV2.mostrarEstadoCuenta("Jazmin", "12345678");
        System.out.println("\nDeposito $1500 para tener saldo en la cuenta...");
        billeteraEjemploV2.depositarMontoCuenta("Jazmin", "12345678",1500.0d);
        System.out.println("\nMuestro el estado...");
        billeteraEjemploV2.mostrarEstadoCuenta("Jazmin", "12345678");
        System.out.println("\nInvierto $500 de su saldo...");
        if (billeteraEjemploV2.invertirMontoCuenta("Jazmin", "12345678",500.0d)){
            System.out.println("Se invertio correctamente!!!");
        }
        System.out.println("\nMuestro su estado...");
        billeteraEjemploV2.mostrarEstadoCuenta("Jazmin", "12345678");
        System.out.println("\nAhora cancelo la inversion");
        System.out.println("AVISO: como la inversion no fue hace 30 dias nisiquiera le va a dar un interes del 30% pero esa opcion esta implementada en el metodo");
        if (billeteraEjemploV2.cancelarInversionCuenta("Jazmin", "12345678")){
            System.out.println("Se cancelo correctamente la inversion!!!");
        }
        System.out.println("\nMuestro el estado...");
        billeteraEjemploV2.mostrarEstadoCuenta("Jazmin", "12345678");
        System.out.println("\nPregunta: ¿Se podría mejorar el diseño en términos de encapsulamiento/contrato?");
        System.out.println("Respuesta: En terminos de encapsulamiento no hay forma de mejorarlo ya que el sistema sigue manteniendo el encapsulamiento aun con los cambios implementados");
        System.out.println("\nPregunta: ¿Qué pasa con la cohesión y el acoplamiento?");
        System.out.println("Respuesta: Lo que pasa con la cohesion y el acoplamiento es que se mantiene igual a la del anterior ejercicio\nya que solo se agregaron un par de metodos a cada clase que lo necesitaba");
    }

    public static void ejemplo_6(){
        System.out.println("\nEjemplos del ejercicio 6: ");
        System.out.println("Creo el sistema de informes...");
        ModuloInformes estacionDeServicio = new ModuloInformes();
        System.out.println("\nAgrego a los empleados y los surtidores de la estacion de servicio...");
        estacionDeServicio.nuevoEmpleado("Pepe", "Dominguez", "MiCasa123", "34.556.793", "11 2541-8820");
        estacionDeServicio.nuevoEmpleado("Jazmin", "Garcia", "MiCasa341","40.764.725","11 8367-5612");
        estacionDeServicio.nuevoEmpleado("Lucas", "Gomez", "MiCasa923","34.447.159","11 3805-1292");

        estacionDeServicio.agregarExpendedor(1,"nafta",200.0d);
        estacionDeServicio.agregarExpendedor(2,"gasoil",100.0d);
        estacionDeServicio.agregarExpendedor(3,"kerosene", 50.0d);
        estacionDeServicio.agregarExpendedor(4,"gasoil", 100.0d);

        System.out.println("Creo algunos clientes y hago que realicen compras en la estacion de servicio...");
        estacionDeServicio.nueva_compra("Camila Rodriguez", "39.456.203","LHD 234", 1, "Jazmin", 40.0d);
        estacionDeServicio.nueva_compra("Santino Gimenez", "41.957.352", "FRY 884", 3, "Lucas", 60.0d);
        estacionDeServicio.nueva_compra("Valentin Da Rosa", "37.674.813", "PJK 764", 2, "Pepe", 50.0d);
        estacionDeServicio.nueva_compra("Juan Alberdi", "46.327.031", "HRT 426", 2, "Lucas", 55.0d);
        estacionDeServicio.nueva_compra("Julian Guerra", "33.589.472","PRU 925", 3, "Pepe", 45.0d);
        estacionDeServicio.nueva_compra("Maria Gonzalez", "43.610.732", "JWK 185", 1, "Jazmin",35.0d);
        estacionDeServicio.nueva_compra("Patricia Morales","38.754.561", "TYR 654", 1, "Pepe", 54.0d);
        estacionDeServicio.nueva_compra("Axel Nogales", "34.669.387", "PJT 749", 4, "Jazmin", 59.0d);
        estacionDeServicio.nueva_compra("Diana Martinez", "36.701.551", "LDR 219", 2,"Lucas", 54.0d);
        estacionDeServicio.nueva_compra("Lara Rodriguez", "37.834.253", "IRT 634", 1, "Jazmin", 39.0d);
        estacionDeServicio.nueva_compra("Renata Gonzales", "37.458.210", "LQT 655", 3, "Lucas", 56.0d);
        estacionDeServicio.nueva_compra("Pablo Paez", "28.916.318", "REH 615", 4, "Jazmin",35.0d);
        estacionDeServicio.nueva_compra("Leo Rodriguez", "41.639.573", "RFT 592", 3, "Lucas", 39.0d);
        estacionDeServicio.nueva_compra("Julian Guerra", "33.589.472","PRU 925", 3, "Jazmin", 30.0d);
        estacionDeServicio.nueva_compra("Axel Nogales", "34.669.387", "PJT 749", 4, "Pepe", 46.0d);
        estacionDeServicio.nueva_compra("Valentin Da Rosa", "37.674.813", "PJK 764", 2, "Pepe", 50.0d);

        System.out.println("\nAhora muestro un informe con el top 10 clientes de la estacion...");
        estacionDeServicio.informeTop10Clientes();

        System.out.println("\nAhora muestro el informe de ventas por combustible...");
        estacionDeServicio.informeVentasXCombustible();

        System.out.println("\nAhora muestro el informe de ventas por surtidor....");
        estacionDeServicio.informeVentasXSurtidor();

        System.out.println("\nAhora muestro los surtidores con su cantidad de litros totales...");
        estacionDeServicio.litrosXSurtidor();

        System.out.println("\nAhora muestro el informe de ventas por empleados...");
        estacionDeServicio.informeVentasXEmpleado();

        System.out.println("\nSe ha propuesto un nuevo diseño porque asi el cliente no conoce las ventas y ademas el empleado puede tener acceso mas facil a las ventas que realizo");
        System.out.println("Ademas el nuevo diseño tiene una lista de expendedores ya que el anterior diseño no cumplia lo propuesto o no era tan eficiente para tener los surtidores" +
                "\nEn cambio con este nuevo diseño se puede tener varios surtidores como se pide y encima organizados en una lista");
    }

    public static  void ejemplo_7(){
        System.out.println("\nEjemplos del ejercicio 7: ");
        System.out.println("Creo el sistema de informes...");
        ModuloInformesV2 estacionDeServicioV2 = new ModuloInformesV2();
        System.out.println("\nAgrego a los empleados y los surtidores de la estacion de servicio...");
        estacionDeServicioV2.nuevoEmpleado("Pepe", "Dominguez", "MiCasa123", "34.556.793", "11 2541-8820");
        estacionDeServicioV2.nuevoEmpleado("Jazmin", "Garcia", "MiCasa341","40.764.725","11 8367-5612");
        estacionDeServicioV2.nuevoEmpleado("Lucas", "Gomez", "MiCasa923","34.447.159","11 3805-1292");

        estacionDeServicioV2.agregarExpendedor(1,"nafta",200.0d);
        estacionDeServicioV2.agregarExpendedor(2,"gasoil",100.0d);
        estacionDeServicioV2.agregarExpendedor(3,"kerosene", 50.0d);
        estacionDeServicioV2.agregarExpendedor(4,"gasoil", 100.0d);

        System.out.println("Creo algunos clientes y hago que realicen compras en la estacion de servicio...");
        System.out.println("AVISO: las fechas de las compras seran establecidas para el dia 30/09/2023");
        estacionDeServicioV2.nueva_compra("Camila Rodriguez", "39.456.203","LHD 234", 1, "Jazmin", 40.0d, LocalDateTime.of(LocalDate.of(2023,9,30), LocalTime.NOON),false);
        estacionDeServicioV2.nueva_compra("Santino Gimenez", "41.957.352", "FRY 884", 3, "Lucas", 60.0d, LocalDateTime.of(LocalDate.of(2023,9,30), LocalTime.NOON),false);
        estacionDeServicioV2.nueva_compra("Valentin Da Rosa", "37.674.813", "PJK 764", 2, "Pepe", 50.0d, LocalDateTime.of(LocalDate.of(2023,9,30), LocalTime.NOON),false);
        estacionDeServicioV2.nueva_compra("Juan Alberdi", "46.327.031", "HRT 426", 2, "Lucas", 55.0d, LocalDateTime.of(LocalDate.of(2023,9,30), LocalTime.NOON),false);
        estacionDeServicioV2.nueva_compra("Julian Guerra", "33.589.472","PRU 925", 3, "Pepe", 45.0d, LocalDateTime.of(LocalDate.of(2023,9,30), LocalTime.NOON),false);
        estacionDeServicioV2.nueva_compra("Maria Gonzalez", "43.610.732", "JWK 185", 1, "Jazmin",35.0d, LocalDateTime.of(LocalDate.of(2023,9,30), LocalTime.NOON),false);
        estacionDeServicioV2.nueva_compra("Patricia Morales","38.754.561", "TYR 654", 1, "Pepe", 54.0d, LocalDateTime.of(LocalDate.of(2023,9,30), LocalTime.NOON),false);
        estacionDeServicioV2.nueva_compra("Axel Nogales", "34.669.387", "PJT 749", 4, "Jazmin", 59.0d, LocalDateTime.of(LocalDate.of(2023,9,30), LocalTime.NOON),false);
        estacionDeServicioV2.nueva_compra("Diana Martinez", "36.701.551", "LDR 219", 2,"Lucas", 54.0d, LocalDateTime.of(LocalDate.of(2023,9,30), LocalTime.NOON),false);
        estacionDeServicioV2.nueva_compra("Lara Rodriguez", "37.834.253", "IRT 634", 1, "Jazmin", 39.0d, LocalDateTime.of(LocalDate.of(2023,9,30), LocalTime.NOON),false);
        estacionDeServicioV2.nueva_compra("Renata Gonzales", "37.458.210", "LQT 655", 3, "Lucas", 56.0d, LocalDateTime.of(LocalDate.of(2023,9,30), LocalTime.NOON),false);
        estacionDeServicioV2.nueva_compra("Pablo Paez", "28.916.318", "REH 615", 4, "Jazmin",35.0d, LocalDateTime.of(LocalDate.of(2023,9,30), LocalTime.NOON),false);
        estacionDeServicioV2.nueva_compra("Leo Rodriguez", "41.639.573", "RFT 592", 3, "Lucas", 39.0d, LocalDateTime.of(LocalDate.of(2023,9,30), LocalTime.NOON),false);

        System.out.println("\nAhora muestro un informe con el top 10 clientes de septiembre de la estacion...");
        estacionDeServicioV2.informeTop10Clientes(Month.SEPTEMBER);

        System.out.println("\nMuestro el informe de venta de combustibles con su precio de venta unitario...");
        estacionDeServicioV2.informeVentasXCombustible();

        System.out.println("\nAhora aumento el precio unitario de los combustibles...");
        estacionDeServicioV2.cambiar_precioCombustible("nafta", 250.0d);
        estacionDeServicioV2.cambiar_precioCombustible("gasoil", 150.0d);
        estacionDeServicioV2.cambiar_precioCombustible("kerosene", 100.0d);

        System.out.println("\nMuestro de nuevo el informe para ver el precio unitario cambiado...");
        estacionDeServicioV2.informeVentasXCombustible();

        System.out.println("\nMuestro el informe de empleados y a los top 10 les otorgo el permiso de dar un descuento....");
        estacionDeServicioV2.informeVentasXEmpleado(Month.SEPTEMBER, true);

        System.out.println("\nMuestro el top 10 de clientes para ver cuales pueden recibir el descuento...");
        estacionDeServicioV2.informeTop10Clientes(Month.SEPTEMBER);

        System.out.println("\nHago la compra con la cliente Patricia (esta deberia de recibir un 5% de descuento por ser top 10)...");
        estacionDeServicioV2.nueva_compra("Patricia Morales","38.754.561", "TYR 654", 1, "Jazmin", 30.0d, LocalDateTime.of(LocalDate.of(2023,10,6), LocalTime.NOON),false);

        System.out.println("\nAhora hago la compra con el cliente Leo y el empleado Pepe va a otorgar un descuento del 10%...");
        estacionDeServicioV2.nueva_compra("Leo Rodriguez", "41.639.573", "RFT 592", 3, "Pepe", 50.0d, LocalDateTime.of(LocalDate.of(2023,10,6), LocalTime.NOON),true);

        System.out.println("\nComo Pepe otorgo el descuento ahora voy a mostrar el informe de empleados del mes de octubre sin otorgar un nuevo permiso de descuento para ver si pepe realmente otorgo el descuento...");
        estacionDeServicioV2.informeVentasXEmpleado(Month.OCTOBER,false);

        System.out.println("\nMuestro a los clientes del mes de octubre para ver si se aplicaron los descuentos...");
        estacionDeServicioV2.informeTop10Clientes(Month.OCTOBER);
        System.out.println("\nPregunta:  ¿Qué pasa si el dueño decide vender otros productos además de combustible? Como pueden ser: servicios de boxes, productos de limpieza para el auto, etc.");
        System.out.println("Respuesta: Lo que pasaria es que habria que crear una clase llamada productos y se tendria que usar herencia con cada tipo de producto que se desee para calcular el total de cada uno.");
    }


    public static void ejemplo_8(){
        System.out.println("\nEjemplo del ejercicio 8: ");
        System.out.println("NOTA: aunque no lo parezca la clase Publicaciones esta herendando los metodos de la biblioteca del tp1 solo que no los voy a usar para el ejemplo");
        System.out.println("Aunque algunos de los metodos del tp1 de biblioteca podria no funcionar porque publicaciones agrega nuevos atributos distintos");
        System.out.println("Creo la biblioteca...");
        NuevaBiblioteca biblioteca = new NuevaBiblioteca();

        System.out.println("\nagrego libros a la biblioteca... ");
        ArrayList<String> autores = new ArrayList<>();
        autores.add("Abraham Silberschatz");
        autores.add("Peter Baer Galvin");
        autores.add("Greg Gagne");
        biblioteca.agregar_libro("Fundamentos De Sistemas Operativos (7ma Edicion)", autores,"Carmelo Sanchez Gonzalez", "11 2367-1953", "Pepe", 5,"84-481-4641-7", "2005",828);
        autores.remove(2);
        autores.remove(1);
        autores.remove(0);
        autores.add("Carlo Collodi");
        biblioteca.agregar_libro("Las Aventuras De Pinocho",autores,"no tiene", "11 5701-6362", "Jazmin", 2, "23-256-7123-6", "1883",204);

        System.out.println("\nCreo socios de la biblioteca...");
        SocioBiblioteca socioLucas = biblioteca.agregarSocioBiblioteca("Lucas Gomez","34.674.462");
        SocioBiblioteca socioCamila = biblioteca.agregarSocioBiblioteca("Camila Rodriguez", "40.591.034");

        System.out.println("\nAhora presto dos ejemplares de libros a dos socios diferentes de la biblioteca...");
        biblioteca.prestar_ejemplar("Fundamentos De Sistemas Operativos (7ma Edicion)","Carmelo Sanchez Gonzalez",socioLucas,3);
        biblioteca.prestar_ejemplar("Fundamentos De Sistemas Operativos (7ma Edicion)","Carmelo Sanchez Gonzalez",socioCamila,5);

        System.out.println("\nMuestro la cantidad de ejemplares prestados por cada libro...");
        biblioteca.mostrar_cant_ejemplares();

        System.out.println("\nMuestro los ejemplares que fueron prestados...");
        biblioteca.mostrar_ejemplaresPrestados();

        System.out.println("\nDevuelvo un libro prestado...");
        biblioteca.devolverEjemplar(socioLucas);

        System.out.println("\nVuelvo a mostrar los ejemplares prestados...");
        biblioteca.mostrar_ejemplaresPrestados();

        System.out.println("Creo dos revistas diferentes...");
        biblioteca.agregar_revista("Historia Social", "Carmen", "11 5839-3778", "Jazmin", 3,"4525-8622", 2, "2020");
        biblioteca.agregar_revista("America Latina Hoy", "Jose", "11 6438-1194", "Pepe", 4,"6458-1538",3,"2023");

        System.out.println("\nEl socio Lucas ahora pide prestada una revista...");
        biblioteca.prestar_ejemplar("Historia Social","Carmen", socioLucas, 2);
        System.out.println("\nVuelvo a mostrar los ejemplares prestados...");
        biblioteca.mostrar_ejemplaresPrestados();

        System.out.println("\nAgrego una Tesis a la biblioteca...");
        biblioteca.agregarTesis("Tesis1", "Raul", "11 9846-7227","Pepe", 2,"Joaquin",LocalDate.of(2022,2,3));
        System.out.println("\nVuelve a pedir prestado otro ejemplar Lucas...");
        biblioteca.prestar_ejemplar("Tesis1", "Raul", socioLucas, 1);

        System.out.println("\nAhora agrego un diario...");
        biblioteca.agregar_diario("Clarin", "Ricardo Kirschbaum","11 7394-2918", "Jazmin", 3, LocalDate.of(2023,10,1));

        System.out.println("\nMuestro la cantidad de ejemplares prestados por cada publicacion...");
        biblioteca.mostrar_cant_ejemplares();
    }

    public static void ejemplo_9(){
        System.out.println("\nEjemplo del ejercicio 9:");
        System.out.println("\nCreo el sistema de formas...");
        Formas sistemaDeFormas = new Formas();

        System.out.println("\nAgrego figuras 2d...");
        sistemaDeFormas.nuevoCirculo(1.0d);
        sistemaDeFormas.nuevoCuadrado(2.0d,3.0d);
        sistemaDeFormas.nuevoRectangulo(2.0d,4.0d);
        sistemaDeFormas.nuevoTriangulo(4.0d,8.0d);
        System.out.println("\nMuestro el area de todas las figuras 2d... ");
        sistemaDeFormas.mostrarFiguras2D();

        System.out.println("\nAgrego figuras 3d...");
        sistemaDeFormas.nuevoCubo(2.0d);
        sistemaDeFormas.nuevaEsfera(3.0d);
        sistemaDeFormas.nuevoParalelepipedo(2.0d,3.0d,4.0d);
        sistemaDeFormas.nuevoTetraedro(3.0d);
        System.out.println("\nMuestro el area y volumen de todas las figuras 3d...");
        sistemaDeFormas.mostrarFiguras3D();
    }

    public static void ejemplo_10(){
        System.out.println("\nEjemplo del ejercicio 10: ");
        System.out.println("Creo la app...");
        App appOrganizacion = new App();
        System.out.println("\nAgrego un empleado de cada tipo...");
        appOrganizacion.agregarEmpleadoPasante("Pepe Morales", "11 4873-9426", "20-33654824-4", LocalDate.of(2023,6,9));
        appOrganizacion.agregarEmpleadoAsalariado("Jazmin Gutierrez", "11 9238-7217","21-45452353-3",LocalDate.of(2023,10,1),80000.0d);
        appOrganizacion.agregarEmpleadoXComision("Lucas Pereira", "11 9283-5729", "19-38432416-2",LocalDate.of(2023,10,7),20.0d,0.3, 7000.0d);
        appOrganizacion.agregarEmpleadoXHora("Martina Sosa", "11 8922-5373", "20-30523532",LocalDate.of(2023,10,8),42, 5000.0d,Month.OCTOBER);
        appOrganizacion.agregarEmpleadoXComisionConSalario("Matias Rodriguez", "11 5436-6539","20-33648140-4",LocalDate.of(2023,10,9),20.0d,0.3,10000.0d,7000.0d);

        System.out.println("\nAhora muestro el sueldo de cada uno...");
        appOrganizacion.mostrarSueldoEmpleados();
    }

    public static void ejemplo_11(){
        System.out.println("\nEjemplo del ejercicio 11: ");
        System.out.println("Creo la agencia de autos...");
        SistemaDeAgencia agenciaAutomoviles = new SistemaDeAgencia();
        System.out.println("\nRegistro un vehiculo de cada tipo para probar...");
        agenciaAutomoviles.registrarCamion("UKE 536");
        agenciaAutomoviles.registrarAutoVIP("RTF 725", 4);
        agenciaAutomoviles.registrarAutoDePasajeros("PRG 150", 2);
        agenciaAutomoviles.registrarCamionetasFlete("IRL 936", 1000.0d);
        agenciaAutomoviles.registrarCombi("KLA 482");

        System.out.println("\nPresto algunos vehiculos a clientes...");
        agenciaAutomoviles.prestarVehiculo("Pepe Martinez","35.467.174","11 4592-0209", "RTF 725", 30);
        agenciaAutomoviles.prestarVehiculo("Jazmin Rodriguez", "39.432.794","11 6955-6734", "KLA 482", 50);
        agenciaAutomoviles.prestarVehiculo("Raul Fernandez", "34.659.175", "11 5327-1546", "UKE 536",55);
        agenciaAutomoviles.prestarVehiculo("Pepe Martinez", "35.467.174","11 4592-0209", "PRG 150", 20);
        agenciaAutomoviles.prestarVehiculo("Jazmin Rodriguez", "39.432.794","11 6955-6734", "IRL 936", 30);

        System.out.println("\nMuestro el monto total del cliente Pepe: ");
        agenciaAutomoviles.mostrarMontoTotalCliente("35.467.174");
        System.out.println("\nMuestro el total del cliente Jazmin: ");
        agenciaAutomoviles.mostrarMontoTotalCliente("39.432.794");
        System.out.println("\nMuestro el total del cliente Raul: ");
        agenciaAutomoviles.mostrarMontoTotalCliente("34.659.175");
        System.out.println("\nMuestro el total de todos los alquileres...");
        agenciaAutomoviles.mostrarMontoTodosLosAlquileres();
    }

    public static void ejemplo_12(){
        System.out.println("\nEjemplos del ejercicio 12:");
        System.out.println("AVISO: primero se probara que funcionan las cuentas normales y las credito " +
                "\nque en teoria deberian de funcionar igual a como lo hacen en el ejercicio 5" +
                "\nLuego se probaran las operaciones de una caja ahorro");
        System.out.println("Creo la billetera virtual...");
        BilleteraVirtualV3 billeteraEjemploV3 = new BilleteraVirtualV3();
        System.out.println("Creo una cuenta con cuenta credito y normal...");
        billeteraEjemploV3.crear_cuenta("Jazmin", "12345678", 3000.0d, 1000.0d, 1000.0d, true ,false,null);
        System.out.println("\nMuestro el estado de la cuenta del usuario Jazmin...");
        billeteraEjemploV3.mostrarEstadoCuenta("Jazmin", "12345678");
        System.out.println("\nLa usuario Jazmin ahora va a comprar con su cuenta credito ($1000)...");
        if (billeteraEjemploV3.comprarUsandoCuentaCredito("Jazmin", "12345678", 1000.0d)){
            System.out.println("Compra Exitosa!!!");
        }
        System.out.println("\nMuestro el estado de Jazmin...");
        billeteraEjemploV3.mostrarEstadoCuenta("Jazmin", "12345678");
        System.out.println("\nAhora realizo un pago de la compra realizada(paga $900)...");
        if (billeteraEjemploV3.pagarUsandoCuentaCredito("Jazmin","12345678", 900.0d, 0)){
            System.out.println("Pago realizado!!");
        }
        System.out.println("\nMuestro el estado para ver como quedo el saldo deudor...");
        billeteraEjemploV3.mostrarEstadoCuenta("Jazmin", "12345678");

        System.out.println("\nHago que invierta una parte de su saldo ($1500)...");
        if (billeteraEjemploV3.invertirMontoCuenta("Jazmin", "12345678", 1500)){
            System.out.println("Se invirtio correctamente!!!");
        }
        System.out.println("\nMuestro su estado...");
        billeteraEjemploV3.mostrarEstadoCuenta("Jazmin", "12345678");
        System.out.println("\nIntento realizar un gasto mayor al sueldo ($3000)...");
        billeteraEjemploV3.realizarGastoCuenta("Jazmin", "12345678",2500.0d);
        System.out.println("\nComo tiene una inversion se puede reducir el giro descubierto por lo que hago que gaste igual...");
        if (billeteraEjemploV3.realizarGastoYGirarCuenta("Jazmin", "12345678",2500.0d)){
            System.out.println("Se realizo el gasto correctamente!!!");
        }
        System.out.println("\nMuestro su estado...");
        billeteraEjemploV3.mostrarEstadoCuenta("Jazmin", "12345678");
        System.out.println("\nDeposito $1500 para tener saldo en la cuenta...");
        billeteraEjemploV3.depositarMontoCuenta("Jazmin", "12345678",1500.0d);
        System.out.println("\nMuestro el estado...");
        billeteraEjemploV3.mostrarEstadoCuenta("Jazmin", "12345678");
        System.out.println("\nInvierto $500 de su saldo...");
        if (billeteraEjemploV3.invertirMontoCuenta("Jazmin", "12345678",500.0d)){
            System.out.println("Se invertio correctamente!!!");
        }
        System.out.println("\nMuestro su estado...");
        billeteraEjemploV3.mostrarEstadoCuenta("Jazmin", "12345678");
        System.out.println("\nAhora cancelo la inversion");
        System.out.println("AVISO: como la inversion no fue hace 30 dias nisiquiera le va a dar un interes del 30% pero esa opcion esta implementada en el metodo");
        if (billeteraEjemploV3.cancelarInversionCuenta("Jazmin", "12345678")){
            System.out.println("Se cancelo correctamente la inversion!!!");
        }
        System.out.println("\nMuestro el estado...");
        billeteraEjemploV3.mostrarEstadoCuenta("Jazmin", "12345678");

        System.out.println("______________________NUEVO____________________________");
        System.out.println("\nAhora creo un usuario que tenga caja de ahorro...");
        billeteraEjemploV3.crear_cuenta("Pepe", "ContraseniaSegura", 1500.0d, 500.0d, null,false,true,3000.0d);
        System.out.println("\nMuestro su estado...");
        billeteraEjemploV3.mostrarEstadoCuenta("Pepe", "ContraseniaSegura");
        System.out.println("\nPrimero invierto $1500 con la caja de ahorro de Pepe");
        if (billeteraEjemploV3.invertirMontoCajaAhorro("Pepe", "ContraseniaSegura",1500.0d)){
            System.out.println("Se invertio correctamente!!!");
        }
        System.out.println("\nMuestro su nuevo estado...");
        billeteraEjemploV3.mostrarEstadoCuenta("Pepe", "ContraseniaSegura");
        System.out.println("\nDeposito $500 en la caja de ahorro de Pepe");
        billeteraEjemploV3.depositarMontoCajaAhorro("Pepe", "ContraseniaSegura",500.0d);
        System.out.println("\nAhora trato de gastar lo que esta en la caja de ahorro con $3000...");
        billeteraEjemploV3.realizarGastoCajaAhorro("Pepe", "ContraseniaSegura",3000.0d);
        System.out.println("\nComo quiero realizar el gasto voy a cancelar la inversion y luego gastar el dinero...");
        if (billeteraEjemploV3.cancelarInversionCajaAhorro("Pepe", "ContraseniaSegura")){
            System.out.println("Se cancelo la inversion correctamente!");
        }
        System.out.println("\nMuestro el estado...");
        billeteraEjemploV3.mostrarEstadoCuenta("Pepe", "ContraseniaSegura");
        System.out.println("\nAhora por ultimo realizo el gasto de $3000 en la caja de ahorro...");
        if (billeteraEjemploV3.realizarGastoCajaAhorro("Pepe", "ContraseniaSegura",3000.0d)){
            System.out.println("Se realizo el gasto correctamente!!!");
        }
    }

    public static void ejemplo_13(){
        System.out.println("\nEjemplo del ejercicio 13");
        System.out.println("\nPrimero muestro el escenario planteado...");
        System.out.println("\nCreo un vuelo nuevo...");
        ArrayList<Persona> miembros = new ArrayList<>();
        Vuelo nuevoVuelo = new Vuelo(miembros);
        System.out.println("\nAhora genero al tripulante Pepe");
        Tripulante nuevo_tripulante = new Tripulante("Pepe","11 3465-7547", "MiCasa123", "Copiloto");
        nuevoVuelo.agregarMiembrosVuelo(nuevo_tripulante);
        System.out.println("\nComo un tripulante no puede ser un pasajero entonces creo un pasajero con los datos del tripulante...");
        Pasajero nuevo_pasajero = new Pasajero("Pepe","11 3465-7547", "MiCasa123", 2);
        nuevoVuelo.agregarMiembrosVuelo(nuevo_pasajero);
        Ticket nuevoTicketVuelo = new Ticket(nuevoVuelo, nuevo_pasajero);
        //el ticket no se usa pero lo implemento de igual forma
        System.out.println("\nAhora muestro los miembros del vuelo...");
        System.out.println("AVISO: para que sea mas claro el escenario planteado agregue dos variables booleanas que identifican cual persona es pasajero y cual tripulante");
        System.out.println(nuevoVuelo);
        System.out.println("Con esto se comprueba que si un miembro de la Tripulación desea subir a un vuelo como pasajero, entonces debe ser dado de alta 2 veces en el sistema");

        System.out.println("\n________________ESCENARIO_MODIFICADO_____________________");
        System.out.println("\nCreo el sistema de agencia Modificado...");
        SistemaDeGestionModificado agenciaDeVueloV2 = new SistemaDeGestionModificado();
        System.out.println("\nCreo un nuevo vuelo de avion...");
        agenciaDeVueloV2.crearVuelo(2);
        System.out.println("\nPruebo a agregar al mismo tripulante que el escenario anterior...");
        agenciaDeVueloV2.agregarTripulante(2,"Pepe","11 3465-7547", "MiCasa123", "Copiloto");
        System.out.println("\nAhora como el sistema fue modificado vamos a agregarle un nuevo rol al tripulante que va a ser el de pasajero...");
        agenciaDeVueloV2.agregarRol(false,true,"Pepe",5,null);
        System.out.println("\nAgrego un nuevo pasajero para probar que funciona el sistema...");
        agenciaDeVueloV2.agregarPasajero(2,"Jazmin", "11 5426-8542", "MiCasa954", 6);
        System.out.println("Ahora muestro los miembros del vuelo (en este caso deberia de aparecer solo Pepe con sus dos roles asignados y el otro pasajero)...");
        agenciaDeVueloV2.mostrar_Vuelos();
    }


}
