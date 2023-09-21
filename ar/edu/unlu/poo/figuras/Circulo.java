package ar.edu.unlu.poo.figuras;

public class Circulo extends Figura2D{
    protected Double radio;

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    public Double getRadio() {
        return radio;
    }

    @Override
    public void calcularArea() {
        //super.calcularArea();
        Double area = Math.PI * Math.pow(getRadio(),2);
        setArea(area);
    }



}
