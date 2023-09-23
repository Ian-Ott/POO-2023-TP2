package ar.edu.unlu.poo.libro;

public class Ejemplar {

    private int nro;
    private boolean prestado;

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public boolean getPrestado(){
        return prestado;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public int getNro() {
        return nro;
    }
}
