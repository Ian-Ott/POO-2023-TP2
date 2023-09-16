package ar.edu.unlu.poo.club;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class ClubFutbol {
    private ArrayList<Socios> credencial = new ArrayList<>();

    public void inscripcion(String nombre, String apellido, String DNI, int edad, String contacto, String direccion, String email, Subscripciones suscripcionElegida){
        Socios nuevo_socio = new Socios();
        nuevo_socio.setNombre(nombre);
        nuevo_socio.setApellido(apellido);
        nuevo_socio.setDNI(DNI);
        nuevo_socio.setEdad(edad);
        nuevo_socio.setContacto(contacto);
        nuevo_socio.setDireccion(direccion);
        nuevo_socio.setEmail(email);
        nuevo_socio.setSubscripcion(suscripcionElegida);
        nuevo_socio.setFecha_inscripcion(LocalDate.now());
        credencial.add(nuevo_socio);
    }

    public void reporte_mensual(Month mes){
        LocalDate mesPedido = LocalDate.of(2023,  mes, 1);
        if (credencial.isEmpty()){

        }else {
            System.out.println("Reporte Mensual: ");
            System.out.println("________________________________________________________________________________________");
            for (int i = 0; i < credencial.size(); i++){
        if (mesPedido.getMonth().equals(credencial.get(i).getFecha_inscripcion().getMonth())){
            //si el socio se inscribio en el mes actual se muestra por pantalla
            // en cambio si se inscribio meses atras no se muestra
            System.out.println("Socio " + (i + 1) + "- Nombre: " + credencial.get(i).getNombre() + " / Apellido: " + credencial.get(i).getApellido());
            System.out.println("Fecha de inscripcion: " + credencial.get(i).getFecha_inscripcion() + " / DNI: " + credencial.get(i).getDNI() + " / Edad: " + credencial.get(i).getEdad());
            System.out.println("Contacto: " + credencial.get(i).getContacto() + " / Direccion: " + credencial.get(i).getDireccion() + " / Email: " + credencial.get(i).getEmail());
            if (credencial.get(i).getSubscripcion().equals(Subscripciones.BASICA)){
                System.out.println("Subscripcion: Basica");
            } else if (credencial.get(i).getSubscripcion().equals(Subscripciones.INTERMEDIA)){
                System.out.println("Subscripcion: Intermedia");
            }else {
                System.out.println("Subscripcion: Destacada");
            }
            System.out.println("________________________________________________________________________________________");
        }
    }
    }
    }
    public void actividades_sub(Subscripciones suscripcionPedida){
        if (suscripcionPedida.equals(Subscripciones.BASICA)){
            System.out.println("Actividades disponibles con la subscripcion basica: ");
        } else if (suscripcionPedida.equals(Subscripciones.INTERMEDIA)) {
            System.out.println("Actividades disponibles con la subscripcion intermedia: ");
        }else {
            System.out.println("Actividades disponibles con la subscripcion Destacada: ");
        }
    }

    public void mostrarPorOrdenSub(){
        System.out.println("Socios con subscripcion Basica: ");
        for (int i = 0; i < credencial.size(); i++){
            if (credencial.get(i).getSubscripcion().equals(Subscripciones.BASICA)){
                System.out.println("Socio " + (i + 1) + "- Nombre: " + credencial.get(i).getNombre() + " / Apellido: " + credencial.get(i).getApellido());
                System.out.println("Fecha de inscripcion: " + credencial.get(i).getFecha_inscripcion() + " / DNI: " + credencial.get(i).getDNI() + " / Edad: " + credencial.get(i).getEdad());
                System.out.println("Contacto: " + credencial.get(i).getContacto() + " / Direccion: " + credencial.get(i).getDireccion() + " / Email: " + credencial.get(i).getEmail());
                if (credencial.get(i).getSubscripcion().equals(Subscripciones.BASICA)){
                    System.out.println("Subscripcion: Basica");
                } else if (credencial.get(i).getSubscripcion().equals(Subscripciones.INTERMEDIA)){
                    System.out.println("Subscripcion: Intermedia");
                }else {
                    System.out.println("Subscripcion: Destacada");
                }
                System.out.println("________________________________________________________________________________________");
            }
        }
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("Socios con subscripcion Intermedia: ");
        for (int i = 0; i < credencial.size(); i++){
            if (credencial.get(i).getSubscripcion().equals(Subscripciones.INTERMEDIA)){
                System.out.println("Socio " + (i + 1) + "- Nombre: " + credencial.get(i).getNombre() + " / Apellido: " + credencial.get(i).getApellido());
                System.out.println("Fecha de inscripcion: " + credencial.get(i).getFecha_inscripcion() + " / DNI: " + credencial.get(i).getDNI() + " / Edad: " + credencial.get(i).getEdad());
                System.out.println("Contacto: " + credencial.get(i).getContacto() + " / Direccion: " + credencial.get(i).getDireccion() + " / Email: " + credencial.get(i).getEmail());
                if (credencial.get(i).getSubscripcion().equals(Subscripciones.BASICA)){
                    System.out.println("Subscripcion: Basica");
                } else if (credencial.get(i).getSubscripcion().equals(Subscripciones.INTERMEDIA)){
                    System.out.println("Subscripcion: Intermedia");
                }else {
                    System.out.println("Subscripcion: Destacada");
                }
                System.out.println("________________________________________________________________________________________");
            }
        }
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("Socios con subscripcion Destacada: ");
        for (int i = 0; i < credencial.size(); i++){
            if (credencial.get(i).getSubscripcion().equals(Subscripciones.DESTACADA)){
                System.out.println("Socio " + (i + 1) + "- Nombre: " + credencial.get(i).getNombre() + " / Apellido: " + credencial.get(i).getApellido());
                System.out.println("Fecha de inscripcion: " + credencial.get(i).getFecha_inscripcion() + " / DNI: " + credencial.get(i).getDNI() + " / Edad: " + credencial.get(i).getEdad());
                System.out.println("Contacto: " + credencial.get(i).getContacto() + " / Direccion: " + credencial.get(i).getDireccion() + " / Email: " + credencial.get(i).getEmail());
                if (credencial.get(i).getSubscripcion().equals(Subscripciones.BASICA)){
                    System.out.println("Subscripcion: Basica");
                } else if (credencial.get(i).getSubscripcion().equals(Subscripciones.INTERMEDIA)){
                    System.out.println("Subscripcion: Intermedia");
                }else {
                    System.out.println("Subscripcion: Destacada");
                }
                System.out.println("________________________________________________________________________________________");
            }
        }
    }
}
