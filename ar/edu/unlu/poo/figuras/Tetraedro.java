package ar.edu.unlu.poo.figuras;

public class Tetraedro extends Figura3D{
    //poner su propio calcular area y volumen
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
        Double area = Math.pow(getArista(),2) * Math.sqrt(3);
        setArea(area);
    }

    @Override
    public void calcularVolumen() {
        //super.calcularVolumen();
        Double volumen = Math.pow(getArista(),3) * (Math.sqrt((double) 2 /12));
        setVolumen(volumen);
    }


}
