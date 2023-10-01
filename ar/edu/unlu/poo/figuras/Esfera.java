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
        Double volumen = (4 * Math.PI * Math.pow(getRadio(),3))/3;
        //AVISO: puse el divido 3 del 4/3 al final porque sino no tomaba el cuenta el /3
        // y daba un resultado erroneo
        setVolumen(volumen);
    }


}
