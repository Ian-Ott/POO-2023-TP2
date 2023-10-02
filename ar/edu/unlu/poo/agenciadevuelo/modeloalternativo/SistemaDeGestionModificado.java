package ar.edu.unlu.poo.agenciadevuelo.modeloalternativo;


import java.util.ArrayList;

public class SistemaDeGestionModificado {
    ArrayList<VueloV2> vuelos = new ArrayList<>();
    //agregue el sistema de gestion para tener ocultamiento de informacion sobre las clases
    //esto no modifica mucho el planteo original
    ArrayList<TicketV2> ticketsVuelos = new ArrayList<>();

    public void crearVuelo(int nro_vuelo){
        VueloV2 nuevo_vuelo = new VueloV2(nro_vuelo);
        vuelos.add(nuevo_vuelo);
    }

    public void agregarPasajero(int nro_vuelo,String nombre,String numeroDeTelefono,String direccion, int nro_pasajero){
        for (int i = 0; i < vuelos.size();i++){
            if (vuelos.get(i).getNro_vuelo() == nro_vuelo){
                PasajeroV2 nuevo_pasajero = new PasajeroV2(nro_pasajero);
                PersonaV2 nueva_persona = new PersonaV2(nombre,numeroDeTelefono,direccion, nuevo_pasajero);
                TicketV2 nuevoTicket = new TicketV2(vuelos.get(i), nuevo_pasajero);
                ticketsVuelos.add(nuevoTicket);
                vuelos.get(i).agregarMiembrosVuelo(nueva_persona);
            }
        }
    }

    public void agregarTripulante(int nro_vuelo, String nombre, String direccion, String numeroTelefono,String cargo) {
        for (int i = 0; i < vuelos.size();i++){
            if (vuelos.get(i).getNro_vuelo() == nro_vuelo){
                TripulanteV2 nuevo_tripulante = new TripulanteV2(cargo);
                PersonaV2 nueva_persona = new PersonaV2(nombre,numeroTelefono,direccion, nuevo_tripulante);
                vuelos.get(i).agregarMiembrosVuelo(nueva_persona);
            }
        }
    }

    public void agregarRol(boolean agregarRolTripulante, boolean agregarRolPasajero, String nombre, int nro_pasajero, String cargo){
        PersonaV2 personaAux;
        for (int i = 0; i < vuelos.size();i++){
            for (int j = 0;j < vuelos.get(i).getMiembrosVuelo().size();j++){
                personaAux = vuelos.get(i).getMiembrosVuelo().get(j);
                if (personaAux.getNombre().equals(nombre)){
                    if (agregarRolTripulante){
                        TripulanteV2 nuevoTripulante = new TripulanteV2(cargo);
                        personaAux.agregarRolPersona(nuevoTripulante);
                    } else if (agregarRolPasajero) {
                        PasajeroV2 nuevoPasajero = new PasajeroV2(nro_pasajero);
                        personaAux.agregarRolPersona(nuevoPasajero);
                    }
                }
            }
        }
    }

    public void mostrar_Vuelos(){
        for (int i = 0; i < vuelos.size(); i++){
            System.out.println("__________________________________________________________________________________");
            System.out.println("\nVuelo " + vuelos.get(i).getNro_vuelo() + ":");
            System.out.println(vuelos.get(i));
        }
    }
}