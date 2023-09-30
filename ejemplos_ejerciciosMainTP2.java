import ar.edu.unlu.poo.academia.Academia;
import ar.edu.unlu.poo.academia.CredencialAlumno;
import ar.edu.unlu.poo.academia.Nivel;
import ar.edu.unlu.poo.agencia.AgenciaTurismo;
import ar.edu.unlu.poo.agencia.Clasificacion;
import ar.edu.unlu.poo.billetera.ejercicio4.BilleteraVirtual;
import ar.edu.unlu.poo.billetera.ejercicio5.BilleteraVirtualV2;
import ar.edu.unlu.poo.club.ClubFutbol;
import ar.edu.unlu.poo.club.Subscripciones;

import java.time.LocalDate;
import java.time.Month;
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
                //ejemplo_6();
                break;
            case 7:
                //ejemplo_7();
                break;
            case 8:
                //ejemplo_8();
                break;
            case 9:
                //ejemplo_9();
                break;
            case 10:
                //ejemplo_10();
                break;
            case 11:
                //ejemplo_11();
                break;
            case 12:
                //ejemplo_12();
                break;
            case 13:
                //ejemplo_13();
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
        System.out.println("5-Ejercicio 5 - ???");
        System.out.println("6-Ejercicio 6 - Estacion de Servicio");
        System.out.println("7-Ejercicio 7 - ???");
        System.out.println("-Parte dos: Herencia y polimorfismo:");
        System.out.println("8-Ejercicio 8 - Biblioteca V2");
        System.out.println("9-Ejercicio 9 - Figuras Geometricas");
        System.out.println("10-Ejercicio 10 - App Empleados");
        System.out.println("11-Ejercicio 11 - Agencia de Vehiculos");
        System.out.println("12-Ejercicio 12 - ???");
        System.out.println("13-Ejercicio 13 - ???");
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
        nuevo_club.inscripcion("Pepito", "Planes", "45.225.211", 19, "11-1234-3421", "Micasa123", "soyPepito@gmail.com", Subscripciones.INTERMEDIA );
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
    /*private static void ejemplo_8(){
        System.out.println("\nEjemplo de Biblioteca: ");
        BibliotecaTP1 biblioteca = new BibliotecaTP1();

        System.out.println("\nagrego libros a la biblioteca... ");
        biblioteca.agregar_libro("La odisea", "Homero", 448, 10);
        biblioteca.agregar_libro("Frankenstein", "Mary Shelley", 304, 1);

        System.out.println("\nContenido de la biblioteca: " + biblioteca);

        System.out.println("\nPido prestado dos libros de la odisea: ");
        biblioteca.prestar_libro("La odisea", "Homero");
        biblioteca.prestar_libro("La odisea", "Homero");

        System.out.println("\nPido prestado un libro de frankestein: ");
        biblioteca.prestar_libro("Frankenstein", "Mary Shelley");

        System.out.println("\nCompruebo los prestamos realizados con el libro la odisea: " + biblioteca.prestamosRealizados("La odisea", "Homero"));

        System.out.println("\nComparo la cantidad de paginas del libro la odisea con el de frankestein: ");
        if (biblioteca.libro1_tieneMasPags("La odisea" , "Homero", "Frankenstein", "Mary Shelley")){
            System.out.println("La odisea tiene mas cantidad de paginas que Frankenstein");
        }else {
            System.out.println("Frankenstein tiene mas cantidad de paginas que frankenstein");
        }
        System.out.println("\nPido prestado un libro mas de la odisea y compruebo la cantidad total de prestamos que realizo la biblioteca: ");
        biblioteca.prestar_libro("La odisea", "Homero");
        System.out.println("\nLa cantidad de prestamos totales que realizo la biblioteca fue de " + biblioteca.total_prestamos());

        System.out.println("\nMuestro como quedo la descripcion de La odisea: ");
        biblioteca.mostrar_descripcion("La odisea", "Homero");

    } este es un ejemplo del ejercicio 6 del tp1*/


}
