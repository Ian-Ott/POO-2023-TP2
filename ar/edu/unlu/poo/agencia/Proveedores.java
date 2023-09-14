package ar.edu.unlu.poo.agencia;

public class Proveedores {
    private String nombre_proveedor;
    private String tipoCompania;
    private Clasificacion ClasificacionProveedor;

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setTipoCompania(String tipoCompania) {
        this.tipoCompania = tipoCompania;
    }

    public String getTipoCompania() {
        return tipoCompania;
    }

    public void setClasificacionProveedor(Clasificacion clasificacionProveedor) {
        ClasificacionProveedor = clasificacionProveedor;
    }

    public Clasificacion getClasificacionProveedor() {
        return ClasificacionProveedor;
    }
}

