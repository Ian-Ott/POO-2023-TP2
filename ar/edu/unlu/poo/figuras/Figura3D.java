package ar.edu.unlu.poo.figuras;

public abstract class Figura3D extends FiguraGeometrica {
    private Double volumen;

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public Double getVolumen() {
        return volumen;
    }

    public void calcularVolumen(){

    }
}
