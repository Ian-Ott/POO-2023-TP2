package ar.edu.unlu.poo.agenciadevuelo.modeloalternativo;

import ar.edu.unlu.poo.agenciadevuelo.modelooriginal.Persona;

import java.util.ArrayList;

public class VueloV2 {
    private int nro_vuelo;
    //agregue el nro de vuelo para identificar el vuelo al que le quiero agregar personas
    private ArrayList<PersonaV2> miembrosVuelo;
    public VueloV2(int nro_vuelo){
        this.nro_vuelo = nro_vuelo;
        this.miembrosVuelo = new ArrayList<>();
    }

    public void agregarMiembrosVuelo(PersonaV2 miembroVuelo) {
        this.miembrosVuelo.add(miembroVuelo);
    }

    public int getNro_vuelo() {
        return nro_vuelo;
    }

    public ArrayList<PersonaV2> getMiembrosVuelo() {
        return miembrosVuelo;
    }
    public String toString(){
        PersonaV2 personaAux;
        String acumulador = "";
        int j = 1;
        if (miembrosVuelo.isEmpty()){
            return "<No hay miembros del vuelo Agregados>";
        }
        for (int i = 0; i < miembrosVuelo.size(); i++){
            personaAux = miembrosVuelo.get(i);
            acumulador += "\n"+ j +"-Nombre: " + personaAux.nombre + " | Telefono: " + personaAux.numeroDeTelefono;
            for (int k = 0; k < personaAux.getRolesPersona().size(); k++){
                acumulador += personaAux.getRolesPersona().get(k);
            }
            j++;
        }
        return acumulador;
    }
}
