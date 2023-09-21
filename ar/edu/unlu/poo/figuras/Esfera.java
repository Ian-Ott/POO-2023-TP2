package ar.edu.unlu.poo.figuras;

public class Esfera extends Figura3D{
    private Double radio;

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    public Double getRadio() {
        return radio;
    }

    @Override
    public void calcularArea() {
        //super.calcularArea();
        Double area = 4 * Math.PI * Math.pow(getRadio(), 2);
        setArea(area);
    }

    @Override
    public void calcularVolumen() {
        //super.calcularVolumen();
        Double volumen = (4/3) * Math.PI * Math.pow(getRadio(),3);
        setVolumen(volumen);
    }


}
