package ar.edu.unlu.poo.figuras;

public class Cuadrado extends Figura2D{
    private Double lado1;
    private Double lado2;

    public void setLado1(Double lado1) {
        this.lado1 = lado1;
    }

    public Double getLado1() {
        return lado1;
    }

    public void setLado2(Double lado2) {
        this.lado2 = lado2;
    }

    public Double getLado2() {
        return lado2;
    }

    @Override
    public void calcularArea() {
        //super.calcularArea();
        Double area = getLado1() * getLado2();
        setArea(area);
    }


}
