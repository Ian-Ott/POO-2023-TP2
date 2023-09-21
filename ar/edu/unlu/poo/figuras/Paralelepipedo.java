package ar.edu.unlu.poo.figuras;

public class Paralelepipedo extends Figura3D{
    private Double arista1;
    private Double arista2;
    private Double arista3;

    public void setArista1(Double arista1) {
        this.arista1 = arista1;
    }

    public Double getArista1() {
        return arista1;
    }

    public void setArista2(Double arista2) {
        this.arista2 = arista2;
    }

    public Double getArista2() {
        return arista2;
    }

    public void setArista3(Double arista3) {
        this.arista3 = arista3;
    }

    public Double getArista3() {
        return arista3;
    }

    @Override
    public void calcularArea() {
        //super.calcularArea();
        Double area = 2 * (getArista1() * getArista2() + getArista1() * getArista3() + getArista2() * getArista3());
        setArea(area);
    }

    @Override
    public void calcularVolumen() {
        //super.calcularVolumen();
        Double volumen = getArista1() * getArista2() * getArista3();
        setVolumen(volumen);
    }


}
