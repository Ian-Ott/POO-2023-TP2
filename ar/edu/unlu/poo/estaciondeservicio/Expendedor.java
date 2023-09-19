package ar.edu.unlu.poo.estaciondeservicio;

public class Expendedor {
    private int codigo;
    private Combustible tipoCombustible = new Combustible();

    private Float totalVentas = 0F;

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

    public void setTotalVentas(Float totalVentas) {
        this.totalVentas = totalVentas;
    }

    public Float getTotalVentas() {
        return totalVentas;
    }
}
