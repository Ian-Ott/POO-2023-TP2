package ar.edu.unlu.poo.figuras;

public class Triangulo extends Figura2D{
    protected Double base;
    protected Double altura;

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getBase() {
        return base;
    }

    @Override
    public void calcularArea() {
        Double area = (getBase() * getAltura()) / 2;
        setArea(area);
    }
}
