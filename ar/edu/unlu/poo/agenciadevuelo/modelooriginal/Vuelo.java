package ar.edu.unlu.poo.agenciadevuelo.modelooriginal;


import java.util.ArrayList;

public class Vuelo {

    private ArrayList<Persona> miembrosVuelo;
    public Vuelo(ArrayList<Persona> miembros){
        this.miembrosVuelo = miembros;
    }

    public void agregarMiembrosVuelo(Persona miembroVuelo) {
        this.miembrosVuelo.add(miembroVuelo);
    }

    public ArrayList<Persona> getMiembrosVuelo() {
        return miembrosVuelo;
    }
    public String toString(){
    Persona personaAux;
    String acumulador = "";
    int j = 1;
    if (miembrosVuelo.isEmpty()){
        return "<No hay miembros del vuelo Agregados>";
    }
    for (int i = 0; i < miembrosVuelo.size(); i++){
        personaAux = miembrosVuelo.get(i);
        acumulador += "\n"+ j +"-Nombre: " + personaAux.nombre + " | Telefono: " + personaAux.numeroDeTelefono + " | es pasajero: " + personaAux.es_pasajero + " | es tripulante: " + personaAux.es_tripulante;
        j++;
    }
        return acumulador;
    }
}
