package Space_Suit_Manager.modelo;

import java.io.Serializable;

public class Traje_Espacial implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id_traje;
    private String talla;
    private double pesoSoportado;
    private String fechaInspeccion;

    public Traje_Espacial(String id_traje, String talla, double pesoSoportado, String fechaInspeccion) {
        this.id_traje = id_traje;
        this.talla = talla;
        this.pesoSoportado = pesoSoportado;
        this.fechaInspeccion = fechaInspeccion;
    }

    // getters y setters (nombres coincidentes con el resto del proyecto)
    public String getId_traje() { return id_traje; }
    public void setId_traje(String id_traje) { this.id_traje = id_traje; }

    public String getTalla() { return talla; }
    public void setTalla(String talla) { this.talla = talla; }

    public double getPesoSoportado() { return pesoSoportado; }
    public void setPesoSoportado(double pesoSoportado) { this.pesoSoportado = pesoSoportado; }

    public String getFechaInspeccion() { return fechaInspeccion; }
    public void setFechaInspeccion(String fechaInspeccion) { this.fechaInspeccion = fechaInspeccion; }

    @Override
    public String toString() {
        return "Traje_Espacial { id=" + id_traje +
               ", talla=" + talla +
               ", pesoSoportado=" + pesoSoportado +
               ", fechaInspeccion=" + fechaInspeccion + " }";
    }
}
		