package ar.edu.unlu.poo.figuras;

public class Cubo extends Figura3D{
    private Double arista;

    public void setArista(Double arista) {
        this.arista = arista;
    }

    public Double getArista() {
        return arista;
    }

    @Override
    public void calcularArea() {
        //super.calcularArea();
        Double area = 6 * Math.pow(getArista(),2);
        setArea(area);
    }

    @Override
    public void calcularVolumen() {
        //super.calcularVolumen();
        Double volumen = Math.pow(getArista(),3);
        setVolumen(volumen);
    }


}
