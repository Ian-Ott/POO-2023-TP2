package ar.edu.unlu.poo.figuras;

public class Rectangulo extends Figura2D{
    protected Double base;
    protected Double altura;

    //calcular area del rectangulo
    public void setBase(Double base) {
        this.base = base;
    }

    public Double getBase() {
        return base;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getAltura() {
        return altura;
    }

    @Override
    public void calcularArea() {
        //super.calcularArea();
        Double area = getBase() * getAltura();
        setArea(area);
    }

}
