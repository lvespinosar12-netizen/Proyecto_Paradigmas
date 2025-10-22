package PanelDeControl.servicios;

import Space_Suit_Manager.modelo.Traje_Espacial;

public interface OperacionArchivo {

    public String serializar(Traje_Espacial[] trajes, String ruta, String nombreArchivo);

    public Traje_Espacial[] deserializar(String ruta, String nombreArchivo);
    
    Traje_Espacial leerArchivo();
}
