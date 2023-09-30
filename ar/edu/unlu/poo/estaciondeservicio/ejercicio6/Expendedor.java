package ar.edu.unlu.poo.estaciondeservicio.ejercicio6;

public class Expendedor {
    private int codigo;
    private Combustible tipoCombustible = new Combustible();

    private double totalVentas = 0.0;

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setTipoCombustible(Combustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public Combustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }

    public double getTotalVentas() {
        return totalVentas;
    }
}
