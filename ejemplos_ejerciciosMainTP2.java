import ar.edu.unlu.poo.club.ClubFutbol;
import ar.edu.unlu.poo.club.Subscripciones;

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
                //ejemplo_2();
                break;
            case 3:
                //ejemplo_3();
                break;
            case 4:
                //ejemplo_4();
                break;
            case 5:
                //ejemplo_5();
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
        System.out.println("4-Ejercicio 4 - ???");
        System.out.println("5-Ejercicio 5 - ???");
        System.out.println("6-Ejercicio 6 - Estacion de Servicio");
        System.out.println("7-Ejercicio 7 - ???");
        System.out.println("-Parte dos: Herencia y polimorfismo:");
        System.out.println("8-Ejercicio 8 - ???");
        System.out.println("9-Ejercicio 9 - ???");
        System.out.println("10-Ejercicio 10 - ???");
        System.out.println("11-Ejercicio 11 - ???");
        System.out.println("12-Ejercicio 12 - ???");
        System.out.println("13-Ejercicio 13 - ???");
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

        System.out.println("\n muestro el reporte mensual de usuarios inscriptos... \n(en este caso deberia de mostrar todos porque se inscribieron hoy esos nuevos socios)");
        nuevo_club.reporte_mensual();

        System.out.println("\nMuestro las actividades disponibles segun la subscripcion...");
        nuevo_club.actividades_sub(Subscripciones.BASICA);
        nuevo_club.actividades_sub(Subscripciones.INTERMEDIA);
        nuevo_club.actividades_sub(Subscripciones.DESTACADA);

        System.out.println("\n Muestro un listado de socios clasificados segun su subscripcion...");
        nuevo_club.mostrarPorOrdenSub();
    }

}
